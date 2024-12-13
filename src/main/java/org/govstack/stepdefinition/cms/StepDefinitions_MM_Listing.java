package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.cms.mediamanager.pages.MediaManagerListingPage;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.utils.CommonMethods;

public class StepDefinitions_MM_Listing {
    MediaManagerListingPage mmListingPage = new MediaManagerListingPage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    CommonMethods methods = new CommonMethods();
    LoginPage loginPage = new LoginPage();
    ContentMainPage mainPage=new ContentMainPage();

    @When("Navigate to the Test Page {string}")
    public void navigate_to_the_test_page(String testCaseID) {
        TestData.readTestData(testCaseID, "MediaManager_Listing");
        mmListingPage.navigateToMMTestPage();
    }

    @And("Add Media Manager Content")
    public void add_media_manager_content() {
        mmListingPage.clickAddMainContent();
        mmListingPage.addMediaManagerContent();
        mmListingPage.setMMIntro();
        mmListingPage.addContentDetails();
        mmListingPage.setMMOutro();
        mmListingPage.clickCreateButton();
    }

    @And("Navigate to Extra Content Tab")
    public void navigate_to_extra_content_tab() {
        mmListingPage.navigateToExtraContentTab();
    }

    @And("Add Media Manager Content in Extra Content Tab")
    public void add_media_manager_content_in_extra_content() {
        mmListingPage.clickAddAboveMainContent();
        mmListingPage.addMediaManagerContent();
        mmListingPage.setMMIntro();
        mmListingPage.addExtraContentDetails();
        mmListingPage.setMMOutro();
        mmListingPage.clickCreateButton();
    }

    @And("Verify Extra Content in Front End")
    public void verify_extra_content_front_end() {
        mmListingPage.verifyExtraContentFrontEnd();
    }

    @And("Remove Media Manager Content in Extra Content Tab")
    public void remove_media_manager_content_in_extra_content() {
        mmListingPage.removeExtraContent();
    }

    @And("Navigate to Settings - Design and Layout")
    public void navigate_to_settings_design_layout() {
        mmListingPage.navigateToSettingsDesignAndLayout();
    }

    @And("Configure Design and Layout for Grid View")
    public void configure_design_layout_grid_view() {
        mmListingPage.configureDesignAndLayoutForGridView();
    }

    @Then("Remove Meta Info")
    public void remove_meta_info() {
        mmListingPage.removeMetaInfo();
    }

    @And("Select Table View as Presentation View")
    public void select_table_view_as_presentation_view() {
        mmListingPage.selectTableView();
    }

    @Then("Configure Table View Settings")
    public void configure_table_view_settings() {
        mmListingPage.configureTableViewSettings();
    }

    @When("Launch Media Manager front end application in new tab")
    public void launch_media_manager_front_end_application_in_new_tab() {
        methods.openAndSwitchNewTab();
        loginPage.launchFrontEndApplication_AutoMediaManager();
        commonPageUtils.dismissAllAlerts();
    }

    @And("Verify Table View configurations in Front End")
    public void verify_table_view_config_in_front_end() {
        mmListingPage.verifyTableViewConfigInFrontEnd();
    }

    @Given("Launch Media Manager front end application")
    public void launch_media_manager_front_end_application()  throws InterruptedException {
        loginPage.launchFrontEndApplication_AutoMediaManager();
        Thread.sleep(4000);
        commonPageUtils.dismissAllAlerts();
        Thread.sleep(4000);
    }

    @And("Test Filtering Options {string}")
    public void test_filtering_options(String testCaseID)  {
        TestData.readTestData(testCaseID, "MediaManager_Listing");
        mmListingPage.testFilterUsingKeyword();
        mmListingPage.testFilterUsingCategories();
        mmListingPage.testFilterUsingFileTypes();
        mmListingPage.testFilterUsingDateTypes();
        mmListingPage.testFilterCombination();
    }

    @Then("Test Media Listing Pagination")
    public void test_media_listing_pagination() {
        mmListingPage.testPagination();
    }

    @And("Test Download and View File {string}")
    public void test_download_view_file(String testCaseID) {
        TestData.readTestData(testCaseID, "MediaManager_Listing");
        mmListingPage.testDownloadFile();
        mmListingPage.testViewFile();
    }

    @Then("View Media Listing Details {string}")
    public void view_media_listing_details(String testCaseID) {
        TestData.readTestData(testCaseID, "MediaManager_Listing");
        mmListingPage.viewMediaListingContentDetails();
    }

    @When("Navigate to Categories")
    public void navigate_to_categories() {
        mainPage.navigateToMediaManagerCategories();
    }

    @And("Rename and unpublish a category {string}")
    public void rename_category(String testCaseID) {
        TestData.readTestData(testCaseID, "MediaManager_Listing");
        mmListingPage.renameCategory();
        commonPageUtils.saveAndPublish();
        mmListingPage.clickBackButton();
        mmListingPage.unpublishCategory();
    }

    @Then("Verify renamed and unpublished category in Front End")
    public void verify_renamed_unpublished_category_front_end() {
        mmListingPage.verifyRenamedCategory();
    }

    @And("Rename and publish a category {string}")
    public void rename_publish_category(String testCaseID) {
        TestData.readTestData(testCaseID, "MediaManager_Listing");
        mmListingPage.renameCategory();
        commonPageUtils.saveAndPublish();
        mmListingPage.clickBackButton();
        mmListingPage.publishCategory();
    }

    @When("Select MM Test Page")
    public void select_mm_test_page() {
        mmListingPage.selectMMTestPage();
    }

    @Then("Remove Media Manager Content")
    public void remove_media_manager_content() {
        mmListingPage.removeMediaManagerContent();
    }
}
