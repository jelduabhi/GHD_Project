package org.govstack.pom.cms.alerts.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlertLocators extends InitElements {

    @FindBy(xpath = "//button[@class='btn btn-outline umb-outline']")
    public WebElement creatNewAlertBtn;
    @FindBy(xpath = "//div[@class='umb-content-grid__content']")
    public List<WebElement> alertsLists;
    @FindBy(xpath = "//div[@class='umb-content-grid__content']/a/span[2]")
    public List<WebElement> alertsTitles;
    @FindBy(xpath = "(//span[@icon=\"icon-trash\"])[3]")
    public WebElement deleteBtn;
    @FindBy(xpath = "//button[@class='btn umb-button__button btn-danger umb-button-- umb-outline']/span")
    public WebElement yesDeleteBtn;

    /**
     * Content Section
     */
    @FindBy(id = "headerName")
    public WebElement headerNameTxt;
    @FindBy(id = "alertTitle")
    public WebElement alertTitleTxt;
    @FindBy(id = "alertOptionalLabel")
    public WebElement alertOptionalTxt;
    @FindBy(id = "alertActionText")
    public WebElement alertActionText;
    @FindBy(xpath = "//ng-form[@name='multiUrlPickerForm']/button")
    public WebElement callToActionLnk;

    /**
     * Settings Section
     */
    @FindBy(xpath = "//button[contains(text(),'Settings')]")
    public WebElement settingsLnk;
    @FindBy(xpath = "(//select[@name=\"dropDownList\"])[1]")
    public WebElement alertTypeDropdown;
    @FindBy(xpath = "(//select[@name=\"dropDownList\"])[2]")
    public WebElement alertStyleDropdown;
    @FindBy(xpath = "(//span[@icon='icon-calendar'])[1]/parent::span")
    public WebElement startDatebtn;
    @FindBy(xpath = "//input[@id='alertEndDate']/parent::div/span")
    public WebElement endDateBtn;
    @FindBy(xpath = "//div[@class='dayContainer']/span")
    public List<WebElement> datePicker;
    @FindBy(xpath = "(//input[@aria-label='Hour'])[1]")
    public WebElement startDateHours;
    @FindBy(xpath = "(//input[@aria-label='Minute'])[1]")
    public WebElement startDateMinitus;
    @FindBy(id = "alertPages")
    public WebElement alertPages;
    @FindBy(xpath = " (//a[contains(text(),'Automation Testing Page QA')])[2]")
    public WebElement clickQAPage;
    @FindBy(xpath = "(//a[contains(text(),'Automation Testing Page STG')])[2]")
    public WebElement clickStagePage;
    @FindBy(xpath = "//umb-button[@label-key='general_submit']/div/button")
    public WebElement submitBtn;


    //RG_AL_3.9 Alert without start date validation message should be visible

    @FindBy(xpath = "(//p[contains(text(),'Required')])[1]")
    public WebElement alertWithoutDateSaveValidMessage;


}
