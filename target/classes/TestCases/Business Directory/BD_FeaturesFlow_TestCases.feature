Feature: Business Directory Features Scenarios
  Background: Login the page
    Given Launch and login Business Directory Back Office

  #This Test case contains:
  #TestCaseId: RG_BD_FT_01
  #TestCaseId: RG_BD_FT_11
  @RG_BD_FT_01 @Bdfeatures @Regression @BD
  Scenario Outline: RG_BD_FT_01 create new features and RG_BD_FT_11 Search Features
    When user Go to Features tab
    Then click add button
    And create features and click save button "<Testcase ID>"
    Then verify features is created
    Examples:
      | Testcase ID     |
      | RG_BDF_1.1      |

  @RG_BD_FT_02 @Bdfeatures @Regression @BD
  Scenario Outline: RG_BD_FT_02 Delete features
    When user Go to Features tab
    Then click add button
    And create features and click save button "<Testcase ID>"
    Then verify features is created
    And click delete button
    Then verify features is deleted
    Examples:
      | Testcase ID |
      | RG_BDF_1.2  |

  @RG_BD_FT_03 @Bdfeatures @Regression @BD
  Scenario Outline: RG_BD_FT_03 Edit/update features
    When user Go to Features tab
    Then click add button
    And create features and click save button "<Testcase ID>"
    Then verify features is created
    And click edit button
    And edit features and click save button "<Testcase ID>"
    Then verify features is edited
    Examples:
      | Testcase ID |
      | RG_BDF_1.3  |

  @RG_BD_FT_04 @Bdfeatures @Regression @BD
  Scenario Outline: RG_BD_FT_04 Status Filter in Amenities Listing screen
    When user Go to Features tab
    Then go to active filter and click funnel icon
    And select the status of features column "<Testcase ID>"
    Then verify status set by user
    Examples:
      | Testcase ID |
      | RG_BDF_1.4  |

  @RG_BD_FT_09 @Bdfeatures @Regression @BD
  Scenario: RG_BD_FT_09 Pagination Page Selector (Using number)
    When user Go to Features tab
    Then on the displayed numbers for page selector click any available number

  @RG_BD_FT_10 @Bdfeatures @Regression @BD
  Scenario: RG_BD_FT_10 Pagination Page Selector (Using three dots)
    When user Go to Features tab
    Then on the page selector, click the three dots

  @RG_BD_FT_13 @Bdfeatures @Regression @BD
  Scenario Outline: RG_BD_FT_13 Add Features button on Grid
    When user Go to Features tab
    Then search features with non existing record "<Testcase ID>"
    And click add features button from grid
    And create features and click save button "<Testcase ID>"
    Then verify features is created
    Examples:
      | Testcase ID |
      | RG_BDF_1.14 |

  @RG_BD_FT_14 @Bdfeatures @Regression @BD
  Scenario Outline: RG_BD_FT_14 Clear Search button on Grid
    When user Go to Features tab
    Then search features with non existing record "<Testcase ID>"
    When user click clear button
    Then verify user should be able to a clear search using clear button from grid
    Examples:
      | Testcase ID |
      | RG_BDF_1.14 |