Feature: Parks and Facilities Listings (Public URL) Scenarios

  # ####################################################################################################
  #   Author :-  Hazel Bernadette Abiera
  # ####################################################################################################

  #   This scenario will cover RG_PF_LIS_PB_01
  @RG_PF_LIS_PB_01 @PFListings @Regression @PF
  Scenario Outline: RG_PF_LIS_PB_01 PF Listings Landing Page in CMS Backoffice
    Given Launch and login Park and Facilities Back Office
    When User Go to PF Listings tab
    And Search and select a PF listing "<Testcase ID>"
    Then Verify PF listing details in Backend
    Examples:
      | Testcase ID    |
      | RG_P&FLF_1.1   |

  #   This scenario will cover:
  #   RG_PF_LIS_PB_01, RG_PF_LIS_PB_02, RG_PF_LIS_PB_03,
  #   RG_PF_LIS_PB_22, RG_PF_LIS_PB_39, RG_PF_LIS_PB_40
  @RG_PF_LIS_PB_02 @PFListings @Regression @PF
  Scenario Outline: RG_PF_LIS_PB_01, RG_PF_LIS_PB_02, RG_PF_LIS_PB_03, RG_PF_LIS_PB_22, RG_PF_LIS_PB_39, RG_PF_LIS_PB_40 Additional Info should be displayed in Frontend
    Given Launch Parks and Facilities Landing Page
    When Verify PF Listing in Front End "<Testcase ID>"
    And Verify clicking the Website will direct to the site
    Then Go back to PF Landing Page through navigation link
    Examples:
      | Testcase ID     |
      | RG_P&FLF_1.1    |

  #   This scenario will cover:
  #   RG_PF_LIS_PB_20, RG_PF_LIS_PB_24, RG_PF_LIS_PB_25, RG_PF_LIS_PB_26, RG_PF_LIS_PB_27, RG_PF_LIS_PB_41
  @RG_PF_LIS_PB_20 @PFListings @Regression @PF
  Scenario: RG_PF_LIS_PB_20, RG_PF_LIS_PB_24, RG_PF_LIS_PB_25, RG_PF_LIS_PB_26, RG_PF_LIS_PB_27, RG_PF_LIS_PB_41 Listing based on filters applied
    Given Launch Parks and Facilities Landing Page
    When Verify all pf listings result count
    And Filter PF Listings
    Then Verify no available pf listing based on filter applied

  #   This scenario will cover:
  #   RG_PF_LIS_PB_23, RG_PF_LIS_PB_28, RG_PF_LIS_PB_29, RG_PF_LIS_PB_30, RG_PF_LIS_PB_31,
  #   RG_PF_LIS_PB_32, RG_PF_LIS_PB_33, RG_PF_LIS_PB_34
  @RG_PF_LIS_PB_23 @PFListings @Regression @PF
  Scenario: RG_PF_LIS_PB_23, RG_PF_LIS_PB_28, RG_PF_LIS_PB_29, RG_PF_LIS_PB_30, RG_PF_LIS_PB_31, RG_PF_LIS_PB_32, RG_PF_LIS_PB_33, RG_PF_LIS_PB_34 Test Pagination in PF Landing Page
    Given Launch Parks and Facilities Landing Page
    When Test pagination