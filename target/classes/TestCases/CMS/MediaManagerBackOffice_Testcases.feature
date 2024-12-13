Feature: Media Manager Backoffice Scenarios
  Background: Login the page
    Given Launch and login GovStack CMS Back Office
    When Go to Content Home and navigate to media manager
  @MM_BO_03 @mmCategory
  Scenario Outline: MM_BO_03 Categories - Create
    When user click categories
    Then click create media category
    Then enter input category name "<TestcaseID>"
    When user click save and publish
    Then verify created category is visible inside categories folder
    Examples:
      | TestcaseID  |
      | MM_BO_03    |
  @MM_BO_04 @mmCategory
  Scenario: MM_BO_04 Categories - Unpublish
    When user click categories
    And User selects the category
    And user unPublish the published category
  @MM_BO_05 @mmCategory
  Scenario: MM_BO_05 Categories - Delete
    When user click categories
    And user selects existing category and delete category
    And deleted category should be displayed in recycle bin
  @MM_BO_06 @mmCategoryCRUD
  Scenario Outline: MM_BO_06 Meta Information- Create Text fields,Text Area Fields,Date Fields,Date with Time fields,Link fields
    When user expand meta information
    And click text field menu "<TestcaseID>"
    Then click create media category
    Then enter input category name "<TestcaseID>"
    When user click save and publish
    Then verify created category is visible inside text fields folder
    Examples:
      | TestcaseID     |
      | MM_BO_06_01    |
      | MM_BO_06_02    |
      | MM_BO_06_03    |
      | MM_BO_06_04    |
      | MM_BO_06_05    |
  @MM_BO_09 @mmCategoryCRUD
  Scenario Outline: MM_BO_09 Meta Information - Unpublish Text fields,Text Area Fields,Date Fields,Date with Time fields,Link fields
    When user expand meta information
    And click text field menu "<TestcaseID>"
    And user unPublish the published meta informations
    Examples:
      | TestcaseID     |
      | MM_BO_06_01    |
      | MM_BO_06_02    |
      | MM_BO_06_03    |
      | MM_BO_06_04    |
      | MM_BO_06_05    |
  @MM_BO_07 @mmCategory
  Scenario Outline: MM_BO_07 Meta Information - Edit Text fields,Text Area Fields,Date Fields,Date with Time fields,Link fields
    When user expand meta information
    And click text field menu "<TestcaseID>"
    When user update the meta informations details "<TestcaseID>"
    Then enter input category name "<TestcaseID>"
    When user click save and publish
    Then verify created category is visible inside text fields folder
    Examples:
      | TestcaseID         |
      | MM_BO_07_01_Update |
      | MM_BO_07_02_Update |
      | MM_BO_07_03_Update |
      | MM_BO_07_04_Update |
      | MM_BO_07_05_Update |
  @MM_BO_08 @mmCategoryCRUD
  Scenario Outline: MM_BO_08 Meta Information - Delete Text field,Text Area Fields,Date Fields,Date with Time fields,Link fields
    When user expand meta information
    And click text field menu "<TestcaseID>"
    And user selects existing category and delete category
    And deleted meta information should be displayed in recycle bin
    Examples:
      | TestcaseID     |
      | MM_BO_06_01    |
      | MM_BO_06_02    |
      | MM_BO_06_03    |
      | MM_BO_06_04    |
      | MM_BO_06_05    |
  @MM_BO_16_A
  Scenario Outline: MM_BO_16 General - Invalid Search Categories
    When user click categories
    Then verify invalid record search and validate the validation message "<TestcaseID>"
    Examples:
      | TestcaseID  |
      | MM_BO_16_01 |
  @MM_BO_16_B
  Scenario Outline: MM_BO_16 General - Invalid Search Text field,Text Area Fields,Date Fields,Date with Time fields,Link fields
    When user expand meta information
    And click text field menu "<TestcaseID>"
    Then verify invalid record search and validate the validation message "<TestcaseID>"
    Examples:
      | TestcaseID  |
      | MM_BO_16_02 |
      | MM_BO_16_03 |
      | MM_BO_16_04 |
      | MM_BO_16_05 |
      | MM_BO_16_06 |
  @MM_BO_17
  Scenario Outline: MM_BO_17 Search - subfolder of Media Pages specific
    When user expand media pages
    And click automation subfolder of media pages
    Then verify search with heading subheading and textfield "<TestcaseID>"
    Examples:
      | TestcaseID    |
      | MM_BO_17_01   |
      | MM_BO_17_02   |
      | MM_BO_17_03   |
      | MM_BO_17_04   |
  @MM_BO_18_A @mmMediaPages
  Scenario: MM_BO_18_A General Cards view - Categories
    When user click categories
    And select list view icon
    Then verify name status lastEdited and created by column visible
  @MM_BO_18_B @mmMediaPages
  Scenario Outline: MM_BO_18_B General Cards view-Meta Information Text field,Text Area Fields,Date Fields,Date with Time fields,Link fields
    When user expand meta information
    And click text field menu "<TestcaseID>"
    And select list view icon
    Then verify name status lastEdited and created by column visible
    Examples:
      | TestcaseID  |
      | MM_BO_16_02 |
      | MM_BO_16_03 |
      | MM_BO_16_04 |
      | MM_BO_16_05 |
      | MM_BO_16_06 |
  @MM_BO_18_C @mmMediaPages
  Scenario: MM_BO_18_C General Cards view- Media Pages
    When user expand media pages
    And click automation subfolder of media pages
    Then verify name status lastEdited and created by column visible
  @MM_BO_18_D @mmMediaPages
  Scenario: MM_BO_18_D General Cards view- Template Builder
    When user expand template builder menu
    And click sample templates of template builder
    Then verify name status lastEdited and created by column visible
  @MM_BO_10 @mmTempBld
  Scenario Outline: MM_BO_10 Template Builder - Create
    When user expand template builder menu
    And click sample templates of template builder
    Then click create media page blank option
    Then enter input template builder name "<TestcaseID>"
    When user click save and publish
    Then verify created template builder is visible inside categories folder
    Examples:
      | TestcaseID  |
      | MM_BO_10    |
  @MM_BO_11 @mmTempBld
  Scenario: MM_BO_11 Template Builder - Unpublish
    When user expand template builder menu
    And click sample templates of template builder
    And User selects the category
    And user unPublish the published template builder
  @MM_BO_12 @mmCategory
  Scenario Outline: MM_BO_12 Template Builder - Edit
    When user expand template builder menu
    And click sample templates of template builder
    When user update the template builder details "<TestcaseID>"
    Then update and enter input template builder name "<TestcaseID>"
    When user click save and publish
    Then verify created template builder is visible inside categories folder
    Examples:
      | TestcaseID  |
      | MM_BO_12    |
  @MM_BO_13 @mmCategoryCRUD
  Scenario: MM_BO_13 Template Builder - Delete
    When user expand template builder menu
    And click sample templates of template builder
    And user selects existing template builder and delete template builder
    And deleted meta information should be displayed in recycle bin
  @MM_BO_14
  Scenario: MM_BO_14 Template Builder - Copy to Media Pages
    When user expand template builder menu
    And click sample templates of template builder
    And select any item from list
    When user click copy uncheck relate to original toggle and select media page subfolder
    When user expand media pages
    And click automation subfolder of media pages
    Then verify name status lastEdited and created by column visible

    # Media Manager Pages TC Meta Information Fields
  # THIS TEST CASES CONTAINS LINK FIELDS TEST CASES FOR TC ID TC_LF_1 TO TC_LF_4
  @TC_LF_1 @mmMediaPages
  Scenario Outline: TC_LF_1,TC_LF_2,TC_LF_3,TC_LF_4 Media Page for Meta Information fields with Link Fields Amended By,Contact Info,Related Document,Repealed By
    When user expand media pages
    And click automation subfolder of media pages
    Then click create media page blank option
    Then enter input template builder name "<TestcaseID>"
    And select meta information field with type as link field
    And select meta information type as amedned by
    And add link field type value and click submit button "<TestcaseID>"
    When user click save and publish
    When user click info icon
    Then verify values are successfully added and working on frontend
    Examples:
      | TestcaseID  |
      | TC_LF_1     |
      | TC_LF_2     |
      | TC_LF_3     |
      | TC_LF_4     |
  @TC_DTF_1 @mmMediaPages
  Scenario Outline: TC_DTF_1 create media pages for Meta Information Fields with Date Time Fields: Meeting Date
    When user expand media pages
    And click automation subfolder of media pages
    Then click create media page blank option
    Then enter input template builder name "<TestcaseID>"
    And select meta information field with type as date time field
    And select meta information type as meeting date
    And select meeting date from calendar
    When user click save and publish
    When user click info icon
    Then verify values are successfully added and working on frontend
    Examples:
      | TestcaseID  |
      | TC_DTF_1    |

    #Media Manager Pages AT Meta Information Fields Date Field pending test cases started here
   #TEST CASES ID COVERED : TC_DF_9,TC_DF_10,TC_DF_11,TC_DF_12
   #NOTE: FROM TC_DF_1 TO TC_DF_8 SAI KUMAR WORKED ON HIS PR
  @TC_DF_9 @mmMediaPages
  Scenario Outline: TC_DF_9,TC_DF_10,TC_DF_11,TC_DF_12 create media pages for Meta Information Fields with Date Fields: Issue Date,Publication Date,Review Date,Submission Date
    When user expand media pages
    And click automation subfolder of media pages
    Then click create media page blank option
    Then enter input template builder name "<TestcaseID>"
    And select meta information field with type as date field
    And select meta information type as issue date "<TestcaseID>"
    And select meeting date from calendar
    When user click save and publish
    When user click info icon
    Then verify values are successfully added and working on frontend
    Examples:
      | TestcaseID  |
      | TC_DF_9     |
      | TC_DF_10    |
      | TC_DF_11    |
      | TC_DF_12    |