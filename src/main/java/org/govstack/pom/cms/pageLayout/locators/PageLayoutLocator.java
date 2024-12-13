package org.govstack.pom.cms.pageLayout.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLayoutLocator extends InitElements {

    @FindBy(xpath = "//li[@data-element='tab-content']//button[@type='button']")
    public WebElement contentTab;

}
