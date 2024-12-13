package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.dashboard.pages.DashboardPage;
import org.govstack.pom.login.pages.LoginPage;


public class StepDefinitions_Dashboard {
    LoginPage loginpage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("Login as Website Admin on Govstack QA")
    public void loginAsWebsiteAdminOnGovstackQA() {
        loginpage.loginToGovStack_BackOffice();
    }

    @Then("Verify Dashboard Welcome message {string}")
    public void verify_dashboard_welcome_message(String TestcaseID) {
        TestData.readTestData(TestcaseID, "Dashboard");
        dashboardPage.verifyDashboardWelcomeMsg();
    }


    @Then("Verify Dashboard Recent Activities {string}")
    public void verifyDashboardRecentActivities(String TestcaseID) {
        TestData.readTestData(TestcaseID, "Dashboard");
        dashboardPage.verifyDashboardRecentActivities();
    }

    @Then("Verify Dashboard My recent Activites {string}")
    public void verifyDashboardMyRecentActivites(String TestcaseID) {
        TestData.readTestData(TestcaseID, "Dashboard");
        dashboardPage.verifyDashboardMyRecentActivities();

    }

    @Then("Verify Dashboard Pending Content {string}")
    public void verifyDashboardPendingContent(String TestcaseID) {
        TestData.readTestData(TestcaseID, "Dashboard");
        dashboardPage.verifyDashboardPendingContent();

    }

    @Then("Verify Dashboard Help {string}")
    public void verifyDashboardHelp(String TestcaseID) {
        TestData.readTestData(TestcaseID, "Dashboard");
        dashboardPage.verifyDashboardHelp();
    }

    //GOVPORT_014 Validate user can access dashboard
    @Then("Verify nav icon click with list of CMS, Events, Forms, Citizen Portal")
    public void verify_nav_icon_click_with_list_of_cms_events_forms_citizen_portal() {
        dashboardPage.ribbonClick();

    }

    @When("user click citizen portal link then verify citizen portal url is open")
    public void user_click_citizen_portal_link_then_verify_citizen_portal_url_is_open() {
        dashboardPage.citizenNavList();
    }

    @When("Click support link")
    public void click_support_link() {
        dashboardPage.supportLinkMenu();
    }

    @Then("verify support link open i new tab")
    public void verify_support_link_open_i_new_tab() {
        dashboardPage.supportLinkPage();
    }

    @When("Click learning center link")
    public void click_learning_center_link() {
        dashboardPage.learningCenterLinkMenu();
    }

    @Then("verify learning center link open i new tab")
    public void verify_learning_center_link_open_i_new_tab() {
        dashboardPage.learningCenterLinkPage();

    }

    @When("click on govstack logo")
    public void click_on_govstack_logo() {
        dashboardPage.gsLogo();
    }

    @Then("verify dashboard url will be open")
    public void verify_dashboard_url_will_be_open() {
        dashboardPage.dashboardUrlAssertion("https://ghd-app-cac-s-govstackdashboardui.azurewebsites.net/dashboard");
    }

    @When("Click User profile")
    public void click_user_profile() {
        dashboardPage.govStackUserProfile();
    }

    @Then("Click User signout")
    public void click_user_signout() {
        dashboardPage.govStackUserSignout();
    }

    @When("Click manage user link")
    public void click_manage_user_link() {
        dashboardPage.govStackManageUser();
    }

    @Then("verify manage use link open i new tab")
    public void verify_manage_use_link_open_i_new_tab() {
        dashboardPage.govstackManageUserAssertion();
    }

    @When("user click business Directory link")
    public void user_click_business_directory_link() {
        dashboardPage.businessDirectoryNavList();
    }


    @When("user click {string} card")
    public void user_click_card(String url) {
        loginpage.launchApplication(url);
    }

    @Then("verify url is open {string}")
    public void verify_url_is_open(String url) {
        dashboardPage.businessDirectoryUrlAssertion(url);
    }

    @When("user click park and facilities link")
    public void user_click_park_and_facilities_link() {
        dashboardPage.parkFacilitiesNavList();
    }

    @When("user click subscription management link")
    public void user_click_subscription_management_link() {
        dashboardPage.subscriptionMgtNavList();
    }

    @When("user click tenant service link")
    public void user_click_tenant_service_link() {
        dashboardPage.tenantServiceNavList();
    }

    @When("user click citizen portal card")
    public void user_click_citizen_portal_card() {
        dashboardPage.citizenCardOpen();
    }

    @When("user click business directory card")
    public void user_click_business_directory_card() {
        dashboardPage.businessDirectoryCardOpen();
    }

    @When("user click park and facilities card")
    public void user_click_park_and_facilities_card() {
        dashboardPage.parkFacilitiesCardOpen();
    }

    @When("user click subscription management card")
    public void user_click_subscription_management_card() {
        dashboardPage.subscriptionMgtCardOpen();
    }

    @When("user click tenant service card")
    public void user_click_tenant_service_card() {
        dashboardPage.tenantCardOpen();
    }

    @When("user click events card")
    public void user_click_events_card() {
        dashboardPage.eventsCardOpen();
    }

    @When("user click forms card")
    public void user_forms_card() {
        dashboardPage.formsCardOpen();
    }


    @Then("verify cards visible")
    public void verify_cards_visible() {
        dashboardPage.cardHeaderValidation();
    }

    @When("user click setting link and manage user link")
    public void user_click_setting_link_and_manage_user_link() {
        dashboardPage.govstackSettingIcon();
        dashboardPage.govstackManageUserPermissionLink();
    }

    @When("user click events link")
    public void user_click_events_link() {
        dashboardPage.gsEventsRibbon();
    }

    @When("user click forms link")
    public void user_click_forms_link() {
        dashboardPage.gsFormsRibbon();
    }

    @When("user click cms link")
    public void user_click_cms_link() {
        dashboardPage.gsCmsRibbon();
    }


}
