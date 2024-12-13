Feature: Park and Facilities Activities Scenarios
  Background: PF Login the page
    Given Launch and login Park and Facilities Back Office


  @RG_PF_ACT_01_RG_PF_ACT_07 @PF @Regression @PFActivities
  Scenario: RG_PF_ACT_01_RG_PF_ACT_07_Validate Admin should be able to sort a Activity
    When user Go to PF Activities tab
    And user is able to activities and Activity table is automatically sorted by Name column
    And user sort with active then activities should be sorted with active
    And user sort with System Default then activities should be sorted with System Default
    And user sort with count then activities should be sorted with count

    @RG_PF_ACT_02_RG_PF_ACT_06 @PF @Regression @PFActivities
    Scenario Outline: RG_PF_ACT_02_RG_PF_ACT_06_Validate Admin should be able to add a Activity
      When user Go to PF Activities tab
      And user add the activity "<Test Case ID>"
      Then Activity should be added
      When user search for the activity
      Then Activity should be displayed
      Examples:
      |Test Case ID|
      |RG_PF_ACT_02|

  @RG_PF_ACT_03 @PF @Regression @PFActivities
  Scenario Outline: RG_PF_ACT_03_Validate Admin should be able to edit a Activity
    When user Go to PF Activities tab
    And user update the activity "<Test Case ID>"
    Then Activity should be updated
    Examples:
      |Test Case ID|
      |RG_PF_ACT_03|

  @RG_PF_ACT_04 @PF @Regression @PFActivities
  Scenario Outline: RG_PF_ACT_04_Validate Admin should be able to delete a Activity
    When user Go to PF Activities tab
    And user add the activity "<Test Case ID>"
    And Activity should be added
    And user delete the activity
    Then Activity should be deleted
    Examples:
      |Test Case ID|
      |RG_PF_ACT_04|

  @RG_PF_ACT_05 @PF @Regression @PFActivities
  Scenario: RG_PF_ACT_05_Validate Admin should be able to activate or deactivate a Activity
    When user Go to PF Activities tab
    Then user should be able to activate or deactivate

