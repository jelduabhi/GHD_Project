package org.govstack.pom.bd.bdFeatures.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdAmenities.locators.BDAmenitiesLocators;
import org.govstack.pom.bd.bdFeatures.locators.BDFeaturesLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.testng.Assert;

public class BDFeaturesPage extends WebDriverManager {

    CommonMethods methods = new CommonMethods();
    BDFeaturesLocators bdFeaturesLoc = new BDFeaturesLocators();
    BDAmenitiesLocators bdAmentiesLoc = new BDAmenitiesLocators();

    public void bdFeaturesTab() {
        methods.waitForElement(4);
        methods.clickElement(bdFeaturesLoc.featuresTab);
        methods.waitForElement(4);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Features tab clicked");
    }

    public void bdCreateFeatures() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdFeaturesLoc.featuresNameField, TestData.getData("Name") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.clickElement(bdAmentiesLoc.amenitiesStatusDropdown);
            methods.waitForElement(4);
            if (TestData.getData("Status").equalsIgnoreCase("Active")) {
                methods.waitForElement(3);
                methods.clickElement(bdAmentiesLoc.amenitiesStatusActive);
            } else if (TestData.getData("Status").equalsIgnoreCase("Inactive")) {
                methods.waitForElement(3);
                methods.clickElement(bdAmentiesLoc.amenitiesStatusInactive);
            }
            methods.clickElement(bdAmentiesLoc.amenitiesSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Features created successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to create Features");
        }
    }

    public void bdFeaturesSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdFeaturesLoc.featuresSearchField, TestData.getData("Validation"));
            methods.waitForElement(4);
            methods.isElementPresent(bdFeaturesLoc.featuresSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in features working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in features");
        }
    }

    public void bdFeaturesDeleteAssertion() {
        try {
            methods.waitForElement(4);
            methods.isElementPresent(bdAmentiesLoc.amenitiesNoFoundText);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Deleted features not visbible validation passed");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Deleted features still visible in grid validation failed");
        }
    }

    public void bdSelectFeaturesStatusFilter() {
        try {
            methods.waitForElement(3);
            methods.clickElement(bdAmentiesLoc.amenitiesSelectAll);
            if (TestData.getData("FeaturesStatusFilter").equalsIgnoreCase("Active")) {
                methods.waitForElement(3);
                methods.clickElement(bdAmentiesLoc.amenitiesTrue);
            } else if (TestData.getData("FeaturesStatusFilter").equalsIgnoreCase("Inactive")) {
                methods.waitForElement(3);
                methods.clickElement(bdAmentiesLoc.amenitiesFalse);
            }
            methods.clickElement(bdAmentiesLoc.amenitiesFilterBtn);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Filter of status selected successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to select status filter");
        }
    }

    public void bdFeatureSearch() {
        methods.waitForElement(6);
        methods.sendTextToElement(bdFeaturesLoc.featuresSearchField, TestData.getData("nonExistFeatures"));
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Features Search field typed by user");
    }

    public void bdAddFeaturesGridBtn() {
        methods.waitForElement(6);
        methods.clickElement(bdFeaturesLoc.addFeaturesBtnGrid);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Add Feature Button clicked");
    }

    public void bdEditFeatures() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdFeaturesLoc.featuresNameField, TestData.getData("EditFeatures") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.waitForElement(4);
            methods.clickElement(bdAmentiesLoc.amenitiesSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Features edited successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to edit Features");
        }
    }

    public void bdFeaturesEditSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdFeaturesLoc.featuresSearchField, TestData.getData("EditFeaturesValidation"));
            methods.waitForElement(4);
            methods.isElementPresent(bdFeaturesLoc.featuresSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in features working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in features");
        }
    }
}