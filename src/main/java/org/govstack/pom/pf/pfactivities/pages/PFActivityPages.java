package org.govstack.pom.pf.pfactivities.pages;

import com.relevantcodes.extentreports.LogStatus;
import com.google.common.collect.Ordering;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.pf.pfactivities.locators.PFActivityLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

import static org.govstack.webdriver.WebDriverManager.getDriver;

public class PFActivityPages {

    CommonMethods methods = new CommonMethods();
    PFActivityLocators pfActivityLocators=new PFActivityLocators();
    public static String activityName;

    public void clickActivity(){
       methods.clickElement( pfActivityLocators.activitiesLnk);
        methods.waitForElement(3);
    }

    public void clickAddButton(){
        methods.clickElement(pfActivityLocators.addBtn);
        methods.waitForElement(2);
    }
    public void pfCreateActivity() {
        try {
            activityName=TestData.getData("Activity Name") + "_" + methods.generateRandomString();
            methods.sendTextToElement(pfActivityLocators.pfActivityNameField, activityName);
            methods.clickElement(pfActivityLocators.activityStatusDropdown);
            methods.waitForElement(2);
            if (TestData.getData("Status").equalsIgnoreCase("Yes")) {
                methods.clickElement(pfActivityLocators.pfStatusYes);
            } else if (TestData.getData("Status").equalsIgnoreCase("No")) {
                methods.clickElement(pfActivityLocators.pfStatusNo);
            }
            methods.waitForElement(2);
            methods.clickElement(pfActivityLocators.pfActivitySaveBtn);
            methods.waitForElement(3);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Amenities under Park & facility created successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to create Amenities under Park & facility");
        }
    }

