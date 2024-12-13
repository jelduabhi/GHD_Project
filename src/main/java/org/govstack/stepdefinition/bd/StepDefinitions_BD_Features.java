package org.govstack.stepdefinition.bd;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdFeatures.pages.BDFeaturesPage;
import org.govstack.pom.pf.pfactivities.pages.PFActivityPages;

public class StepDefinitions_BD_Features {

    BDFeaturesPage bdFeaturePg = new BDFeaturesPage();
    PFActivityPages activityPages=new PFActivityPages();

    @When("user Go to Features tab")
    public void user_go_to_features_tab() {
        bdFeaturePg.bdFeaturesTab();
    }

    @When("user is able to validate and feature table is automatically sorted by Name column")
    public void user_is_able_to_activities_and_activity_table_is_automatically_sorted_by_name_column() {
        TestData.readTestData("RG_PF_FT_01", "PF_Features");
        activityPages.validateTitleAndSortWithName();
    }

    @Then("create features and click save button {string}")
    public void create_features_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Features");
        bdFeaturePg.bdCreateFeatures();
    }

    @Then("verify features is created")
    public void verify_features_is_created() {
        bdFeaturePg.bdFeaturesSearchAssertion();
    }

    @Then("verify features is deleted")
    public void verify_features_is_deleted() {
        bdFeaturePg.bdFeaturesDeleteAssertion();
    }

    @Then("select the status of features column {string}")
    public void select_the_status_of_features_column(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Features");
        bdFeaturePg.bdSelectFeaturesStatusFilter();
    }

    @Then("search features with non existing record {string}")
    public void search_features_with_non_existing_record(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Features");
        bdFeaturePg.bdFeatureSearch();
    }

    @Then("click add features button from grid")
    public void click_add_features_button_from_grid() {
        bdFeaturePg.bdAddFeaturesGridBtn();
    }

    @Then("edit features and click save button {string}")
    public void edit_features_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Features");
        bdFeaturePg.bdEditFeatures();
    }

    @Then("verify features is edited")
    public void verify_features_is_edited() {
        bdFeaturePg.bdFeaturesEditSearchAssertion();
    }
}