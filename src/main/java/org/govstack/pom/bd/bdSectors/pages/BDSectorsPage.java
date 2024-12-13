package org.govstack.pom.bd.bdSectors.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdSectors.locators.BDSectorsLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.testng.Assert;

public class BDSectorsPage extends WebDriverManager {

    CommonMethods methods = new CommonMethods();
    BDSectorsLocators bdSectorLoc = new BDSectorsLocators();

    public void bdSectorsTab() {
        methods.waitForElement(4);
        methods.clickElement(bdSectorLoc.sectorsTab);
        methods.waitForElement(4);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Sectors tab clicked");
    }

    public void bdSectorsSearchAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdSectorLoc.sectorsSearchField, TestData.getData("Validation"));
            methods.waitForElement(4);
            String searchColumnActualText = methods.getElementText(bdSectorLoc.sectorsSearchResult);
            System.out.println("Search Column Actual Text : " + searchColumnActualText);
            methods.assertEqualsString(searchColumnActualText,TestData.getData("Validation"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search result in sectors working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search result in sectors");
        }
    }

    public void bdSectorToggleValidation(){
        try {
            methods.waitForElement(3);
            methods.clickElement(bdSectorLoc.sectorToggle);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Toggle clicked properly");
        }
        catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to enable/disable toggle");
        }
    }

    public void bdSectorExpandCollapseValidation(){
        try {
            methods.waitForElement(3);
            methods.clickElement(bdSectorLoc.sectorExpand);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Sector expanded properly from listing grid");
            methods.waitForElement(4);
            methods.clickElement(bdSectorLoc.sectorCollapse);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Sector collapsed properly from listing grid");
        }
        catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to expand/collapse sector from listing grid");
        }
    }

    public void bdSectorsExpandGrid() {
        methods.waitForElement(4);
        methods.clickElement(bdSectorLoc.sectorExpand);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Sectors expand from grid list");
    }

    public void bdAreaOfServiceBtn() {
        methods.waitForElement(4);
        methods.scrollAndClickElement(bdSectorLoc.sectorAreaOfServiceBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Area of service button click");
    }

    public void bdCreateAreaOfSector() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdSectorLoc.sectorNameField, TestData.getData("Header") + "_" + methods.generateRandomString());
            methods.waitForElement(3);
            methods.clickElement(bdSectorLoc.sectorStatusDropdown);
            methods.waitForElement(4);
            if (TestData.getData("Status").equalsIgnoreCase("Yes")) {
                methods.waitForElement(3);
                methods.clickElement(bdSectorLoc.sectorStatusYes);
            } else if (TestData.getData("Status").equalsIgnoreCase("No")) {
                methods.waitForElement(3);
                methods.clickElement(bdSectorLoc.sectorStatusNo);
            }
            methods.clickElement(bdSectorLoc.sectorSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Area of sector created successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to create Area of sector");
        }
    }


    public void bdSectorCreationValidation(){
        try {
            methods.waitForElement(3);
            if (methods.isElementPresent(bdSectorLoc.sectorListValidation)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Sector validated");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to validate sector");
                Assert.fail();
            }
        }
        catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to validate sector from listing grid");
        }
    }


    public void bdSectorDeleteBtn() {
        methods.waitForElement(4);
        methods.scrollAndClickElement(bdSectorLoc.sectorDeleteIcon);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Delete button Clicked");
        methods.waitForElement(3);
        methods.clickElement(bdSectorLoc.sectorDeleteOkBtn);
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "Delete button Clicked and record deleted successfully");
    }

    public void bdSectorEditBtn() {
        methods.waitForElement(4);
        methods.clickElement(bdSectorLoc.sectorEditIcon);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Edit icon clicked");
    }

    public void bdEditAreaOfSector() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(bdSectorLoc.sectorNameField, TestData.getData("Update_Sector") + "_" + methods.generateRandomString());
            methods.waitForElement(3);
            methods.clickElement(bdSectorLoc.sectorSaveBtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Area of sector edited successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to edit Area of sector");
        }
    }

    public void bdSectorUpdationValidation(){
        try {
            methods.waitForElement(3);
            if (methods.isElementPresent(bdSectorLoc.sectorListUpdateValidation)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Sector updated");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to update sector");
                Assert.fail();
            }
        }
        catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to update sector from listing grid");
        }
    }
}