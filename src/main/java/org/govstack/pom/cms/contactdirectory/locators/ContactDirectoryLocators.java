package org.govstack.pom.cms.contactdirectory.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactDirectoryLocators extends InitElements {

    @FindBy(xpath = "//localize[@key='actions_create']/parent:: button[@class='btn btn-outline umb-outline']")
    public WebElement createNewContactBtn;
    @FindBy(id = "headerName")
    public WebElement headerNameTxt;
    @FindBy(xpath = "//button[@data-element='sub-view-umbInfo']")
    public WebElement infoTabBtn;
    @FindBy(xpath = "//a[@class='umb-tree-item__label']")
    public List<WebElement> categoryLists;
    @FindBy(xpath = "//span[@icon=\"icon-delete\"]/parent :: button")
    public WebElement deleteBtn;
    @FindBy(xpath = "(//span[@class=\"umb-button__content\"])[2]")
    public WebElement deleteConfirmBtn;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement deleteSuccessMsg;
    @FindBy(xpath = "//button[text()='Ok']")
    public WebElement okBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameTxt;
    @FindBy(id = "lastName")
    public WebElement lastNameTxt;
    @FindBy(id = "title")
    public WebElement titleTxt;
    @FindBy(id = "email")
    public WebElement emailTxt;
    @FindBy(id = "description")
    public WebElement descriptionTxt;
    @FindBy(id = "locationText")
    public WebElement locationText;
    @FindBy(id = "locationLink")
    public WebElement locationLinkTxt;
    @FindBy(xpath = "//select[@name='dropDownList']/option")
    public List<WebElement> categoryListsDropDown;

    @FindBy(id="phoneName")
    public WebElement phoneNameTxt;
    @FindBy(id="phoneNumber")
    public WebElement phoneNumberTxt;

    @FindBy(id="phoneIsPrimary")
    public WebElement phoneIsPrimaryToggleBtn;
    @FindBy(xpath="//a[@class='umb-content-grid__item-name umb-outline']/span[2]")
    public List<WebElement> contactsList;
}
