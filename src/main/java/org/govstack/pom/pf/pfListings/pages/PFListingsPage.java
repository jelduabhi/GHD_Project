package org.govstack.pom.pf.pfListings.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdListings.locators.BDListingsLocators;
import org.govstack.pom.pf.pfListings.locators.PFListingsLocators;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.testng.Assert;

public class PFListingsPage extends WebDriverManager {

    public static String listingName;
    CommonMethods methods = new CommonMethods();
    PFListingsLocators pfListingsLocators = new PFListingsLocators();
    LoginPage loginPage = new LoginPage();
    BDListingsLocators bdListingsLocators = new BDListingsLocators();

    public void pfListingsTab() {
        methods.waitForElement(4);
        methods.clickElement(pfListingsLocators.listingsTab);
        methods.waitForElement(2);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Listings tab clicked");
    }

    public void clickAddLocation(){
        methods.clickElement(pfListingsLocators.addLocationBtn);
    }

    public void clickNextBtn(){
        methods.clickElement(pfListingsLocators.nextBtn);
        methods.waitForElement(2);
    }

    public void clickSaveBtn(){
        methods.clickElement(pfListingsLocators.saveBtn);
        methods.waitForElement(2);
    }

    public void clickSaveBtnFinal(){
        methods.clickElement(pfListingsLocators.saveBtnFinal);
        methods.waitForElement(5);
    }

    public void enterGeneralDetails(){
        listingName=TestData.getData("Location Name")+"_"+methods.generateRandomString();
        methods.sendTextToElement(pfListingsLocators.locationNameTxt,listingName);
        methods.clickElement(pfListingsLocators.saveBtn);
        methods.waitForElement(2);
        methods.clickElement(pfListingsLocators.fecilityTypeDropdown);
        methods.selectValueFromList(TestData.getData("Facility Types"));
        methods.clickElement(pfListingsLocators.locationTypeDropdown);
        methods.selectValueFromList(TestData.getData("Location Types"));
    }

    public void enterAddressDetails(){
        methods.sendTextToElement(pfListingsLocators.streetTxt,TestData.getData("Street Address"));
        methods.sendTextToElement(pfListingsLocators.cityTxt,TestData.getData("City"));
        methods.clickElement(pfListingsLocators.countriesDropdown);
        methods.selectValueFromList(TestData.getData("Country"));
        methods.clickElement(pfListingsLocators.statesDropdown);
        methods.selectValueFromList(TestData.getData("State"));
        methods.sendTextToElement(pfListingsLocators.postalCodeTxt,TestData.getData("Postal Code"));
        methods.waitForElement(2);
        methods.clickElement(pfListingsLocators.locateAddressBtn);
        methods.waitForElement(3);
    }

    public void enterDetails(){
            methods.sendTextToElement(pfListingsLocators.locationDescription, TestData.getData("Description"));
            methods.clickElement(pfListingsLocators.uploadBtn);
            methods.waitForElement(5);
            methods.uploadDocument(ConfigurationManager.getPropertyValue("IMAGE_FILE_PATH"));
            methods.sendTextToElement(pfListingsLocators.phoneNumberTxt,TestData.getData("Mobile Number"));
            methods.sendTextToElement(pfListingsLocators.faxNumberTxt,TestData.getData("Fax Number"));
           // methods.sendTextToElement(pfListingsLocators.urlTxt,TestData.getData("URL"));
            methods.waitForElement(3);
    }

