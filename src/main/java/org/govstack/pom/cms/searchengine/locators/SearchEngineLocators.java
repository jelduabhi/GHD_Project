package org.govstack.pom.cms.searchengine.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEngineLocators extends InitElements {

    @FindBy(id="headerName")
    public WebElement headerName;
    @FindBy(xpath="//a[contains(text(),'Search Engines')]")
    public WebElement searchEngine;
    @FindBy(xpath = "//button[@class='btn btn-outline umb-outline dropdown-toggle']/localize")
    public WebElement createDropDown;
    @FindBy(xpath="//span[text()='Default Search']")
    public WebElement defaultSearchLnk;
    @FindBy(xpath="//span[text()='Google Search']")
    public WebElement googleSearchLnk;
    @FindBy(xpath="//span[text()='Catalog Search']")
    public WebElement catalogSearchLnk;
    @FindBy(xpath="//span[text()='Cludo Search']")
    public WebElement cludoSearchLnk;
    @FindBy(id="defaultSearchPlaceholder")
    public WebElement defaultSearchPlaceholder;
    @FindBy(id="searchEngineTitle")
    public WebElement searchEngineTitle;

    @FindBy(id="googleSearchEngineId")
    public WebElement googleSearchEngineId;
    @FindBy(id="googleSearchPlaceholder")
    public WebElement googleSearchPlaceholder;

    @FindBy(id="catalogSearchUrl")
    public WebElement catalogSearchUrl;
    @FindBy(id="catalogSearchPlaceholder")
    public WebElement catalogSearchPlaceholder;

    @FindBy(id="cludoEngineId")
    public WebElement cludoEngineId;
    @FindBy(id="cludoCustomerId")
    public WebElement cludoCustomerId;
    @FindBy(id="cludoSearchPlaceholder")
    public WebElement cludoSearchPlaceholder;
    @FindBy(id="cludoFilterName")
    public WebElement cludoFilterName;
    @FindBy(id="cludoFilterValue")
    public WebElement cludoFilterValue;
    @FindBy(xpath="//ng-form[@name='contentPickerForm']/button")
    public WebElement cludoSearchPageAddBtn;
    @FindBy(xpath = "//input[contains(@id,'search')]")
    public WebElement searchTxt;
    @FindBy(xpath = "//localize[@key='content_unpublished']")
    public WebElement status_unPublished;

    @FindBy(xpath = "//localize[@key='content_published']")
    public WebElement status_published;
}
