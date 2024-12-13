package org.govstack.stepdefinition.mi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.TestData;
import org.govstack.pom.mi.locators.MILocators;
import org.govstack.pom.mi.pages.MIPage;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class StepDefinitions_MI {

    MIPage mipage = new MIPage();
    MILocators miLocators = new MILocators();


    @When("On Media Pages > Subfolder Media Pages > Select Document Template {string}")
    public void onMediaPagesSubfolderMediaPagesSelectDocumentTemplate(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.navigateToHomeMenu();
        mipage.navigateToMediaTemplatePage();
        mipage.clickOnTemplate(TestData.getData("Template"));
        mipage.cleanExistingMIcontent();
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Document Version > Add Value")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectDocumentVersionAddValue() {
        mipage.addContentCard("Text Field");
        mipage.selectContent("Document Version");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select DepartmentDivision > Add Value")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectDepartmentDivisionAddValue() {
        mipage.addContentCard("Text Field");
        mipage.selectContent("Department/Division");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Text Area Fields > Select Description > Add Value")
    public void settingsUnderMetaInformationAddContentTextAreaFieldsSelectDescriptionAddValue() {
        mipage.addContentCard("Text Area Field");
        mipage.selectContent("Description");
        mipage.enterTextAreaFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select AuthorIssuer > Add Value")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectAuthorIssuerAddValue() {
        mipage.addContentCard("Text Field");
        mipage.selectContent("Author/Issuer");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectStatusAddValue() {
        mipage.addContentCard("Text Field");
        mipage.selectContent("Status");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectAlternativeTextAddValue() {
        mipage.addContentCard("Text Field");
        mipage.selectContent("Alternative Text");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit")
    public void settingsUnderMetaInformationAddContentLinkFieldsSelectRelatedDocumentLinkToMediaSelectMediaSelectAnyFileSubmit() {
        mipage.addContentCard("Link Field");
        mipage.selectContent("Related Document");
        mipage.selectLinkImgContentValue(TestData.getData("File Value"));
    }

    @And("Save and Publish")
    public void saveAndPublish() {
        mipage.clickOnSaveAndPublish();
    }

    @And("Go to Info > Links > Select URL link")
    public void goToInfoLinksSelectURLLink() {
        mipage.navigateToInfoTab();
        mipage.navigateToTemplateFEPage(TestData.getData("Template URL"));
    }

    @Then("Verify meta information is on the front end url link and has its values: Document Version, DepartmentDivision, Description, AuthorIssuer, Status, Alternative Text, Related Document")
    public void verifyMetaInformationIsOnTheFrontEndUrlLinkAndHasItsValuesDocumentVersionDepartmentDivisionDescriptionAuthorIssuerStatusAlternativeTextRelatedDocument() {
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Document Version", TestData.getData("Text Value"));
        expectedValues.put("Department/Division", TestData.getData("Text Value"));
        expectedValues.put("Description", TestData.getData("Text Value"));
        expectedValues.put("Author/Issuer", TestData.getData("Text Value"));
        expectedValues.put("Status", TestData.getData("Text Value"));
        expectedValues.put("Alternative Text", TestData.getData("Text Value"));
        expectedValues.put("Related Document", TestData.getData("File name"));
        mipage.verifyMITemplateTableContent(miLocators.miFETableHeader, miLocators.miFETableData, expectedValues);
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Bylaw Number > Add Value {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectBylawNumberAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Text Field");
        mipage.selectContent("By-law Number");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Date Fields > Select Date of Enactment > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectDateOfEnactmentAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Date Field");
        mipage.selectContent("Date of Enactment");
        mipage.selectCurrentDate();
    }

    @And("Settings > Under Meta Information > Add content > Date Fields > Select Effective Date > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectEffectiveDateAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Date Field");
        mipage.selectContent("Effective Date");
        mipage.selectCurrentDate();
    }


    @And("Settings > Under Meta Information > Add content > Link Fields > Select Amended By > Add > Insert Link > Insert Link Title > Submit {string}")
    public void settingsUnderMetaInformationAddContentLinkFieldsSelectAmendedByAddInsertLinkInsertLinkTitleSubmit(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Link Field");
        mipage.selectContent("Amended By");
        mipage.enterLinkUrlAndTitle(TestData.getData("Link URL"), TestData.getData("Link Title"));
    }

    @And("Settings > Under Meta Information > Add content > Link Fields > Select Repealed By > > Add > Insert Link > Insert Link Title > Submit {string}")
    public void settingsUnderMetaInformationAddContentLinkFieldsSelectRepealedByAddInsertLinkInsertLinkTitleSubmit(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Link Field");
        mipage.selectContent("Repealed By");
        mipage.enterLinkUrlAndTitle(TestData.getData("Link URL"), TestData.getData("Link Title"));
    }

    @Then("Verify meta information is on the front end url link and has its values: Bylaw Number, Document Version, DepartmentDivision, Description, Date of Enactment, Effective Date, Amended By, Repealed By, AuthorIssuer, Status, Alternative Text, Related Document {string}")
    public void verifyMetaInformationIsOnTheFrontEndUrlLinkAndHasItsValuesBylawNumberDocumentVersionDepartmentDivisionDescriptionDateOfEnactmentEffectiveDateAmendedByRepealedByAuthorIssuerStatusAlternativeTextRelatedDocument(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("By-law Number", TestData.getData("Text Value"));
        expectedValues.put("Document Version", TestData.getData("Text Value"));
        expectedValues.put("Department/Division", TestData.getData("Text Value"));
        expectedValues.put("Description", TestData.getData("Text Value"));
        expectedValues.put("Date of Enactment", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Effective Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Amended By", TestData.getData("Link Title") + " " + TestData.getData("Link URL"));
        expectedValues.put("Repealed By", TestData.getData("Link Title") + " " + TestData.getData("Link URL"));
        expectedValues.put("Author/Issuer", TestData.getData("Text Value"));
        expectedValues.put("Status", TestData.getData("Text Value"));
        expectedValues.put("Alternative Text", TestData.getData("Text Value"));
        expectedValues.put("Related Document", TestData.getData("File name"));
        mipage.verifyMITemplateTableContent(miLocators.miFETableHeader, miLocators.miFETableData, expectedValues);
    }


    @And("Settings > Under Meta Information > Add content > Date Fields > Select Issue Date > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectIssueDateAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Date Field");
        mipage.selectContent("Issue Date");
        mipage.selectCurrentDate();
    }

    @And("Settings > Under Meta Information > Add content > Date Fields > Select Expiration Date > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectExpirationDateAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Date Field");
        mipage.selectContent("Expiration Date");
        mipage.selectCurrentDate();
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Contact Information > Link to Page > Search: Contact > Select any Contact Information > Submit {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectContactInformationLinkToPageSearchContactSelectAnyContactInformationSubmit(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        //Text Fields > Select Contact Information IS NOT PRESENT
    }

    @Then("Verify meta information is on the front end url link and has its values: DepartmentDivision, Description, Issue Date, Effective Date, Expiration Date, Amended By, Repealed By, AuthorIssuer, Contact Information, Status, Alternative Text, Related Document {string}")
    public void verifyMetaInformationIsOnTheFrontEndUrlLinkAndHasItsValuesDepartmentDivisionDescriptionIssueDateEffectiveDateExpirationDateAmendedByRepealedByAuthorIssuerContactInformationStatusAlternativeTextRelatedDocument(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Department/Division", TestData.getData("Text Value"));
        expectedValues.put("Description", TestData.getData("Text Value"));
        expectedValues.put("Issue Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Effective Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Expiration Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Amended By", TestData.getData("Link Title") + " " + TestData.getData("Link URL"));
        expectedValues.put("Repealed By", TestData.getData("Link Title") + " " + TestData.getData("Link URL"));
        expectedValues.put("Author/Issuer", TestData.getData("Text Value"));
        //Text Fields > Select Contact Information IS NOT PRESENT
        expectedValues.put("Status", TestData.getData("Text Value"));
        expectedValues.put("Alternative Text", TestData.getData("Text Value"));
        expectedValues.put("Related Document", TestData.getData("File name"));
        mipage.verifyMITemplateTableContent(miLocators.miFETableHeader, miLocators.miFETableData, expectedValues);
    }

    @And("Settings > Under Meta Information > Add content > Date Fields > Select Meeting Date > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectMeetingDateAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        //Date Fields > Select Meeting Date IS NOT PRESENT
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Meeting Type > Add Value {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectMeetingTypeAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Text Field");
        mipage.selectContent("Meeting Type");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Meeting Location > Add Value {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectMeetingLocationAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Text Field");
        mipage.selectContent("Meeting Location");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @Then("Verify meta information is on the front end url link and has its values: Meeting Date, Meeting Type, Meeting Location, DepartmentDivision, Description, AuthorIssuer, Status, Alternative Text, Related Document {string}")
    public void verifyMetaInformationIsOnTheFrontEndUrlLinkAndHasItsValuesMeetingDateMeetingTypeMeetingLocationDepartmentDivisionDescriptionAuthorIssuerStatusAlternativeTextRelatedDocument(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        Map<String, String> expectedValues = new HashMap<>();
        //Date Fields > Select Meeting Date IS NOT PRESENT
        expectedValues.put("Meeting Type", TestData.getData("Text Value"));
        expectedValues.put("Meeting Location", TestData.getData("Text Value"));
        expectedValues.put("Department/Division", TestData.getData("Text Value"));
        expectedValues.put("Description", TestData.getData("Text Value"));
        expectedValues.put("Author/Issuer", TestData.getData("Text Value"));
        expectedValues.put("Status", TestData.getData("Text Value"));
        expectedValues.put("Alternative Text", TestData.getData("Text Value"));
        expectedValues.put("Related Document", TestData.getData("File name"));
        mipage.verifyMITemplateTableContent(miLocators.miFETableHeader, miLocators.miFETableData, expectedValues);
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select ApplicationReport Number > Add Value {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectApplicationReportNumberAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Text Field");
        mipage.selectContent("Application/Report Number");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Date Fields > Select Submission Date > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectSubmissionDateAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Date Field");
        mipage.selectContent("Submission Date");
        mipage.selectCurrentDate();
    }

    @And("Settings > Under Meta Information > Add content > Date Fields > Select Review Date > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectReviewDateAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Date Field");
        mipage.selectContent("Review Date");
        mipage.selectCurrentDate();
    }

    @And("Settings > Under Meta Information > Add content > Date Fields > Select Approval Date > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectApprovalDateAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Date Field");
        mipage.selectContent("Approval Date");
        mipage.selectCurrentDate();
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Applicant Name > Add Value {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectApplicantNameAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Text Field");
        mipage.selectContent("Applicant Name");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @Then("Verify meta information is on the front end url link and has its values: ApplicationReport Number, Submission Date, Review Date, Approval Date, Expiration Date, Applicant Name, Contact Information, DepartmentDivision, Description, Amended By, Repealed By, Status, Alternative Text, Related Document {string}")
    public void verifyMetaInformationIsOnTheFrontEndUrlLinkAndHasItsValuesApplicationReportNumberSubmissionDateReviewDateApprovalDateExpirationDateApplicantNameContactInformationDepartmentDivisionDescriptionAmendedByRepealedByStatusAlternativeTextRelatedDocument(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Application/Report Number", TestData.getData("Text Value"));
        expectedValues.put("Submission Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Review Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Approval Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Expiration Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Applicant Name", TestData.getData("Text Value"));
        //Text Fields > Select Contact Information IS NOT PRESENT
        expectedValues.put("Department/Division", TestData.getData("Text Value"));
        expectedValues.put("Description", TestData.getData("Text Value"));
        expectedValues.put("Status", TestData.getData("Text Value"));
        expectedValues.put("Amended By", TestData.getData("Link Title") + " " + TestData.getData("Link URL"));
        expectedValues.put("Repealed By", TestData.getData("Link Title") + " " + TestData.getData("Link URL"));
        expectedValues.put("Alternative Text", TestData.getData("Text Value"));
        expectedValues.put("Related Document", TestData.getData("File name"));
        mipage.verifyMITemplateTableContent(miLocators.miFETableHeader, miLocators.miFETableData, expectedValues);
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select PolicyRegulation Number > Add Value {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectPolicyRegulationNumberAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Text Field");
        mipage.selectContent("Policy/Regulation Number");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @And("Settings > Under Meta Information > Add content > Date Fields > Select Adoption Date > Add Value {string}")
    public void settingsUnderMetaInformationAddContentDateFieldsSelectAdoptionDateAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Date Field");
        mipage.selectContent("Adoption Date");
        mipage.selectCurrentDate();
    }

    @Then("Verify meta information is on the front end url link and has its values: PolicyRegulation Number, Adoption Date, Effective Date, DepartmentDivision, Description, Amended By, Repealed By, AuthorIssuer, Status, Alternative Text, Related Document {string}")
    public void verifyMetaInformationIsOnTheFrontEndUrlLinkAndHasItsValuesPolicyRegulationNumberAdoptionDateEffectiveDateDepartmentDivisionDescriptionAmendedByRepealedByAuthorIssuerStatusAlternativeTextRelatedDocument(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Policy/Regulation Number", TestData.getData("Text Value"));
        expectedValues.put("Adoption Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Effective Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Department/Division", TestData.getData("Text Value"));
        expectedValues.put("Description", TestData.getData("Text Value"));
        expectedValues.put("Amended By", TestData.getData("Link Title") + " " + TestData.getData("Link URL"));
        expectedValues.put("Repealed By", TestData.getData("Link Title") + " " + TestData.getData("Link URL"));
        expectedValues.put("Author/Issuer", TestData.getData("Text Value"));
        expectedValues.put("Status", TestData.getData("Text Value"));
        expectedValues.put("Alternative Text", TestData.getData("Text Value"));
        expectedValues.put("Related Document", TestData.getData("File name"));
        mipage.verifyMITemplateTableContent(miLocators.miFETableHeader, miLocators.miFETableData, expectedValues);
    }

    @And("Settings > Under Meta Information > Add content > Text Fields > Select Notice Number > Add Value {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectNoticeNumberAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Text Field");
        mipage.selectContent("Notice Number");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @Then("Verify meta information is on the front end url link and has its values: Notice Number, Issue Date, Effective Date, Expiration Date, DepartmentDivision, Description, AuthorIssuer, Contact Information, Status, Alternative Text, Related Document {string}")
    public void verifyMetaInformationIsOnTheFrontEndUrlLinkAndHasItsValuesNoticeNumberIssueDateEffectiveDateExpirationDateDepartmentDivisionDescriptionAuthorIssuerContactInformationStatusAlternativeTextRelatedDocument(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Notice Number", TestData.getData("Text Value"));
        expectedValues.put("Issue Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Effective Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Expiration Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Department/Division", TestData.getData("Text Value"));
        expectedValues.put("Description", TestData.getData("Text Value"));
        expectedValues.put("Author/Issuer", TestData.getData("Text Value"));
        //Text Fields > Select Contact Information IS NOT PRESENT
        expectedValues.put("Status", TestData.getData("Text Value"));
        expectedValues.put("Alternative Text", TestData.getData("Text Value"));
        expectedValues.put("Related Document", TestData.getData("File name"));
        mipage.verifyMITemplateTableContent(miLocators.miFETableHeader, miLocators.miFETableData, expectedValues);
    }


    @And("Settings > Under Meta Information > Add content > Text Fields > Select Document Number > Add Value {string}")
    public void settingsUnderMetaInformationAddContentTextFieldsSelectDocumentNumberAddValue(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        mipage.addContentCard("Text Field");
        mipage.selectContent("Document Number");
        mipage.enterTextFieldContentValue(TestData.getData("Text Value"));
    }

    @Then("Verify meta information is on the front end url link and has its values: Document Number, Issue Date, Effective Date, Expiration Date, Document Version, DepartmentDivision, Description, AuthorIssuer, Contact Information, Status, Alternative Text, Related Document {string}")
    public void verifyMetaInformationIsOnTheFrontEndUrlLinkAndHasItsValuesDocumentNumberIssueDateEffectiveDateExpirationDateDocumentVersionDepartmentDivisionDescriptionAuthorIssuerContactInformationStatusAlternativeTextRelatedDocument(String testCaseID) {
        TestData.readTestData(testCaseID, "MI");
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Document Number", TestData.getData("Text Value"));
        expectedValues.put("Issue Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Effective Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Expiration Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedValues.put("Document Version", TestData.getData("Text Value"));
        expectedValues.put("Department/Division", TestData.getData("Text Value"));
        expectedValues.put("Description", TestData.getData("Text Value"));
        expectedValues.put("Author/Issuer", TestData.getData("Text Value"));
        //Text Fields > Select Contact Information IS NOT PRESENT
        expectedValues.put("Status", TestData.getData("Text Value"));
        expectedValues.put("Alternative Text", TestData.getData("Text Value"));
        expectedValues.put("Related Document", TestData.getData("File name"));
        mipage.verifyMITemplateTableContent(miLocators.miFETableHeader, miLocators.miFETableData, expectedValues);
    }
}
