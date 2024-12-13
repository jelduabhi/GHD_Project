package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.govstack.framework.TestData;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.contactdirectory.pages.ContactDirectoryFrontEndPage;
import org.govstack.pom.cms.contactdirectory.pages.ContactDirectoryPage;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;

public class StepDefinitions_ContactDirectory {

    ContentMainPage contentMainPage = new ContentMainPage();
    ContactDirectoryPage contactDirectoryPage = new ContactDirectoryPage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    LoginPage loginPage = new LoginPage();
    CommonMethods methods = new CommonMethods();
    ContactDirectoryFrontEndPage directoryFrontEndPage = new ContactDirectoryFrontEndPage();

    @Given("user selects the contact category folder")
    public void user_selects_the_contact_category_folder() {
        contentMainPage.selectContactsCategoryFolder();
    }

    @Given("user selects the contact category")
    public void user_selects_the_contact_category() {
        contentMainPage.selectContactsCategory();
    }

    @Given("user expand the contact category")
    public void user_expand_the_contact_category() {
        contentMainPage.expandContactCategory();
    }

    @When("user create new category folder {string}")
    public void user_create_new_category_folder(String testCaseID) {
        TestData.readTestData(testCaseID, "Contact Directory");
        contactDirectoryPage.createContactsCategoryOrFolder();
        commonPageUtils.clickSaveAndPublish();
    }

    @When("user create new category {string}")
    public void user_create_new_category(String testCaseID) {
        TestData.readTestData(testCaseID, "Contact Directory");
        contactDirectoryPage.createContactsCategoryOrFolder();
        commonPageUtils.clickSaveAndPublish();
    }

    @When("user update the category {string}")
    public void user_update_the_category(String testCaseID) {
        TestData.readTestData(testCaseID, "Contact Directory");
        contactDirectoryPage.updateContactsCategory();
        commonPageUtils.clickSaveAndPublish();
    }

    @When("user delete the category")
    public void user_delete_the_category() {
        contactDirectoryPage.deleteContactsCategory();
    }

    @When("User is able to create new category folder")
    public void user_is_able_to_create_new_category_folder() {
        contactDirectoryPage.verifyContactsCategoryOrFolder();
    }

    @When("user is able to create new category")
    public void user_is_able_to_create_new_category() {
        contactDirectoryPage.verifyContactsCategoryOrFolder();
    }

    @When("user launch contact directory front end page in new tab")
    public void user_launch_category_front_end_page_in_new_tab() {
        methods.openAndSwitchNewTab();
        loginPage.launchFrontEndApplication_ContactDirectory();
        commonPageUtils.dismissAlerts();
    }

    @Then("Category should be created under Contacts")
    public void category_should_be_created_under_contacts() {
        directoryFrontEndPage.validateContactCategory();
    }

    @Then("Category should be updated under Contacts")
    public void category_should_be_updated_under_contacts() {
        directoryFrontEndPage.validateContactCategory();
    }

    @Then("Category should be deleted under Contacts")
    public void category_should_be_deleted_under_contacts() {
        directoryFrontEndPage.validateContactCategoryNotDisplayed();
    }

    @Then("category details should be updated")
    public void category_details_should_be_updated() {
        contactDirectoryPage.verifyContactsCategoryOrFolder();
    }

    @Then("category details should be deleted")
    public void category_details_should_be_deleted() {
        contactDirectoryPage.verifyContactsCategoryOrFolderNotDisplayed();
    }

    @Given("user select the contacts list")
    public void user_select_the_contacts_list() {
        contentMainPage.selectContactLists();
    }

    @When("user create a new contact {string}")
    public void user_create_a_new_contact(String testCaseID) {
        TestData.readTestData(testCaseID, "Contact Directory");
        contactDirectoryPage.clickNewContact();
        contactDirectoryPage.createNewContact();
    }

    @Then("new contact should be created")
    public void new_contact_should_be_created() {
        commonPageUtils.clickSaveAndPublish();
    }

    @Then("user add new phone number to the contact")
    public void user_add_new_phone_number_to_the_contact() {
        contactDirectoryPage.verifyNewContact();
        contactDirectoryPage.clickNewContact();
        contactDirectoryPage.enterContactDetails();
        commonPageUtils.clickSaveAndPublish();
    }

    @Then("new contact should be displayed")
    public void new_contact_should_be_displayed() {
        //directoryFrontEndPage.validateContactCategory();
    }

    @Then("contact details should be updated")
    public void contact_details_should_be_updated() {
        directoryFrontEndPage.validateContactDetails();
    }

    @When("user update a primary number {string}")
    public void user_update_a_primary_number(String testCaseID) {
        TestData.readTestData(testCaseID,"Contact Directory");
        contactDirectoryPage.updateContactNumber();
    }

    @Then("new contact should be updated")
    public void new_contact_should_be_updated() {
        commonPageUtils.clickSaveAndPublish();
    }
}
