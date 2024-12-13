package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.disablelinksfornonpagenodes.pages.DisableLInksForNonPageNodesPage;

public class StepDefinitions_DisableLinksForNonPageNodes {

    DisableLInksForNonPageNodesPage dLinksPage = new DisableLInksForNonPageNodesPage();

    @When("Go to News Categories {string}")
    public void goToNewsCategoriesTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandNewsMenu();
        dLinksPage.navigateToNewsCatagories();
    }

    @And("Navigate to Info")
    public void navigateToInfoTestcaseID() {
        dLinksPage.navigateToInfo();
    }

    @Then("Check if disabled links for Non Page Nodes")
    public void checkIfDisabledLinksForNonPageNodesTestcaseID() {
        dLinksPage.verifyLinksSection();
    }

    @When("Go to News Authors {string}")
    public void goToNewsAuthorsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandNewsMenu();
        dLinksPage.navigateToNewsAuthors();
    }

    @When("Go to News Authors Items {string}")
    public void goToNewsAuthorsItemsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandNewsMenu();
        dLinksPage.navigateToNewsAuthors();
        dLinksPage.navigateToNewsAuthorsItems();
    }

    @When("Go to News Post {string}")
    public void goToNewsPostTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandNewsMenu();
        dLinksPage.navigateToNewsPost();
    }

    @When("Go to Alerts {string}")
    public void goToAlertsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToAlerts();
    }

    @When("Go to Alerts Items {string}")
    public void goToAlertsItemsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToAlerts();
        dLinksPage.navigateToAlertsItems();
    }

    @When("Go to Parsers Pages {string}")
    public void goToParsersPagesTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToParsers();
    }

    @When("Go to Custom Integration {string}")
    public void goToCustomIntegrationTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToCustomIntegration();
    }

    @When("Go to Contact  Directory Contacts {string}")
    public void goToContactDirectoryContactsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandCDMenu();
        dLinksPage.navigateToCDContacts();
    }

    @When("Go to Contact  Directory  Contacts  Click any Contact items {string}")
    public void goToContactDirectoryContactsClickAnyContactItemsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandCDMenu();
        dLinksPage.navigateToCDContactsItems();
    }

    @When("Go to Contact  Directory  Contacts List {string}")
    public void goToContactDirectoryContactsListTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandCDMenu();
        dLinksPage.navigateToCDContactsList();
    }

    @When("Go to Search Engine Config {string}")
    public void goToSearchEngineConfigTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToSEConfig();
    }

    @When("Go to Search Engine Config Search Engines {string}")
    public void goToSearchEngineConfigSearchEnginesTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandSEConfigMenu();
        dLinksPage.navigateToSEConfigSEs();
    }

    @When("Go to Search Engine Config Theme Configuration {string}")
    public void goToSearchEngineConfigThemeConfigurationTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandSEConfigMenu();
        dLinksPage.navigateToSEConfigThemeConfig();
    }

    @When("Go to News {string}")
    public void goToNewsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToNews();
    }

    @Then("Check if there is a nodes link")
    public void checkIfThereIsANodesLink() {
        dLinksPage.isLinksSectionPresent();
    }

    @When("Go to News  Posts  News Posts {string}")
    public void goToNewsPostsNewsPostsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandNewsMenu();
        dLinksPage.navigateToNewsNewsPosts();
    }

    @When("Go to  Parser Pages  Click any Parsers Items Calendar and Forms {string}")
    public void goToParserPagesClickAnyParsersItemsCalendarAndFormsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToParsers();
        dLinksPage.navigateToPPCalendar();
    }

    @When("Go to  Contact Directory {string}")
    public void goToContactDirectoryTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToCD();
    }

    @When("Go to Contact Directory  Contact List and Contacts List {string}")
    public void goToContactDirectoryContactListAndContactsListTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.expandCDMenu();
        dLinksPage.navigateToCDContactsList();
    }

    @Then("Redirected URL Management links should not be displayed for Contact list and Contacts List")
    public void redirectedURLManagementLinksShouldNotBeDisplayedForContactListAndContactsList() {
        dLinksPage.verifyRedirectUrlSectionNotPreset();
    }

    @When("Go to Design {string}")
    public void goToDesignTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToDesign();
    }

    @When("Go to Design Design Item {string}")
    public void goToDesignDesignItemTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToDesign();
        dLinksPage.navigateToDesignItems();
    }

    @When("Go to Global {string}")
    public void goToGlobalTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToGlobal();
    }

    @When("Go to Global Global Items {string}")
    public void goToGlobalGlobalItemsTestcaseID(String testCaseID) {
        TestData.readTestData(testCaseID, "DisabledLinksForNonPageNodes");
        dLinksPage.navigateToGlobal();
        dLinksPage.navigateToGlobalItems();
    }
}
