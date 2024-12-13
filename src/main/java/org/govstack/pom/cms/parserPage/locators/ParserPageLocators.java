package org.govstack.pom.cms.parserPage.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParserPageLocators extends InitElements {
    /**
     * Settings Section
     **/
    @FindBy(id = "headerName")
    public WebElement parserNameTxt;

    @FindBy(id = "parserDivId")
    public WebElement divIdTxt;

    @FindBy(id = "parserDivInnerText")
    public WebElement divInnerTxt;

    @FindBy(xpath = "//a[@title='Configuration']")
    public WebElement configurationTab;

    @FindBy(xpath = "//a[@href='/Management/Configuration/Template']")
    public WebElement templatesTab;

    @FindBy(xpath = "//a[@href='/Management/Template/Update/08ba14da-4834-4274-8820-b1a400bfcae7']")
    public WebElement stgRegressionTemplateEditBtn;

    @FindBy(id = "RemoteUrl")
    public WebElement remoteURLTxt;

    @FindBy(id = "RemoteElement")
    public WebElement elementIDTxt;

    @FindBy(xpath = "//button[@class='EVN_btn EVN_btn-primary']")
    public WebElement saveBtn;

    @FindBy(xpath = "//h1[@class='heading main base-heading']")
    public WebElement headerNameLbl;

    @FindBy(xpath = "(//a[@title='Manage Configuration'])[1]")
    public WebElement fbConfigTab;

    @FindBy(xpath = "//a[@title='Manage Templates']")
    public WebElement fbTemplatesTab;

    @FindBy(xpath = "//a[@title='Update Template']")
    public WebElement defaultTemplateEditBtn;

    @FindBy(xpath = "//button[@title='Save']")
    public WebElement fbSaveBtn;

    @FindBy(xpath = "//a[@title='View List']")
    public WebElement fbListTab;

    @FindBy(xpath = "//a[@title='Launch Options']")
    public WebElement launchOptionsBtn;

    @FindBy(xpath = "//a[@title='Open https://forms-amo-master.qa.esolg.ca/Demo-Form']")
    public WebElement launchDemoForm;

    @FindBy(xpath = "//button[@class='btn base-btn-bg base-btn-bg base-btn-bg-solid base-btn-bg-hover-solid base-btn-text base-btn-borders accept-cookies']")
    public WebElement acceptCookiesBtn;

    @FindBy(xpath = "//div[@id='formBuilder']//h1[text()='Test Form']")
    public WebElement testFormHeadingTxt;

    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    public WebElement whichCountryDropdown;

    @FindBy(xpath = "//li[contains(text(),'Algeria')]")
    public WebElement selectCountry;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg']")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@class='form-control datepicker hasDatepicker']")
    public WebElement chooseDate;

    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']")
    public WebElement dateToday;

    @FindBy(xpath = "//input[@class='form-control timepicker hasTimepicker']")
    public WebElement chooseTime;

    @FindBy(xpath = "//td[@data-hour='8']")
    public WebElement chooseHr;

    @FindBy(xpath = "//td[@data-minute='30']")
    public WebElement chooseMin;

    @FindBy(xpath = "(//div[@class='radio']/label)[1]")
    public WebElement yesRadioBtn;

//    @FindBy(xpath = "(//div[@class='radio']/label)[2]")
//    public WebElement noRadioBtn;

    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    public WebElement contactOption;

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    public WebElement emailOption;

    @FindBy(css = "input#Q_f77d4d1b-1dc9-41d9-8ed9-64e08224527b_0")
    public WebElement emailTxt;

    @FindBy(css = "input#P_b13ce70d-652f-4fb3-b0fc-ca78dbad4135_0")
    public WebElement calculationTxt;

    @FindBy(xpath = "//input[@id='Q_ad09eb0b-938b-4377-86d6-87e6cb7b0d64_0']")
    public WebElement panelTxt;

    @FindBy(xpath = "//a[@title='Add']")
    public WebElement addBtn;

    @FindBy(css = "div#P_9887aa2d-37c8-4d75-a75b-db09344e123e_0")
    public WebElement signatureField;

//    @FindBy(xpath = "//div[@class='recaptcha-checkbox-spinner']")
//    public WebElement recaptchaCheckBox;

    @FindBy(xpath = "//div[@class='col-md-12 ']//h1[text()='Thank You']")
    public WebElement thankYouMessage;

    @FindBy(xpath = "//div[@id='logo']")
    public WebElement govstackLogo;
}
