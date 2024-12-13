package org.govstack.pom.cms.news.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.news.locators.NewsLocators;
import org.govstack.pom.cms.news.locators.UpdatePost_Locators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.*;
import org.govstack.webdriver.WebDriverManager;

import org.testng.Assert;

import java.time.*;


public class UpdatePost_Page extends WebDriverManager {

    UpdatePost_Locators updatePostLoc = new UpdatePost_Locators();
    CommonMethods methods = new CommonMethods();
    NewsLocators newsLocators = new NewsLocators();
    LoginPage loginpage = new LoginPage();

    String updateText = "_" + methods.generateRandomString();

    public void selectExistingPost() {
        try {
            methods.clickElementFromList(updatePostLoc.postlist, TestData.getData("post name"));
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "successfully selectExistingPost");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to select existing post");
        }
    }

    public void updatePostname() {
        try {
            methods.sendTextToElement(updatePostLoc.postname, updateText);
            methods.waitForElement(1);
            ExtentReporter.log(LogStatus.PASS, "successfully updatePostname");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to update postname");
        }
    }

    public void updateCurrentDate() {
        try {
            methods.clickElement(newsLocators.datePicker);
            methods.selectOptionFromList(newsLocators.postDateTxt, methods.getCurrentDate());
            methods.clickElement(newsLocators.headerNameTxt);
            ExtentReporter.log(LogStatus.PASS, "successfully updateCurrentDate");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to update current date");
        }
    }

    public void removeCategory() {
        try {
            if (methods.isElementPresent(updatePostLoc.selectedCatg)) {
                methods.clickElement(updatePostLoc.removeCatg);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, "successfully removeCategory");
            } else {
                ExtentReporter.log(LogStatus.INFO, "SELECT CATEGORY TO REMOVE");
                Assert.assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(LogStatus.INFO, e.getMessage());
        }
    }

    public void addCategory() {
        try {
            methods.clickElement(newsLocators.postCategoriesBtn);
            methods.selectOptionFromList(updatePostLoc.catgList, TestData.getData("post categories"));
            methods.clickElement(newsLocators.submitBtn);
            methods.waitForElement(3);
            methods.assertTrueForElementPresense(updatePostLoc.selectedCatg);
            ExtentReporter.log(LogStatus.PASS, "successfully addCategory");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to add category");
        }
    }

    public void removeAuthor() {
        try {
            if (methods.isElementPresent(updatePostLoc.selectedAuth)) {
                methods.clickElement(updatePostLoc.removeAuth);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, "successfully removeAuthor");
            } else {
                ExtentReporter.log(LogStatus.INFO, "SELECT AUTHOR TO REMOVE");
                Assert.assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(LogStatus.INFO, e.getMessage());
        }
    }

    public void addAuthor() {
        try {
            methods.clickElement(newsLocators.authorBtn);
            methods.waitForElement(2);
            methods.selectOptionFromList(newsLocators.selectAuthor, TestData.getData("author"));
            methods.waitForElement(1);
            methods.clickElement(newsLocators.submitBtn);
            methods.waitForElement(2);
            methods.assertTrueForElementPresense(updatePostLoc.selectedAuth);
            ExtentReporter.log(LogStatus.PASS, "successfully addAuthor");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to add author");
        }
    }

    public void navigateSummary() {
        try {
            methods.clickElement(newsLocators.summaryBtn);
            methods.waitForElement(1);
            ExtentReporter.log(LogStatus.PASS, "successfully navigateSummary");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to navigate summary");
        }

    }

    public void updateSummaryHeadings() {
        try {
            methods.sendTextToElement(updatePostLoc.summaryHeading1, methods.generateRandomString());
            methods.waitForElement(1);
            methods.sendTextToElement(updatePostLoc.summaryHeading2, methods.generateRandomString());
            methods.waitForElement(1);
            ExtentReporter.log(LogStatus.PASS, "successfully updateSummaryHeadings");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to update summary headings");
        }
    }


    public void removeImg() {
        try {
            if (methods.isElementPresent(updatePostLoc.imgThumb)) {
                methods.moveToElement(updatePostLoc.imgThumb);
                methods.waitForElement(1);
                methods.clickElement(updatePostLoc.removeImg);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, "successfully removeImg");
            } else {
                ExtentReporter.log(LogStatus.INFO, "SELECT IMAGE TO REMOVE");
                Assert.assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(LogStatus.INFO, e.getMessage());
        }
    }

    public void updateImage() {
        try {
            methods.clickElement(updatePostLoc.addImg);
            methods.waitForElement(2);
            methods.inputFile(TestData.getData("image"), updatePostLoc.imgInput);
            methods.waitForElementClickable(updatePostLoc.selectImgBtn, 30);
            methods.clickElement(updatePostLoc.selectImgBtn);
            methods.waitForElementVisibility(updatePostLoc.imgThumb, 10);
            ExtentReporter.log(LogStatus.PASS, "successfully updateImage");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to update image");
        }
    }


    public void verifyPostStatus() {
        try {
            for (WebElement post : updatePostLoc.postlist) {
                if (methods.getElementText(post).contains(updateText)) {
                    //status published
                    methods.assertEqualsString(methods.getElementText(updatePostLoc.getPublishedStatusValue(post)), TestData.getData("published status value"));
                    ExtentReporter.log(LogStatus.PASS, "successfully verifyPostStatus");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verify post status");
        }
    }

    public void verifyLastEditedCurrentDate() {
        try {
            for (WebElement post : updatePostLoc.postlist) {
                if (methods.getElementText(post).contains(updateText)) {
                    String date = methods.getElementText(updatePostLoc.getLastEditedDateValue(post)).trim().split(" ")[0];
                    LocalDate currentDate = LocalDate.now();
                    methods.assertEqualsString(date, currentDate.toString());
                    ExtentReporter.log(LogStatus.PASS, "successfully verifyLastEditedCurentDate");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verify last edited date as current date");
        }
    }

    public void verifyCreatedby() {
        try {
            for (WebElement post : updatePostLoc.postlist) {
                if (methods.getElementText(post).contains(updateText)) {
                    methods.assertEqualsOfElementText(updatePostLoc.getCreatedbyValue(post), TestData.getData("createdby"));
                    ExtentReporter.log(LogStatus.PASS, "successfully verifyCreatedby");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verify createdby user");
        }
    }

    public void updateFutureDate() {
        try {
            methods.clickElement(newsLocators.datePicker);
            if (TestData.getData("post date").equalsIgnoreCase("futuredate")) {
                methods.selectOptionFromList(newsLocators.postDateTxt, methods.getFutureDate(2));
            }
            methods.clickElement(newsLocators.headerNameTxt);
            ExtentReporter.log(LogStatus.PASS, "successfully updateFutureDate");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed update future date");
        }
    }


    public void updateBlankDate() {
        try {
            if (methods.getAttributeOfElementEquals(updatePostLoc.calInput, "aria-invalid", "false")) {
                methods.clickElement(updatePostLoc.calClearBtn);
                methods.waitForElement(1);
                if (methods.getAttributeOfElementEquals(updatePostLoc.calInput, "aria-invalid", "true")) {
                    ExtentReporter.log(LogStatus.PASS, "successfully updateBlankDate");
                } else {
                    ExtentReporter.log(LogStatus.FAIL, "BUG GOVCMS-1420");
                    Assert.fail();
                }
            } else {
                ExtentReporter.log(LogStatus.INFO, "SELECT DATE TO CLEAR");
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(LogStatus.INFO, e.getMessage());
        } catch (NullPointerException e) {
            ExtentReporter.log(LogStatus.INFO, e.getMessage());
        }
    }

    public void deleteContentMainContent() {
        try {
            methods.moveToElement(updatePostLoc.mainContentBtn);
            methods.waitForElement(2);
            if (updatePostLoc.contentMaincontentImgShadowroot.isDisplayed()) {
                methods.moveToElement(updatePostLoc.contentImgDeleteIcon);
                methods.clickElement(updatePostLoc.contentImgDeleteIcon);
                methods.clickElement(updatePostLoc.contentImgDeleteBtn);
                methods.waitForElementInVisibility(updatePostLoc.contentImgDeleteOverlay, 5);
                ExtentReporter.log(LogStatus.PASS, "successfully deleteContentMainContent");
            } else {
                ExtentReporter.log(LogStatus.INFO, "SELECT CONTENT TO DELETE");
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(LogStatus.INFO, e.getMessage());
        }
    }

    public void verfiydeleteContentPageTitle() {
        try {
            methods.assertTrueOfElementTextEmpty(newsLocators.pageTitleTxt);
            ExtentReporter.log(LogStatus.PASS, "successfully verfiydeleteContentPageTitle");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verify deleted content page title");
        }
    }

    public void verifydeleteContentSecondHeading() {
        try {
            methods.assertTrueOfElementTextEmpty(updatePostLoc.contentSecondHeading);
            ExtentReporter.log(LogStatus.PASS, "successfully verifydeleteContentSecondHeading");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verify deleted content secondary heading");
        }
    }

    public void verifydeleteContentMainContent() {
        try {
            methods.assertTrueForElementNotPresent(updatePostLoc.contentMaincontentImgShadowroot);
            ExtentReporter.log(LogStatus.PASS, "successfully verifydeleteContentMainContent");
        } catch (NoSuchElementException e) {
            ExtentReporter.log(LogStatus.INFO, e.getMessage());
        }
    }

    public void clickReadyToSaveAndPublish() {
        try {
            methods.clickElement(updatePostLoc.readyTosaveAndPublishOverlayBtn);
            methods.waitForElementInVisibility(updatePostLoc.readyTosaveAndPublishOverlay, 10);
            ExtentReporter.log(LogStatus.PASS, "successfully clickReadyToSaveAndPublish");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to click ready to save and publish overlay");
        }
    }

    public void validateRequiredHelplineError() {
        try {
            methods.assertEqualsOfElementText(updatePostLoc.requiredErrorHelpString, TestData.getData("required help error"));
            ExtentReporter.log(LogStatus.PASS, "successfully validateRequiredHelplineError");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to validate required help error string");
        }
    }

    public void validatePropertyInvalidError() {
        try {
            methods.assertEqualsOfElementText(updatePostLoc.propertyError, TestData.getData("property error"));
            ExtentReporter.log(LogStatus.PASS, "successfully validatePropertyInvalidError");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to validate property invalid error string");
        }
    }

    public void verifyPostDateRequired() {
        try {
            methods.assertEqualsOfElementText(updatePostLoc.requiredErrorHelpString, "Required");
            ExtentReporter.log(LogStatus.PASS, "successfully verifyPostDateRequired");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to validate required help error string");
        }
    }

    public void verifyPostDatePropertyInvalid() {
        try {
            methods.assertEqualsOfElementText(updatePostLoc.propertyError, "This property is invalid");
            ExtentReporter.log(LogStatus.PASS, "successfully verifyPostDatePropertyInvalid");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to validate invalid property string");
        }
    }

    public void verifyValidationErrors() {
        try {
            methods.assertTrueForElementTextContains(updatePostLoc.validationErrorAlert, "Validation errors must be fixed before the item can be saved");
            ExtentReporter.log(LogStatus.PASS, "successfully verifyValidationErrors");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to validate validation error alert");
        }
    }

    public void navigateFENewsListingPage() {
        try {
            methods.openAndSwitchNewTab();
            ExtentReporter.log(LogStatus.INFO, "successfully OpenAndSwitchNewTab");
            loginpage.launchFrontEndApplication();
            ExtentReporter.log(LogStatus.PASS, "successfully launchFrontEndApplication");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to navigate frontend news listing page");
        }
    }

    public void dismissAllAlertsOnFEPage() {
        try {
            methods.clickElement(updatePostLoc.dismisallalerts);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "successfully dismissAllAlertsOnFEPage");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to click on dismiss all alerts");
        }
    }

    public void selectNewsPost() {
        try {
            methods.clickElementFromList(updatePostLoc.newsPostListOnFE, NewsPage.newsTitle);
            ExtentReporter.log(LogStatus.PASS, "successfully selectNewsPost");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to select news post on frontend page");
        }
    }

    public void verifyNewsPostContentPageTitle() {
        try {
            methods.assertTrueForElementNotPresent(updatePostLoc.newsPostContentPageTitle);
            ExtentReporter.log(LogStatus.PASS, "successfully verifyNewsPostContentPageTitle");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verify content page title inside news post");
        }
    }

    public void verifyNewsPostContentH2() {
        try {
            methods.assertTrueForElementPresense(updatePostLoc.newsPostContentH2);
            ExtentReporter.log(LogStatus.PASS, "successfully verifyNewsPostContentH2 fallback of post name");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verify content secondary heading inside news post");
        }
    }

    public void verifyNewsPostContentGalleryImg() {
        try {
            methods.assertTrueForElementNotPresent(updatePostLoc.newsPostContentGalleryImg);
            ExtentReporter.log(LogStatus.PASS, "successfully verifyNewsPostContentGalleryImg");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to verify content main content gallery image inside news post");
        }
    }
}