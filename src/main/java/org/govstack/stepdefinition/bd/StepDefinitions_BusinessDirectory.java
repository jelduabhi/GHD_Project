package org.govstack.stepdefinition.bd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.pom.bd.businessDirectoryUserMgt.pages.BusinessDirectoryUserMgtPage;
import org.govstack.pom.cms.dashboard.pages.DashboardPage;
import org.govstack.pom.login.pages.LoginPage;

public class StepDefinitions_BusinessDirectory {

    LoginPage loginPage = new LoginPage();
    BusinessDirectoryUserMgtPage businessDirectoryUsermgtPg = new BusinessDirectoryUserMgtPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("Launch and login Business Directory Back Office")
    public void Launch_and_login_Business_Directory_Back_Office() {
        loginPage.loginToGovStack_BackOffice();
        loginPage.businessDirectoryCMSApplication();
    }

    @Then("Business directory page should be displayed")
    public void Business_directory_page_should_be_displayed() {
        businessDirectoryUsermgtPg.businessDirectoryPageValidationAssertion();
    }

    @Then("verify user navigated to dashboard page")
    public void verify_user_navigated_to_dashboard_page() {
        businessDirectoryUsermgtPg.businessDirectoryPostSignOutValidationAssertion();
    }

    @When("user click dashboard link")
    public void user_click_dashboard_link() {
        dashboardPage.dashboardNavList();
    }


}
