package org.govstack.pom.cms.utils;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommonLocators extends InitElements {

    @FindBy(xpath = "//umb-button[@alias=\"saveAndPublish\"]/div/button")
    public WebElement saveAndPublishBtn;

    @FindBy(xpath = "//umb-button[@alias=\"preview\"]/div/button")
    public WebElement saveAndPreviewBtn;

    @FindBy(xpath = "//umb-button[@alias='overlaySubmit']/div/button")
    public WebElement confirmBtn;
    @FindBy(xpath="//umb-button[@alias='overlayClose']/div/button")
    public WebElement cancelBtn;

    @FindBy(xpath = "//button[@data-element='button-group-toggle']")
    public WebElement buttonGroupToggle;

    @FindBy(xpath = "//localize[text()='Unpublish']")
    public WebElement unpublishBtn;

    @FindBy(xpath = "//button[text()='Dismiss all alerts']")
    public WebElement dismissAllAlerts;
    @FindBy(xpath = "//button[@class='umb--alert__close']")
    public List<WebElement> bannerAlerts;
}
