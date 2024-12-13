package org.govstack.stepdefinition.cms;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.alerts.pages.AlertPage;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.cms.news.pages.*;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;

public class StepDefinitions_News {

    NewsPage newsPage = new NewsPage();
    ContentMainPage mainPage = new ContentMainPage();
    NewsFrontEndPage frontEndPage = new NewsFrontEndPage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    UpdatePost_Page updatePostPage = new UpdatePost_Page();
    DeleteNewsPage deletePage = new DeleteNewsPage();
    AlertPage alertPage = new AlertPage();
    NewsSearchPage newsPageFrontend = new NewsSearchPage();
    CommonMethods methods = new CommonMethods();

    @When("User selects the news")
    public void i_selects_the_news() {
        mainPage.selectTheContent();
    }

    @When("User enter all the details {string}")
    public void i_enter_all_the_details(String testCaseID) {
        TestData.readTestData(testCaseID, "News");
        newsPage.enterNewsDetails();
//        newsPage.enterNewsDetailsPentest();
    }

    @When("User update the content hide page title")
    public void user_update_the_content_hide_page_title() {
        newsPage.updateContent();
    }

    @And("User should be able to publish the news")
    public void i_should_be_able_to_publish_the_news() {
        commonPageUtils.saveAndPublish();
        newsPage.verifyPublish();
    }

    @And("News should be posted to front end application")
    public void news_should_be_posted_to_front_end_application() {
        frontEndPage.validateNewsInFrontEnd();
    }

    @Then("News should be published to front end application")
    public void news_should_be_published_to_front_end_application() {
        frontEndPage.validateNewsPublished();
    }

    @Then("Page title and secondary heading should be hidden")
    public void page_title_and_secondary_heading_should_be_hidden() {
        frontEndPage.verifyPageTitleAndSecondaryHeading();
    }

    @When("Go to Content Home and Navigate to News Posts")
    public void go_to_Content_Home_and_Navigate_to_News_Posts() {
        mainPage.selectTheContent();
    }

    @And("update News Widgets in Setting")
    public void update_news_widgets_in_setting() {
        newsPage.updateSettings();
        commonPageUtils.saveAndPublish();
    }

    @Then("verify Widgets updated in front End")
    public void verify_widgets_updated_in_front_end() {
        frontEndPage.validateToggleInFrontEnd();
    }

    @When("user unPublish the published news")
    public void user_unPublish_the_published_news() {
        newsPage.unPublishNews();
        newsPage.verifyUnPublishNews();
    }

    @Then("News should not be posted to front end application")
    public void news_should_not_be_posted_to_front_end_application() {
        frontEndPage.validateNewsNotPublishedInFrontEnd();
    }

    @When("user publish the un published news")
    public void user_publish_the_published_news() {
        newsPage.publishUnpublishedNews();
        newsPage.verifyPublish();
    }

    @When("user preview the news")
    public void user_preview_the_news() {
        newsPage.selectExistingNews();
        commonPageUtils.clickSaveAndPreview();
    }

    @Then("Preview page should be displayed")
    public void preview_page_should_be_displayed() {
        methods.switchToWindow();
        methods.waitForElement(3);
        ExtentReporter.log(LogStatus.PASS,"");
    }

    //RG_NW_2.7
    @And("Navigate to Settings, update the following Post date leave as blank")
    public void navigateToSettingsUpdateTheFollowingPostDateLeaveAsBlank() {
        updatePostPage.updateBlankDate();
    }

    //RG_NW_3.2.7
    @Then("Verify “Validation: Validation errors must be fixed before the item can be saved” is returned")
    public void verifyValidationValidationErrorsMustBeFixedBeforeTheItemCanBeSavedIsReturned() {
        updatePostPage.validateRequiredHelplineError();
    }


    @Then("Verify Post date is a required field. Leaving is blank marked the field as “This property is invalid”")
    public void verifyPostDateIsARequiredFieldLeavingIsBlankMarkedTheFieldAsThisPropertyIsInvalid() {
        updatePostPage.validatePropertyInvalidError();
    }

    @When("User selects existing news")
    public void user_selects_existing_news() {
        newsPage.selectExistingNews();
    }

    @When("User selects news with blank post date")
    public void user_selects_news_with_blank_post_date() {
        newsPage.selectNewsWithBlankPostDate();
        commonPageUtils.clickSaveAndPublish();
    }

    @When("Verify Validation Errors")
    public void verify_validation_errors() {
//        TestData.readTestData(TestcaseID, "UpdatePost");
        updatePostPage.verifyPostDateRequired();
        updatePostPage.verifyPostDatePropertyInvalid();
        updatePostPage.verifyValidationErrors();
    }

    @When("User update the Settings and Summary details {string}")
    public void user_update_the_settings_and_summary_details(String testCaseID) {
        TestData.readTestData(testCaseID, "News");
        newsPage.updateNews();
    }

