package org.govstack.stepdefinition.bd;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdCMS.pages.BDCmsPage;
import org.govstack.pom.cms.sitemap.pages.SiteMapPage;
import org.govstack.pom.cms.utils.CommonPageUtils;

public class StepDefinitions_BD_CMS {

    CommonPageUtils commonPageUtils = new CommonPageUtils();
    BDCmsPage BD_Cms_pg = new BDCmsPage();
    SiteMapPage sitemapPg = new SiteMapPage();

    @Then("Go to create page under main site")
    public void go_to_create_page_under_main_site() {
        BD_Cms_pg.BD_dotIcon();
    }

    @Then("create business directory landing page {string}")
    public void create_business_directory_landing_page(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_CMS");
        BD_Cms_pg.BD_createPage();
        commonPageUtils.saveAndPublish();
        BD_Cms_pg.bdMenuLinkList();
        sitemapPg.infoTabLink();
    }

    @Then("verify business directory page in frontend")
    public void verify_business_directory_page_in_frontend() {
        BD_Cms_pg.bd_frontendPage_Validation_Assertion();
    }

    @When("user go to created business directory landing page")
    public void user_go_to_created_business_directory_landing_page() {
        BD_Cms_pg.bdMenuLinkList();
        BD_Cms_pg.bd_SectorNavSelection();
    }

    @Then("select business directory sector page")
    public void select_business_directory_sector_page() {
        BD_Cms_pg.bd_SectorPageCreateLinkSelect();
    }

    @Then("create business directory sector page {string}")
    public void create_business_directory_sector_page(String testcaseID) {
        TestData.readTestData(testcaseID, "BD_CMS");
        BD_Cms_pg.BD_SectorcreatePage();
        commonPageUtils.saveAndPublish();
        sitemapPg.infoTabLink();
    }

    @Then("verify business directory sector page in frontend")
    public void verify_business_directory_sector_page_in_frontend() {
        BD_Cms_pg.bd_SectorfrontendPage_Validation_Assertion();
    }

    @Then("expand the created business directory page and select the business directory sector page")
    public void expand_the_created_business_directory_page_and_select_the_business_directory_sector_page() {
        BD_Cms_pg.expandSelectBdSectorPage();
        sitemapPg.infoTabLink();
    }

    
    @Then("verify user should be able to link to filtered searches \\(for each individual sector) directly")
    public void verify_user_should_be_able_to_link_to_filtered_searches_for_each_individual_sector_directly() {
        BD_Cms_pg.bd_SectorSelectfrontendPage_Validation_Assertion();
    }


}
