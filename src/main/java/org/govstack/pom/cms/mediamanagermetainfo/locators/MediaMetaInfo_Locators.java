package org.govstack.pom.cms.mediamanagermetainfo.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MediaMetaInfo_Locators extends InitElements {

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Media Pages']")
    public WebElement mediaPagesEllipsBtn;
    @FindBy(xpath = "//span[text()='Create']")
    public WebElement createBtn;
    @FindBy(xpath = "//span[contains(text(),'Media Pages Subfolder')]/parent::button")
    public WebElement mediaPagesSubfolderBtn;
    @FindBy(id = "headerName")
    public WebElement headerName;
    @FindBy(xpath = "(//span[contains(text(),'Media Pages')]/parent::button)[2]")
    public WebElement mediaPageLnk;
    @FindBy(xpath = "//localize[text()='Blank']/parent::span/parent::button")
    public WebElement blankPage;
    @FindBy(xpath = "//button[@class='btn-reset umb-media-card-grid__create-button umb-outline']")
    public WebElement fileBtn;
    @FindBy(id = "datatype-search")
    public WebElement searchTxt;
    @FindBy(xpath = "//img[@class='umb-media-grid__item-image lazy loaded']")
    public WebElement logolnk;
    @FindBy(xpath = "(//button[@class='btn umb-button__button btn-success umb-button-- umb-outline'])[2]")
    public WebElement selectBtn;
    @FindBy(xpath = "documentCategories")
    public WebElement documentCategoriesAddBtn;
    @FindBy(xpath = "//div[@class='umb-table-cell black umb-minilistview__fade-not-allowed']")
    public List<WebElement>categoryList;
    @FindBy(xpath = "(//button[@class='btn umb-button__button btn-success umb-button-- umb-outline'])[2]")
    public WebElement submitBtn;
    @FindBy(id = "button_documentMetaInformation")
    public WebElement documentMetaInformationBtn;
    @FindBy(xpath = "//div[text()='Text Field']")
    public WebElement textFieldLnk;
    @FindBy(id = "fieldProperty")
    public WebElement fieldPropertyBtn;
    @FindBy(id="fieldValue")
    public WebElement fieldValueTxt;
    @FindBy(xpath = "//button[@data-element=\"sub-view-umbInfo\"]")
    public WebElement infoBtn;
    @FindBy(xpath = "//div[@class=\"block-form umb-box-content\"]/ul/li/a")
    public WebElement pageLinks;

    public WebElement getElement(String location){
        return getDriver().findElement(By.xpath("//umb-button-ellipsis[@text=Open context menu for '"+location+"']"));
    }
}
