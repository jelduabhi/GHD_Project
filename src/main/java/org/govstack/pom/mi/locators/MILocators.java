package org.govstack.pom.mi.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MILocators extends InitElements {

    @FindBy(xpath = "//li[@data-element='tree-item-Media Manager']//a")
    public List<WebElement> mmlist;

    @FindBy(xpath = "//div[@class='umb-table-cell umb-table__name']//a")
    public List<WebElement> templateNameList;

    @FindBy(xpath = "//button[@id='button_documentMetaInformation']//localize[contains(text(),'Add content')]")
    public WebElement miAddContentBtn;

    @FindBy(xpath = "//ng-form[@name='infiniteEditorForm']//div[@class='umb-panel umb-editor-wrapper']")
    public WebElement miAddContentForm;

    @FindBy(xpath = "//umb-block-card//div//div[@class='__name']")
    public List<WebElement> miAddCcntentCardList;

    @FindBy(xpath = "//ng-form[@class='ng-pristine ng-valid ng-valid-min-count ng-valid-max-count']//button[@id='fieldProperty']")
    public WebElement miAddContentCurrentBlockAddBtn;

    @FindBy(xpath = "//ng-form[@class='ng-pristine ng-valid ng-valid-val-server ng-valid-required']//input[@id='fieldValue']")
    public WebElement miAddContentCurrentBlockTextField;

    @FindBy(xpath = "//ng-form[@class='ng-pristine ng-valid ng-valid-val-server ng-valid-required']//textarea[@id='fieldValue']")
    public WebElement miAddContentCurrentBlockTextAreaField;

    @FindBy(xpath = "//ng-form[@class='ng-pristine ng-valid ng-valid-val-property-msg ng-valid-min-count ng-valid-max-count']//ng-form[@name='multiUrlPickerForm']//button")
    public WebElement miAddContentActiveBlockLinkFieldAddBtn;

    @FindBy(xpath = "//form[@name='propertySettingsForm']//div[@class='umb-panel umb-editor-wrapper']")
    public WebElement miSelectContentForm;

    @FindBy(xpath = "//div[@class='umb-linkpicker']//div[@class='umb-panel umb-editor-wrapper']")
    public WebElement miSelectlinkForm;

    @FindBy(xpath = "//button[normalize-space()='Select media']")
    public WebElement miSelectlinkMediaBtn;

    @FindBy(xpath = "//umb-button[@label-key='general_submit']//button[@type='button']")
    public WebElement miLinkMediaSubmitBtn;

    @FindBy(xpath = "//div[contains(@class,'umb-table-cell black umb-minilistview__fade-not-allowed')]")
    public List<WebElement> miSelectContentList;

    @FindBy(xpath = "//input[@id='mini-listview-search']")
    public WebElement miSelectContentInputTextBox;

    @FindBy(xpath = "//table[@aria-label='File Details']//tr//th")
    public List<WebElement> miFETableHeader;

    @FindBy(xpath = "//table[@aria-label='File Details']//tr//td")
    public List<WebElement> miFETableData;

    @FindBy(xpath = "//input[@id='datatype-search']")
    public WebElement input;

    @FindBy(xpath = "//umb-button[@label-key='buttons_select']//button[@type='button']")
    public WebElement imgSelectBtn;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileInput;

    @FindBy(xpath = "//div[@class='umb-block-list__block--actions']//button[@title='Delete']")
    public List<WebElement> existingmiinfoDeleteBtn;

    @FindBy(xpath = "//div[@name='overlay.name']")
    public WebElement mideleteoverlay;

    @FindBy(xpath = "//umb-button[@alias='overlaySubmit']//div[@class='umb-button']//button//span[normalize-space()='Delete']")
    public WebElement mideleteOverlayBtn;

    @FindBy(xpath = "//input[@id='urlLinkPicker']")
    public WebElement linkurl;

    @FindBy(xpath = "//input[@id='nodeNameLinkPicker']")
    public WebElement linktitle;

    @FindBy(xpath = "//umb-button[@alias='save']/div/button")
    public WebElement save;

    @FindBy(xpath = "//input[contains(@id,'search')]")
    public WebElement templateSearch;
}
