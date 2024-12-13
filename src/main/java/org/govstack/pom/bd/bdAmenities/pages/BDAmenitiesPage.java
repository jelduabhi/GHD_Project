package org.govstack.pom.bd.bdAmenities.pages;

import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdAmenities.locators.BDAmenitiesLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

public class BDAmenitiesPage extends WebDriverManager {

    CommonMethods methods = new CommonMethods();
    BDAmenitiesLocators bdAmentiesLoc = new BDAmenitiesLocators();

    public void bdAmenitiesTab() {
        methods.waitForElement(4);
        methods.clickElement(bdAmentiesLoc.amenitiesTab);
        methods.waitForElement(4);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Amenities tab clicked");
    }

    public void bdAmenitiesAddBtn() {
        methods.waitForElement(3);
        methods.clickElement(bdAmentiesLoc.amenitiesAddBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Amenities Add button clicked");
    }

    public void bdAmenitiesEditBtn() {
        methods.waitForElement(3);
        methods.clickElement(bdAmentiesLoc.amenitiesEditBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Amenities Edit button clicked");
    }

    public void bdAmenitiesThreeDots() {
        methods.waitForElement(3);
        if (methods.isElementPresent(bdAmentiesLoc.amenitiesThreeDotsPage)) {
            methods.waitForElement(3);
            methods.clickElement(bdAmentiesLoc.amenitiesThreeDotsPage);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Amenities Three dots icon clicked");
        }
    }

    public void bdAmenitiesPageClick() {
        methods.waitForElement(3);
        if (methods.isElementPresent(bdAmentiesLoc.amenitiesPage)) {
            methods.waitForElement(3);
            methods.clickElement(bdAmentiesLoc.amenitiesPage);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Amenities Page clicked");
        }
    }

    public void bdCreateAmenities() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdAmentiesLoc.amenitiesNameField, TestData.getData("Name") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.clickElement(bdAmentiesLoc.amenitiesStatusDropdown);
            methods.waitForElement(4);
            //methods.clickElement(bdAmentiesLoc.amenitiesStatus);
            if (TestData.getData("Status").equalsIgnoreCase("Active")) {
                methods.waitForElement(3);
                methods.clickElement(bdAmentiesLoc.amenitiesStatusActive);
            } else if (TestData.getData("Status").equalsIgnoreCase("Inactive")) {
                methods.waitForElement(3);
                methods.clickElement(bdAmentiesLoc.amenitiesStatusInactive);
            }
            methods.clickElement(bdAmentiesLoc.amenitiesSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Amenities created successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to create Amenities");
        }
    }

    public void bdEditAmenities() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdAmentiesLoc.amenitiesNameField, TestData.getData("EditAmenity") + "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.waitForElement(4);
            methods.clickElement(bdAmentiesLoc.amenitiesSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Amenities edited successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to edit Amenities");
        }
    }

    public void bdAmenitiesSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdAmentiesLoc.amenitiesSearchField, TestData.getData("Validation"));
            methods.waitForElement(4);
            methods.isElementPresent(bdAmentiesLoc.amenitiesSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in amenities working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in amenities");
        }
    }

    public void bdAmenitiesEditSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdAmentiesLoc.amenitiesSearchField, TestData.getData("EditAmenityValidation"));
            methods.waitForElement(4);
            methods.isElementPresent(bdAmentiesLoc.amenitiesSearchResult);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in amenities working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in amenities");
        }
    }

    public void bdAmenitiesDeleteAssertion() {
        try {
            methods.waitForElement(4);
            methods.isElementPresent(bdAmentiesLoc.amenitiesNoFoundText);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Deleted amenties not visbible validation passed");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Deleted amenities still visible in grid validation failed");
        }
    }

    public void bdAmenitiesStatusFilterAssertion() {
        try {
            methods.waitForElement(4);
            methods.isElementPresent(bdAmentiesLoc.amenitiesFilterSelectedStatus);
            methods.isElementPresent(bdAmentiesLoc.amenitiesFilterSelectedClearAll);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Filter validated Successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to validate status filter");
        }
    }

    public void bdAmenitiesSearch() {
        methods.waitForElement(6);
        methods.sendTextToElement(bdAmentiesLoc.amenitiesSearchField, TestData.getData("nonExistAmenities"));
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Amenities Search field typed by user");
    }

    public void bdAmenitiesFunnelIcon() {
        methods.waitForElement(6);
        methods.clickElement((bdAmentiesLoc.amenitiesStatusFunnelIcon));
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Amenities Funnel icon clicked");
    }

    public void bdAddAmenitiesGridBtn() {
        methods.waitForElement(6);
        methods.clickElement(bdAmentiesLoc.addAmenitiesBtnGrid);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Add Amenities Button clicked");
    }

    public void bdDeleteAmenitiesBtn() {
        methods.waitForElement(6);
        methods.clickElement(bdAmentiesLoc.amenitiesDeleteBtn);
        methods.waitForElement(4);
        methods.clickElement(bdAmentiesLoc.amenitiesOkBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Delete Button amenities button clicked");
    }

    public void bdAddAmenitiesClearGridBtn() {
        methods.waitForElement(6);
        if (methods.isElementPresent(bdAmentiesLoc.amenitiesClearBtnGrid)) {
            methods.clickElement(bdAmentiesLoc.amenitiesClearBtnGrid);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Clear Amenities Button clicked");
        }

    }

    public void bdAmenitiesListValidationAssertion() {
        try {
            methods.waitForElement(3);
            if (methods.isElementPresent(bdAmentiesLoc.amenitiesList)) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Amenities list is visible");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Amenities list is not visible");
                Assert.fail();
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to get Amenities list");
        }
    }

    public void bdSelectStatusFilter() {
        try {
            methods.waitForElement(3);
            methods.clickElement(bdAmentiesLoc.amenitiesSelectAll);
            if (TestData.getData("AmenitiesStatusFilter").equalsIgnoreCase("Active")) {
                methods.waitForElement(3);
                methods.clickElement(bdAmentiesLoc.amenitiesTrue);
            } else if (TestData.getData("AmenitiesStatusFilter").equalsIgnoreCase("Inactive")) {
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
}