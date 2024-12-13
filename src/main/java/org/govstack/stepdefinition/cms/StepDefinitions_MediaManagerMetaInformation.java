package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.pom.cms.contentMain.pages.ContentMainPage;
import org.govstack.pom.cms.mediamanagermetainfo.pages.MediaMetaInfoPages;
import org.govstack.pom.cms.utils.CommonPageUtils;

public class StepDefinitions_MediaManagerMetaInformation {

    ContentMainPage mainPage=new ContentMainPage();
    MediaMetaInfoPages mediaMetaInfoPages=new MediaMetaInfoPages();
    CommonPageUtils pageUtils=new CommonPageUtils();

    @When("user create a Subfolder Media Pages")
    public void user_create_a_subfolder_media_pages() {
        mainPage.navigateToMediaPages();
        mediaMetaInfoPages.createSubfolderMediaPages();
        pageUtils.saveAndPublish();
    }

    @When("user create Media Page for Meta Information fields with Text Fields {string}")
    public void user_create_media_page_for_meta_information_fields_with_text_fields(String string) {
        mediaMetaInfoPages.createMediaPage();
    }

    @Then("Values should be successfully added and working on frontend.")
    public void values_should_be_successfully_added_and_working_on_frontend() {

    }
}
