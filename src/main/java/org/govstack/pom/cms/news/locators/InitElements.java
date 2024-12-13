package org.govstack.pom.cms.news.locators;

import org.govstack.webdriver.WebDriverManager;
import org.openqa.selenium.support.PageFactory;


public class InitElements extends WebDriverManager {

    public InitElements(){
        PageFactory.initElements(getDriver(),this);
    }
}
