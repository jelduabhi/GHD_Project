package org.govstack.pom.bd.bdListings.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BDListingsLocators extends InitElements {

    @FindBy(xpath = "(//div[contains(text(),'Listings')])")
    public WebElement listingsTab;

    @FindBy(xpath = "//input[@name='listings Search']")
    public WebElement listingsSearchField;

    @FindBy(xpath = "//td[@data-colindex='1']")
    public WebElement listingNameRow;

    @FindBy(xpath = "//td[@data-colindex='2']")
    public WebElement listingSectorRow;

    @FindBy(xpath = "//td[@data-colindex='3']")
    public WebElement listingAOSRow;

    @FindBy(xpath = "//button[@title='Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "(//p[contains(text(),'Amenities')])")
    public WebElement amenitiesTxt;

    @FindBy(xpath = "(//span[contains(text(),'Play Areas')])")
    public WebElement amenitiesItem1;

    @FindBy(xpath = "(//span[contains(text(),'Pet-Friendly')])")
    public WebElement amenitiesItem2;

    @FindBy(xpath = "(//span[contains(text(),'Family Events')])")
    public WebElement amenitiesItem3;

    @FindBy(xpath = "(//span[contains(text(),'Free Wi-Fi')])")
    public WebElement amenitiesItem4;

    @FindBy(xpath = "(//button[@class='e-control e-btn e-lib e-outline'])[1]")
    public WebElement cancelBtn;

    // Front End Page
    @FindBy(css = "input#bdSearch")
    public WebElement searchField;

    @FindBy(xpath = "//input[@class='bd-filters-search-submit']")
    public WebElement applyBtn;

    @FindBy(xpath = "//span[@class='bd-location-title']")
    public WebElement listingTitle;

    @FindBy(xpath = "//span[@class='bd-facilities-type']")
    public WebElement facilitiesType;

    @FindBy(xpath = "//span[@class='bd-installation-type']")
    public WebElement installationType;

    @FindBy(xpath = "//span[@class='bd-address']")
    public WebElement address;

    @FindBy(xpath = "//p[@class='bd-address']")
    public WebElement detailsAddress;

    @FindBy(xpath = "//span[@class='bd-location-title']")
    public WebElement listingTitleLink;

//    @FindBy(xpath = "//img[@src='https://ghdsacacstntghu0000022.ghdcdn.com/media/BusinessDirectory/341FB5FD-745B-4378-8C66-47DB1E1D7A47.png']")
//    public WebElement imageField;
    @FindBy(xpath = "//div[@class='bd-location-image']")
    public WebElement imageField;

    @FindBy(xpath = "(//p[contains(text(),'Auto Listing')])")
    public WebElement descriptionTxt;

//    @FindBy(xpath = "//a[@href='tel:6321234567']")
//    public WebElement phoneTxt;
    @FindBy(xpath = "//div[@class='bd-location-phone']")
    public WebElement phoneTxt;

    @FindBy(xpath = "//div[@class='bd-location-fax']")
    public WebElement faxTxt;

    @FindBy(xpath = "//div[@class='bd-location-website']")
    public WebElement websiteTxt;

    @FindBy(xpath = "(//a[contains(text(),'shang')])")
    public WebElement websiteLink;

    @FindBy(xpath = "//div[@class='bd-location-email']")
    public WebElement emailTxt;

//    @FindBy(xpath = "//table[@class='bd-location-hours']//td[1]")
    @FindBy(xpath = "(//td[contains(text(),'Everyday')])")
    public WebElement operatingHrsTxt1;

//    @FindBy(xpath = "//table[@class='bd-location-hours']//td[2]")
    @FindBy(xpath = "(//td[contains(text(),'12:00')])")
    public WebElement operatingHrsTxt2;

    @FindBy(xpath = "//a[@class='bd-backToListing']")
    public WebElement backToListingsBtn;

    @FindBy(xpath = "//div[@class='row']//h2")
    public WebElement bdHeadingTxt;

    @FindBy(css = "a.facebook.icon")
    public WebElement facebookIcon;

    @FindBy(css = "a.twitter.icon")
    public WebElement twitterIcon;

    @FindBy(css = "a.youtube.icon")
    public WebElement youtubeIcon;

    @FindBy(css = "a.instagram.icon")
    public WebElement instagramIcon;

    @FindBy(css = "a.tiktok.icon")
    public WebElement tiktokIcon;

    @FindBy(xpath = "(//li[@class='breadcrumb-item'])[2]")
    public WebElement bdPageNav;

    @FindBy(xpath = "//span[@class='bd-filters-results-count']")
    public WebElement resultCountTxt;

//    @FindBy(xpath = "(//button[@class='bd-filters-category'])[1]")
    @FindBy(xpath = "(//span[contains(text(),'Sectors')])")
    public WebElement sectorsFilter;

    @FindBy(xpath = "(//span[contains(text(),'Areas of Service')])")
    public WebElement aosFilter;

    @FindBy(xpath = "(//span[contains(text(),'Amenities')])")
    public WebElement amenitiesFilter;

    @FindBy(xpath = "//input[@directoryname='Accommodations']")
    public WebElement sectorAccommodationsCategory;

    @FindBy(xpath = "//input[@directoryname='Construction']")
    public WebElement sectorConstructionCategory;

    @FindBy(xpath = "//input[@directoryname='Free Wi-Fi']")
    public WebElement amenitiesFreeWifiCategory;

    @FindBy(xpath = "//input[@directoryname='Bed and Breakfasts']")
    public WebElement aosBedandBreakfastsCategory;

    @FindBy(xpath = "//input[@directoryname='Airport']")
    public WebElement aosAirportCategory;

    @FindBy(xpath = "//input[@directoryname='Accessible Access']")
    public WebElement amenitiesAccessibleAccessCategory;

    @FindBy(xpath = "//div[@class='gs-feed-body']")
    public WebElement noResultsTxt;

    @FindBy(xpath = "//button[@class='bd-filters-clear']")
    public WebElement clearAllLink;

    @FindBy(xpath = "//div[@class='bd-list-itemsViewed']//label")
    public WebElement resultsPerPageTxt;

//    @FindBy(xpath = "//div[@class='select-wrapper']")
//    public WebElement resultsPerPageValue;

    @FindBy(xpath = "//select[@id='pageSizeSelect']")
    public WebElement resultsPerPageDropdown;

    @FindBy(xpath = "(//li[@class='page-item '])")
    public WebElement pageSelectorBtn;

    @FindBy(xpath = "(//li[@class='page-item next'])")
    public WebElement nextPageBtn;

    @FindBy(xpath = "(//li[@class='page-item prev'])")
    public WebElement previousPageBtn;

    @FindBy(xpath = "(//li[@class='page-item active disabled'])")
    public WebElement activeSelectedPageBtn;

    @FindBy(xpath = "//a[@title='Click to open A Listing Test do not delete']")
    public WebElement autoListingTxt;

}
