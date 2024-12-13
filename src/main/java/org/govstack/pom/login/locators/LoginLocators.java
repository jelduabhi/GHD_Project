package org.govstack.pom.login.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginLocators extends InitElements {

    @FindBy(id = "Umbraco.BackOffice.OpenIdConnect")
    public WebElement signinWithB2Cbtn;
    @FindBy(id = "signInName")
    public WebElement userNameTxt;
    @FindBy(xpath = "//button[text()='Next']")
    public WebElement nextBtn;
    @FindBy(name = "passwd")
    public WebElement passwordTxt;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signInBtn;

    @FindBy(id = "idSIButton9")
    public WebElement staySignedInBth;

    @FindBy(id = "KmsiCheckboxField")
    public WebElement staySignedInChk;
    @FindBy(xpath = "//a[@class='btn btn-light']")
    public List<WebElement> dashBoardBusinessDirectory;


    @FindBy(xpath = "//a[@class='EVN_btn EVN_btn-lg EVN_btn-success EVN_btn-block btnLabel']")
    public WebElement alreadyHaveAccountBtn;

    @FindBy(xpath = "//a[@class='EVN_btn EVN_btn-primary']")
    public WebElement ssoLoginBtn;

    // Login Fields for Form Builder
    @FindBy(id = "Email")
    public WebElement emailFormBuilderTxt;

    @FindBy(id = "Password")
    public WebElement passwordFormBuilderTxt;

    @FindBy(xpath = "//input[@title='Login']")
    public WebElement loginFormBuilderBtn;

    //Bids and tender login locators

    @FindBy(xpath = "//input[@name='text_field_domain']")
    public WebElement btAgencyNameField;

    @FindBy(xpath = "(//span[normalize-space()='Use bids&tenders'])[1]")
    public WebElement btUseBtBtn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement btEmailLoginField;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement btPasswordLoginField;

    @FindBy(xpath = "(//span[normalize-space()='Login'])[1]")
    public WebElement btLoginBtn;


}
