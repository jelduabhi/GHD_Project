package org.govstack.pom.cms.news.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsLocators_FrontEnd extends InitElements {

    @FindBy(xpath = "//button[text()='Dismiss all alerts']")
    public WebElement dismissAllAlerts;
    @FindBy(xpath = "(//span[@class='gs-feed-list-author'])[1]")
    public WebElement authorList;
    @FindBy(id = "txtItemSearch")
    public WebElement searchNewsTxt;
    @FindBy(id = "btnSearch")
    public WebElement searchBtn;
    @FindBy(xpath = "//div[@class='gs-feed-list-meta']/a")
    public List<WebElement> newsTitleLnk;
    @FindBy(xpath = "//h1[@class='heading main base-heading']")
    public WebElement newsTitleLbl;
    @FindBy(xpath = "//span[@class='gs-feed-list-description']/p")
    public WebElement newsDescriptionLnk;
    @FindBy(xpath = "//p[@class='secondary-heading base-secondary-heading']")
    public WebElement secondaryHeading;
    @FindBy(xpath = "//h1[@class='heading main base-heading']")
    public WebElement pageTitle;
    @FindBy(xpath = "//*[text()='No articles were found.']")
    public WebElement noFoundMessage;

}
