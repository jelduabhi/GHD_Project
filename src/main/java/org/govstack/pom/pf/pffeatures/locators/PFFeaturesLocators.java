package org.govstack.pom.pf.pffeatures.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PFFeaturesLocators extends InitElements {

    @FindBy(xpath = "//input[@name='name']")
    public WebElement pfFeaturesNameField;

    @FindBy(xpath = "//li[contains(text(),'No')]")
    public WebElement pfStatusNo;

    @FindBy(xpath = "//li[contains(text(),'Yes')]")
    public WebElement pfStatusYes;

    @FindBy(xpath = "//button[@class='e-lib e-btn e-control e-flat paf-features-grid e-icon-btn e-save-cancel e-savebutton']")
    public WebElement pfSaveBtn;

    @FindBy(xpath = "(//input[@placeholder='Search Features'])[1]")
    public WebElement pfFeaturesSearchField;

    @FindBy(xpath = "//td[contains(.,'Automation_Features_')]")
    public WebElement pffeaturesSearchResult;

    @FindBy(xpath = "//button[@class='paf-features-grid e-control e-btn e-lib e-primary e-flat']")
    public WebElement pfOkDeleteBtn;

    @FindBy(xpath = "//td[contains(.,'No records to display')]")
    public WebElement pfNoRecordFound;
}
