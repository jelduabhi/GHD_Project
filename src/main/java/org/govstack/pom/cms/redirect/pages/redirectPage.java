package org.govstack.pom.cms.redirect.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.redirect.locators.redirectLocator;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;

public class redirectPage extends WebDriverManager {
    CommonMethods methods = new CommonMethods();
    redirectLocator redirectLoc = new redirectLocator();

    public void govstackRedirectTab() {
        try {
            methods.waitForElement(10);
            methods.clickElement(redirectLoc.redirectTab);
            ExtentReporter.log(LogStatus.PASS, "user click redirect tab");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to click redirect tab");
        }
    }

    public void redirectHeaderAssertion() {
        try {
            methods.waitForElement(10);
            methods.isElementPresent(redirectLoc.redirectHeader);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Redirect header and screen is visible");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Verify Redirect tab");
        }
    }

    public void redirectButton() {
        try {
            methods.waitForElement(10);
            methods.clickElement(redirectLoc.addRedirectBtn);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Add Redirect button clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to click add redirect button");
        }
    }

    public void enterOrignalUrl() {
        methods.waitForElement(10);
        methods.sendTextToElement(redirectLoc.originalUrl, TestData.getData("OriginalUrl") + "/" + methods.generateRandomString());
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.destinationUrl);
        methods.waitForElement(5);
        methods.sendTextToElement(redirectLoc.urlLinkTextField, TestData.getData("DestinationUrl"));
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.redirectSubmitBtn);
        methods.waitForElement(10);
        methods.clickElement(redirectLoc.redirectAddBtn);
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "URL details added");
    }

    public void advanceOptionSelect() {
        methods.waitForElement(10);
        methods.sendTextToElement(redirectLoc.originalUrl, TestData.getData("OriginalUrl") + "/" + methods.generateRandomString());
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.temporaryRadioBtn);
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.destinationUrl);
        methods.waitForElement(5);
        methods.sendTextToElement(redirectLoc.urlLinkTextField, TestData.getData("DestinationUrl"));
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.redirectSubmitBtn);
        methods.waitForElement(10);
        methods.clickElement(redirectLoc.redirectAddBtn);
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "URL details added");
    }

    public void enterMediaUrl() {
        methods.waitForElement(10);
        methods.sendTextToElement(redirectLoc.originalUrl, TestData.getData("OriginalUrl") + "/" + methods.generateRandomString());
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.destinationUrl);
        methods.waitForElement(5);
        methods.clickElement(redirectLoc.selectMediaBtn);
        methods.waitForElement(3);
        methods.sendTextToElement(redirectLoc.searchFileField, TestData.getData("DestinationUrl"));
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.gsLogoSelect);
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.mediaSelectBtn);
        methods.waitForElement(3);
        methods.clickElement(redirectLoc.redirectSubmitBtn);
        methods.waitForElement(10);
        methods.clickElement(redirectLoc.redirectAddBtn);
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "Media File selected");
    }

    public void redirectSearchAssertion() {
        try {
            methods.waitForElement(5);
            methods.sendTextToElement(redirectLoc.redirectSearchFilter, TestData.getData("OriginalUrl"));
            methods.waitForElement(10);
            methods.isElementPresent(redirectLoc.redirectsearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in redirect page working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search in redirect search filter");
        }
    }

    public void orginalUrlClickList() {
        try {
            methods.waitForElement(5);
            methods.clickElement(redirectLoc.originalUrlClick);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Original Url Click from list");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to click orignal url from list");
        }
    }

    public void redirectTemporaryBtnSelect() {
        try {
            methods.waitForElement(5);
            methods.clickElement(redirectLoc.temporaryRadioBtn);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Temporary Radio button Select");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to click temporary radio button");
        }
    }

    public void originalUrlRedirectAssertion() {
        try {
            methods.waitForElement(8);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            System.out.println(tabUrl);
            methods.assertEqualsString(tabUrl, TestData.getData("title"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Original url open in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open Original url");
        }
    }

    public void mediaUrlRedirectAssertion() {
        try {
            methods.waitForElement(8);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
//            System.out.println(tabUrl);
//            methods.assertEqualsString(tabUrl, TestData.getData("title"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "media url open in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open media url");
        }
    }


}
