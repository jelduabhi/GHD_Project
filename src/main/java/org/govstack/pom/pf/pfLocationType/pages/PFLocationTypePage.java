package org.govstack.pom.pf.pfLocationType.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdAmenities.locators.BDAmenitiesLocators;
import org.govstack.pom.pf.pfLocationType.locators.PFLocationTypeLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.testng.Assert;

public class PFLocationTypePage extends WebDriverManager {

    CommonMethods methods = new CommonMethods();
    PFLocationTypeLocators pfLocationTypeLoc = new PFLocationTypeLocators();
    BDAmenitiesLocators bdAmentiesLoc = new BDAmenitiesLocators();

    public void pfLocationsTypeTab() {
        methods.waitForElement(4);
        methods.clickElement(pfLocationTypeLoc.pfLocationTypeTab);
        methods.waitForElement(4);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Location Type tab clicked");
    }

    public void pfCreateLocationType() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfLocationTypeLoc.pfLocationTypeNameField, TestData.getData("Name") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.clickElement(bdAmentiesLoc.amenitiesStatusDropdown);
            methods.waitForElement(4);
            if (TestData.getData("Status").equalsIgnoreCase("Yes")) {
                methods.waitForElement(3);
                methods.clickElement(pfLocationTypeLoc.pfLocationTypeStatusYes);
            } else if (TestData.getData("Status").equalsIgnoreCase("No")) {
                methods.waitForElement(3);
                methods.clickElement(pfLocationTypeLoc.pfLocationTypeStatusNo);
            }
            methods.clickElement(pfLocationTypeLoc.pfLocationTypeSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Location Type under Park & facility created successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to create Location Type under Park & facility");
        }
    }

    public void pfLocationTypeSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfLocationTypeLoc.pfLocationTypeSearchField, TestData.getData("Validation"));
            methods.waitForElement(4);
            methods.isElementPresent(pfLocationTypeLoc.pfLocationTypeSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in Location Type working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in Location Type");
        }
    }

    public void pfLocationTypeDeleteBtn() {
        methods.waitForElement(6);
        methods.clickElement(pfLocationTypeLoc.pfLocationTypeDeleteBtn);
        methods.waitForElement(4);
        methods.clickElement(pfLocationTypeLoc.pfLocationTypeOkBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Delete Button on location type grid clicked");
    }

    public void pfLocationTypeDeleteAssertion() {
        try {
            methods.waitForElement(4);
            methods.isElementPresent(pfLocationTypeLoc.pfLocationTypeNoFoundText);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Deleted location type not visible validation passed");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Deleted location type still visible in grid validation failed");
        }
    }

    public void pfLocationTypeEditSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfLocationTypeLoc.pfLocationTypeSearchField, TestData.getData("EditLocationTypeValidation"));
            methods.waitForElement(4);
            methods.isElementPresent(pfLocationTypeLoc.pfLocationTypeSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in location type working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in location type");
        }
    }

    public void pfLocationTypeEditFeatures() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(pfLocationTypeLoc.pfLocationTypeNameField, TestData.getData("EditLocationType") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.waitForElement(4);
            methods.clickElement(pfLocationTypeLoc.pfLocationTypeEditSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Location type edited successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to edit Location Type");
        }
    }

}
