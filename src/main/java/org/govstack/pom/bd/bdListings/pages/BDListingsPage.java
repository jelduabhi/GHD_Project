package org.govstack.pom.bd.bdListings.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdListings.locators.BDListingsLocators;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.parserPage.locators.ParserPageLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.testng.Assert;

public class BDListingsPage extends WebDriverManager {

    public static String listingName;
    CommonMethods methods = new CommonMethods();
    BDListingsLocators bdListingsLocators = new BDListingsLocators();
    LoginPage loginPage = new LoginPage();
    ParserPageLocators parserLocators = new ParserPageLocators();

    public void bdListingsTab() {
        methods.waitForElement(4);
        methods.clickElement(bdListingsLocators.listingsTab);
        methods.waitForElement(4);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Listings tab clicked");
    }

    public void searchListing() {
        listingName = TestData.getData("Listing Name");
        methods.sendTextToElement(bdListingsLocators.listingsSearchField, "A Listing");
        methods.waitForElement(3);
        methods.assertEqualsOfElementText(bdListingsLocators.listingNameRow, listingName);
        methods.assertEqualsOfElementText(bdListingsLocators.listingSectorRow, TestData.getData("Sector"));
        methods.assertEqualsOfElementText(bdListingsLocators.listingAOSRow, TestData.getData("AOS"));
        methods.clickElement(bdListingsLocators.editBtn);
        methods.waitForElement(2);
    }

