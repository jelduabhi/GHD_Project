package org.govstack.stepdefinition.bidsTender;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.bidsTender.pages.BTpage;
import org.govstack.pom.login.pages.LoginPage;

public class StepDefinitions_Bids_Tenders {
    LoginPage loginPage = new LoginPage();
    BTpage btPage = new BTpage();

    @Given("Launch and login Bids and tender Back Office")
    public void Launch_and_login_Bids_and_tender_Back_Office() {
        loginPage.loginToBidsTenders_BackOffice();
    }

    @When("user go to team members")
    public void user_go_to_team_members() {
        btPage.btSideBarMenu();
    }

    @When("add a new team member with tag as purchaser and Assign to group with all permissions {string}")
    public void add_a_new_team_member_with_tag_as_purchaser_and_assign_to_group_with_all_permissions(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.btAddTeamMember();
    }

    @Then("verify a new team member is created in pro with all permissions")
    public void verify_a_new_team_member_is_created_in_pro_with_all_permissions() {
        btPage.btSearchTeamMemberAssertion();
    }

    @When("user go to project tab select create a project")
    public void user_go_to_project_tab_select_create_a_project() {
        btPage.btProjectSetupTab();
    }

    @When("select create a new project option and select source card")
    public void select_create_a_new_project_option_and_select_source_card() {
        btPage.btStartProject();
    }

    @When("select create a new project option and select contract card")
    public void select_create_a_new_project_option_and_select_contract_card() {
        btPage.btStartContractProject();
    }
    @When("user search for a project")
    public void user_search_for_a_project() {
        btPage.btSearchProject("Automation_BT_ProjectName_dDqil");
    }
    @Then("enter project details {string}")
    public void enter_project_details(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.btProjectDetails();
    }

    @Then("enter project details for intake {string}")
    public void enter_project_details_for_intake(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.btProjectDetailsIntakeProConversion();
    }

    @Then("in procurement method screen select invitational card and select procurement method")
    public void in_procurement_method_screen_select_invitational_card_and_select_procurement_method() {
        btPage.btProcurementMethod();
    }

    @Then("allow multiple submission and verify project created and user able to search created project")
    public void allow_multiple_submission_and_verify_project_created_and_user_able_to_search_created_project() {
        btPage.btSourceCriteriaScreenOne();
        btPage.btSourceCriteriaScreenTwo();
        btPage.btSourceCriteriaScreenThree();
    }

    @Then("user enters the details details for BT")
    public void user_enters_the_details_details_for_bt() {
        btPage.clickManageButton();
        btPage.enterDetails();
    }

    @Then("user enters Documents details")
    public void user_enters_documents_details() {
        btPage.enterDocumentsDetails();
    }

    @Then("user enters the Submission Requirements details")
    public void user_enters_the_submission_requirements_details() {
        btPage.enterSubmissionRequirementDetails();
    }

    @Then("user enters the invitation details")
    public void user_enters_the_invitation_details() {
        btPage.enterInvitationDetails();
    }

    @Then("user enters the dates details")
    public void user_enters_the_dates_details() {
        btPage.enterDateDetails();
    }

    @Then("user should be able to publish the project")
    public void user_should_be_able_to_publish_the_project() {
        btPage.publishBT();
    }
    @Then("user upload a document to Addenda and Questions Section")
    public void user_upload_a_document_to_addenda_and_questions_section() {
        btPage.enterQuesAndAddendaDetails();
    }

    @Then("user download the submission")
    public void user_download_the_submission() {
        btPage.downLodSubmission();
    }

    @Then("allow multiple submission in contract criteria and verify project created and user able to search created project")
    public void allow_multiple_submission_in_contract_criteria_and_verify_project_created_and_user_able_to_search_created_project() {
        btPage.btContractCriteriaScreenOne();
    }

    @When("user go to evaluator portal link")
    public void user_go_to_evaluator_portal_link() {
        btPage.btEvaluatorPortalLink();
    }

    @Then("click create account button")
    public void click_create_account_button() {
        btPage.btSupplierAccountCreate();
    }

    @Then("fill all supplier details {string}")
    public void fill_all_supplier_details(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.btSupplierAccountFormField();
    }

    @Then("login with existing supplier account {string}")
    public void login_with_existing_supplier_account(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.btSupplierExistingAccount();
    }

    @Then("make some updates on the supplier details {string}")
    public void make_some_updates_on_the_supplier_details(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.btSupplierAccountEditFormField();
    }

