package org.govstack.pom.cms.custom404.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Custom404Locators extends InitElements {


    @FindBy(id = "onPageTitle")
    public WebElement customPageHeading;

}
