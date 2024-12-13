package org.govstack.pom.pf.pffeatures.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdAmenities.locators.BDAmenitiesLocators;
import org.govstack.pom.pf.pffeatures.locators.PFFeaturesLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.testng.Assert;

public class PFFeaturesPage extends WebDriverManager{

    CommonMethods methods = new CommonMethods();
    PFFeaturesLocators pfFeaturesLoc = new PFFeaturesLocators();
    BDAmenitiesLocators bdAmentiesLoc = new BDAmenitiesLocators();

    public void pfCreateFeatures() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfFeaturesLoc.pfFeaturesNameField, TestData.getData("Name") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.clickElement(bdAmentiesLoc.amenitiesStatusDropdown);
            methods.waitForElement(4);
            if (TestData.getData("Status").equalsIgnoreCase("Yes")) {
                methods.waitForElement(3);
                methods.clickElement(pfFeaturesLoc.pfStatusYes);
            } else if (TestData.getData("Status").equalsIgnoreCase("No")) {
                methods.waitForElement(3);
                methods.clickElement(pfFeaturesLoc.pfStatusNo);
            }
            methods.clickElement(pfFeaturesLoc.pfSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Features under Park & facility created successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to create Features under Park & facility");
        }
    }

    public void pfFeaturesSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfFeaturesLoc.pfFeaturesSearchField, TestData.getData("Validation"));
            methods.waitForElement(4);
            methods.isElementPresent(pfFeaturesLoc.pffeaturesSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in features working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in features");
        }
    }

    public void pfDeleteBtn() {
        methods.waitForElement(6);
        methods.clickElement(bdAmentiesLoc.amenitiesDeleteBtn);
        methods.waitForElement(4);
        methods.clickElement(pfFeaturesLoc.pfOkDeleteBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Delete Button feature button clicked");
    }

    public void pfFeaturesDeleteAssertion() {
        try {
            methods.waitForElement(4);
            methods.isElementPresent(pfFeaturesLoc.pfNoRecordFound);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Deleted features not visible validation passed");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Deleted features still visible in grid validation failed");
        }
    }

    public void pfFeaturesEditSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfFeaturesLoc.pfFeaturesSearchField, TestData.getData("EditFeaturesValidation"));
            methods.waitForElement(4);
            methods.isElementPresent(pfFeaturesLoc.pffeaturesSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in features working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in features");
        }
    }

    public void pfEditFeatures() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfFeaturesLoc.pfFeaturesNameField, TestData.getData("EditFeatures") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.waitForElement(4);
            methods.clickElement(pfFeaturesLoc.pfSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Features edited successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to edit Features");
        }
    }
}
