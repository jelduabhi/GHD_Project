package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.redirect.pages.redirectPage;

public class StepDefinitions_Redirect {

    redirectPage redirectPg = new redirectPage();

    @When("go to redirect tab")
    public void go_to_redirect_tab() {
        redirectPg.govstackRedirectTab();
    }

    @Then("verify redirect screen is visible")
    public void verify_redirect_screen_is_visible() {
        redirectPg.redirectHeaderAssertion();
    }

    @Then("click add new redirect button")
    public void click_add_new_redirect_button() {
        redirectPg.redirectButton();
    }

    @Then("type original url and select destination url {string}")
    public void type_original_url_and_select_destination_url(String testcaseID) {
        TestData.readTestData(testcaseID, "Redirect");
        redirectPg.enterOrignalUrl();
    }

    @Then("type original url and select destination url with temporay redirect optin {string}")
    public void type_original_url_and_select_destination_url_with_temporay_redirect_optin(String testcaseID) {
        TestData.readTestData(testcaseID, "Redirect");
        redirectPg.advanceOptionSelect();
    }

    @Then("type original url and select media file {string}")
    public void type_original_url_and_select_media_file(String testcaseID) {
        TestData.readTestData(testcaseID, "Redirect");
        redirectPg.enterMediaUrl();
    }


    @Then("verify should be able to see Redirects are configurable")
    public void verify_should_be_able_to_see_redirects_are_configurable() {
        redirectPg.redirectSearchAssertion();
    }

    @When("user click orignal url from list")
    public void user_click_orignal_url_from_list() {
        redirectPg.orginalUrlClickList();
    }

    @Then("verify configured redirects are working as expected and directing to the intended pages")
    public void verify_configured_redirects_are_working_as_expected_and_directing_to_the_intended_pages() {
        redirectPg.originalUrlRedirectAssertion();
    }

    @Then("verify redirect pointing to an existing media file works as expected")
    public void verify_redirect_pointing_to_an_existing_media_file_works_as_expected() {
        redirectPg.mediaUrlRedirectAssertion();
    }


}
