package org.govstack.pom.mi.pages;

import org.govstack.framework.TestData;
import org.govstack.pom.cms.disablelinksfornonpagenodes.locators.DisableLinksForNonPageNodesLocators;
import org.govstack.pom.cms.disablelinksfornonpagenodes.pages.DisableLInksForNonPageNodesPage;
import org.govstack.pom.cms.news.locators.NewsLocators;
import org.govstack.pom.cms.news.locators.UpdatePost_Locators;
import org.govstack.pom.cms.subnav.locators.SubNavLocators;
import org.govstack.pom.cms.utils.CommonLocators;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.pom.mi.locators.MILocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MIPage extends WebDriverManager {

    CommonMethods methods = new CommonMethods();
    DisableLInksForNonPageNodesPage dLinksPage = new DisableLInksForNonPageNodesPage();
    DisableLinksForNonPageNodesLocators dLinksLocators = new DisableLinksForNonPageNodesLocators();
    MILocators miLocators = new MILocators();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    UpdatePost_Locators updatePostLocators = new UpdatePost_Locators();
    SubNavLocators subnavLocators = new SubNavLocators();
    NewsLocators newsLocators = new NewsLocators();
    CommonLocators commonLocators = new CommonLocators();

    static String MMmenuBtnText = "Expand child items for Media Manager";
    static String MPmenuBtnText = "Expand child items for Media Pages";


    public void navigateToHomeMenu(){
        dLinksPage.clickOnHomeExpandBtn();
    }
    public void navigateToMediaTemplatePage(){
        dLinksPage.clickOnLeftMenuItemFromList(dLinksLocators.leftexpandBtns, MMmenuBtnText);
        dLinksPage.clickOnLeftMenuItemFromList(dLinksLocators.leftexpandBtns, MPmenuBtnText);
        dLinksPage.clickOnLeftMenuItemFromList(miLocators.mmlist, TestData.getData("Expand Button Text"));
        methods.waitForElement(5);
    }
    public void clickOnTemplate(String templatename){
        methods.scrollAndClickElement(miLocators.templateSearch);
        methods.sendTextToElement(miLocators.templateSearch, templatename);
        methods.waitForElement(3);
        methods.selectOptionFromList(miLocators.templateNameList, templatename);
        methods.waitForElement(5);
    }
    public void cleanExistingMIcontent(){
        for(WebElement ele : miLocators.existingmiinfoDeleteBtn)
            if(methods.isElementPresent(ele)){
                methods.moveToElement(ele);
                methods.clickElement(ele);
                methods.waitForElementVisibility(miLocators.mideleteoverlay,5);
                methods.clickElement(miLocators.mideleteOverlayBtn);
                methods.waitForElementInVisibility(miLocators.mideleteoverlay,5);

            }
    }
    public void addContentCard(String cardname){
        methods.clickElement(miLocators.miAddContentBtn);
        methods.waitForElementVisibility(miLocators.miAddContentForm, 2);
        methods.selectOptionFromList(miLocators.miAddCcntentCardList, cardname);
        methods.waitForElementInVisibility(miLocators.miAddContentForm, 2);
    }
    public void selectContent(String contentname){
        methods.clickElement(miLocators.miAddContentCurrentBlockAddBtn);
        methods.waitForElementVisibility(miLocators.miSelectContentForm, 2);
        methods.sendTextToElement(miLocators.miSelectContentInputTextBox, contentname);
        methods.waitForElement(2);
        methods.selectOptionFromList(miLocators.miSelectContentList, contentname);
        methods.waitForElementInVisibility(miLocators.miSelectContentForm, 2);
    }
    public void enterTextFieldContentValue(String contentvalue){
        methods.sendTextToElement(miLocators.miAddContentCurrentBlockTextField, contentvalue);
        methods.waitForElement(2);
    }
    public void enterTextAreaFieldContentValue(String contentvalue){
        methods.sendTextToElement(miLocators.miAddContentCurrentBlockTextAreaField, contentvalue);
        methods.waitForElement(2);
    }
    public void selectLinkImgContentValue(String img){
        methods.clickElement(miLocators.miAddContentActiveBlockLinkFieldAddBtn);
        methods.waitForElementVisibility(miLocators.miSelectlinkForm,2);
        methods.clickElement(miLocators.miSelectlinkMediaBtn);
        methods.waitForElement(2);
        methods.inputFile(img, miLocators.fileInput);
        methods.waitForElementClickable(miLocators.imgSelectBtn, 30);
        methods.clickElement(miLocators.imgSelectBtn);
        methods.waitForElementVisibility(miLocators.miSelectlinkForm, 2);
        methods.clickElement(miLocators.miLinkMediaSubmitBtn);
        methods.waitForElementInVisibility(miLocators.miSelectlinkForm,2);
    }
    public void enterLinkUrlAndTitle(String linkurl, String linktext){
        methods.clickElement(miLocators.miAddContentActiveBlockLinkFieldAddBtn);
        methods.waitForElementVisibility(miLocators.miSelectlinkForm,2);
        methods.sendTextToElement(miLocators.linkurl, linkurl);
        methods.waitForElement(2);
        methods.sendTextToElement(miLocators.linktitle, linktext);
        methods.waitForElement(2);
        methods.clickElement(miLocators.miLinkMediaSubmitBtn);
        methods.waitForElementInVisibility(miLocators.miSelectlinkForm,2);
    }

    public void clickOnSaveAndPublish(){
        commonPageUtils.saveAndPublish();
        methods.waitForElementInVisibility(updatePostLocators.readyTosaveAndPublishOverlay, 5);
    }
    public void navigateToInfoTab(){
        dLinksPage.navigateToInfo();
    }
    public void navigateToTemplateFEPage(String templateurl){
        methods.clickElement(subnavLocators.pageurl);
        methods.waitForElement(3);
        methods.switchToWindow();
        methods.waitForElement(2);
        assert methods.getCurrentUrl().contains(templateurl);
        commonPageUtils.dismissAllAlerts();
    }
    public void verifyMITemplateTableContent(List<WebElement> tableHeaders, List<WebElement> tableData, Map<String, String> expectedValues) {
        for (int i = 0; i < tableHeaders.size(); i++) {
            String header = tableHeaders.get(i).getText();
            String value = tableData.get(i).getText();
            List<WebElement> links = tableData.get(i).findElements(By.tagName("a"));
            if (!links.isEmpty()) {
                WebElement ele = links.getFirst();
                System.out.println("Checking " + header
                        + ": expected " + expectedValues.get(header)
                        + ", found " + ele.getText() + " " + ele.getAttribute("href"));
                assert ele.getText().toLowerCase().contains(expectedValues.get(header).split(" ")[0].toLowerCase()) : "Mismatch for " + header;
                assert ele.getAttribute("href").toLowerCase().contains(expectedValues.get(header).split(" ")[0].toLowerCase()) : "Mismatch for " + header;
            } else {
                System.out.println("Checking " + header + ": expected " + expectedValues.get(header) + ", found " + value);
                assert value.toLowerCase().contains(expectedValues.get(header).toLowerCase()) : "Mismatch for " + header;
            }

        }
    }
    public String getpresentdate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy-MM-dd");
        String s= dateOnly.format(cal.getTime()).split("-")[2];
        if(s.startsWith("0")){
            s=s.replace("0","");
        }
        return s;
    }
    public void savecontent(){
        methods.clickElement(miLocators.save);
        methods.waitForElement(3);
        methods.clickElement(commonLocators.confirmBtn);
        methods.waitForElement(8);
        methods.waitForElementInVisibility(updatePostLocators.readyTosaveAndPublishOverlay, 5);
    }
    public void selectCurrentDate() {
        methods.clickElement(newsLocators.datePicker);
        methods.waitForElement(2);
        methods.selectOptionFromList(newsLocators.postDateTxt, getpresentdate());
        methods.waitForElement(2);
        savecontent();
    }

}
