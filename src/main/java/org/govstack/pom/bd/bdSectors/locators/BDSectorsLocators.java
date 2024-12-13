package org.govstack.pom.bd.bdSectors.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BDSectorsLocators extends InitElements {

    @FindBy(xpath = "(//div[contains(text(),'Sectors')])[1]")
    public WebElement sectorsTab;
    @FindBy(xpath = "(//input[@placeholder='Search Sectors'])[1]")
    public WebElement sectorsSearchField;

    @FindBy(xpath = "//td[@data-colindex='1']")
    public WebElement sectorsSearchResult;

    @FindBy(xpath = "//div[@class='e-switch-wrapper e-wrapper']")
    public  WebElement sectorToggle;

    @FindBy(xpath = "(//td[@class='e-detailrowcollapse e-lastrowcell'])[1]")
    public WebElement sectorExpand;

    @FindBy(xpath = "(//td[@class='e-lastrowcell e-detailrowexpand'])[1]")
    public WebElement sectorCollapse;

    @FindBy(xpath = "(//span[normalize-space()='Add Area of service'])[1]")
    public  WebElement sectorAreaOfServiceBtn;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement sectorNameField;

    @FindBy(xpath = "//button[@class='e-lib e-btn e-control e-flat e-icon-btn e-save-cancel e-savebutton']")
    public WebElement sectorSaveBtn;

    @FindBy(xpath = "(//span[@class='e-input-group-icon e-ddl-icon e-search-icon'])[1]")
    public WebElement sectorStatusDropdown;

    @FindBy(xpath = "//li[contains(.,'Yes')]")
    public WebElement sectorStatusYes;

    @FindBy(xpath = "//li[contains(.,'No')]")
    public WebElement sectorStatusNo;

    @FindBy(xpath = "//td[contains(.,'Automation_Sectors_')]")
    public WebElement sectorListValidation;

    @FindBy(xpath = "//td[contains(.,'Automation_Sectors_Update_')]")
    public WebElement sectorListUpdateValidation;

    @FindBy(xpath = "(//span[@class='e-btn-icon e-trash e-icons'])[last()]")
    public  WebElement sectorDeleteIcon;

    @FindBy(xpath = "(//button[@class='e-control e-btn e-lib e-primary e-flat'])[2]")
    public  WebElement sectorDeleteOkBtn;

    @FindBy(xpath = "(//span[@class='e-btn-icon e-edit e-icons'])[last()]")
    public  WebElement sectorEditIcon;

}