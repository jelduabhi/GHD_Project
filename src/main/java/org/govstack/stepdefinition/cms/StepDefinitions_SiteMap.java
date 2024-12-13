package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.login.pages.LoginPage;
import org.govstack.pom.cms.sitemap.pages.SiteMapPage;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.utils.CommonMethods;

public class StepDefinitions_SiteMap {

    SiteMapPage sitemapPg = new SiteMapPage();
    CommonPageUtils commonPageUtils = new CommonPageUtils();
    LoginPage loginPage = new LoginPage();
    CommonMethods methods = new CommonMethods();

    @When("Go to content home")
    public void go_to_content_home() {
        sitemapPg.selectHomeContent();
    }

    @When("user navigate to sitemap xml menu")
    public void user_navigate_to_sitemap_xml_menu() {
        sitemapPg.siteMapXmlMenu();
    }

    @When("user click navigate to  info link and click sitemap xml link")
    public void user_click_navigate_to_info_link_and_click_sitemap_xml_link() {
        sitemapPg.infoTabLink();
        sitemapPg.sitemampXmlLinkClick();
    }

    @Then("verify sitemap xml or robot file should be loaded")
    public void verify_sitemap_xml_or_robot_file_should_be_loaded() {
        sitemapPg.SiteMapRobotLinkpageOpenNewTab();
    }

    @When("user navigate to robot txt menu")
    public void user_navigate_to_robot_txt_menu() {
        sitemapPg.robotsTxtMenu();
    }

    @When("user click navigate to  info link and click robot txt link")
    public void user_click_navigate_to_info_link_and_click_robot_txt_link() {
        sitemapPg.infoTabLink();
        sitemapPg.robotTxtLinkClick();
    }

    @When("user click home and create a page {string}")
    public void user_click_home_and_create_a_page(String testcaseID) {
        TestData.readTestData(testcaseID, "Sitemap");
        sitemapPg.newPageCreate();
        commonPageUtils.saveAndPublish();
    }

    @When("user click subsite and create a page {string}")
    public void user_click_subsite_and_create_a_page(String testcaseID) {
        TestData.readTestData(testcaseID, "Sitemap");
        sitemapPg.subsitePageCreate();
        commonPageUtils.saveAndPublish();
    }

    @When("user open news_rss in new tab")
    public void user_open_news_rss_in_new_tab() {
        methods.openAndSwitchNewTab();
        loginPage.launchFrontEndApplication_Rss_Feeds();

    }

}
