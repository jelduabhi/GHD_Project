package org.govstack.stepdefinition.pf;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.pf.pfLocationType.pages.PFLocationTypePage;
import org.govstack.pom.pf.pfactivities.pages.PFActivityPages;

public class StepDefinitions_PF_LocationType {

    PFLocationTypePage pfLocationTypePg = new PFLocationTypePage();
    PFActivityPages activityPages=new PFActivityPages();

    @When("user Go to Location Type tab")
    public void user_go_to_Location_Type_tab() {
        pfLocationTypePg.pfLocationsTypeTab();
    }

    @When("user is able to validate and location type table is automatically sorted by Name column")
    public void user_is_able_to_activities_and_activity_table_is_automatically_sorted_by_name_column() {
        TestData.readTestData("RG_PF_LOC_01", "PF_LocationType");
        activityPages.validateTitleAndSortWithName();
    }

    @Then("create location type for park and facilities and click save button {string}")
    public void create_location_type_for_park_and_facilities_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "PF_LocationType");
        pfLocationTypePg.pfCreateLocationType();
    }

    @Then("verify location type is created under park and facilities list")
    public void verify_location_type_is_created_under_park_and_facilities_list() {
        pfLocationTypePg.pfLocationTypeSearchAssertion();
    }

    @Then("click delete button for location type park and facilities")
    public void click_delete_button_for_location_type_park_and_facilities() {
        pfLocationTypePg.pfLocationTypeDeleteBtn();
    }
    @Then("verify location type is deleted for park and facilities")
    public void verify_location_type_is_deleted_for_park_and_facilities() {
        pfLocationTypePg.pfLocationTypeDeleteAssertion();
    }

    @Then("edit location type of park and facilities and click save button {string}")
    public void edit_location_type_of_park_and_facilities_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "PF_LocationType");
        pfLocationTypePg.pfLocationTypeEditFeatures();
    }

    @Then("verify location type is edited under park and facilities list")
    public void verify_location_type_is_edited_under_park_and_facilities_list() {
        pfLocationTypePg.pfLocationTypeEditSearchAssertion();
    }

}