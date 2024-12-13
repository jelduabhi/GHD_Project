package org.govstack.stepdefinition.bd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdListings.pages.BDListingsPage;
import org.govstack.pom.cms.utils.CommonPageUtils;

public class StepDefinitions_BD_Listings {
    BDListingsPage bdListingsPage = new BDListingsPage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();

    @When("user Go to Listings tab")
    public void user_go_to_listings_tab() {
        bdListingsPage.bdListingsTab();
    }

    @And("Search and select a listing {string}")
    public void search_and_select_listing(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Listings");
        bdListingsPage.searchListing();
    }

    @Then("Verify listing details in Backend")
    public void verify_listing_details_backend() {
        bdListingsPage.verifyListingDetailsBackend();
    }

    @And("Launch Business Directory Landing Page")
    public void launch_bd_landing_page() {
        bdListingsPage.launchBDPageFrontEnd();
        commonPageUtils.dismissAllAlerts();
        bdListingsPage.acceptCookies();
    }

    @And("Verify BD Listing in Front End {string}")
    public void verify_bd_listing(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_Listings");
        bdListingsPage.verifyBDListing();
        bdListingsPage.verifyAdditionalDetails();
    }

    @And("Verify clicking the Website URL will direct to the site")
    public void verify_website_link() {
        bdListingsPage.verifyWebsite();
    }

    @And("Go back to BD Landing Page")
    public void go_back_to_bdlanding_page() {
        bdListingsPage.backToBusinessListings();
    }

    @And("Search and select a listing in Frontend")
    public void search_and_select_listing_frontend() {
        bdListingsPage.searchListingFrontEnd();
    }

    @And("Verify clicking the Social Icons will direct to the site")
    public void verify_icons() {
        bdListingsPage.verifyFBIcon();
        bdListingsPage.verifyTwitterIcon();
        bdListingsPage.verifyYoutubeIcon();
        bdListingsPage.verifyIGIcon();
        bdListingsPage.verifyTiktokIcon();
    }

    @And("Go back to BD Landing Page through navigation link")
    public void go_back_through_navigation_link() {
        bdListingsPage.goBackThroughNavigationLink();
    }

    @And("Verify all listings result count")
    public void verify_all_listings_result_count() {
        bdListingsPage.verifyResultCount();
    }

    @And("Filter Listings")
    public void filter_listings() {
        bdListingsPage.filter2SectorListings();
        bdListingsPage.addAmenitiesFilter();
        bdListingsPage.addAOSFilter();
        bdListingsPage.clearFilter();
    }

    @And("Verify no available listing based on filter applied")
    public void verify_no_available_listings() {
        bdListingsPage.verifyNoAvailableListings();
        bdListingsPage.clearFilter();
    }

    @And("Test results per page")
    public void test_results_per_page() {
        bdListingsPage.testResultsPerPage();
    }


}
