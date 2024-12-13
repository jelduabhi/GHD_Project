package org.govstack.pom.pf.pfLocationType.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFLocationTypeLocators extends InitElements {

    @FindBy(xpath = "(//div[contains(text(),'Location Types')])[1]")
    public WebElement pfLocationTypeTab;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement pfLocationTypeNameField;

    @FindBy(xpath = "//li[contains(text(),'No')]")
    public WebElement pfLocationTypeStatusNo;

    @FindBy(xpath = "//li[contains(text(),'Yes')]")
    public WebElement pfLocationTypeStatusYes;

    @FindBy(xpath = "//button[@class='e-lib e-btn e-control e-flat paf-installations-grid e-icon-btn e-save-cancel e-savebutton']")
    public WebElement pfLocationTypeSaveBtn;

    @FindBy(xpath = "(//input[@placeholder='Search Location Types'])[1]")
    public WebElement pfLocationTypeSearchField;

    @FindBy(xpath = "//td[contains(.,'Automation_LocationType_')]")
    public WebElement pfLocationTypeSearchResult;

    @FindBy(xpath = "(//button[@title='Delete'])[1]")
    public WebElement pfLocationTypeDeleteBtn;

    @FindBy(xpath = "//button[@class='paf-installations-grid e-control e-btn e-lib e-primary e-flat']")
    public WebElement pfLocationTypeOkBtn;

    @FindBy(xpath = "//td[contains(.,'No records to display')]")
    public WebElement pfLocationTypeNoFoundText;

    @FindBy(xpath = "(//span[@class='e-btn-icon e-update e-icons'])[1]")
    public WebElement pfLocationTypeEditSaveBtn;


}
