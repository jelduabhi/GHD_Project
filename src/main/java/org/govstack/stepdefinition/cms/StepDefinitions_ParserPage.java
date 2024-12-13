package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.parserPage.pages.ParserPagePage;
import org.govstack.pom.cms.utils.CommonPageUtils;

public class StepDefinitions_ParserPage {
    ParserPagePage parserPage = new ParserPagePage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();

    @And("Create New Parser Page {string}")
    public void create_new_parser(String testcaseID) {
        TestData.readTestData(testcaseID, "Parser");
        parserPage.enterParserPageDetails();
    }

    @Then("User should be able to publish the parser")
    public void i_should_be_able_to_publish_the_parser() {
        commonPageUtils.saveAndPublish();
        parserPage.verifyParser();
    }

    @When("Launch and Login to Calendar Event Management {string}")
    public void navigate_to_event_management(String testCaseID) {
        TestData.readTestData(testCaseID, "Parser");
        parserPage.navigateToCalendarEventManagement();
    }

    @When("Navigate to Configuration Tab - Templates")
    public void navigate_templates_configuration_tab() {
        parserPage.navigateToTemplatesConfigTab();
    }

    @And("Update the Remote URL and Verify Element ID {string}")
    public void update_the_remote_url_verify_element_id(String testCaseID) {
        TestData.readTestData(testCaseID, "Parser");
        parserPage.updateTemplate();
    }

    @Then("Save Calendar Template")
    public void save_calendar_template() {
        parserPage.saveCalendarTemplate();
    }

    @Then("Calendar Template should be updated in Management View {string}")
    public void calendar_template_should_be_updated(String testCaseID) {
        TestData.readTestData(testCaseID, "Parser");
        parserPage.verifyCalendarTemplateInManagement();
    }

    @When("Launch and Login to Form Management {string}")
    public void navigate_to_form_management(String testCaseID) {
        TestData.readTestData(testCaseID, "Parser");
        parserPage.navigateToFormManagement();
    }

    @When("Navigate to FB Configuration Tab - Templates")
    public void navigate_fb_templates_configuration_tab() {
        parserPage.navigateToFBTemplatesConfigTab();
    }

    @Then("Save Form Builder Template")
    public void save_formBuilder_template() {
        parserPage.saveFormBuilderTemplate();
    }

    @Then("Verify Demo Form should be updated {string}")
    public void demo_form_should_be_updated(String testCaseID) {
        TestData.readTestData(testCaseID, "Parser");
        parserPage.verifyDemoForm();
    }

    @When("Launch Demo Form {string}")
    public void launch_demo_form(String testCaseID) {
        TestData.readTestData(testCaseID, "Parser");
        parserPage.launchDemoForm();
    }

    @And("Test Parser Page with Test Form")
    public void test_parser_page_with_test_form() {
        parserPage.testParserPageWithTestForm();
    }

    @And("Verify Thank You Message should appear")
    public void verify_thank_you_message() {
        parserPage.verifyThankyouMessage();
    }

    @And("Verify Top Navigation is responsive")
    public void verify_top_navigation() {
        parserPage.verifyTopNavigation();
    }

    @And("Go to Content Home and Navigate to Parsers")
    public void navigate_to_parser() {
        parserPage.navigateToParser();
    }

    @When("Delete Parser {string}")
    public void delete_parser(String testCaseID) {
        TestData.readTestData(testCaseID, "Parser");
        parserPage.deleteParser();
    }

}
