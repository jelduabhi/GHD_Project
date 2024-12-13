package org.govstack.pom.bd.businessDirectoryUserMgt.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessDirectoryUserMgtLocators extends InitElements {

    @FindBy(xpath = "//h1[normalize-space()='Business Directory']")
    public WebElement businessDirHeader;

}
