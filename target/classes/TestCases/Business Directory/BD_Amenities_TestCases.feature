Feature: Business Directory Amenities Scenarios

  Background: Login the page
    Given Launch and login Business Directory Back Office

  #TestCaseId: RG_BD_AM_01
  #TestCaseId: RG_BD_AM_11
  @RG_BD_AM_01 @amenities @Regression @BD
  Scenario Outline: RG_BD_AM_01 Create new amenity and RG_BD_AM_11 Search amenity
    When user Go to Amenities tab
    Then click add button
    And create amenities and click save button "<Testcase ID>"
    Then verify amenities is created
    Examples:
      | Testcase ID     |
      | RG_BDA_1.1      |
      | RG_BDA_1.1_inac |

  @RG_BD_AM_02 @amenities @Regression @BD
  Scenario Outline: RG_BD_AM_02 Delete amenity
    When user Go to Amenities tab
    Then click add button
    And create amenities and click save button "<Testcase ID>"
    Then verify amenities is created
    And click delete button
    Then verify amenity is deleted
    Examples:
      | Testcase ID |
      | RG_BDA_1.2  |

  @RG_BD_AM_03 @bdamenity @BD
  Scenario Outline: RG_BD_AM_03 Edit/update amenity
    When user Go to Amenities tab
    Then click add button
    And create amenities and click save button "<Testcase ID>"
    Then verify amenities is created
    And click edit button
    And edit amenities and click save button
    Then verify amenities is edited
    Examples:
      | Testcase ID |
      | RG_BDA_1.3  |

  @RG_BD_AM_13 @bdamenities @BD
  Scenario Outline: RG_BD_AM_13 Add Amenity button on Grid
    When user Go to Amenities tab
    Then search amenities with non existing record "<Testcase ID>"
    And click add amenties button from grid
    And create amenities and click save button "<Testcase ID>"
    Then verify amenities is created
    Examples:
      | Testcase ID |
      | RG_BDA_1.13 |

  @RG_BD_AM_14 @bdamenities @BD
  Scenario Outline: RG_BD_AM_14 Clear Search button on Grid
    When user Go to Amenities tab
    Then search amenities with non existing record "<Testcase ID>"
    When user click clear button
    Then verify user should be able to a clear search using clear button from grid
    Examples:
      | Testcase ID |
      | RG_BDA_1.13 |

  @RG_BD_AM_10 @bdamenity @BD
  Scenario: RG_BD_AM_10 Pagination Page Selector (Using three dots)
    When user Go to Amenities tab
    Then on the page selector, click the three dots

  @RG_BD_AM_09 @bdamenity @BD
  Scenario: RG_BD_AM_09 Pagination Page Selector (Using number)
    When user Go to Amenities tab
    Then on the displayed numbers for page selector click any available number

  @RG_BD_AM_04 @bdamenity @BD
  Scenario Outline: RG_BD_AM_04 Status Filter in Amenities Listing screen
    When user Go to Amenities tab
    Then go to active filter and click funnel icon
    And select the status "<Testcase ID>"
    Then verify status set by user
    Examples:
      | Testcase ID |
      | RG_BDA_1.4  |