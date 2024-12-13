package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.mediaManagerBackoffice.pages.MediaManagerBackOfficePage;
import org.govstack.pom.cms.utils.CommonPageUtils;
public class StepDefinitions_MediaManagerBackoffice {

    MediaManagerBackOfficePage mediaManagerBackOfficePg = new MediaManagerBackOfficePage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    @When("Go to Content Home and navigate to media manager")
    public void Go_to_Content_Home_and_navigate_to_media_manager() {
        mediaManagerBackOfficePg.selectHomeContent();
    }
    @When("user click categories")
    public void user_click_categories() {
        mediaManagerBackOfficePg.mediaManagerCategoriesMenu();
    }
    @Then("click create media category")
    public void click_create_media_category() {
        mediaManagerBackOfficePg.mediaManagerCreateCategoryBtn();
    }
    @Then("click create media page blank option")
    public void click_create_media_page_blank_option() {
        mediaManagerBackOfficePg.mediaManagerMediaPageBlankBtn();
    }
    @Then("enter input category name {string}")
    public void enter_input_category_name(String testCaseID) {
        TestData.readTestData(testCaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.mediaManagerCreateCategoryField();
    }
    @Then("enter input template builder name {string}")
    public void enter_input_template_builder_name(String testCaseID) {
        TestData.readTestData(testCaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.mediaManagerCreateTemplateBuilderField();
    }
    @Then("update and enter input template builder name {string}")
    public void update_and_enter_input_template_builder_name(String testCaseID) {
        TestData.readTestData(testCaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.mediaManagerUpdateTemplateBuilderField();
    }
    @When("user click save and publish")
    public void user_click_save_and_publish() {
        commonPageUtils.saveAndPublish();
    }
    @Then("verify created category is visible inside categories folder")
    public void verify_created_category_is_visible_inside_categories_folder() {
        mediaManagerBackOfficePg.verifyPublishCategories();
    }
    @Then("verify created template builder is visible inside categories folder")
    public void verify_created_template_builder_is_visible_inside_categories_folder() {
        mediaManagerBackOfficePg.verifyPublishTemplateBuilder();
    }
    @Then("verify created category is visible inside text fields folder")
    public void verify_created_category_is_visible_inside_text_fields_folder() {
        mediaManagerBackOfficePg.verifyPublishTextField();
    }
    @When("User selects the category")
    public void user_selects_the_category() {
        System.out.println("Test");
    }
    @When("user unPublish the published category")
    public void user_un_publish_the_published_category() {
        mediaManagerBackOfficePg.unPublishCategory();
        mediaManagerBackOfficePg.verifyUnPublishCategory();
    }
    @When("user unPublish the published template builder")
    public void user_un_publish_the_published_template_builder() {
        mediaManagerBackOfficePg.mediaManagerCommonGridIcon();
        mediaManagerBackOfficePg.unPublishCategory();
        mediaManagerBackOfficePg.verifyUnPublishTemplateBuilder();
    }
    @When("user unPublish the published meta informations")
    public void user_un_publish_the_published_meta_informations() {
        mediaManagerBackOfficePg.unPublishCategory();
        mediaManagerBackOfficePg.verifyUnPublishMetaInformation();
    }
    @When("user selects existing category and delete category")
    public void user_selects_existing_category_and_delete_category() {
        mediaManagerBackOfficePg.deletedCategory();
    }
    @When("user selects existing template builder and delete template builder")
    public void user_selects_existing_template_builder_and_delete_template_builder() {
        mediaManagerBackOfficePg.mediaManagerCommonGridIcon();
        mediaManagerBackOfficePg.deletedCategory();
    }
    @When("deleted category should be displayed in recycle bin")
    public void deleted_category_should_be_displayed_in_recycle_bin() {
        mediaManagerBackOfficePg.checkDeletedCategoryInRecycleBin();
    }
    @When("deleted meta information should be displayed in recycle bin")
    public void deleted_meta_information_should_be_displayed_in_recycle_bin() {
        mediaManagerBackOfficePg.checkDeletedMetaInformationInRecycleBin();
    }
    @When("user expand meta information")
    public void user_expand_meta_information() {
        mediaManagerBackOfficePg.mediaManagerExpandMetaInfo();
    }
    @When("click text field menu {string}")
    public void click_text_field_menu(String testCaseID) {
        TestData.readTestData(testCaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.mediaManagerTextFieldMenuLink();
    }
    @When("user update the meta informations details {string}")
    public void user_update_the_meta_informations_details(String testcaseID) {
        TestData.readTestData(testcaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.updateMetaInformations();
        //commonPageUtils.saveAndPublish();
        //alertPage.verifyAlert();
    }
    @When("user update the template builder details {string}")
    public void user_update_the_template_builder_details(String testcaseID) {
        TestData.readTestData(testcaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.mediaManagerCommonGridIcon();
        mediaManagerBackOfficePg.updateTemplateBuilder();
        //commonPageUtils.saveAndPublish();
        //alertPage.verifyAlert();
    }
    @Then("verify invalid record search and validate the validation message {string}")
    public void verify_invalid_record_search_and_validate_the_validation_message(String testcaseID) {
        TestData.readTestData(testcaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.verifyInvalidSearchAssertion();
    }
    @When("user expand media pages")
    public void user_expand_media_pages() {
        mediaManagerBackOfficePg.mediaManagerExpandMediaPagesInfo();
    }
    @When("user expand template builder menu")
    public void user_expand_template_builder_menu() {
        mediaManagerBackOfficePg.mediaManagerTemplateBuilderPagesInfo();
    }
    @When("click automation subfolder of media pages")
    public void click_automation_subfolder_of_media_pages() {
        mediaManagerBackOfficePg.mediaManagerMediaPagesSubfolderMenu();
    }
    @When("click sample templates of template builder")
    public void click_sample_templates_of_template_builder() {
        mediaManagerBackOfficePg.mediaManagerTempBldSampleTempMenu();
    }
    @Then("verify search with heading subheading and textfield {string}")
    public void verify_search_with_heading_subheading_and_textfield(String testcaseID) {
        TestData.readTestData(testcaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.verifyMediaPagesValidSearchAssertion();
    }
    @When("select list view icon")
    public void select_list_view_icon() {
        mediaManagerBackOfficePg.mediaManagerCommonListIcon();
    }
    @Then("verify name status lastEdited and created by column visible")
    public void verify_name_status_last_edited_and_created_by_column_visible() {
        mediaManagerBackOfficePg.mediaManagerCommonTableListAssertion();
    }
    @When("select any item from list")
    public void select_any_item_from_list() {
        mediaManagerBackOfficePg.mediaManagerRowSelection();
    }
    @When("user click copy uncheck relate to original toggle and select media page subfolder")
    public void user_click_copy_uncheck_relate_to_original_toggle_and_select_media_page_subfolder() {
        mediaManagerBackOfficePg.mediaManagerRowCopy();
    }

    //Media Manager Pages TC Meta Information Fields step definitions
    @Then("select meta information field with type as link field")
    public void select_meta_information_field_with_type_as_link_field() {
        mediaManagerBackOfficePg.mediaManagerMetaInformationLinkFieldCard();
    }
    @Then("select meta information field with type as date time field")
    public void select_meta_information_field_with_type_as_date_time_field() {
        mediaManagerBackOfficePg.mediaManagerMetaInformationDateWithTimeFieldCard();
    }
    @Then("select meta information type as amedned by")
    public void select_meta_information_type_as_amedned_by() {
        mediaManagerBackOfficePg.mediaManagerMetaInformationLinkTypeList();
    }
    @Then("select meta information type as meeting date")
    public void select_meta_information_type_as_meeting_date() {
        mediaManagerBackOfficePg.mediaManagerMetaInformationMeetingDateList();
    }
    @Then("add link field type value and click submit button {string}")
    public void add_link_field_type_value_and_click_submit_button(String testcaseID) {
        TestData.readTestData(testcaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.mediaManagerMetaInformationLinkValue();
    }
    @Then("select meeting date from calendar")
    public void select_meeting_date_from_calendar() {
        mediaManagerBackOfficePg.mediaManagerMetaInformationMeetingDateSelect();
    }
    @When("user click info icon")
    public void user_click_info_icon() {
        mediaManagerBackOfficePg.mediaManagerMetaInformationInfoIcon();
    }
    @Then("verify values are successfully added and working on frontend")
    public void verify_values_are_successfully_added_and_working_on_frontend() {
        mediaManagerBackOfficePg.mediaManagerMetaInformationLinkFieldValidation();
    }

    /*
  Media Manager Pages AT Meta Information Fields Date Field pending test cases started here
  STEP DEFINITIONS TEST CASES ID COVERED : TC_DF_9,TC_DF_10,TC_DF_11,TC_DF_12
  NOTE: FROM TC_DF_1 TO TC_DF_8 SAI KUMAR WORKED ON HIS PR
  */
    @Then("select meta information field with type as date field")
    public void select_meta_information_field_with_type_as_date_field() {
        mediaManagerBackOfficePg.mediaManagerMetaInformationDateFieldCard();
    }
    @Then("select meta information type as issue date {string}")
    public void select_meta_information_type_as_issue_date(String testcaseID) {
        TestData.readTestData(testcaseID, "Media Manager Backoffice");
        mediaManagerBackOfficePg.mediaManagerMetaInformationDateFieldListType();
    }

}
