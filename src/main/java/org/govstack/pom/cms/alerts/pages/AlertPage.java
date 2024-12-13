package org.govstack.pom.cms.alerts.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.alerts.locators.AlertLocators;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.news.locators.NewsLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Objects;

public class AlertPage {

    public static String alertTitle;


    AlertLocators alertLocators = new AlertLocators();
    CommonMethods methods = new CommonMethods();
    NewsLocators newsLocators = new NewsLocators();
    ContentMainLocators mainLocators = new ContentMainLocators();

    public void createAlert() {
        enterAlertContentDetails();
        enterSettingsDetails();
    }

    public void createAlertWithoutStartDate() {
        enterAlertContentDetails();
        enterSettingsDetailsWithoutStartDate();
    }


    public void verifyAlert() {
        methods.clickElement(mainLocators.selectAlerts);
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt, alertTitle);
        for (WebElement ele : newsLocators.results) {
            if (ele.getText().contains(alertTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, "Alert Created");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Alert Created");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Alert not Created");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Alert not Created");
            }
        }
    }

    public void clickNewAlert() {
        methods.clickElement(alertLocators.creatNewAlertBtn);
    }

    public void enterAlertContentDetails() {
        alertTitle = TestData.getData("Alert title") + "_" + methods.generateRandomString();
        methods.sendTextToElement(alertLocators.headerNameTxt, alertTitle);
        methods.sendTextToElement(alertLocators.alertTitleTxt, alertTitle);
        methods.sendTextToElement(alertLocators.alertOptionalTxt, TestData.getData("Alert Optional Label"));
//        methods.switchToFrame(alertLocators.alertDescriptionFrame);
//        methods.sendTextToElement(alertLocators.alertDescription, TestData.getData("Alert Description"));
//        methods.switchToDefaultContent();
        methods.sendTextToElement(alertLocators.alertActionText, TestData.getData("Call to Action Text"));
        if (TestData.getData("Call to Action Link") != null) {
            methods.clickElement(alertLocators.callToActionLnk);

        }
    }

    public void enterSettingsDetails() {
        methods.javaScriptClickElement(alertLocators.settingsLnk);
        methods.selectValueFromDropdown(alertLocators.alertTypeDropdown, TestData.getData("Alert Type"));
        methods.clickElement(alertLocators.startDatebtn);
        methods.waitForElement(1);
        if (TestData.getData("Post Date").equalsIgnoreCase("CurrentDate")) {
            methods.selectDateFromCalender(alertLocators.datePicker, methods.getCurrentDate());
            methods.waitForElement(1);
            methods.sendTextToElement(alertLocators.startDateHours, methods.getCurrentHours());
            methods.waitForElement(2);
            methods.sendTextToElement(alertLocators.startDateMinitus, methods.getCurrentMinitus());
        } else if (TestData.getData("Post Date").equalsIgnoreCase("PastDate")) {
            methods.selectDateFromCalender(alertLocators.datePicker, methods.getPastDate(1));
            methods.waitForElement(1);
        } else if (TestData.getData("Post Date").equalsIgnoreCase("FutureDate")) {
            methods.selectDateFromCalender(alertLocators.datePicker, methods.getFutureDate(2));
            methods.waitForElement(1);
        }

        methods.selectValueFromDropdown(alertLocators.alertStyleDropdown, TestData.getData("Alert Style"));
        methods.clickElement(alertLocators.endDateBtn);
        methods.waitForElement(1);
        if (TestData.getData("End Date").equalsIgnoreCase("CurrentDate")) {
            methods.selectDateFromCalender(alertLocators.datePicker, methods.getCurrentDate());
            methods.waitForElement(1);
        } else if (TestData.getData("End Date").equalsIgnoreCase("PastDate")) {
            methods.selectDateFromCalender(alertLocators.datePicker, methods.getPastDate(1));
            methods.waitForElement(1);
        } else if (TestData.getData("End Date").equalsIgnoreCase("FutureDate")) {
            methods.selectDateFromCalender(alertLocators.datePicker, methods.getFutureDate(2));
            methods.waitForElement(1);
        }

        methods.clickElement(alertLocators.alertPages);
        methods.waitForElement(2);
        if (Objects.requireNonNull(ConfigurationManager.getPropertyValue("ENV")).equals("STAGE")) {
            methods.scrollToElement(alertLocators.clickStagePage);
            methods.clickElement(alertLocators.clickStagePage);
        } else {
//            methods.scrollToElement(alertLocators.clickQAPage);
//            methods.clickElement(alertLocators.clickQAPage);
            methods.scrollToElement(alertLocators.clickStagePage);
            methods.clickElement(alertLocators.clickStagePage);
        }
        methods.clickElement(alertLocators.submitBtn);
    }


    public void enterSettingsDetailsWithoutStartDate() {
        methods.javaScriptClickElement(alertLocators.settingsLnk);
        methods.selectValueFromDropdown(alertLocators.alertTypeDropdown, TestData.getData("Alert Type"));
        methods.selectValueFromDropdown(alertLocators.alertStyleDropdown, TestData.getData("Alert Style"));
//        methods.clickElement(alertLocators.startDatebtn);
//        methods.waitForElement(2);
//        if (TestData.getData("Start Date").equalsIgnoreCase("CurrentDate")) {
//            methods.selectOptionFromList(alertLocators.datePicker, methods.getCurrentDate());
//        }
    }


    //RG_AL_3.9 Alert without start date validation message should be visible
    public void alertSaveWithoutDate() {
        Assert.assertTrue(alertLocators.alertWithoutDateSaveValidMessage.isDisplayed());
        ExtentReporter.log(LogStatus.INFO, "Validation message required field is visible");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Validation message required field is visible");

    }


    public void updateAlerts() {
        alertTitle = methods.getElementText(alertLocators.alertsTitles.getFirst());
        methods.clickElement(alertLocators.alertsTitles.getFirst());
        enterAlertContentDetails();
        enterSettingsDetails();
    }

    public void deleteAlert(String alertType) {
        Iterator<WebElement> alertsList = alertLocators.alertsLists.iterator();
        Iterator<WebElement> alertsTitle = alertLocators.alertsTitles.iterator();
        if (methods.getElementText(alertLocators.alertsTitles.getFirst()).contains(alertType)) {
            alertTitle = methods.getElementText(alertLocators.alertsTitles.getFirst());
            methods.clickElement(alertLocators.alertsLists.getFirst());
        } else {
            while (alertsTitle.hasNext()) {
                alertTitle = methods.getElementText(alertsTitle.next());
                if (alertTitle.contains(alertType)) {
                    methods.clickElement(alertsList.next());
                    break;
                } else {
                    alertsList.next();
                }
            }
        }
        methods.waitForElement(2);
        methods.clickElement(alertLocators.deleteBtn);
        methods.clickElement(alertLocators.yesDeleteBtn);
        methods.waitForElement(1);
    }

    public void checkDeletedAlertInRecycleBin() {
        methods.clickElement(mainLocators.recycleBinBtn);
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt, alertTitle);
        methods.waitForElement(2);
        for (WebElement ele : newsLocators.results) {
            if (ele.getText().contains(alertTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, "Alert Deleted");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Alert Deleted");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Alert not Deleted");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Alert not Created");
            }
        }
    }
}
