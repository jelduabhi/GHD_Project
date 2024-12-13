package org.govstack.pom.bd.bdListNaics.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BDListingNaicsLocators extends InitElements {

    @FindBy(xpath = "(//div[@class='add-business'])[1]")
    public WebElement BdAddBusinessbtn;

    @FindBy(xpath = "(//div[contains(text(),'General')])[1]")
    public WebElement Bdgeneraltab;

    @FindBy(xpath = "(//input[@placeholder='Enter NAICS code'])[1]")
    public WebElement BdNaicsCodeTextField;

    @FindBy(xpath = "//p[@class='error-message']")
    public WebElement BdNaicsErrorMessage;

    @FindBy(xpath = "(//button[normalize-space()='NAICS Lookup'])[1]")
    public WebElement BdNaicsLookupBtn;

    @FindBy(xpath = "(//strong[normalize-space()='NAICS Code Lookup'])[1]")
    public WebElement BdNaicsLookupwindowheading;

    @FindBy(xpath = "(//input[@placeholder='Search by NAICS Code or NAICS Title'])[1]")
    public WebElement BdNaicsSearchfield;

    @FindBy(xpath = "(//div[@class='e-headercontent'])[1]")
    public WebElement BdNaicstableContentHeader;

    @FindBy(xpath = "(//tr[@class='e-row'])[1]")
    public WebElement BdNaicstableGridResult;

    @FindBy(xpath = "(//span[@class='e-icons e-treegridexpand'])[1]")
    public WebElement BdNaicsListExpand;

    @FindBy(xpath = "(//span[@class='e-icons e-treegridcollapse'])[1]")
    public WebElement BdNaicsListCollapse;

    @FindBy(xpath = "(//button[@class='copy-icon'])[1]")
    public  WebElement BdCopyIcon;

    @FindBy(xpath = "(//button[normalize-space()='Close'])[1]")
    public  WebElement BdNaicsClosepopupBtn;
    @FindBy(xpath = "(//button[normalize-space()='Return to Listings'])[1]")
    public WebElement BdReturnListTab;

    @FindBy(xpath = "(//input[@placeholder='Search Listings'])[1]")
    public  WebElement BdListSearch;

    @FindBy(xpath = "(//span[@class='e-editable-value'])[1]")
    public WebElement BdEditableFieldName;

    @FindBy(xpath = "(//input[@id='inplace_editor_editor'])[1]")
    public WebElement BdEditableInputField;

    @FindBy(xpath = "//div[@class='e-dlg-content']")
    public WebElement unsavedPopupContent;

    @FindBy(xpath = "(//button[normalize-space()='Keep Editing'])[1]")
    public WebElement unsavedPopupKeepEditBtn;

    @FindBy(xpath = "(//button[normalize-space()='Go to Listings'])[1]")
    public WebElement unsavedPopupKeepGoListingBtn;

    @FindBy(xpath = "(//div[contains(text(),'Listings')])[1]")
    public WebElement BdlistTab;

    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
    public WebElement BdSaveBtn;

    @FindBy(xpath = "//h2[@class='no-item-found']")
    public WebElement BdListingNoFoundText;
}
