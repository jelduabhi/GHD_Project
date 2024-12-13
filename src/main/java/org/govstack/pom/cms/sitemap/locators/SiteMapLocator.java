package org.govstack.pom.cms.sitemap.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteMapLocator extends InitElements {

    @FindBy(xpath = "(//a[normalize-space()='Sitemap XML'])[1]")
    public WebElement siteMapXmlMenuList;

    @FindBy(xpath = "(//a[normalize-space()='Robots TXT'])[1]")
    public WebElement robotTxtMenuList;

    @FindBy(xpath = "(//button[@data-element='sub-view-umbInfo'])[1]")
    public WebElement infoTab;

    @FindBy(xpath = "(//span[normalize-space()='/en/sitemap-xml/'])[1]")
    public WebElement siteMapLink;

    @FindBy(xpath = "(//span[normalize-space()='/en/robots-txt/'])[1]")
    public WebElement robotTxtLink;

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Home']")
    public WebElement homeHamburgerIcon;

    @FindBy(xpath = "(//span[contains(@class,'menu-label')])[1]")
    public WebElement menuPage;

    @FindBy(xpath = "//localize[contains(@key,'blueprints_blankBlueprint')]")
    public WebElement blankPageLoc;

    @FindBy(xpath = "//input[@id='headerName']")
    public WebElement blankPageHeadingField;

    @FindBy(xpath = "(//a[normalize-space()='Subsite'])[1]")
    public WebElement subsitePageMenu;

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Subsite']")
    public WebElement subsiteHamburgerIcon;

    @FindBy(xpath = "(//span[contains(@class,'menu-label')])[2]")
    public WebElement subsiteMenuPage;


}
