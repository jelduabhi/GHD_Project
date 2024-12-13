Feature: Park and Facilities Listing GridScenarios
  Background: PF Login the page
    Given Launch and login Park and Facilities Back Office

  @RG_PF_LIS_BO_02 @PF @Regression @PFActivities
  Scenario: RG_PF_LIS_BO_02_RG_PF_LIS_BO_03_RG_PF_LIS_BO_04_RG_PF_LIS_BO_05_RG_PF_LIS_BO_06_Validate Admin should be able to sort a Activity
    When User Go to PF Listings tab
    And user is able to see listing and Activity table is automatically sorted by Name column
    And user is able to sort by Facility Type, Location Types, Status
    And user is able to filter by Facility Type, Location Types, Status

    @RG_PF_LIS_BO_08
    Scenario Outline: RG_PF_LIS_BO_08_RG_PF_LIS_BO_09_RG_PF_LIS_BO_10_RG_PF_LIS_BO_11_RG_PF_LIS_BO_01_Validate user is able to create a new Location under Listing
      When User Go to PF Listings tab
      And user selects the add location
      And user enters the general details "<Test Case ID>"
      And user enters the address details
      And user enters the details details
      Then location should be added
      Examples:
      |Test Case ID|
      |RG_PF_LIS_BO_08|
      |RG_PF_LIS_BO_09|
      |RG_PF_LIS_BO_10|

  @RG_PF_LIS_BO_12 @PF @Regression @PFActivities
  Scenario Outline: RG_PF_LIS_BO_12_Validate Admin should be able to edit a Activity
    When User Go to PF Listings tab
    And user update the activity "<Test Case ID>"
    Then Activity should be updated
    Examples:
      |Test Case ID|
      |RG_PF_LIS_BO_12|

  @RG_PF_LIS_BO_07 @PF @Regression @PFActivities
  Scenario: RG_PF_LIS_BO_07_Validate Admin should be able to delete a Activity
    When User Go to PF Listings tab
    And user delete the activity
    Then Activity should be deleted