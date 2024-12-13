package org.govstack.stepdefinition.pf;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.pf.pfactivities.pages.PFActivityPages;

public class StepDefinitions_PF_Activities {
    PFActivityPages activityPages = new PFActivityPages();

    @When("user Go to PF Activities tab")
    public void user_go_to_pf_activities_tab() {
        activityPages.clickActivity();
    }

    @When("user add the activity {string}")
    public void user_add_the_activity(String testCaseId) {
        TestData.readTestData(testCaseId, "PF_Activities");
        activityPages.clickAddButton();
        activityPages.pfCreateActivity();
    }

    @Then("Activity should be added")
    public void activity_should_be_added() {
        activityPages.validateActivityCreated();
    }

    @When("user search for the activity")
    public void user_search_for_the_activity() {
        activityPages.searchActivity();
    }

    @Then("Activity should be displayed")
    public void activity_should_be_displayed() {
        activityPages.validateActivityCreated();
    }

    @When("user update the activity {string}")
    public void user_update_the_activity(String testCaseId) {
        TestData.readTestData(testCaseId, "PF_Activities");
        activityPages.editActivity();
        activityPages.pfCreateActivity();
    }

    @Then("Activity should be updated")
    public void activity_should_be_updated() {
        activityPages.validateActivityCreated();
    }

    @When("user delete the activity")
    public void user_delete_the_activity() {
        activityPages.deleteActivity();
    }

    @Then("Activity should be deleted")
    public void activity_should_be_deleted() {
        activityPages.validateActivityDeleted();
    }

    @When("user is able to activities and Activity table is automatically sorted by Name column")
    public void user_is_able_to_activities_and_activity_table_is_automatically_sorted_by_name_column() {
        TestData.readTestData("RG_PF_ACT_01", "PF_Activities");
        activityPages.validateTitleAndSortWithName();
    }

    @When("user sort with active then activities should be sorted with active")
    public void user_sort_with_active_then_activities_should_be_sorted_with_active() {
        activityPages.validateActiveFilter();
    }

    @When("user sort with System Default then activities should be sorted with System Default")
    public void user_sort_with_system_default_then_activities_should_be_sorted_with_system_default() {
        activityPages.validateSystemDefaultFilter();
    }

    @When("user sort with count then activities should be sorted with count")
    public void user_sort_with_count_then_activities_should_be_sorted_with_count() {
        activityPages.validateCountFilter();
    }

    @Then("user should be able to activate or deactivate")
    public void user_should_be_able_to_activate_deactivate() {
        activityPages.validateActivateDeactivate();
    }
}
