package org.govstack.pom.cms.disablelinksfornonpagenodes.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.disablelinksfornonpagenodes.locators.DisableLinksForNonPageNodesLocators;
import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.subnav.locators.SubNavLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;


public class DisableLInksForNonPageNodesPage extends WebDriverManager {

    CommonMethods methods = new CommonMethods();
    DisableLinksForNonPageNodesLocators dLinksLocators = new DisableLinksForNonPageNodesLocators();
    ContentMainLocators mainLocators = new ContentMainLocators();
    SubNavLocators subNavLocators = new SubNavLocators();

    public void clickOnHomeExpandBtn() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
    }

    public void expandNewsMenu() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftexpandBtns, TestData.getData("Expand Button Text"));
    }

    public void expandSEConfigMenu() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftexpandBtns, TestData.getData("Expand Button Text"));
    }

    public void expandCDMenu() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftexpandBtns, TestData.getData("Expand Button Text"));
    }

    public void clickOnLeftMenuItemFromList(List<WebElement> eleList, String str) {
        try {
            for (WebElement ele : eleList) {
                if (methods.getTextOfElementEquals(ele, str)) {
                    methods.scrollToElement(ele);
                    methods.waitForElement(1);
                    methods.clickElement(ele);
                    methods.waitForElement(1);
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL,e.getMessage());
            Assert.fail();
        }
    }

    public void navigateToNewsCatagories() {
        clickOnLeftMenuItemFromList(dLinksLocators.newslist, TestData.getData("Menu Item Text"));
    }

    public void navigateToInfo() {
        if (subNavLocators.info.isDisplayed()) {
            methods.clickElement(subNavLocators.info);
            methods.waitForElement(2);
        } else {
            methods.clickElement(dLinksLocators.more);
            methods.waitForElement(1);
            methods.clickElement(subNavLocators.info);
            methods.waitForElement(2);
        }
    }

    public void verifyLinksSection() {
        try {
            if (methods.isElementPresent(dLinksLocators.linksec)) {
                Assert.fail();
            }
        } catch (NoSuchElementException e) {
           ExtentReporter.log(LogStatus.FAIL,e.getMessage());
           Assert.fail(e.getMessage());
        }
    }

    public void navigateToNewsAuthors() {
        clickOnLeftMenuItemFromList(dLinksLocators.newslist, TestData.getData("Menu Item Text"));
    }

    public void navigateToNewsAuthorsItems() {
        methods.clickElement(dLinksLocators.authorsFirstItem);
        methods.waitForElement(2);
    }

    public void navigateToNewsPost() {
        clickOnLeftMenuItemFromList(dLinksLocators.newslist, TestData.getData("Menu Item Text"));
    }

    public void navigateToAlerts() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToAlertsItems() {
        methods.clickElement(dLinksLocators.alertsFirstItem);
        methods.waitForElement(2);
    }

    public void navigateToParsers() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToCustomIntegration() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToCDContacts() {
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToCDContactsItems() {
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
        methods.clickElement(dLinksLocators.cdContactsFirsItem);
        methods.waitForElement(2);

    }

    public void navigateToCDContactsList() {
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToSEConfig() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToSEConfigSEs() {
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToSEConfigThemeConfig() {
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToNews() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void isLinksSectionPresent() {
        if(methods.isElementPresent(dLinksLocators.linksec)){
            ExtentReporter.log(LogStatus.PASS,dLinksLocators.linksec+" is displayed");
        }else{
            ExtentReporter.log(LogStatus.FAIL,dLinksLocators.linksec+" is not displayed");
            Assert.fail();
        }
    }

    public void navigateToNewsNewsPosts() {
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
        methods.clickElement(dLinksLocators.newsPostsFirstItem);
        methods.waitForElement(2);
    }

    public void navigateToPPCalendar() {
        methods.clickElement(dLinksLocators.ppCalendar);
        methods.waitForElement(2);
    }

    public void navigateToCD() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void verifyRedirectUrlSectionNotPreset() {
        try {
            if (methods.isElementPresent(dLinksLocators.redirecturlamngmt)) {
                Assert.fail();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    public void navigateToDesign() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToDesignItems() {
        methods.clickElement(dLinksLocators.designWireframe);
        methods.waitForElement(2);
    }

    public void navigateToGlobal() {
        clickOnHomeExpandBtn();
        clickOnLeftMenuItemFromList(dLinksLocators.leftlist, TestData.getData("Menu Item Text"));
    }

    public void navigateToGlobalItems() {
        methods.clickElement(dLinksLocators.globalNavigation);
        methods.waitForElement(2);
    }
}
