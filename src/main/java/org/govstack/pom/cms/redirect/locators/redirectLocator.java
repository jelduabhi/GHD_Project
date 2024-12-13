package org.govstack.pom.cms.redirect.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class redirectLocator extends InitElements {

    @FindBy(xpath = "//li[@data-element='tab-redirects']//button[@type='button']")
    public WebElement redirectTab;

    @FindBy(xpath = "//localize[@key='redirects_redirects']")
    public WebElement redirectHeader;

    @FindBy(xpath = "//span[normalize-space()='Add new redirect']")
    public WebElement addRedirectBtn;

    @FindBy(xpath = "//input[@redirects-validate-url='vm.isValidUrl(model.value)']")
    public WebElement originalUrl;

    @FindBy(xpath = "//button[@class='umb-node-preview-add']")
    public WebElement destinationUrl;

    @FindBy(xpath = "//input[@id='urlLinkPicker']")
    public WebElement urlLinkTextField;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    public WebElement redirectSubmitBtn;

    @FindBy(xpath = "//span[normalize-space()='Add']")
    public WebElement redirectAddBtn;

    @FindBy(xpath = "//input[@placeholder='Type to search...']")
    public WebElement redirectSearchFilter;

    @FindBy(xpath = "(//tr[@ng-repeat='redirect in vm.redirects'])[1]")
    public WebElement redirectsearchResult;

    @FindBy(xpath = "(//a[contains(.,'/automationredirectlink/')])[1]")
    public WebElement originalUrlClick;

    @FindBy(xpath = "(//localize[@key='defaultdialogs_selectMedia'])[1]")
    public WebElement selectMediaBtn;

    @FindBy(xpath = "//input[@id='datatype-search']")
    public WebElement searchFileField;

    @FindBy(xpath = "//img[@alt='Govstack Logo Black']")
    public WebElement gsLogoSelect;

    @FindBy(xpath = "//span[normalize-space()='Select']")
    public WebElement mediaSelectBtn;

    @FindBy(xpath = "(//span[contains(text(),'Temporary')])[1]")
    public WebElement temporaryRadioBtn;


}
