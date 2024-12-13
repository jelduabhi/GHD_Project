package org.govstack.pom.bidsTender.locators;

import org.govstack.pom.cms.news.locators.InitElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BTLocators extends InitElements {

    @FindBy(xpath = "(//button[@id='settings-menu-control'])[1]")
    public WebElement btSideMenu;

    @FindBy(xpath = "(//a[normalize-space()='Team Members'])[1]")
    public WebElement btTeamMemberList;

    @FindBy(xpath = "//button[@id='btnAddMember']")
    public WebElement btAddTeamMemberBtn;

    @FindBy(xpath = "//input[@id='inputFirstName']")
    public WebElement btGivenNameField;

    @FindBy(xpath = "//input[@id='inputLastName']")
    public WebElement btLastNameField;

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement btEmailTextField;

    @FindBy(xpath = "//input[@id='inputPassword1']")
    public WebElement btPasswordTextField;

    @FindBy(xpath = "//input[@id='inputPassword2']")
    public WebElement btConfirmPasswordTextField;

    @FindBy(xpath = "//span[normalize-space()='Full Access']")
    public WebElement btFulAccessCheckbox;

    @FindBy(xpath = "//span[normalize-space()='Procurement Lead']")
    public WebElement btProcurementLeadCheckbox;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement btAddMemberSubmitBtn;

    @FindBy(xpath = "//input[@id='filterTeamMembers']")
    public WebElement btSearchTeamMember;

    @FindBy(xpath = "//td[contains(.,'stage-automation_bt_')]")
    public WebElement btSearchTeamFilter;

    @FindBy(xpath = "//div[@id='Projects']")
    public WebElement btProjectTab;

    @FindBy(xpath = "//span[normalize-space()='Create a project']")
    public WebElement btCreateProjectLinkText;

    @FindBy(xpath = "//span[normalize-space()='Find a project']")
    public WebElement btSearchProjectLink;

    @FindBy(xpath = "//a[@id='project_new']")
    public WebElement btCreateNewProCard;

    @FindBy(xpath = "//a[@id='project_type_source']")
    public WebElement btProTypeSourceCard;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Next'])[1]")
    public WebElement btNextBtn;

    @FindBy(xpath = "//input[@id='projectName']")
    public WebElement btProNameField;

    @FindBy(xpath = "//input[@id='projectDepartment']")
    public WebElement btProDepttDropdown;

    @FindBy(xpath = "//li[@id='projectDepartment-0']")
    public WebElement btProDepttOne;

    @FindBy(xpath = "//input[@id='divisionCategory']")
    public WebElement btProDivisionDropdown;

    @FindBy(xpath = "//li[@id='divisionCategory-0']")
    public WebElement btProDivCatOne;

    @FindBy(xpath = "(//span[@class='app-radio-content'][normalize-space()='No'])[1]")
    public WebElement btHasProjectAnotherRadiobtn;

    @FindBy(xpath = "(//span[@class='app-radio-content'][normalize-space()='No'])[2]")
    public WebElement btHasCoprProjectRadiobtn;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Continue'])[2]")
    public WebElement btProDetailsContinueBtn;


    @FindBy(xpath = "//a[@id='source_method_invitational']")
    public WebElement btInvitationalCard;

    @FindBy(xpath = "//div[@aria-label='project_type select']")
    public WebElement btProTypeDropdown;

    @FindBy(xpath = "//span[normalize-space()='RFP']")
    public WebElement btProTypeDropdownListRFP;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Continue'])[3]")
    public WebElement btProMethodContinueBtn;

    @FindBy(xpath = "//span[normalize-space()='Online']")
    public WebElement btOnlineRadiobtn;

    @FindBy(xpath = "(//span[contains(text(),'Yes')])[3]")
    public WebElement btMultipleSubmissionRadiobtn;

    @FindBy(xpath = "(//label[@aria-label='No'])[4]")
    public WebElement btPlantakerRadiobtn;

    @FindBy(xpath = "(//label[@aria-label='No'])[7]")
    public WebElement btBidResRadiobtn;

    @FindBy(xpath = "//a[@id='documents_unsealed']")
    public WebElement btDocUnsealedCard;

    @FindBy(xpath = "//input[@id='resultsDisplay']")
    public WebElement btRstDisplayDropdown;

    @FindBy(xpath = "//li[@id='resultsDisplay-1']")
    public WebElement btRstDisplayDropdownOne;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Continue'])[4]")
    public WebElement btSourceCriteriaScreenOneContBtn;


    @FindBy(xpath = "(//label[@aria-label='No'])[8]")
    public WebElement btDisRegRadiobtn;

    @FindBy(xpath = "(//label[@aria-label='No'])[9]")
    public WebElement btDeadlineRadiobtn;

    @FindBy(xpath = "(//label[@aria-label='No'])[11]")
    public WebElement btIrrecoverPerRadiobtn;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Continue'])[5]")
    public WebElement btSourceCriteriaScreenTwoContBtn;

    @FindBy(xpath = "(//label[@aria-label='No'])[12]")
    public WebElement btTrackSubmissionRadiobtn;

    @FindBy(xpath = "(//label[@aria-label='No'])[13]")
    public WebElement btProMeetingRadiobtn;

    @FindBy(xpath = "(//label[@aria-label='No'])[14]")
    public WebElement btTradeAggrementRadiobtn;

    @FindBy(xpath = "(//label[@aria-label='No'])[15]")
    public WebElement btEvaluateRadiobtn;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Continue'])[6]")
    public WebElement btSourceCriteriaScreenThreeContBtn;

    @FindBy(xpath = "(//p[@class='is-size-2 has-margin-bottom-small'])[1]")
    public WebElement btProjectSuccess;

    @FindBy(xpath = "(//button[@id='search_projects'])[1]")
    public WebElement btSearchProjectBtn;

    @FindBy(xpath = "//input[@id='filterTerm']")
    public WebElement btSearchProjectFilterField;

    @FindBy(xpath = "//button[@class='has-no-minWidth is-fullwidth button app-button is-primary']")
    public WebElement btSearchProjectFilterBtn;

    @FindBy(xpath = "//label[@id='projectNumberAutoGenerate']")
    public WebElement btAutogeneratePro;

    @FindBy(xpath = "(//a[normalize-space()=\"Evaluator's Portal\"])[1]")
    public WebElement btEvaluatorPortalLinkText;

    @FindBy(xpath = "//a[@aria-label='Navigate to Log out Page']")
    public WebElement btLogoutLinkText;

    @FindBy(xpath = "//a[@aria-label='Create Vendor Link']")
    public WebElement btCreatAccLinkBtn;

    @FindBy(xpath = "//a[@aria-label='Vendor Login Link']")
    public WebElement btSupplierLoginLinkBtn;

    @FindBy(xpath = "//input[@id='Username']")
    public WebElement btSupplierLoginEmailField;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement btSupplierLoginPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btSupplierLoginbtn;

    @FindBy(xpath = "(//a[normalize-space()='Manage Account'])[1]")
    public WebElement btSupplierManageAccLinkText;

    @FindBy(xpath = "//input[@id='CompanyName']")
    public WebElement btCompanyNameField;

    @FindBy(xpath = "//input[@id='RelevantName']")
    public WebElement btRelevantNameField;

    @FindBy(xpath = "//input[@id='Address1']")
    public WebElement btAddress1Field;

    @FindBy(xpath = "//input[@id='Address2']")
    public WebElement btAddress2Field;

    @FindBy(xpath = "//input[@id='City']")
    public WebElement btCityField;

    @FindBy(xpath = "//input[@id='PostalCode']")
    public WebElement btPostalCodeField;

    @FindBy(xpath = "//input[@id='ProvinceState']")
    public WebElement btStateField;

    @FindBy(xpath = "//input[@id='Country']")
    public WebElement btCountryField;

    @FindBy(xpath = "//input[@id='Website']")
    public WebElement btWebsiteField;

    @FindBy(xpath = "//input[@id='HstNumber']")
    public WebElement bthstField;

    @FindBy(xpath = "(//a[normalize-space()='Aggregates'])[1]")
    public WebElement btAggregateField;

    @FindBy(xpath = "(//input[@id='Contacts[0].FirstName'])[1]")
    public WebElement btContactFirstNameField;

    @FindBy(xpath = "(//input[@id='Contacts[0].LastName'])[1]")
    public WebElement btContactLastNameField;

    @FindBy(xpath = "(//input[@id='Contacts[0].Email'])[1]")
    public WebElement btContactEmailField;

    @FindBy(xpath = "(//input[@id='Contacts[0].EmailConfirm'])[1]")
    public WebElement btContactEmailConfirmField;

    @FindBy(xpath = "(//input[@id='Contacts[0].Password'])[1]")
    public WebElement btContactPasswordField;

    @FindBy(xpath = "(//input[@id='Contacts[0].PasswordConfirm'])[1]")
    public WebElement btContactPasswordConfirmField;

    @FindBy(xpath = "(//input[@id='Contacts[0].PhoneAreaCode'])[1]")
    public WebElement btContactAreaField;

    @FindBy(xpath = "(//input[@id='Contacts[0].PhonePrefix'])[1]")
    public WebElement btContactPhoneprefixField;

    @FindBy(xpath = "(//input[@id='Contacts[0].PhoneSuffix'])[1]")
    public WebElement btContactPhonesuffixField;

    @FindBy(xpath = "//input[@id='VendorTermAccepted']")
    public WebElement btContactTermsCheckbox;

    @FindBy(xpath = "//button[@id='btnVendorUpdate']")
    public WebElement btContactSubmitBtn;

    @FindBy(xpath = "//div[@id='modalContent']")
    public WebElement btSupplierModalContent;

    @FindBy(xpath = "//div[@class='row-data row-data-projectNumber']/div/a")
    public WebElement btProjectGrid;

    @FindBy(xpath = "//span[normalize-space()='Team']")
    public WebElement btProAssignTeamLink;

    @FindBy(xpath = "//span[normalize-space()='Add Team Member']")
    public WebElement btProAssignAddTeamBtn;

    @FindBy(xpath = "//input[@id='member-search']")
    public WebElement btProAssignSearch;

    @FindBy(xpath = "//ul[@class='team-members-list']/li[1]")
    public WebElement btProAssignSearchTeamList;

    @FindBy(xpath = "//span[normalize-space()='Project Team Member']")
    public WebElement btProAssignCheckbox;

    @FindBy(xpath = "(//span[normalize-space()='Add'])[1]")
    public WebElement btProAssignAddBtn;

    @FindBy(xpath = "//span[normalize-space()='Copy intake request URL']")
    public WebElement btCopyIntakeUrl;

    @FindBy(xpath = "//span[@class='app-button-inner']")
    public WebElement intakeStartbtn;

    @FindBy(xpath = "//input[@id='contactFirstName']")
    public WebElement intakeFirstName;

    @FindBy(xpath = "//input[@id='contactLastName']")
    public WebElement intakeLastName;

    @FindBy(xpath = "//input[@id='contactEmail']")
    public WebElement intakeEmail;

    @FindBy(xpath = "//input[@id='contactSelDepartment']")
    public WebElement intakeDepttDropdown;

    @FindBy(xpath = "//span[normalize-space()='Department One']")
    public WebElement intakeDepttDropdownList;

    @FindBy(xpath = "//input[@id='contactSelDivision']")
    public WebElement intakeDivDropdown;

    @FindBy(xpath = "//span[normalize-space()='Division 1']")
    public WebElement intakeDivDropdownList;

    @FindBy(xpath = "//input[@id='contactSelLead']")
    public WebElement intakecontactLeadDropdown;

    @FindBy(xpath = "//span[normalize-space()='Not sure']")
    public WebElement intakecontactLeadDropdownList;

    @FindBy(xpath = "(//span[normalize-space()='Next'])[1]")
    public WebElement intakeCommNextBtn;


    @FindBy(xpath = "//input[@id='projDetailsProjectName']")
    public WebElement intakeProName;

    @FindBy(xpath = "//span[normalize-space()='Services']")
    public WebElement intakeProServiceRadioBtn;

    @FindBy(xpath = "//div[@aria-label='Editor editing area: main. Press Alt+0 for help.']")
    public WebElement intakeProDescriptionTextArea;

    @FindBy(xpath = "//input[@id='projDetailsBidType']")
    public WebElement intakeProBidTypeDropdown;

    @FindBy(xpath = "//li[contains(.,'RFP')]")
    public WebElement intakeProBidTypeDropdownList;

    @FindBy(xpath = "//span[normalize-space()='No']")
    public WebElement intakeProSitevisit;

    @FindBy(xpath = "//input[@id='projValueAnnualValue']")
    public WebElement intakeProAnnualValue;

    @FindBy(xpath = "//input[@id='projValueTotalValue']")
    public WebElement intakeProTotalValue;

    @FindBy(xpath = "(//span[normalize-space()='Submit'])[1]")
    public WebElement intakeSubmitBtn;

    @FindBy(xpath = "//h1[normalize-space()='Congratulations']")
    public WebElement intakeSuccessText;

    @FindBy(xpath = "//span[normalize-space()='Go to bids&tenders website']")
    public WebElement intakebtWebsiteBtn;

    @FindBy(xpath = "(//a[@id='project_type_contract'])[1]")
    public WebElement startContractCards;


    @FindBy(xpath = "(//label[@aria-label='No'])[16]")
    public WebElement termcontract;

    @FindBy(xpath = "(//label[@aria-label='No'])[18]")
    public WebElement contractWarrantyPeriod;

    @FindBy(xpath = "(//label[@aria-label='No'])[19]")
    public WebElement contractPricingPeriod;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Continue'])[7]")
    public WebElement contractContinueBtnOne;


    @FindBy(xpath = "(//label[@id='vendorDocuments'])[1]")
    public WebElement contractDocPref;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Continue'])[8]")
    public WebElement contractContinueBtnTwo;

    @FindBy(xpath = "//a[contains(text(),'Contract')]")
    public WebElement contractTabSelect;

    @FindBy(xpath = "//td[@class='available today']/div/span")
    public WebElement contractStarCurrentDate;

    @FindBy(xpath = "//input[@id='contractDatesDateOpen0']")
    public WebElement contractTabStrDateBtn;

    @FindBy(xpath = "//input[@id='contractDatesDateClosing0']")
    public WebElement contractTabEndDateBtn;

    @FindBy(xpath = "//input[@id='datesProjectValue']")
    public WebElement contractTabProValue;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement contractBtmSaveBtn;

    @FindBy(xpath = "//a[@data-path='/suppliers']")
    public WebElement contractSplTab;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Add Suppliers'])[1]")
    public WebElement contractAddSplBtn;

    @FindBy(xpath = "//input[@id='contractSuppliersAddSupplierSuppliers']")
    public WebElement supplierDropdown;

    @FindBy(xpath = "//p[normalize-space()='stage-automationtester.kk@gmail.com']")
    public WebElement supplierDropdownList;

    @FindBy(xpath = "//button[@id='contractSuppliersAddSupplierAdd']")
    public WebElement addSupplierBtn;

    @FindBy(xpath = "(//span[normalize-space()='Start Contract'])[1]")
    public WebElement startContractBtn;

    @FindBy(xpath = "(//span[normalize-space()='Close Contract'])[1]")
    public WebElement closeContractBtn;

    @FindBy(xpath = "(//span[normalize-space()='Find a project'])[1]")
    public WebElement btFindProjectLinkText;

    @FindBy(xpath = "//span[normalize-space()='Saved Searches']")
    public WebElement savedProjectTab;

    @FindBy(xpath = "(//div[@class='app-title-content'])[2]//h3")
    public WebElement savedProjectList;

    @FindBy(xpath = "//span[normalize-space()='Apply Search']")
    public WebElement savedProApplySearchBtn;

    @FindBy(xpath = "//span[@class='is-flex is-aligned-center is-flex-wrap']")
    public WebElement intakeResultGridList;

    @FindBy(xpath = "(//span[normalize-space()='06_intake'])[1]")
    public WebElement intakeProNumber;

    @FindBy(xpath = "//span[normalize-space()='Manage']")
    public WebElement intakeManageBtnGrid;

    @FindBy(xpath = "//span[normalize-space()='Print request to PDF']")
    public WebElement intakePrintPdfBtn;

    @FindBy(xpath = "(//span[@class='app-button-inner'][normalize-space()='Manage'])[1]")
    public WebElement intakeDashManageBtn;

    @FindBy(xpath = "(//li[normalize-space()='Approve'])[1]")
    public WebElement intakeViewDashBtn;

    @FindBy(xpath = "(//td[@class='el-table_4_column_21 is-left  el-table__cell']/div)[1]")
    public WebElement intakeCellValue;

    @FindBy(xpath = "//input[@id='filterRequests']")
    public WebElement intakeSearchFilterField;

    @FindBy(xpath = "(//span[normalize-space()='Confirm'])[1]")
    public WebElement intakeConfirmDashBtn;

    @FindBy(xpath = "//input[@id='teamLead']")
    public WebElement intakeProLeadDropdown;

    @FindBy(xpath = "//li[@id='teamLead-0']//span[contains(text(),'Automation User')]")
    public WebElement intakeProLeadDropdownList;

    @FindBy(xpath = "//h3[normalize-space()='Intake: pending requests']")
    public WebElement intakeHeading;
    @FindBy(xpath = "//input[@id='filterRequests']")
    public WebElement intakeSearchReq;
    @FindBy(xpath = "//div[contains(@class,'intake-essentials-widget has-margin-top-small has-padding-top')]//table[contains(@class,'el-table__body')]//td")
    public List<WebElement> intakeTD;

    public WebElement getManageMenu(WebElement ele) {
        return ele.findElement(By.xpath("following::button[contains(@type,'text')]//span[normalize-space()='Manage']"));
    }
@FindBy(xpath = "//span[contains(text(),'Manage')]/parent::button")
public WebElement intakeManageBtn;
    @FindBy(xpath = "/html[1]/body[1]/ul[1]//li")
    public List<WebElement> intakeManageList;
    @FindBy(xpath = "//button[@class='has-full-width button-intake-decline button app-button is-danger']")
    public WebElement intakeDeclineBtn;
    @FindBy(xpath = "//div[@class='el-dialog__wrapper intake-decline-modal']")
    public WebElement intakeDeclineDialogue;
    @FindBy(xpath = "//p[@class='ck-placeholder']")
    public WebElement intakeDeclineText;
    @FindBy(xpath = "//button[contains(.,'Decline request')]")
    public WebElement intakeDeclineReqBtn;
    @FindBy(xpath = "//div[@class='el-notification right']")
    public WebElement intakeDeclineToastMsgDialogue;
    @FindBy(xpath = "//button//span[contains(text(),'View declined comment')]")
    public WebElement intakeViewdeclinedcommentBtn;
    @FindBy(xpath = "//p[@data-placeholder='Start typing...']")
    public WebElement intakeViewdeclinedcomment;
    @FindBy(xpath = "(//span[text()='Download']/parent::span/parent::button)[2]")
    public WebElement intakePrintBtn;
    @FindBy(xpath = "//table[@class='el-table__body']/tbody/tr[1]/td[2]")
    public WebElement projectlbl;
    @FindBy(xpath = "//table[@class='el-table__body']/tbody/tr[1]/td[2]/div/div/div[2]/button")
    public WebElement manageBtn;

    /**
     * Details Page
     */
    @FindBy(xpath = "//span[@class='app-subnav-item-content']/div[contains(text(),'Details')]")
    public WebElement detailsLnk;
    @FindBy(id = "detailsInternalReferenceNumber")
    public WebElement detailsInternalReferenceNumber;
    @FindBy(xpath = "//span[text()='Goods']")
    public WebElement goodsBtn;
    @FindBy(id = "detailsProjectEstimatedValue")
    public WebElement detailsProjectEstimatedValue;
    @FindBy(id = "detailsProjectAnnualValue")
    public WebElement detailsProjectAnnualValue;
    @FindBy(xpath = "//p[@class='ck-placeholder']")
    public WebElement descriptionTxt;
    @FindBy(xpath = "//input[@aria-label=\"search\"]")
    public WebElement categryTxt;
    @FindBy(xpath = "//button[@class='app-tree-filter__actions__search button app-button is-text']")
    public WebElement searchBtn;
    @FindBy(xpath = "//span[text()='Equipment']/parent::div/label/span")
    public WebElement foodChkBox;
    @FindBy(id = "detailsProjectOnlinePrice")
    public WebElement detailsProjectOnlinePrice;
    @FindBy(id = "detailsProjectShippingPrice")
    public WebElement detailsProjectShippingPrice;
    @FindBy(id = "detailsProjectPickupPrice")
    public WebElement detailsProjectPickupPrice;
    @FindBy(id = "detailsTax")
    public WebElement detailsTax;
    @FindBy(id = "detailsProjectShippingTax")
    public WebElement detailsProjectShippingTax;
    @FindBy(id = "detailsProjectPickupTax")
    public WebElement detailsProjectPickupTax;
    @FindBy(xpath="(//li[contains(text(),'HST')])[3]")
    public WebElement taxOption;
    @FindBy(xpath = "//span[contains(text(),'Save')]/parent::button[@type='secondary']")
    public WebElement saveBtn;

    /**
     * Documents Page
     */
    @FindBy(xpath = "//span[@class='app-subnav-item-content']/div[contains(text(),'Documents')]")
    public WebElement documentsLnk;
    @FindBy(xpath = "//div[contains(text(),'Drop file here or click to upload')]")
    public WebElement uploadBtn;
    @FindBy(id = "documentUploadDocumentDisplayName")
    public WebElement documentUploadDocumentDisplayName;
    @FindBy(id = "documentUploadDocumentPages")
    public WebElement documentUploadDocumentPages;
    @FindBy(id = "documentUploadDocumentType")
    public WebElement documentUploadDocumentType;
    @FindBy(id = "documentUploadUploadButton")
    public WebElement documentUploadUploadButton;
    @FindBy(xpath = "//table[@class='el-table__body']/tbody/tr[1]/td[2]/div")
    public WebElement displayNameInTable;

    /**
     * Submission Requirements Page
     */
    @FindBy(xpath = "//span[@class='app-subnav-item-content']/div[contains(text(),'Submission Requirements')]")
    public WebElement submissionRequirementsLnk;
    @FindBy(xpath = "//span[text()='Schedule of Prices']/parent::label/span[1]")
    public WebElement scheduleOfPricesChkBox;
    @FindBy(xpath = "//div[contains(text(),'Schedule of Prices')]/parent::a")
    public WebElement scheduleOfPricesLnk;
    @FindBy(xpath = "//span[contains(text(),'Create Form')]/parent::button")
    public WebElement createFormBtn;
    @FindBy(id = "tableName")
    public WebElement formName;
    @FindBy(xpath = "//button[@class='is-close-button button app-button is-text']")
    public WebElement closeBtn;
    @FindBy(xpath = "//table[@class='el-table__body']/tbody/tr[1]/td[1]/div")
    public WebElement formNameInTable;
    @FindBy(xpath = "//div[contains(text(),'Terms and Conditions')]/parent::a")
    public WebElement termsAndConditionsLnk;
    @FindBy(id = "srTermsUniqueTitle")
    public WebElement srTermsUniqueTitle;
    @FindBy(id = "srTermsTermsConditionsTextSelection")
    public WebElement srTermsTermsConditionsTextSelection;
    @FindBy(xpath = "//span[text()='Highlight Sample Template']")
    public WebElement termsAndConditionsDropDown;
    @FindBy(xpath="//span[contains(text(),'Form Layout')]")
    public WebElement formLayoutLnk;
    @FindBy(xpath = "//th[@class]/div")
    public List<WebElement> tableColumn;
    @FindBy(xpath = "//div[@class='column-name el-input']/input")
    public WebElement titleTxt;
    @FindBy(xpath = "//div[@class='app-select column-type has-no-label']/div/div/input")
    public WebElement columnType;
    @FindBy(xpath="//input[@value=\"Bidder Input\"]/parent::span/span")
    public WebElement bidderInputChk;

    /**
     * Invitation Page
     */
    @FindBy(xpath = "//span[@class='app-subnav-item-content']/div[contains(text(),'Invitations')]")
    public WebElement invitationLnk;
    @FindBy(id = "tab-3")
    public WebElement searchCriteria;
    @FindBy(xpath = "//input[@aria-label='search']")
    public WebElement searchTxt;
    @FindBy(xpath = "//span[contains(text(),'Search')]/parent::button[@class='app-tree-filter__actions__search button app-button is-text']")
    public WebElement searchLnk;
    @FindBy(xpath = "(//label[@aria-label=\"Yes\"]/input[contains(@id,'controlId')]/following-sibling::span[2])[1]")
    public WebElement emergencySupplier_Yes;
    @FindBy(xpath = "(//label[@aria-label=\"Yes\"]/input[contains(@id,'controlId')]/following-sibling::span[2])[2]")
    public WebElement certifiedDiverseSupplier_Yes;
    @FindBy(xpath = "//input[@id=\"supplierDiversityClassification\"]")
    public WebElement supplierDiversityClassification;
    @FindBy(id = "invitations_search_by_criteria_search")
    public WebElement searchButton;
    @FindBy(xpath = "//table[@class='el-table__body']/tbody/tr[1]/td[1]")
    public WebElement categorySelect;
    @FindBy(xpath = "(//span[contains(text(),'Add')]/parent::button)[1]")
    public WebElement addButton;
    @FindBy(xpath = "(//h4[@class='app-title-heading is-size-4'])[1]")
    public WebElement invitationCheck;

    /**
     * Dates Page
     */
    @FindBy(xpath = "//span[@class='app-subnav-item-content']/div[contains(text(),'Dates')]")
    public WebElement DatesLnk;
    @FindBy(id = "date-sent")
    public WebElement publishDateSent;
    @FindBy(xpath = "//table[@class='el-date-table']/tbody/tr/td[@class='available']/div/span")
    public List<WebElement> dates;
    @FindBy(xpath = "//table[@class='el-date-table']/tbody/tr/td[@class='available today']/div/span")
    public WebElement todayDate;
    @FindBy(id = "bid-pub-date")
    public WebElement bidOpenDate;
    @FindBy(id = "bid-pub-date-time")
    public WebElement bitOpenTime;
    @FindBy(xpath = "//div[@class='el-time-panel__content']/div/div[1]/div/ul/li")
    public WebElement timeList;
    @FindBy(xpath = "//div[@class='el-time-panel__content']/div/div[1]/div/ul/li")
    public WebElement secondsList;

    @FindBy(id = "bid-close")
    public WebElement closeDate;
    @FindBy(xpath = "//span[contains(text(),'Publish')]/parent::button")
    public WebElement publishBtn;
    @FindBy(xpath = "(//span[contains(text(),'Publish')]/parent::button)[2]")
    public WebElement publishFinalBtn;
    @FindBy(xpath = "//div[@class='project-status__container-wrapper']")
    public WebElement statusLable;
    @FindBy(xpath = "(//button[@class='has-margin-right-small button app-button is-primary has-min-width']/span)[3]")
    public WebElement yesButton;

    @FindBy(xpath = "//a[contains(text(),'Source')]")
    public WebElement sourceLink;
    @FindBy(xpath = "//a[@class='app-subnav-item has-noIcon has-path']")
    public WebElement quesAndAddendaLnk;
    @FindBy(id="tab-1")
    public WebElement AddendaLnk;
    @FindBy(xpath = "(//span[contains(text(),'Upload')])[1]")
    public WebElement uploadBtnAddedBtn;
    @FindBy(id = "questionsAddendaAddendumName")
    public WebElement questionsAddendaAddendumName;
    @FindBy(xpath = "(//span[contains(text(),'Browse')])[1]")
    public WebElement browseBtn;
    @FindBy(xpath = "(//span[contains(text(),'Save')])[4]")
    public WebElement uploadSaveBtn;

    @FindBy(xpath = "//a[@class='app-subnav-item has-noIcon']")
    public WebElement submissionLnk;
    @FindBy(xpath = "(//span[contains(text(),'Export')]/parent::button)[1]")
    public WebElement exportBtn;
}

