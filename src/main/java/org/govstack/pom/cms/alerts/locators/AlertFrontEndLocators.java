package org.govstack.pom.cms.alerts.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AlertFrontEndLocators extends InitElements {

    @FindBy(xpath = "//p[@class='bx--modal-header__heading bx--type-beta']")
    public List<WebElement> alertHeadings;

    @FindBy(xpath = "//button[@aria-label='Next']")
    public WebElement alertNextButton;
    @FindBy(xpath = "//div[@class='umb--alert__title']")
    public List<WebElement> bannerAlerts;
}
