package org.govstack.pom.cms.news.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsLocators extends InitElements {

    @FindBy(id = "displayAuthors")
    public WebElement displayAuthorsToggle;

    @FindBy(id = "displayCategories")
    public WebElement displayCategoriesToggle;

    @FindBy(id = "displayDates")
    public WebElement displayDatesToggle;


    @FindBy(xpath = "//div[@class='umb-editor-sub-header__content-left']")
    public WebElement createNewsPost;

    @FindBy(xpath = "(//button[@ng-click='createBlank(entityType,contentType.alias)'])[1]")
    public WebElement createBlankNewsPost;


    /**
     * Settings Section
     **/
    @FindBy(id = "headerName")
    public WebElement headerNameTxt;

    @FindBy(xpath = "//span[@icon='icon-calendar']")
    public WebElement datePicker;
    @FindBy(xpath = "//div[@class='dayContainer']/span")
    public List<WebElement> postDateTxt;

    @FindBy(xpath = "//button[@id='postCategories']")
    public WebElement postCategoriesBtn;
    @FindBy(xpath = "//a[@class='umb-tree-item__label']")
    public List<WebElement> selectCategory;
    @FindBy(xpath = "//umb-button[@label-key='general_submit']/div/button")
    public WebElement submitBtn;
    @FindBy(xpath = "//button[@id='postAuthor']")
    public WebElement authorBtn;
    @FindBy(xpath = "//div[@class='umb-table-cell black umb-minilistview__fade-not-allowed']")
    public List<WebElement> selectAuthor;
    @FindBy(xpath = "//button[@id='sendSubscriberNotification']")
    public WebElement sendSubscriberNotification;


    /**
     * Content
     **/
    @FindBy(xpath = "(//button[contains(text(),'Content')])[1]")
    public WebElement contentMenuBtn;
    @FindBy(xpath = "//label[@class='usn-item item  pageLayoutFull']")
    public WebElement layoutFullLnk;
    @FindBy(xpath = "//label[@class='usn-item item  pageLayoutLeft']")
    public WebElement layoutLeftLnk;
    @FindBy(xpath = "//label[@class='usn-item item  pageLayoutRight']")
    public WebElement layoutRightLnk;
    @FindBy(xpath = "//span[@id='removePageHeading']")
    public WebElement removePageHeadingsToggle;
    @FindBy(xpath = "//input[@id='onPageTitle']")
    public WebElement pageTitleTxt;
    @FindBy(xpath = "//input[@placeholder='Heading goes here']")
    public WebElement secondaryHeadingTxt;
    @FindBy(xpath = "//div[text()='S']")
    public WebElement contentSecondaryHeadingFont_S;
    @FindBy(xpath = "//div[text()='M']")
    public WebElement contentSecondaryHeadingFont_M;
    @FindBy(xpath = "//div[text()='L']")
    public WebElement contentSecondaryHeadingFont_L;
    @FindBy(xpath = "//iframe[contains(@id,'pageSummary')]")
    public WebElement pageSummaryFrame;
    @FindBy(id = "tinymce")
    public WebElement textTxt;

    @FindBy(xpath = "(//button[@aria-label='Open media picker'])[1]")
    public WebElement imageButton;
    @FindBy(xpath = "//input[@id='datatype-search']")
    public WebElement searchImageLnk;
    @FindBy(xpath = "//div[@data-element='media-grid-item-0']")
    public WebElement selectImagelnk;
    @FindBy(xpath = "(//umb-button[@button-style=\"success\"]/div/button)[2]")
    public WebElement summarySelectBtn;

    @FindBy(xpath = "//div[@name='node.name']/div/button")
    public List<WebElement> deleteButton;

    /**
     * Summary
     **/
    @FindBy(xpath = "//button[contains(text(),'Summary')]")
    public WebElement summaryBtn;
    @FindBy(id = "pageListingHeading")
    public WebElement pageListingHeadingTxt;
    @FindBy(id = "pageListingSecondaryHeading")
    public WebElement pageListingSecondaryHeadingTxt;


    @FindBy(xpath = "//input[contains(@id,'search')]")
    public WebElement searchTxt;

    @FindBy(xpath = "//a[@class='umb-content-grid__item-name umb-outline']/span[2]")
    public List<WebElement> results;


    @FindBy(xpath = "//a[@class='umb-content-grid__item-name umb-outline']/span[2]")
    public List<WebElement> newsLists;

    @FindBy(xpath = "//a[@class='umb-content-grid__item-name umb-outline -light']/span[2]")
    public List<WebElement> unPublishedNewsLists;

    @FindBy(xpath = "//localize[@key='content_unpublished']")
    public WebElement newsStatus;
}
