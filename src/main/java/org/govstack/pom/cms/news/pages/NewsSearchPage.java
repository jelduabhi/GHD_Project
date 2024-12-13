package org.govstack.pom.cms.news.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.cms.news.locators.NewsSearchLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Objects;

import static org.govstack.webdriver.WebDriverManager.getDriver;

public class NewsSearchPage {

    CommonMethods methods = new CommonMethods();
    NewsSearchLocators newsSearchLocators = new NewsSearchLocators();
    JavascriptExecutor js = ((JavascriptExecutor) getDriver());

    public void dismissAllAlerts() {
        if (newsSearchLocators.alertDimisss.isDisplayed()) {
            newsSearchLocators.alertDimisss.click();
        }
        ExtentReporter.log(LogStatus.INFO, "Dismiss All alerts Button Clicked");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Dismiss All alerts Button Clicked");
    }

    public void searchNewsButton() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Search Button from news section clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Search Button from news section clicked");
            methods.clickElement(newsSearchLocators.searchBtn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void newsInputFieldBox(String newsSearchText) {
        try {
            ExtentReporter.log(LogStatus.INFO, "Text entered in news input field");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Text entered in news input field");
            //newsSearchLocators.newsInputField.sendKeys(methods.generateRandomString());
            newsSearchLocators.newsInputField.sendKeys(newsSearchText);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void categorySelectionDropdown(String categoryData) {
        try {
            ExtentReporter.log(LogStatus.INFO, "Category selected from Search by category section");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Category selected from Search by category section");
            Select select = new Select(newsSearchLocators.categorySelectOption);
            select.selectByVisibleText(categoryData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void newsDisplayedAssertion() {
        try {
            ExtentReporter.log(LogStatus.INFO, "News article visible");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "News article visible");
            Assert.assertTrue(newsSearchLocators.articleTitle.isDisplayed());
            Assert.assertTrue(newsSearchLocators.articleDescription.isDisplayed());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void startDateSelectField() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Start date selection from news section");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Start date selection from news section");
            js.executeScript("arguments[0].value = arguments[1]", newsSearchLocators.startDate,methods.getFutureDateMonthYear());
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL,e.getMessage());
            Assert.fail();
        }
    }

    public void endDateSelectField() {
        try {
            ExtentReporter.log(LogStatus.INFO, "End date selection from news section");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "End date selection from news section");
            js.executeScript("arguments[0].value = arguments[1]", newsSearchLocators.endDate,methods.getFutureDateMonthYear());
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL,e.getMessage());
            Assert.fail();
        }
    }

    public void noArticleFoundValidAssertion() {
        ExtentReporter.log(LogStatus.INFO, "No Articles found text is visible");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "No Articles found text is visible");
        Assert.assertTrue(newsSearchLocators.noArticleFoundText.isDisplayed());
    }

    //RG_NW_2.14 verify default field available in news form in frontend

    public void newsFormDefaultFieldValidation() {
        ExtentReporter.log(LogStatus.INFO, "Default field visible in news section in frontend");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Default field visible in news section in frontend");
        Assert.assertTrue(newsSearchLocators.categorySelectOption.isDisplayed());
        Assert.assertTrue(newsSearchLocators.newsInputField.isDisplayed());
        Assert.assertTrue(newsSearchLocators.startDate.isDisplayed());
        Assert.assertTrue(newsSearchLocators.endDate.isDisplayed());
        Assert.assertTrue(newsSearchLocators.searchBtn.isDisplayed());
        Assert.assertTrue(newsSearchLocators.clearBtn.isDisplayed());
    }

    //RG_NW_2.19 verify on click clear button search criteria will be deleted

    public void clearButtonNews() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Clear Button Clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Clear Button Clicked");
            methods.clickElement(newsSearchLocators.clearBtn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void defaultNewsFieldValidation() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Default field visible in news section in frontend");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Default field visible in news section in frontend");
            String expectedText = newsSearchLocators.newsInputField.getAttribute("placeholder");
            String actualText = "Search The News...";
            Assert.assertEquals(actualText, expectedText);
            String categoryExpectedText = newsSearchLocators.categorySelectOption.getAttribute("aria-label");
            if (Objects.requireNonNull(ConfigurationManager.getPropertyValue("ENV")).equals("PENTEST")) {
                String categoryActualText = "Choose Category";
                Assert.assertEquals(categoryActualText, categoryExpectedText);
            } else {
                String categoryActualText = "Select a Category";
                Assert.assertEquals(categoryActualText, categoryExpectedText);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //RG_NW_2.22 verify subscribe button is visible on news section in frontend page

    public void subscribeButtonNewsFrontend() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Subscribe Button Clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Subscribe Button Clicked");
            methods.clickElement(newsSearchLocators.subscribeBtnNews);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ExtentReporter.log(LogStatus.FAIL, "Subscribe button Not clicked");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Subscribe button Not clicked");
            Assert.fail();
        }
    }

    public void subscribePageValidation() {
        try {
            for(WebElement ele: newsSearchLocators.subscriptionLables){
                if(methods.getElementText(ele).equals("First Name") ||
                methods.getElementText(ele).equals("Last Name")||
                methods.getElementText(ele).equals("Email")||
                methods.getElementText(ele).equals("Confirm Email")){
                    ExtentReporter.log(LogStatus.PASS, methods.getElementText(ele)+" is validated");
                }
            }
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "subscribePageValidation is validated");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "subscribePageValidation is failed "+e.getMessage());
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "subscribePageValidation is failed");
            Assert.fail();
        }
    }

    //RG_NW_2.20 Verify selected category list should be displayed in news


}
