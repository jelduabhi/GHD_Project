package org.govstack.pom.pf.pfaminities.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdAmenities.locators.BDAmenitiesLocators;
import org.govstack.pom.pf.pfaminities.locators.PFAmenitiesLocators;
import org.govstack.pom.pf.pffeatures.locators.PFFeaturesLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.testng.Assert;

public class PFAmenitiesPage extends WebDriverManager {
    CommonMethods methods = new CommonMethods();
    PFAmenitiesLocators pfAmenitiesLoc = new PFAmenitiesLocators();
    PFFeaturesLocators pfFeaturesLoc = new PFFeaturesLocators();
    BDAmenitiesLocators bdAmentiesLoc = new BDAmenitiesLocators();

    public void pfCreateAmenities() {
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
            methods.clickElement(pfAmenitiesLoc.pfAmenitiesSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Amenities under Park & facility created successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to create Amenities under Park & facility");
        }
    }

    public void pfAmenitiesSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfAmenitiesLoc.pfAmenitiesSearchField, TestData.getData("Validation"));
            methods.waitForElement(4);
            methods.isElementPresent(pfAmenitiesLoc.pfAmenitiesSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in amenities working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in amenities");
        }
    }

    public void pfAmenitiesDeleteBtn() {
        methods.waitForElement(6);
        methods.clickElement(bdAmentiesLoc.amenitiesDeleteBtn);
        methods.waitForElement(4);
        methods.clickElement(pfAmenitiesLoc.pfAmenitiesOkDeleteBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Delete Button amenities button clicked");
    }

    public void pfAmenitiesDeleteAssertion() {
        try {
            methods.waitForElement(4);
            methods.isElementPresent(pfFeaturesLoc.pfNoRecordFound);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Deleted amenities not visible validation passed");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Deleted amenities still visible in grid validation failed");
        }
    }

    public void pfAmenitiesEditSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfAmenitiesLoc.pfAmenitiesSearchField, TestData.getData("EditAmenityValidation"));
            methods.waitForElement(4);
            methods.isElementPresent(pfAmenitiesLoc.pfAmenitiesSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in amenities working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in amenities");
        }
    }

    public void pfAmenitiesEditFeatures() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfFeaturesLoc.pfFeaturesNameField, TestData.getData("EditAmenity") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.waitForElement(4);
            methods.clickElement(pfAmenitiesLoc.pfAmenitiesEditSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Amenities edited successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to edit Amenities");
        }
    }

    //Facility Type

    public void pfFacilityTypeTab() {
        methods.waitForElement(4);
        methods.clickElement(pfAmenitiesLoc.pfFacilityTypeTab);
        methods.waitForElement(4);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Facility Type tab clicked");
    }

    public void pfFacilityTypeSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfAmenitiesLoc.pfFacilityTypeSearchField, TestData.getData("Validation"));
            methods.waitForElement(4);
            methods.isElementPresent(pfAmenitiesLoc.pfFacilityTypeSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Facility Type search worked successfully");

        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in facility type");
        }
    }
}