    public void validatePFListingCreated(){
        try {
            methods.waitForElement(4);
            methods.sendTextToElement(bdListingsLocators.listingsSearchField, listingName);
            methods.waitForElement(2);
            if(methods.getElementText(pfListingsLocators.listingTable).equals(listingName)){
                ExtentReporter.log(LogStatus.PASS,listingName+" is created");
            }else{
                ExtentReporter.log(LogStatus.FAIL,listingName+" is not created");
                Assert.fail();
            }
        }catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,listingName+" is not created");
            Assert.fail();
        }
    }

    public void searchListing() {
        listingName = TestData.getData("Listing Name");
        methods.waitForElement(4);
        methods.sendTextToElement(bdListingsLocators.listingsSearchField, "Auto");
        methods.waitForElement(2);
        methods.assertEqualsOfElementText(bdListingsLocators.listingNameRow, listingName);
        methods.assertEqualsOfElementText(bdListingsLocators.listingSectorRow, TestData.getData("Facility"));
        methods.assertEqualsOfElementText(bdListingsLocators.listingAOSRow, TestData.getData("Location"));
        methods.clickElement(bdListingsLocators.editBtn);
        methods.waitForElement(2);
    }

    public void verifyListingDetailsBackend() {
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesTxt, "Activities - Optional");
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem1, TestData.getData("Activity1"));
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem2, TestData.getData("Activity2"));
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem3, TestData.getData("Activity3"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesTxt, "Amenities - Optional");
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem1, TestData.getData("Amenity1"));
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem2, TestData.getData("Amenity2"));
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem3, TestData.getData("Amenity3"));
        methods.clickElement(bdListingsLocators.cancelBtn);
    }

    public void launchPFPageFrontEnd() {
        loginPage.launchFrontEndApplication_ParksAndFacilities();
    }

    public void verifyPFListing() {
        methods.sendTextToElement(pfListingsLocators.searchField, "Auto");
        methods.waitForElement(3);
        methods.clickElement(pfListingsLocators.applyBtn);
        methods.waitForElement(3);
        methods.assertEqualsOfElementText(pfListingsLocators.listingTitle, TestData.getData("Listing Name"));
        methods.assertEqualsOfElementText(pfListingsLocators.facilitiesType, TestData.getData("Facility"));
        methods.assertEqualsOfElementText(pfListingsLocators.installationType, TestData.getData("Location"));
        methods.assertEqualsOfElementText(pfListingsLocators.address, TestData.getData("Address"));
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem1, TestData.getData("Activity1"));
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem2, TestData.getData("Activity2"));
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem3, TestData.getData("Activity3"));
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem1, TestData.getData("Amenity1"));
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem2, TestData.getData("Amenity2"));
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem3, TestData.getData("Amenity3"));
    }

    public void verifyAdditionalDetails() {
        methods.clickElement(pfListingsLocators.listingTitleLink);
        try {
            methods.switchToWindow();
            ExtentReporter.log(LogStatus.PASS, "PF Link open in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open PF link in new tab");
        }
        methods.waitForElement(3);
        methods.assertEqualsOfElementText(pfListingsLocators.detailsViewListingTitle, TestData.getData("Listing Name"));
        methods.assertEqualsOfElementText(pfListingsLocators.facilitiesType, TestData.getData("Facility"));
        methods.assertEqualsOfElementText(pfListingsLocators.installationType, TestData.getData("Location"));
        methods.assertEqualsOfElementText(pfListingsLocators.detailsViewAddress, TestData.getData("Address"));
        Assert.assertTrue(pfListingsLocators.imageField.isDisplayed());
        methods.assertTrueForElementPresense(pfListingsLocators.imageField);
        methods.assertEqualsOfElementText(pfListingsLocators.descriptionTxt, TestData.getData("Description"));
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesAvailableTxt, "Activities available");
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem1, TestData.getData("Activity1"));
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem2, TestData.getData("Activity2"));
        methods.assertEqualsOfElementText(pfListingsLocators.activitiesItem3, TestData.getData("Activity3"));
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesAvailableTxt, "Amenities available");
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem1, TestData.getData("Amenity1"));
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem2, TestData.getData("Amenity2"));
        methods.assertEqualsOfElementText(pfListingsLocators.amenitiesItem3, TestData.getData("Amenity3"));
        methods.assertTrueForElementTextContains(pfListingsLocators.phoneTxt, TestData.getData("Phone"));
