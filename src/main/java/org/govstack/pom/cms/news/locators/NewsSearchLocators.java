package org.govstack.pom.cms.news.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsSearchLocators extends InitElements {

    @FindBy(xpath = "//button[@class='umb--alerts__dismiss']")
    public WebElement alertDimisss;

    @FindBy(xpath = "//button[@id='btnSearch']")
    public WebElement searchBtn;

    @FindBy(xpath = "//input[@id='txtItemSearch']")
    public WebElement newsInputField;

    @FindBy(xpath = "//select[@id='news-categories']")
    public WebElement categorySelectOption;

    @FindBy(xpath = "(//a[@class='gs-feed-list-title'])[1]")
    public WebElement articleTitle;

    @FindBy(xpath = "//span[@class='gs-feed-list-description']")
    public WebElement articleDescription;

    @FindBy(xpath = "//input[@id='dateFrom']")
    public WebElement startDate;

    @FindBy(xpath = "//input[@id='dateTo']")
    public WebElement endDate;

    @FindBy(xpath = "//p[normalize-space()='No articles were found.']")
    public WebElement noArticleFoundText;

    //RG_NW_2.14 verify default field available in news form in frontend

    @FindBy(xpath = "//button[@id='btnClear']")
    public WebElement clearBtn;

    //RG_NW_2.19 verify on click clear button search criteria will be deleted

    //RG_NW_2.22 verify subscribe button is visible on news section in frontend page

    @FindBy(xpath = "//button[normalize-space()='Subscribe']")
    public WebElement subscribeBtnNews;

    @FindBy(xpath = "//p[contains(text(),'Stay up to date by subscribing to one of our newsl')]")
    public WebElement subscribePageHeading;
    @FindBy(xpath = "//label[@class='form-label']")
    public List<WebElement> subscriptionLables;

    //RG_NW_2.20 Verify selected category list should be displayed in news


}
