package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.calender.pages.CalenderPages;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.pom.login.pages.LoginPage;

public class StepDefinitions_Calender {

    LoginPage loginPage=new LoginPage();
    CalenderPages calenderPage=new CalenderPages();
    CommonPageUtils commonPageUtils=new CommonPageUtils();

    @Given("user launch tenant application")
    public void user_launch_tenant_application() {
        loginPage.launchTenantApplication();
    }
    @When("user submit tenant app with or without calender {string}")
    public void user_submit_tenant_app_without_without_calender(String testCaseID) {
        TestData.readTestData(testCaseID,"Calender");
        calenderPage.submitCalender();
    }


    @When("user launch the CMS application")
    public void user_launch_the_cms_application() {
        loginPage.launchCMSWithoutCred();
        loginPage.launchCMSApplication();
    }

    @When("create a new page under main with calendar content")
    public void create_a_new_page_under_main() {
        calenderPage.saveCustomIntegrations();
        calenderPage.createNewPageWithCalender();
        calenderPage.enterConfigurationDetails();
        calenderPage.enterContentDetails();
        commonPageUtils.saveAndPublish();
    }

    @When("validate calender in front end page")
    public void go_to_content_section() {
        calenderPage.validateCalendar();
    }

}
