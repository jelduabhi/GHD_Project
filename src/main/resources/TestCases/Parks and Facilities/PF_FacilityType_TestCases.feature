Feature: Park and Facilities Amenities Scenarios
  Background: Login the page
    Given Launch and login Park and Facilities Back Office

  @RG_PF_FAC_02_RG_PF_FAC_04 @PF @Regression @PFActivities
  Scenario: RG_PF_FAC_02_RG_PF_FAC_04_Validate Admin should be able to sort a Facility type
    When user Go to Facility type tab
    And user is able to validate Facility table and it is automatically sorted by Name column
    And user sort with active then activities should be sorted with active
    And user sort with System Default then activities should be sorted with System Default
    And user sort with count then activities should be sorted with count

  @RG_PF_FAC_02 @pfFacilityType @PF @Regression
  Scenario: RG_PF_FAC_02 Enabling/Disabling Facility Type
    When user Go to Facility type tab
    And verify that radio button should be changed either to enabled or disable when user clicked

   @RG_PF_FAC_03 @pfFacilityType @PF @Regression
    Scenario Outline: RG_PF_FAC_03 Admins should be able to use the Search bar in Facility
    When user Go to Facility type tab
    Then search the facility type and verify search should work "<Testcase ID>"
    Examples:
      | Testcase ID          |
      | RG_PFL_2.1           |
