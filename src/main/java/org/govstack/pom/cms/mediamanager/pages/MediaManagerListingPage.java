package org.govstack.pom.cms.mediamanager.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.mediamanager.locators.MediaManagerListingLocators;
import org.govstack.pom.cms.utils.CommonLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MediaManagerListingPage extends WebDriverManager {

    public static String testingPageName = "Automation Media Manager Page";
    public static String categoryName;

    MediaManagerListingLocators mmListingLocators = new MediaManagerListingLocators();
    CommonMethods methods = new CommonMethods();
    ContentMainLocators mainLocators = new ContentMainLocators();
    CommonLocators commonLocators = new CommonLocators();

    public void navigateToMMTestPage() {
        if (methods.stringEquals(TestData.getData("MM Page Name"), testingPageName)) {
            methods.clickElement(mainLocators.mainSiteExpandBtn);
            methods.waitForElement(2);
            for (WebElement ele : mmListingLocators.mainsiteList) {
                if (methods.getElementTextContains(ele, TestData.getData("MM Page Name"))) {
                    methods.clickElement(ele);
                    methods.waitForElement(1);
                    break;
                }
            }
        }
    }

    public void clickAddMainContent() {
        methods.moveToElement(mmListingLocators.mainContentBtn);
        methods.clickElement(mmListingLocators.mainContentBtn);
        methods.waitForElement(2);
    }

    public void addMediaManagerContent() {
        methods.sendTextToElement(mmListingLocators.mainContentFilterTxtbox, TestData.getData("Content Filter Name"));
        methods.clickElement(mmListingLocators.mediaManagerListingContent);
    }

    public void setMMIntro() {
        methods.clickElement(mmListingLocators.displayIntroFlag); //Set to Yes
        methods.clickElement(mmListingLocators.displayIntroFlag); //Set to No
    }

    public void addContentDetails() {
        methods.clickElement(mmListingLocators.mediaFolderAddBtn);
        methods.waitForElement(3);
        for (WebElement ele : mmListingLocators.contentFolderList) {
            if (methods.getElementTextContains(ele, TestData.getData("Content Folder Name"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
        methods.clickElement(mmListingLocators.mediaCategoriesAddBtn);
        methods.waitForElement(3);
        methods.sendTextToElement(mmListingLocators.categoryFilterTxtbox, TestData.getData("Category Name 1"));
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.categoryItem);
        methods.waitForElement(2);
        methods.sendTextToElement(mmListingLocators.categoryFilterTxtbox, TestData.getData("Category Name 2"));
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.categoryItem);
        methods.waitForElement(2);
        methods.sendTextToElement(mmListingLocators.categoryFilterTxtbox, TestData.getData("Category Name 3"));
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.categoryItem);
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.submitCategoryBtn);

        // Select Searchable Meta Information
        for (WebElement ele : mmListingLocators.metaInformationCheckbox) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Info"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }

        // Select File Types
        for (WebElement ele : mmListingLocators.metaInformationCheckbox) {
            if (methods.getElementTextContains(ele, TestData.getData("File Type 1"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
        for (WebElement ele : mmListingLocators.metaInformationCheckbox) {
            if (methods.getElementTextContains(ele, TestData.getData("File Type 2"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
    }

    public void setMMOutro() {
        methods.scrollToElement(mmListingLocators.displayOutroFlag);
        methods.clickElement(mmListingLocators.displayOutroFlag); //Set to Yes
        methods.clickElement(mmListingLocators.displayOutroFlag); //Set to No
        methods.waitForElement(1);
    }

    public void clickCreateButton() {
        methods.clickElement(mmListingLocators.createBtn);
        methods.waitForElement(3);
    }

    public void navigateToExtraContentTab() {
        methods.clickElement(mmListingLocators.ExtraContentMenuBtn);
        methods.waitForElement(1);
    }

    public void clickAddAboveMainContent() {
        methods.moveToElement(mmListingLocators.aboveMainContentBtn);
        methods.clickElement(mmListingLocators.aboveMainContentBtn);
        methods.waitForElement(2);
    }
    public void addExtraContentDetails() {
        methods.clickElement(mmListingLocators.mediaFolderAddBtn);
        methods.waitForElement(3);
        for (WebElement ele : mmListingLocators.contentFolderList) {
            if (methods.getElementTextContains(ele, TestData.getData("Content Folder Name"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
        methods.clickElement(mmListingLocators.mediaCategoriesAddBtn);
        methods.waitForElement(2);
        methods.sendTextToElement(mmListingLocators.categoryFilterTxtbox, TestData.getData("Category Name 3"));
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.categoryItem);
        methods.waitForElement(2);
        methods.sendTextToElement(mmListingLocators.categoryFilterTxtbox, TestData.getData("Category Name 4"));
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.categoryItem);
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.submitCategoryBtn);

        // Select Searchable Meta Information
        for (WebElement ele : mmListingLocators.metaInformationCheckbox) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Info"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }

        // Select File Types
        for (WebElement ele : mmListingLocators.metaInformationCheckbox) {
            if (methods.getElementTextContains(ele, TestData.getData("File Type 3"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }

        for (WebElement ele : mmListingLocators.metaInformationCheckbox) {
            if (methods.getElementTextContains(ele, TestData.getData("File Type 2"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
    }

    public void verifyExtraContentFrontEnd() {
        methods.assertTrueForElementPresense(mmListingLocators.category2Filter);
        methods.assertTrueForElementPresense(mmListingLocators.pdfFileTypeFilter);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile3);
        methods.waitForElement(2);
    }

    public void removeExtraContent() {
        methods.moveToElement(mmListingLocators.aboveMainContentDeleteBtn);
        methods.clickElement(mmListingLocators.aboveMainContentDeleteBtn);
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.deleteBtn);
    }

    public void navigateToSettingsDesignAndLayout() {
        methods.moveToElement(mmListingLocators.mainContentSettingsBtn);
        methods.clickElement(mmListingLocators.mainContentSettingsBtn);
        methods.waitForElement(2);
    }

    public void configureDesignAndLayoutForGridView() {
        methods.clickElement(mmListingLocators.gridViewBtn);
        methods.assertTrueForElementPresense(mmListingLocators.itemsPerRowBtn);
        methods.assertTrueForElementPresense(mmListingLocators.originalImageCropBtn);
        methods.clickElement(mmListingLocators.itemsPerRowBtn);
        methods.clickElement(mmListingLocators.originalImageCropBtn);
        methods.clickElement(mmListingLocators.hideFiltersSwitcher); //Set to Yes
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.hideFiltersSwitcher); //Set to No
        methods.assertTrueForElementPresense(mmListingLocators.searchPlaceholderTxtbox);
        methods.sendTextToElement(mmListingLocators.searchPlaceholderTxtbox, "Sample");
        methods.clickElement(mmListingLocators.buttonColorBtn);
        methods.clickElement(mmListingLocators.createBtn);
        methods.waitForElement(2);
    }

    public void selectTableView() {
        methods.clickElement(mmListingLocators.tableViewBtn);
        methods.waitForElement(2);
        methods.assertTrueForElementPresense(mmListingLocators.tableViewTab);
        methods.clickElement(mmListingLocators.tableViewTab);
    }

    public void configureTableViewSettings() {
        methods.clickElement(mmListingLocators.tableViewBtn);
        methods.waitForElement(2);
        methods.assertTrueForElementPresense(mmListingLocators.tableViewTab);
        methods.clickElement(mmListingLocators.removeCategoriesSwitcher); //Set to Yes
        methods.clickElement(mmListingLocators.removeCategoriesSwitcher); //Set to No
        methods.clickElement(mmListingLocators.addMetaInfoColumnsBtn);
        methods.waitForElement(2);
        for (WebElement ele : mmListingLocators.contentList) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Content List"))) {
                methods.clickElement(ele);
                methods.waitForElement(1);
                break;
            }
        }
        for (WebElement ele : mmListingLocators.contentListName) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Content Name"))) {
                methods.clickElement(ele);
                methods.waitForElement(1);
                break;
            }
        }
        methods.clickElement(mmListingLocators.submitCategoryBtn);
        methods.clickElement(mmListingLocators.removeDateCreatedSwitcher); //Set to Yes
        methods.clickElement(mmListingLocators.removeDateCreatedSwitcher); //Set to No
        methods.clickElement(mmListingLocators.removeDateModifiedSwitcher); //Set to Yes
        methods.clickElement(mmListingLocators.removeDateModifiedSwitcher); //Set to No
        methods.clickElement(mmListingLocators.removeFileTypeSwitcher); //Set to Yes
        methods.clickElement(mmListingLocators.removeFileTypeSwitcher); //Set to No
        methods.clickElement(mmListingLocators.removeFileSizeSwitcher); //Set to Yes
        methods.clickElement(mmListingLocators.removeFileSizeSwitcher); //Set to No
        methods.clickElement(mmListingLocators.removeDownloadLinksSwitcher); //Set to Yes
        methods.clickElement(mmListingLocators.removeDownloadLinksSwitcher); //Set to No
        methods.clickElement(mmListingLocators.createBtn);
        methods.waitForElement(2);
    }

    public void verifyTableViewConfigInFrontEnd() {
        methods.assertTrueForElementPresense(mmListingLocators.frontEndTable);
        methods.waitForElement(1);
        for (WebElement ele : mmListingLocators.tableHeaderList) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Content List"))) {
                methods.assertEqualsOfElementText(ele, TestData.getData("Table Header 1"));
                break;
            }
        }
        for (WebElement ele : mmListingLocators.tableHeaderList) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Content List"))) {
                methods.assertEqualsOfElementText(ele, TestData.getData("Table Header 2"));
                break;
            }
        }
        for (WebElement ele : mmListingLocators.tableHeaderList) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Content List"))) {
                methods.assertEqualsOfElementText(ele, TestData.getData("Table Header 3"));
                break;
            }
        }
        for (WebElement ele : mmListingLocators.tableHeaderList) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Content List"))) {
                methods.assertEqualsOfElementText(ele, TestData.getData("Table Header 4"));
                break;
            }
        }
        for (WebElement ele : mmListingLocators.tableHeaderList) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Content List"))) {
                methods.assertEqualsOfElementText(ele, TestData.getData("Table Header 5"));
                break;
            }
        }
        for (WebElement ele : mmListingLocators.tableHeaderList) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Content List"))) {
                methods.assertEqualsOfElementText(ele, TestData.getData("Table Header 6"));
                break;
            }
        }
    }

    public void removeMetaInfo() {
        methods.clickElement(mmListingLocators.mainContentDetailsBtn);
        methods.waitForElement(2);

        // Select Searchable Meta Information
        for (WebElement ele : mmListingLocators.metaInformationCheckbox) {
            if (methods.getElementTextContains(ele, TestData.getData("Meta Info"))) {
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
        methods.clickElement(mmListingLocators.createBtn);
    }

    public void testFilterUsingKeyword() {
        methods.sendTextToElement(mmListingLocators.searchKeywordTxtbox, TestData.getData("Search Keyword"));
        methods.clickElement(mmListingLocators.filterMediaBtn);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile1);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile2);
        methods.clickElement(mmListingLocators.clearAllFilterBtn);
    }

    public void testFilterUsingCategories() {
        methods.clickElement(mmListingLocators.categoriesFilterDropdown);
        methods.clickElement(mmListingLocators.testAutoCategoryFilter);
        methods.clickElement(mmListingLocators.filterMediaBtn);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile2);
        methods.clickElement(mmListingLocators.clearAllFilterBtn);
    }

    public void testFilterUsingFileTypes() {
        methods.clickElement(mmListingLocators.fileTypesFilterDropdown);
        methods.clickElement(mmListingLocators.fileTypesFilterType);
        methods.clickElement(mmListingLocators.filterMediaBtn);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile1);
        methods.clickElement(mmListingLocators.clearAllFilterBtn);
    }

    public void testFilterUsingDateTypes() {
        methods.selectValueFromDropdown(mmListingLocators.dateTypesFilterDropdown, TestData.getData("Date Type Filter"));
        methods.sendTextToElement(mmListingLocators.startDateFilter, TestData.getData("Start Date"));
        methods.clickElement(mmListingLocators.filterMediaBtn);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile1);
        methods.clickElement(mmListingLocators.clearAllFilterBtn);
    }

    public void testFilterCombination() {
        methods.sendTextToElement(mmListingLocators.searchKeywordTxtbox, TestData.getData("Search Keyword"));
        methods.clickElement(mmListingLocators.categoriesFilterDropdown);
        methods.clickElement(mmListingLocators.testAutoCategoryFilter);
        methods.clickElement(mmListingLocators.fileTypesFilterDropdown);
        methods.clickElement(mmListingLocators.pngFileTypeFilter);
        methods.clickElement(mmListingLocators.filterMediaBtn);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile2);
        methods.clickElement(mmListingLocators.clearAllFilterBtn);
    }

    public void testPagination() {
        methods.scrollToElement(mmListingLocators.page2Btn);
        methods.clickElement(mmListingLocators.page2Btn);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile1);
        methods.clickElement(mmListingLocators.page1Btn);
        methods.assertTrueForElementNotPresent(mmListingLocators.mediaFile1);
        methods.clickElement(mmListingLocators.nextPageBtn);
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile1);
        methods.clickElement(mmListingLocators.previousPageBtn);
        methods.assertTrueForElementNotPresent(mmListingLocators.mediaFile1);
        methods.selectValueFromDropdown(mmListingLocators.resultsPerPageDropdown, "40");
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile1);
        methods.selectValueFromDropdown(mmListingLocators.resultsPerPageDropdown, "60");
        methods.assertTrueForElementPresense(mmListingLocators.mediaFile1);
        methods.selectValueFromDropdown(mmListingLocators.resultsPerPageDropdown, "20");
        methods.assertTrueForElementNotPresent(mmListingLocators.mediaFile1);
    }

    public void testDownloadFile() {
        methods.sendTextToElement(mmListingLocators.searchKeywordTxtbox, TestData.getData("Search Keyword"));
        methods.clickElement(mmListingLocators.filterMediaBtn);
        methods.clickElement(mmListingLocators.hazelFileDownloadBtn);
        methods.waitForElement(2);
        methods.isFileDownloaded();
    }

    public void testViewFile() {
        try {
            methods.clickElement(mmListingLocators.hazelFileViewBtn);
            methods.waitForElement(2);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("bd"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "File viewed successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to view file");
        }
        methods.closeAndSwapToParent();

        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.fileTypesFilterDropdown);
        methods.clickElement(mmListingLocators.pngFileTypeFilter);
        methods.clickElement(mmListingLocators.filterMediaBtn);
        try {
            methods.clickElement(mmListingLocators.hazelTestFileViewBtn);
            methods.waitForElement(2);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("Not found"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "File viewed successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to view file");
        }
        methods.closeAndSwapToParent();
    }

    public void viewMediaListingContentDetails() {
        methods.sendTextToElement(mmListingLocators.searchKeywordTxtbox, TestData.getData("Search Keyword"));
        methods.clickElement(mmListingLocators.fileTypesFilterDropdown);
        methods.clickElement(mmListingLocators.fileTypesFilterType);
        methods.clickElement(mmListingLocators.filterMediaBtn);
        methods.clickElement(mmListingLocators.mediaFile1);

        //Verify Listing Details
        methods.assertEqualsOfElementText(mmListingLocators.categoryDetailTxt, TestData.getData("Category Name 1"));
        methods.assertEqualsOfElementText(mmListingLocators.descriptionDetailTxt, TestData.getData("Description"));
        methods.assertEqualsOfElementText(mmListingLocators.tableContentTxt1, TestData.getData("Table Header 2"));
        methods.assertEqualsOfElementText(mmListingLocators.tableContentTxt2, TestData.getData("Details Content"));

        //Download File
        methods.clickElement(mmListingLocators.hazelFileDownloadBtn);
        methods.waitForElement(2);
        methods.isFileDownloaded();

        //View File
        try {
            methods.waitForElement(5);
            methods.clickElement(mmListingLocators.hazelFileViewBtn);
            methods.waitForElement(2);
            methods.switchToWindow();
            String tabUrl = getDriver().getTitle();
            Assert.assertTrue(tabUrl.contains("bd"));
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "File viewed successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to view file");
        }
        methods.closeAndSwapToParent();
    }

    public void renameCategory() {
        for (WebElement ele : mmListingLocators.categoriesTitles) {
            if (methods.getElementText(ele).contains("Hazel")) {
                categoryName = methods.getElementText(ele);
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
        methods.sendTextToElement(mmListingLocators.categoryHeaderName, TestData.getData("Category Name 3"));
    }

    public void clickBackButton() {
        methods.clickElement(mmListingLocators.backBtn);
    }

    public void unpublishCategory() {
        for (WebElement ele : mmListingLocators.categoriesLists) {
            if (methods.getElementText(ele).contains("Test automation")) {
                categoryName = methods.getElementText(ele);
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
        methods.clickElement(mmListingLocators.unpublishBtn);
        methods.clickElement(commonLocators.confirmBtn);
    }

    public void publishCategory() {
        for (WebElement ele : mmListingLocators.categoriesLists) {
            if (methods.getElementText(ele).contains("Test automation")) {
                categoryName = methods.getElementText(ele);
                methods.clickElement(ele);
                methods.waitForElement(2);
                break;
            }
        }
        methods.clickElement(mmListingLocators.publishBtn);
        methods.clickElement(commonLocators.confirmBtn);
    }

    public void verifyRenamedCategory() {
        methods.clickElement(mmListingLocators.categoriesFilterDropdown);
        methods.clickElement(mmListingLocators.hazelRenamedCategoryFilter);
        methods.assertTrueForElementNotPresent(mmListingLocators.testAutoCategoryFilter);
        methods.clickElement(mmListingLocators.filterMediaBtn);
        methods.clickElement(mmListingLocators.mediaFile4);
        methods.assertEqualsOfElementText(mmListingLocators.categoryDetailTxt, TestData.getData("Category Name 2"));
    }

    public void selectMMTestPage() {
        if (methods.stringEquals(TestData.getData("MM Page Name"), testingPageName)) {
            for (WebElement ele : mmListingLocators.mainsiteList) {
                if (methods.getElementTextContains(ele, TestData.getData("MM Page Name"))) {
                    methods.clickElement(ele);
                    methods.waitForElement(1);
                    break;
                }
            }
        }
    }

    public void removeMediaManagerContent() {
        methods.moveToElement(mmListingLocators.mainContentDeleteBtn);
        methods.clickElement(mmListingLocators.mainContentDeleteBtn);
        methods.waitForElement(2);
        methods.clickElement(mmListingLocators.deleteBtn);
    }
}