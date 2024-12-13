package org.govstack.pom.cms.mediaManagerBackoffice.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MediaManagerBackOfficeLocators extends InitElements {
    @FindBy(xpath = "//a[contains(text(),'Media Manager')]/parent::div/button")
    public WebElement mediaManagerExpandBtn;
    @FindBy(xpath = "//a[contains(text(),'Meta Information')]/parent::div/button")
    public WebElement mediaManagerMetaInfoExpandBtn;
    @FindBy(xpath = "//a[contains(text(),'Media Pages')]/parent::div/button")
    public WebElement mediaManagerMediaPagesExpandBtn;
    @FindBy(xpath = "//a[contains(text(),'Templates Builder')]/parent::div/button")
    public WebElement mediaManagerTemplateBuilderExpandBtn;
    @FindBy(xpath = "(//a[contains(text(),'Automation Do  Not Delete')])[1]")
    public WebElement mediaManagerMediaPagesAutomationMenu;
    @FindBy(xpath = "(//a[contains(text(),'Sample Templates')])[1]")
    public WebElement mediaManagerTemplateBldSampleTemplateMenu;
    @FindBy(xpath = "//a[normalize-space()='Categories']")
    public WebElement mediaManagerCatergoriesMenu;
    @FindBy(xpath = "//a[normalize-space()='Text Fields']")
    public WebElement mediaManagerTextFieldMenu;
    @FindBy(xpath = "//a[normalize-space()='Text Area Fields']")
    public WebElement mediaManagerTextAreaFieldMenu;
    @FindBy(xpath = "//a[normalize-space()='Date Fields']")
    public WebElement mediaManagerDateFieldMenu;
    @FindBy(xpath = "//a[normalize-space()='Date with Time Fields']")
    public WebElement mediaManagerDateWithTimeFieldMenu;
    @FindBy(xpath = "//a[normalize-space()='Link Fields']")
    public WebElement mediaManagerLinkFieldMenu;
    @FindBy(xpath = "//button[@class='btn btn-outline umb-outline']")
    public WebElement createMediaCategoryBtn;
    @FindBy(xpath = "//div[@class='btn-group']//button[@type='button']")
    public WebElement createTempBldBtn;
    @FindBy(xpath = "(//span[normalize-space()='Media Page'])[1]")
    public WebElement createTempBldMediaPgBlankBtn;
    @FindBy(xpath = "//input[@id='headerName']")
    public WebElement mediaCatNamefield;
    @FindBy(xpath = "//input[contains(@id,'search')]")
    public WebElement searchTxtCategory;
    @FindBy(xpath = "//a[@class='umb-content-grid__item-name umb-outline']/span[2]")
    public List<WebElement> Categoryresults;
    @FindBy(xpath = "//a[@class='umb-content-grid__item-name umb-outline']/span[2]")
    public List<WebElement> categoryLists;
    @FindBy(xpath = "//a[@class='umb-content-grid__item-name umb-outline -light']/span[2]")
    public List<WebElement> unPublishedNewsLists;
    @FindBy(xpath = "//localize[@key='content_unpublished']")
    public WebElement categoryStatus;
    @FindBy(xpath = "//div[@class='umb-content-grid__content']")
    public List<WebElement> catLists;
    @FindBy(xpath = "//div[@class='umb-content-grid__content']/a/span[2]")
    public List<WebElement> catTitles;
    @FindBy(xpath = "(//span[@icon=\"icon-trash\"])[3]")
    public WebElement deleteBtn;
    @FindBy(xpath = "//button[@class='btn umb-button__button btn-danger umb-button-- umb-outline']/span")
    public WebElement yesDeleteBtn;
    @FindBy(xpath = "(//span[starts-with(text(),'Automation')])[1]")
    public WebElement metaInfoRecycleList;
    @FindBy(xpath = "(//localize[@key='general_searchNoResult'])[1]")
    public WebElement invalidSearchTextMessage;
    @FindBy(xpath = "(//div[@class='umb-table-cell umb-table__name'])[2]")
    public WebElement validSearchMediaPages;
    @FindBy(xpath = "//span[@icon='icon-thumbnails-small']")
    public WebElement thumbnailIcon;
    @FindBy(xpath = "(//span[@icon='icon-list'])[2]")
    public WebElement listIcon;
    @FindBy(xpath = "//localize[@key='general_name']")
    public WebElement generalNameCol;
    @FindBy(xpath = "//localize[@key='general_status']")
    public WebElement generalStatusCol;
    @FindBy(xpath = "//span[normalize-space()='Last edited']")
    public WebElement generalLastEditedCol;
    @FindBy(xpath = "//span[normalize-space()='Created by']")
    public WebElement generalCreatedByCol;
    @FindBy(xpath = "//button[@id='documentCategories']")
    public WebElement templateBldAddCatr;
    @FindBy(xpath = "(//div[contains(text(),'Category')])[1]")
    public WebElement templateBldCatSelect;
    @FindBy(xpath = "(//span[normalize-space()='Submit'])[1]")
    public WebElement templateBldSubmitbtn;
    @FindBy(xpath = "(//div[@role='button'])[1]")
    public WebElement tembulderList;
    @FindBy(xpath = "//span[normalize-space()='Copy...']")
    public WebElement tempBuilderCopy;
    @FindBy(xpath = "(//button[@class='umb-toggle umb-toggle--checked'])[1]")
    public WebElement tempBuilderRelateOriginalToggle;
    @FindBy(xpath = "//input[@placeholder='Type to search...']")
    public WebElement tempBuilderSearchFolder;
    @FindBy(xpath = "//span[starts-with(text(),'Automation Do  Not Delete')]")
    public WebElement tempBuilderClickFolder;

    //Media Manager Pages TC Meta Information Fields Locators
    @FindBy(xpath = "//button[@id='button_documentMetaInformation']")
    public WebElement metaInformationAddButton;
    @FindBy(xpath = "(//div[contains(text(),'Link Field')])[1]")
    public WebElement metaInformationLinkFieldCard;
    @FindBy(xpath = "(//div[contains(text(),'Date with Time Field')])[1]")
    public WebElement metaInformationDateWithTimeCard;
    @FindBy(xpath = "//button[@id='fieldProperty']")
    public WebElement metaInformationAddType;
    @FindBy(xpath = "//div[contains(text(),'Amended By')]")
    public WebElement metaInformationLinkTypeList;
    @FindBy(xpath = "//div[contains(text(),'Meeting Date')]")
    public WebElement metaInformationMeetingDateList;
    @FindBy(xpath = "//div[contains(text(),'Contact Information')]")
    public WebElement metaInformationLinkTypeContactInfo;
    @FindBy(xpath = "//div[contains(text(),'Related Document')]")
    public WebElement metaInformationLinkTypeRelatedDoc;
    @FindBy(xpath = "//div[contains(text(),'Repealed By')]")
    public WebElement metaInformationLinkTypeRepealedBy;
    @FindBy(xpath = "//button[contains(.,'Value:')]")
    public WebElement metaInformationValueButton;
    @FindBy(xpath = "//input[@id='urlLinkPicker']")
    public WebElement metaInformationLinkTextField;
    @FindBy(xpath = "//input[@id='nodeNameLinkPicker']")
    public WebElement metaInformationLinkTitleTextField;
    @FindBy(xpath = "(//span[normalize-space()='Info'])[1]")
    public WebElement metaInfoIcon;
    @FindBy(xpath = "(//span[@icon='icon-out'])[position()=1]")
    public WebElement metaInfoUrl;
    @FindBy(xpath = "(//th[@scope='row'])[1]")
    public WebElement metaFrontendLinkField;
    @FindBy(xpath = "//input[@id='fieldValue']")
    public WebElement metaDateField;
    @FindBy(xpath = "//span[@aria-current='date']")
    public WebElement metaCurrentDateIcon;

    /*
  Media Manager Pages AT Meta Information Fields Date Field pending test cases started here
  LOCATORS COVERED FOR TEST CASES ID COVERED : TC_DF_9,TC_DF_10,TC_DF_11,TC_DF_12
  NOTE: FROM TC_DF_1 TO TC_DF_8 SAI KUMAR WORKED ON HIS PR
  */
    @FindBy(xpath = "(//div[contains(text(),'Date Field')])[1]")
    public WebElement metaInformationDateCard;
    @FindBy(xpath = "//input[@id='mini-listview-search']")
    public WebElement metaInfoDateFieldSearch;
    @FindBy(xpath = "//div[contains(text(),'Issue Date')]")
    public WebElement metaInfoDateFieldIssueDate;
    @FindBy(xpath = "//div[contains(text(),'Publication Date')]")
    public WebElement metaInfoDateFieldPublicationDate;
    @FindBy(xpath = "//div[contains(text(),'Review Date')]")
    public WebElement metaInfoDateFieldReviewDate;
    @FindBy(xpath = "//div[contains(text(),'Submission Date')]")
    public WebElement metaInfoDateFieldSubmissionDate;
}
