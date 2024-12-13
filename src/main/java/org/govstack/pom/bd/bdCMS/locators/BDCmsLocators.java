package org.govstack.pom.bd.bdCMS.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BDCmsLocators extends InitElements {

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Home']")
    public WebElement homeHamburgerIcon;

    @FindBy(xpath = "(//span[normalize-space()='Business Directory Landing Page'])[1]")
    public WebElement bdLandingPageLink;

    @FindBy(xpath = "//input[@id='headerName']")
    public WebElement bdHeaderField;

    @FindBy(xpath = "//input[@id='heading']")
    public WebElement bdHeadingField;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement bdDescriptionField;

    @FindBy(xpath = "//input[@id='placeholder']")
    public WebElement bdPlaceholderField;

    @FindBy(xpath = "(//a[contains(.,'Automation_BD_CMS_Header_')])[last()]")
    public WebElement bdMenuList;

    @FindBy(xpath = "//span[contains(.,'/en/automation_bd_cms_header_')]")
    public WebElement bdCmsDirectLink;


    @FindBy(xpath = "(//umb-button-ellipsis[contains(.,'Open context menu for Automation_BD_CMS_Header_')])[last()]")
    public WebElement bdSectorHamburgorIcon;

    @FindBy(xpath = "(//span[normalize-space()='Business Directory Sector Page'])[1]")
    public WebElement bdSectorPageCreateLink;

    @FindBy(xpath = "//a[contains(.,'Automation_BD_CMS_Header_3bcXx')][last()]/parent::div/button")
    public WebElement bdExpandBtn;

    @FindBy(xpath = "//a[contains(text(),'Automation_Sector_Page_Header_Sn5lB')]")
    public WebElement bdSectorMenuList;

    @FindBy(xpath = "(//p[normalize-space()='Accommodations'])[1]")
    public WebElement accomodateFilterCard;

    @FindBy(xpath = "//button[normalize-space()='Accommodations']")
    public WebElement accomodateFilterCardSelected;

}
