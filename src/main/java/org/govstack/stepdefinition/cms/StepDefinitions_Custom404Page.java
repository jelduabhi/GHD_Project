package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.custom404.pages.Custom404Page;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.cms.news.pages.NewsFrontEndPage;
import org.govstack.pom.cms.utils.CommonPageUtils;


public class StepDefinitions_Custom404Page {

    ContentMainPage contentMainPage = new ContentMainPage();
    Custom404Page customPages = new Custom404Page();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    NewsFrontEndPage frontEndPage = new NewsFrontEndPage();

    @When("Go to Content Home and Navigate to page not found page")
    public void go_to_content_home_and_navigate_to_page_not_found_page() {
        contentMainPage.pageNotFoundContent();

    }

    @When("Create new page not found page {string}")
    public void create_new_page_not_found_page(String testcaseID) {
        TestData.readTestData(testcaseID, "CustomNotFound");
        customPages.enterDetails();

    }

    @When("User should be able to publish the page")
    public void user_should_be_able_to_publish_the_page() {
        commonPageUtils.saveAndPublish();
    }

    @When("User launch the page not found frond end url in new tab")
    public void user_launch_the_page_not_found_frond_end_url_in_new_tab() {
        frontEndPage.launchFrontEndInNewTab();
    }

    @Then("validate the page not found message")
    public void validate_the_page_not_found_message() {
        customPages.pageNotFoundFrontendValidation();

    }


}
