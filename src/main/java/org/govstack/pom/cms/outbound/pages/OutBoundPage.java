package org.govstack.pom.cms.outbound.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.news.pages.NewsPage;
import org.govstack.pom.cms.outbound.locators.OutBoundLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;

public class OutBoundPage {

    static String outBoundTitle;
    OutBoundLocators outBoundLocators = new OutBoundLocators();
    CommonMethods methods = new CommonMethods();

    public void createNewOutboundLink() {
        navigateToOutBoundPage();
        createOutBoundLink();
    }

    public void navigateToOutBoundPageUnderSubNav() {
        methods.scrollToElement(outBoundLocators.pageEllipsisBtn_subNav);
        methods.rightClickOnTheElement(outBoundLocators.pageEllipsisBtn_subNav);
    }

    public void navigateToOutBoundPage() {
        if (Objects.equals(ConfigurationManager.getPropertyValue("ENV"), "QA")) {
            methods.scrollToElement(outBoundLocators.pageEllipsisBtn_QA);
            methods.rightClickOnTheElement(outBoundLocators.pageEllipsisBtn_QA);
        } else {
            methods.scrollToElement(outBoundLocators.pageEllipsisBtn_STAGE);
            methods.rightClickOnTheElement(outBoundLocators.pageEllipsisBtn_STAGE);
        }
    }

    public void navigateToOutBoundLinkPage() {
        methods.clickElement(outBoundLocators.createBtn);
        methods.clickElement(outBoundLocators.createOutBoundLink);
    }

    public void enterOutBoundDetails() {
        outBoundTitle = TestData.getData("Header Name") + "_" + methods.generateRandomString();
        methods.sendTextToElement(outBoundLocators.headerNameTxt, outBoundTitle);
        methods.sendTextToElement(outBoundLocators.outboundLinkUrlTxt, TestData.getData("OutBound_URL"));
        if (TestData.getData("Open New Tab") != null && TestData.getData("Open New Tab").equalsIgnoreCase("No")) {
            methods.clickElement(outBoundLocators.openNewTabToggleBtn);
        }
    }

    public void createOutBoundLink() {
        outBoundTitle = TestData.getData("Header Name") + "_" + methods.generateRandomString();
        methods.clickElement(outBoundLocators.createBtn);
        methods.clickElement(outBoundLocators.createOutBoundLink);
        methods.sendTextToElement(outBoundLocators.headerNameTxt, outBoundTitle);
        methods.sendTextToElement(outBoundLocators.outboundLinkUrlTxt, TestData.getData("OutBound_URL"));
        if (TestData.getData("Open New Tab") != null && TestData.getData("Open New Tab").equalsIgnoreCase("No")) {
            methods.clickElement(outBoundLocators.openNewTabToggleBtn);
        }
    }

    public void verifyOutBoundCreated() {
        boolean contactsCategory = false;
        methods.waitForElement(2);
        for (WebElement categoryFolder : outBoundLocators.outBoundLists) {
            if (categoryFolder.getText().equals(outBoundTitle)) {
                methods.moveToElement(categoryFolder);
                CommonMethods.highlightElement(categoryFolder);
                contactsCategory = true;
                break;
            }
        }
        if (contactsCategory) {
            ExtentReporter.logWithScreenshot(LogStatus.PASS, outBoundTitle + " is created");
        } else {
            ExtentReporter.log(LogStatus.FAIL, outBoundTitle + " is not created");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, outBoundTitle + " is not created");
            Assert.fail();
        }
    }

    public void verifyOutBoundDeleted() {
        boolean contactsCategory = false;
        methods.waitForElement(2);
        for (WebElement categoryFolder : outBoundLocators.outBoundLists) {
            if (categoryFolder.getText().equals(outBoundTitle)) {
                methods.moveToElement(categoryFolder);
                CommonMethods.highlightElement(categoryFolder);
                contactsCategory = true;
                break;
            }
        }
        if (contactsCategory) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, outBoundTitle + " is not deleted");
            Assert.fail();
        } else {
            ExtentReporter.log(LogStatus.PASS, outBoundTitle + " is is Deleted");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, outBoundTitle + " is Deleted");
        }
    }

    public void navigateToMainPageUnderOutBound() {
        methods.waitForElement(3);
        for (WebElement outbound : outBoundLocators.outBoundLists) {
            if (outbound.getText().contains("Automation Outbound Link") && !outbound.getText().contains("Updated")) {
                methods.rightClickOnTheElement(outbound);
                break;
            }
        }
    }

    public void deleteOutBoundLink() {
        methods.clickElement(outBoundLocators.deleteBtn);
        methods.clickElement(outBoundLocators.deleteConfirmBtn);
        methods.clickElement(outBoundLocators.finalOkBtn);
    }

    public void selectExistingOutBound() {
        methods.waitForElement(3);
        for (WebElement outbound : outBoundLocators.outBoundLists) {
            if (outbound.getText().contains("Automation Outbound Link") && !outbound.getText().contains("Updated")) {
                methods.moveToElement(outbound);
                methods.clickElement(outbound);
                break;
            }
        }
    }

    public void createPage() {
        methods.clickElement(outBoundLocators.createBtn);
        methods.clickElement(outBoundLocators.createPageLink);
        methods.clickElement(outBoundLocators.createOutBoundLink);
        NewsPage newsPage = new NewsPage();
        outBoundTitle = TestData.getData("Header Name") + "_" + methods.generateRandomString();
        methods.sendTextToElement(outBoundLocators.headerNameTxt, outBoundTitle);
        newsPage.enterContentDetails();
        newsPage.enterSummaryDetails();
    }

    public void verifyOutBoundLinkOnMainPage() {
        methods.rightClickOnTheElement(outBoundLocators.mainPageEllipsisBtn);
        methods.clickElement(outBoundLocators.createBtn);
        methods.waitForElement(3);
    }

    public void verifyOutBoundLink() {
        boolean outboundLink = false;
        for (WebElement ele : outBoundLocators.createOutBoundLnk) {
            if (ele.getText().contains("Outbound Link")) {
                outboundLink = true;
            }
        }
            if (!outboundLink) {
                ExtentReporter.log(LogStatus.PASS, "Out Bound link not displayed");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Out Bound link is displayed");
                Assert.fail("Out Bound link is displayed");
            }
    }

    public void validateErrorMessage(String message) {
        if (methods.getElementText(outBoundLocators.errorMessage).equals(message)) {
            ExtentReporter.logWithScreenshot(LogStatus.PASS, message + " Validated");
        } else {
            ExtentReporter.log(LogStatus.FAIL, message + " Not Displayed");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, message + " Not Displayed");
            Assert.fail();
        }
    }

    public void validateOutBoundErrorMessage(String message) {
        if (methods.getElementText(outBoundLocators.outBoundErrorMessage).equals(message)) {
            ExtentReporter.logWithScreenshot(LogStatus.PASS, message + " Validated");
        } else {
            ExtentReporter.log(LogStatus.FAIL, message + " Not Displayed");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, message + " Not Displayed");
            Assert.fail();
        }
    }
}
