package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.cms.searchengine.pages.SearchEnginePage;
import org.govstack.pom.cms.utils.CommonPageUtils;

public class StepDefinitions_SearchEngine {

    ContentMainPage contentMainPage=new ContentMainPage();
    SearchEnginePage enginePage=new SearchEnginePage();
    CommonPageUtils commonPageUtils=new CommonPageUtils();

    @When("user navigate to Search Engine Configuration")
    public void user_navigate_to_search_engine_configuration() {
        contentMainPage.navigateToSearchEngineConfig();
    }

    @When("user create google search {string}")
    public void user_create_google_search(String testCaseNumber) {
        TestData.readTestData(testCaseNumber,"Search Engine");
        enginePage.createSearchEngine();
        commonPageUtils.saveAndPublish();
    }

    @Then("search engine should be created")
    public void search_engine_should_be_created() {
        enginePage.validatedSearchEnginePublished();
    }
}
