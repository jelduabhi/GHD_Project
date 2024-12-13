package org.govstack.stepdefinition.bd;

import io.cucumber.java.en.Then;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdListNaics.pages.BDListingNaicsPage;

public class StepDefinitions_BD_Listing_Naics {

    BDListingNaicsPage BdListingNaicsPg = new BDListingNaicsPage();

    @Then("click add business")
    public void click_add_business() {
        BdListingNaicsPg.bdAddBusinessButton();
    }

    @Then("verify general tab is open by default")
    public void verify_general_tab_is_open_by_default() {
        BdListingNaicsPg.generalTabValidation();
    }

    @Then("on NAICS code enter the code {string}")
    public void on_naics_code_enter_the_code(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Listing_Naics");
        BdListingNaicsPg.naicsCodeAdd();
    }

    @Then("click NAICS look up button")
    public void click_naics_look_up_button() {
        BdListingNaicsPg.bdNaicsLookupButton();
    }

    @Then("verify NAICS look up window is open")
    public void verify_naics_look_up_window_is_open() {
        BdListingNaicsPg.naicsLookupWindowValidation();
    }

    @Then("verify NAICS look up window should have search bar and table column NAICS_code,Industry_title and Copycode is visible")
    public void verify_naics_look_up_window_should_have_search_bar_and_table_column_naics_code_industry_title_and_copycode_is_visible() {
        BdListingNaicsPg.naicsLookupWindowContentValidation();
    }

    @Then("Search the NAISC code by code or title {string}")
    public void search_the_naisc_code_by_code_or_title(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Listing_Naics");
        BdListingNaicsPg.searchNaicscode();
    }

    @Then("verify that user able to expand and collapse NAICS list grid")
    public void verify_that_user_able_to_expand_and_collapse_naics_list_grid() {
        BdListingNaicsPg.bdNaicsExpandCollapseValidation();
    }

    @Then("click copy icon")
    public void click_copy_icon() {
        BdListingNaicsPg.naicsCopiedcode();
    }
    @Then("paste the copied code in NAICS text field")
    public void paste_the_copied_code_in_naics_text_field() {
        BdListingNaicsPg.naicsCodepaste();
    }

    @Then("on NAICS code enter the code with invalid code or special character negative use case {string}")
    public void on_naics_code_enter_the_code_with_invalid_code_or_special_character_negative_use_case(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Listing_Naics");
        BdListingNaicsPg.naicsInvalidCodeAddValidation();
    }
    @Then("verify return to listing button is visible")
    public void verify_return_to_listing_button_is_visible() {
        BdListingNaicsPg.returnToListingTabValidation();
    }

    @Then("search listing from grid {string}")
    public void search_listing_from_grid(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Listing_Naics");
        BdListingNaicsPg.ListingSearch();
    }

    @Then("do any edit like typing additional character on the name {string}")
    public void do_any_edit_like_typing_additional_character_on_the_name(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Listing_Naics");
        BdListingNaicsPg.editableNameFieldBd();
    }

    @Then("click return listing button")
    public void click_return_listing_button() {
        BdListingNaicsPg.listingTabClick();

    }
    @Then("verify notification message will appear with an option of keep editing or go to listings")
    public void verify_notification_message_will_appear_with_an_option_of_keep_editing_or_go_to_listings() {
        BdListingNaicsPg.unsavedPopupvalidation();
    }

    @Then("click go to listing")
    public void click_go_to_listing() {
        BdListingNaicsPg.goBackListingModalBtn();
    }

    @Then("verify user is on grid listing")
    public void verify_user_is_on_grid_listing() {
        BdListingNaicsPg.listingTabValidation();
    }

    @Then("click keep editing button and save")
    public void click_keep_editing_button_and_save() {
        BdListingNaicsPg.goKeepEditingListingModalBtn();
    }

    @Then("verify bd listing is deleted from grid")
    public void verify_bd_listing_is_deleted_from_grid() {
        BdListingNaicsPg.bdListingDeleteAssertion();
    }
}
