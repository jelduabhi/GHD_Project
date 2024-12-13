package org.govstack.pom.cms.news.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.alerts.locators.AlertLocators;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.news.locators.NewsLocators;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;


public class NewsPage {
    public static String newsTitle;
    public static String displayAuthors;
    public static String displayCategories;
    public static String displayDates;


    CommonMethods methods = new CommonMethods();
    NewsLocators newsLocators = new NewsLocators();
    ContentMainLocators mainLocators = new ContentMainLocators();
    AlertLocators alertLocators = new AlertLocators();
    CommonPageUtils commonPageUtils = new CommonPageUtils();

    public void enterNewsDetails() {
        clickNewPost();
        enterSettingsDetails();
        enterContentDetails();
        enterSummaryDetails();
    }

    public void enterNewsDetailsPentest() {
        clickNewPostDirect();
        enterSettingsDetails();
        enterContentDetails();
        enterSummaryDetails();
    }

    public void verifyUnPublishNews() {
        methods.clickElement(mainLocators.postsBtn);
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt, newsTitle);
        methods.waitForElement(2);
        if (newsLocators.newsStatus.getText().contains("Unpublished")) {
            CommonMethods.highlightElement(newsLocators.newsStatus);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "News un published");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "News un published");
        } else {
            ExtentReporter.log(LogStatus.FAIL, "News published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "News published");
            Assert.fail();
        }
    }

    public void verifyPublish() {
        methods.clickElement(mainLocators.postsBtn);
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt, newsTitle);
        methods.waitForElement(2);
        for (WebElement ele : newsLocators.results) {
            if (ele.getText().contains(newsTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, newsTitle + " News Published");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, newsTitle + " News Published");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, newsTitle + " News not Published");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, newsTitle + " News not Published");
                Assert.fail();
            }
        }
    }

    public void clickNewPost() {
        methods.clickElement(newsLocators.createNewsPost);
        methods.clickElement(newsLocators.createBlankNewsPost);
    }

    public void clickNewPostDirect() {
        methods.clickElement(newsLocators.createNewsPost);
    }

    public void enterSettingsDetails() {
        newsTitle = TestData.getData("Header Name") + "_" + methods.generateRandomString();
        methods.sendTextToElement(newsLocators.headerNameTxt, newsTitle);
        methods.clickElement(newsLocators.datePicker);
        methods.waitForElement(2);
        if (TestData.getData("Post Date").equalsIgnoreCase("CurrentDate")) {
            methods.selectDateFromCalender(alertLocators.datePicker, methods.getCurrentDate());
            methods.waitForElement(1);
            methods.sendTextToElement(alertLocators.startDateHours, methods.getCurrentHours());
            methods.waitForElement(1);
            methods.sendTextToElement(alertLocators.startDateMinitus, methods.getCurrentMinitus());
        }
        methods.javaScriptClickElement(newsLocators.postCategoriesBtn);
        methods.waitForElement(2);
        methods.selectOptionFromList(newsLocators.selectCategory, TestData.getData("Post Category"));
        methods.waitForElement(2);
//        This step is added for testing email notification in Subscription
//        methods.selectOptionFromList(newsLocators.selectCategory, TestData.getData("Post Category2"));
//        methods.waitForElement(2);
        methods.clickElement(newsLocators.submitBtn);
        methods.javaScriptClickElement(newsLocators.authorBtn);
        methods.waitForElement(1);
        if (Objects.equals(ConfigurationManager.getPropertyValue("ENV"), "STAGE")) {
            methods.selectOptionFromList(newsLocators.selectAuthor, TestData.getData("Author_STAGE"));
        } else {
            methods.selectOptionFromList(newsLocators.selectAuthor, TestData.getData("Author_QA"));
        }
        methods.waitForElement(2);
        methods.clickElement(newsLocators.submitBtn);
//        methods.clickElement(newsLocators.sendSubscriberNotification);
        methods.waitForElement(2);
    }

    public void enterContentDetails() {
        methods.clickElement(newsLocators.contentMenuBtn);
        methods.waitForElement(1);
        if (TestData.getData("Layout").equals("Left")) {
            methods.clickElement(newsLocators.layoutLeftLnk);
            methods.waitForElement(1);
        } else if (TestData.getData("Layout").equals("Full")) {
            methods.clickElement(newsLocators.layoutFullLnk);
            methods.waitForElement(1);
        } else if (TestData.getData("Layout").equals("Right")) {
            methods.clickElement(newsLocators.layoutRightLnk);
            methods.waitForElement(1);
        }
        methods.sendTextToElement(newsLocators.pageTitleTxt, TestData.getData("Page title") + "_" + methods.generateRandomString());
        methods.sendTextToElement(newsLocators.secondaryHeadingTxt, TestData.getData("Secondary Heading"));

        if (TestData.getData("Secondary Heading Font").equals("M")) {
            methods.clickElement(newsLocators.contentSecondaryHeadingFont_M);
        } else if (TestData.getData("Secondary Heading Font").equals("S")) {
            methods.clickElement(newsLocators.contentSecondaryHeadingFont_S);
        } else if (TestData.getData("Secondary Heading Font").equals("L")) {
            methods.clickElement(newsLocators.contentSecondaryHeadingFont_L);
        }

    }

    public void updateContent() {
        newsTitle = newsTitle + "_Updated";
        methods.sendTextToElement(newsLocators.headerNameTxt, newsTitle);
        methods.clickElement(newsLocators.contentMenuBtn);
        methods.clickElement(newsLocators.removePageHeadingsToggle);
        methods.waitForElement(1);
    }

    public void navigateContent() {
        try {
            newsTitle = newsTitle + "_Updated";
            methods.sendTextToElement(newsLocators.headerNameTxt, newsTitle);
            methods.clickElement(newsLocators.contentMenuBtn);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "successfully navigateContent");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to navigate content");
        }
    }

    public void deleteContentPageTitle() {
        try {
            methods.clearElementInput(newsLocators.pageTitleTxt);
            methods.clearElementInput(newsLocators.secondaryHeadingTxt);
            ExtentReporter.log(LogStatus.PASS, "successfully deleteContentPageTitle");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to delete content page title");
        }
    }

    public void deleteAuthorCategory() {
        for (WebElement ele : newsLocators.deleteButton) {
            ele.click();
            methods.waitForElement(1);
        }
    }

    public void enterSummaryDetails() {
        methods.clickElement(newsLocators.summaryBtn);
        methods.sendTextToElement(newsLocators.pageListingHeadingTxt, newsTitle);
        methods.sendTextToElement(newsLocators.pageListingSecondaryHeadingTxt, TestData.getData("Secondary Heading"));
        methods.switchToFrame(newsLocators.pageSummaryFrame);
        methods.sendTextToElement(newsLocators.textTxt, TestData.getData("Text"));
        methods.switchToDefaultContent();
        methods.clickElement(newsLocators.imageButton);
        methods.sendTextToElement(newsLocators.searchImageLnk, TestData.getData("Image type"));
        methods.clickElement(newsLocators.selectImagelnk);
        methods.clickElement(newsLocators.summarySelectBtn);
    }

    public void updateSummaryDetails() {
        methods.clickElement(newsLocators.summaryBtn);
        methods.sendTextToElement(newsLocators.pageListingHeadingTxt, newsTitle);
        methods.sendTextToElement(newsLocators.pageListingSecondaryHeadingTxt, TestData.getData("Secondary Heading"));
    }

    public void updateSettings() {
        methods.scrollAndClickElement(newsLocators.displayAuthorsToggle);
        methods.clickElement(newsLocators.displayCategoriesToggle);
        methods.clickElement(newsLocators.displayDatesToggle);
        displayAuthors = methods.getAttributeValue(newsLocators.displayAuthorsToggle, "aria-checked");
        displayCategories = methods.getAttributeValue(newsLocators.displayCategoriesToggle, "aria-checked");
        displayDates = methods.getAttributeValue(newsLocators.displayDatesToggle, "aria-checked");
    }

    public void selectExistingNews() {
        for (WebElement ele : newsLocators.newsLists) {
            if (methods.getElementText(ele).contains("Automation") && !methods.getElementText(ele).contains("Update")) {
                newsTitle = methods.getElementText(ele);
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
    }

    public void selectNewsWithBlankPostDate() {
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt, "donot delete");
        methods.waitForElement(2);
        newsTitle = methods.getElementText(newsLocators.newsLists.getFirst());
        methods.clickElement(newsLocators.newsLists.getFirst());
    }

    public void updateNews() {
        if (TestData.getData("Settings") != null) {
            deleteAuthorCategory();
            enterSettingsDetails();
        }
        if (TestData.getData("Summary") != null) {
            updateSummaryDetails();
        }
    }

    public void unPublishNews() {
        boolean newsList = false;
        for (WebElement ele : newsLocators.newsLists) {
            if (methods.getElementText(ele).contains("Automation")) {
                newsTitle = methods.getElementText(ele);
                methods.clickElement(ele);
                newsList = true;
                break;
            }
        }
        if (newsList) {
            ExtentReporter.log(LogStatus.PASS, newsTitle + "is selected to unpublish");
            commonPageUtils.unpublish();
        } else {
            ExtentReporter.log(LogStatus.FAIL, newsTitle + "is selected to unpublish");
        }
    }

    public void publishUnpublishedNews() {
        boolean newsList = false;
        for (WebElement ele : newsLocators.unPublishedNewsLists) {
            if (methods.getElementText(ele).contains("Automation")) {
                newsTitle = methods.getElementText(ele);
                methods.clickElement(ele);
                newsList = true;
                break;
            }
        }
        if (newsList) {
            ExtentReporter.log(LogStatus.PASS, newsTitle + "is selected to unpublish");
            commonPageUtils.saveAndPublish();
        } else {
            ExtentReporter.log(LogStatus.FAIL, newsTitle + "is selected to unpublish");
        }
    }


}

