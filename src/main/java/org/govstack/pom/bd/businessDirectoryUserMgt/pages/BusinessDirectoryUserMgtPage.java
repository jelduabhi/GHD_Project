package org.govstack.pom.bd.businessDirectoryUserMgt.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.bd.businessDirectoryUserMgt.locators.BusinessDirectoryUserMgtLocators;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;


public class BusinessDirectoryUserMgtPage extends org.govstack.webdriver.WebDriverManager {

    CommonMethods methods = new CommonMethods();
    BusinessDirectoryUserMgtLocators businessDirLoc = new BusinessDirectoryUserMgtLocators();

    public void businessDirectoryPageValidationAssertion() {
        try {
            methods.waitForElement(8);
            String tabUrl = getDriver().getTitle();
            System.out.println(tabUrl);
            methods.assertEqualsString(tabUrl, "GHD Business Directory Backoffice");
            methods.isElementPresent(businessDirLoc.businessDirHeader);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Business Directory Page opened successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open Business Directory Page");
        }
    }

    public void businessDirectoryPostSignOutValidationAssertion() {
        try {
            methods.waitForElement(8);
            String tabUrl = getDriver().getTitle();
            System.out.println(tabUrl);
            methods.assertEqualsString(tabUrl, "govstack");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Business Directory post signout redirect to Dashboard screen successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to navigate to dashboard screen post sign out Business directory");
        }
    }

}
