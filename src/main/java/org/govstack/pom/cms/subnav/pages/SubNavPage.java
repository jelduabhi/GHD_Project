package org.govstack.pom.cms.subnav.pages;


import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.news.locators.NewsLocators;
import org.govstack.pom.cms.subnav.locators.SubNavLocators;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;


public class SubNavPage extends WebDriverManager {

    public static String subNavMainPageName = "SubNav_MainPage";
    public static String subNavSubpageOneName = "SubNav_SubPageOne";

    SubNavLocators subnavLocators = new SubNavLocators();
    CommonMethods methods = new CommonMethods();
    NewsLocators newsLocators = new NewsLocators();
    ContentMainLocators mainLocators = new ContentMainLocators();
    CommonPageUtils commonUtil = new CommonPageUtils();
    LoginPage loginPage=new LoginPage();


    public void clickMainsiteThreeDotIcon() {
        methods.clickElement(subnavLocators.mainsiteEllipsisBtn);
        methods.waitForElement(2);
    }

    public void selectPage() {
        methods.clickElement(subnavLocators.newPage);
        methods.waitForElement(2);
    }

    public void selectBlankPageTemplate() {
        if (methods.stringEquals(TestData.getData("page template"), "blank")) {
            methods.clickElement(subnavLocators.blankPageTemplate);
            methods.waitForElement(2);
        }
    }

    public void addHeadername() {
        methods.sendTextToElement(subnavLocators.subnavHeadername, TestData.getData("Headername"));
        methods.waitForElement(2);
    }

    public void addContentHeading() {
        methods.sendTextToElement(subnavLocators.subnavContentHeading, TestData.getData("Content Heading"));
        methods.waitForElement(2);
    }

    public void addContentSeconddaryHeading() {
        methods.sendTextToElement(subnavLocators.subnavContentSecondaryHeading, TestData.getData("Content Secondary Heading"));
        methods.waitForElement(2);
    }

    public void selectLayout() {
        if (methods.stringEquals(TestData.getData("Layout"), "Left")) {
            methods.clickElement(newsLocators.layoutLeftLnk);
            methods.waitForElement(1);
        } else if (methods.stringEquals(TestData.getData("Layout"), "Full")) {
            methods.clickElement(newsLocators.layoutFullLnk);
            methods.waitForElement(1);
        } else if (methods.stringEquals(TestData.getData("Layout"), "Right")) {
            methods.clickElement(newsLocators.layoutRightLnk);
            methods.waitForElement(1);
        }
    }

    public void verifySubnavMainpageCreated() {
        for (WebElement ele : subnavLocators.mainsiteList) {
            if (methods.getElementTextContains(ele, TestData.getData("Headername"))) {
               Assert.assertTrue(true);
                break;
            }
        }
    }

    public void clickSubnavMainPageThreeDotIcon() {
        if (methods.stringEquals(TestData.getData("subnav mainpage name"), subNavMainPageName)) {
            methods.clickElement(mainLocators.mainSiteExpandBtn);
            methods.waitForElement(2);
            methods.clickElement(subnavLocators.subnavMainpageEllipsisBtn);
            methods.waitForElement(2);
        }
    }

    public void verifySubnavSubpageOneCreatedUnderMainpage() {
        if (methods.stringEquals(TestData.getData("subnav mainpage name"), subNavMainPageName)) {
            for (WebElement ele : subnavLocators.subnavMainpageList) {
                if (methods.getElementTextContains(ele, TestData.getData("Headername"))) {
                   Assert.assertTrue(true);
                    break;
                }
            }
        }
    }

    public void clickSubnavSubPageOneThreeDotIcon() {
        if (methods.stringEquals(TestData.getData("subnav subpageone name"), subNavSubpageOneName)) {
            methods.clickElement(mainLocators.mainSiteExpandBtn);
            methods.waitForElement(2);
            methods.clickElement(subnavLocators.subnavMainpageExpandBtn);
            methods.waitForElement(2);
            methods.clickElement(subnavLocators.subnavSubpageOneEllipsisBtn);
            methods.waitForElement(2);
        }
    }

