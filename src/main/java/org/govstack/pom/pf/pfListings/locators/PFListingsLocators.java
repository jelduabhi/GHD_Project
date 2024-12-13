package org.govstack.pom.pf.pfListings.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PFListingsLocators extends InitElements {

    @FindBy(xpath = "//div[contains(text(),'Listings')]")
    public WebElement listingsTab;

    /** General Details **/
    @FindBy(xpath="//button[@class='e-control e-btn e-lib e-primary']")
    public WebElement addLocationBtn;
    @FindBy(id="inplace_editor_editor")
    public WebElement locationNameTxt;
    @FindBy(xpath = "//button[@Title='Save']")
    public WebElement saveBtn;
    @FindBy(xpath = "(//button[text()='Save'])[2]")
    public WebElement saveBtnFinal;
    @FindBy(xpath="(//span[@aria-label='dropdownlist'])[1]")
    public WebElement fecilityTypeDropdown;
    @FindBy(xpath="(//span[@aria-label='dropdownlist'])[2]")
    public WebElement locationTypeDropdown;
    @FindBy(xpath="//button[@class='e-control e-btn e-lib e-primary']")
    public WebElement nextBtn;

    /** Address Details **/
    @FindBy(xpath="//input[@aria-label='Street Address']")
    public WebElement streetTxt;
    @FindBy(xpath="//input[@aria-label='City']")
    public WebElement cityTxt;
    @FindBy(xpath="//span[@aria-labelledby=\"countries_hidden\"]")
    public WebElement countriesDropdown;
    @FindBy(xpath="//span[@aria-labelledby=\"states_hidden\"]")
    public WebElement statesDropdown;
    @FindBy(xpath="//input[@aria-label='Zip Code/Postal Code']")
    public WebElement postalCodeTxt;
    @FindBy(xpath="//button[text()='Locate Address']")
    public WebElement locateAddressBtn;

    /** Address Details **/
    @FindBy(xpath="//textarea[@name=\"location-description\"]")
    public WebElement locationDescription;
    @FindBy(xpath="//button[text()='Click to upload']")
    public WebElement uploadBtn;

    @FindBy(xpath = "//input[@placeholder='Enter phone number']")
    public WebElement phoneNumberTxt;

    @FindBy(xpath = "//input[@placeholder='Enter fax number']")
    public WebElement faxNumberTxt;

    @FindBy(xpath = "//input[@aria-label='URL']")
    public WebElement urlTxt;

    @FindBy(xpath = "(//p[contains(text(),'Activities')])")
    public WebElement activitiesTxt;

    @FindBy(xpath = "(//span[contains(text(),'Badminton')])")
    public WebElement activitiesItem1;

    @FindBy(xpath = "(//span[contains(text(),'Swimming')])")
    public WebElement activitiesItem2;

    @FindBy(xpath = "(//span[contains(text(),'Picnic')])")
    public WebElement activitiesItem3;

    @FindBy(xpath = "(//span[contains(text(),'Diving Board')])")
    public WebElement amenitiesItem1;

    @FindBy(xpath = "(//span[contains(text(),'Free Parking')])")
    public WebElement amenitiesItem2;

    @FindBy(xpath = "(//span[contains(text(),'Hot Tub')])")
    public WebElement amenitiesItem3;

    // Front End Page
    @FindBy(css = "input#search")
    public WebElement searchField;

    @FindBy(xpath = "//input[@class='pf-filters-search-submit']")
    public WebElement applyBtn;

    @FindBy(xpath = "//span[@class='pf-location-title']")
    public WebElement listingTitle;

    @FindBy(xpath = "//span[@class='pf-facilities-type']")
    public WebElement facilitiesType;

    @FindBy(xpath = "//span[@class='pf-installation-type']")
    public WebElement installationType;

    @FindBy(xpath = "//span[@class='pf-address']")
    public WebElement address;

    @FindBy(xpath = "//h1[@class='heading main base-heading']")
    public WebElement detailsViewListingTitle;

    @FindBy(xpath = "//p[@class='pf-address']")
    public WebElement detailsViewAddress;

    @FindBy(xpath = "//span[@class='pf-location-title']")
    public WebElement listingTitleLink;

//    @FindBy(xpath = "//img[@src='https://ghdsacacstntghu0000022.ghdcdn.com/media/ParksAndFacilities/57049FE5-E07F-4C50-9545-BEB4BA02D488.jpg']")
    @FindBy(xpath = "//div[@class='pf-location-image']")
    public WebElement imageField;

    @FindBy(xpath = "(//p[contains(text(),'Beach Park Test')])")
    public WebElement descriptionTxt;

    @FindBy(xpath = "//h2[@class='pf-tag-activity']")
    public WebElement activitiesAvailableTxt;

    @FindBy(xpath = "//h2[@class='pf-tag-amenity']")
    public WebElement amenitiesAvailableTxt;

    @FindBy(xpath = "//div[@class='pf-locaton-phone']")
    public WebElement phoneTxt;

    @FindBy(xpath = "(//a[contains(text(),'facebook')])")
    public WebElement websiteLink;

    @FindBy(xpath = "(//td[contains(text(),'Everyday')])")
    public WebElement operatingHrsTxt1;

    @FindBy(xpath = "(//td[contains(text(),'4:00')])")
    public WebElement operatingHrsTxt2;

    @FindBy(xpath = "//div[@class='row']//h2")
    public WebElement pfHeadingTxt;

    @FindBy(xpath = "(//li[@class='breadcrumb-item'])[2]")
    public WebElement pfPageNav;

    @FindBy(xpath = "//span[@class='pf-filters-results-count']")
    public WebElement resultCountTxt;

    @FindBy(xpath = "(//button[@class='pf-filters-category'])[1]")
    public WebElement typesFilter;

    @FindBy(xpath = "(//button[@class='pf-filters-category'])[2]")
    public WebElement locationTypesFilter;

    @FindBy(xpath = "(//button[@class='pf-filters-category'])[3]")
    public WebElement activitiesFilter;

    @FindBy(xpath = "(//button[@class='pf-filters-category'])[4]")
    public WebElement amenitiesFilter;

    @FindBy(xpath = "//input[@parkname='Arts, Community and Culture']")
    public WebElement typesArtsCategory;

    @FindBy(xpath = "//input[@parkname='Points of Service']")
    public WebElement typesPointsOfServiceCategory;

    @FindBy(xpath = "//input[@parkname='Badminton']")
    public WebElement activitiesBadmintonCategory;

    @FindBy(xpath = "//input[@parkname='Diving Board']")
    public WebElement amenitiesDivingBoardCategory;

    @FindBy(xpath = "//input[@parkname='Beach']")
    public WebElement locationBeachCategory;

    @FindBy(xpath = "//input[@parkname='Dog Park']")
    public WebElement locationDogParkCategory;

    @FindBy(xpath = "//div[@class='gs-feed-body']")
    public WebElement noResultsTxt;

    @FindBy(xpath = "//button[@class='pf-filters-clear']")
    public WebElement clearAllLink;

    @FindBy(xpath = "//div[@class='pf-list-itemsViewed']//label")
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

    @FindBy(xpath = "//a[@title='Click to open Auto PF Test do not delete']")
    public WebElement autoListingTxt;

    @FindBy(xpath = "//*[@id=\"paf-installations-table_content_table\"]/tbody/tr/td[2]")
    public WebElement listingTable;

}
