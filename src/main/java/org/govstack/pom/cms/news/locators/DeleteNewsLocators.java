package org.govstack.pom.cms.news.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeleteNewsLocators extends InitElements {


    // RG_NW_2.23 News Listing Page - Backend Starts here

    @FindBy(xpath = "//div[@class=\"umb-content-grid__content\"]")
    public WebElement gridList;

    @FindBy(xpath = "//div[@class='umb-editor-sub-header__content-left']")
    public WebElement createNewsBtnVisible;

    @FindBy(xpath = "//ng-form[@class='umb-mini-search ng-pristine ng-valid']")
    public WebElement searchBtnVisible;

    @FindBy(xpath = "//button[@class='umb-layout-selector__active-layout umb-outline']")
    public WebElement thumbnailIcon;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement searchFieldNews;

    @FindBy(xpath = "//div[@class=\"umb-content-grid__content\"]")
    public List<WebElement> gridListt;


    // RG_NW_3.1 Verify setting page of news default field are available

    @FindBy(xpath = "//div[@class='umb-editor-sub-header__content-left']")
    public WebElement createPostBtn;

    @FindBy(xpath = "(//button[@ng-click='createBlank(entityType,contentType.alias)'])[1]")
    public WebElement createBlankNewsPostBtn;

    @FindBy(xpath = "//input[@id='headerName']")
    public WebElement postTitleField;

    @FindBy(xpath = "//input[@id='postDate']")
    public WebElement postDateField;

    @FindBy(xpath = "//button[@id='postCategories']")
    public WebElement postCategoryField;

    @FindBy(xpath = "//button[@id='postAuthor']")
    public WebElement authorField;

    @FindBy(xpath = "(//span[@id='disableComments'])[1]")
    public WebElement disableCommentToggle;

    @FindBy(xpath = "(//button[@id='sendSubscriberNotification'])[1]")
    public WebElement sendSubsriberNotificationToogle;

    @FindBy(xpath = "(//div[@role='application'])[1]")
    public WebElement customMessageField;

    //RG_NW_3.4 Verify summary page of news default fields are available

    @FindBy(xpath = "//button[contains(text(),' Summary ')]")
    public WebElement summaryTab;

    @FindBy(xpath = "//input[@id='pageListingHeading']")
    public WebElement headingFieldNews;

    @FindBy(xpath = "//input[@id='pageListingSecondaryHeading']")
    public WebElement secondaryHeadingFieldNews;

    @FindBy(xpath = "(//div[@role='application'])[2]")
    public WebElement textFieldNews;

    @FindBy(xpath = "//div[@data-element='sortable-thumbnails']")
    public WebElement imageFielddNews;

    //RG_NW_3.5 Verify navigation page of post default fields are available
    @FindBy(xpath = "//button[contains(text(),' Navigation ')]")
    public WebElement navigationTabPost;

    @FindBy(xpath = "//span[@id='umbracoNaviHide']")
    public WebElement hideNavigationTogglePost;

    @FindBy(xpath = "//span[@id='hideFromInternalSearch']")
    public WebElement hideInternalSearchTogglePost;

    @FindBy(xpath = "//span[@id='hideBreadcrumb']")
    public WebElement hideBreadCrumbTogglePost;

    @FindBy(xpath = "//input[@id='breadcrumbLinkText']")
    public WebElement breadCrumbLinkTextPost;

    //RG_NW_3.8 Verify advance page of post default field are available
    @FindBy(xpath = "//button[contains(text(),' Advanced ')]")
    public WebElement advancedTabPost;

    @FindBy(xpath = "//span[@id='hideWebsiteHeaderSection']")
    public WebElement hidewebsiteHeaderAdvancedTab;

    @FindBy(xpath = "//span[@id='hideWebsiteFooterSection']")
    public WebElement hidewebsiteFooterAdvancedTab;

    @FindBy(xpath = "//button[@id='overrideWebsiteStyle']")
    public WebElement overideDesignStyleAdvancedTab;

    @FindBy(xpath = "//span[@id='overrideWebsiteLogo']")
    public WebElement overideWebsiteLogoAdvancedTab;

    @FindBy(xpath = "//input[@id='customBodyClasses']")
    public WebElement customPageClassAdvancedTab;

    @FindBy(xpath = "//span[@id='disableDelete']")
    public WebElement disableDeleteAdvancedTab;

    //RG_NW_3.6 Verify SEO and share page of post default field are available

    @FindBy(xpath = "//button[contains(text(),' SEO & Share')]")
    public WebElement seoTabPost;

    @FindBy(xpath = "//input[@placeholder='Your web page title goes here']")
    public WebElement seoPageTitle;

    @FindBy(xpath = "//textarea[@placeholder='Your web page description goes here']")
    public WebElement seoPageDescription;

    @FindBy(xpath = "//umb-property[@data-element='property-openGraphImage']//ul[@class='umb-sortable-thumbnails ng-pristine ng-untouched ng-valid ng-not-empty']")
    public WebElement seoPageSocialImage;

    @FindBy(xpath = "//input[@id='twitterCreatorUsername']")
    public WebElement seoPageTwitter;

    @FindBy(xpath = "//span[@id='hideFromSearchEngines']")
    public WebElement seoPageHideSearchEngine;

    @FindBy(xpath = "//span[@id='stopInternalLinksBeingFollowed']")
    public WebElement seoPageStopInternalLink;

    @FindBy(xpath = "(//div[@class='noUi-base'])[3]")
    public WebElement seoPageHideSitexmlPriority;

    @FindBy(xpath = "//div[@class='umb-box']//div[@class='controls']//label[1]")
    public WebElement seoPageHideSitexmlChange;

    @FindBy(xpath = "//input[@id='overrideCanonicalURL']")
    public WebElement seoPageCanonicalURL;

    @FindBy(xpath = "//input[@id='umbracoUrlAlias']")
    public WebElement seoPageAlternateURL;

    @FindBy(xpath = "//input[@id='umbracoUrlName']")
    public WebElement seoPageAlternateName;

    //RG_NW_3.7 Verify on script page default field are available

    @FindBy(xpath = "//button[contains(text(),' Scripts ')]")
    public WebElement scriptTabPost;

    @FindBy(xpath = "//label[normalize-space()='Header opening scripts']")
    public WebElement labelText1;

    @FindBy(xpath = "//label[normalize-space()='Header closing scripts']")
    public WebElement labelText2;

    @FindBy(xpath = "//label[normalize-space()='After opening body scripts']")
    public WebElement labelText3;

    @FindBy(xpath = "//label[normalize-space()='Before closing body scripts']")
    public WebElement labelText4;

    //RG_NW_4.3 Verify Items per page field is editable in news screen

    @FindBy(xpath = "//label[contains(@class,'itemsRow_7')]")
    public WebElement rowSelectionNewsSetting;

    @FindBy(xpath = "(//button[@data-element='tree-item-expand'])[1]")
    public WebElement homeBtn;

    @FindBy(xpath = "//a[@class='umb-tree-item__label'][normalize-space()='News']")
    public WebElement newsBtn;

    @FindBy(xpath = "//button[@class='btn btn-success dropdown-toggle umb-button-group__toggle ']")
    public WebElement requestPublishIcon;

    @FindBy(xpath = "//button[contains(@data-element,'button-saveAndPublish')]")
    public WebElement savePublish;

    @FindBy(xpath = "//span[normalize-space()='Save and publish']")
    public WebElement savePublishpopUp;

    //RG_NW_3.7 Verify on script page default field are available
    @FindBy(xpath = "//button[contains(text(),'Extra Content')]")
    public WebElement extraContentTabPost;

    @FindBy(xpath = "//span[@id='hideDefaultTopComponents']")
    public WebElement hideGlobalComponentExtraContentTab;

    @FindBy(xpath = "//button[@id='button_aboveMainContent']")
    public WebElement aboveMainContentExtraContentTab;

    @FindBy(xpath = "//button[@id='button_belowMainContent']")
    public WebElement belowMainContentExtraContentTab;

    @FindBy(xpath = "//span[@id='hideDefaultBottomComponents']")
    public WebElement hideGlobalBottomContentExtraContentTab;

    @FindBy(xpath = "//span[@id='hideDefaultPods']")
    public WebElement hideGlobalPodsContentExtraContentTab;

    @FindBy(xpath = "//button[@id='button_pagePods']")
    public WebElement podsExtraContentTab;


}
