Feature: Park and Facilities Amenities Scenarios

  Background: Login the page
    Given Launch and login Park and Facilities Back Office

  @RG_PF_AM_01_RG_PF_AM_07 @PF @Regression @PFActivities
  Scenario: RG_PF_AM_01_RG_PF_AM_07_Validate Admin should be able to sort a Amenities
    When user Go to Amenities tab
    And user is able to validate and Amenities table is automatically sorted by Name column
    And user sort with active then activities should be sorted with active
    And user sort with System Default then activities should be sorted with System Default
    And user sort with count then activities should be sorted with count

  #RG_PF_AM_02 Test cases contains mentioned below test cases:
  #Test_Case_Id: RG_PF_AM_02 Create amenity under Park and facility
  #Test_Case_Id: RG_PF_AM_06 Search amenity under Park and facility
  @RG_PF_AM_02 @pfAmenities @PF @Regression
  Scenario Outline: RG_PF_AM_02 create and RG_PF_AM_06 search a amenity under Park and Facility grid
    When user Go to Amenities tab
    Then click add button
    And create amenities for park and facilities and click save button "<Testcase ID>"
    Then verify amenities is created under park and facilities list
    Examples:
      | Testcase ID     |
      | RG_PFAM_1.2     |

  @RG_PF_AM_04 @pfAmenities @PF @Regression
  Scenario Outline: RG_PF_AM_04 Delete amenities for Park and Facility
    When user Go to Amenities tab
    Then click add button
    And create amenities for park and facilities and click save button "<Testcase ID>"
    Then verify amenities is created under park and facilities list
    And click delete button for amenities park and facilities
    Then verify amenities is deleted for park and facilities
    Examples:
      | Testcase ID |
      | RG_PFAM_1.4 |

  @RG_PF_AM_03 @pfAmenities @PF @Regression
  Scenario Outline: RG_PF_AM_03 Edit Amenities for park and facility
    When user Go to Amenities tab
    Then click add button
    And create amenities for park and facilities and click save button "<Testcase ID>"
    Then verify amenities is created under park and facilities list
    And click edit button
    And edit amenities of park and facilities and click save button "<Testcase ID>"
    Then verify amenities is edited under park and facilities list
    Examples:
      | Testcase ID |
      | RG_PFAM_1.3 |

  @RG_PF_AM_05 @pfAmenities @PF @Regression
  Scenario: RG_PF_AM_05 Enabling/Disabling Amenities
    When user Go to Amenities tab
    And verify that radio button should be changed either to enabled or disable when user clicked