package org.govstack.pom.cms.searchengine.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.searchengine.locators.SearchEngineLocators;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;

public class SearchEnginePage {

    SearchEngineLocators searchEngineLocators=new SearchEngineLocators();
    CommonMethods methods=new CommonMethods();
    public static String searchEngineTitle;

    public void clickSearchEngine(){
        methods.clickElement(searchEngineLocators.searchEngine);
    }
    public void createSearchEngine(){
        try {
            clickSearchEngine();
            searchEngineTitle=TestData.getData("Header")+"_"+methods.generateRandomString();
            methods.clickElement(searchEngineLocators.createDropDown);
            methods.waitForElement(2);
            switch (TestData.getData("SearchType")) {
                case "Default":
                    methods.clickElement(searchEngineLocators.defaultSearchLnk);
                    enterDefaultSearchDetails();
                    break;
                case "Google":
                    methods.clickElement(searchEngineLocators.googleSearchLnk);
                    enterGoogleSearchDetails();
                    break;
                case "Catalog":
                    methods.clickElement(searchEngineLocators.catalogSearchLnk);
                    enterCatelogSearchDetails();
                    break;
                case "Cludo":
                    methods.clickElement(searchEngineLocators.cludoSearchLnk);
                    enterCludoSearchDetails();
                    break;
                default:
                    ExtentReporter.log(LogStatus.FAIL, "Please select search type");
                    Assert.fail();
            }
        }catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to select search type "+e.getMessage());
            Assert.fail();
        }
    }

    public void enterDefaultSearchDetails(){
        methods.sendTextToElement(searchEngineLocators.headerName,searchEngineTitle);
        methods.sendTextToElement(searchEngineLocators.defaultSearchPlaceholder,TestData.getData("Search Placeholder"));
        methods.sendTextToElement(searchEngineLocators.searchEngineTitle,TestData.getData("Engine Display Name"));
    }

    public void enterGoogleSearchDetails(){
        methods.sendTextToElement(searchEngineLocators.headerName,searchEngineTitle);
        methods.sendTextToElement(searchEngineLocators.googleSearchEngineId,methods.generateSampleID());
        methods.sendTextToElement(searchEngineLocators.googleSearchPlaceholder,TestData.getData("Search Placeholder"));
        methods.sendTextToElement(searchEngineLocators.searchEngineTitle,TestData.getData("Engine Display Name"));
    }

    public void enterCatelogSearchDetails(){
        methods.sendTextToElement(searchEngineLocators.headerName,searchEngineTitle);
        methods.sendTextToElement(searchEngineLocators.catalogSearchPlaceholder,TestData.getData("Search Placeholder"));
        methods.sendTextToElement(searchEngineLocators.catalogSearchUrl,TestData.getData("Catalog Search Url"));
        methods.sendTextToElement(searchEngineLocators.searchEngineTitle,TestData.getData("Engine Display Name"));
    }

    public void enterCludoSearchDetails(){
        methods.sendTextToElement(searchEngineLocators.headerName,searchEngineTitle);
        methods.sendTextToElement(searchEngineLocators.cludoEngineId,methods.generateSampleID());
        methods.sendTextToElement(searchEngineLocators.cludoCustomerId,methods.generateSampleID());
        methods.sendTextToElement(searchEngineLocators.cludoSearchPlaceholder,TestData.getData("Search Placeholder"));
        methods.sendTextToElement(searchEngineLocators.searchEngineTitle,TestData.getData("Engine Display Name"));
        methods.sendTextToElement(searchEngineLocators.cludoFilterName,TestData.getData("Cludo Filter Name"));
        methods.sendTextToElement(searchEngineLocators.cludoFilterValue,TestData.getData("Cludo Filter Value"));
    }

    public void validatedSearchEnginePublished(){
        clickSearchEngine();
        methods.clickElement(searchEngineLocators.searchTxt);
        methods.sendTextToElement(searchEngineLocators.searchTxt, searchEngineTitle);
        methods.waitForElement(2);
        if (searchEngineLocators.status_published.getText().contains("Unpublished")) {
            CommonMethods.highlightElement(searchEngineLocators.status_published);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.FAIL, "Search Engine un published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Search Engine un published");
            Assert.fail();
        } else {
            ExtentReporter.log(LogStatus.PASS, "Search Engine published");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search Engine published");
        }
    }
    public void validatedSearchEngineNotPublished(){
        clickSearchEngine();
        methods.clickElement(searchEngineLocators.searchTxt);
        methods.sendTextToElement(searchEngineLocators.searchTxt, searchEngineTitle);
        methods.waitForElement(2);
        if (searchEngineLocators.status_unPublished.getText().contains("Unpublished")) {
            CommonMethods.highlightElement(searchEngineLocators.status_unPublished);
            methods.waitForElement(2);
            ExtentReporter.log(LogStatus.PASS, "Search Engine un published");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Search Engine un published");
        } else {
            ExtentReporter.log(LogStatus.FAIL, "Search Engine published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Search Engine published");
            Assert.fail();
        }
    }
}
