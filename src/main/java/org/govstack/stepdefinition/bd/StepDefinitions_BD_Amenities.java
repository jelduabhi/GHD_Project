package org.govstack.stepdefinition.bd;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdAmenities.pages.BDAmenitiesPage;
import org.govstack.pom.pf.pfactivities.pages.PFActivityPages;

public class StepDefinitions_BD_Amenities {
    BDAmenitiesPage bdAmenitiesPg = new BDAmenitiesPage();
    PFActivityPages activityPages=new PFActivityPages();

    @When("user Go to Amenities tab")
    public void user_go_to_amenities_tab() {
        bdAmenitiesPg.bdAmenitiesTab();
    }

    @When("user is able to validate and Amenities table is automatically sorted by Name column")
    public void user_is_able_to_activities_and_activity_table_is_automatically_sorted_by_name_column() {
        TestData.readTestData("RG_PF_AM_01", "PF_Amenities");
        activityPages.validateTitleAndSortWithName();
    }

    @Then("click add button")
    public void click_add_button() {
        bdAmenitiesPg.bdAmenitiesAddBtn();
    }

    @Then("create amenities and click save button {string}")
    public void create_amenities_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Amenities");
        bdAmenitiesPg.bdCreateAmenities();
    }

    @Then("verify amenities is created")
    public void verify_amenities_is_created() {
        bdAmenitiesPg.bdAmenitiesSearchAssertion();
    }

    @Then("verify amenities is edited")
    public void verify_amenities_is_edited() {
        bdAmenitiesPg.bdAmenitiesEditSearchAssertion();
    }

    @Then("search amenities with non existing record {string}")
    public void search_amenities_with_non_existing_record(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Amenities");
        bdAmenitiesPg.bdAmenitiesSearch();
    }

    @Then("click add amenties button from grid")
    public void click_add_amenties_button_from_grid() {
        bdAmenitiesPg.bdAddAmenitiesGridBtn();
    }

    @When("user click clear button")
    public void user_click_clear_button() {
        bdAmenitiesPg.bdAddAmenitiesClearGridBtn();
    }

    @Then("verify user should be able to a clear search using clear button from grid")
    public void verify_user_should_be_able_to_a_clear_search_using_clear_button_from_grid() {
        bdAmenitiesPg.bdAmenitiesListValidationAssertion();
    }

    @Then("click delete button")
    public void click_delete_button() {
        bdAmenitiesPg.bdDeleteAmenitiesBtn();
    }

    @Then("verify amenity is deleted")
    public void verify_amenity_is_deleted() {
        bdAmenitiesPg.bdAmenitiesDeleteAssertion();
    }

    @Then("click edit button")
    public void click_edit_button() {
        bdAmenitiesPg.bdAmenitiesEditBtn();

    }

    @Then("edit amenities and click save button")
    public void edit_amenities_and_click_save_button() {
        bdAmenitiesPg.bdEditAmenities();
    }

    @Then("on the page selector, click the three dots")
    public void on_the_page_selector_click_the_three_dots() {
        bdAmenitiesPg.bdAmenitiesThreeDots();
    }

    @Then("on the displayed numbers for page selector click any available number")
    public void on_the_displayed_numbers_for_page_selector_click_any_available_number() {
        bdAmenitiesPg.bdAmenitiesPageClick();
    }

    @Then("go to active filter and click funnel icon")
    public void go_to_active_filter_and_click_funnel_icon() {
        bdAmenitiesPg.bdAmenitiesFunnelIcon();

    }

    @Then("select the status {string}")
    public void select_the_status(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Amenities");
        bdAmenitiesPg.bdSelectStatusFilter();

    }

    @Then("verify status set by user")
    public void verify_status_set_by_user() {
        bdAmenitiesPg.bdAmenitiesStatusFilterAssertion();
    }

}