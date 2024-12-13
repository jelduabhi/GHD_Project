package org.govstack.pom.pf.pfactivities.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PFActivityLocators extends InitElements {

    @FindBy(xpath = "//div[text()='Activities']")
    public WebElement activitiesLnk;
    @FindBy(xpath = "//button[@aria-label=\"Add\"]")
    public WebElement addBtn;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement pfActivityNameField;
    @FindBy(xpath = "//span[@aria-label='dropdownlist']")
    public WebElement activityStatusDropdown;
    @FindBy(xpath = "//li[contains(text(),'No')]")
    public WebElement pfStatusNo;
    @FindBy(xpath = "//li[contains(text(),'Yes')]")
    public WebElement pfStatusYes;
    @FindBy(xpath = "//table[@class='e-table']/tbody/tr/td[2]")
    public List<WebElement> activityTable;
    @FindBy(xpath = "//button[@class=\"e-lib e-btn e-control e-flat paf-activities-grid e-icon-btn e-save-cancel e-savebutton\"]")
    public WebElement pfActivitySaveBtn;
    @FindBy(xpath = "//div[@id='paf-activities-tableEditConfirm']/div[2]/button[1]")
    public WebElement deleteConfirmBtn;
    @FindBy(name="activities Search")
    public WebElement searchTxt;
    @FindBy(xpath="//span[@class='e-headertext']")
    public List<WebElement> activityTableTitleLbl;
    @FindBy(xpath = "//div[@e-mappinguid=\"e-flmenu-grid-column2\"]")
    public WebElement activeFilter;
    @FindBy(xpath="//span[@class='e-frame e-icons e-selectall e-check']")
    public WebElement selectAll;
    @FindBy(xpath="//span[@class='e-frame e-icons e-selectall e-stop']")
    public WebElement selectAllStop;
    @FindBy(xpath="//span[text()='True']")
    public WebElement trueCheckBox;
    @FindBy(xpath="//span[text()='False']")
    public WebElement falseCheckBox;
    @FindBy(xpath = "//button[text()='Filter']")
    public WebElement filterButton;
    @FindBy(xpath = "//input[@class='e-control e-switch e-lib']")
    public List<WebElement> activeStatusBtn;
    @FindBy(xpath = "//div[@e-mappinguid=\"e-flmenu-grid-column3\"]")
    public WebElement systemDefaultFilter;
    @FindBy(xpath = "//span[@class='e-icons e-lock']")
    public List<WebElement> systemDefaultLock;
    @FindBy(xpath = "//span[text()='Count']/parent::div/following-sibling::div")
    public WebElement countFilter;
    @FindBy(xpath = "(//span[@class='e-switch-inner'])[1]")
    public WebElement activeOnBtn;
    @FindBy(xpath = "(//span[@class='e-switch-inner e-switch-active'])[1]")
    public WebElement activeOffBtn;
}
