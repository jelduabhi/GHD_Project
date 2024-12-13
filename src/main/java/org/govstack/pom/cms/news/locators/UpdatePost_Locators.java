package org.govstack.pom.cms.news.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class UpdatePost_Locators extends InitElements {
    //posts page
    @FindBy(xpath = " //div[@class='umb-content-grid']//div//a")
    public List<WebElement> postlist;
    //post open page
    @FindBy(id = "headerName")
    public WebElement postname;
    @FindBy(css = ".umb-editor-header__back")
    public WebElement back;
    @FindBy(xpath = "//button[@data-element='button-saveAndPublish']")
    public WebElement saveAndPublish;
    @FindBy(xpath = "//button[@umb-auto-focus='true']")
    public WebElement readyTosaveAndPublishOverlayBtn;
    @FindBy(xpath = "//div[@name='overlay.name']")
    public WebElement readyTosaveAndPublishOverlay;
    @FindBy(xpath = "//div[@class='alert alert-error property-error']")
    public WebElement propertyError;

    //settings tab
    @FindBy(xpath = "//umb-property[@data-element='property-postAuthor']//div[@class='umb-node-preview__name']")
    public WebElement selectedAuth;
    @FindBy(xpath = "//umb-property[@data-element='property-postCategories']//div[@class='umb-node-preview__name']")
    public WebElement selectedCatg;
    @FindBy(xpath = "//div[@data-element='tab-content-settings']")
    public WebElement body;
    @FindBy(xpath = "//div[@class='umb-control-group']//following-sibling::div//a")
    public List<WebElement> catgList;
    @FindBy(xpath = "//umb-property[@data-element='property-postCategories']//localize[@key='general_remove'][normalize-space()='Remove']")
    public WebElement removeCatg;
    @FindBy(xpath = "//umb-property[@data-element='property-postAuthor']//localize[@key='general_remove'][normalize-space()='Remove']")
    public WebElement removeAuth;
    @FindBy(xpath = "//input[@id='postDate']")
    public WebElement calInput;
    @FindBy(xpath = "//button[@class='btn-clear']")
    public WebElement calClearBtn;
    @FindBy(css = ".help-inline")
    public WebElement requiredErrorHelpString;
    @FindBy(css = ".umb-notifications")
    public WebElement validationErrorAlert;
    //summary tab
    @FindBy(xpath = "//input[@id='pageListingHeading']")
    public WebElement summaryHeading1;
    @FindBy(xpath = "//input[@id='pageListingSecondaryHeading']")
    public WebElement summaryHeading2;
    @FindBy(xpath = "//button[@aria-label='Open media picker']")
    public WebElement addImg;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement imgInput;
    @FindBy(xpath = "//umb-button[@label-key='buttons_select']//button[@type='button']")
    public WebElement selectImgBtn;
    @FindBy(css = ".umb-sortable-thumbnails__wrapper")
    public WebElement imgThumb;
    @FindBy(css = "button[aria-label='Remove']")
    public WebElement removeImg;
    //content
    @FindBy(xpath = " //input[@placeholder='Heading goes here']")
    public WebElement contentSecondHeading;
    @FindBy(xpath = " //button[@title='Delete']")
    public WebElement contentImgDeleteIcon;
    @FindBy(css = ".umb-block-list__block--content.blockelement__draggable-element.ui-sortable-handle")
    public WebElement contentMaincontentImgShadowroot;
    @FindBy(xpath = " //div[@name='overlay.name']")
    public WebElement contentImgDeleteOverlay;
    @FindBy(xpath = "//button[@umb-auto-focus='true']")
    public WebElement contentImgDeleteBtn;
    //front end
    @FindBy(xpath = "//button[normalize-space()='Dismiss all alerts']")
    public WebElement dismisallalerts;
    @FindBy(xpath = "//a[@title='Click to open ']")
    public List<WebElement> newsPostListOnFE;
    @FindBy(xpath = "//p[@class='secondary-heading lg base-secondary-heading']")
    public WebElement newsPostContentPageTitle;
    @FindBy(xpath = "//h1[@class='heading main base-heading']")
    public WebElement newsPostContentH2;
    @FindBy(xpath = "//img[@class=' lazyloaded']")
    public WebElement newsPostContentGalleryImg;
    @FindBy(id="button_mainContent")
            public WebElement mainContentBtn;


    public WebElement getPublishedStatusValue(WebElement ele) {
        return ele.findElement(By.xpath("following-sibling::ul//div[@class='umb-content-grid__details-value'][contains(.,'Published')]"));
    }

    public WebElement getLastEditedDateValue(WebElement ele) {
        return ele.findElement(By.xpath("//following-sibling::ul//div[@class='umb-content-grid__details-label'][contains(.,'Last edited:')]//following-sibling::div[@class='umb-content-grid__details-value']"));
    }

    public WebElement getCreatedbyValue(WebElement ele) {
        return ele.findElement(By.xpath("//following-sibling::ul//div[@class='umb-content-grid__details-label'][contains(.,'Created by:')]//following-sibling::div[@class='umb-content-grid__details-value']"));
    }

}
