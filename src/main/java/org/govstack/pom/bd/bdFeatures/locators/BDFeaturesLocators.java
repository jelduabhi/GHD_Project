package org.govstack.pom.bd.bdFeatures.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BDFeaturesLocators extends InitElements {

    @FindBy(xpath = "(//div[contains(text(),'Features')])[1]")
    public WebElement featuresTab;

    @FindBy(xpath = "//input[@id='feature-tablename']")
    public WebElement featuresNameField;

    @FindBy(xpath = "//input[@name='features Search']")
    public WebElement featuresSearchField;

    @FindBy(xpath = "//td[contains(.,'Automation_Features_')]")
    public WebElement featuresSearchResult;

    @FindBy(xpath = "(//button[normalize-space()='Add feature'])[1]")
    public WebElement addFeaturesBtnGrid;

}