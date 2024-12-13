package org.govstack.pom.cms.alerts.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.cms.alerts.locators.AlertFrontEndLocators;
import org.govstack.pom.cms.news.locators.NewsLocators_FrontEnd;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AlertFrontEndPage {

    CommonMethods methods = new CommonMethods();
    AlertFrontEndLocators alertFrontEndLocators = new AlertFrontEndLocators();
    NewsLocators_FrontEnd newsLocatorsFrontEnd = new NewsLocators_FrontEnd();

    public void verifyAlertInFrontEnd() {
        methods.waitForElement(3);
        for (WebElement ele : alertFrontEndLocators.alertHeadings) {
            if (ele.getText().equalsIgnoreCase(AlertPage.alertTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Alert is published");
                break;
            } else if (alertFrontEndLocators.alertNextButton.isEnabled()) {
                methods.clickElement(alertFrontEndLocators.alertNextButton);
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Alert is not published");
                Assert.fail();
            }
        }
    }

    public void verifyBannerAlert() {
        methods.clickElement(newsLocatorsFrontEnd.dismissAllAlerts);
        methods.waitForElement(1);
        for (WebElement ele : alertFrontEndLocators.bannerAlerts) {
            if (ele.getText().equals(AlertPage.alertTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Alert is published");
            }
        }
    }

    public void verifyBannerAlertNotPublished() {
        methods.clickElement(newsLocatorsFrontEnd.dismissAllAlerts);
        methods.waitForElement(1);
        for (WebElement ele : alertFrontEndLocators.bannerAlerts) {
            if (ele.getText().equals(AlertPage.alertTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Alert is published");
                Assert.fail();
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Alert is Not published");
            }
        }
    }


    public void verifyPopupAlertNotPublished() {
        for (WebElement ele : alertFrontEndLocators.alertHeadings) {
            if (ele.getText().equalsIgnoreCase(AlertPage.alertTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.FAIL, "Alert is published");
                Assert.fail();
                break;
            } else if (alertFrontEndLocators.alertNextButton.isEnabled()) {
                methods.clickElement(alertFrontEndLocators.alertNextButton);
            } else {
                ExtentReporter.log(LogStatus.PASS, "Alert is not published");
            }
        }
    }

    public void verifyAlertNotPublished(String alertType) {
        switch (alertType.toLowerCase()) {
            case "pop up" :
                verifyPopupAlertNotPublished();
                break;
            case "banner":
                verifyBannerAlertNotPublished();
                break;
            default:
                ExtentReporter.log(LogStatus.FAIL,"Select alert type");
                Assert.fail();
        }
    }
}
