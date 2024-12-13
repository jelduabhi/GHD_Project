package org.govstack.pom.cms.outbound.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OutBoundLocators extends InitElements {

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Automation Testing Page QA']")
    public WebElement pageEllipsisBtn_QA;

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Automation Sub Nav Page']")
    public WebElement pageEllipsisBtn_subNav;

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Automation Testing Page STG']")
    public WebElement pageEllipsisBtn_STAGE;

    @FindBy(xpath = "(//span[@class='icon umb-icon']/parent:: button)[1]")
    public WebElement createBtn;
    @FindBy(xpath = "(//button[@class='umb-action-link umb-outline btn-reset'])[1]")
    public WebElement createPageLink;
    @FindBy(xpath = "(//button[@class='umb-action-link umb-outline btn-reset'])[2]")
    public WebElement createOutBoundLink;
    @FindBy(xpath = "//span[@class='menu-label']")
    public List<WebElement> createOutBoundLnk;
    @FindBy(id = "headerName")
    public WebElement headerNameTxt;
    @FindBy(id = "outboundLinkUrl")
    public WebElement outboundLinkUrlTxt;

    @FindBy(id = "openInNewTab")
    public WebElement openNewTabToggleBtn;

    @FindBy(xpath = "//a[@class='umb-tree-item__label']")
    public List<WebElement> outBoundLists;

    @FindBy(xpath = "//umb-button-ellipsis[@text='Open context menu for Home']")
    public WebElement mainPageEllipsisBtn;

    @FindBy(xpath = "//span[@ng-bind-html='notification.message']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@class=\"alert alert-error property-error\"]")
    public WebElement outBoundErrorMessage;

    @FindBy(xpath = "//span[text()='Delete']")
    public WebElement deleteBtn;
    @FindBy(xpath = "//umb-button[@ng-if='showConfirm']/div/button")
    public WebElement deleteConfirmBtn;
    @FindBy(xpath = "//button[text()='Ok']")
    public WebElement finalOkBtn;

}