    //RG_NW_2.5
    @And("Navigate to Settings, update the following Post date Update to Future Date")
    public void navigateToSettingsUpdateTheFollowingPostDateUpdateToFutureDate() {
        updatePostPage.updateFutureDate();
    }

    //RG_NW_2.3
    @And("Navigate to Settings, update the following")
    public void navigate_to_settings_update_the_following() {
        updatePostPage.updatePostname();
        updatePostPage.updateCurrentDate();
        updatePostPage.removeCategory();
        updatePostPage.addCategory();
        updatePostPage.removeAuthor();
        updatePostPage.addAuthor();
    }

    @And("Navigate to Summary, update the following")
    public void navigate_to_summary_update_the_following() {
        updatePostPage.navigateSummary();
        updatePostPage.updateSummaryHeadings();
        updatePostPage.removeImg();
        updatePostPage.updateImage();

    }


    @And("Click Save and Publish")
    public void click_save_and_publish() {
        commonPageUtils.saveAndPublish();
    }


    @Then("Verify Updates made on post will reflect under Posts with updated information on the following")
    public void verify_updates_made_on_post_will_reflect_under_posts_with_updated_information_on_the_following() {
        updatePostPage.verifyPostStatus();
        updatePostPage.verifyLastEditedCurrentDate();
        updatePostPage.verifyCreatedby();
    }

    @Then("User delete the news")
    public void user_delete_the_news() {
        deletePage.deletedNews();
    }

    @Then("Verify all created Posts are listed.")
    public void verify_all_created_posts_are_listed() {
        deletePage.postListing();
    }

    @Then("Verify Create News Post button is available")
    public void verify_create_news_post_button_is_available() {
        deletePage.createNewsPostBtnAssertion();
    }

    @Then("Verify View Option button is available \\( Grid and List)")
    public void verify_view_option_button_is_available_grid_and_list() {
        deletePage.thumbnailIconVisibleAssertion();
    }

    @Then("Verify Search button is available.")
    public void verify_search_button_is_available() {
        deletePage.searchBtnVisibleAssertion();
    }

    @Then("Verify searching a keyword would return valid values.")
    public void verify_searching_a_keyword_would_return_valid_values() throws InterruptedException {
        deletePage.validSearchList();
        Thread.sleep(4000);
        deletePage.searchFieldText("Automation");
        Thread.sleep(4000);
        deletePage.listingResult();
    }

    @Then("News should be deleted")
    public void news_should_be_deleted() {
        alertPage.checkDeletedAlertInRecycleBin();
    }

    //Scenario 3: RG_NW_3.1 Verify setting page of news default field are available - Backend
    @When("I click on create post button")
    public void i_click_on_create_post_button() throws InterruptedException {
        Thread.sleep(4000);
        deletePage.createPostButton();
//        deletePage.createPostButtonPentest();
    }

    //Scenario 4: RG_NW_3.4 Verify summary page of news default fields are available - Backend
    @When("click on summary tab")
    public void click_on_summary_tab() throws InterruptedException {
        System.out.println("click_on_summary_tab");
        Thread.sleep(4000);
        deletePage.summaryTabNewsss();
    }

    @Then("verify following fields available on summary page ie Heading,Secondary Heading,Text,Image")
    public void verify_following_fields_available_on_summary_page_ie_heading_secondary_heading_text_image() {
        deletePage.summaryTabValidField();
    }

    @Then("Verify following fields available on Setting Page ie Post Title, Post Date, Categories,Author,Disable Comments,Send Subscriber Notification,Custom Message")
    public void verify_following_fields_available_on_setting_page_ie_post_title_post_date_categories_author_disable_comments_send_subscriber_notification_custom_message() {
        deletePage.newsDefaultSettingFieldsAssertion();
    }

    //RG_NW_3.8 Verify advance page of post default field are available

    //Scenario 5:RG_NW_3.5 Verify navigation page of post default fields are available
    @When("click on navigation tab")
    public void click_on_navigation_tab() {
        deletePage.navigationTab();
    }

    @Then("verify following fields available on navigation page ie Hide from all navigation, Hide from internal search, Hide breadcrumb, Breadcrumb link text")
    public void verify_following_fields_available_on_navigation_page_ie_hide_from_all_navigation_hide_from_internal_search_hide_breadcrumb_breadcrumb_link_text() {
        deletePage.navigationTabValidField();
    }

    //RG_NW_3.6 Verify SEO and share page of post default field are available

    @When("I click on advanced tab")
    public void i_click_on_advanced_tab() {
        deletePage.advancedTab();
    }

