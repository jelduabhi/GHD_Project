package org.govstack.utils;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class CommonMethods extends WebDriverManager {

    public static Set<String> openWindows;
    WebDriverWait driverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    Actions actions = new Actions(getDriver());

    public void implicitWait(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public static String captureScreen() {
        String path;
        File targetPath;
        try {
            File source = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            path = ExtentReporter.reportPath + "/" + source.getName();
            targetPath = new File(path);
            FileUtils.copyFile(source, targetPath);
            return source.getName();
        } catch (Exception e) {
            return null;
        }
    }

    public static void highlightElement(WebElement ele) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", ele);
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to highlight element");
            Assert.fail(e.getMessage());
        }
    }

    public boolean isElementClickable(WebElement ele){
        try{
            driverWait.until(ExpectedConditions.elementToBeClickable(ele));
            ExtentReporter.log(LogStatus.PASS,ele.getAttribute("href")+" Is clickable");
            return  true;
        }catch (Exception e){
            ExtentReporter.log(LogStatus.PASS,ele.getAttribute("href")+" is not clickable");
            return false;
        }
    }

    public void clickElement(WebElement ele) {
        waitForElementVisibility(ele,30);
        try {
            if(isElementClickable(ele)) {
                highlightElement(ele);
                ele.click();
                ExtentReporter.log(LogStatus.PASS, ele + " clicked");
            }
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, ele + " Unable to click element " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, ele + " Unable to click element " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void javaScriptClickElement(WebElement ele) {
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(ele));
            highlightElement(ele);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", ele);
            ExtentReporter.log(LogStatus.PASS, ele + " clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, ele + " Unable to click element " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, ele + " Unable to click element " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
public void uploadDocument(String file){
        try {
            Robot robot = new Robot();
            String path = System.getProperty("user.dir") + file;
            setClipboardData(path);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to upload document");
        }
}
    public void sendTextToElement(WebElement ele, String text) {
        try {
            if (text != null) {
                driverWait.until(ExpectedConditions.visibilityOf(ele));
                highlightElement(ele);
                ele.clear();
                ele.sendKeys(text);
                ExtentReporter.log(LogStatus.PASS, ele + " " + text + " entered successfully");
            }
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, ele + " Unable to enter a text to element " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, ele + " Unable to enter a text to element " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        return dateOnly.format(cal.getTime()).split("/")[1];
    }

    public void selectDateFrom_Calender(List<WebElement>dates,String value){
        for(WebElement ele:dates){
            if(ele.getText().equals(value)){
                clickElement(ele);
            }
        }
    }

    public String getFutureDateMonthYear() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return futureDate.format(formatter);
    }


    public String getCurrentHours() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String[] time = timeStamp.split("_");
        return time[1];
    }

    public String getCurrentMinitus() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HH_mm_ss").format(Calendar.getInstance().getTime());
        String[] time = timeStamp.split("_");
        return time[2];
    }


    public String generateRandomString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public void selectOptionFromList(List<WebElement> element, String value) {
        try {
            for (WebElement ele : element) {
                if (ele.getText().equals(value)) {
                    clickElement(ele);
                    ExtentReporter.log(LogStatus.PASS, value + " Selected");
                    break;
                }
            }
            waitForElement(2);
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to select " + value + " " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to select " + value + " " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void selectDateFromCalender(List<WebElement> element, String value) {
        try {
            for (WebElement ele : element) {
                if (ele.getText().equals(value) && TestData.getData("Post Date").equalsIgnoreCase("PastDate")) {
                    clickElement(ele);
                    ExtentReporter.log(LogStatus.PASS, value + " Date Selected");
                    break;
                } else if (ele.getText().equals(value) && !ele.getAttribute("class").contains("prevMonthDay")) {
                    clickElement(ele);
                    ExtentReporter.log(LogStatus.PASS, value + " Date Selected");
                    break;
                }
            }
            waitForElement(2);
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to select Date " + value + " " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to select Date " + value + " " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void selectValueFromList(List<WebElement> element, Integer value) {
        try {
            clickElement(element.get(value));
            ExtentReporter.log(LogStatus.PASS, value + " Selected from dropdown");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to select value from list " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void selectValueFromDropdown(WebElement element, String value) {
        try {
            if(value != null){
            highlightElement(element);
            Select select = new Select(element);
            select.selectByVisibleText(value);
            ExtentReporter.log(LogStatus.PASS, value + " Selected from dropdown");
            }
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to select " + value + " " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to select " + value + " " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void waitForElement(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "");
            Assert.fail(e.getMessage());
        }
    }
    public void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }


    public void scrollToElement(WebElement ele) {
        try {
            waitForElement(1);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block:'center',inline: 'nearest'});", ele);
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to scroll to element");
            Assert.fail(e.getMessage());
        }
    }

    public void scrollAndClickElement(WebElement ele) {
        try {
            scrollToElement(ele);
            ele.click();
            ExtentReporter.log(LogStatus.PASS, ele + " clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to click " + ele + " " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to click " + ele + " " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void moveToElement(WebElement ele) {
        try {
            actions.moveToElement(ele).perform();
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to move to the element");
            Assert.fail(e.getMessage());
        }
    }

    public String getAttributeValue(WebElement ele, String attributeName) {
        try {
            return ele.getAttribute(attributeName);
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to locate Element " + ele);
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to locate Element " + ele);
            Assert.fail(e.getMessage());
            return null;
        }
    }

    public String getElementText(WebElement ele) {
        try {
            highlightElement(ele);
            return ele.getText();
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to get text from " + ele);
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to get text from " + ele);
            Assert.fail(e.getMessage());
            return null;
        }
    }

    public void openAndSwitchNewTab() {
        try {
            getDriver().switchTo().newWindow(WindowType.TAB);
            getDriver().manage().deleteAllCookies();
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to switch tab "+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    public Set<String> getWindowsCount() {
        return getDriver().getWindowHandles();
    }

    public void switchToWindow() {
        try {
            String currentWindow = getDriver().getWindowHandle();
            for (String childWindow : getWindowsCount()) {
                if (!currentWindow.equals(childWindow)) {
                    getDriver().switchTo().window(childWindow);
                }
            }
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to switch window "+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void closeAndSwapToParent() {
        Set<String> allWindows = new HashSet<>(getDriver().getWindowHandles());
        int windowsCount = allWindows.size();
        for (int currWin = windowsCount; currWin >= 2; --currWin) {
            getDriver().close();
            swapWindow(currWin - 2);
        }
    }

    public void swapWindow(int i) {
        openWindows = getWindowsCount();
        String switchWindow = (String) openWindows.toArray()[i];
        getDriver().switchTo().window(switchWindow);
    }


    public boolean isElementPresent(WebElement ele) {
        try {

            ele.isDisplayed();
            highlightElement(ele);
            ExtentReporter.log(LogStatus.PASS, ele + " is displayed");
            return true;
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, ele + " is not displayed");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, ele + " is not displayed");
            return false;
        }
    }

    public boolean isElementNotPresent(WebElement ele) {
        try {
            ele.isDisplayed();
            ExtentReporter.log(LogStatus.FAIL, ele + " is displayed");
            return false;
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.PASS, ele + " is not displayed");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, ele + " is not displayed");
            return true;
        }
    }

    public void switchToFrame(WebElement ele) {
        try {
            waitForElement(1);
            getDriver().switchTo().frame(ele);
            ExtentReporter.log(LogStatus.PASS, ele + " Switch to Frame");
            waitForElement(1);
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, ele + " Unable to switch to frame");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, ele + " Unable to switch to frame");
            Assert.fail(e.getMessage());
        }
    }

    public void switchToDefaultContent() {
        try {
            getDriver().switchTo().defaultContent();
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to switch to default "+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    //---------------updatepost-----------------start------------------//

    public void assertEqualsOfElementText(WebElement ele, String str) {
        Assert.assertEquals(getElementText(ele), str);
    }

    public void assertTrueForElementPresense(WebElement ele) {
        Assert.assertTrue(isElementPresent(ele));
    }

    public void assertTrueForElementNotPresent(WebElement ele) {
        Assert.assertTrue(isElementNotPresent(ele));
    }

    public void assertTrueOfElementTextEmpty(WebElement ele) {
        Assert.assertTrue(getElementText(ele).isEmpty());
    }

    public void assertTrueForElementTextContains(WebElement ele, String str) {
        Assert.assertTrue(getElementText(ele).contains(str));
    }

    public WebElement getShadowElementByCSS(WebElement rootEle, String shadowEleCSS) {
        try {
            SearchContext shadow = rootEle.getShadowRoot();
            return shadow.findElement(By.cssSelector(shadowEleCSS));
        }catch (Exception e){
            ExtentReporter.log(LogStatus.PASS,"Unable to get shadow element "+e.getMessage());
            return null;
        }
    }

    public List<WebElement> getShadowElementsByCSS(WebElement rootEle, String shadowEleCSS) {
        try {
            SearchContext shadow = rootEle.getShadowRoot();
            return shadow.findElements(By.cssSelector(shadowEleCSS));
        }catch (Exception e){
            ExtentReporter.log(LogStatus.PASS,"Unable to get shadow element "+e.getMessage());
            return null;
        }
    }

    public String getFutureDate(int daysToAdd) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysToAdd);
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateOnly.format(cal.getTime()).split("/")[1];
        if (date.startsWith("0")) {
            date = date.split("0")[1];
        }
        return date;
    }

    public String getPastDate(int daysToSubtract) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -daysToSubtract);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(cal.getTime()).split("/")[1];
        if (date.startsWith("0")) {
            date = date.split("0")[1];
        }
        return date;
    }

    public void waitForElementVisibility(WebElement ele, long time) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOf(ele));
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to find an element "+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void waitForElementInVisibility(WebElement ele, long time) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOf(ele));
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to find an element "+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void waitForElementClickable(WebElement ele, long time) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to find element "+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    public void clickElementFromList(List<WebElement> element, String value) {
        try {
            for (WebElement ele : element) {
                if (getElementText(ele).contains(value)) {
                    clickElement(ele);
                    ExtentReporter.log(LogStatus.PASS, value + " Selected");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to select " + value + " " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to select " + value + " " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void inputFile(String path, WebElement ele) {
        try {
            File file = new File(path);
            ele.sendKeys(file.getAbsolutePath());
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to send a file "+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void clearElementInput(WebElement ele) {
        try {
            highlightElement(ele);
            ele.clear();
            ExtentReporter.log(LogStatus.PASS, ele + " cleared");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, ele + " Unable to clear " + e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, ele + " Unable to clear " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    public String getAttributeOfElement(WebElement ele, String attribute) {
        try {
            return ele.getAttribute(attribute);
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to get element attribute "+e.getMessage());
            Assert.fail(e.getMessage());
            return null;
        }
    }

    public boolean getAttributeOfElementEquals(WebElement ele, String attribute, String value) {
        try {
            return getAttributeOfElement(ele, attribute).equals(value);
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to get element attribute"+e.getMessage());
            Assert.fail(e.getMessage());
            return false;
        }
    }

    public void assertEqualsString(String str1, String str2) {
        Assert.assertEquals(str1, str2);
    }

    public void rightClickOnTheElement(WebElement ele) {
        try {
            actions.contextClick(ele).build().perform();
            waitForElement(1);
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Unable to right click on the element "+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public boolean getElementTextContains(WebElement ele, String postName) {
        return ele.getText().contains(postName);
    }

    public boolean stringEquals(String str1, String str2) {
        return str1.equals(str2);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public long generateRandomNumber() {
        Random random = new Random();
        long range = 9586240000L; // 9 followed by 9 zeros
        return (long)(range * random.nextDouble());
    }

    public String generateSampleID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    public  boolean getTextOfElementEquals(WebElement ele, String str) {
        return getElementText(ele).equals(str);
    }

    public void selectValueFromList(String list){
        try {
            WebElement ele = getDriver().findElement(By.xpath("//li[contains(text(),'" + list + "')]"));
            scrollToElement(ele);
            clickElement(ele);
        }catch (Exception ele){
            Assert.fail(ele.getMessage());
        }
    }

    public void selectValueFromText(String list){
        try {
            WebElement ele = getDriver().findElement(By.xpath("//li[text()='" + list + "']"));
            scrollToElement(ele);
            clickElement(ele);
        }catch (Exception ele){
            Assert.fail(ele.getMessage());
        }
    }

    public void selectValueFromSpan(String list){
        try {
            WebElement ele = getDriver().findElement(By.xpath("//span[contains(text(),'" + list + "')]"));
            scrollToElement(ele);
            clickElement(ele);
        }catch (Exception ele){
            Assert.fail(ele.getMessage());
        }
    }
    public void selectValueFromSpanText(String list){
        try {
            WebElement ele = getDriver().findElement(By.xpath("//span[text()='" + list + "']"));
            scrollToElement(ele);
            clickElement(ele);
        }catch (Exception ele){
            Assert.fail(ele.getMessage());
        }
    }

    public synchronized void checkLink(String url) {
        try {
            if(url.contains("https")) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    ExtentReporter.log(LogStatus.FAIL, "Broken link: " + url + " (Response Code: " + responseCode + ")");
                } else {
                    ExtentReporter.log(LogStatus.PASS, "Valid link: " + url);
                }
            }
        } catch (IOException e) {
            ExtentReporter.log(LogStatus.FAIL,"Error checking link: " + url + " (" + e.getMessage() + ")");
        }
    }

    public void validateLogsInConsole(){
        ExtentReporter.log(LogStatus.INFO,"--------------- CMS_PRD_2:- Validate any js/CSS 500 Errors related to site builder bundle or $jquery\n" +
                "NAV - right click >> Inspect >> Consoles ---------------------------");
        LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains("ERROR") || entry.getMessage().contains("Failed") || entry.getMessage().contains("500") ) {
                ExtentReporter.log(LogStatus.FAIL,"Found an error in the console: " + entry.getMessage());
            }else{
                ExtentReporter.log(LogStatus.PASS,"Log: " + entry.getMessage());
            }
        }
    }

    public boolean isFileDownloaded(){
        String filePath=System.getProperty("user.home")+"\\Downloads\\";
        File file=new File(filePath);
        File[]folderContent=file.listFiles();
        boolean status=false;
        assert folderContent != null;
        for(File files:folderContent){
            if(files.toString().equals(filePath+"\\exportfile.xls")){
                ExtentReporter.log(LogStatus.PASS,"file Downloaded");
                waitForElement(2);
                files.delete();
                status=true;
                break;
            }
        }
        return status;
    }
}