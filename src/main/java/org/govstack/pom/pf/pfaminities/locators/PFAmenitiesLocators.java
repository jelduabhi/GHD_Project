package org.govstack.pom.pf.pfaminities.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFAmenitiesLocators extends InitElements {

    @FindBy(xpath = "//button[@class='e-lib e-btn e-control e-flat paf-amenities-grid e-icon-btn e-save-cancel e-savebutton']")
    public WebElement pfAmenitiesSaveBtn;

    @FindBy(xpath = "(//input[@placeholder='Search Amenities'])[1]")
    public WebElement pfAmenitiesSearchField;

    @FindBy(xpath = "//td[contains(.,'Automation_Amenities_')]")
    public WebElement pfAmenitiesSearchResult;

    @FindBy(xpath = "//button[@class='paf-amenities-grid e-control e-btn e-lib e-primary e-flat']")
    public WebElement pfAmenitiesOkDeleteBtn;

    @FindBy(xpath = "(//span[@class='e-btn-icon e-update e-icons'])[1]")
    public WebElement pfAmenitiesEditSaveBtn;

    //Facility Type locators
    @FindBy(xpath = "(//div[contains(text(),'Facility Types')])[1]")
    public WebElement pfFacilityTypeTab;

    @FindBy(xpath = "(//input[@placeholder='Search Facility Types'])[1]")
    public WebElement pfFacilityTypeSearchField;

    @FindBy(xpath = "//td[contains(.,'Sports')]")
    public WebElement pfFacilityTypeSearchResult;

    @FindBy(xpath = "(//td[@class='e-lastrowcell'])[1]")
    public  WebElement pfFacilityTypeNoRecord;
}