    @Then("Verify following fields available on advanced page ie Hide website header,Hide website footer,Override design style,Override website logo,Override content,Custom page classes,Disable delete")
    public void verify_following_fields_available_on_advanced_page_ie_hide_website_header_hide_website_footer_override_design_style_override_website_logo_override_content_custom_page_classes_disable_delete() {
        deletePage.advancedTabValidField();
    }

    //RG_NW_3.7 Verify on script page default field are available

    @When("I click on seo and share tab")
    public void i_click_on_seo_and_share_tab() {
        deletePage.seoTab();
    }

    @Then("verify default field available in seo and share page.")
    public void verify_default_field_available_in_seo_and_share_page() {
        deletePage.seoTabValidField();
    }

    //RG_NW_4.3 Verify Items per page field is editable in news screen

    @When("I click on scripts tab")
    public void i_click_on_scripts_tab() {
        deletePage.scriptsTab();
    }

    @Then("verify default field are available")
    public void verify_default_field_are_available() {
        deletePage.scriptsTabValidField();
    }

    @When("I selects the custom new button")
    public void I_selects_the_custom_new_button() {
        deletePage.customNewsMenu();
    }

    @When("Update the following: Items per page")
    public void update_the_following_items_per_page() {
        deletePage.rowSelectionCustomNews();
    }


    //RG_NW_3.3 Verify on extra content page default field are available

    @When("Click save and publish button")
    public void click_save_and_publish_button() throws InterruptedException {
        Thread.sleep(4000);
        deletePage.requestPublishBtnIcon();
        Thread.sleep(4000);
        deletePage.savePublishBtn();
        Thread.sleep(4000);
        deletePage.savePublishPopupBtn();
    }

    @Then("Verify Content published message will be returned after Save and Publish.")
    public void verify_content_published_message_will_be_returned_after_save_and_publish() {
        System.out.println("Content published: English (United States) published and visible on the website");
    }

    @When("I click on extra content tab")
    public void i_click_on_extra_content_tab() {
        deletePage.extraContentTab();
    }

    @Then("verify default field are available in extra content page")
    public void verify_default_field_are_available_in_extra_content_page() {
        deletePage.extraContentTabValidFields();
    }


    @When("Try to Search and Filter News with no news within the selected date range, then it should display “No Articles were found”")
    public void try_to_search_and_filter_news_with_no_news_within_the_selected_date_range_then_it_should_display_no_articles_were_found() throws InterruptedException {
        newsPageFrontend.startDateSelectField();
        newsPageFrontend.endDateSelectField();
        newsPageFrontend.searchNewsButton();
        Thread.sleep(4000);
    }

    @Then("Check if not displaying the article")
    public void check_if_not_displaying_the_article() throws InterruptedException {
        Thread.sleep(4000);
        newsPageFrontend.noArticleFoundValidAssertion();
        Thread.sleep(3000);
    }

    //Scenario 2: RG_NW_5.3 Search and filtering criteria with  selected date range is greater than the today's date
    @When("Try to Search and Filter News with the selected date range is greater than the todays date, then then it should display “No Articles were found”")
    public void try_to_search_and_filter_news_with_the_selected_date_range_is_greater_than_the_todays_date_then_then_it_should_display_no_articles_were_found()  {
        newsPageFrontend.startDateSelectField();
        newsPageFrontend.endDateSelectField();
        newsPageFrontend.searchNewsButton();
    }

    //Scenario :3 RG_NW_5.1 News Search - search panel is located below all articles on mobile

    @When("Try to Search and Filter News")
    public void try_to_search_and_filter_news() {
        newsPageFrontend.newsInputFieldBox("Test Nona QA 418");
        newsPageFrontend.categorySelectionDropdown("Cat 1");
    }

    @When("Select Article date within the selected date")
    public void select_article_date_within_the_selected_date()  {
        newsPageFrontend.startDateSelectField();
        newsPageFrontend.endDateSelectField();
        newsPageFrontend.searchNewsButton();
    }

    @Then("Check if displaying the article")
    public void check_if_displaying_the_article() {
        newsPageFrontend.newsDisplayedAssertion();
    }

    //RG_NW_2.14 verify default field available in news form in frontend

    @Then("Verify following field available in news form ie Search field,Filter by news categories,start date, end date, search and clear button")
    public void verify_following_field_available_in_news_form_ie_search_field_filter_by_news_categories_start_date_end_date_search_and_clear_button() {
        newsPageFrontend.newsFormDefaultFieldValidation();
    }

    //RG_NW_2.19 verify on click clear button search criteria will be deleted

    @Then("Click clear button")
    public void click_clear_button() {
        newsPageFrontend.clearButtonNews();
    }

    @Then("Verify search criteria will be deleted and date field is in default current date")
    public void verify_search_criteria_will_be_deleted_and_date_field_is_in_default_current_date() throws InterruptedException {
        Thread.sleep(4000);
        newsPageFrontend.defaultNewsFieldValidation();

    }