    public void verifyListingDetailsBackend() {
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesTxt, "Amenities - Optional");
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem1, TestData.getData("Amenity1"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem2, TestData.getData("Amenity2"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem3, TestData.getData("Amenity3"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem4, TestData.getData("Amenity4"));
        methods.clickElement(bdListingsLocators.cancelBtn);
    }

    public void launchBDPageFrontEnd() {
        loginPage.launchFrontEndApplication_BusinessDirectory();
    }

    public void acceptCookies() {
        methods.clickElement(parserLocators.acceptCookiesBtn);
    }

    public void verifyBDListing() {
        methods.waitForElement(3);
        methods.sendTextToElement(bdListingsLocators.searchField, "A Listing");
        methods.clickElement(bdListingsLocators.applyBtn);
        methods.waitForElement(3);
        methods.assertEqualsOfElementText(bdListingsLocators.listingTitle, TestData.getData("Listing Name"));
        methods.assertEqualsOfElementText(bdListingsLocators.facilitiesType, TestData.getData("Sector"));
        methods.assertEqualsOfElementText(bdListingsLocators.installationType, TestData.getData("AOS"));
        methods.assertEqualsOfElementText(bdListingsLocators.address, TestData.getData("Address"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem1, TestData.getData("Amenity1"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem2, TestData.getData("Amenity2"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem3, TestData.getData("Amenity3"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem4, TestData.getData("Amenity4"));
    }

    public void verifyAdditionalDetails() {
        methods.clickElement(bdListingsLocators.listingTitleLink);
        methods.assertEqualsOfElementText(bdListingsLocators.facilitiesType, TestData.getData("Sector"));
        methods.assertEqualsOfElementText(bdListingsLocators.installationType, TestData.getData("AOS"));
        methods.assertEqualsOfElementText(bdListingsLocators.detailsAddress, TestData.getData("Address"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem1, TestData.getData("Amenity1"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem2, TestData.getData("Amenity2"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem3, TestData.getData("Amenity3"));
        methods.assertEqualsOfElementText(bdListingsLocators.amenitiesItem4, TestData.getData("Amenity4"));
        Assert.assertTrue(bdListingsLocators.imageField.isDisplayed());
        methods.assertTrueForElementPresense(bdListingsLocators.imageField);
        methods.assertTrueForElementTextContains(bdListingsLocators.descriptionTxt, TestData.getData("Description"));
        methods.assertTrueForElementTextContains(bdListingsLocators.phoneTxt, TestData.getData("Phone"));
        methods.assertTrueForElementTextContains(bdListingsLocators.faxTxt, TestData.getData("Fax"));
        methods.assertEqualsOfElementText(bdListingsLocators.websiteTxt, TestData.getData("Website"));
        methods.assertEqualsOfElementText(bdListingsLocators.emailTxt, TestData.getData("Email"));
        methods.assertEqualsOfElementText(bdListingsLocators.operatingHrsTxt1, "Everyday");
        methods.assertEqualsOfElementText(bdListingsLocators.operatingHrsTxt2, "12:00 AM - 12:00 AM");
    }

    public void verifyWebsite() {
        try {
            methods.waitForElement(2);
            methods.clickElement(bdListingsLocators.websiteLink);
            methods.waitForElement(3);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("Shangri-La"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Website link opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open Website link in new tab");
        }
        methods.closeAndSwapToParent();
    }

    public void backToBusinessListings() {
        methods.waitForElement(2);
        methods.scrollAndClickElement(bdListingsLocators.backToListingsBtn);
        methods.waitForElement(2);
        methods.assertTrueForElementPresense(bdListingsLocators.bdHeadingTxt);
    }

    public void searchListingFrontEnd() {
        methods.waitForElement(3);
        methods.sendTextToElement(bdListingsLocators.searchField, "A Listing");
        methods.clickElement(bdListingsLocators.applyBtn);
        methods.waitForElement(3);
        methods.assertEqualsOfElementText(bdListingsLocators.resultCountTxt, "1 to 1 of 1 Results");
        methods.clickElement(bdListingsLocators.listingTitleLink);
    }

    public void verifyResultCount() {
        methods.waitForElement(3);
        methods.assertTrueForElementTextContains(bdListingsLocators.resultCountTxt, "1 to 10");
    }

    public void verifyFBIcon() {
        try {
            methods.waitForElement(2);
            methods.clickElement(bdListingsLocators.facebookIcon);
            methods.waitForElement(3);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("Facebook"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Social link opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open Social link in new tab");
        }
        methods.closeAndSwapToParent();
    }

    public void verifyTwitterIcon() {
        try {
            methods.waitForElement(2);
            methods.clickElement(bdListingsLocators.twitterIcon);
            methods.waitForElement(3);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("x"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Social link opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open Social link in new tab");
        }
        methods.closeAndSwapToParent();
    }

    public void verifyYoutubeIcon() {
        try {
            methods.waitForElement(2);
            methods.clickElement(bdListingsLocators.youtubeIcon);
            methods.waitForElement(3);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("YouTube"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Social link opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open Social link in new tab");
        }
        methods.closeAndSwapToParent();
    }

    public void verifyIGIcon() {
        try {
            methods.waitForElement(2);
            methods.clickElement(bdListingsLocators.instagramIcon);
            methods.waitForElement(3);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("instagram"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Social link opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open Social link in new tab");
        }
        methods.closeAndSwapToParent();
    }

    public void verifyTiktokIcon() {
        try {
            methods.waitForElement(2);
            methods.clickElement(bdListingsLocators.tiktokIcon);
            methods.waitForElement(3);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("tiktok"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Social link opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open Social link in new tab");
        }
        methods.closeAndSwapToParent();
    }

    public void goBackThroughNavigationLink() {
        methods.clickElement(bdListingsLocators.bdPageNav);
        methods.waitForElement(1);
        methods.assertTrueForElementPresense(bdListingsLocators.bdHeadingTxt);
    }

    public void filter2SectorListings() {
        methods.clickElement(bdListingsLocators.sectorsFilter);
        methods.clickElement(bdListingsLocators.sectorAccommodationsCategory);
        methods.clickElement(bdListingsLocators.sectorConstructionCategory);
        methods.clickElement(bdListingsLocators.applyBtn);
        methods.waitForElement(2);
        methods.assertEqualsOfElementText(bdListingsLocators.resultCountTxt, "1 to 7 of 7 Results");
        methods.assertTrueForElementNotPresent(bdListingsLocators.nextPageBtn);
    }

    public void addAmenitiesFilter() {
        methods.clickElement(bdListingsLocators.amenitiesFilter);
        methods.clickElement(bdListingsLocators.amenitiesFreeWifiCategory);
        methods.clickElement(bdListingsLocators.applyBtn);
        methods.waitForElement(1);
        methods.assertEqualsOfElementText(bdListingsLocators.resultCountTxt, "1 to 7 of 7 Results");
    }

    public void addAOSFilter() {
        methods.clickElement(bdListingsLocators.aosFilter);
        methods.clickElement(bdListingsLocators.aosBedandBreakfastsCategory);
        methods.clickElement(bdListingsLocators.applyBtn);
        methods.waitForElement(1);
        methods.assertEqualsOfElementText(bdListingsLocators.resultCountTxt, "1 to 5 of 5 Results");
    }

    public void clearFilter() {
        methods.clickElement(bdListingsLocators.clearAllLink);
        methods.waitForElement(2);
    }

    public void verifyNoAvailableListings() {
        methods.clickElement(bdListingsLocators.sectorsFilter);
        methods.clickElement(bdListingsLocators.sectorAccommodationsCategory);
        methods.clickElement(bdListingsLocators.aosFilter);
        methods.clickElement(bdListingsLocators.aosAirportCategory);
        methods.clickElement(bdListingsLocators.amenitiesFilter);
        methods.clickElement(bdListingsLocators.amenitiesAccessibleAccessCategory);
        methods.clickElement(bdListingsLocators.applyBtn);
        methods.waitForElement(4);
        methods.assertEqualsOfElementText(bdListingsLocators.noResultsTxt, "No results found.");
    }

    public void testResultsPerPage() {
        methods.waitForElement(3);
        methods.sendTextToElement(bdListingsLocators.searchField, "Test");
        methods.clickElement(bdListingsLocators.applyBtn);
        methods.waitForElement(1);
        methods.assertEqualsOfElementText(bdListingsLocators.resultsPerPageTxt, "Results per page");
        methods.selectValueFromDropdown(bdListingsLocators.resultsPerPageDropdown, "10");
        methods.waitForElement(3);
        methods.assertTrueForElementTextContains(bdListingsLocators.resultCountTxt, "1 to 10");
        Assert.assertTrue(bdListingsLocators.activeSelectedPageBtn.isDisplayed());
        methods.selectValueFromDropdown(bdListingsLocators.resultsPerPageDropdown, "5");
        methods.waitForElement(3);
        methods.assertTrueForElementTextContains(bdListingsLocators.resultCountTxt, "1 to 5");
        Assert.assertTrue(bdListingsLocators.activeSelectedPageBtn.isDisplayed());
        methods.selectValueFromDropdown(bdListingsLocators.resultsPerPageDropdown, "20");
        methods.waitForElement(3);
        methods.assertTrueForElementTextContains(bdListingsLocators.resultCountTxt, "1 to 20");
        Assert.assertTrue(bdListingsLocators.nextPageBtn.isDisplayed());
        methods.clickElement(bdListingsLocators.nextPageBtn);
        methods.waitForElement(2);
        methods.assertTrueForElementNotPresent(bdListingsLocators.autoListingTxt);
        methods.assertEqualsOfElementText(bdListingsLocators.activeSelectedPageBtn, "2");
        Assert.assertTrue(bdListingsLocators.previousPageBtn.isDisplayed());
        methods.clickElement(bdListingsLocators.previousPageBtn);
        methods.waitForElement(2);
        Assert.assertTrue(bdListingsLocators.autoListingTxt.isDisplayed());
        methods.assertEqualsOfElementText(bdListingsLocators.activeSelectedPageBtn, "1");
        methods.assertTrueForElementNotPresent(bdListingsLocators.previousPageBtn);
        methods.clickElement(bdListingsLocators.pageSelectorBtn);
        methods.waitForElement(3);
        methods.assertEqualsOfElementText(bdListingsLocators.activeSelectedPageBtn, "2");
    }
}
