package org.govstack.pom.cms.mediamanagermetainfo.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.mediamanagermetainfo.locators.MediaMetaInfo_Locators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;

public class MediaMetaInfoPages {

    CommonMethods methods = new CommonMethods();
    MediaMetaInfo_Locators mediaMetaInfoLocators = new MediaMetaInfo_Locators();
    public static String mediaSubFolderName;
    public static String mediaPage;

    public void createSubfolderMediaPages() {
        mediaSubFolderName = "Automation_Media_" + methods.generateRandomString();
        methods.rightClickOnTheElement(mediaMetaInfoLocators.mediaPagesEllipsBtn);
        methods.clickElement(mediaMetaInfoLocators.mediaPagesSubfolderBtn);
        methods.waitForElement(3);
        methods.sendTextToElement(mediaMetaInfoLocators.headerName, mediaSubFolderName);
    }

    public void createMediaPage(){
        mediaPage=TestData.getData("Media Page")+"_"+methods.generateRandomString();
        methods.clickElement(mediaMetaInfoLocators.getElement(mediaSubFolderName));
        methods.clickElement(mediaMetaInfoLocators.mediaPageLnk);
        methods.clickElement(mediaMetaInfoLocators.blankPage);
        methods.waitForElement(3);
        methods.sendTextToElement(mediaMetaInfoLocators.headerName, mediaPage);
        methods.clickElement(mediaMetaInfoLocators.fileBtn);
        methods.waitForElement(3);
        methods.sendTextToElement(mediaMetaInfoLocators.searchTxt,TestData.getData("File"));
        methods.clickElement(mediaMetaInfoLocators.logolnk);
        methods.clickElement(mediaMetaInfoLocators.selectBtn);
        methods.waitForElement(3);
        methods.clickElement(mediaMetaInfoLocators.documentCategoriesAddBtn);
        methods.waitForElement(3);
        for(WebElement ele:mediaMetaInfoLocators.categoryList){
            if(ele.getText().equals(TestData.getData("Category"))){
                methods.clickElement(ele);
                break;
            }
        }
        methods.clickElement(mediaMetaInfoLocators.submitBtn);
        methods.waitForElement(3);
        methods.clickElement(mediaMetaInfoLocators.documentMetaInformationBtn);
        if (TestData.getData("Meta Information Content").equals("Text Field")) {
            methods.clickElement(mediaMetaInfoLocators.textFieldLnk);
            methods.waitForElement(2);
            methods.clickElement(mediaMetaInfoLocators.fieldPropertyBtn);
            methods.waitForElement(3);
            methods.sendTextToElement(mediaMetaInfoLocators.fieldValueTxt, TestData.getData("Field Value"));
        } else {
            ExtentReporter.log(LogStatus.FAIL, "Please select Meta Information Content");
        }
    }

    public void validateMediaPage(){
        //methods.clickElement();
    }
}