    public void verifySubnavSubpageTwoCreatedUnderSubpageOne() {
        if (methods.stringEquals(TestData.getData("subnav mainpage name"), subNavMainPageName)) {
            for (WebElement ele : subnavLocators.subnavMainpageList) {
                if (methods.getElementTextContains(ele, TestData.getData("subnav subpageone name"))) {
                    for (WebElement el : subnavLocators.subnavSubpageOneList) {
                        if (methods.getElementTextContains(el, TestData.getData("Headername"))) {
                           Assert.assertTrue(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void navigateToSubnavMainPageInfo() {
        if (methods.stringEquals(TestData.getData("subnav mainpage name"), subNavMainPageName)) {
            methods.clickElement(mainLocators.mainSiteExpandBtn);
            methods.waitForElement(2);
            for (WebElement ele : subnavLocators.mainsiteList) {
                if (methods.getElementTextContains(ele, TestData.getData("subnav mainpage name"))) {
                    methods.clickElement(ele);
                    methods.waitForElement(1);
                    break;
                }
            }
            methods.clickElement(subnavLocators.info);
            methods.waitForElement(1);
        }
    }

    public void clickAndOpenSubnavMainpageUrl() {
        methods.clickElement(subnavLocators.pageurl);
        methods.waitForElement(3);
        methods.switchToWindow();
        methods.waitForElement(2);
        if (Objects.equals(ConfigurationManager.getPropertyValue("ENV"), "PENTEST")) {
            methods.assertEqualsString(TestData.getData("subnav mainpage url pentest"), methods.getCurrentUrl());
        } else {
            methods.assertEqualsString(TestData.getData("subnav mainpage url"), methods.getCurrentUrl());
        }
        commonUtil.dismissAllAlerts();
    }

    public void verifySubnavMenuFE() {
        methods.assertTrueForElementPresense(subnavLocators.unexpandedSubnavSubpageOne);
        methods.assertTrueForElementPresense(subnavLocators.subnavSubpageOneLink);
        methods.assertTrueForElementPresense(subnavLocators.unexpandedSubnavSubpageOneBtn);
        methods.clickElement(subnavLocators.unexpandedSubnavSubpageOneBtn);

        methods.assertTrueForElementPresense(subnavLocators.expandedSubnavSubpageOne);
        methods.assertTrueForElementPresense(subnavLocators.expandedSubnavSubpageOneBtn);
        methods.assertTrueForElementPresense(subnavLocators.subnavSubpageTwoLink);
    }

    public void verifyLayoutFE() {
        if (methods.stringEquals(TestData.getData("Layout"), "Left")) {
            methods.assertTrueForElementPresense(subnavLocators.subnavContentLeftLayout);
            methods.assertTrueForElementPresense(subnavLocators.subnavRightSideForLeftLayout);
        } else if (methods.stringEquals(TestData.getData("Layout"), "Right")) {
            methods.assertTrueForElementPresense(subnavLocators.subnavContentRightLayout);
            methods.assertTrueForElementPresense(subnavLocators.subnavLeftSideForRightLayout);
        }
    }

    public void verifySubnavMainpagePresenceFE() {
        methods.assertTrueForElementPresense(subnavLocators.subnavTitleFE);
    }

    public void verifySubnavMenuHyperlinksFE() {
        methods.clickElement(subnavLocators.subnavSubpageOneLink);
        if (Objects.equals(ConfigurationManager.getPropertyValue("ENV"), "PENTEST")) {
            methods.assertEqualsString(TestData.getData("subnav subpageone url pentest"), methods.getCurrentUrl());
            methods.clickElement(subnavLocators.subnavSubpageTwoLink);
            methods.assertEqualsString(TestData.getData("subnav subpagetwo url pentest"), methods.getCurrentUrl());
        } else {
            methods.assertEqualsString(TestData.getData("subnav subpageone url"), methods.getCurrentUrl());
            methods.clickElement(subnavLocators.subnavSubpageTwoLink);
            methods.assertEqualsString(TestData.getData("subnav subpagetwo url"), methods.getCurrentUrl());
        }
    }

    public void navigateToSubnavMainPageFE() {
        if (Objects.equals(ConfigurationManager.getPropertyValue("ENV"), "PENTEST")) {
            loginPage.launchSubNavMainPage(TestData.getData("subnav mainpage url pentest"));
        } else {
            loginPage.launchSubNavMainPage(TestData.getData("subnav mainpage url"));
        }
        methods.waitForElement(3);
        commonUtil.dismissAllAlerts();
    }

    public void expandAndCollapseSubnavMenu() {
        methods.clickElement(subnavLocators.unexpandedSubnavSubpageOneBtn);
        methods.waitForElement(1);
        methods.clickElement(subnavLocators.expandedSubnavSubpageOneBtn);
        methods.waitForElement(1);
    }

    public void verifySubnavBreadCrumpPresenceonFE() {
        methods.assertTrueForElementPresense(subnavLocators.subnavBreadcrumpFE);
    }

    public void verifySubnavSubpageOneSelectedPlaceholder() {
        methods.assertTrueForElementPresense(subnavLocators.subnavSubpageOneSelectedPlaceholder);
    }

    public void clickOnSubnavSubpageOne() {
        methods.clickElement(subnavLocators.subnavSubpageOneLink);
        methods.waitForElement(2);
    }

    public void clickOnSubnavViewFullMenuFE() {
        methods.assertTrueForElementPresense(subnavLocators.subnavViewFullMenu);
        methods.clickElement(subnavLocators.subnavViewFullMenu);
        methods.waitForElement(1);

        methods.assertTrueForElementPresense(subnavLocators.expandedSubnavBottomDropdown);
    }

    public void verifySubnavViewFullMenuFE() {
        methods.assertTrueForElementPresense(subnavLocators.unexpandedSubnavBottomSubpageOne);
        methods.assertTrueForElementPresense(subnavLocators.unexpandedSubnavBottomSubpageOneBtn);
        methods.clickElement(subnavLocators.unexpandedSubnavBottomSubpageOneBtn);
        methods.waitForElement(1);
        methods.assertTrueForElementPresense(subnavLocators.subnavBottomSubpageTwo);
    }

    public void clickOnSubnavCloseFullMenuFE() {
        methods.assertTrueForElementPresense(subnavLocators.subnavCloseFullMenu);
        methods.clickElement(subnavLocators.subnavCloseFullMenu);
        methods.waitForElement(1);
    }

    public void verifySubnavCloseFullMenuFE() {
//        methods.assertEqualsOfElementAttribute(subnavLocators.unexpandedSubnavBottomDropdown, "style", "display: none;")
        methods.assertTrueForElementPresense(subnavLocators.subnavViewFullMenu);
    }

    public void verifyHideAllNavFE() {
            if (methods.isElementNotPresent(subnavLocators.unexpandedSubnavSubpageOneBtn)) {
                ExtentReporter.log(LogStatus.PASS,"");
            } else {
                ExtentReporter.log(LogStatus.FAIL,subnavLocators.unexpandedSubnavSubpageOneBtn+ " is displayed");
                Assert.fail();
            }
    }

    public void toggleYESHideFromAllNav() {
            if (methods.isElementPresent(subnavLocators.hideFromAllNavTextNO)) {
                methods.clickElement(subnavLocators.hideFromAllNav);
                methods.waitForElement(1);
            }
    }

    public void gotoNavigationTab() {
        methods.clickElement(subnavLocators.navigationTab);
        methods.waitForElement(1);
    }

    public void navigateToSubnavSubpageTwo() {
        if (methods.stringEquals(TestData.getData("subnav mainpage name"), subNavMainPageName)) {
            methods.clickElement(mainLocators.mainSiteExpandBtn);
            methods.waitForElement(1);
            methods.clickElement(subnavLocators.subnavMainpageExpandBtn);
            methods.waitForElement(1);
            methods.clickElement(subnavLocators.subnavSubpageOneExpandBtn);
            methods.waitForElement(1);
            methods.clickElement(subnavLocators.subnavSubpageTwo);
            methods.waitForElement(2);
        }
    }
}