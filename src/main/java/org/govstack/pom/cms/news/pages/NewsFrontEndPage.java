package org.govstack.pom.cms.news.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.news.locators.NewsLocators_FrontEnd;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;

public class NewsFrontEndPage {

    LoginPage loginPage = new LoginPage();
    CommonMethods methods = new CommonMethods();
    NewsLocators_FrontEnd newsLocatorsFrontEnd = new NewsLocators_FrontEnd();
    CommonPageUtils commonPageUtils = new CommonPageUtils();

    public void launchFrontEndInNewTab() {
        methods.openAndSwitchNewTab();
        loginPage.launchFrontEndApplication();
        commonPageUtils.dismissAllAlerts();
    }


    public void validateToggleInFrontEnd() {
        methods.waitForElement(2);
        if (NewsPage.displayAuthors.equalsIgnoreCase("true")) {
            if (methods.isElementPresent(newsLocatorsFrontEnd.authorList)) {
                ExtentReporter.log(LogStatus.PASS, "Author details displayed");
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Author details are not displayed");
                Assert.fail();
            }
        }
        if (NewsPage.displayAuthors.equalsIgnoreCase("false")) {
            if (methods.isElementNotPresent(newsLocatorsFrontEnd.authorList)) {
                ExtentReporter.log(LogStatus.PASS, "Author details not displayed");
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Author details are displayed");
                Assert.fail();
            }
        }
    }

    public void validateNewsNotPublishedInFrontEnd() {
        methods.waitForElement(2);
        methods.scrollToElement(newsLocatorsFrontEnd.searchNewsTxt);
        methods.sendTextToElement(newsLocatorsFrontEnd.searchNewsTxt, NewsPage.newsTitle);
        methods.waitForElement(1);
        methods.clickElement(newsLocatorsFrontEnd.searchBtn);
        methods.waitForElement(2);
        if (methods.getElementText(newsLocatorsFrontEnd.noFoundMessage).equals("No articles were found.")) {
            CommonMethods.highlightElement(newsLocatorsFrontEnd.noFoundMessage);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, NewsPage.newsTitle + " News is not published");
        } else {
            ExtentReporter.log(LogStatus.FAIL, NewsPage.newsTitle + " News is published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, NewsPage.newsTitle + " News is published");
        }
    }

    public void validatePreview() {
        if (methods.getElementText(newsLocatorsFrontEnd.newsTitleLbl).equals(NewsPage.newsTitle)) {
            CommonMethods.highlightElement(newsLocatorsFrontEnd.newsTitleLbl);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, NewsPage.newsTitle + " News details is displayed");
        } else {
            ExtentReporter.log(LogStatus.FAIL, NewsPage.newsTitle + " News details is not displayed");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, NewsPage.newsTitle + " News details is not displayed");
        }
    }

    public void validateNewsInFrontEnd() {
        methods.waitForElement(2);
        methods.scrollToElement(newsLocatorsFrontEnd.searchNewsTxt);
        methods.sendTextToElement(newsLocatorsFrontEnd.searchNewsTxt, NewsPage.newsTitle);
        methods.waitForElement(1);
        methods.clickElement(newsLocatorsFrontEnd.searchBtn);
        methods.waitForElement(2);
        if (methods.isElementPresent(newsLocatorsFrontEnd.newsTitleLnk.getFirst())) {
            methods.scrollToElement(newsLocatorsFrontEnd.newsDescriptionLnk);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, NewsPage.newsTitle + " News is published");
            if (methods.getElementText(newsLocatorsFrontEnd.newsTitleLnk.getFirst()).equals(NewsPage.newsTitle)) {
                ExtentReporter.log(LogStatus.PASS, NewsPage.newsTitle + " Validated");
            } else {
                ExtentReporter.log(LogStatus.FAIL, NewsPage.newsTitle + " Not Validated");
            }
        } else {
            ExtentReporter.log(LogStatus.FAIL, NewsPage.newsTitle + " News is not published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, NewsPage.newsTitle + " News is not published");
        }
    }

    public void validateNewsPublished() {
        methods.waitForElement(2);
        methods.scrollToElement(newsLocatorsFrontEnd.searchNewsTxt);
        methods.sendTextToElement(newsLocatorsFrontEnd.searchNewsTxt, NewsPage.newsTitle);
        methods.waitForElement(1);
        methods.clickElement(newsLocatorsFrontEnd.searchBtn);
        methods.waitForElement(2);
        if (methods.isElementPresent(newsLocatorsFrontEnd.newsTitleLnk.getFirst())) {
            methods.scrollToElement(newsLocatorsFrontEnd.newsDescriptionLnk);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, NewsPage.newsTitle + " News is published");
            if (methods.getElementText(newsLocatorsFrontEnd.newsTitleLnk.getFirst()).equals(NewsPage.newsTitle)) {
                ExtentReporter.log(LogStatus.PASS, NewsPage.newsTitle + " Validated");
            } else {
                ExtentReporter.log(LogStatus.FAIL, NewsPage.newsTitle + " Not Validated");
            }
        } else {
            ExtentReporter.log(LogStatus.FAIL, NewsPage.newsTitle + " News is not published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, NewsPage.newsTitle + " News is not published");
        }
    }

    public void verifyPageTitleAndSecondaryHeading() {
        methods.waitForElement(2);
        methods.scrollToElement(newsLocatorsFrontEnd.searchNewsTxt);
        methods.sendTextToElement(newsLocatorsFrontEnd.searchNewsTxt, NewsPage.newsTitle);
        methods.waitForElement(1);
        methods.clickElement(newsLocatorsFrontEnd.searchBtn);
        methods.waitForElement(2);
        if (methods.isElementPresent(newsLocatorsFrontEnd.newsTitleLnk.getFirst())) {
            methods.scrollToElement(newsLocatorsFrontEnd.newsDescriptionLnk);
            methods.clickElement(newsLocatorsFrontEnd.newsTitleLnk.getFirst());
            methods.waitForElement(2);
            if (methods.isElementNotPresent(newsLocatorsFrontEnd.secondaryHeading) && methods
                    .isElementNotPresent(newsLocatorsFrontEnd.pageTitle)) {
                ExtentReporter.log(LogStatus.PASS, "Page Title and Secondary heading is hidden");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Page Title and Secondary heading is hidden");
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Page Title and Secondary heading is not hidden");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Page Title and Secondary heading is not hidden");
            }
        }
    }
}
