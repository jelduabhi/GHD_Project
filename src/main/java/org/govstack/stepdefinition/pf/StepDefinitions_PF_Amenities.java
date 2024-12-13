package org.govstack.stepdefinition.pf;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.pf.pfactivities.pages.PFActivityPages;
import org.govstack.pom.pf.pfaminities.pages.PFAmenitiesPage;

public class StepDefinitions_PF_Amenities {

    PFAmenitiesPage pfAmenitiespg = new PFAmenitiesPage();
    PFActivityPages activityPages=new PFActivityPages();

    @Then("create amenities for park and facilities and click save button {string}")
    public void create_amenities_for_park_and_facilities_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "PF_Amenities");
        pfAmenitiespg.pfCreateAmenities();
    }

    @Then("verify amenities is created under park and facilities list")
    public void verify_amenities_is_created_under_park_and_facilities_list() {
        pfAmenitiespg.pfAmenitiesSearchAssertion();
    }

    @Then("click delete button for amenities park and facilities")
    public void click_delete_button_for_amenities_park_and_facilities() {
        pfAmenitiespg.pfAmenitiesDeleteBtn();
    }
    @Then("verify amenities is deleted for park and facilities")
    public void verify_amenities_is_deleted_for_park_and_facilities() {
        pfAmenitiespg.pfAmenitiesDeleteAssertion();
    }

    @Then("edit amenities of park and facilities and click save button {string}")
    public void edit_amenities_of_park_and_facilities_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "PF_Amenities");
        pfAmenitiespg.pfAmenitiesEditFeatures();
    }

    @Then("verify amenities is edited under park and facilities list")
    public void verify_amenities_is_edited_under_park_and_facilities_list() {
        pfAmenitiespg.pfAmenitiesEditSearchAssertion();
    }

    //Facility Type
    @When("user Go to Facility type tab")
    public void user_go_to_Facility_type_tab() {
        pfAmenitiespg.pfFacilityTypeTab();
    }

    @When("user is able to validate Facility table and it is automatically sorted by Name column")
    public void user_is_able_to_activities_and_activity_table_is_automatically_sorted_by_name_column() {
        TestData.readTestData("RG_PF_FAC_01", "PF_FacilityType");
        activityPages.validateTitleAndSortWithName();
    }

    @Then("search the facility type and verify search should work {string}")
    public void search_the_facility_type_and_verify_search_should_work(String testcaseID) {
        TestData.readTestData(testcaseID, "PF_FacilityType");
        pfAmenitiespg.pfFacilityTypeSearchAssertion();
    }

}
