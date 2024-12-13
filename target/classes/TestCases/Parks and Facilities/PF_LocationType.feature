Feature: Park and Facilities location type scenarios
  Background: Login the page
    Given Launch and login Park and Facilities Back Office

  @RG_PF_LOC_01_RG_PF_LOC_07 @PF @Regression @PFActivities
  Scenario: RG_PF_LOC_01_RG_PF_LOC_07_Validate Admin should be able to sort a location type
    When user Go to Location Type tab
    And user is able to validate and location type table is automatically sorted by Name column
    And user sort with active then activities should be sorted with active
    And user sort with System Default then activities should be sorted with System Default
    And user sort with count then activities should be sorted with count

  #RG_PF_LOC_02 Test cases contains mentioned below test cases:
  #Test_Case_Id: RG_PF_LOC_02 Create location type under Park and facility
  #Test_Case_Id: RG_PF_LOC_06 Search location type under Park and facility
  @RG_PF_LOC_02 @pfLocationType @PF @Regression
  Scenario Outline: RG_PF_LOC_02 create and RG_PF_LOC_06 search a location type under Park and Facility grid
    When user Go to Location Type tab
    Then click add button
    And create location type for park and facilities and click save button "<Testcase ID>"
    Then verify location type is created under park and facilities list
    Examples:
      | Testcase ID    |
      | RG_PFL_1.2     |

  @RG_PF_LOC_04 @pfLocationType @PF @Regression
  Scenario Outline: RG_PF_LOC_04 Delete location type for Park and Facility
    When user Go to Location Type tab
    Then click add button
    And create location type for park and facilities and click save button "<Testcase ID>"
    Then verify location type is created under park and facilities list
    And click delete button for location type park and facilities
    Then verify location type is deleted for park and facilities
    Examples:
      | Testcase ID |
      | RG_PFL_1.4  |

  @RG_PF_LOC_03 @pfLocationType @PF @Regression
  Scenario Outline: RG_PF_LOC_03 Edit Location Type for park and facility
    When user Go to Location Type tab
    Then click add button
    And create location type for park and facilities and click save button "<Testcase ID>"
    Then verify location type is created under park and facilities list
    And click edit button
    And edit location type of park and facilities and click save button "<Testcase ID>"
    Then verify location type is edited under park and facilities list
    Examples:
      | Testcase ID |
      | RG_PFL_1.3  |

  @RG_PF_LOC_05 @pfLocationType @PF @Regression
  Scenario: RG_PF_LOC_05 Enabling/Disabling Location Type
    When user Go to Location Type tab
    And verify that radio button should be changed either to enabled or disable when user clicked