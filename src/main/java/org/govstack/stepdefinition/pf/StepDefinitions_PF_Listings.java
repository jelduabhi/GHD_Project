package org.govstack.stepdefinition.pf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.pf.pfListings.pages.PFListingsPage;
import org.govstack.pom.bd.bdListings.pages.BDListingsPage;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.pom.pf.pfactivities.pages.PFActivityPages;

public class StepDefinitions_PF_Listings {
    PFListingsPage pfListingsPage = new PFListingsPage();
    BDListingsPage bdListingsPage = new BDListingsPage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    PFActivityPages activityPages=new PFActivityPages();

    @When("User Go to PF Listings tab")
    public void user_go_to_listings_tab() {
        pfListingsPage.pfListingsTab();
    }

    @When("user is able to see listing and Activity table is automatically sorted by Name column")
    public void user_is_able_to_activities_and_activity_table_is_automatically_sorted_by_name_column() {
        TestData.readTestData("RG_PF_LIS_BO_03", "PF_Listings");
        activityPages.validateTitleAndSortWithName();
    }
    @When("user is able to sort by Facility Type, Location Types, Status")
    public void user_is_able_to_sort_by_facility_type_location_types_status() {
    activityPages.validateSortWithFacilityTypeLocationTypeStatus();
    }

    @When("user is able to filter by Facility Type, Location Types, Status")
    public void user_is_able_to_filter_by_facility_type_location_types_status() {

    }
    @When("user should sort with fecility type")
    public void user_should_sort_with_fecility_type() {
        activityPages.validateActiveFilter();
    }

    @And("Search and select a PF listing {string}")
    public void search_and_select_listing(String testcaseID) {
        TestData.readTestData(testcaseID, "PF_Listings");
        pfListingsPage.searchListing();
    }

    @Then("Verify PF listing details in Backend")
    public void verify_listing_details_backend() {
        pfListingsPage.verifyListingDetailsBackend();
    }

    @And("Launch Parks and Facilities Landing Page")
    public void launch_pf_landing_page() {
        pfListingsPage.launchPFPageFrontEnd();
        commonPageUtils.dismissAllAlerts();
        bdListingsPage.acceptCookies();
    }

    @And("Verify PF Listing in Front End {string}")
    public void verify_pf_listing(String testcaseID) {
        TestData.readTestData(testcaseID, "PF_Listings");
        pfListingsPage.verifyPFListing();
        pfListingsPage.verifyAdditionalDetails();
    }

    @And("Verify clicking the Website will direct to the site")
    public void verify_website_link() {
        pfListingsPage.verifyWebsite();
    }

    @And("Go back to PF Landing Page through navigation link")
    public void go_back_through_navigation_link() {
        pfListingsPage.goBackThroughNavigationLink();
    }

    @And("Verify all pf listings result count")
    public void verify_all_listings_result_count() {
        pfListingsPage.verifyResultCount();
    }

    @And("Filter PF Listings")
    public void filter_listings() {
        pfListingsPage.filter2SectorListings();
        pfListingsPage.addActivitiesFilter();
        pfListingsPage.addAmenitiesFilter();
        pfListingsPage.addLocationTypesFilter();
        pfListingsPage.clearFilter();
    }

    @And("Verify no available pf listing based on filter applied")
    public void verify_no_available_listings() {
        pfListingsPage.verifyNoAvailableListings();
        pfListingsPage.clearFilter();
    }

    @And("Test pagination")
    public void test_pagination() {
        pfListingsPage.testPagination();
    }

    @When("user selects the add location")
    public void user_selects_the_add_location() {
        pfListingsPage.clickAddLocation();
    }

    @When("user enters the general details {string}")
    public void user_enters_the_general_details(String testCaseID) {
        TestData.readTestData(testCaseID,"PF_Listings_BackOffice");
        pfListingsPage.enterGeneralDetails();
        pfListingsPage.clickNextBtn();
    }

    @When("user enters the address details")
    public void user_enters_the_address_details() {
        pfListingsPage.enterAddressDetails();
        pfListingsPage.clickNextBtn();
    }

    @When("user enters the details details")
    public void user_enters_the_details_details() {
        pfListingsPage.enterDetails();
        pfListingsPage.clickSaveBtnFinal();
    }

    @Then("location should be added")
    public void location_should_be_added() {
        pfListingsPage.validatePFListingCreated();
    }
}
