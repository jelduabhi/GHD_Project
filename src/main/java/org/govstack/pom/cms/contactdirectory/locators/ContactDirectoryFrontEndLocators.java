package org.govstack.pom.cms.contactdirectory.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactDirectoryFrontEndLocators extends InitElements {

    @FindBy(xpath = "//h2[@class='category-title']")
    public List<WebElement> categoryTitle;
    @FindBy(xpath="//a[contains(@id,'phoneLink')]")
    public List<WebElement> primaryNumber;

}
