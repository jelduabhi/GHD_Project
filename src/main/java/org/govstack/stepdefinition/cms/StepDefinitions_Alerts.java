package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.alerts.pages.AlertFrontEndPage;
import org.govstack.pom.cms.alerts.pages.AlertPage;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;

import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;


public class StepDefinitions_Alerts {
    public static String alertType;
    ContentMainPage contentMainPage = new ContentMainPage();
    AlertPage alertPage = new AlertPage();
    LoginPage loginPage = new LoginPage();
    CommonMethods methods = new CommonMethods();
    AlertFrontEndPage alertFrontEndPage = new AlertFrontEndPage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();

    @When("Go to Content Home and Navigate to Alerts page")
    public void go_to_content_home_and_navigate_to_alerts_page() {
        contentMainPage.selectAlertsContent();
    }

    @When("Create new alerts {string}")
    public void create_new_alerts(String testcaseID) {
        TestData.readTestData(testcaseID, "Alerts");
        alertPage.clickNewAlert();
        alertPage.createAlert();
    }

    @When("Should be able to post the alert")
    public void should_be_able_to_post_the_alert() {
        commonPageUtils.saveAndPublish();
    }

    @Then("Alerts will be display under Alerts item")
    public void alerts_will_be_display_under_alerts_item() {
        alertPage.verifyAlert();
    }


    @When("User launch the Alert frond end application in new tab")
    public void user_launch_the_alert_frond_end_application_in_new_tab() {
        methods.openAndSwitchNewTab();
        loginPage.launchFrontEndApplication_Alert();
    }

    @Then("User should be able to see Alert details")
    public void user_should_be_bale_to_see_alert_details() {
        if (TestData.getData("Post Date").equalsIgnoreCase("CurrentDate") && !TestData.getData("End Date").equalsIgnoreCase("PastDate")) {
            alertFrontEndPage.verifyAlertInFrontEnd();
        } else {
            alertFrontEndPage.verifyPopupAlertNotPublished();
        }
    }

    @Then("User should be able to see Alert details in banner")
    public void user_should_be_bale_to_see_alert_details_in_banner() {
        alertFrontEndPage.verifyBannerAlert();
    }

    //RG_AL_3.9 Alert without start date validation message should be visible

    @When("Create new alerts {string} without start date")
    public void create_new_alerts_without_start_date(String testcaseID) {
        TestData.readTestData(testcaseID, "Alerts");
        alertPage.clickNewAlert();
        alertPage.createAlertWithoutStartDate();
    }

    @Then("validation message will be visible to user")
    public void validation_message_will_be_visible_to_user() {
        commonPageUtils.clickSaveAndPublish();
        alertPage.alertSaveWithoutDate();

    }

    @When("User update the alert details {string}")
    public void i_update_alert_details(String testcaseID) {
        TestData.readTestData(testcaseID, "Alerts");
        alertPage.updateAlerts();
        commonPageUtils.saveAndPublish();
        alertPage.verifyAlert();
    }

    @When("user selects existing alert and delete alert {string}")
    public void user_selects_existing_alert_and_delete_alert(String alertType) {
        StepDefinitions_Alerts.alertType = alertType;
        alertPage.deleteAlert(alertType);
    }


    @When("deleted alert should be displayed in recycle bin")
    public void deleted_alert_should_be_displayed_in_recycle_bin() {
        alertPage.checkDeletedAlertInRecycleBin();
    }

    @Then("deleted alert should not be posted to front end")
    public void deleted_alert_should_not_be_posted_to_front_end() {
        alertFrontEndPage.verifyAlertNotPublished(alertType);
    }
}
