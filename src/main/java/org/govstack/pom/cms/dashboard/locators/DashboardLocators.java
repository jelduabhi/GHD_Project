package org.govstack.pom.cms.dashboard.locators;


import org.govstack.pom.cms.news.locators.InitElements;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardLocators extends InitElements {

    @FindBy(xpath = "//h1[normalize-space()='Welcome to Govstack CMS']")
    public WebElement dashboardWelcomeMsg;
    @FindBy(xpath = "//div[normalize-space()='Recent activities']")
    public WebElement dashboardRecentActivitiesHeading;
    @FindBy(xpath = " //div[normalize-space()='Pending content']")
    public WebElement dashboardPendingcontentHeading;
    @FindBy(xpath = " //div[normalize-space()='Your recent activity']")
    public WebElement dashboardYourrecentactivityHeading;
    @FindBy(xpath = "//govstack-ribbon")
    public WebElement govtstackcmsRibbonShadowRoot;
    public String helpButtonCSS = "";
    public String helpDeskCSS = ".gs-ribbon-theme-bold";
    public String helpSupportCSS = "a[href='https://ghddigitalpss.com/support']";
    public String helpLearningCenterCSS = "a[href='https://www.govstack.com/learning-centre/govstack-content-management-system/']";
    public String learningCenterCSS = "a[href='https://www.govstack.com/learning-centre/']";
    public String helpOverlay = "#gs-ribbon-dropdown-help-content";
    public String navIconCss = "#gs-ribbon-dropdown-grid-btn";
    public String menuOptions = "#gs-ribbon-dropdown-grid-content >li>a";
    public String citizenLinkCSS = "a[href='https://citizenportal2-admin.stg.esolg.ca/']";
    public String businessDirectoryLinkCSS = "a[href='https://ghd-wa-cac-s-businessdirectoryui.azurewebsites.net/']";
    public String parkFacilitiesLinkCss = "a[href='http://ghd-wa-cac-s-parksandfacilitiesui.azurewebsites.net/']";
    public String dashboardLinkCss = "a[href='https://ghd-app-cac-s-govstackdashboardui.azurewebsites.net/dashboard']";
    public String tenantServiceLinkCss = "a[href='https://ghd-app-cac-q-tenantservice-02.azurewebsites.net/']";
    public String subscriptionMgtLinkCss = "a[href='https://ghd-app-cac-s-subscription-management.azurewebsites.net/']";
    public String govStackLogoCss = "[alt='Gavstack logo']";
    //public String govStackLogoCss = "a[aria-label='gavstack']";
    public String userProfileCss = ".gs-ribbon-user-initials";
    public String userProfileSignoutCss = ".gs-ribbon-button";
    public String managerUserCSS = "a[href='https://cac-s-vuladm-001-egfvghhfaqfchxhw.z01.azurefd.net/']";
    public String settingIconCss = "ul[class=\"gs-ribbon-right-items\"]>li>button";
    public String manageUserPermissionCss = "#gs-ribbon-dropdown-settings-content >li>a";
    public String eventsRibboCss = "a[href='https://calendar-icreate1.qa.esolutionsgroup.ca/Management/Account/InitiateSSO']";
    public String formsRibboCss = "a[href='https://formbuilder-icreate3.qa.esolutionsgroup.ca/Identity/Login']";
    public String cmsRibboCss = "a[href='https://ghd-app-cac-q-govstackcms.azurewebsites.net/umbraco']";


    @FindBy(id = "Umbraco.BackOffice.OpenIdConnect")
    public WebElement signinWithB2CbtnDashboardCMS;

    @FindBy(xpath = "//div[2]//div[1]//div[2]//a[1]")
    public WebElement citizenCard;

    @FindBy(xpath = "//a[@href='https://ghd-wa-cac-s-businessdirectoryui.azurewebsites.net/']")
    public WebElement businessDirectoryCard;

    @FindBy(xpath = "//a[@href='http://ghd-wa-cac-s-parksandfacilitiesui.azurewebsites.net/']")
    public WebElement parkFacilitiesCard;

    @FindBy(xpath = "//a[@href='https://ghd-app-cac-s-subscription-management.azurewebsites.net/']")
    public WebElement subscriptionMgtCard;

    @FindBy(xpath = "(//a[contains(text(),'Open')])[6]")
    public WebElement tenantCard;

    @FindBy(xpath = "//a[@href='https://ghd-app-cac-q-govstackcms.azurewebsites.net/umbraco']")
    public WebElement cmsCard;

    @FindBy(xpath = "(//a[contains(text(),'Open')])[3]")
    public WebElement eventCard;

    @FindBy(xpath = "(//a[@class='btn btn-light'][normalize-space()='Open'])[4]")
    public WebElement formsCard;

    @FindBy(xpath = "//div[@class='card-header']")
    public WebElement cardHeader;


    CommonMethods methods = new CommonMethods();

    public WebElement getHelpButton() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, helpButtonCSS);
    }

    public WebElement getHelpDeskString() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, helpDeskCSS);
    }

    public WebElement settingIcon() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, settingIconCss);
    }

    public void clickMenuByOption(String option){
        List<WebElement>elements=methods.getShadowElementsByCSS(govtstackcmsRibbonShadowRoot,menuOptions);
        for(WebElement ele:elements){
            if(ele.getText().equals(option)){
               ele.click();
               break;
            }
        }
    }

    public WebElement eventsRibbonClick() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, eventsRibboCss);
    }

    public WebElement formsRibbonClick() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, formsRibboCss);
    }


    public WebElement cmsRibbonClick() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, cmsRibboCss);
    }


    public WebElement getHelpSupport() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, helpSupportCSS);
    }

    public WebElement getHelpLearningCenter() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, helpLearningCenterCSS);
    }

    public WebElement getHelpOverlay() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, helpOverlay);
    }

    //GOVPORT_014 Validate user can access dashboard
    public WebElement getNavBarIcon() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, navIconCss);
    }

    public WebElement learningCenterIcon() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, learningCenterCSS);
    }

    public WebElement citizenLinkList() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, citizenLinkCSS);
    }

    public WebElement subscriptionMgtLinkList() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, subscriptionMgtLinkCss);
    }

    public WebElement tenantServiceLinkList() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, tenantServiceLinkCss);
    }


    public WebElement businessDirectoryList() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, businessDirectoryLinkCSS);
    }

    public WebElement parkFacilitiesList() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, parkFacilitiesLinkCss);
    }

    public WebElement dashboardList() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, dashboardLinkCss);
    }

    public WebElement manageuserPermissionRoles() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, manageUserPermissionCss);

    }


    public WebElement govstackLogoClick() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, govStackLogoCss);
    }

    public WebElement govStackUserProfileIcon() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, userProfileCss);
    }

    public WebElement govStackUserSignOutLink() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, userProfileSignoutCss);
    }

    public WebElement govStackManageUserLink() {
        return methods.getShadowElementByCSS(govtstackcmsRibbonShadowRoot, managerUserCSS);
    }

}






