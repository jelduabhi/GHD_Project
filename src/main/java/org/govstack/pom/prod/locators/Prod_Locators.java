package org.govstack.pom.prod.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Prod_Locators extends InitElements {

    @FindBy(xpath = "//button[@class='umb--alert__close']")
    public List<WebElement> alerts;
    @FindBy(xpath="//a")
    public List<WebElement> allLinks;
    @FindBy (xpath = "//span[text()='Settings']")
    public WebElement settingsLink;
    @FindBy(xpath = "//a[text()='Log Viewer']")
    public WebElement logViewer;
    @FindBy(xpath="//div[@title=\"Number of Errors\"]/following-sibling::div")
    public WebElement errors;
    @FindBy(xpath="//table[@class='table table-hover']/tbody/tr")
    public List<WebElement> errorTable;

    @FindBy (xpath = "(//a[@class='umb-tree-root-link umb-outline'])[1]")
    public WebElement settingsLnk;
    @FindBy(xpath = "//button[contains(text(),'Examine Management')]")
    public WebElement examineManagementLnk;
    @FindBy(xpath = "//button[contains(text(),'Models Builde')]")
    public WebElement modelsBuilderLnk;

    @FindBy(xpath = "//button[contains(text(),'ExternalIndex')]")
    public WebElement externalIndexLnk;
    @FindBy(xpath = "//button[contains(text(),'InternalIndex')]")
    public WebElement internalIndexLnk;

    @FindBy(xpath="(//div[@class='umb-panel-group__details-status-text']/div)[1]")
    public WebElement statusLbl;

    @FindBy(xpath = "//*[@id=\"modelsBuilder\"]/div/div/div[2]/div/ul/li")
    public WebElement modelBuilderStatus;
}
