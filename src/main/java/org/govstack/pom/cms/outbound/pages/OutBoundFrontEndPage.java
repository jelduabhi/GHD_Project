package org.govstack.pom.cms.outbound.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.cms.outbound.locators.OutBoundFrontEndLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OutBoundFrontEndPage {

    OutBoundFrontEndLocators frontEndLocators=new OutBoundFrontEndLocators();
    CommonMethods methods=new CommonMethods();

    public void validateOutBoundLink(){
        boolean outBoundLink = false;
        for(WebElement ele:frontEndLocators.outBoundLinks){
            if(methods.getElementText(ele).equals(OutBoundPage.outBoundTitle)){
                outBoundLink=true;
                break;
            }
        }
        if(outBoundLink){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,OutBoundPage.outBoundTitle+" Is displayed in front end");
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, OutBoundPage.outBoundTitle+" Is not displayed in front end");
            Assert.fail();
        }
    }

    public void validateOutBoundLinkinCurrentTab(){
        for(WebElement ele:frontEndLocators.outBoundLinks){
            if(methods.getElementText(ele).equals(OutBoundPage.outBoundTitle)){
                methods.moveToElement(ele);
                methods.clickElement(ele);
                methods.waitForElement(2);
                if(methods.getWindowsCount().size()>2){
                    ExtentReporter.log(LogStatus.FAIL,"OutBound link opened in new Tab");
                    Assert.fail();
                }else {
                    ExtentReporter.log(LogStatus.PASS,"OutBound link opened in current Tab");
                }
            }
        }
    }

    public void validateOutBoundLinkinNewTab(){
        for(WebElement ele:frontEndLocators.outBoundLinks){
            if(methods.getElementText(ele).equals(OutBoundPage.outBoundTitle)){
                methods.moveToElement(ele);
                methods.clickElement(ele);
                methods.waitForElement(2);
                if(methods.getWindowsCount().size()>2){
                    ExtentReporter.log(LogStatus.PASS,"OutBound link opened in new Tab");
                }else {
                    ExtentReporter.log(LogStatus.FAIL,"OutBound link opened in current Tab");
                    Assert.fail();
                }
            }
        }
    }
    public void validateOutBoundLinkinNewTabUnderSubnav(){
        methods.clickElement(frontEndLocators.subNavExpandBtn);
        methods.waitForElement(1);
        for(WebElement ele:frontEndLocators.outBoundLinksUnderSubNav){
            if(methods.getElementText(ele).equals(OutBoundPage.outBoundTitle)){
                methods.moveToElement(ele);
                methods.clickElement(ele);
                methods.waitForElement(2);
                if(methods.getWindowsCount().size()>2){
                    ExtentReporter.log(LogStatus.PASS,"OutBound link opened in new Tab");
                }else {
                    ExtentReporter.log(LogStatus.FAIL,"OutBound link opened in current Tab");
                    Assert.fail();
                }
            }
        }
    }
}
