package org.govstack.pom.cms.dashboard.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.dashboard.locators.DashboardLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class DashboardPage extends WebDriverManager {

    DashboardLocators dashboardLoc = new DashboardLocators();
    CommonMethods methods = new CommonMethods();


    public void validateDashboardHelpPages(WebElement ele, String str) {
        methods.clickElement(ele);
        methods.waitForElement(3);
        methods.switchToWindow();
        String tabUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(str, tabUrl);
        methods.closeAndSwapToParent();
    }

    public void verifyDashboardWelcomeMsg() {
        try {
            methods.waitForElement(1);
            methods.assertEqualsString(methods.getElementText(dashboardLoc.dashboardWelcomeMsg), TestData.getData("dashboard headings"));
            methods.waitForElement(1);
            ExtentReporter.log(LogStatus.PASS, "successfully verifyDashboardWelcomeMsg");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verifyDashboardWelcomeMsg");
        }

    }

    public void verifyDashboardRecentActivities() {
        try {
            methods.waitForElement(1);
            methods.assertEqualsString(methods.getElementText(dashboardLoc.dashboardRecentActivitiesHeading), TestData.getData("dashboard headings"));
            methods.waitForElement(1);
            ExtentReporter.log(LogStatus.PASS, "successfully verifyDashboardRecentActivities");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verifyDashboardRecentActivities");
        }
    }

    public void verifyDashboardMyRecentActivities() {
        try {
            methods.waitForElement(1);
            methods.assertEqualsString(methods.getElementText(dashboardLoc.dashboardYourrecentactivityHeading), TestData.getData("dashboard headings"));
            methods.waitForElement(1);
            ExtentReporter.log(LogStatus.PASS, "successfully verifyDashboardMyRecentActivities");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verifyDashboardMyRecentActivities");
        }
    }

    public void verifyDashboardPendingContent() {
        try {
            methods.waitForElement(1);
            methods.assertEqualsString(methods.getElementText(dashboardLoc.dashboardPendingcontentHeading), TestData.getData("dashboard headings"));
            methods.waitForElement(1);
            ExtentReporter.log(LogStatus.PASS, "successfully verifyDashboardPendingContent");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verifyDashboardPendingContent");
        }
    }

    public void verifyDashboardHelp() {
        try {
            methods.waitForElement(1);
            if (methods.isElementPresent(dashboardLoc.getHelpButton())) {
                methods.clickElement(dashboardLoc.getHelpButton());
                methods.waitForElement(1);
                if (methods.isElementPresent(dashboardLoc.getHelpOverlay())) {
                    //verify strings
                    methods.assertEqualsString(methods.getElementText(dashboardLoc.getHelpDeskString()), TestData.getData("dashboard help desk text"));
                    methods.waitForElement(1);
                    methods.assertEqualsString(methods.getElementText(dashboardLoc.getHelpSupport()), TestData.getData("dashboard help support text"));
                    methods.waitForElement(1);
                    methods.assertEqualsString(methods.getElementText(dashboardLoc.getHelpLearningCenter()), TestData.getData("dashboard help learning text"));
                    methods.waitForElement(1);
                    //verify pages
//                  String mainpage = getDriver().getCurrentUrl();
                    validateDashboardHelpPages(dashboardLoc.getHelpSupport(), TestData.getData("dashboard help support url"));
                    validateDashboardHelpPages(dashboardLoc.getHelpLearningCenter(), TestData.getData("dashboard help learning url"));
                    //verify close help
                    methods.waitForElement(1);
                    methods.clickElement(dashboardLoc.getHelpButton());
                    methods.waitForElement(1);
                    methods.assertTrueForElementNotPresent(dashboardLoc.getHelpOverlay());
                    methods.waitForElement(1);
                }
                ExtentReporter.log(LogStatus.PASS, "successfully verifyDashboardHelp");
            } else {
                ExtentReporter.log(LogStatus.FAIL, "DashboardHelp not available");
                Assert.fail();
            }

        } catch (NoSuchElementException e) {
            ExtentReporter.log(LogStatus.INFO, e.getMessage());
        }
    }

    //GOVPORT_014 Validate user can access dashboard
    public void ribbonClick() {
        methods.waitForElement(5);
        methods.clickElement(dashboardLoc.getNavBarIcon());
    }

    public void govstackSettingIcon() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.settingIcon());
            methods.waitForElement(2);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Setting Link Clicked successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Setting Link");
        }

    }

    public void citizenNavList() {
        methods.waitForElement(5);
        methods.clickElement(dashboardLoc.citizenLinkList());
    }

    public void subscriptionMgtNavList() {
        methods.waitForElement(5);
        dashboardLoc.clickMenuByOption("Subscription Management");
    }

    public void tenantServiceNavList() {
        methods.waitForElement(5);
        dashboardLoc.clickMenuByOption("Tenant Service");
    }

    public void businessDirectoryNavList() {
        methods.waitForElement(5);
      dashboardLoc.clickMenuByOption("Business Directory");
    }

    public void parkFacilitiesNavList() {
        methods.waitForElement(5);
        dashboardLoc.clickMenuByOption("Parks and Facilities");
    }

    public void dashboardNavList() {
        methods.waitForElement(5);
        methods.clickElement(dashboardLoc.dashboardList());
    }


    public void supportLinkMenu() {
        methods.clickElement(dashboardLoc.getHelpSupport());
    }

    public void learningCenterLinkMenu() {
        methods.clickElement(dashboardLoc.learningCenterIcon());
    }

    public void gsLogo() {
        methods.implicitWait();
        methods.clickElement(dashboardLoc.govstackLogoClick());
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "Govstack logo clicked successfully");
        methods.waitForElement(3);
    }

    public void gsEventsRibbon() {
        methods.waitForElement(5);
        dashboardLoc.clickMenuByOption("Events");
    }

    public void gsFormsRibbon() {
       dashboardLoc.clickMenuByOption("Forms");
    }

    public void gsCmsRibbon() {
        dashboardLoc.clickMenuByOption("CMS");
        methods.waitForElement(3);
        methods.clickElement(dashboardLoc.signinWithB2CbtnDashboardCMS);
    }


    public void govStackUserProfile() {
        try {
            methods.clickElement(dashboardLoc.govStackUserProfileIcon());
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Govstack user profile clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Govstack user profile.");
        }
    }

    public void govStackUserSignout() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.govStackUserSignOutLink());
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Govstack user profile sign out link clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Govstack user profile sign out link");
        }

    }

    public void govStackManageUser() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.govStackManageUserLink());
            ExtentReporter.log(LogStatus.PASS, "Govstack manage user link clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Govstack manage user link");
        }

    }

    public void supportLinkPage() {
        try {
            methods.switchToWindow();
            String tabUrl = getDriver().getCurrentUrl();
            System.out.println(tabUrl);
            ExtentReporter.log(LogStatus.PASS, "Support Link open in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open support link in new tab");
        }
    }

    public void govstackManageUserPermissionLink() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.manageuserPermissionRoles());
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Manage user Link open in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open Manage user Link");
        }
    }


    public void learningCenterLinkPage() {
        try {
            methods.switchToWindow();
            String tabUrl = getDriver().getCurrentUrl();
            System.out.println(tabUrl);
            ExtentReporter.log(LogStatus.PASS, "Learning center Link open in new tab successfully");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open Learning center link in new tab");
        }
    }

    public void dashboardUrlAssertion(String URL) {
        try {
            String tabUrl = getDriver().getCurrentUrl();
            if(tabUrl.equals(URL)) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Dashboard url open "+tabUrl);
                ExtentReporter.log(LogStatus.PASS, "Dashboard url open "+tabUrl);
            }else{
                ExtentReporter.log(LogStatus.FAIL, "URL Changed "+tabUrl);
                Assert.fail();
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open Dashboard url");
        }
    }

    public void businessDirectoryUrlAssertion(String URL) {
        try {
            methods.waitForElement(5);
            String tabUrl = getDriver().getCurrentUrl();
            if(tabUrl.contains(URL)) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, tabUrl + " url is open");
                ExtentReporter.log(LogStatus.PASS, tabUrl + " url is open");
            }else{
                ExtentReporter.log(LogStatus.FAIL,tabUrl+" URL is changed");
                Assert.fail();
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open url");
        }
    }

    public void govstackManageUserAssertion() {
        try {
            methods.switchToWindow();
            methods.implicitWait();
            businessDirectoryUrlAssertion("rolemanagement");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to open Manager user Link in new tab");
        }
    }

    public void citizenCardOpen() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.citizenCard);
            ExtentReporter.log(LogStatus.PASS, "Citizen card clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Citizen card");
        }
    }

    public void businessDirectoryCardOpen() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.businessDirectoryCard);
            ExtentReporter.log(LogStatus.PASS, "Business directory card clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Business directory card ");
        }
    }

    public void parkFacilitiesCardOpen() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.parkFacilitiesCard);
            ExtentReporter.log(LogStatus.PASS, "Park and facilities card clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Park and facilities card");
        }
    }

    public void subscriptionMgtCardOpen() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.subscriptionMgtCard);
            ExtentReporter.log(LogStatus.PASS, "Subscription management card clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Subscription management card");
        }
    }

    public void tenantCardOpen() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.tenantCard);
            ExtentReporter.log(LogStatus.PASS, "Tenant Service card clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Tenant Service card");
        }
    }


    public void eventsCardOpen() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.eventCard);
            ExtentReporter.log(LogStatus.PASS, "Events Card clicked");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Events Card");
        }
    }

    public void formsCardOpen() {
        try {
            methods.waitForElement(5);
            methods.clickElement(dashboardLoc.formsCard);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Forms Card clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Click Forms Card");
        }
    }

    public void cardHeaderValidation() {
        try {
            methods.waitForElement(5);
            methods.isElementPresent(dashboardLoc.cardHeader);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Cards is visible");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Visible card");
        }
    }


}
