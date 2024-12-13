package org.govstack.pom.cms.subnav.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubNavLocators extends InitElements {

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Home']")
    public WebElement mainsiteEllipsisBtn;

    @FindBy(xpath = "//li[@data-element='action-create-USNPage']//span[@class='menu-label']")
    public WebElement newPage;

    @FindBy(css = "localize[key='blueprints_blankBlueprint']")
    public WebElement blankPageTemplate;

    @FindBy(css = "#headerName")
    public WebElement subnavHeadername;

    @FindBy(xpath = "//input[@id='onPageTitle']")
    public WebElement subnavContentHeading;

    @FindBy(xpath = "//input[@placeholder='Heading goes here']")
    public WebElement subnavContentSecondaryHeading;

    @FindBy(xpath = "//*[@id='tree']/ul/li/ul/li/ul//li")
    public List<WebElement> mainsiteList;

    @FindBy(xpath = "//li[@data-element='tree-item-SubNav_MainPage']//div//button[@data-element='tree-item-expand']")
    public WebElement subnavMainpageExpandBtn;

    @FindBy(xpath = "//li[@data-element='tree-item-SubNav_SubPageOne']//div//button[@data-element='tree-item-expand']")
    public WebElement subnavSubpageOneExpandBtn;

    @FindBy(xpath = "//li[@data-element='tree-item-SubNav_MainPage']/ul/li")
    public List<WebElement> subnavMainpageList;

    @FindBy(xpath = "//li[@data-element='tree-item-SubNav_SubPageOne']/ul/li")
    public List<WebElement> subnavSubpageOneList;

    @FindBy(xpath = "//umb-button-ellipsis[contains(@text,'Open context menu for SubNav_MainPage')]")
    public WebElement subnavMainpageEllipsisBtn;

    @FindBy(xpath = "//umb-button-ellipsis[contains(@text,'Open context menu for SubNav_SubPageOne')]")
    public WebElement subnavSubpageOneEllipsisBtn;

    @FindBy(xpath = "//button[@data-element='sub-view-umbInfo']")
    public WebElement info;

    @FindBy(xpath = "//a[@class='umb-outline']")
    public WebElement pageurl;

    @FindBy(xpath = "//div[@id='gs-subnav-title']//span[contains(text(),'SubNav_MainPage')]")
    public WebElement subnavMainPageFE;

    @FindBy(css = ".heading.main.base-heading")
    public WebElement subnavContentHeadingFE;

    @FindBy(css = ".secondary-heading.base-secondary-heading")
    public WebElement subnavContentSecondaryHeadingFE;

    @FindBy(xpath = "//div[@id='gs-subnav-title']") //css = " #gs-subnav-title"
    public WebElement subnavTitleFE;

    @FindBy(css = ".content-col.left-col.col-lg-8.col-12.order-1")
    public WebElement subnavContentLeftLayout;

    @FindBy(css = ".right-col.col-xl-3.col-lg-4.col-12.order-2")
    public WebElement subnavRightSideForLeftLayout;

    @FindBy(css = ".content-col.right-col.col-lg-8.col-12.order-lg-2.order-1")
    public WebElement subnavContentRightLayout;

    @FindBy(css = ".left-col.col-xl-3.col-lg-4.col-12.order-lg-1.order-2")
    public WebElement subnavLeftSideForRightLayout;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-0']") // /li[@class='with-children']
    public WebElement unexpandedSubnavSubpageOne;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-0']//button[@aria-controls='gs-subnav-dropdown-1']")
    // /li[@class='with-children']
    public WebElement unexpandedSubnavSubpageOneBtn;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-1']/li[@class='with-children']")
    public WebElement unexpandedSubnavSubpageTwo;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-1']/li[@class='with-children']//button[@aria-controls='gs-subnav-dropdown-2']")
    public WebElement unexpandedSubnavSubpageTwoBtn;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-0']/li[@class='with-children open']")
    public WebElement expandedSubnavSubpageOne;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-0']/li[@class='with-children open']//button[@aria-controls='gs-subnav-dropdown-1']")
    public WebElement expandedSubnavSubpageOneBtn;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-1']/li[@class='with-children open']")
    public WebElement expandedSubnavSubpageTwo;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-1']/li[@class='with-children open']//button[@aria-controls='gs-subnav-dropdown-2']")
    //    expanded button attribute//aria-expanded="true"
    public WebElement expandedSubnavSubpageTwoBtn;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-0']//a")
    public WebElement subnavSubpageOneLink;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-1']//a")
    public WebElement subnavSubpageTwoLink;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-2']//a")
    public WebElement subnavSubpageThreeLink;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-0']//li[@class='with-children open']//li[@class='with-children']")
    public WebElement subnavSubpageOnePlaceholder;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-0']//li[@class='with-children open']")
    public WebElement subnavSubpageOneSelectedPlaceholder;

    @FindBy(xpath = "//ol[@class='breadcrumb']") //ol[@class='breadcrumb']//li
    public WebElement subnavBreadcrumpFE;

    @FindBy(xpath = "//a[@class='gs-subnav-extended-link']")
    public WebElement subnavViewFullMenuLink;

    @FindBy(css = ".gs-subnav-extended-toggle.toggle")
    public WebElement subnavViewFullMenuBtn;

    @FindBy(xpath = "//a[@class='gs-subnav-extended-link open']")
    public WebElement subnavCloseFullMenuLink;

    @FindBy(xpath = "//button[@class='gs-subnav-extended-toggle toggle'][@aria-expanded='false']")
    public WebElement viewFullMenuBtn;

    @FindBy(xpath = "//button[@class='gs-subnav-extended-toggle toggle'][@aria-expanded='true']")
    public WebElement closeFullMenuBtn;

    @FindBy(xpath = "//ul[@class='gs-subnav gs-subnav-bottom']//ul[@id='gs-subnav-extended-menu']//li[@class='with-children']")
    public WebElement unexpandedSubnavBottomSubpageOne;

    @FindBy(xpath = "//ul[@class='gs-subnav gs-subnav-bottom']//ul[@id='gs-subnav-extended-menu']//li[@class='with-children']/button")
    public WebElement unexpandedSubnavBottomSubpageOneBtn;

    @FindBy(xpath = "//ul[@class='gs-subnav gs-subnav-bottom']//ul[@id='gs-subnav-extended-menu']//li[@class='with-children open']/button")
    public WebElement expandedSubnavBottomSubPageOneBtn;

    @FindBy(xpath = "//ul[@class='gs-subnav gs-subnav-bottom']//ul[@id='gs-subnav-extended-menu']//li[@class='with-children open']/ul")
    public WebElement subnavBottomSubpageTwo;

    @FindBy(linkText = "View Full Menu")
    public WebElement subnavViewFullMenu;

    @FindBy(linkText = "Close Full Menu")
    public WebElement subnavCloseFullMenu;

    @FindBy(xpath = "//ul[@id='gs-subnav-extended-menu']")
    public WebElement unexpandedSubnavBottomDropdown;

    @FindBy(xpath = "//ul[@id='gs-subnav-extended-menu'][@style='display: block;']")
    public WebElement expandedSubnavBottomDropdown;

    @FindBy(xpath = "//li[contains(@data-element,'tree-item-SubNav_MainPage')]")
    public WebElement subnavMainpage;

    @FindBy(xpath = "//li[contains(@data-element,'tree-item-SubNav_SubPageOne')]")
    public WebElement subnavSubpageOne;

    @FindBy(xpath = "//li[contains(@data-element,'tree-item-SubNav_SubPageTwo')]")
    public WebElement subnavSubpageTwo;

    @FindBy(xpath = "//button[contains(text(),'Navigation')]")
    public WebElement navigationTab;

    @FindBy(xpath = "//span[@id='umbracoNaviHide']")
    public WebElement hideFromAllNav;

    @FindBy(xpath = "//umb-property[@data-element='property-umbracoNaviHide']//span[@class='switcher-status'][normalize-space()='No']")
    public WebElement hideFromAllNavTextNO;

    @FindBy(xpath = "//umb-property[@data-element='property-umbracoNaviHide']//span[@class='switcher-status'][normalize-space()='YES']")
    public WebElement hideFromAllNavTexYES;

    @FindBy(xpath = "//ul[@id='gs-subnav-dropdown-0']/li/ul/li[@class='with-children']")
    public WebElement hideBtn;

}