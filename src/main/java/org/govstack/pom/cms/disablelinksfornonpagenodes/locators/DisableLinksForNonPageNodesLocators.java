package org.govstack.pom.cms.disablelinksfornonpagenodes.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DisableLinksForNonPageNodesLocators extends InitElements {

    @FindBy(xpath = "//a[@class='umb-tree-item__label']/parent::div/button")
    public List<WebElement> leftexpandBtns;

    @FindBy(xpath = "//a[@class='umb-tree-item__label']")
    public List<WebElement> leftlist;

    @FindBy(xpath = "//li[@data-element='tree-item-News']//a")
    public List<WebElement> newslist;

    @FindBy(xpath = "//div[@class='umb-box-header'][@title-key='general_links']//div[@class='umb-box-header-title']")
    public WebElement linksec;

    @FindBy(xpath = " //div[contains(text(),'Redirect URL Management')]")
    public WebElement redirecturlamngmt;

    @FindBy(xpath = "//button[@data-element='sub-view-more']")
    public WebElement more;

    @FindBy(xpath = "(//a[@class='umb-content-grid__item-name umb-outline'])[1]")
    public WebElement authorsFirstItem;

    @FindBy(xpath = "(//a[@class='umb-content-grid__item-name umb-outline'])[1]")
    public WebElement alertsFirstItem;

    @FindBy(xpath = "(//a[@class='umb-content-grid__item-name umb-outline'])[1]")
    public WebElement cdContactsFirsItem;

    @FindBy(xpath = "(//a[@class='umb-content-grid__item-name umb-outline'])[1]")
    public WebElement newsPostsFirstItem;

    @FindBy(xpath = "//a[@class='umb-content-grid__item-name umb-outline']//span[contains(text(),'Calendar')]")
    public WebElement ppCalendar;


    @FindBy(xpath = "//a[contains(@ng-click,'viewItem(item)')]//span[contains(text(),'Wireframe')]")
    public WebElement designWireframe;

    @FindBy(xpath = "//a[contains(@ng-click,'vm.clickItem(item)')]//span[contains(text(),'Navigation')]")
    public WebElement globalNavigation;
}
