package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.outbound.pages.OutBoundFrontEndPage;
import org.govstack.pom.cms.outbound.pages.OutBoundPage;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;

public class StepDefinitions_OutBound {

    ContentMainPage contentMainPage = new ContentMainPage();
    OutBoundPage outBoundPage = new OutBoundPage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    CommonMethods methods=new CommonMethods();
    LoginPage loginPage=new LoginPage();
    OutBoundFrontEndPage frontEndPage=new OutBoundFrontEndPage();

    @When("user navigate to regular page")
    public void user_navigate_to_regular_page() {
        contentMainPage.expandMainContent();
    }

    @When("user add outbound link to the regular page {string}")
    public void user_add_outBound_link_to_the_regular_page(String testCaseID) {
        TestData.readTestData(testCaseID, "OutBound");
        outBoundPage.createNewOutboundLink();
        commonPageUtils.saveAndPublish();
    }

    @Then("outbound link should be added")
    public void outbound_link_should_be_added() {
        outBoundPage.verifyOutBoundCreated();
    }


    @When("user try to add Outbound Link on homepage")
    public void user_try_to_add_outbound_link_on_homepage() {
        outBoundPage.verifyOutBoundLinkOnMainPage();
    }

    @Then("user should not see Outbound Link on homepage")
    public void user_should_not_see_outbound_link_on_homepage() {
        outBoundPage.verifyOutBoundLink();
    }

    @When("user add the regular page under Outbound link {string}")
    public void user_add_the_regular_page_under_outbound_link(String testCaseID) {
        TestData.readTestData(testCaseID, "OutBound");
        outBoundPage.navigateToMainPageUnderOutBound();
        outBoundPage.createPage();
        commonPageUtils.saveAndPublish();
    }

    @Then("regular page should be added under Outbound link")
    public void regular_page_should_be_added_under_outbound_link() {
        outBoundPage.verifyOutBoundCreated();
    }

    @When("user navigate to created outbound link")
    public void user_navigate_to_created_outbound_link() {
        outBoundPage.navigateToMainPageUnderOutBound();
    }


    @When("user create a new outbound link under Outbound Link {string}")
    public void user_create_a_new_outbound_link_under_outbound_link(String testCaseID) {
        TestData.readTestData(testCaseID, "OutBound");
        outBoundPage.createOutBoundLink();
        commonPageUtils.saveAndPublish();
    }

    @When("user create a new outbound link under Outbound Link without any details")
    public void user_create_a_new_outbound_link_under_outbound_link_without_any_details() {
        outBoundPage.navigateToOutBoundPage();
        outBoundPage.navigateToOutBoundLinkPage();
        commonPageUtils.clickSaveAndPublish();
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String message) {
        outBoundPage.validateErrorMessage(message);
    }

    @When("user add outbound link without http to the regular page {string}")
    public void user_add_outbound_link_without_http_to_the_regular_page(String testcaseID) {
        TestData.readTestData(testcaseID,"OutBound");
        outBoundPage.createNewOutboundLink();
        commonPageUtils.saveAndPublish();
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        commonPageUtils.clickCancelButton();
        outBoundPage.validateOutBoundErrorMessage(TestData.getData("Error Message"));
    }

    @When("user edited outbound link to the regular page {string}")
    public void user_edited_outbound_link_to_the_regular_page(String testcaseID) {
        TestData.readTestData(testcaseID,"OutBound");
        outBoundPage.selectExistingOutBound();
        outBoundPage.enterOutBoundDetails();
        commonPageUtils.saveAndPublish();
    }

    @When("user delete the existing outbound link to the regular page")
    public void user_delete_the_existing_outbound_link_to_the_regular_page() {
        outBoundPage.navigateToMainPageUnderOutBound();
        outBoundPage.deleteOutBoundLink();
    }

    @Then("outbound link should not be added")
    public void outbound_link_should_not_be_added() {
        outBoundPage.verifyOutBoundDeleted();
    }

    @When("user navigate to sub nav page")
    public void user_navigate_to_sub_nav_page() {
      contentMainPage.expandSubNavContent();
    }

    @When("user add outbound link to the subnav page {string}")
    public void user_add_outbound_link_to_the_subnav_page(String testcaseID) {
        TestData.readTestData(testcaseID,"OutBound");
        outBoundPage.navigateToOutBoundPageUnderSubNav();
        outBoundPage.createOutBoundLink();
        commonPageUtils.saveAndPublish();
    }


    @Then("user launch the outbound front end page")
    public void user_launch_the_outbound_front_end_page() {
        methods.openAndSwitchNewTab();
        loginPage.launchFrontEndApplication_OutBound();
        commonPageUtils.dismissAlerts();
    }

    @Then("outbound link should be displayed in front end page")
    public void outbound_link_should_be_displayed_in_front_end_page() {
        if(TestData.getData("Open New Tab")!=null && TestData.getData("Open New Tab").equalsIgnoreCase("No")){
            frontEndPage.validateOutBoundLinkinCurrentTab();
        }else{
            frontEndPage.validateOutBoundLinkinNewTab();
        }
    }

    @Then("outbound link should be displayed under sub Nav page")
    public void outbound_link_should_be_displayed_under_sub_Nav_page() {
            frontEndPage.validateOutBoundLinkinNewTabUnderSubnav();
    }
}
