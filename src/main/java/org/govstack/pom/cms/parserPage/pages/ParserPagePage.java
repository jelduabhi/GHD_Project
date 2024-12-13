package org.govstack.pom.cms.parserPage.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.alerts.locators.AlertLocators;
import org.govstack.pom.cms.alerts.pages.AlertPage;
import org.govstack.pom.cms.contentMain.locators.ContentMainLocators;
import org.govstack.pom.cms.dashboard.pages.DashboardPage;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.parserPage.locators.ParserPageLocators;
import org.govstack.pom.cms.news.locators.NewsLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;


public class ParserPagePage {
    public static String parserName;
    public static String headerName;
    public static String demoFormURL;

    CommonMethods methods = new CommonMethods();
    ParserPageLocators parserLocators = new ParserPageLocators();
    ContentMainLocators mainLocators = new ContentMainLocators();
    NewsLocators newsLocators = new NewsLocators();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AlertLocators alertLocators = new AlertLocators();

    public void enterParserPageDetails() {
        enterSettingsDetails();
    }

    public void enterSettingsDetails() {
        parserName = TestData.getData("Parser Name");
        methods.sendTextToElement(parserLocators.parserNameTxt, parserName);
        methods.sendTextToElement(parserLocators.divIdTxt, TestData.getData("Div ID"));
        methods.sendTextToElement(parserLocators.divInnerTxt, TestData.getData("Div Inner Text"));
    }

    public void verifyParser() {
        methods.clickElement(mainLocators.selectParsers);
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt, parserName);
        for (WebElement ele : newsLocators.results) {
            if (ele.getText().contains(parserName)) {
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(LogStatus.PASS, "Parser Created");
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Parser Created");
                break;
            } else {
                ExtentReporter.log(LogStatus.FAIL, "Parser not Created");
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Parser not Created");
            }
        }
    }

    public void navigateToCalendarEventManagement() {
        loginPage.launchAndLoginToCalendarEventManagement(TestData.getData("Event Management URL"));
        methods.waitForElement(3);
    }

    public void navigateToTemplatesConfigTab() {
        methods.clickElement(parserLocators.configurationTab);
        methods.clickElement(parserLocators.templatesTab);
        methods.clickElement(parserLocators.stgRegressionTemplateEditBtn);
    }

    public void updateTemplate() {
        if (Objects.equals(ConfigurationManager.getPropertyValue("ENV"), "PENTEST")) {
            methods.sendTextToElement(parserLocators.remoteURLTxt, TestData.getData("Remote URL Pentest"));
            methods.sendTextToElement(parserLocators.elementIDTxt, TestData.getData("Element ID"));
        } else {
            methods.sendTextToElement(parserLocators.remoteURLTxt, TestData.getData("Remote URL"));
            methods.sendTextToElement(parserLocators.elementIDTxt, TestData.getData("Element ID"));
        }
    }

    public void saveCalendarTemplate() {
        methods.clickElement(parserLocators.saveBtn);
    }

    public void saveFormBuilderTemplate() {
        methods.clickElement(parserLocators.fbSaveBtn);
    }

    public void verifyCalendarTemplateInManagement() {
        headerName = TestData.getData("Header Name");
        loginPage.launchCalendarEventView(TestData.getData("Template URL"));
        methods.waitForElement(3);
        try {
            methods.assertEqualsOfElementText(parserLocators.headerNameLbl, headerName);
            ExtentReporter.log(LogStatus.PASS,"Updated Calendar is displayed");
        } catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Updated Calendar is not displayed");
            Assert.fail();
        }
    }

    public void navigateToFormManagement() {
        loginPage.launchAndLoginToFormManagement(TestData.getData("Event Management URL"));
    }

    public void navigateToFBTemplatesConfigTab() {
        methods.clickElement(parserLocators.fbConfigTab);
        methods.clickElement(parserLocators.fbTemplatesTab);
        methods.clickElement(parserLocators.defaultTemplateEditBtn);
    }

    public void verifyDemoForm() {
        demoFormURL = TestData.getData("Template URL");
        headerName = TestData.getData("Header Name");
        methods.clickElement(parserLocators.fbListTab);
        methods.clickElement(parserLocators.launchOptionsBtn);
        methods.assertEqualsOfElementText(parserLocators.launchDemoForm, demoFormURL);
        loginPage.launchCalendarEventView(TestData.getData("Template URL"));
        methods.waitForElement(3);
        try {
            methods.assertEqualsOfElementText(parserLocators.headerNameLbl, headerName);
            ExtentReporter.log(LogStatus.PASS,"Updated Form is displayed");
        } catch (Exception e){
            ExtentReporter.log(LogStatus.FAIL,"Updated Form is not displayed");
            Assert.fail();
        }
    }

    public void launchDemoForm() {
        loginPage.launchCalendarEventView(TestData.getData("Template URL"));
        methods.waitForElement(2);
        methods.clickElement(parserLocators.acceptCookiesBtn);
    }

    public void testParserPageWithTestForm() {
        methods.assertEqualsOfElementText(parserLocators.testFormHeadingTxt, "Test Form");
        methods.clickElement(parserLocators.whichCountryDropdown);
//        methods.sendTextToElement(parserLocators.whichCountrySearchTxt, "Philippines");
        methods.clickElement(parserLocators.selectCountry);
        methods.clickElement(parserLocators.continueBtn);
        methods.clickElement(parserLocators.chooseDate);
        methods.clickElement(parserLocators.dateToday);
        methods.clickElement(parserLocators.chooseTime);
        methods.clickElement(parserLocators.chooseHr);
        methods.clickElement(parserLocators.chooseMin);
//        methods.assertTrueForElementNotPresent(parserLocators.contactOption);
        methods.clickElement(parserLocators.yesRadioBtn);
        methods.waitForElement(2);
        methods.clickElement(parserLocators.contactOption);
        methods.clickElement(parserLocators.emailOption);
        methods.sendTextToElement(parserLocators.emailTxt, "qavaluser@ghd.com");
        methods.assertEqualsOfElementText(parserLocators.calculationTxt, "");
        methods.sendTextToElement(parserLocators.panelTxt, "Test");
        methods.clickElement(parserLocators.addBtn);
        methods.clickElement(parserLocators.signatureField);
//        methods.clickElement(parserLocators.recaptchaCheckBox);
        methods.waitForElement(20);
        methods.clickElement(parserLocators.continueBtn);
    }

    public void verifyThankyouMessage() {
        methods.waitForElement(3);
        methods.assertEqualsOfElementText(parserLocators.thankYouMessage, "Thank You");
    }

    public void verifyTopNavigation() {{
        methods.waitForElement(15);
        methods.clickElement(parserLocators.govstackLogo);
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "Govstack logo clicked successfully");
    }
        if (Objects.equals(ConfigurationManager.getPropertyValue("ENV"), "PENTEST")) {
        methods.waitForElement(3);
            dashboardPage.dashboardUrlAssertion(TestData.getData("Dashboard URL Pentest"));
        } else {
            dashboardPage.dashboardUrlAssertion(TestData.getData("Dashboard URL"));
        }
    }

    public void navigateToParser() {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectParsers);
        methods.waitForElement(2);
    }

    public void deleteParser() {
        parserName = TestData.getData("Parser Name");
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt, parserName);
        methods.waitForElement(5);
        AlertPage.alertTitle = methods.getElementText(alertLocators.alertsTitles.getFirst());
        methods.clickElement(alertLocators.alertsLists.getFirst());
        methods.clickElement(alertLocators.deleteBtn);
        methods.clickElement(alertLocators.yesDeleteBtn);
        methods.waitForElement(1);
    }
}