    @Then("verify supplier account details should be updated successfully")
    public void verify_supplier_account_details_should_be_updated_successfully() {
        btPage.btSupplierAccountUpdateValidation();
    }

    @Then("select project from grid")
    public void select_project_from_grid() {
        btPage.btSelectProjectGrid();
    }

    @When("user go to add team member and assign the access")
    public void user_go_to_add_team_member_and_assign_the_access() {
        btPage.btAssignProjectTeamMember();
    }

    @Then("verify user should be only that project which assigned")
    public void verify_user_should_be_only_that_project_which_assigned() {
        System.out.println("Test");
    }

    @When("user click copy intake request url button")
    public void user_click_copy_intake_request_url_button() {
        btPage.btCopyIntakeUrlButton();
    }

    @Then("verify intake request url open in new tab")
    public void verify_intake_request_url_open_in_new_tab() {
        btPage.btCopyIntakeUrlNewTab();
    }

    @Then("click start request button")
    public void click_start_request_button() {
        btPage.intakeStartButton();
    }
    @Then("fill intake form mandatory field {string}")
    public void fill_intake_form_mandatory_field(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.intakeContactDetailsFormField();
        btPage.intakeProjectDetailsFormField();
        btPage.intakeProjectValueFormField();
    }
    @When("user click submit request button")
    public void user_click_submit_request_button() {
        btPage.intakeSubmitButton();
    }
    @Then("verify intake request submitted successfully")
    public void verify_intake_request_submitted_successfully() {
        btPage.intakeRequestSubmitSuccessValidation();
    }

    @Then("select contract tab")
    public void select_contract_tab() {
       btPage.navContractTab();
    }
    @Then("add start date end date and project value")
    public void add_start_date_end_date_and_project_value() {
        btPage.contractTabDateAmount();
    }
    @Then("go to supplier tab and invite supplier")
    public void go_to_supplier_tab_and_invite_supplier() {
        btPage.contractSupplierTab();
    }
    @When("user click start contract button")
    public void user_click_start_contract_button() {
        btPage.startContractButtonValidation();
    }
    @Then("verify close contract button is visible")
    public void verify_close_contract_button_is_visible() {
        btPage.closeContractButtonValidation();
    }

    @When("user go to project tab select find a project")
    public void user_go_to_project_tab_select_find_a_project() {
        btPage.btFindProjectTab();
    }
    @Then("search a project")
    public void search_a_project() {
        btPage.intakeSavedSearchProjectFilter();
    }
    @Then("verify result is accurate based on search criteria")
    public void verify_result_is_accurate_based_on_search_criteria() {
        btPage.intakeSearchResultFilterValidation();
    }

    @Then("select the intake number")
    public void select_the_intake_number() {
        btPage.intakeProSelect();
    }
    @When("user click print request to pdf button")
    public void user_click_print_request_to_pdf_button() {
        btPage.intakePrintPdfBtn();
    }
    @Then("verify report should be downloaded with accurate data")
    public void verify_report_should_be_downloaded_with_accurate_data() {
        System.out.println("Test");
    }

    @When("user click view button from manage option")
    public void user_click_view_button_from_manage_option() {
        btPage.intakeDashboardManageButton();
    }

    @When("On Main Dashboard, go to Intake: pending requests and look for the created intake request {string}")
    public void onMainDashboardGoToIntakePendingRequestsAndLookForTheCreatedIntakeRequest(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.searcIntakeRequest();
    }

    @And("Click on ‘View’ under manage column")
    public void clickOnViewUnderManageColumn() {
        btPage.clickViewButton();
    }

    @And("On view page, click on ‘Decline’ button")
    public void onViewPageClickOnDeclineButton() {
        btPage.clickDeclineButton();
    }

    @And("On decline pop-up window, provide the reason for declining")
    public void onDeclinePopUpWindowProvideTheReasonForDeclining() {
        btPage.typeDeclineComment();
    }

    @And("Click on Decline button")
    public void clickOnDeclineButton() {
        btPage.clickDeclineRequestButton();
    }

    @And("Click on ‘View decline comment’ {string}")
    public void clickOnViewDeclineComment(String testcaseID) {
        TestData.readTestData(testcaseID, "BT_Smoke_TC");
        btPage.verifyViewDeclineComment();
    }

    @Then("On intake request view page, click on ‘Print request to PDF’ button")
    public void onIntakeRequestViewPageClickOnPrintRequestToPDFButton() {
        btPage.clickIntakePrintButton();
    }
}
