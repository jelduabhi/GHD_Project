package org.govstack.pom.cms.outbound.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OutBoundFrontEndLocators extends InitElements {

    @FindBy(xpath="//li[@class='with-children open']/ul/li/a/span")
    public List<WebElement> outBoundLinks;
    @FindBy(xpath = "//li[@class='with-children open']/ul/li/button")
    public WebElement subNavExpandBtn;
    @FindBy(xpath="//ul[contains(@id,'gs-subnav-dropdown')]/li/a/span")
    public List<WebElement> outBoundLinksUnderSubNav;

}
