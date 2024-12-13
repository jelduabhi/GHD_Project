package org.govstack.pom.cms.contentMain.pages;

import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.ConfigurationManager;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.utils.CommonMethods;

import java.util.Objects;

public class ContentMainPage extends WebDriverManager {

    ContentMainLocators mainLocators = new ContentMainLocators();
    CommonMethods methods = new CommonMethods();

    public void selectTheContent() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollToElement(mainLocators.newsExpandBtn);
        methods.clickElement(mainLocators.newsExpandBtn);
        methods.waitForElement(2);
        methods.clickElement(mainLocators.postsBtn);
        methods.waitForElement(2);
    }

    public void expandMainContent() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        if (Objects.equals(ConfigurationManager.getPropertyValue("ENV"), "QA")) {
            methods.clickElement(mainLocators.pageExpandLnk_QA);
        } else {
            methods.clickElement(mainLocators.pageExpandLnk_STAGE);
        }
    }

    public void expandSubNavContent() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.clickElement(mainLocators.pageExpandLnk_STAGE);
        methods.clickElement(mainLocators.pageExpandSubNavLnk);
    }


    public void selectAlertsContent() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectAlerts);
        methods.waitForElement(2);
    }

    //@RG_CP_1.1 for selecting page not found menu
    public void pageNotFoundContent() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.pageNotFoundBtn);
        methods.waitForElement(2);
    }

    public void selectContactsCategoryFolder() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.clickElement(mainLocators.contactDirectoryExpandBtn.getFirst());
        methods.waitForElement(1);
        methods.clickElement(mainLocators.contactDirectoryEllipsisBtn);
        methods.clickElement(mainLocators.contactsCategoryFolderBtn);
        methods.waitForElement(1);
    }

    public void selectContactsCategory() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollToElement(mainLocators.contactDirectoryExpandBtn.getFirst());
        methods.clickElement(mainLocators.contactDirectoryExpandBtn.getFirst());
        methods.waitForElement(1);
        methods.scrollToElement(mainLocators.contactCategoryEllipsisBtn.getFirst());
        methods.clickElement(mainLocators.contactCategoryEllipsisBtn.getFirst());
        methods.clickElement(mainLocators.contactsCategoryBtn);
        methods.waitForElement(1);
    }

    public void selectBlogContent() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectBlogs);
        methods.waitForElement(2);
    }

    public void newsMainPage() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectNewsLnk);
        methods.waitForElement(2);
    }

    public void mainHomePage() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectMainHome);
        methods.waitForElement(2);
    }

    public void parserMainPage() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectParsers);
        methods.waitForElement(2);
        methods.clickElement(mainLocators.createParserBtn);
        methods.waitForElement(2);
    }

    public void subscribeMainPage() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectSubscribe);
    }

    public void subscribeConfirmPage() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.expandSubscribe);
        methods.waitForElement(2);
        methods.clickElement(mainLocators.selectConfirmSubscribe);
    }

    public void subscribeUnSubscribePage() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.expandSubscribe);
        methods.waitForElement(2);
        methods.clickElement(mainLocators.selectUnSubscribe);
    }

    public void pageLayoutAutomationMainPage() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectPageLayoutAutomation);
    }

    public void expandContactCategory() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollToElement(mainLocators.contactDirectoryExpandBtn.getFirst());
        methods.clickElement(mainLocators.contactDirectoryExpandBtn.getFirst());
        methods.waitForElement(1);
        methods.scrollToElement(mainLocators.contactCategoryExpandBtn.getFirst());
        methods.clickElement(mainLocators.contactCategoryExpandBtn.getFirst());
        methods.waitForElement(1);
    }

    public void selectContactLists() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.clickElement(mainLocators.contactDirectoryExpandBtn.getFirst());
        methods.waitForElement(1);
        methods.clickElement(mainLocators.contactListLnk);
        methods.waitForElement(1);
    }

    public void navigateToSearchEngineConfig(){
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(1);
        methods.clickElement(mainLocators.searchEngineExpandBtn);
        methods.waitForElement(1);
    }

    public void navigateToPFPage(){
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(1);
        methods.clickElement(mainLocators.mainPageEllipsisBtn);
        methods.waitForElement(3);
        methods.clickElement(mainLocators.pfPage);
        methods.waitForElement(2);
    }

    public void navigateToMediaPages(){
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(1);
        methods.clickElement(mainLocators.mediaManagerExpandBtn);
        methods.waitForElement(1);
        methods.clickElement(mainLocators.mediaPagesExpandBtn);
        methods.waitForElement(2);
    }

    public void navigateToMediaManagerCategories(){
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(1);
        methods.clickElement(mainLocators.mediaManagerExpandBtn);
        methods.waitForElement(1);
        methods.clickElement(mainLocators.selectMediaManagerCategories);
        methods.waitForElement(2);
    }
}
