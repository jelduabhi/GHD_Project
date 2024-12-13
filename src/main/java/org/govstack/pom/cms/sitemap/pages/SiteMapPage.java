package org.govstack.pom.cms.sitemap.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.sitemap.locators.SiteMapLocator;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;

public class SiteMapPage extends WebDriverManager {
    ContentMainLocators mainLocators = new ContentMainLocators();
    CommonMethods methods = new CommonMethods();
    SiteMapLocator siteMapLoc = new SiteMapLocator();

    public void selectHomeContent() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);

    }

    public void siteMapXmlMenu() {
        methods.waitForElement(4);
        methods.scrollAndClickElement(siteMapLoc.siteMapXmlMenuList);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Sitemap XML menu clicked");
        methods.waitForElement(2);
    }

    public void robotsTxtMenu() {
        methods.waitForElement(4);
        methods.scrollAndClickElement(siteMapLoc.robotTxtMenuList);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Robot TXT menu clicked");
        methods.waitForElement(2);
    }

    public void infoTabLink() {
        methods.waitForElement(4);
        methods.clickElement(siteMapLoc.infoTab);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Info link clicked");
    }

    public void sitemampXmlLinkClick() {
        methods.waitForElement(3);
        methods.clickElement(siteMapLoc.siteMapLink);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Sitexml link clicked");
    }

    public void robotTxtLinkClick() {
        methods.waitForElement(3);
        methods.clickElement(siteMapLoc.robotTxtLink);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Robot txt link clicked");
    }

    public void newPageCreate() {
        methods.waitForElement(3);
        methods.clickElement(siteMapLoc.homeHamburgerIcon);
        methods.waitForElement(2);
        methods.clickElement(siteMapLoc.menuPage);
        methods.waitForElement(2);
        methods.clickElement(siteMapLoc.blankPageLoc);
        methods.waitForElement(3);
        methods.sendTextToElement(siteMapLoc.blankPageHeadingField, TestData.getData("Heading") + "_" + methods.generateRandomString());
        methods.waitForElement(3);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "New page create screen in Home Page");
    }

    public void subsitePageCreate() {
        methods.waitForElement(3);
        methods.scrollAndClickElement(siteMapLoc.subsitePageMenu);
        methods.waitForElement(2);
        methods.clickElement(siteMapLoc.subsiteHamburgerIcon);
        methods.waitForElement(2);
        methods.clickElement(siteMapLoc.subsiteMenuPage);
        methods.waitForElement(2);
        methods.clickElement(siteMapLoc.blankPageLoc);
        methods.waitForElement(3);
        methods.sendTextToElement(siteMapLoc.blankPageHeadingField, TestData.getData("Heading") + "_" + methods.generateRandomString());
        methods.waitForElement(3);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Subsite Create Page screen");
    }

    public void SiteMapRobotLinkpageOpenNewTab() {
        try {
            methods.waitForElement(8);
            methods.switchToWindow();
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Sitemap / robot link open in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open Sitemap / robot link url in new tab");
        }
    }

}
