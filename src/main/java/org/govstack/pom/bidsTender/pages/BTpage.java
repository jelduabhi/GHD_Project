package org.govstack.pom.bidsTender.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.bidsTender.locators.BTLocators;
import org.govstack.utils.CommonMethods;
import org.govstack.webdriver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BTpage extends WebDriverManager {
    WebDriver driver = getDriver();
    CommonMethods methods = new CommonMethods();
    BTLocators btLoc = new BTLocators();

    public void btSideBarMenu() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.btSideMenu);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btTeamMemberList);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Bids and Tenders side bar menu clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail();
        }
    }

    public void btAddTeamMember() {
        try {
            methods.waitForElement(4);
            if (methods.isElementPresent(btLoc.btAddTeamMemberBtn)) {
                methods.waitForElement(4);
                methods.clickElement(btLoc.btAddTeamMemberBtn);
                methods.waitForElement(2);
                methods.sendTextToElement(btLoc.btGivenNameField, TestData.getData("GivenName") + "_" + methods.generateRandomString());
                methods.sendTextToElement(btLoc.btLastNameField, TestData.getData("LastName") + "_" + methods.generateRandomString());
                methods.sendTextToElement(btLoc.btEmailTextField, TestData.getData("Email") + "_" + methods.generateRandomString() + "@yopmail.com");
                methods.sendTextToElement(btLoc.btPasswordTextField, TestData.getData("Password"));
                methods.sendTextToElement(btLoc.btConfirmPasswordTextField, TestData.getData("ConfirmPassword"));
                methods.waitForElement(2);
                methods.clickElement(btLoc.btProcurementLeadCheckbox);
                methods.clickElement(btLoc.btFulAccessCheckbox);
                methods.waitForElement(2);
                methods.clickElement(btLoc.btAddMemberSubmitBtn);
                methods.waitForElement(4);
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Add team member button visible team member created");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Bids and Tenders side bar menu clicked");
                Assert.fail("Add team member button not displayed unable to create a new team member");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail();
        }
    }


    public void btSearchTeamMemberAssertion() {
        try {
            methods.waitForElement(3);
            methods.sendTextToElement(btLoc.btSearchTeamMember, TestData.getData("Validation"));
            methods.waitForElement(4);
            if (methods.isElementPresent(btLoc.btSearchTeamFilter)) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Team member search filter working properly");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Unable to search team member");
                Assert.fail("failed to search team member in listing grid");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to search team member in listing grid");
        }
    }

    public void btProjectSetupTab() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.btProjectTab);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btCreateProjectLinkText);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Bids and Tenders Project tab clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Bids and Tenders Project tab");
        }
    }

    public void btSearchProject(String project) {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.btProjectTab);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btSearchProjectLink);
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.btSearchProjectFilterField, project);
            methods.waitForElement(2);
            methods.scrollAndClickElement(btLoc.btSearchProjectFilterBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Project Searched");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Bids and Tenders Project tab");
        }
    }

    public void btStartProject() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.btCreateNewProCard);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btProTypeSourceCard);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btNextBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "New project card selected and working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click cards to create a new project");
        }
    }

    public void btStartContractProject() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.btCreateNewProCard);
            methods.waitForElement(2);
            methods.clickElement(btLoc.startContractCards);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btNextBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Contract card selected and working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click cards to create a new Contract");
        }
    }

    public void btProjectDetails() {
        try {
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.btProNameField, TestData.getData("ProjectName") + "_" + methods.generateRandomString());
            methods.clickElement(btLoc.btAutogeneratePro);
            methods.clickElement(btLoc.btProDepttDropdown);
            methods.clickElement(btLoc.btProDepttOne);
            methods.clickElement(btLoc.btProDivisionDropdown);
            methods.waitForElement(1);
            methods.clickElement(btLoc.btProDivCatOne);
            methods.waitForElement(1);
            methods.scrollAndClickElement(btLoc.btHasProjectAnotherRadiobtn);
            methods.waitForElement(1);
            methods.scrollAndClickElement(btLoc.btHasCoprProjectRadiobtn);
            methods.waitForElement(1);
            methods.clickElement(btLoc.btProDetailsContinueBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Project details added successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to add project details");
        }
    }

    public void btProcurementMethod() {
        try {
            methods.waitForElement(2);
            methods.clickElement(btLoc.btInvitationalCard);
            methods.waitForElement(1);
            methods.clickElement(btLoc.btProTypeDropdown);
            methods.waitForElement(1);
            methods.clickElement(btLoc.btProTypeDropdownListRFP);
            methods.waitForElement(1);
            methods.clickElement(btLoc.btProMethodContinueBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Procurement method details added properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to add Procurement method details");
        }
    }

    public void btSourceCriteriaScreenOne() {
        try {
            methods.waitForElement(2);
            methods.clickElement(btLoc.btOnlineRadiobtn);
            methods.clickElement(btLoc.btMultipleSubmissionRadiobtn);
            methods.clickElement(btLoc.btPlantakerRadiobtn);
            methods.scrollAndClickElement(btLoc.btBidResRadiobtn);
            methods.clickElement(btLoc.btDocUnsealedCard);
            methods.scrollAndClickElement(btLoc.btRstDisplayDropdown);
            methods.clickElement(btLoc.btRstDisplayDropdownOne);
            methods.scrollAndClickElement(btLoc.btSourceCriteriaScreenOneContBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Source criteria screen one details added properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to add Source criteria screen one");
        }
    }

    public void btSourceCriteriaScreenTwo() {
        try {
            methods.waitForElement(2);
            methods.clickElement(btLoc.btDisRegRadiobtn);
            methods.waitForElement(1);
            methods.clickElement(btLoc.btDeadlineRadiobtn);
            methods.clickElement(btLoc.btIrrecoverPerRadiobtn);
            methods.scrollAndClickElement(btLoc.btSourceCriteriaScreenTwoContBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Source criteria screen two details added properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to add Source criteria screen two");
        }
    }

    public void clickManageButton() {
        methods.waitForElement(4);
        methods.moveToElement(btLoc.projectlbl);
        methods.javaScriptClickElement(btLoc.manageBtn);
        methods.waitForElement(5);
    }

    public void enterDetails() {
        try {
            methods.clickElement(btLoc.detailsLnk);
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.detailsInternalReferenceNumber, String.valueOf(methods.generateRandomNumber()));
            methods.waitForElement(2);
            methods.scrollToElement(btLoc.goodsBtn);
            methods.clickElement(btLoc.goodsBtn);
            methods.sendTextToElement(btLoc.detailsProjectEstimatedValue, TestData.getData("Estimated Total Contract Value"));
            methods.sendTextToElement(btLoc.detailsProjectAnnualValue, TestData.getData("Estimated Annual Contract Value"));
            methods.sendTextToElement(btLoc.descriptionTxt, TestData.getData("Description"));
            methods.sendTextToElement(btLoc.categryTxt, TestData.getData("Categories"));
            methods.clickElement(btLoc.searchBtn);
            methods.waitForElement(3);
            methods.clickElement(btLoc.foodChkBox);
            methods.moveToElement(btLoc.detailsProjectOnlinePrice);
            methods.sendTextToElement(btLoc.detailsProjectOnlinePrice, TestData.getData("Online Price"));
            methods.scrollToElement(btLoc.detailsProjectShippingPrice);
            methods.sendTextToElement(btLoc.detailsProjectShippingPrice, TestData.getData("Shipping Price"));
            methods.sendTextToElement(btLoc.detailsProjectPickupPrice, TestData.getData("Pickup Price"));
//            methods.clickElement(btLoc.detailsTax);
//            methods.clearElementInput(btLoc.taxOption);
//            methods.clickElement(btLoc.detailsProjectShippingTax);
//            methods.clearElementInput(btLoc.taxOption);
//            methods.clickElement(btLoc.detailsProjectPickupTax);
//            methods.clearElementInput(btLoc.taxOption);
            methods.clickElement(btLoc.saveBtn);
            methods.waitForElement(5);
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to enter details " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void enterDocumentsDetails() {
        try {
            methods.clickElement(btLoc.documentsLnk);
            methods.waitForElement(3);
            methods.clickElement(btLoc.uploadBtn);
            methods.waitForElement(5);
            methods.uploadDocument(ConfigurationManager.getPropertyValue("BT_DOCUMENT"));
            String documentName = TestData.getData("Document Display Name") + "_" + methods.generateRandomString();
            methods.sendTextToElement(btLoc.documentUploadDocumentDisplayName, documentName);
            methods.sendTextToElement(btLoc.documentUploadDocumentPages, TestData.getData("Page Count"));
            methods.scrollToElement(btLoc.documentUploadDocumentType);
            methods.clickElement(btLoc.documentUploadDocumentType);
            methods.waitForElement(2);
            methods.selectValueFromList(TestData.getData("Document Type"));
            methods.clickElement(btLoc.documentUploadUploadButton);
            methods.waitForElement(3);
            if (methods.getElementText(btLoc.displayNameInTable).equals(documentName)) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "Document Uploaded");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Document Uploaded");
                Assert.fail();
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to upload a document " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void enterSubmissionRequirementDetails() {
        methods.clickElement(btLoc.submissionRequirementsLnk);
        methods.waitForElement(3);
        methods.clickElement(btLoc.scheduleOfPricesChkBox);
        methods.clickElement(btLoc.saveBtn);
        methods.waitForElement(3);
        methods.clickElement(btLoc.scheduleOfPricesLnk);
        methods.waitForElement(3);
        methods.clickElement(btLoc.createFormBtn);
        String formName = TestData.getData("Form Name") + "_" + methods.generateRandomString();
        methods.waitForElement(2);
        methods.sendTextToElement(btLoc.formName, formName);
        //  enterFormLayoutDetails();
        methods.clickElement(btLoc.saveBtn);
        methods.waitForElement(7);
        methods.clickElement(btLoc.closeBtn);
        methods.waitForElement(3);
        if (methods.getElementText(btLoc.formNameInTable).equals(formName)) {
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "Schedule of Prices created");
        } else {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Schedule of Prices is not created");
            Assert.fail();
        }
        methods.clickElement(btLoc.termsAndConditionsLnk);
        methods.waitForElement(2);
        methods.sendTextToElement(btLoc.srTermsUniqueTitle, TestData.getData("Terms and Conditions Text"));
        methods.clickElement(btLoc.srTermsTermsConditionsTextSelection);
        methods.waitForElement(2);
        methods.clickElement(btLoc.termsAndConditionsDropDown);
        methods.clickElement(btLoc.saveBtn);
        methods.waitForElement(3);
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "Terms and conditions entered");
    }

    public void enterFormLayoutDetails() {
        methods.clickElement(btLoc.formLayoutLnk);
        methods.waitForElement(2);
        for (int i = 3; i < 7; i++) {
            methods.clickElement(getDriver().findElement(By.xpath("(//th[@class]/div)[" + i + "]")));
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.titleTxt, TestData.getData("Column Type_" + i));
            methods.clickElement(btLoc.columnType);
            methods.selectValueFromSpanText(TestData.getData("Column Type_" + i));
            methods.clickElement(btLoc.bidderInputChk);
        }
        methods.clickElement(btLoc.saveBtn);
        methods.waitForElement(3);
    }

    public void enterInvitationDetails() {
        methods.clickElement(btLoc.invitationLnk);
        methods.waitForElement(2);
        methods.clickElement(btLoc.searchCriteria);
        methods.waitForElement(2);
        methods.scrollToElement(btLoc.searchTxt);
        methods.scrollToElement(btLoc.searchTxt);
        methods.sendTextToElement(btLoc.searchTxt, TestData.getData("Categories"));
        methods.clickElement(btLoc.searchLnk);
        methods.waitForElement(3);
        methods.clickElement(btLoc.foodChkBox);
        methods.clickElement(btLoc.emergencySupplier_Yes);
        methods.clickElement(btLoc.certifiedDiverseSupplier_Yes);
        methods.scrollToElement(btLoc.supplierDiversityClassification);
        methods.clickElement(btLoc.supplierDiversityClassification);
        methods.waitForElement(1);
        methods.selectValueFromSpan(TestData.getData("Diversity Clasifications"));
        methods.clickElement(btLoc.searchButton);
        methods.waitForElement(3);
        methods.clickElement(btLoc.categorySelect);
        methods.scrollToElement(btLoc.addButton);
        methods.clickElement(btLoc.addButton);
        methods.clickElement(btLoc.categorySelect);
        methods.waitForElement(3);
        methods.clickElement(btLoc.saveBtn);
        methods.waitForElement(3);
        methods.scrollToElement(btLoc.searchCriteria);
        if (methods.isElementPresent(btLoc.invitationCheck)) {
            ExtentReporter.log(LogStatus.PASS, "Invitation Details is Entered");
        } else {
            ExtentReporter.log(LogStatus.FAIL, "Invitation Details is not Entered");
            Assert.fail("Invitation Details is not Entered");
        }
    }

    public void enterDateDetails() {
        methods.clickElement(btLoc.DatesLnk);
        methods.waitForElement(1);
        methods.clickElement(btLoc.publishDateSent);
        methods.waitForElement(1);
        String date = methods.getCurrentDate();
        if (date.startsWith("0")) {
            date = date.replace("0", "");
            date = date.replace(" ", "");
        }
        methods.clickElement(btLoc.todayDate);
        methods.waitForElement(1);
        methods.scrollToElement(btLoc.bidOpenDate);
        methods.clickElement(btLoc.bidOpenDate);
        methods.selectDateFrom_Calender(btLoc.dates, String.valueOf(Integer.parseInt(date) + 2));
        methods.waitForElement(1);
        methods.scrollToElement(btLoc.closeDate);
        methods.clickElement(btLoc.closeDate);
        methods.waitForElement(1);
        methods.selectDateFrom_Calender(btLoc.dates, String.valueOf(Integer.parseInt(date) + 3));
        methods.waitForElement(3);
        methods.clickElement(btLoc.saveBtn);
        methods.waitForElement(10);
    }

    public void btSourceCriteriaScreenThree() {
        try {
            methods.waitForElement(2);
            methods.clickElement(btLoc.btTrackSubmissionRadiobtn);
            methods.clickElement(btLoc.btProMeetingRadiobtn);
            methods.clickElement(btLoc.btTradeAggrementRadiobtn);
            methods.clickElement(btLoc.btEvaluateRadiobtn);
            methods.scrollAndClickElement(btLoc.btSourceCriteriaScreenThreeContBtn);
            methods.waitForElement(5);
            String text = methods.getElementText(btLoc.btProjectSuccess);
            methods.clickElement(btLoc.btSearchProjectBtn);
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.btSearchProjectFilterField, text);
            methods.waitForElement(2);
            methods.scrollAndClickElement(btLoc.btSearchProjectFilterBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Source criteria screen three details added properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to add Source criteria screen three");
        }
    }

    public void publishBT() {
        methods.clickElement(btLoc.publishBtn);
        methods.waitForElement(10);
        methods.clickElement(btLoc.publishFinalBtn);
        methods.clickElement(btLoc.yesButton);
        methods.waitForElement(3);
        if (methods.getElementText(btLoc.statusLable).contains("Scheduled to Publish")) {
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "BT published");
        } else {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "BT published");
            Assert.fail();
        }
    }

    public void enterQuesAndAddendaDetails() {
        try {
            methods.clickElement(btLoc.sourceLink);
            methods.waitForElement(2);
            methods.clickElement(btLoc.quesAndAddendaLnk);
            methods.waitForElement(2);
            methods.clickElement(btLoc.AddendaLnk);
            methods.waitForElement(2);
            methods.clickElement(btLoc.uploadBtnAddedBtn);
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.questionsAddendaAddendumName, "Automation");
            methods.clickElement(btLoc.browseBtn);
            methods.waitForElement(5);
            Robot robot = new Robot();
            String path = System.getProperty("user.dir") + ConfigurationManager.getPropertyValue("BT_DOCUMENT");
            methods.setClipboardData(path);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            methods.clickElement(btLoc.uploadSaveBtn);
            methods.waitForElement(15);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, "");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void downLodSubmission(){
        methods.clickElement(btLoc.submissionLnk);
        methods.waitForElement(2);
        methods.clickElement(btLoc.exportBtn);
        if(methods.isFileDownloaded()){
            ExtentReporter.log(LogStatus.PASS,"File Downloaded");
        }
    }
    public void btEvaluatorPortalLink() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.btSideMenu);
            methods.waitForElement(3);
            methods.clickElement(btLoc.btEvaluatorPortalLinkText);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Evaluator's Portal Link text clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Evaluator's Portal Link text");
        }
    }

    public void btSupplierAccountCreate() {
        try {
            methods.clickElement(btLoc.btLogoutLinkText);
            methods.waitForElement(3);
            methods.clickElement(btLoc.btCreatAccLinkBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Supplier account create button clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Supplier account create button");
        }
    }

    public void btSupplierAccountFormField() {
        try {
            methods.sendTextToElement(btLoc.btCompanyNameField, TestData.getData("CompanyNameField") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.btRelevantNameField, TestData.getData("RelevantNameField") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.btAddress1Field, TestData.getData("Address1Field"));
            methods.sendTextToElement(btLoc.btAddress2Field, TestData.getData("Address2Field"));
            methods.sendTextToElement(btLoc.btCityField, TestData.getData("CityField"));
            methods.sendTextToElement(btLoc.btPostalCodeField, TestData.getData("PostalCodeField"));
            methods.sendTextToElement(btLoc.btStateField, TestData.getData("StateField"));
            methods.sendTextToElement(btLoc.btCountryField, TestData.getData("CountryField"));
            methods.sendTextToElement(btLoc.btWebsiteField, TestData.getData("WebsiteField"));
            methods.sendTextToElement(btLoc.bthstField, TestData.getData("hstField"));
            methods.scrollAndClickElement(btLoc.btAggregateField);

            methods.sendTextToElement(btLoc.btContactFirstNameField, TestData.getData("ContactFirstNameField") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.btContactLastNameField, TestData.getData("ContactLastNameField") + "_" + methods.generateRandomString());
            String randomEmail = methods.generateRandomString();
            methods.sendTextToElement(btLoc.btContactEmailField, TestData.getData("ContactEmailField") + "_" + randomEmail + "@yopmail.com");
            methods.sendTextToElement(btLoc.btContactEmailConfirmField, TestData.getData("ContactEmailConfirmField") + "_" + randomEmail + "@yopmail.com");
            methods.sendTextToElement(btLoc.btContactPasswordField, TestData.getData("ContactPasswordField"));
            methods.sendTextToElement(btLoc.btContactPasswordConfirmField, TestData.getData("ContactPasswordConfirmField"));
            methods.sendTextToElement(btLoc.btContactAreaField, TestData.getData("ContactAreaField"));
            methods.sendTextToElement(btLoc.btContactPhoneprefixField, TestData.getData("ContactPhoneprefixField"));
            methods.sendTextToElement(btLoc.btContactPhonesuffixField, TestData.getData("ContactPhonesuffixField"));
            methods.clickElement(btLoc.btContactTermsCheckbox);
            //methods.clickElement(btLoc.btContactSubmitBtn);
            methods.waitForElement(8);

            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Supplier account create button clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Supplier account create button");
        }
    }

    public void btSupplierExistingAccount() {
        try {
            methods.clickElement(btLoc.btLogoutLinkText);
            methods.waitForElement(3);
            methods.clickElement(btLoc.btSupplierLoginLinkBtn);
            methods.sendTextToElement(btLoc.btSupplierLoginEmailField, TestData.getData("Email"));
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.btSupplierLoginPasswordField, TestData.getData("Password"));
            methods.clickElement(btLoc.btSupplierLoginbtn);
            methods.waitForElement(4);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Existing Supplier account Logged in successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to Login Existing Supplier account");
        }
    }

    public void btSupplierAccountEditFormField() {
        try {
            methods.clickElement(btLoc.btSupplierManageAccLinkText);
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.btRelevantNameField, TestData.getData("RelevantNameField") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.btAddress1Field, TestData.getData("Address1Field") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.btAddress2Field, TestData.getData("Address2Field") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.btContactFirstNameField, TestData.getData("ContactFirstNameField") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.btContactLastNameField, TestData.getData("ContactLastNameField") + "_" + methods.generateRandomString());
            methods.clickElement(btLoc.btContactSubmitBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Supplier details edited properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to edit supplier details");
        }
    }

    public void btSupplierAccountUpdateValidation() {
        try {
            methods.waitForElement(3);
            if (methods.getElementText(btLoc.btSupplierModalContent).contains("Update Successful.")) {
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Supplier details saved properly");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to save supplier details");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to save supplier details");
        }
    }

    public void btSelectProjectGrid() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.btProjectGrid);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Project selected and clicked from listing grid");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail();
        }
    }

    public void btAssignProjectTeamMember() {
        try {
            methods.waitForElement(2);
            methods.clickElement(btLoc.btProAssignTeamLink);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btProAssignAddTeamBtn);
            methods.sendTextToElement(btLoc.btProAssignSearch, "automation_bt_firstName_");
            methods.waitForElement(2);
            methods.clickElement(btLoc.btProAssignSearchTeamList);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btProAssignCheckbox);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btProAssignAddBtn);
            methods.waitForElement(8);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Project successfully assign to team member");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to assign project to team member");
        }
    }

    public void btCopyIntakeUrlButton() {
        try {
            methods.waitForElement(4);
            methods.scrollAndClickElement(btLoc.btCopyIntakeUrl);
            methods.waitForElement(8);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "copy intake button clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click intake url button");
        }
    }

    public void btCopyIntakeUrlNewTab() {
        try {
            methods.waitForElement(2);
            methods.openAndSwitchNewTab();
            methods.waitForElement(3);
            driver.get("https://next.stage.bidsandtenders.ca/#/intake-request?cid=772dbe03-9772-4e9e-be4a-314fdb66b703&nid=aa179dcc-40f8-450b-8aef-258184e3d533");
            methods.waitForElement(3);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake URL open properly in new tab");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to open intake url in new tab");
        }
    }

    public void intakeStartButton() {
        try {
            methods.waitForElement(4);
            methods.scrollAndClickElement(btLoc.intakeStartbtn);
            methods.waitForElement(8);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake Start request button clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Intake Start request button");
        }
    }

    public void intakeContactDetailsFormField() {
        try {
            methods.sendTextToElement(btLoc.intakeFirstName, TestData.getData("GivenName") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.intakeLastName, TestData.getData("LastName") + "_" + methods.generateRandomString());
            methods.sendTextToElement(btLoc.intakeEmail, TestData.getData("Email") + "_" + methods.generateRandomString() + "@yopmail.com");
            methods.waitForElement(1);
            methods.clickElement(btLoc.intakeDepttDropdown);
            methods.waitForElement(1);
            methods.clickElement(btLoc.intakeDepttDropdownList);
            methods.waitForElement(1);
            methods.clickElement(btLoc.intakeDivDropdown);
            methods.waitForElement(1);
            methods.clickElement(btLoc.intakeDivDropdownList);
            methods.waitForElement(1);
            methods.clickElement(btLoc.intakecontactLeadDropdown);
            methods.waitForElement(1);
            methods.clickElement(btLoc.intakecontactLeadDropdownList);
            methods.waitForElement(3);
            methods.clickElement(btLoc.intakeCommNextBtn);
            methods.waitForElement(8);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake Contact details mandatory field filled successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to fill Intake contact details mandatory fields");
        }
    }

    public void intakeProjectDetailsFormField() {
        try {
            methods.sendTextToElement(btLoc.intakeProName, TestData.getData("ProjectName") + "_" + methods.generateRandomString());
            methods.clickElement(btLoc.intakeProServiceRadioBtn);
            methods.sendTextToElement(btLoc.intakeProDescriptionTextArea, TestData.getData("ProjectDesc"));
            methods.waitForElement(1);
            methods.scrollAndClickElement(btLoc.intakeProBidTypeDropdown);
            methods.waitForElement(1);
            methods.clickElement(btLoc.intakeProBidTypeDropdownList);
            methods.waitForElement(2);
            methods.clickElement(btLoc.intakeProSitevisit);
            methods.waitForElement(2);
            methods.clickElement(btLoc.intakeCommNextBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake project details mandatory field filled successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to fill Intake project details mandatory fields");
        }
    }

    public void intakeProjectValueFormField() {
        try {
            methods.sendTextToElement(btLoc.intakeProAnnualValue, TestData.getData("ProAnnualValue"));
            methods.waitForElement(1);
            methods.sendTextToElement(btLoc.intakeProTotalValue, TestData.getData("ProTotalValue"));
            methods.waitForElement(3);
            methods.clickElement(btLoc.intakeCommNextBtn);
            methods.waitForElement(20); //will disable once captcha disabled
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake project value mandatory field filled successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to fill project value mandatory fields");
        }
    }

    public void intakeSubmitButton() {
        try {
            methods.waitForElement(10); //we will decrease this once captcha will be removed
            methods.scrollAndClickElement(btLoc.intakeSubmitBtn);
            methods.waitForElement(8);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake Submit button clicked successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click intake submit button");
        }
    }

    public void intakeRequestSubmitSuccessValidation() {
        try {
            methods.waitForElement(4);
            if (methods.getElementText(btLoc.intakeSuccessText).contains("Congratulations")) {
                methods.waitForElement(3);
                methods.clickElement(btLoc.intakebtWebsiteBtn);
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake Request send successfully");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Failed to send Intake request");
                Assert.fail("Failed to send Intake request");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to send request");
        }
    }

    public void btContractCriteriaScreenOne() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.termcontract);
            methods.waitForElement(1);
            methods.clickElement(btLoc.contractWarrantyPeriod);
            methods.waitForElement(1);
            methods.clickElement(btLoc.contractPricingPeriod);
            methods.waitForElement(1);
            methods.clickElement(btLoc.contractContinueBtnOne);
            methods.waitForElement(2);
            methods.clickElement(btLoc.contractDocPref);
            methods.waitForElement(2);
            methods.clickElement(btLoc.contractContinueBtnTwo);
            methods.waitForElement(20); //This we added as it took time to get project detail page
            String text = methods.getElementText(btLoc.btProjectSuccess);
            methods.clickElement(btLoc.btSearchProjectBtn);
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.btSearchProjectFilterField, text);
            methods.waitForElement(5);
            methods.scrollAndClickElement(btLoc.btSearchProjectFilterBtn);
            methods.waitForElement(15); //But this we will decrease
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Contract added and search properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to add and search contract");
        }
    }

    public void navContractTab() {
        try {
            methods.waitForElement(4); //we will decrease this once captcha will be removed
            methods.scrollAndClickElement(btLoc.contractTabSelect);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Contract Tab clicked successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Contract Tab");
        }
    }

    public void contractTabDateAmount() {
        try {
            methods.waitForElement(4);//we will decrease this once captcha will be removed
            methods.clickElement(btLoc.contractTabStrDateBtn);
            methods.waitForElement(2);
            methods.clickElement(btLoc.contractStarCurrentDate);
            methods.waitForElement(3);
            methods.clickElement(btLoc.contractTabEndDateBtn);
            methods.waitForElement(3);
            methods.clickElement(btLoc.contractStarCurrentDate);
            methods.waitForElement(2);
//            if (TestData.getData("Post Date").equalsIgnoreCase("CurrentDate")) {
//                methods.clickElement(btLoc.contractTabStrDateBtn);
//                methods.waitForElement(4);
//                methods.selectDateFromCalender(btLoc.contractTabStrDate, methods.getCurrentDate());
//                methods.waitForElement(1);
//                methods.waitForElement(2);
//            }
            methods.sendTextToElement(btLoc.contractTabProValue, "1000");
            methods.waitForElement(2);
            methods.clickElement(btLoc.contractBtmSaveBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Contract Tab clicked successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Contract Tab");
        }
    }

    public void contractSupplierTab() {
        try {
            methods.waitForElement(4); //we will decrease this once captcha will be removed
            methods.clickElement(btLoc.contractSplTab);
            methods.waitForElement(1);
            methods.clickElement(btLoc.contractAddSplBtn);
            methods.waitForElement(2);
            methods.clickElement(btLoc.supplierDropdown);
            methods.waitForElement(2);
            methods.sendTextToElement(btLoc.supplierDropdown, "stage-automationtester.kk@gmail.com");
            methods.waitForElement(4);
            methods.clickElement(btLoc.supplierDropdownList);
            methods.waitForElement(4);
            methods.clickElement(btLoc.addSupplierBtn);
            methods.waitForElement(8);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Contract Tab clicked successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Contract Tab");
        }
    }

    public void startContractButtonValidation() {
        try {
            methods.waitForElement(4); //we will decrease this once captcha will be removed
            if (methods.isElementPresent(btLoc.startContractBtn)) {
                methods.clickElement(btLoc.startContractBtn);
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Start contract button clicked Successfully");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to click start contract button");
                Assert.fail("Unable to click start contract button");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Start Contract button");
        }
    }

    public void closeContractButtonValidation() {
        try {
            methods.waitForElement(4); //we will decrease this once captcha will be removed
            if (methods.isElementPresent(btLoc.closeContractBtn)) {
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Close contract button visible properly");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Close contract button not visible");
                Assert.fail("Close contract button not visible");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to visible close Contract button");
        }
    }

    public void btFindProjectTab() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.btProjectTab);
            methods.waitForElement(2);
            methods.clickElement(btLoc.btFindProjectLinkText);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Bids and Tenders Find a project link clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Find a project link");
        }
    }

    public void intakeSavedSearchProjectFilter() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.savedProjectTab);
            methods.waitForElement(2);
            methods.clickElement(btLoc.savedProjectList);
            methods.waitForElement(1);
            methods.clickElement(btLoc.savedProApplySearchBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake filter working properly");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to search intake filter");
        }
    }


    public void intakeSearchResultFilterValidation() {
        try {
            methods.waitForElement(4);
            if (methods.isElementPresent(btLoc.intakeResultGridList)) {
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake result visible on grid with saved filters");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Failed to search intake result from grid");
                Assert.fail("Failed to search intake result from grid");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to search intake result from grid");
        }
    }

    public void intakeProSelect() {
        try {
            methods.waitForElement(4);
            methods.clickElement(btLoc.intakeProNumber);
            methods.clickElement(btLoc.intakeManageBtnGrid);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Intake Project selected from listing grid");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to select intake project from listing grid");
        }
    }

    public void intakePrintPdfBtn() {
        try {
            methods.waitForElement(4);
            if (methods.isElementPresent(btLoc.intakePrintPdfBtn)) {
                methods.waitForElement(2);
                methods.clickElement(btLoc.intakePrintPdfBtn);
                methods.waitForElement(8);
                ExtentReporter.logWithScreenshot(LogStatus.INFO, "Print to pdf button clicked properly");
            } else {
                ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Failed to click Print to pdf button");
                Assert.fail("Failed to click Print to pdf button");
            }
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Print to pdf button");
        }
    }

    public void intakeDashboardManageButton() {
        try {
            methods.waitForElement(4);
            methods.scrollAndClickElement(btLoc.intakeDashManageBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Manage button clicked from intake dashboard");
            methods.waitForElement(2);
            String text = methods.getElementText(btLoc.intakeCellValue);
            methods.sendTextToElement(btLoc.intakeSearchFilterField, text);
            methods.waitForElement(3);
            methods.clickElement(btLoc.intakeViewDashBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "View button clicked from intake dashboard");
            methods.waitForElement(2);
            methods.clickElement(btLoc.intakeConfirmDashBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Confirm button clicked from intake dashboard");
            methods.waitForElement(3);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Manage button clicked from intake dashboard");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to click Manage button clicked from intake dashboard");
        }
    }

    public void btProjectDetailsIntakeProConversion() {
        try {
            methods.waitForElement(2);
            methods.clickElement(btLoc.btAutogeneratePro);
            methods.waitForElement(2);
            methods.clickElement(btLoc.intakeProLeadDropdown);
            methods.waitForElement(1);
            methods.sendTextToElement(btLoc.intakeProLeadDropdown, "Automation User");
            methods.waitForElement(1);
            methods.clickElement(btLoc.intakeProLeadDropdownList);


            methods.waitForElement(1);
            methods.scrollAndClickElement(btLoc.btHasProjectAnotherRadiobtn);
            methods.waitForElement(1);
            methods.scrollAndClickElement(btLoc.btHasCoprProjectRadiobtn);
            methods.waitForElement(1);
            methods.clickElement(btLoc.btProDetailsContinueBtn);
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Project details added successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("Failed to add project details");
        }
    }

    public void searcIntakeRequest() {
        methods.scrollToElement(btLoc.intakeHeading);
        CommonMethods.highlightElement(btLoc.intakeHeading);
        methods.sendTextToElement(btLoc.intakeSearchReq, TestData.getData("intake name"));
        methods.waitForElement(3);
    }

    public void clickViewButton() {
        for (WebElement cell : btLoc.intakeTD) {
            if (methods.getTextOfElementEquals(cell, TestData.getData("intake name"))) {
                methods.clickElement(btLoc.getManageMenu(cell));
                methods.waitForElement(2);
                break;
            }
        }
        for (WebElement li : btLoc.intakeManageList) {
            if (methods.getTextOfElementEquals(li, TestData.getData("view button"))) {
                methods.clickElement(li);
                methods.waitForElement(2);
                break;
            }
        }
    }

    public void clickDeclineButton() {
        methods.clickElement(btLoc.intakeManageBtn);
        methods.waitForElement(2);
        methods.clickElement(btLoc.intakeDeclineBtn);
        methods.waitForElementVisibility(btLoc.intakeDeclineDialogue, 2);
    }

    public void typeDeclineComment() {
        methods.sendTextToElement(btLoc.intakeDeclineText, "decline comment");
        methods.clickElement(btLoc.intakeDeclineReqBtn);
        methods.waitForElementVisibility(btLoc.intakeDeclineToastMsgDialogue, 5);
        methods.waitForElement(2);
    }

    public void clickDeclineRequestButton() {
        methods.clickElement(btLoc.intakeDeclineReqBtn);
        methods.waitForElementVisibility(btLoc.intakeDeclineToastMsgDialogue, 5);
//        methods.assertEqualsOfElementText(btLoc.intakeDeclineToastMsgContent,"Success");
//        methods.assertEqualsOfElementText(btLoc.intakeDeclineToastMsgContent,"Intake request successfully declined");
    }

    public void verifyViewDeclineComment() {
        methods.clickElement(btLoc.intakeViewdeclinedcommentBtn);
        methods.waitForElementVisibility(btLoc.intakeDeclineDialogue, 5);
        methods.assertEqualsOfElementText(btLoc.intakeViewdeclinedcomment, TestData.getData("decline comment"));
    }

    public void clickIntakePrintButton() {
        methods.clickElement(btLoc.intakePrintPdfBtn);
    }
}