    //RG_NW_2.22 verify subscribe button is visible on news section in frontend page
    @When("click on subscribe news button")
    public void click_on_subscribe_news_button() {
        newsPageFrontend.subscribeButtonNewsFrontend();
    }

    @Then("verify user will be navigate to subscribe news page")
    public void verify_user_will_be_navigate_to_subscribe_news_page() {
        newsPageFrontend.subscribePageValidation();
    }

    //RG_NW_2.20 Verify selected category list should be displayed in news

    @When("Select the news category")
    public void select_the_news_category() {
        newsPageFrontend.categorySelectionDropdown("Cat 1");
    }


    @And("On Posts, open the created post {string}")
    public void on_posts_open_the_created_post(String testCaseID) {
        TestData.readTestData(testCaseID, "UpdatePost");
    }

    //RG_NW_2.3
    @And("Navigate to Settings, update the following {string}")
    public void navigate_to_settings_update_the_following(String testCaseID) {
        TestData.readTestData(testCaseID, "UpdatePost");
        updatePostPage.updatePostname();
        updatePostPage.updateCurrentDate();
        updatePostPage.removeCategory();
        updatePostPage.addCategory();
        updatePostPage.removeAuthor();
        updatePostPage.addAuthor();
    }

    @And("Navigate to Summary, update the following {string}")
    public void navigate_to_summary_update_the_following(String testCaseID) {
        TestData.readTestData(testCaseID, "UpdatePost");
        updatePostPage.navigateSummary();
        updatePostPage.updateSummaryHeadings();
        updatePostPage.removeImg();
        updatePostPage.updateImage();

    }

//    @And("Click Save and Publish")
//    public void click_save_and_publish() {
//        updatePostPage.clickRequestPublishMenuButton();
//    }

    @And("Confirmation page will display, Ready to Publish? Click Save and publish button.")
    public void confirmation_page_will_display_ready_to_publish_click_save_and_publish_button() {
        updatePostPage.clickReadyToSaveAndPublish();
    }

    @Then("Verify Updates made on post will reflect under Posts with updated information on the following {string}")
    public void verify_updates_made_on_post_will_reflect_under_posts_with_updated_information_on_the_following(String testCaseID) {
        TestData.readTestData(testCaseID, "UpdatePost");
        updatePostPage.verifyPostStatus();
        updatePostPage.verifyLastEditedCurrentDate();
        updatePostPage.verifyCreatedby();
    }

    //RG_NW_2.5
    @And("Navigate to Settings, update the following Post date Update to Future Date {string}")
    public void navigateToSettingsUpdateTheFollowingPostDateUpdateToFutureDate(String testCaseID) {
        TestData.readTestData(testCaseID, "UpdatePost");
        updatePostPage.updateFutureDate();
    }

    //RG_NW_2.7
    @And("Navigate to Settings, update the following Post date leave as blank {string}")
    public void navigateToSettingsUpdateTheFollowingPostDateLeaveAsBlank(String testCaseID) {
        TestData.readTestData(testCaseID, "UpdatePost");
        updatePostPage.updateBlankDate();
    }

    //RG_NW_3.2.7
    @Then("Verify Validation errors must be fixed before the item can be saved” is returned")
    public void verifyValidationErrorsMustBeFixedBeforeTheItemCanBeSavedIsReturned() {
        updatePostPage.validateRequiredHelplineError();
    }

    //@RG_NW_3.2.7
    @And("Navigate to Content and Delete or Remove the values for  the following fields")
    public void navigateToContentAndDeleteRemoveTheValuesForTheFollowingFields() {
        newsPage.navigateContent();
        newsPage.deleteContentPageTitle();
        updatePostPage.deleteContentMainContent();
    }

    @Then("Verify the following content fields are now empty")
    public void verifyTheFollowingContentFieldsAreNowEmpty() {
        updatePostPage.verfiydeleteContentPageTitle();
        updatePostPage.verifydeleteContentSecondHeading();
        updatePostPage.verifydeleteContentMainContent();
    }

    //RG_NW_3.2.8
    @When("Navigate to News Listings Page")
    public void navigateToNewsListingsPage() {
        updatePostPage.navigateFENewsListingPage();
        updatePostPage.dismissAllAlertsOnFEPage();

    }

    @And("Navigate to All Post, select and open a News Post.")
    public void navigateToAllPostSelectAndOpenANewsPost() {
        updatePostPage.selectNewsPost();
    }

    @Then("Verify the following fields fields are  no longer available")
    public void verifyTheFollowingFieldsFieldsAreNoLongerAvailable() {
        updatePostPage.verifyNewsPostContentPageTitle();
        updatePostPage.verifyNewsPostContentH2();
        updatePostPage.verifyNewsPostContentGalleryImg();
    }
}
