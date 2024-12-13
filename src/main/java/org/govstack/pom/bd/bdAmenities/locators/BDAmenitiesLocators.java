package org.govstack.pom.bd.bdAmenities.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BDAmenitiesLocators extends InitElements {

    @FindBy(xpath = "(//div[contains(text(),'Amenities')])[1]")
    public WebElement amenitiesTab;

    @FindBy(xpath = "//span[contains(.,'Add')]")
    public WebElement amenitiesAddBtn;

    @FindBy(xpath = "//input[@id='amenities-tablename']")
    public WebElement amenitiesNameField;

    @FindBy(xpath = "//button[@class='e-lib e-btn e-control e-flat e-icon-btn e-save-cancel e-savebutton']")
    public WebElement amenitiesSaveBtn;

    @FindBy(xpath = "//span[@aria-label='dropdownlist']")
    public WebElement amenitiesStatusDropdown;

    @FindBy(xpath = "//li[contains(.,'Active')]")
    public WebElement amenitiesStatusActive;

    @FindBy(xpath = "//li[contains(.,'Inactive')]")
    public WebElement amenitiesStatusInactive;

    @FindBy(xpath = "//input[@name='amenities Search']")
    public WebElement amenitiesSearchField;

    @FindBy(xpath = "//td[contains(.,'Automation_Amenities_')]")
    public WebElement amenitiesSearchResult;

    @FindBy(xpath = "//button[@id='amenities-table_add']")
    public WebElement addAmenitiesBtnGrid;

    @FindBy(xpath = "//button[normalize-space()='Clear search']")
    public WebElement amenitiesClearBtnGrid;

    @FindBy(xpath = "//td[@class='e-rowcell']")
    public WebElement amenitiesList;

    @FindBy(xpath = "(//button[@title='Delete'])[1]")
    public WebElement amenitiesDeleteBtn;

    @FindBy(xpath = "//button[@class='e-control e-btn e-lib e-primary e-flat'][contains(.,'OK')]")
    public WebElement amenitiesOkBtn;

    @FindBy(xpath = "//h2[@class='no-item-found']")
    public WebElement amenitiesNoFoundText;

    @FindBy(xpath = "(//button[@title='Edit'])[1]")
    public WebElement amenitiesEditBtn;

    @FindBy(xpath = "(//a[@title='Go to next pager items'])[1]")
    public WebElement amenitiesThreeDotsPage;

    @FindBy(xpath = "//a[@name='Goto page2']")
    public WebElement amenitiesPage;

    @FindBy(xpath = "(//div[@class='e-filtermenudiv e-icons e-icon-filter'])[1]")
    public WebElement amenitiesStatusFunnelIcon;

//    @FindBy(xpath = "(//span[normalize-space()='Select All'])[1]")
//    public WebElement amenitiesSelectAll;

    @FindBy(xpath = "(//span[@class='e-frame e-icons e-selectall e-check'])")
    public WebElement amenitiesSelectAll;

    @FindBy(xpath = "(//span[normalize-space()='False'])[1]")
    public WebElement amenitiesFalse;

    @FindBy(xpath = "(//span[normalize-space()='True'])[1]")
    public WebElement amenitiesTrue;

    @FindBy(xpath = "(//button[normalize-space()='Filter'])[1]")
    public WebElement amenitiesFilterBtn;

    @FindBy(xpath = "(//span[@class='filter-selected'])[1]")
    public WebElement amenitiesFilterSelectedStatus;

    @FindBy(xpath = "(//div[@class='clear-filter'])[1]")
    public WebElement amenitiesFilterSelectedClearAll;

}