package org.govstack.pom.cms.news.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.cms.alerts.locators.AlertLocators;
import org.govstack.pom.cms.alerts.pages.AlertPage;
import org.govstack.pom.cms.news.locators.DeleteNewsLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class DeleteNewsPage {

    CommonMethods methods = new CommonMethods();
    DeleteNewsLocators deleteNewsLocators = new DeleteNewsLocators();
    AlertLocators alertLocators = new AlertLocators();


    public void deletedNews() {
        AlertPage.alertTitle = methods.getElementText(alertLocators.alertsTitles.getFirst());
        methods.clickElement(alertLocators.alertsLists.getFirst());
        methods.clickElement(alertLocators.deleteBtn);
        methods.clickElement(alertLocators.yesDeleteBtn);
        methods.waitForElement(1);
    }


    public void postListing() {
        ExtentReporter.log(LogStatus.INFO, "Grid List is displayed");
        Assert.assertTrue(deleteNewsLocators.gridList.isDisplayed());

    }

    public void createNewsPostBtnAssertion() {
        if(methods.isElementPresent(deleteNewsLocators.createNewsBtnVisible)){
            ExtentReporter.log(LogStatus.INFO, "Create News post button is visible");
        }else {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Create News post button is not visible");
            Assert.fail();
        }
    }

    public void searchBtnVisibleAssertion() {
        if(methods.isElementPresent(deleteNewsLocators.searchBtnVisible)){
            ExtentReporter.log(LogStatus.INFO, "Search button is visible");
        }else {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Search button is not displayed");
            Assert.fail();
        }
    }

    public void thumbnailIconVisibleAssertion() {
        if(methods.isElementPresent(deleteNewsLocators.thumbnailIcon)){
            ExtentReporter.log(LogStatus.INFO, "ThumbnailIcon is displayed");
        }else {
            ExtentReporter.log(LogStatus.FAIL, "ThumbnailIcon is not displayed");
            Assert.fail();
        }
    }

    public void validSearchList() {
        if(methods.isElementPresent(deleteNewsLocators.searchBtnVisible)){
            ExtentReporter.log(LogStatus.INFO, "Search button is displayed");
        }else {
            ExtentReporter.log(LogStatus.FAIL, "Search button is not displayed");
            Assert.fail();
        }
    }

    public void searchFieldText(String searchText) {
        ExtentReporter.log(LogStatus.INFO, "Search the text in search field");
        deleteNewsLocators.searchFieldNews.sendKeys(searchText);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Search the text in search field");

    }

    public void listingResult() {
        ExtentReporter.log(LogStatus.INFO, "Post search related field visible");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Post search related field visible");
        for (WebElement option : deleteNewsLocators.gridListt) {
            String optionText = option.getText();
            if (optionText.equals("Automation")) {
                Assert.assertTrue(true);
                break;
            }
        }
    }


    // RG_NW_3.1 Verify setting page of news default field are available

    public void createPostButton() {
        ExtentReporter.log(LogStatus.INFO, "Create Post Button Clicked");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Create Post Button Clicked");
        methods.clickElement(deleteNewsLocators.createPostBtn);
        methods.clickElement(deleteNewsLocators.createBlankNewsPostBtn);
    }

    public void createPostButtonPentest() {
        ExtentReporter.log(LogStatus.INFO, "Create Post Button Clicked");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Create Post Button Clicked");
        methods.clickElement(deleteNewsLocators.createPostBtn);
    }


    public void newsDefaultSettingFieldsAssertion() {
        ExtentReporter.log(LogStatus.INFO, "postTitleField,postDateField,postCategoryField,authorField,disableCommentToggle,sendSubsriberNotificationToogle,customMessageField");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "postTitleField,postDateField,postCategoryField,authorField,disableCommentToggle,sendSubsriberNotificationToogle,customMessageField");
        Assert.assertTrue(deleteNewsLocators.postTitleField.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.postDateField.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.postCategoryField.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.authorField.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.disableCommentToggle.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.sendSubsriberNotificationToogle.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.customMessageField.isDisplayed());
    }

    //RG_NW_3.4 Verify summary page of news default fields are available

    public void summaryTabNewsss() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Summary Tab clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Summary Tab clicked");
            deleteNewsLocators.summaryTab.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public void summaryTabValidField() {
        ExtentReporter.log(LogStatus.INFO, "Heading,Secondary Heading,Text,Image is displayed");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Heading,Secondary Heading,Text,Image is displayed");
        Assert.assertTrue(deleteNewsLocators.headingFieldNews.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.secondaryHeadingFieldNews.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.textFieldNews.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.imageFielddNews.isDisplayed());
    }

    //RG_NW_3.5 Verify navigation page of post default fields are available

    public void navigationTab() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Navigation Tab clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Navigation Tab clicked");
            methods.clickElement(deleteNewsLocators.navigationTabPost);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void navigationTabValidField() {
        ExtentReporter.log(LogStatus.INFO, "navigation page ie Hide from all navigation, Hide from internal search, Hide breadcrumb, Breadcrumb link text is displayed");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "navigation page ie Hide from all navigation, Hide from internal search, Hide breadcrumb, Breadcrumb link text is displayed");
        Assert.assertTrue(deleteNewsLocators.hideNavigationTogglePost.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.hideInternalSearchTogglePost.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.hideBreadCrumbTogglePost.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.breadCrumbLinkTextPost.isDisplayed());
    }

    //RG_NW_3.8 Verify advance page of post default field are available

    public void advancedTab() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Advanced Tab clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Advanced Tab clicked");
            methods.clickElement(deleteNewsLocators.advancedTabPost);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void advancedTabValidField() {
        ExtentReporter.log(LogStatus.INFO, "fields available on advanced page ie Hide website header,Hide website footer,Override design style,Override website logo,Override content,Custom page classes,Disable delete");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "fields available on advanced page ie Hide website header,Hide website footer,Override design style,Override website logo,Override content,Custom page classes,Disable delete");
        Assert.assertTrue(deleteNewsLocators.hidewebsiteHeaderAdvancedTab.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.hidewebsiteFooterAdvancedTab.isDisplayed());
        methods.scrollToElement(deleteNewsLocators.overideDesignStyleAdvancedTab);
        Assert.assertTrue(deleteNewsLocators.overideDesignStyleAdvancedTab.isDisplayed());
        methods.scrollToElement(deleteNewsLocators.overideWebsiteLogoAdvancedTab);
        Assert.assertTrue(deleteNewsLocators.overideWebsiteLogoAdvancedTab.isDisplayed());
        methods.scrollToElement(deleteNewsLocators.customPageClassAdvancedTab);
        Assert.assertTrue(deleteNewsLocators.customPageClassAdvancedTab.isDisplayed());
        methods.scrollToElement(deleteNewsLocators.disableDeleteAdvancedTab);
        Assert.assertTrue(deleteNewsLocators.disableDeleteAdvancedTab.isDisplayed());

    }

    //RG_NW_3.6 Verify SEO and share page of post default field are available

    public void seoTab() {
        try {
            ExtentReporter.log(LogStatus.INFO, "SEO & Share Tab clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "SEO & Share Tab clicked");
            methods.clickElement(deleteNewsLocators.seoTabPost);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void seoTabValidField() {
        ExtentReporter.log(LogStatus.INFO, "verify default field available in seo and share page");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "verify default field available in seo and share page");
        Assert.assertTrue(deleteNewsLocators.seoPageTitle.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageDescription.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageSocialImage.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageTwitter.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageHideSearchEngine.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageStopInternalLink.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageHideSitexmlPriority.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageHideSitexmlChange.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageCanonicalURL.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageAlternateURL.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.seoPageAlternateName.isDisplayed());

    }


    //RG_NW_3.7 Verify on script page default field are available

    public void scriptsTab() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Scripts Tab clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Scripts Tab clicked");
            methods.clickElement(deleteNewsLocators.scriptTabPost);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scriptsTabValidField() {
        ExtentReporter.log(LogStatus.INFO, "verify default field available in scripts page");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "verify default field available in scripts page");
        Assert.assertTrue(deleteNewsLocators.labelText1.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.labelText2.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.labelText3.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.labelText4.isDisplayed());
    }

    //RG_NW_4.3 Verify Items per page field is editable in news screen

    public void rowSelectionCustomNews() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Rows selected from custom news settings tab");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Rows selected from custom news settings tab");
            methods.clickElement(deleteNewsLocators.rowSelectionNewsSetting);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void customNewsMenu() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Custom news menu clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Custom news menu clicked");
            methods.clickElement(deleteNewsLocators.homeBtn);
            methods.clickElement(deleteNewsLocators.newsBtn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void requestPublishBtnIcon() {
        ExtentReporter.log(LogStatus.INFO, "Request and Publish icon clicked");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Request and Publish icon clicked");
        methods.clickElement(deleteNewsLocators.requestPublishIcon);
    }

    public void savePublishBtn() {
        ExtentReporter.log(LogStatus.INFO, "save publish link clicked");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "save publish link clicked");
        methods.clickElement(deleteNewsLocators.savePublish);

    }

    public void savePublishPopupBtn() {
        ExtentReporter.log(LogStatus.INFO, "save & publish button clicked on pop up screen");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "save & publish button clicked on pop up screen");
        methods.clickElement(deleteNewsLocators.savePublishpopUp);

    }

    //RG_NW_3.7 Verify on script page default field are available
    public void extraContentTab() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Extra Content Tab clicked");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Extra Content Tab clicked");
            methods.clickElement(deleteNewsLocators.extraContentTabPost);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void extraContentTabValidFields() {
        ExtentReporter.log(LogStatus.INFO, "Default fields available in extra content tab screen.");
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Default fields available in extra content tab screen.");
        Assert.assertTrue(deleteNewsLocators.hideGlobalComponentExtraContentTab.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.aboveMainContentExtraContentTab.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.belowMainContentExtraContentTab.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.hideGlobalBottomContentExtraContentTab.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.hideGlobalPodsContentExtraContentTab.isDisplayed());
        Assert.assertTrue(deleteNewsLocators.podsExtraContentTab.isDisplayed());

    }


}
