Feature: Business Directory Sectors and Area of Service Scenarios
  Background: Login the page
    Given Launch and login Business Directory Back Office

  #Sectors test cases started here
  #Sectors test cases contains
  #Test_Case_Id:RG_BD_SEC_02
  #Test_Case_Id:RG_BD_SEC_03
  #Test_Case_Id:RG_BD_SEC_04
  #Test_Case_Id:RG_BD_SEC_05

  @RG_BD_SEC_02 @sectors @Regression @BD
  Scenario Outline: RG_BD_SEC_02 Expanding Sectors and RG_BD_SEC_03 Collapsing Sectors
    When user Go to Sectors tab
    Then search sectors with existing record "<Testcase ID>"
    And verify that user able to expand and collapse sector in grid
    Examples:
      | Testcase ID |
      | RG_BDS_1.2 |


  @RG_BD_SEC_05 @sectors @Regression @BD
  Scenario Outline: RG_BD_SEC_05 Search Sectors
    When user Go to Sectors tab
    Then search sectors with existing record "<Testcase ID>"
    Examples:
      | Testcase ID |
      | RG_BDS_1.5 |

  @RG_BD_SEC_04 @sectors @Regression @BD
  Scenario Outline: RG_BD_SEC_04 Enabling/Disabling Sector
    When user Go to Sectors tab
    Then search sectors with existing record "<Testcase ID>"
    And verify that radio button should be changed either to enabled or disable when user clicked
    Examples:
      | Testcase ID |
      | RG_BDS_1.4 |

  #Area of service test cases started here
  #Area of service test cases contains
  #Test_Case_Id:RG_BD_AOS_05
  #Test_Case_Id:RG_BD_AOS_06
  #Test_Case_Id:RG_BD_AOS_07
  #Test_Case_Id:RG_BD_AOS_08

  @RG_BD_AOS_05 @areaOfService @sectors @Regression @BD
  Scenario: RG_BD_AOS_05 Pagination Page Selector
    When user Go to Sectors tab
    Then on the displayed numbers for page selector click any available number

  @RG_BD_AOS_06 @areaOfService @sectors @Regression @BD
  Scenario Outline: RG_BD_AOS_06 Adding Area of service
    When user Go to Sectors tab
    Then search sectors with existing record "<Testcase ID>"
    And expand the sector list
    Then click area of service button
    And create new sector "<Testcase ID>"
    Then verify sector is created
    Examples:
      | Testcase ID  |
      | RG_BDAOS_1.6 |

  @RG_BD_AOS_07 @areaOfService @sectors @Regression @BD
  Scenario Outline: RG_BD_AOS_07 Deleting Area of service
    When user Go to Sectors tab
    Then search sectors with existing record "<Testcase ID>"
    And expand the sector list
    Then click delete button from grid
    Examples:
      | Testcase ID  |
      | RG_BDAOS_1.7 |

  @RG_BD_AOS_08 @areaOfService @sectors @Regression @BD
  Scenario Outline: RG_BD_AOS_08 Editing Area of service
    When user Go to Sectors tab
    Then search sectors with existing record "<Testcase ID>"
    And expand the sector list
    Then click area of service button
    And create new sector "<Testcase ID>"
    Then verify sector is created
    And click edit icon
    Then edit the record "<Testcase ID>"
    And verify sector is updated
    Examples:
      | Testcase ID  |
      | RG_BDAOS_1.8 |