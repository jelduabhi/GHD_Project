package org.govstack.pom.cms.contentMain.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContentMainLocators extends InitElements {

    @FindBy(xpath = "(//button[@data-element='tree-item-expand'])[1]")
    public WebElement mainSiteExpandBtn;
    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Home']/button")
    public WebElement mainPageEllipsisBtn;
    @FindBy(xpath = "//a[contains(text(),'News')]/parent::div/button")
    public WebElement newsExpandBtn;
    @FindBy(xpath = "//a[contains(text(),'Post')]")
    public WebElement postsBtn;
    @FindBy(xpath = "(//a[text()='News'])[1]")
    public WebElement selectNewsLnk;
    @FindBy(xpath = "(//a[text()='Alerts'])[1]")
    public WebElement selectAlerts;
    @FindBy(xpath = "(//a[normalize-space()='Blog'])[1]")
    public WebElement selectBlogs;
    @FindBy(xpath = "(//a[normalize-space()='Home'])[1]")
    public WebElement selectMainHome;
    @FindBy(xpath = "(//a[normalize-space()='Parsers'])[1]")
    public WebElement selectParsers;
    @FindBy(xpath = "//button[@class='btn btn-outline umb-outline']")
    public WebElement createParserBtn;
    @FindBy(xpath = "(//a[normalize-space()='Subscribe'])[1]")
    public WebElement selectSubscribe;
    @FindBy(xpath = "//a[contains(text(),'Subscribe')]/parent::div/button")
    public WebElement expandSubscribe;
    @FindBy(xpath = "(//a[normalize-space()='Confirm Subscription'])")
    public WebElement selectConfirmSubscribe;
    @FindBy(xpath = "(//a[normalize-space()='Unsubscribe'])")
    public WebElement selectUnSubscribe;
    @FindBy(xpath = "(//a[normalize-space()='Page Layout Automation'])[1]")
    public WebElement selectPageLayoutAutomation;

    @FindBy(xpath = "//a[text()='Recycle Bin']")
    public WebElement recycleBinBtn;
    @FindBy(xpath = "//a[contains(text(),'Automation Contact Directory')]/parent::div/button")
    public List<WebElement> contactDirectoryExpandBtn;
    @FindBy(xpath = "//a[contains(text(),'Contact Category Folder')]/parent::div/button")
    public List<WebElement> contactCategoryExpandBtn;
    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Automation Contact Directory']")
    public WebElement contactDirectoryEllipsisBtn;
        @FindBy(xpath = "//umb-button-ellipsis[contains(@text,'Open context menu for Contact Category Folder')]")
    public List<WebElement> contactCategoryEllipsisBtn;
    @FindBy(xpath = "(//button[@class='umb-action-link umb-outline btn-reset'])[1]")
    public WebElement contactsCategoryBtn;
    @FindBy(xpath = "(//button[@class='umb-action-link umb-outline btn-reset'])[2]")
    public WebElement contactsCategoryFolderBtn;
    @FindBy(xpath = "//a[text()='Automation Contact Lists']")
    public WebElement contactListLnk;
    @FindBy(xpath = "//li[@data-element='tree-item-Automation Testing Page QA']/div/button")
    public WebElement pageExpandLnk_QA;
    @FindBy(xpath = "//li[@data-element='tree-item-Automation Sub Nav Page']/div/button")
    public WebElement pageExpandSubNavLnk;
    @FindBy(xpath = "//li[@data-element='tree-item-Automation Testing Page STG']/div/button")
    public WebElement pageExpandLnk_STAGE;

    //For adding Page not found locator
    @FindBy(xpath = "//a[normalize-space()='Page not found']")
    public WebElement pageNotFoundBtn;

    @FindBy(xpath = "//a[contains(text(),'Search Engine Configurations')]/parent::div/button")
    public WebElement searchEngineExpandBtn;
    @FindBy(xpath = "(//span[contains(text(),'Parks & Facilities Landing Page')]/parent::button)[1]")
    public WebElement pfPage;

    @FindBy(xpath = "//a[contains(text(),'Media Manager')]/parent::div/button")
    public WebElement mediaManagerExpandBtn;
    @FindBy(xpath = "//a[contains(text(),'Media Pages')]/parent::div/button")
    public WebElement mediaPagesExpandBtn;
    @FindBy(xpath = "(//a[text()='Categories'])[1]")
    public WebElement selectMediaManagerCategories;


}
