package org.govstack.pom.cms.contactdirectory.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.contactdirectory.locators.ContactDirectoryLocators;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.news.locators.NewsLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;

public class ContactDirectoryPage {

    public static String contactsCategoryOrFolder;
    public static String contactName;
    public static String contactNumber;
    ContactDirectoryLocators directoryLocators = new ContactDirectoryLocators();
    CommonMethods methods = new CommonMethods();
    NewsLocators newsLocators=new NewsLocators();
    ContentMainLocators mainLocators=new ContentMainLocators();

    public void createContactsCategoryOrFolder() {
        contactsCategoryOrFolder = TestData.getData("Header Name") + "_" + methods.generateRandomString();
        methods.sendTextToElement(directoryLocators.headerNameTxt, contactsCategoryOrFolder);
    }

    public void clickNewContact() {
        methods.clickElement(directoryLocators.createNewContactBtn);
        methods.waitForElement(1);
    }

    public void createNewContact() {
        String headerName=TestData.getData("Header Name");
        String randomString=methods.generateRandomString();
        contactName=headerName+"_"+randomString;
        methods.sendTextToElement(directoryLocators.headerNameTxt,contactName );
        methods.sendTextToElement(directoryLocators.firstNameTxt, headerName);
        methods.sendTextToElement(directoryLocators.lastNameTxt, randomString);
        methods.sendTextToElement(directoryLocators.titleTxt, contactName);
        methods.sendTextToElement(directoryLocators.emailTxt, TestData.getData("Email"));
        methods.sendTextToElement(directoryLocators.descriptionTxt, TestData.getData("Description"));
        methods.sendTextToElement(directoryLocators.locationText, TestData.getData("Location Text"));
        methods.sendTextToElement(directoryLocators.locationLinkTxt, TestData.getData("Location Link"));
        methods.selectValueFromList(directoryLocators.categoryListsDropDown, 1);
    }

    public void verifyNewContact(){
        methods.clickElement(mainLocators.contactListLnk);
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt, contactName);
        methods.waitForElement(2);
        for (WebElement ele : newsLocators.results) {
            if (ele.getText().contains(contactName)) {
                CommonMethods.highlightElement(ele);
                methods.clickElement(ele);
                break;
            }
        }
    }

    public void enterContactDetails(){
        String phoneName=TestData.getData("phoneName")+"_"+methods.generateRandomString();
        methods.sendTextToElement(directoryLocators.headerNameTxt,phoneName);
        methods.sendTextToElement(directoryLocators.phoneNameTxt,phoneName);
        contactNumber=Long.toString(methods.generateRandomNumber());
        methods.sendTextToElement(directoryLocators.phoneNumberTxt,contactNumber);
    }

    public void verifyContactsCategoryOrFolder() {
        boolean contactsCategory = false;
        methods.waitForElement(2);
        for (WebElement categoryFolder : directoryLocators.categoryLists) {
            if (categoryFolder.getText().equals(contactsCategoryOrFolder)) {
                methods.moveToElement(categoryFolder);
                CommonMethods.highlightElement(categoryFolder);
                contactsCategory = true;
                break;
            }
        }
        if (contactsCategory) {
            ExtentReporter.logWithScreenshot(LogStatus.PASS, contactsCategoryOrFolder + " is created");
        } else {
            ExtentReporter.log(LogStatus.FAIL, contactsCategoryOrFolder + " is not created");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, contactsCategoryOrFolder + " is not created");
        }
    }

    public void updateContactsCategory() {
        methods.waitForElement(2);
        for (WebElement categoryFolder : directoryLocators.categoryLists) {
            if (categoryFolder.getText().contains("Automation Contact Category") && !categoryFolder.getText().contains("Updated")) {
                methods.moveToElement(categoryFolder);
                CommonMethods.highlightElement(categoryFolder);
                methods.clickElement(categoryFolder);
                contactsCategoryOrFolder = TestData.getData("Header Name") + "_" + methods.generateRandomString();
                methods.clickElement(directoryLocators.infoTabBtn);
                methods.sendTextToElement(directoryLocators.headerNameTxt, contactsCategoryOrFolder);
                ExtentReporter.logWithScreenshot(LogStatus.PASS, contactsCategoryOrFolder + " is Updated");
                break;
            }
        }
    }

    public void deleteContactsCategory() {
        methods.waitForElement(2);
        for (WebElement categoryFolder : directoryLocators.categoryLists) {
            if (categoryFolder.getText().contains("Automation Contact Category")) {
                contactsCategoryOrFolder = categoryFolder.getText();
                methods.moveToElement(categoryFolder);
                CommonMethods.highlightElement(categoryFolder);
                methods.rightClickOnTheElement(categoryFolder);
                methods.clickElement(directoryLocators.deleteBtn);
                methods.clickElement(directoryLocators.deleteConfirmBtn);
                methods.waitForElement(4);
                if (methods.isElementPresent(directoryLocators.deleteSuccessMsg)) {
                    CommonMethods.highlightElement(directoryLocators.deleteSuccessMsg);
                    methods.clickElement(directoryLocators.okBtn);
                } else {
                    ExtentReporter.log(LogStatus.FAIL, contactsCategoryOrFolder + " is not deleted");
                }
                break;
            }
        }
    }

    public void verifyContactsCategoryOrFolderNotDisplayed() {
        boolean contactsCategory = false;
        methods.waitForElement(2);
        for (WebElement categoryFolder : directoryLocators.categoryLists) {
            if (categoryFolder.getText().equals(contactsCategoryOrFolder)) {
                methods.moveToElement(categoryFolder);
                CommonMethods.highlightElement(categoryFolder);
                contactsCategory = true;
                break;
            }
        }
        if (contactsCategory) {
            ExtentReporter.log(LogStatus.FAIL, contactsCategoryOrFolder + " is Not deleted");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, contactsCategoryOrFolder + " is not deleted");
        } else {
            ExtentReporter.log(LogStatus.PASS, contactsCategoryOrFolder + " is deleted");
            ExtentReporter.logWithScreenshot(LogStatus.PASS, contactsCategoryOrFolder + " is deleted");
        }
    }

    public void selectContactList(){
        for(WebElement ele:directoryLocators.contactsList){
            if(methods.getElementText(ele).contains("Automation Contact") && !methods.getElementText(ele).contains("updated")){
                methods.clickElement(ele);
                break;
            }
        }
    }

    public void selectContactNum(){
        for(WebElement ele:directoryLocators.contactsList){
            if(methods.getElementText(ele).contains("Automation")){
                methods.clickElement(ele);
                break;
            }
        }
    }

    public void updateContactNumber(){
        selectContactList();
        methods.waitForElement(2);
        selectContactNum();
        methods.waitForElement(2);
        enterContactDetails();
    }
}
