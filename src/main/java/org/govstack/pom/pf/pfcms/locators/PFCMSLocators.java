package org.govstack.pom.pf.pfcms.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFCMSLocators extends InitElements {

    @FindBy(id = "headerName")
    public WebElement headerNameTxt;
    @FindBy(id = "heading")
    public WebElement headingTxt;
    @FindBy(id = "description")
    public WebElement descriptionTxt;
    @FindBy(id = "placeholder")
    public WebElement placeholderTxt;
    @FindBy(xpath = "//button[contains(text(),'Advanced')]")
    public WebElement advancedBtn;
    @FindBy(id = "overrideWebsiteStyle")
    public WebElement overrideWebsiteStyleBtn;
    @FindBy(xpath = "//div[text()='Prestige']")
    public WebElement prestigeBtn;
    @FindBy(id = "customBodyClasses")
    public WebElement customBodyClassesTxt;
    @FindBy(xpath = "(//umb-editor-navigation-item[@class='umb-sub-views-nav-item'])[3]/button")
    public WebElement infoBtn;
    @FindBy(xpath = "//span[contains(text(),'en/')]")
    public WebElement pfFrontEndUrl;
    @FindBy(xpath = "//div[contains(@class,'heading-col col')]/h2")
    public WebElement pfFrontEndTitle;

}