//        methods.assertEqualsOfElementText(pfListingsLocators.websiteLink, TestData.getData("Website"));
        methods.assertEqualsOfElementText(pfListingsLocators.websiteLink, "https://www.facebook.com/");
        methods.assertEqualsOfElementText(pfListingsLocators.operatingHrsTxt1, "Everyday");
        methods.assertEqualsOfElementText(pfListingsLocators.operatingHrsTxt2, "4:00 AM - 4:00 AM");
    }

    public void verifyWebsite() {
        try {
            methods.waitForElement(2);
            methods.clickElement(pfListingsLocators.websiteLink);
            methods.waitForElement(3);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("Facebook"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Website link opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open Website link in new tab");
        }
        methods.closeAndSwapToParent();
    }

    public void goBackThroughNavigationLink() {
        methods.clickElement(pfListingsLocators.pfPageNav);
        methods.waitForElement(1);
        methods.assertTrueForElementPresense(pfListingsLocators.pfHeadingTxt);
    }

    public void verifyResultCount() {
        methods.assertTrueForElementTextContains(pfListingsLocators.resultCountTxt, "1 to 10");
    }

    public void filter2SectorListings() {
        methods.clickElement(pfListingsLocators.typesFilter);
        methods.clickElement(pfListingsLocators.typesArtsCategory);
        methods.clickElement(pfListingsLocators.typesPointsOfServiceCategory);
        methods.clickElement(pfListingsLocators.applyBtn);
        methods.waitForElement(5);
        methods.assertTrueForElementTextContains(pfListingsLocators.resultCountTxt, "1 to 10");
    }

    public void addActivitiesFilter() {
        methods.clickElement(pfListingsLocators.activitiesFilter);
        methods.clickElement(pfListingsLocators.activitiesBadmintonCategory);
        methods.clickElement(pfListingsLocators.applyBtn);
        methods.waitForElement(5);
        methods.assertEqualsOfElementText(pfListingsLocators.resultCountTxt, "1 to 6 of 6 Results");
    }

    public void addAmenitiesFilter() {
        methods.clickElement(pfListingsLocators.amenitiesFilter);
        methods.clickElement(pfListingsLocators.amenitiesDivingBoardCategory);
        methods.clickElement(pfListingsLocators.applyBtn);
        methods.waitForElement(5);
        methods.assertEqualsOfElementText(pfListingsLocators.resultCountTxt, "1 to 1 of 1 Results");
    }

    public void addLocationTypesFilter() {
        methods.clickElement(pfListingsLocators.locationTypesFilter);
        methods.clickElement(pfListingsLocators.locationBeachCategory);
        methods.clickElement(pfListingsLocators.applyBtn);
        methods.waitForElement(5);
        methods.assertEqualsOfElementText(pfListingsLocators.resultCountTxt, "1 to 1 of 1 Results");
    }

    public void clearFilter() {
        methods.clickElement(pfListingsLocators.clearAllLink);
        methods.waitForElement(5);
    }

    public void verifyNoAvailableListings() {
        methods.clickElement(pfListingsLocators.locationTypesFilter);
        methods.clickElement(pfListingsLocators.locationDogParkCategory);
        methods.clickElement(pfListingsLocators.activitiesFilter);
        methods.clickElement(pfListingsLocators.activitiesBadmintonCategory);
        methods.clickElement(pfListingsLocators.applyBtn);
        methods.waitForElement(5);
        methods.assertEqualsOfElementText(pfListingsLocators.noResultsTxt, "No results found.");
    }

    public void testPagination() {
        methods.assertEqualsOfElementText(pfListingsLocators.resultsPerPageTxt, "Results per page");
//        methods.assertEqualsOfElementText(bdListingsLocators.resultsPerPageValue, "10");
        methods.selectValueFromDropdown(pfListingsLocators.resultsPerPageDropdown, "10");
        methods.waitForElement(5);
        methods.assertTrueForElementTextContains(pfListingsLocators.resultCountTxt, "1 to 10");
        Assert.assertTrue(pfListingsLocators.activeSelectedPageBtn.isDisplayed());
        methods.selectValueFromDropdown(pfListingsLocators.resultsPerPageDropdown, "5");
        methods.waitForElement(4);
        methods.assertTrueForElementTextContains(pfListingsLocators.resultCountTxt, "1 to 5");
        Assert.assertTrue(pfListingsLocators.activeSelectedPageBtn.isDisplayed());
        Assert.assertTrue(pfListingsLocators.nextPageBtn.isDisplayed());
        methods.waitForElement(3);
        methods.clickElement(pfListingsLocators.nextPageBtn);
        methods.waitForElement(3);
        methods.assertTrueForElementTextContains(pfListingsLocators.resultCountTxt, "6 to 10");
        methods.assertEqualsOfElementText(pfListingsLocators.activeSelectedPageBtn, "2");
        methods.selectValueFromDropdown(pfListingsLocators.resultsPerPageDropdown, "20");
        methods.waitForElement(4);
        methods.assertEqualsOfElementText(pfListingsLocators.activeSelectedPageBtn, "1");
        methods.assertTrueForElementNotPresent(pfListingsLocators.previousPageBtn);
        Assert.assertTrue(pfListingsLocators.nextPageBtn.isDisplayed());
        methods.clickElement(pfListingsLocators.pageSelectorBtn);
        methods.waitForElement(3);
        methods.assertTrueForElementNotPresent(pfListingsLocators.nextPageBtn);
        Assert.assertTrue(pfListingsLocators.previousPageBtn.isDisplayed());
        methods.clickElement(pfListingsLocators.previousPageBtn);
        methods.waitForElement(2);
        Assert.assertTrue(pfListingsLocators.autoListingTxt.isDisplayed());
    }


}
