package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.subnav.pages.SubNavPage;


public class StepDefinitions_SubNav {

    SubNavPage subnavPage = new SubNavPage();

    @When("Create Main Page, Navigate to Home or Main Site, click on the three dots and click Create, Select Page, choose a template {string}")
    public void createMainPageNavigateToHomeOrMainSiteClickOnTheDotsAndClickCreateSelectPageChooseATemplate(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.clickMainsiteThreeDotIcon();
        subnavPage.selectPage();
        subnavPage.selectBlankPageTemplate();
    }

    @And("Add name and Page Title, Headings etc. {string}")
    public void addNameAndPageTitleHeadingsEtc(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.addHeadername();
        subnavPage.addContentHeading();
        subnavPage.addContentSeconddaryHeading();
    }

    @And("Choose a Layout Left or Right {string}")
    public void chooseALayoutLeftOrRight(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.selectLayout();
    }

    @Then("Main Page created successfully under the Home or Main Site. {string}")
    public void mainPageCreatedSuccessfullyUnderTheHomeOrMainSite(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.verifySubnavMainpageCreated();
    }

    @When("Go to the created Test Page Main Page and Create a Sub Nav Page Click on the three dots and click Create, Select Page, choose a template {string}")
    public void goToTheCreatedTestPageMainPageAndCreateASubNavPageClickOnTheThreeDotsAndClickCreateSelectPageChooseATemplate(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.clickSubnavMainPageThreeDotIcon();
        subnavPage.selectPage();
        subnavPage.selectBlankPageTemplate();
    }

    @Then("Secondary website navigation sub nav created successfully under the Main Test Page. {string}")
    public void secondaryWebsiteNavigationSubNavCreatedSuccessfullyUnderTheMainTestPage(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.verifySubnavSubpageOneCreatedUnderMainpage();

    }

    @When("Go to the Home  Content  Main Page  Sub Nav Page {string}")
    public void goToTheHomeContentMainPageSubNavPage(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.clickSubnavSubPageOneThreeDotIcon();
        subnavPage.selectPage();
        subnavPage.selectBlankPageTemplate();
    }

    @Then("Secondary sub navigation component is created successfully under the Sub Nav Page {string}")
    public void secondarySubNavigationComponentIsCreatedSuccessfullyUnderTheSubNavPage(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.verifySubnavSubpageTwoCreatedUnderSubpageOne();
    }

    @When("Go to the created Test Page Main Page and Navigate to the info {string}")
    public void goToTheCreatedTestPageMainPageAndNavigateToTheInfo(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.navigateToSubnavMainPageInfo();
    }

    @And("Click the link to view the front end page which includes the created sub navigation {string}")
    public void clickTheLinkToViewTheFrontEndPageWhichIncludesTheCreatedSubNavigation(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.clickAndOpenSubnavMainpageUrl();
    }

    @Then("Verify Main Parent Page in bold format.{string}")
    public void verifyMainParentPageInBoldFormat(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.verifySubnavMainpagePresenceFE();
    }

    @Then("Verify Custom secondary sub navigation component for website sidebar displaying following the selected lay out left or right and hierarchy structure. {string}")
    public void verifyCustomSecondarySubNavigationComponentForWebsiteSidebarDisplayingFollowingTheSelectedLayOutLeftRightAndHierarchyStructure(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.verifyLayoutFE();
    }

    @Then("Verify Contextual sub navigation menu that shows only the navigation items specific to the subcategory of the page the user is on. {string}")
    public void verifyContextualSubNavigationMenuThatShowsOnlyTheNavigationItemsSpecificToTheSubcategoryOfThePageTheUserIsOn(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.verifySubnavMenuFE();
    }

    @Then("Include links to all pages and child pages that are part of the parent vertical. {string}")
    public void includeLinksToAllPagesAndChildPagesThatArePartOfTheParentVertical(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.verifySubnavMenuHyperlinksFE();
    }

    @When("Navigate to the Front End page {string}")
    public void navigateToTheFrontEndPage(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.navigateToSubnavMainPageFE();
    }

    @And("Scroll thru the Sub Nave structure, try to expand and collapse.")
    public void scrollThruTheSubNaveStructureTryToExpandAndCollapse() {
        subnavPage.expandAndCollapseSubnavMenu();
    }

    @And("On the Sub Nav Structure select a page")
    public void onTheSubNavStructureSelectAPage() {
        subnavPage.clickOnSubnavSubpageOne();
    }

    @Then("Support advanced sub navigation where the selected page or section automatically appears at the top of the sub navigation. below the Main Parent Page")
    public void supportAdvancedSubNavigationWhereTheSelectedPageOrSectionAutomaticallyAppearsAtTheTopOfTheSubNavigationBelowTheMainParentPage() {
        subnavPage.verifySubnavSubpageOneSelectedPlaceholder();
    }

    @Then("Navigation breadcrumbs should be included on lower left")
    public void navigationBreadcrumbsShouldBeIncludedOnLowerLeft() {
        subnavPage.verifySubnavBreadCrumpPresenceonFE();
    }

    @And("On the Sub Nav Structure, Click View Full Menu bullets button")
    public void onTheSubNavStructureClickViewFullMenuBulletsButton() {
        subnavPage.clickOnSubnavViewFullMenuFE();
    }

    @Then("opening the view full menu list, the full sitemap should be displayed. we should see + toggles where pages have children.")
    public void openingTheViewFullMenuListTheFullSitemapShouldBeDisplayedWeShouldSeeTogglesWherePagesHaveChildren() {
        subnavPage.verifySubnavViewFullMenuFE();
    }

    @And("On the Sub Nav Structure, Click Close Full Menu x close button")
    public void onTheSubNavStructureClickCloseFullMenuXCloseButton() {
        subnavPage.clickOnSubnavCloseFullMenuFE();
    }

    @Then("View Full menu should remain open when selected unless Close Full Menu is clicked or if user select a specific page.")
    public void viewFullMenuShouldRemainOpenWhenSelectedUnlessCloseFullMenuIsClickedOrIfUserSelectASpecificPage() {
        subnavPage.verifySubnavCloseFullMenuFE();
    }

    @When("Go to the Home Content Main Page Sub Nav Page Secondary Sub Nav Page {string}")
    public void goToTheHomeContentMainPageSubNavPageSecondarySubNavPage(String testCaseID) {
        TestData.readTestData(testCaseID, "SubNav");
        subnavPage.navigateToSubnavSubpageTwo();
    }

    @And("Go to Navigation tab")
    public void goToNavigationTab() {
        subnavPage.gotoNavigationTab();
    }

    @When("On Hide from all navigation select Yes")
    public void onHideFromAllNavigationSelectYes() {
        subnavPage.toggleYESHideFromAllNav();
    }


    @Then("Parent page with only non visible child pages does not display a + symbol in the sub nav.")
    public void parentPageWithOnlyNonVisibleChildPagesDoesNotDisplayASymbolInTheSubNav() {
        subnavPage.verifyHideAllNavFE();
    }
}