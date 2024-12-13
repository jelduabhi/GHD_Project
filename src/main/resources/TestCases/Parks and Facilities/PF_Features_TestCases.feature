Feature: Park and Facilities Features Scenarios
  Background: Login the page
    Given Launch and login Park and Facilities Back Office

  @RG_PF_FT_01_RG_PF_FT_07 @PF @Regression @PFActivities
  Scenario: RG_PF_FT_01_RG_PF_FT_07_Validate Admin should be able to sort a feature
    When user Go to Features tab
    And user is able to validate and feature table is automatically sorted by Name column
    And user sort with active then activities should be sorted with active
    And user sort with count then activities should be sorted with count

  #RG_PF_FT_02 This test cases contains mentioned below test case:
  #TestCaseId:RG_PF_FT_02 create a feature
  #TestCaseId:RG_PF_FT_06 Search a feature

  @RG_PF_FT_02 @pfFeatures @Regression @PF
  Scenario Outline: RG_PF_FT_02 and RG_PF_FT_06 create and search a features under Park and Facility grid
    When user Go to Features tab
    Then click add button
    And create features for park and facilities and click save button "<Testcase ID>"
    Then verify features is created under park and facilities list
    Examples:
      | Testcase ID     |
      | RG_PFF_1.2      |

  @RG_PF_FT_04 @pfFeatures @Regression @PF
  Scenario Outline: RG_PF_FT_04 Delete features for Park and Facility
    When user Go to Features tab
    Then click add button
    And create features for park and facilities and click save button "<Testcase ID>"
    Then verify features is created under park and facilities list
    And click delete button for park and facilities
    Then verify features is deleted for park and facilities
    Examples:
      | Testcase ID |
      | RRG_PFF_1.4  |

  @RG_PF_FT_03 @pfFeatures @Regression @PF
  Scenario Outline: RG_PF_FT_03 Edit Features for park and facility
    When user Go to Features tab
    Then click add button
    And create features for park and facilities and click save button "<Testcase ID>"
    Then verify features is created under park and facilities list
    And click edit button
    And edit features of park and facilities and click save button "<Testcase ID>"
    Then verify features is edited under park and facilities list
    Examples:
      | Testcase ID |
      | RG_PFF_1.3  |


  @RG_PF_FT_05 @pfFeatures @Regression @PF
  Scenario: RG_PF_FT_05 Enabling/Disabling Features
    When user Go to Features tab
    And verify that radio button should be changed either to enabled or disable when user clicked