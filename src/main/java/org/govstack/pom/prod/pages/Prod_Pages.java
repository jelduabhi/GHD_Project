package org.govstack.pom.prod.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.prod.locators.Prod_Locators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;


public class Prod_Pages {

    Prod_Locators prodLocators=new Prod_Locators();
    CommonMethods methods=new CommonMethods();

    public void validateBrokenLinks(){
        ExtentReporter.log(LogStatus.INFO,"--------------- CMS_PRD_1: -Validate the homepage content, navigation and CSS layout are loaded properly. ---------------------------");
        for(WebElement alert:prodLocators.alerts){
            alert.click();
            methods.waitForElement(1);
        }
        for(WebElement ele:prodLocators.allLinks){
            methods.checkLink(ele.getAttribute("href"));
        }
    }

    public void validateErrorInLogs(){
        ExtentReporter.log(LogStatus.INFO,"--------------- CMS_PRD_3:- Validate Logs for errors Nav - go to back office using '/umbraco' >> Login using SSO >>Setting Tab >>  Log viewer >> All Logs ---------------------------");
        try {
            methods.clickElement(prodLocators.settingsLink);
            methods.clickElement(prodLocators.logViewer);
            methods.waitForElement(3);
            if (Integer.parseInt(methods.getElementText(prodLocators.errors)) > 0) {
                methods.clickElement(prodLocators.errors);
                methods.waitForElement(2);
                if(!prodLocators.errorTable.isEmpty()){
                    ExtentReporter.logWithScreenshot(LogStatus.FAIL,"CMS_PRD_3:- Error logs in CMS Back Office Log viewer ");
                }
            }
        }catch (Exception e){
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,e.getMessage());
        }
    }

    public void validateExamineManagement(){
        ExtentReporter.log(LogStatus.INFO,"--------------- CMS_PRD_4:- Validate Examine Management Nav - Settings tab >> Examine Management >> External Index, Internal Index. ---------------------------");
        methods.clickElement(prodLocators.settingsLnk);
        methods.clickElement(prodLocators.examineManagementLnk);
        methods.clickElement(prodLocators.externalIndexLnk);
        if(methods.getElementText(prodLocators.statusLbl).equals("Healthy")){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,"CMS_PRD_4:- External Links is Healthy");
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"CMS_PRD_4:-External Links is not Healthy "+methods.getElementText(prodLocators.statusLbl));
        }
        methods.clickElement(prodLocators.modelsBuilderLnk);
        methods.clickElement(prodLocators.examineManagementLnk);
        methods.clickElement(prodLocators.internalIndexLnk);
        if(methods.getElementText(prodLocators.statusLbl).equals("Healthy")){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,"CMS_PRD_4:- Internal Links is Healthy");
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"CMS_PRD_4:- Internal Links is not Healthy "+methods.getElementText(prodLocators.statusLbl));
        }
    }

    public void validateModelBuilder(){
        ExtentReporter.log(LogStatus.INFO,"--------------------- CMS_PRD_5:-Nav - Settings tab >> ModelsBuilder >> Mode set to Nothing----------------------");
        methods.clickElement(prodLocators.modelsBuilderLnk);
        if(prodLocators.modelBuilderStatus.getText().contains("Nothing")){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,"CMS_PRD_5:-"+methods.getElementText(prodLocators.modelBuilderStatus));
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"CMS_PRD_5:-"+methods.getElementText(prodLocators.modelBuilderStatus));
        }
    }
}
