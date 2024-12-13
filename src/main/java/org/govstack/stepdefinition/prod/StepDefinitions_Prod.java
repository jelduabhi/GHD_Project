package org.govstack.stepdefinition.prod;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.govstack.framework.TestData;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.prod.pages.Prod_Pages;
import org.govstack.utils.CommonMethods;

public class StepDefinitions_Prod {

    LoginPage loginPage=new LoginPage();
    Prod_Pages prodPages=new Prod_Pages();
    CommonMethods methods=new CommonMethods();

    @Given("User launch the production url {string} {string}")
    public void user_launch_the_production_url(String url, String ClientName) {
//        TestData.readTestData(testCaseID,"Prod");
//        loginPage.launchProdFrontEnd(TestData.getData("Prod_Url"));
        loginPage.launchProdFrontEnd(url, ClientName);
    }

    @Then("Validate the homepage content, navigation and CSS layout are loaded properly")
    public void validate_the_homepage_content_navigation_and_css_layout_are_loaded_properly() {
        prodPages.validateBrokenLinks();
    }

    @Then("Validate any js or CSS {int} Errors related to site builder bundle")
    public void validate_any_js_or_css_errors_related_to_site_builder_bundle(Integer int1) {
        System.out.println(int1);
        methods.validateLogsInConsole();
    }

    @Then("user launch and login prod GovStack Back Office {string}")
    public void user_launch_and_login_prod_gov_stack_back_office(String url) {
//        loginPage.loginProdBackOffice(TestData.getData("Prod_Url"));
        loginPage.loginProdBackOffice(url);
    }

    @Then("Validate Logs for errors")
    public void validate_logs_for_errors() {
        prodPages.validateErrorInLogs();
    }

    @Then("Validate Examine Management")
    public void validate_examine_management() {
        prodPages.validateExamineManagement();
    }

    @Then("Mode should be set to Nothing")
    public void mode_should_be_set_to_nothing() {
        prodPages.validateModelBuilder();
    }
}
