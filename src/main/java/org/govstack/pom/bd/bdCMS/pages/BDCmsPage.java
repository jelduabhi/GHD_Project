package org.govstack.pom.bd.bdCMS.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdCMS.locators.BDCmsLocators;
import org.govstack.pom.cms.news.locators.NewsLocators_FrontEnd;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.testng.Assert;

public class BDCmsPage extends WebDriverManager {

    CommonMethods methods = new CommonMethods();
    BDCmsLocators BdCmsLoc = new BDCmsLocators();
    NewsLocators_FrontEnd newsLocatorsFrontEnd = new NewsLocators_FrontEnd();

    public void BD_dotIcon() {
        methods.waitForElement(3);
        methods.clickElement(BdCmsLoc.homeHamburgerIcon);
        methods.waitForElement(2);
//        methods.clickElement(siteMapLoc.menuPage);
//        methods.waitForElement(2);
//        methods.clickElement(siteMapLoc.blankPageLoc);
//        methods.waitForElement(3);
//        methods.sendTextToElement(siteMapLoc.blankPageHeadingField, TestData.getData("Heading") + "_" + methods.generateRandomString());
//        methods.waitForElement(3);
//        ExtentReporter.logWithScreenshot(LogStatus.INFO, "New page create screen in Home Page");
    }

    public void BD_createPage() {
        methods.waitForElement(3);
        methods.clickElement(BdCmsLoc.bdLandingPageLink);
        methods.waitForElement(2);
        methods.sendTextToElement(BdCmsLoc.bdHeaderField, TestData.getData("Header") + "_" + methods.generateRandomString());
        methods.waitForElement(2);
        methods.sendTextToElement(BdCmsLoc.bdHeadingField, TestData.getData("Heading") + "_" + methods.generateRandomString());
        methods.waitForElement(2);
        methods.sendTextToElement(BdCmsLoc.bdDescriptionField, TestData.getData("Description") + "_" + methods.generateRandomString());
        methods.waitForElement(2);
        methods.sendTextToElement(BdCmsLoc.bdPlaceholderField, TestData.getData("Search_Placeholder") + "_" + methods.generateRandomString());
        methods.waitForElement(2);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "BD CMS Create Page field");
    }

    public void bdMenuLinkList() {
        methods.waitForElement(3);
        methods.scrollAndClickElement(BdCmsLoc.bdMenuList);
    }

    public void bd_frontendPage_Validation_Assertion() {
        try {
            methods.waitForElement(2);
            methods.clickElement(BdCmsLoc.bdCmsDirectLink);
            methods.waitForElement(8);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            System.out.println(tabUrl);
            Assert.assertTrue(tabUrl.contains(TestData.getData("Validation")));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "BD CMS opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open BD CMS in new tab");
        }

    }

    public void bd_SectorNavSelection() {
        methods.waitForElement(2);
        methods.clickElement(BdCmsLoc.bdSectorHamburgorIcon);
    }

    public void bd_SectorPageCreateLinkSelect() {
        methods.waitForElement(2);
        methods.clickElement(BdCmsLoc.bdSectorPageCreateLink);
    }

    public void BD_SectorcreatePage() {
        methods.waitForElement(2);
        methods.sendTextToElement(BdCmsLoc.bdHeaderField, TestData.getData("Header") + "_" + methods.generateRandomString());
        methods.waitForElement(2);
        methods.sendTextToElement(BdCmsLoc.bdHeadingField, TestData.getData("Heading") + "_" + methods.generateRandomString());
        methods.waitForElement(2);
        methods.sendTextToElement(BdCmsLoc.bdDescriptionField, TestData.getData("Description") + "_" + methods.generateRandomString());
        methods.waitForElement(2);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "BD Sector Page Create field");
    }

    public void bd_SectorfrontendPage_Validation_Assertion() {
        try {
            methods.waitForElement(2);
            methods.clickElement(BdCmsLoc.bdCmsDirectLink);
            methods.waitForElement(8);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            System.out.println(tabUrl);
            Assert.assertTrue(tabUrl.contains(TestData.getData("Validation")));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "BD Sector Page opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open BD Sector Page in new tab");
        }

    }

    public void bd_SectorSelectfrontendPage_Validation_Assertion() {
        try {
            methods.waitForElement(2);
            methods.clickElement(BdCmsLoc.bdCmsDirectLink);
            methods.waitForElement(8);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            System.out.println(tabUrl);
            Assert.assertTrue(tabUrl.contains("Automation_Sector_Page_Header_"));
            methods.waitForElement(2);
            methods.clickElement(newsLocatorsFrontEnd.dismissAllAlerts);
            methods.waitForElement(2);
            methods.scrollAndClickElement(BdCmsLoc.accomodateFilterCard);
            methods.waitForElement(2);
            methods.isElementPresent(BdCmsLoc.accomodateFilterCardSelected);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Filter selected properly in BD Sector page frontend");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to select filter in BD sector page in frontend ");
        }

    }

    public void expandSelectBdSectorPage() {
        try {
            methods.waitForElement(2);
            methods.scrollAndClickElement(BdCmsLoc.bdExpandBtn);
            methods.waitForElement(2);
            methods.clickElement(BdCmsLoc.bdSectorMenuList);

            ExtentReporter.logWithScreenshot(LogStatus.PASS, "BD Sector Page opens in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open BD Sector Page in new tab");
        }
    }


}
