package org.govstack.pom.bd.bdListNaics.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdListNaics.locators.BDListingNaicsLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.openqa.selenium.Keys;
import org.testng.Assert;


public class BDListingNaicsPage extends WebDriverManager {
    CommonMethods methods = new CommonMethods();
    BDListingNaicsLocators BdListingNaicsLoc = new BDListingNaicsLocators();

    public void bdAddBusinessButton() {
        methods.waitForElement(4);
        methods.clickElement(BdListingNaicsLoc.BdAddBusinessbtn);
        methods.waitForElement(4);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Add Business button clicked");
    }

    public void bdNaicsLookupButton() {
        methods.waitForElement(4);
        methods.clickElement(BdListingNaicsLoc.BdNaicsLookupBtn);
        methods.waitForElement(4);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "NAICS Lookup button clicked");
    }

    public void generalTabValidation(){
        try {
            if (methods.isElementPresent(BdListingNaicsLoc.Bdgeneraltab)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "General tab is visible as default");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "General tab not visible as default");
                Assert.fail("General tab not visible as default");
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("General tab not visible as default");
        }
    }

    public void naicsCodeAdd(){
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(BdListingNaicsLoc.BdNaicsCodeTextField, TestData.getData("NAICS_Code"));
            methods.waitForElement(3);
            if(methods.isElementNotPresent(BdListingNaicsLoc.BdNaicsErrorMessage)) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "NAICS Code is valid code");
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail();
        }
    }

    public void naicsInvalidCodeAddValidation(){
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(BdListingNaicsLoc.BdNaicsCodeTextField, TestData.getData("NAICS_Code"));
            methods.waitForElement(3);
            if(methods.getElementText(BdListingNaicsLoc.BdNaicsErrorMessage).contains("The NAICS code must be a 6-digit number. ")) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "NAICS Code is Invalid code and not accepted");
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail();
        }
    }

    public void naicsLookupWindowValidation(){
        try {
            if (methods.isElementPresent(BdListingNaicsLoc.BdNaicsLookupwindowheading)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "NAICS Lookup window open successfully");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "NAICS Lookup window not open");
                Assert.fail("NAICS Lookup window not open");
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("NAICS Lookup window not open");
        }
    }

    public void naicsLookupWindowContentValidation(){
        try {
            if (methods.isElementPresent(BdListingNaicsLoc.BdNaicsSearchfield) && methods.isElementPresent(BdListingNaicsLoc.BdNaicstableContentHeader)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "NAICS Lookup window have search bar and table column NAICS_code,Industry_title and Copycode is visible");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "NAICS Lookup window search bar and table column NAICS_code,Industry_title and Copycode is not visible");
                Assert.fail("NAICS Lookup window search bar and table column NAICS_code,Industry_title and Copycode is not visible");
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to validate NAICS table header content");
        }
    }

    public void searchNaicscode(){
        try{
            methods.waitForElement(3);
            methods.sendTextToElement(BdListingNaicsLoc.BdNaicsSearchfield, TestData.getData("SearchNaicsCode"));
            if (methods.isElementPresent(BdListingNaicsLoc.BdNaicstableGridResult)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "NAICS Code able to search by Title or code");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to search by Title or code");
                Assert.fail("Failed to search NAICS code by title or code");
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to validate NAICS by code or title");
        }

    }

    public void bdNaicsExpandCollapseValidation(){
        try {
            methods.waitForElement(3);
            methods.clickElement(BdListingNaicsLoc.BdNaicsListCollapse);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "NAICS grid expanded properly from listing grid");
            methods.waitForElement(4);
            methods.clickElement(BdListingNaicsLoc.BdNaicsListExpand);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "NAICS collapsed properly from listing grid");
        }
        catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to expand/collapse NAICS from listing grid");
        }
    }

    public void naicsCopiedcode(){
        methods.waitForElement(3);
        methods.clickElement(BdListingNaicsLoc.BdCopyIcon);
        methods.waitForElement(2);
        methods.clickElement(BdListingNaicsLoc.BdNaicsClosepopupBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "NAICS code copied successfully");
    }

    public void naicsCodepaste(){
        try{
            methods.waitForElement(3);
            methods.sendTextToElement(BdListingNaicsLoc.BdNaicsCodeTextField, Keys.chord(Keys.CONTROL,"v"));
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "NAICS code pasted successfully in NAICS text field");
        }
        catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to paste NAICS code in NAICS text field");
        }

    }

    public void returnToListingTabValidation(){
        try {
            if (methods.isElementPresent(BdListingNaicsLoc.BdReturnListTab)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Return to Listing button is visible as default");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Return to Listing button not visible as default");
                Assert.fail("Return to Listing button not visible as default");
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Return to Listing button not visible as default");
        }
    }


    public void ListingSearch(){
        methods.waitForElement(5);
        methods.sendTextToElement(BdListingNaicsLoc.BdListSearch,TestData.getData("BdSearch"));
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Search data entered in listing search field");
    }

    public void editableNameFieldBd(){
        try {
            methods.waitForElement(3);
            methods.clickElement(BdListingNaicsLoc.BdEditableFieldName);
            methods.waitForElement(5);
            methods.sendTextToElement(BdListingNaicsLoc.BdEditableInputField,TestData.getData("BdNameField") + "_" + methods.generateRandomString());
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Return to Listing button is visible as default");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Return to Listing button not visible as default");
        }
    }

    public void listingTabClick(){
        try {
            if (methods.isElementPresent(BdListingNaicsLoc.BdReturnListTab)){
                methods.waitForElement(3);
                methods.clickElement(BdListingNaicsLoc.BdReturnListTab);
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Return to Listing button is Clicked");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "failed to click listing button");
                Assert.fail();
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to click listing button");
        }
    }

    public void unsavedPopupvalidation(){
        try {
            if (methods.isElementPresent(BdListingNaicsLoc.unsavedPopupContent) && methods.isElementPresent(BdListingNaicsLoc.unsavedPopupKeepEditBtn) && methods.isElementPresent(BdListingNaicsLoc.unsavedPopupKeepGoListingBtn)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Unsaved pop up modal visible");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unsaved pop up modal not visible");
                Assert.fail();
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Unsaved pop up modal not visible");
        }
    }

    public  void goBackListingModalBtn(){
        try{
            methods.waitForElement(3);
            methods.clickElement(BdListingNaicsLoc.unsavedPopupKeepGoListingBtn);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Go Listing button clicked");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Go Listing button.");
        }

    }

    public void listingTabValidation(){
        try {
            if (methods.isElementPresent(BdListingNaicsLoc.BdlistTab)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Listing tab enabled by defaul");
            }
            else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Listing tab not visible as default");
                Assert.fail("Listing tab not visible as default");
            }
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Listing tab not visible as default");
        }
    }

    public  void goKeepEditingListingModalBtn(){
        try{
            methods.waitForElement(3);
            methods.clickElement(BdListingNaicsLoc.unsavedPopupKeepEditBtn);
            methods.waitForElement(2);
            methods.clickElement(BdListingNaicsLoc.BdSaveBtn);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Keep editing button clicked and save button clicked");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Keep editing button and save button");
        }
    }

    public void bdListingDeleteAssertion() {
        try {
            methods.waitForElement(4);
            if(methods.isElementPresent(BdListingNaicsLoc.BdListingNoFoundText)){
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Deleted BD Listing not visbible validation passed");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Deleted BD Listing still visible in grid validation failed");
        }
    }
}
