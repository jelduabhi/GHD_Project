package org.govstack.pom.cms.calender.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.calender.locators.CalenderLocators;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.utils.CommonLocators;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;

public class CalenderPages {

    CommonMethods methods=new CommonMethods();
    CalenderLocators calenderLocators=new CalenderLocators();
    CommonLocators commonLocators=new CommonLocators();
    ContentMainLocators mainLocators=new ContentMainLocators();
    public static String calenderHeading;
    public static String newPageHeading;

    public void submitCalender(){
        methods.clickElement(calenderLocators.clientName);
        methods.selectValueFromText(TestData.getData("Client Name"));
        methods.clickElement(calenderLocators.nextOrSubmitBtn);
        methods.waitForElement(3);
        methods.clickElement(calenderLocators.nextOrSubmitBtn);
        methods.waitForElement(3);
        if(TestData.getData("Calender_ID").equalsIgnoreCase("No")) {
            methods.clearElementInput(calenderLocators.calenderIdTxt);
        }
        methods.clickElement(calenderLocators.nextOrSubmitBtn);
        methods.waitForElement(7);
        if(methods.getElementText(calenderLocators.successMessage).equals("200 Success")){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,"200 Success, Values for"+ TestData.getData("Client Name")+" have been successfully uploaded.");
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Unable to submit");
            Assert.fail("Unable to submit the calender");
        }
    }

    public void saveCustomIntegrations(){
        methods.moveToElement(calenderLocators.customIntegrationLnk);
        methods.clickElement(calenderLocators.customIntegrationLnk);
        methods.waitForElement(2);
        methods.clickElement(commonLocators.saveAndPublishBtn);
        methods.waitForElement(5);
    }

    public void createNewPageWithCalender(){
        newPageHeading=TestData.getData("Main Page Heading")+"_"+methods.generateRandomString();
        calenderHeading= TestData.getData("calendarFeedHeading")+"_"+methods.generateRandomString();
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.clickElement(mainLocators.mainPageEllipsisBtn);
        methods.waitForElement(2);
        methods.clickElement(calenderLocators.createPageBtn);
        methods.waitForElement(2);
        methods.clickElement(calenderLocators.blankPageBtn);
        methods.waitForElement(2);
        methods.sendTextToElement(calenderLocators.headerNameTxt,newPageHeading);
        methods.clickElement(calenderLocators.mainContentAddBtn);
        methods.waitForElement(3);
        methods.sendTextToElement(calenderLocators.searchTxt, TestData.getData("Content Type"));
        methods.waitForElement(2);
        methods.clickElement(calenderLocators.blockCardLnk);
        methods.waitForElement(2);
    }

    public void enterContentDetails(){
        methods.clickElement(calenderLocators.contentLnk);
        methods.sendTextToElement(calenderLocators.calendarFeedHeading,calenderHeading);
        methods.clickElement(calenderLocators.createBtn);
    }

    public void enterConfigurationDetails(){
        methods.selectValueFromDropdown(calenderLocators.calendarDropdown,TestData.getData("Calendar"));
        methods.waitForElement(2);
        methods.selectValueFromDropdown(calenderLocators.viewDropdown,TestData.getData("View"));
        methods.waitForElement(2);
        methods.selectValueFromDropdown(calenderLocators.categoriesDropdown,TestData.getData("Categories"));
        methods.waitForElement(2);

    }

    public void validateCalendar(){
        methods.clickElement(calenderLocators.infoBtn);
        methods.clickElement(calenderLocators.frontEndLnk);
        methods.switchToWindow();
        methods.waitForElement(5);
        methods.clickElement(commonLocators.dismissAllAlerts);
        methods.waitForElement(2);
        if(methods.getElementText(calenderLocators.frontEndMainPageHeading).equals(newPageHeading) &&
        methods.getElementText(calenderLocators.FrontEndCalendarHeading).equals(calenderHeading)){
            ExtentReporter.logWithScreenshot(LogStatus.PASS,"Front End Validated");
        }else{
            ExtentReporter.logWithScreenshot(LogStatus.FAIL,"Front end is not valiated");
        }
    }
}