    public void validateActivityCreated() {
        try {
            boolean status = false;
            boolean count=false;
            for(int i=1;i<=pfActivityLocators.activityTable.size();i++){
                WebElement ele=getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr["+i+"]/td[2]"));
                WebElement countEle=getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr["+i+"]/td[5]"));
                if (ele.getText().equals(activityName)) {
                    methods.waitForElement(1);
                    CommonMethods.highlightElement(ele);
                    status = true;
                    if(countEle.getText().equals("0")) {
                        CommonMethods.highlightElement(countEle);
                        count=true;
                    }
                    break;
                }
            }
            if (status) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, activityName+" Activity is created");
                if(count){
                    ExtentReporter.log(LogStatus.PASS, activityName+" Count is 0");
                }else{
                    ExtentReporter.log(LogStatus.FAIL, activityName+" Count is not 0");
                    Assert.fail(activityName+" Count is not 0");
                }
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, activityName+" Activity is not created");
                Assert.fail(activityName+" Activity is not created");
            }
        }catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, activityName+" Activity is not created");
            Assert.fail(activityName+" Activity is not created");
        }

    }

    public void searchActivity(){
        methods.sendTextToElement(pfActivityLocators.searchTxt,activityName);
        methods.waitForElement(2);
    }

    public void editActivity() {
        try {
            for(int i=2;i<pfActivityLocators.activityTable.size();i++){
                WebElement ele=getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr["+i+"]/td[2]"));
                WebElement editBtn=getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr["+i+"]/td[6]/div/button[1]"));
                if (ele.getText().contains("Automation Activity")) {
                    CommonMethods.highlightElement(ele);
                    methods.clickElement(editBtn);
                    methods.waitForElement(2);
                    break;
                }
            }
        }catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    public void deleteActivity() {
        try {
            for(int i=2;i<pfActivityLocators.activityTable.size();i++){
                WebElement ele=getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr["+i+"]/td[2]"));
                WebElement delete=getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr["+i+"]/td[6]/div/button[2]"));
                if (methods.getElementText(ele).contains(activityName)) {
                    methods.clickElement(delete);
                    methods.waitForElement(2);
                    methods.clickElement(pfActivityLocators.deleteConfirmBtn);
                    break;
                }
            }
        }catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    public void validateActivityDeleted() {
        try {
            boolean status = false;
            for(int i=2;i<pfActivityLocators.activityTable.size();i++){
                WebElement ele=getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr["+i+"]/td[2]"));
                if (ele.getText().equals(activityName)) {
                    methods.waitForElement(1);
                    CommonMethods.highlightElement(ele);
                    status = true;
                    break;
                }
            }
            if (status) {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, activityName+" Activity is not deleted");
                Assert.fail(activityName+" Activity is not deleted");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, activityName+" Activity is deleted");
            }
        }catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, activityName+" Activity is not deleted");
            Assert.fail(activityName+" Activity is not deleted");
        }

    }
    public void validateSortWithFacilityTypeLocationTypeStatus() {
        List<String> activities=new LinkedList<>();
        String[] titleLables = TestData.getData("Title").split(",");
        int count = 0;
        methods.clickElement(pfActivityLocators.activityStatusDropdown);
        methods.waitForElement(2);
        methods.selectValueFromList("50");
        methods.waitForElement(2);
        for (WebElement ele : pfActivityLocators.activityTableTitleLbl) {
            if (ele.getText().equals("id") ) {
            } else if (ele.getText().equals(titleLables[count])) {
                CommonMethods.highlightElement(ele);
                count++;
            }
        }
        for (int i = 1; i <= pfActivityLocators.activityTable.size(); i++) {
            WebElement ele = getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr[" + i + "]/td[2]"));
            if(!ele.getText().contains("Automation")) {
                activities.add(ele.getText());
            }
            CommonMethods.highlightElement(ele);
        }
        if(Ordering.natural().isOrdered(activities)){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,activities+" Activity table is automatically sorted by “Name” column");
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,activities+" Activity table is not automatically sorted by “Name” column");
            //Assert.fail();
        }
    }


    public void validateTitleAndSortWithName() {
        List<String> activities=new LinkedList<>();
        String[] titleLables = TestData.getData("Title").split(",");
        int count = 0;
        for (WebElement ele : pfActivityLocators.activityTableTitleLbl) {
            if (ele.getText().equals("id") ) {
            } else if (ele.getText().equals(titleLables[count])) {
                CommonMethods.highlightElement(ele);
                count++;
            }
        }
        methods.clickElement(pfActivityLocators.activityStatusDropdown);
        methods.waitForElement(2);
        methods.selectValueFromList("50");
        methods.waitForElement(2);
        for (int i = 1; i <= pfActivityLocators.activityTable.size(); i++) {
            WebElement ele = getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr[" + i + "]/td[2]"));
            if(!ele.getText().contains("Automation")) {
                activities.add(ele.getText());
            }
            CommonMethods.highlightElement(ele);
        }
       if(Ordering.natural().isOrdered(activities)){
           ExtentReporter.logWithScreenshot(LogStatus.PASS,activities+" Activity table is automatically sorted by “Name” column");
       }else{
           ExtentReporter.logWithScreenshot(LogStatus.FAIL,activities+" Activity table is not automatically sorted by “Name” column");
           //Assert.fail();
       }
    }

    public void validateActivateDeactivate(){
        try {
            if (pfActivityLocators.activeStatusBtn.getFirst().getAttribute("modelvalue").equals("false")) {
                methods.javaScriptClickElement(pfActivityLocators.activeOnBtn);
                methods.waitForElement(2);
                if (pfActivityLocators.activeStatusBtn.getFirst().getAttribute("modelvalue").equals("true")) {
                    ExtentReporter.log(LogStatus.PASS, "Activate is turned On");
                } else {
                    ExtentReporter.log(LogStatus.FAIL, "Activate is turned Off");
                    Assert.fail();
                }
            } if (pfActivityLocators.activeStatusBtn.getFirst().getAttribute("modelvalue").equals("true")) {
                methods.javaScriptClickElement(pfActivityLocators.activeOffBtn);
                methods.waitForElement(2);
                if (pfActivityLocators.activeStatusBtn.getFirst().getAttribute("modelvalue").equals("false")) {
                    ExtentReporter.log(LogStatus.PASS, "Activate is turned off");
                } else {
                    ExtentReporter.log(LogStatus.FAIL, "Activate is turned on");
                    Assert.fail();
                }
            }
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void validateActiveFilter(){
        methods.clickElement(pfActivityLocators.activeFilter);
        methods.waitForElement(1);
        methods.clickElement(pfActivityLocators.selectAll);
        methods.clickElement(pfActivityLocators.trueCheckBox);
        methods.clickElement(pfActivityLocators.filterButton);
        for(WebElement ele: pfActivityLocators.activeStatusBtn){
            if(ele.getAttribute("modelvalue").equals("true")){
                CommonMethods.highlightElement(ele);
                ExtentReporter.log(LogStatus.PASS,ele.getAttribute("modelvalue"));
            }else{
                ExtentReporter.log(LogStatus.FAIL,ele.getAttribute("modelvalue"));
                Assert.fail(ele.getAttribute("modelvalue"));
            }
        }
        ExtentReporter.logWithScreenshot(LogStatus.PASS,"");
        if(methods.isElementPresent(pfActivityLocators.falseCheckBox)) {
            methods.clickElement(pfActivityLocators.activeFilter);
            methods.waitForElement(1);
            methods.clickElement(pfActivityLocators.selectAllStop);
            methods.clickElement(pfActivityLocators.filterButton);
        }
    }

    public void validateSystemDefaultFilter(){
        methods.clickElement(pfActivityLocators.systemDefaultFilter);
        methods.waitForElement(1);
        methods.clickElement(pfActivityLocators.selectAll);
        methods.clickElement(pfActivityLocators.trueCheckBox);
        methods.clickElement(pfActivityLocators.filterButton);
        for(WebElement ele: pfActivityLocators.systemDefaultLock){
            if(methods.isElementPresent(ele)){
                ExtentReporter.log(LogStatus.PASS,ele.getAttribute("modelvalue"));
            }else{
                ExtentReporter.log(LogStatus.FAIL,ele+" is not present");
                Assert.fail();
            }
        }
        ExtentReporter.logWithScreenshot(LogStatus.PASS,"");
        if(methods.isElementPresent(pfActivityLocators.falseCheckBox)) {
            methods.clickElement(pfActivityLocators.activeFilter);
            methods.waitForElement(1);
            methods.clickElement(pfActivityLocators.selectAllStop);
            methods.clickElement(pfActivityLocators.filterButton);
        }
    }

    public void validateCountFilter(){
        List<Integer> count=new LinkedList<>();
        methods.clickElement(pfActivityLocators.countFilter);
        WebElement ele;
        for (int i = 1; i <= pfActivityLocators.activityTable.size(); i++) {
            if(TestData.getData("TestCaseNumber").contains("FT")){
                ele = getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr[" + i + "]/td[4]"));
            }else {
                ele = getDriver().findElement(By.xpath("//table[@class='e-table']/tbody/tr[" + i + "]/td[5]"));
            }
            count.add(Integer.parseInt(ele.getText()));
            CommonMethods.highlightElement(ele);
        }
        if(Ordering.natural().isOrdered(count)){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,count+" Activity table is sorted by count");
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,count+" Activity table is not sorted by count");
            Assert.fail();
        }
    }
}
