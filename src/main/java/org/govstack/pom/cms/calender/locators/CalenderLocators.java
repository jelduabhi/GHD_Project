package org.govstack.pom.cms.calender.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalenderLocators extends InitElements {
    @FindBy(xpath = "//div[@aria-label=\"Search for option\"]")
    public WebElement clientName;
    @FindBy(xpath = "//button[@class=\"btn pull-right btn-primary\"]")
    public WebElement nextOrSubmitBtn;
    @FindBy(xpath = "//input[@aria-label='CalendarId']")
    public WebElement calenderIdTxt;
    @FindBy(xpath = "//a[text()='Custom Integrations']")
    public WebElement customIntegrationLnk;
    @FindBy(xpath = "(//strong)[1]")
    public WebElement successMessage;
    @FindBy(xpath = "(//button[@class='umb-action-link umb-outline btn-reset'])[1]")
    public WebElement createPageBtn;
    @FindBy(xpath = "//localize[text()='Blank']/parent::span/parent::button")
    public WebElement blankPageBtn;
    @FindBy(id="button_mainContent")
    public WebElement mainContentAddBtn;
    @FindBy(id="block-search")
    public WebElement searchTxt;
    @FindBy(xpath = "//umb-block-card/div/div")
    public WebElement blockCardLnk;
    @FindBy(xpath = "//div[@class=\"umb-editors\"]//div[@class=\"umb-editor-container umb-panel-body umb-scrollable row-fluid\"]//li[2]//button[1]")
    public WebElement contentLnk;
    @FindBy(id="calendarFeedHeading")
    public WebElement calendarFeedHeading;
    @FindBy(xpath = "//button[@class='btn umb-button__button btn-primary umb-button-- umb-outline']")
    public WebElement createBtn;
    @FindBy(id="headerName")
    public WebElement headerNameTxt;
    @FindBy(xpath = "//button[@data-element='sub-view-umbInfo']")
    public WebElement infoBtn;
    @FindBy(xpath = "//span[@class='icon umb-icon']/parent::a")
    public WebElement frontEndLnk;
    @FindBy(xpath = "//h1")
    public WebElement frontEndMainPageHeading;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement FrontEndCalendarHeading;
    @FindBy(xpath = "(//select[@name='dropDownList'])[1]")
    public WebElement calendarDropdown;
    @FindBy(xpath = "(//select[@name='dropDownList'])[2]")
    public WebElement viewDropdown;
    @FindBy(xpath = "(//select[@name='dropDownList'])[3]")
    public WebElement categoriesDropdown;

}
