package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.news.pages.NewsFrontEndPage;
import org.govstack.pom.cms.news.pages.NewsSearchPage;
import org.govstack.utils.CommonMethods;


public class StepDefinitions_Login {

    LoginPage loginPage = new LoginPage();
    NewsFrontEndPage frontEndPage = new NewsFrontEndPage();
    CommonMethods methods = new CommonMethods();
    NewsSearchPage newsPageFrontend = new NewsSearchPage();

    @Given("user launch and login GovStack Back Office")
    public void user_launch_and_login_gov_stack_back_office() {
        loginPage.loginToGovStack_BackOffice();
    }

    @And("switch to new tab and validate Login page")
    public void switch_to_new_tab() {
        methods.openAndSwitchNewTab();
        loginPage.launchGovStack();
        loginPage.verifyDashBoard();
        methods.openAndSwitchNewTab();
        loginPage.launchGovStack();
        loginPage.verifyDashBoard();
    }

    @Then("Dash board should be displayed")
    public void dash_board_should_be_displayed() {
        loginPage.verifyDashBoard();
    }

    @Given("Launch and login GovStack CMS Back Office")
    public void i_launch_and_login_to_the_govStack_application() {
        loginPage.loginToGovStack_BackOffice();
        loginPage.launchCMSApplication();
    }

    @Given("Launch and login GovStack Dashboard")
    public void i_launch_and_login_Dashboard() {
        loginPage.loginToGovStack_BackOffice();

    }

    @When("User launch the News frond end application in new tab")
    public void I_launch_the_News_frond_end_application_in_new_tab() {
        frontEndPage.launchFrontEndInNewTab();
    }

    //TC_GOVCMS317_6 & TC_GOVCMS317_7  Validate as a Fed User, validate using an invalid/password

    @Given("user launch and login GovStack Back Office using fed user or local user with invalid username or password  {string}")
    public void user_launch_and_login_gov_stack_back_office_using_fed_user_or_local_user_with_invalid_username_or_password(String testcaseID) {
        TestData.readTestData(testcaseID, "SSO");
        loginPage.loginToGovStack_BackOffice_FedUserOrLocalUser();
    }

    @When("I Go to Govstack QA Frontend News | Prestige")
    public void i_go_to_govstack_qa_frontend_news_prestige() throws InterruptedException {
        loginPage.launchFrontEndApplication();
        Thread.sleep(4000);
        newsPageFrontend.dismissAllAlerts();
        Thread.sleep(4000);
    }
}
