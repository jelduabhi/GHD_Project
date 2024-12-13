package org.govstack.pom.cms.mediaManagerBackoffice.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.alerts.pages.AlertPage;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.mediaManagerBackoffice.locators.MediaManagerBackOfficeLocators;
import org.govstack.pom.cms.news.locators.NewsLocators_FrontEnd;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MediaManagerBackOfficePage extends WebDriverManager {
    public static String categoryTitle;
    ContentMainLocators mainLocators = new ContentMainLocators();
    MediaManagerBackOfficeLocators mediaManagerBackOfficeLoc = new MediaManagerBackOfficeLocators();
    CommonMethods methods = new CommonMethods();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    NewsLocators_FrontEnd newsLocatorsFrontEnd = new NewsLocators_FrontEnd();

    public void selectHomeContent() {
        methods.waitForElement(3);
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "Home menu expanded");
        methods.waitForElement(2);
        methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerExpandBtn);
        ExtentReporter.logWithScreenshot(LogStatus.INFO, "media manager menu expanded");
    }

    public void mediaManagerCategoriesMenu() {
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerCatergoriesMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Categories menu clicked from media manager main menu");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to clicked categories from media manager main menu" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerExpandMetaInfo() {
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerMetaInfoExpandBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Meta information expanded");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to expand Meta information" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerTextFieldMenuLink() {
        if (TestData.getData("Field").equalsIgnoreCase("TextField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTextFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Text field menu clicked");
        } else if (TestData.getData("Field").equalsIgnoreCase("TextAreaField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTextAreaFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Text Area Field menu clicked");
        } else if (TestData.getData("Field").equalsIgnoreCase("DateField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerDateFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Date Field menu clicked");
        } else if (TestData.getData("Field").equalsIgnoreCase("DateWithTimeField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerDateWithTimeFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Date with time Field menu clicked");
        } else if (TestData.getData("Field").equalsIgnoreCase("LinkField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerLinkFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Link Field menu clicked");
        }
        /*
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTextFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Text field menu clicked successfully");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to click Text field menu"+e.getMessage());
            Assert.fail();
        }
         */
    }

    public void mediaManagerCreateCategoryBtn() {
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.createMediaCategoryBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Create category button clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to clicked Create category button" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerMediaPageBlankBtn() {
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.createTempBldBtn);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.createTempBldMediaPgBlankBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Create media pages blank button clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to clicked Create media pages blank button" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerCreateCategoryField() {
        try {
            methods.waitForElement(4);
            categoryTitle = TestData.getData("Category Name") + "_" + methods.generateRandomString();
            methods.sendTextToElement(mediaManagerBackOfficeLoc.mediaCatNamefield, categoryTitle);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "category name field entered successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to entered category name field" + e.getMessage());
            Assert.fail();
        }
    }

    public void verifyPublishCategories() {
        methods.waitForElement(5);
        methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerCatergoriesMenu);
        methods.waitForElement(5);
        methods.clickElement(mediaManagerBackOfficeLoc.searchTxtCategory);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, categoryTitle);
        methods.waitForElement(2);
        for (WebElement ele : mediaManagerBackOfficeLoc.Categoryresults) {
            if (ele.getText().contains(categoryTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, categoryTitle + " Category Published");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, categoryTitle + " Category Published");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, categoryTitle + " Category not Published");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, categoryTitle + " Category not Published");
                Assert.fail();
            }
        }
    }

    public void verifyPublishTextField() {
        methods.waitForElement(5);
        //methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTextFieldMenu);
        if (TestData.getData("Field").equalsIgnoreCase("TextField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTextFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Text field Data saved and able to searched");
        } else if (TestData.getData("Field").equalsIgnoreCase("TextAreaField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTextAreaFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Text Area field Data saved and able to searched");
        } else if (TestData.getData("Field").equalsIgnoreCase("DateField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerDateFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Date field Data saved and able to searched");
        } else if (TestData.getData("Field").equalsIgnoreCase("DateWithTimeField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerDateWithTimeFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Date with time Field Data saved and able to searched");
        } else if (TestData.getData("Field").equalsIgnoreCase("LinkField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerLinkFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Link Field Data saved and able to searched");
        }
        methods.waitForElement(5);
        methods.clickElement(mediaManagerBackOfficeLoc.searchTxtCategory);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, categoryTitle);
        methods.waitForElement(2);
        for (WebElement ele : mediaManagerBackOfficeLoc.Categoryresults) {
            if (ele.getText().contains(categoryTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, categoryTitle + " TextField Published");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, categoryTitle + " TextField Published");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, categoryTitle + " TextField not Published");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, categoryTitle + " TextField not Published");
                Assert.fail();
            }
        }
    }

    public void unPublishCategory() {
        methods.waitForElement(3);
        boolean newsList = false;
        for (WebElement ele : mediaManagerBackOfficeLoc.categoryLists) {
            if (methods.getElementText(ele).contains("Automation")) {
                categoryTitle = methods.getElementText(ele);
                methods.clickElement(ele);
                newsList = true;
                break;
            }
        }
        if (newsList) {
            ExtentReporter.log(LogStatus.PASS, categoryTitle + "is selected to unpublish");
            commonPageUtils.unpublish();
        } else {
            ExtentReporter.log(LogStatus.FAIL, categoryTitle + "is selected to unpublish");
        }
    }

    public void verifyUnPublishCategory() {
        methods.waitForElement(3);
        methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerCatergoriesMenu);
        methods.clickElement(mediaManagerBackOfficeLoc.searchTxtCategory);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, categoryTitle);
        methods.waitForElement(2);
        if (mediaManagerBackOfficeLoc.categoryStatus.getText().contains("Unpublished")) {
            CommonMethods.highlightElement(mediaManagerBackOfficeLoc.categoryStatus);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "Category un published");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Category un published");
        } else {
            ExtentReporter.log(LogStatus.FAIL, "Category published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Category published");
            Assert.fail();
        }
    }

    public void verifyUnPublishMetaInformation() {
        methods.waitForElement(3);
        //methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerCatergoriesMenu);
        if (TestData.getData("Field").equalsIgnoreCase("TextField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTextFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Text field Data saved and able to searched");
        } else if (TestData.getData("Field").equalsIgnoreCase("TextAreaField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTextAreaFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Text Area field Data saved and able to searched");
        } else if (TestData.getData("Field").equalsIgnoreCase("DateField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerDateFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Date field Data saved and able to searched");
        } else if (TestData.getData("Field").equalsIgnoreCase("DateWithTimeField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerDateWithTimeFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Date with time Field Data saved and able to searched");
        } else if (TestData.getData("Field").equalsIgnoreCase("LinkField")) {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerLinkFieldMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Link Field Data saved and able to searched");
        }
        methods.clickElement(mediaManagerBackOfficeLoc.searchTxtCategory);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, categoryTitle);
        methods.waitForElement(2);
        if (mediaManagerBackOfficeLoc.categoryStatus.getText().contains("Unpublished")) {
            CommonMethods.highlightElement(mediaManagerBackOfficeLoc.categoryStatus);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "Category un published");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Category un published");
        } else {
            ExtentReporter.log(LogStatus.FAIL, "Category published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Category published");
            Assert.fail();
        }
    }

    public void deletedCategory() {
        methods.waitForElement(5);
        AlertPage.alertTitle = methods.getElementText(mediaManagerBackOfficeLoc.catTitles.getFirst());
        methods.clickElement(mediaManagerBackOfficeLoc.catLists.getFirst());
        methods.clickElement(mediaManagerBackOfficeLoc.deleteBtn);
        methods.clickElement(mediaManagerBackOfficeLoc.yesDeleteBtn);
        methods.waitForElement(1);
    }

    public void updateMetaInformations() {
        methods.waitForElement(3);
        AlertPage.alertTitle = methods.getElementText(mediaManagerBackOfficeLoc.catTitles.getFirst());
        methods.clickElement(mediaManagerBackOfficeLoc.catTitles.getFirst());
        //enterAlertContentDetails();
        //enterSettingsDetails();
    }

    public void updateTemplateBuilder() {
        methods.waitForElement(3);
        AlertPage.alertTitle = methods.getElementText(mediaManagerBackOfficeLoc.catTitles.getFirst());
        methods.clickElement(mediaManagerBackOfficeLoc.catTitles.getFirst());
        //enterAlertContentDetails();
        //enterSettingsDetails();
    }

    public void checkDeletedCategoryInRecycleBin() {
        methods.waitForElement(5);
        methods.clickElement(mainLocators.recycleBinBtn);
        methods.clickElement(mediaManagerBackOfficeLoc.searchTxtCategory);
        methods.waitForElement(3);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, categoryTitle);
        methods.waitForElement(2);
        for (WebElement ele : mediaManagerBackOfficeLoc.Categoryresults) {
            if (ele.getText().contains(categoryTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, "Category Deleted");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Category Deleted");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Category not Deleted");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Category not Deleted");
            }
        }
    }

    public void checkDeletedMetaInformationInRecycleBin() {
        methods.waitForElement(5);
        methods.clickElement(mainLocators.recycleBinBtn);
        methods.clickElement(mediaManagerBackOfficeLoc.searchTxtCategory);
        methods.waitForElement(3);
        //methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory,categoryTitle);
        String recycleList = methods.getElementText(mediaManagerBackOfficeLoc.metaInfoRecycleList);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, recycleList);
        methods.waitForElement(2);
        for (WebElement ele : mediaManagerBackOfficeLoc.Categoryresults) {
            if (ele.getText().contains(recycleList)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, "Meta Information Deleted");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Meta Information Deleted");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Meta Information not Deleted");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Meta Information not Deleted");
            }
        }
    }

    public void verifyInvalidSearchAssertion() {
        methods.waitForElement(5);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, TestData.getData("InvalidSearch"));
        methods.waitForElement(2);
        if (methods.getElementText(mediaManagerBackOfficeLoc.invalidSearchTextMessage).contains("Sorry, we can not find what you are looking for.")) {
            CommonMethods.highlightElement(mediaManagerBackOfficeLoc.invalidSearchTextMessage);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "Invalid search assertion valid properly");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Invalid search assertion valid properly");
        } else {
            ExtentReporter.log(LogStatus.FAIL, "Unable to valid invalid search assertion");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to valid invalid search assertion");
        }
    }

    public void mediaManagerExpandMediaPagesInfo() {
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerMediaPagesExpandBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Media Pages expanded");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to expand Media Pages" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerTemplateBuilderPagesInfo() {
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTemplateBuilderExpandBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Template builder expanded");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to expand Template builder" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerMediaPagesSubfolderMenu() {
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerMediaPagesAutomationMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Media Pages subfolder clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to click Media Pages subfolder" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerTempBldSampleTempMenu() {
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTemplateBldSampleTemplateMenu);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Sample template subfolder clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to click Sample template subfolder" + e.getMessage());
            Assert.fail();
        }
    }

    public void verifyMediaPagesValidSearchAssertion() {
        methods.waitForElement(5);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, TestData.getData("InvalidSearch"));
        methods.waitForElement(2);
        if (methods.getElementText(mediaManagerBackOfficeLoc.validSearchMediaPages).contains("Automation Title")) {
            CommonMethods.highlightElement(mediaManagerBackOfficeLoc.validSearchMediaPages);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "media pages valid search result assertion valid properly");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "media pages valid search result assertion valid properly");
        } else {
            ExtentReporter.log(LogStatus.FAIL, "Unable to valid valid search assertion");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to valid valid search assertion");
        }
    }

    public void mediaManagerCommonListIcon() {
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.thumbnailIcon);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.listIcon);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "List icon clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to click List icon" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerCommonTableListAssertion() {
        try {
            methods.waitForElement(3);
            if (methods.getElementText(mediaManagerBackOfficeLoc.generalNameCol).contains("Name") &&
                    methods.getElementText(mediaManagerBackOfficeLoc.generalStatusCol).contains("Status") &&
                    methods.getElementText(mediaManagerBackOfficeLoc.generalLastEditedCol).contains("Last edited") &&
                    methods.getElementText(mediaManagerBackOfficeLoc.generalCreatedByCol).contains("Created by")) {
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "List view visible properly");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to see List view" + e.getMessage());
            Assert.fail();
        }
    }

    public void verifyPublishTemplateBuilder() {
        methods.waitForElement(5);
        methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTemplateBldSampleTemplateMenu);
        methods.waitForElement(5);
        methods.clickElement(mediaManagerBackOfficeLoc.searchTxtCategory);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, categoryTitle);
        methods.waitForElement(2);
        for (WebElement ele : mediaManagerBackOfficeLoc.Categoryresults) {
            if (ele.getText().contains(categoryTitle)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, categoryTitle + " Template builder Published");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, categoryTitle + " Template builder Published");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, categoryTitle + " Template builder not Published");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, categoryTitle + " Template builder not Published");
                Assert.fail();
            }
        }
    }

    public void mediaManagerCreateTemplateBuilderField() {
        try {
            methods.waitForElement(4);
            categoryTitle = TestData.getData("Category Name") + " " + methods.generateRandomString();
            methods.sendTextToElement(mediaManagerBackOfficeLoc.mediaCatNamefield, categoryTitle);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.templateBldAddCatr);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.templateBldCatSelect);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.templateBldSubmitbtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Template builder name field entered successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to entered Template builder name field" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerUpdateTemplateBuilderField() {
        try {
            methods.waitForElement(4);
            categoryTitle = TestData.getData("Category Name") + " " + methods.generateRandomString();
            methods.sendTextToElement(mediaManagerBackOfficeLoc.mediaCatNamefield, categoryTitle);
            methods.waitForElement(2);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Template builder name field updated successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable update Template builder name field" + e.getMessage());
            Assert.fail();
        }
    }

    public void verifyUnPublishTemplateBuilder() {
        methods.waitForElement(3);
        methods.clickElement(mediaManagerBackOfficeLoc.mediaManagerTemplateBldSampleTemplateMenu);
        methods.clickElement(mediaManagerBackOfficeLoc.searchTxtCategory);
        methods.sendTextToElement(mediaManagerBackOfficeLoc.searchTxtCategory, categoryTitle);
        methods.waitForElement(2);
        if (mediaManagerBackOfficeLoc.categoryStatus.getText().contains("Unpublished")) {
            CommonMethods.highlightElement(mediaManagerBackOfficeLoc.categoryStatus);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "Category un published");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Category un published");
        } else {
            ExtentReporter.log(LogStatus.FAIL, "Category published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Category published");
            Assert.fail();
        }
    }

    public void mediaManagerCommonGridIcon() {
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.listIcon);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.thumbnailIcon);
            methods.waitForElement(2);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Grid icon clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to click Grid icon" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerRowSelection() {
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.tembulderList);
            methods.waitForElement(2);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Row selected");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to select row" + e.getMessage());
            Assert.fail();
        }
    }

    public void mediaManagerRowCopy() {
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.tempBuilderCopy);
            methods.waitForElement(2);
            methods.sendTextToElement(mediaManagerBackOfficeLoc.tempBuilderSearchFolder, "Automation Do Not Delete");
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.tempBuilderClickFolder);
            methods.waitForElement(2);
            methods.scrollAndClickElement(mediaManagerBackOfficeLoc.tempBuilderRelateOriginalToggle);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.templateBldSubmitbtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Row selected");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to select row" + e.getMessage());
            Assert.fail();
        }
    }
    //Media Manager Pages TC Meta Information Fields Pages
    public void mediaManagerMetaInformationLinkFieldCard(){
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationAddButton);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationLinkFieldCard);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information link card selected");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to select Meta information link card"+e.getMessage());
            Assert.fail();
        }
    }
    public void mediaManagerMetaInformationDateWithTimeFieldCard(){
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationAddButton);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationDateWithTimeCard);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information Date with time card selected");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to select Meta information Date with time card"+e.getMessage());
            Assert.fail();
        }
    }
    public void mediaManagerMetaInformationLinkTypeList(){
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationAddType);
            methods.waitForElement(2);
            if (TestData.getData("LinkType").equalsIgnoreCase("Amended By")) {
                methods.waitForElement(3);
                methods.clickElement(mediaManagerBackOfficeLoc.metaInformationLinkTypeList);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Link list type Amended By clicked");
            } else if (TestData.getData("LinkType").equalsIgnoreCase("Contact Information")) {
                methods.waitForElement(3);
                methods.clickElement(mediaManagerBackOfficeLoc.metaInformationLinkTypeContactInfo);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Link list type Contact Information clicked");
            } else if (TestData.getData("LinkType").equalsIgnoreCase("Related Document")) {
                methods.waitForElement(3);
                methods.clickElement(mediaManagerBackOfficeLoc.metaInformationLinkTypeRelatedDoc);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Link list type Related Document clicked");
            } else if (TestData.getData("LinkType").equalsIgnoreCase("Repealed By")) {
                methods.waitForElement(3);
                methods.clickElement(mediaManagerBackOfficeLoc.metaInformationLinkTypeRepealedBy);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Link list type Repealed By clicked");
            }
            //methods.clickElement(mediaManagerBackOfficeLoc.metaInformationLinkTypeList);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information link type selected");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to select Meta information link type"+e.getMessage());
            Assert.fail();
        }
    }
    public void mediaManagerMetaInformationMeetingDateList(){
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationAddType);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationMeetingDateList);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information meeting date selected");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to select Meta information meeting date"+e.getMessage());
            Assert.fail();
        }
    }
    public void mediaManagerMetaInformationLinkValue(){
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationValueButton);
            methods.waitForElement(2);
            methods.sendTextToElement(mediaManagerBackOfficeLoc.metaInformationLinkTextField,TestData.getData("LinkField")+ "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.sendTextToElement(mediaManagerBackOfficeLoc.metaInformationLinkTitleTextField,TestData.getData("LinkTitle")+ "_" + methods.generateRandomString());
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.templateBldSubmitbtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information link field values entered");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to entered Meta information link field"+e.getMessage());
            Assert.fail();
        }
    }
    public void mediaManagerMetaInformationMeetingDateSelect(){
        try {
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.metaDateField);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.metaCurrentDateIcon);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information meeting date selected");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to select meeting date"+e.getMessage());
            Assert.fail();
        }
    }
    public void mediaManagerMetaInformationInfoIcon(){
        try {
            methods.waitForElement(5);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInfoIcon);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInfoUrl);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information info icon clicked");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to clicked Meta info icon"+e.getMessage());
            Assert.fail();
        }
    }
    public void mediaManagerMetaInformationLinkFieldValidation(){
        try {
            methods.waitForElement(5);
            methods.switchToWindow();
            methods.clickElement(newsLocatorsFrontEnd.dismissAllAlerts);
            methods.waitForElement(5);
            if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Amended By")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Amended By navigate successfully");
            }
            else if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Contact Information")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Contact Information navigate successfully");
            }
            else if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Related Document")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Related Document navigate successfully");
            }
            else if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Repealed By")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Repealed By navigate successfully");
            }
            else if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Meeting Date")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Meeting Date navigate successfully");
            }else if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Issue Date")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Issue Date navigate successfully");
            }
            else if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Publication Date")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Publication Date navigate successfully");
            }
            else if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Review Date")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Review Date navigate successfully");
            }
            else if (methods.getElementText(mediaManagerBackOfficeLoc.metaFrontendLinkField).contains("Submission Date")){
                methods.scrollToElement(mediaManagerBackOfficeLoc.metaFrontendLinkField);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Frontend page Submission Date navigate successfully");
            }
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information frontend page navigate successfully");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to navigate Meta information frontend page"+e.getMessage());
            Assert.fail();
        }
    }

    /*
  Media Manager Pages AT Meta Information Fields Date Field pending test cases started here
  METHODS COVERED FOR TEST CASES ID COVERED : TC_DF_9,TC_DF_10,TC_DF_11,TC_DF_12
  NOTE: FROM TC_DF_1 TO TC_DF_8 SAI KUMAR WORKED ON HIS PR
  */
    public void mediaManagerMetaInformationDateFieldCard(){
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationAddButton);
            methods.waitForElement(2);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationDateCard);
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information Date card selected");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to select Meta information Date card"+e.getMessage());
            Assert.fail();
        }
    }
    public void mediaManagerMetaInformationDateFieldListType(){
        try {
            methods.waitForElement(3);
            methods.clickElement(mediaManagerBackOfficeLoc.metaInformationAddType);
            methods.waitForElement(2);
            methods.sendTextToElement(mediaManagerBackOfficeLoc.metaInfoDateFieldSearch,TestData.getData("DateFieldSearch"));
            methods.waitForElement(2);
            if (TestData.getData("DateType").equalsIgnoreCase("Issue Date")) {
                methods.waitForElement(3);
                methods.clickElement(mediaManagerBackOfficeLoc.metaInfoDateFieldIssueDate);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Date type Issue Date clicked");
            } else if (TestData.getData("DateType").equalsIgnoreCase("Publication Date")) {
                methods.waitForElement(3);
                methods.clickElement(mediaManagerBackOfficeLoc.metaInfoDateFieldPublicationDate);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Date type Publication Date clicked");
            } else if (TestData.getData("DateType").equalsIgnoreCase("Review Date")) {
                methods.waitForElement(3);
                methods.clickElement(mediaManagerBackOfficeLoc.metaInfoDateFieldReviewDate);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Date type Review Date clicked");
            } else if (TestData.getData("DateType").equalsIgnoreCase("Submission Date")) {
                methods.waitForElement(3);
                methods.clickElement(mediaManagerBackOfficeLoc.metaInfoDateFieldSubmissionDate);
                ExtentReporter.logWithScreenshot(LogStatus.INFO,"Date type Submission Date clicked");
            }
            ExtentReporter.logWithScreenshot(LogStatus.INFO,"Meta information issue date selected");
        }
        catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to select Meta information issue date"+e.getMessage());
            Assert.fail();
        }
    }
}
