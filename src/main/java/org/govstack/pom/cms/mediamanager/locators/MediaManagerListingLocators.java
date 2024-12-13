package org.govstack.pom.cms.mediamanager.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MediaManagerListingLocators extends InitElements {

    @FindBy(xpath = "//*[@id='tree']/ul/li/ul/li/ul//li")
    public List<WebElement> mainsiteList;
    @FindBy(id = "button_mainContent")
    public WebElement mainContentBtn;
    @FindBy(xpath = "//input[@id='block-search']")
    public WebElement mainContentFilterTxtbox;
    @FindBy(xpath = "//div[@class='__info']")
    public WebElement mediaManagerListingContent;
    @FindBy(xpath = "//span[@id='displayIntro']")
    public WebElement displayIntroFlag;
    @FindBy(xpath = "//span[@id='displayOutro']")
    public WebElement displayOutroFlag;
    @FindBy(css = "button#documents.umb-node-preview-add")
    public WebElement mediaFolderAddBtn;
    @FindBy(css = "button#categories.umb-node-preview-add")
    public WebElement mediaCategoriesAddBtn;
    @FindBy(xpath = "//*[@class='umb-tree hide-options']/li/ul/li")
    public List<WebElement> contentFolderList;
    @FindBy(xpath = "//input[@id='mini-listview-search'][1]")
    public WebElement categoryFilterTxtbox;
    @FindBy(xpath = "//div[@class='umb-table-cell black umb-minilistview__fade-not-allowed']")
    public WebElement categoryItem;
    @FindBy(xpath = "(//umb-button[@button-style=\"success\"]/div/button)[2]")
    public WebElement submitCategoryBtn;
    @FindBy(xpath = "//*[@class='checkbox umb-form-check umb-form-check--checkbox ']")
    public List<WebElement> metaInformationCheckbox;
    @FindBy(xpath = "//button[@class='btn umb-button__button btn-primary umb-button-- umb-outline']")
    public WebElement createBtn;
    @FindBy(xpath = "//div[@class='umb-block-list__block --show-validation']")
    public WebElement mainContentDetailsBtn;

    /**
     * Extra Content Tab
     **/
    @FindBy(xpath = "(//button[contains(text(),'Extra Content')])")
    public WebElement ExtraContentMenuBtn;
    @FindBy(id = "button_aboveMainContent")
    public WebElement aboveMainContentBtn;
    @FindBy(xpath = "//umb-property[@data-element='property-aboveMainContent']//button[@class='btn-reset umb-outline action --delete']")
    public WebElement aboveMainContentDeleteBtn;
    @FindBy(xpath = "//button[@class='btn umb-button__button btn-danger umb-button-- umb-outline']")
    public WebElement deleteBtn;

    /**
     * Settings
     **/
    @FindBy(xpath = "//umb-property[@data-element='property-mainContent']//button[@class='btn-reset umb-outline action --settings']")
    public WebElement mainContentSettingsBtn;
    @FindBy(xpath = "//umb-property[@data-element='property-mainContent']//button[@class='btn-reset umb-outline action --delete']")
    public WebElement mainContentDeleteBtn;
    @FindBy(xpath = "//umb-property[@data-element='property-presentationView']//label[@class='usn-item item  itemsRow_1']")
    public WebElement gridViewBtn;
    @FindBy(xpath = "//umb-property[@data-element='property-presentationView']//label[@class='usn-item item  itemsRow_2']")
    public WebElement tableViewBtn;
    @FindBy(xpath = "//umb-property[@data-element='property-itemsPerRow']//label[@class='usn-item item  itemsRow_4']")
    public WebElement itemsPerRowBtn;
    @FindBy(xpath = "//umb-property[@data-element='property-imageCrop']//label[@class='usn-item item smallItem '][1]")
    public WebElement originalImageCropBtn;
    @FindBy(css = "span#hideFilters")
    public WebElement hideFiltersSwitcher;
    @FindBy(id = "searchPlaceholderText")
    public WebElement searchPlaceholderTxtbox;
    @FindBy(xpath = "//umb-property[@data-element='property-searchButtonColour']//label[@title='base-btn']")
    public WebElement buttonColorBtn;

    /**
     * Table View
     **/
    @FindBy(xpath = "//li[@data-element='tab-tableView']")
    public WebElement tableViewTab;
    @FindBy(css = "span#hideCategories")
    public WebElement removeCategoriesSwitcher;
    @FindBy(id = "metadataColumns")
    public WebElement addMetaInfoColumnsBtn;
    @FindBy(xpath = "//ul[@class='umb-tree hide-options']/li/ul/li/div/button")
    public List<WebElement> contentList;
    @FindBy(xpath = "//div[@class='umb-table-body']/div")
    public List<WebElement> contentListName;
    @FindBy(css = "span#hideDateCreated")
    public WebElement removeDateCreatedSwitcher;
    @FindBy(css = "span#hideDateModified")
    public WebElement removeDateModifiedSwitcher;
    @FindBy(css = "span#hideFileType")
    public WebElement removeFileTypeSwitcher;
    @FindBy(css = "span#hideSize")
    public WebElement removeFileSizeSwitcher;
    @FindBy(css = "span#hideDownload")
    public WebElement removeDownloadLinksSwitcher;

    /**
     * Front End
     **/
    @FindBy(xpath = "//div[@class='documentListing table-responsive']")
    public WebElement frontEndTable;
    @FindBy(xpath = "//div[@class='documentListing table-responsive']//table/thead/tr/th")
    public List<WebElement> tableHeaderList;
    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchKeywordTxtbox;
    @FindBy(xpath = "//button[@name='docSubmit']")
    public WebElement filterMediaBtn;
    @FindBy(xpath = "//button[@class='clear-all-selected']")
    public WebElement clearAllFilterBtn;
    @FindBy(xpath = "//a[contains(text(),'Hazel File')]")
    public WebElement mediaFile1;
    @FindBy(xpath = "//a[contains(text(),'Hazel Test')]")
    public WebElement mediaFile2;
    @FindBy(xpath = "//a[contains(text(),'Extra Content')]")
    public WebElement mediaFile3;
    @FindBy(xpath = "//a[contains(text(),'Hazel Category')]")
    public WebElement mediaFile4;
    @FindBy(xpath = "//span[contains(text(), 'Categories')]")
    public WebElement categoriesFilterDropdown;
    @FindBy(xpath = "//label[contains(text(), 'Test automation')]")
    public WebElement testAutoCategoryFilter;
    @FindBy(xpath = "//label[contains(text(), 'Category 2')]")
    public WebElement category2Filter;
    @FindBy(xpath = "//label[contains(text(), 'Category Hazel Renamed')]")
    public WebElement hazelRenamedCategoryFilter;
    @FindBy(xpath = "//span[contains(text(), 'File Types')]")
    public WebElement fileTypesFilterDropdown;
    @FindBy(xpath = "//label[contains(text(), 'JPG/JPEG')]")
    public WebElement fileTypesFilterType;
    @FindBy(xpath = "//label[contains(text(), 'PNG')]")
    public WebElement pngFileTypeFilter;
    @FindBy(xpath = "//label[contains(text(), 'PDF')]")
    public WebElement pdfFileTypeFilter;
    @FindBy(xpath = "//select[@elemname='select-date-field']")
    public WebElement dateTypesFilterDropdown;
    @FindBy(xpath = "//span[@aria-hidden='false']//input[@elemname='start-date']")
    public WebElement startDateFilter;
    @FindBy(xpath = "//a[@aria-label='You are on page 2']")
    public WebElement page2Btn;
    @FindBy(xpath = "//a[@aria-label='You are on page 1']")
    public WebElement page1Btn;
    @FindBy(xpath = "//a[@aria-label='Previous']")
    public WebElement previousPageBtn;
    @FindBy(xpath = "//a[@aria-label='Next']")
    public WebElement nextPageBtn;
    @FindBy(xpath = "//select[@name='pageSizeSelect']")
    public WebElement resultsPerPageDropdown;
    @FindBy(xpath = "//a[@href='/media/zqbje05i/bd.jpg'][1]")
    public WebElement hazelFileDownloadBtn;
    @FindBy(xpath = "//a[@href='/media/zqbje05i/bd.jpg'][2]")
    public WebElement hazelFileViewBtn;
    @FindBy(xpath = "//a[@href='/media/xetjbcqq/apsley-central-public-school.png'][2]")
    public WebElement hazelTestFileViewBtn;
    @FindBy(xpath = "//div[@class='document-categories']//p")
    public WebElement categoryDetailTxt;
    @FindBy(xpath = "//div[@class='document-summary']//p")
    public WebElement descriptionDetailTxt;
    @FindBy(xpath = "//table[@aria-label='File Details']//th")
    public WebElement tableContentTxt1;
    @FindBy(xpath = "//table[@aria-label='File Details']//td")
    public WebElement tableContentTxt2;

    /**
     * Categories Page
     **/
    @FindBy(xpath = "//div[@class='umb-content-grid__content']/a/span[2]")
    public List<WebElement> categoriesTitles;
    @FindBy(xpath = "//div[@class='umb-content-grid__content']")
    public List<WebElement> categoriesLists;
    @FindBy(id = "headerName")
    public WebElement categoryHeaderName;
    @FindBy(xpath = "//umb-button[@label-key='actions_unpublish']")
    public WebElement unpublishBtn;
    @FindBy(xpath = "//umb-button[@label-key='actions_publish']")
    public WebElement publishBtn;
    @FindBy(css = ".umb-editor-header__back")
    public WebElement backBtn;
}
