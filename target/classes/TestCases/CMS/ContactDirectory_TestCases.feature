Feature: Contact Directory Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  @createNewContactsCategoryFolder @ContactDirectory @Regression @CMS
  Scenario Outline: RG_CD_2.1_Verify user is able to Create Category Folder
    Given user selects the contact category folder
    When user create new category folder "<TestCaseID>"
    And User is able to create new category folder
    Examples:
      | TestCaseID |
      | RG_CD_2.1  |

  @createNewContactsCategory @ContactDirectory @Regression @CMS
  Scenario Outline: RG_CD_2.2_RG_CD_2.3_Verify user is able to create Create Categories
    Given user selects the contact category
    When user create new category "<TestCaseID>"
    And user is able to create new category
    And user launch contact directory front end page in new tab
    Then Category should be created under Contacts
    Examples:
      | TestCaseID |
      | RG_CD_2.2  |

  @UpdateCategory @ContactDirectory @Regression @CMS
  Scenario Outline: RG_CD_2.4_RG_CD_2.5_Verify Contacts Category was updated under Contacts
    Given user expand the contact category
    When user update the category "<TestCaseID>"
    Then category details should be updated
    And user launch contact directory front end page in new tab
    Then Category should be updated under Contacts
    Examples:
      | TestCaseID |
      | RG_CD_2.4  |


  @createNewContactAndPhoneNumber @ContactDirectory @Regression @CMS
  Scenario Outline: RG_CD_3.2_RG_CD_3.3_RG_CD_3.4_RG_CD_3.5_Create Contact Item
    Given user select the contacts list
    When user create a new contact "<TestCaseID>"
    Then new contact should be created
    And user add new phone number to the contact
    And user launch contact directory front end page in new tab
    Then new contact should be displayed
    Examples:
      | TestCaseID |
      | RG_CD_3.2_RG_CD_3.3_RG_CD_3.4_RG_CD_3.5  |

  # ####################################################################################################
  #   Author :-  Sai Kumar Jeldu
  #   This scenario will cover RG_CD_3.6_RG_CD_3.7_RG_CD_3.9_RG_CD_3.10
  # ####################################################################################################
  @updatePrimaryNumber @ContactDirectory @Regression @CMS
  Scenario Outline: RG_CD_3.6_RG_CD_3.7_RG_CD_3.9_RG_CD_3.10_Update Primary Contact Number
    Given user select the contacts list
    When user update a primary number "<TestCaseID>"
    Then new contact should be updated
    And user launch contact directory front end page in new tab
    Then contact details should be updated
    Examples:
      | TestCaseID |
      | RG_CD_3.6_RG_CD_3.7|


  @DeleteCategory @ContactDirectory @Regression @CMS
  Scenario: RG_CD_2.6_RG_CD_2.7_Verify Contacts Category was deleted under Contacts
    Given user expand the contact category
    When user delete the category
    And user launch contact directory front end page in new tab
    Then Category should be deleted under Contacts