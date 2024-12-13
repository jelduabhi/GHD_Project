package org.govstack.stepdefinition.pf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.govstack.framework.TestData;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.pf.pffeatures.pages.PFFeaturesPage;

public class StepDefinitons_PF_Features {
    LoginPage loginPage = new LoginPage();
    PFFeaturesPage pfFeaturePg = new PFFeaturesPage();

    @Given("Launch and login Park and Facilities Back Office")
    public void Launch_and_login_Park_and_Facilities_Back_Office() {
        loginPage.loginToGovStack_BackOffice();
        loginPage.Park_Facilities_CMSApplication();
    }

    @Then("create features for park and facilities and click save button {string}")
    public void create_features_for_park_and_facilities_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "PF_Features");
        pfFeaturePg.pfCreateFeatures();
    }

    @Then("click delete button for park and facilities")
    public void click_delete_button_for_park_and_facilities() {
        pfFeaturePg.pfDeleteBtn();
    }
    @Then("verify features is deleted for park and facilities")
    public void verify_features_is_deleted_for_park_and_facilities() {
        pfFeaturePg.pfFeaturesDeleteAssertion();
    }

    @Then("verify features is created under park and facilities list")
    public void verify_features_is_created_under_park_and_facilities_list() {
        pfFeaturePg.pfFeaturesSearchAssertion();
    }

    @Then("edit features of park and facilities and click save button {string}")
    public void edit_features_of_park_and_facilities_and_click_save_button(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Features");
        pfFeaturePg.pfEditFeatures();
    }

    @Then("verify features is edited under park and facilities list")
    public void verify_features_is_edited_under_park_and_facilities_list() {
        pfFeaturePg.pfFeaturesEditSearchAssertion();
    }

}
