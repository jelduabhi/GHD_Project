package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.cms.pageLayout.pages.PageLayoutPage;


public class StepDefinitions_PageLayout {
    ContentMainPage contentMainPage = new ContentMainPage();
    PageLayoutPage pageLayoutPg = new PageLayoutPage();

    @When("Go to Content Home and Navigate to Blog page")
    public void go_to_content_home_and_navigate_to_blog_page() {
        contentMainPage.selectBlogContent();
    }

    @When("Go to Content Home and Navigate to News Main page")
    public void go_to_content_home_and_navigate_to_news_main_page() {
        contentMainPage.newsMainPage();
    }

    @When("Go to main home page")
    public void go_to_main_home_page() {
        contentMainPage.mainHomePage();
    }

    @When("Go to Content Home and Navigate to Parsers Main page")
    public void go_to_content_home_and_navigate_to_parsers_main_page() {
        contentMainPage.parserMainPage();
    }

    @When("Go to Content Home and Navigate to subscribe Main page")
    public void go_to_content_home_and_navigate_to_subscribe_main_page() {
        contentMainPage.subscribeMainPage();
    }

    @When("Go to Content Home and Navigate to subscribe and click confirm page")
    public void go_to_content_home_and_navigate_to_subscribe_and_click_confirm_page() {
        contentMainPage.subscribeConfirmPage();
    }

    @When("Go to Content Home and Navigate to subscribe and click unsubscribe page")
    public void go_to_content_home_and_navigate_to_subscribe_and_click_unsubscribe_page() {
        contentMainPage.subscribeUnSubscribePage();
    }

    @When("Go to Content Home and Navigate to page layout automation page")
    public void go_to_content_home_and_navigate_to_page_layout_automation_page() {
        contentMainPage.pageLayoutAutomationMainPage();
    }

    @Then("Verify CENTER \\(NAV LEFT) and CENTER \\(NAV RIGHT) option not visible")
    public void verify_center_nav_left_and_center_nav_right_option_not_visible() {
        pageLayoutPg.contentTab();
    }

}
