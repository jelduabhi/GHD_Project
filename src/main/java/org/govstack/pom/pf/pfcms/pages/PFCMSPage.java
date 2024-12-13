package org.govstack.pom.pf.pfcms.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.outbound.locators.OutBoundLocators;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.pom.pf.pfcms.locators.PFCMSLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PFCMSPage {

    PFCMSLocators pfcmsLocators=new PFCMSLocators();
    CommonMethods methods=new CommonMethods();
    OutBoundLocators outBoundLocators=new OutBoundLocators();
    CommonPageUtils commonPageUtils=new CommonPageUtils();
    public static String pfPageHeader;

    public void createPFPage(){
        pfPageHeader= TestData.getData("Header Name")+"_"+methods.generateRandomString();
        methods.sendTextToElement(pfcmsLocators.headerNameTxt,pfPageHeader);
        methods.sendTextToElement(pfcmsLocators.headingTxt,pfPageHeader);
        methods.sendTextToElement(pfcmsLocators.descriptionTxt,TestData.getData("Description"));
        methods.sendTextToElement(pfcmsLocators.placeholderTxt,TestData.getData("PlaceHolder"));
        methods.clickElement(pfcmsLocators.advancedBtn);
        methods.waitForElement(2);
        methods.clickElement(pfcmsLocators.overrideWebsiteStyleBtn);
        methods.waitForElement(2);
        methods.clickElement(pfcmsLocators.prestigeBtn);
        methods.waitForElement(2);
        methods.sendTextToElement(pfcmsLocators.customBodyClassesTxt,TestData.getData("Custom Body Classes"));
    }

    public void verifyPFPageCreated() {
        methods.waitForElement(2);
        for (WebElement pfPage : outBoundLocators.outBoundLists) {
            if (pfPage.getText().equals(pfPageHeader)) {
                methods.moveToElement(pfPage);
                methods.clickElement(pfPage);
                break;
            }
        }
        methods.clickElement(pfcmsLocators.infoBtn);
        methods.clickElement(pfcmsLocators.pfFrontEndUrl);
        methods.waitForElement(5);
    }

    public void validatePFPageInFrontEnd(){
        try {
            methods.switchToWindow();
            methods.waitForElement(3);
            commonPageUtils.dismissAllAlerts();
            if (methods.getElementText(pfcmsLocators.pfFrontEndTitle).equals(pfPageHeader)) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, pfPageHeader + " Is Created");
            }else{
                ExtentReporter.logWithScreenshot(LogStatus.PASS,pfPageHeader+" is not Created");
                Assert.fail(pfPageHeader+" is not Created");
            }
        }catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,pfPageHeader+" is not Created");
            Assert.fail(pfPageHeader+" is not Created");
        }
    }

}
