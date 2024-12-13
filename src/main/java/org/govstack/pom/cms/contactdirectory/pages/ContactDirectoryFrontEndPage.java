package org.govstack.pom.cms.contactdirectory.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.cms.contactdirectory.locators.ContactDirectoryFrontEndLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactDirectoryFrontEndPage {

    ContactDirectoryFrontEndLocators directoryFrontEndLocators = new ContactDirectoryFrontEndLocators();
    CommonMethods methods=new CommonMethods();

    public void validateContactCategory() {
        boolean contactCategory = false;
        for (WebElement ele : directoryFrontEndLocators.categoryTitle) {
            if (ele.getText().contains(ContactDirectoryPage.contactsCategoryOrFolder)) {
                CommonMethods.highlightElement(ele);
                contactCategory = true;
                break;
            }
        }
        if (contactCategory) {
            ExtentReporter.logWithScreenshot(LogStatus.PASS, ContactDirectoryPage.contactsCategoryOrFolder + " is Published");
        } else {
            ExtentReporter.log(LogStatus.FAIL, ContactDirectoryPage.contactsCategoryOrFolder + " is not Published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, ContactDirectoryPage.contactsCategoryOrFolder + " is not Published");
            Assert.fail();
        }
    }

    public void validateContactCategoryNotDisplayed() {
        boolean contactCategory = false;
        for (WebElement ele : directoryFrontEndLocators.categoryTitle) {
            if (ele.getText().equals(ContactDirectoryPage.contactsCategoryOrFolder)) {
                CommonMethods.highlightElement(ele);
                contactCategory = true;
                break;
            }
        }
        if (contactCategory) {
            ExtentReporter.log(LogStatus.FAIL, ContactDirectoryPage.contactsCategoryOrFolder + " is Published");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, ContactDirectoryPage.contactsCategoryOrFolder + " is Published");
            Assert.fail();
        } else {
            ExtentReporter.log(LogStatus.PASS, ContactDirectoryPage.contactsCategoryOrFolder + " is not Published");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, ContactDirectoryPage.contactsCategoryOrFolder + " is not Published");
        }
    }

    public void validateContactDetails(){
        boolean primaryNumber=false;
        for(WebElement ele: directoryFrontEndLocators.primaryNumber){
            if(methods.getElementText(ele).equals(ContactDirectoryPage.contactNumber)){
                primaryNumber=true;
                break;
            }
        }
        if(primaryNumber){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,"ContactDetails Updated");
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"ContactDetails not Updated");
            Assert.fail();
        }
    }
}
