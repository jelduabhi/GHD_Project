Feature: Park and Facilities CMS Scenarios

  Background:
    Given Launch and login GovStack CMS Back Office

  @RG_PFCMS_1.1_RG_PFCMS_1.2 @pfcms @PF
  Scenario Outline: RG_P&FCMS_1.1_RG_P&FCMS_1.2_Validate User can add a parks & facilities page in CMS back office under Content node.
    When user create a parks and fecility page from CMS "<Test Case ID>"
    And PF page should be created
    Then PF page should be posted to Front End
    Examples:
      | Test Case ID  |
      | RG_P&FCMS_1.1 |