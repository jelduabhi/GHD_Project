Feature: Business Directory Listings (Public URL) Scenarios

  # ####################################################################################################
  #   Author :-  Hazel Bernadette Abiera
  # ####################################################################################################

 #   This scenario will cover RG_BD_LIS_PB_01
  @RG_BD_LIS_PB_01 @BDListings @Regression @BD
  Scenario Outline: RG_BD_LIS_PB_01 BD Sector Landing Page in CMS Backoffice
    Given Launch and login Business Directory Back Office
    When user Go to Listings tab
    And Search and select a listing "<Testcase ID>"
    Then Verify listing details in Backend
    Examples:
      | Testcase ID    |
      | RG_BDLF_1.1    |

  #   This scenario will cover:
  #   RG_BD_LIS_PB_02, RG_BD_LIS_PB_03, RG_BD_LIS_PB_04, RG_BD_LIS_PB_05,
  #   RG_BD_LIS_PB_06, RG_BD_LIS_PB_42
  @RG_BD_LIS_PB_02 @BDListings @Regression @BD
  Scenario Outline: RG_BD_LIS_PB_02, RG_BD_LIS_PB_03, RG_BD_LIS_PB_04, RG_BD_LIS_PB_05, RG_BD_LIS_PB_06, RG_BD_LIS_PB_42 Additional Info should be displayed in Frontend
    Given Launch Business Directory Landing Page
    When Verify BD Listing in Front End "<Testcase ID>"
    And Verify clicking the Website URL will direct to the site
    Then Go back to BD Landing Page
    Examples:
      | Testcase ID    |
      | RG_BDLF_1.1    |

  #   This scenario will cover RG_BD_LIS_PB_07, RG_BD_LIS_PB_25 and RG_BD_LIS_PB_43
  @RG_BD_LIS_PB_07 @BDListings @Regression @BD
  Scenario: RG_BD_LIS_PB_07, RG_BD_LIS_PB_25, RG_BD_LIS_PB_43 Social Icons should be displayed and clickable
    Given Launch Business Directory Landing Page
    When Search and select a listing in Frontend
    And Verify clicking the Social Icons will direct to the site
    Then Go back to BD Landing Page through navigation link

  #   This scenario will cover:
  #   RG_BD_LIS_PB_23, RG_BD_LIS_PB_25, RG_BD_LIS_PB_27, RG_BD_LIS_PB_28,
  #   RG_BD_LIS_PB_29, RG_BD_LIS_PB_44
  @RG_BD_LIS_PB_23 @BDListings @Regression @BD
  Scenario: RG_BD_LIS_PB_23,RG_BD_LIS_PB_25, RG_BD_LIS_PB_27, RG_BD_LIS_PB_28, RG_BD_LIS_PB_29, RG_BD_LIS_PB_44 Listing based on filters applied
    Given Launch Business Directory Landing Page
    When Verify all listings result count
    And Filter Listings
    Then Verify no available listing based on filter applied

  #   This scenario will cover:
  #   RG_BD_LIS_PB_26, RG_BD_LIS_PB_30, RG_BD_LIS_PB_31, RG_BD_LIS_PB_32,
  #   RG_BD_LIS_PB_33, RG_BD_LIS_PB_34, RG_BD_LIS_PB_35, RG_BD_LIS_PB_36, RG_BD_LIS_PB_37
  @RG_BD_LIS_PB_26 @BDListings @Regression @BD
  Scenario: RG_BD_LIS_PB_26, RG_BD_LIS_PB_30, RG_BD_LIS_PB_31, RG_BD_LIS_PB_32, RG_BD_LIS_PB_33, RG_BD_LIS_PB_34, RG_BD_LIS_PB_35, RG_BD_LIS_PB_36, RG_BD_LIS_PB_37 Test Pagination in Business Directory Landing Page
    Given Launch Business Directory Landing Page
    When Test results per page