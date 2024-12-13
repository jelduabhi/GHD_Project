package org.govstack.stepdefinition.pf;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.cms.utils.CommonPageUtils;
import org.govstack.pom.pf.pfcms.pages.PFCMSPage;

public class StepDefinitions_PF_CMS {
    ContentMainPage contentMainPage=new ContentMainPage();
    PFCMSPage pfcmsPage=new PFCMSPage();
    CommonPageUtils commonPageUtils=new CommonPageUtils();
    @When("user create a parks and fecility page from CMS {string}")
    public void user_create_a_parks_and_fecility_page_from_cms(String testCaseID) {
        TestData.readTestData(testCaseID,"PFCMS");
        contentMainPage.navigateToPFPage();
        pfcmsPage.createPFPage();
    }

    @When("PF page should be created")
    public void pf_page_should_be_created() {
        commonPageUtils.saveAndPublish();
        pfcmsPage.verifyPFPageCreated();
    }

    @Then("PF page should be posted to Front End")
    public void pf_page_should_be_posted_to_front_end() {
        pfcmsPage.validatePFPageInFrontEnd();
    }
}
