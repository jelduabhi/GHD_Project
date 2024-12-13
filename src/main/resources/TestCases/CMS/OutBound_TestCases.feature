Feature: OutBound Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  # ####################################################################################################
  #   Author :-  Sai Kumar Jeldu
  # ####################################################################################################
  @RG_OL_1.1 @Regression @CMS @OutBound
  Scenario Outline:  RG_OL_1.1_RG_OL_1.7_Verify User is able to add Outbound Link under regular page
    When user navigate to regular page
    And user add outbound link to the regular page "<Test Case ID>"
    And outbound link should be added
    And user launch the outbound front end page
    Then outbound link should be displayed in front end page
    Examples:
      | Test Case ID |
      | RG_OL_1.1_RG_OL_1.10    |
      | RG_OL_1.7_RG_OL_1.11    |
      | RG_OL_1.7.1    |
      | RG_OL_1.7.2    |
      | RG_OL_1.7.3    |

  @RG_OL_1.2 @Regression @CMS @OutBound
  Scenario: RG_OL_1.2_Verify user Cannot add Outbound Link on homepage
    When user navigate to regular page
    And user try to add Outbound Link on homepage
    Then user should not see Outbound Link on homepage

  @RG_OL_1.3 @Regression @CMS @OutBound
  Scenario Outline: RG_OL_1.3_Verify user is able to create regular page under Outbound Link
    And user navigate to regular page
    When user add the regular page under Outbound link "<Test Case ID>"
    Then regular page should be added under Outbound link
    Examples:
      | Test Case ID |
      | RG_OL_1.3    |

  @RG_OL_1.4 @Regression @CMS @OutBound
  Scenario Outline: RG_OL_1.4_Verify user is able to create another Outbound Link node under Outbound Link
    When user navigate to regular page
    And user navigate to created outbound link
    And user create a new outbound link under Outbound Link "<Test Case ID>"
    Then outbound link should be added
    Examples:
      | Test Case ID |
      | RG_OL_1.4    |


  @RG_OL_1.5 @Regression @CMS @OutBound
  Scenario Outline: RG_OL_1.5_Verify The Outbound Link should not be saved if the fields are empty
    When user navigate to regular page
    And user create a new outbound link under Outbound Link without any details
    Then "<Error message>" should be displayed
    Examples:
      | Error message                                                |
      | Validation errors must be fixed before the item can be saved |

  @RG_OL_1.6 @OutBound
  Scenario Outline:  RG_OL_1.6_External URL property value must always start in http or https
    When user navigate to regular page
    And user add outbound link without http to the regular page "<Test Case ID>"
    Then an error message should be displayed
    Examples:
      | Test Case ID |
      | RG_OL_1.6    |

  @RG_OL_1.8 @Regression @CMS @OutBound
  Scenario Outline:  RG_OL_1.8_Verify User is able to add Outbound Link under regular page
    When user navigate to regular page
    And user edited outbound link to the regular page "<Test Case ID>"
    Then outbound link should be added
    Examples:
      | Test Case ID |
      | RG_OL_1.8    |

  @RG_OL_1.9 @Regression @CMS @OutBound
  Scenario:  RG_OL_1.9_Verify User is able to add Outbound Link under regular page
    When user navigate to regular page
    And user delete the existing outbound link to the regular page
    Then outbound link should not be added

  @RG_OL_1.12 @Regression @CMS @OutBound
  Scenario Outline:  RG_OL_1.12_RG_OL_1.13_Verify User is able to add Outbound Link under sub nav page
    When user navigate to sub nav page
    And user add outbound link to the subnav page "<Test Case ID>"
    Then outbound link should be added
    And user launch the outbound front end page
    Then outbound link should be displayed under sub Nav page
    Examples:
      | Test Case ID |
      | RG_OL_1.12    |