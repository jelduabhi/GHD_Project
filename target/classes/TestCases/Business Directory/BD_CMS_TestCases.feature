Feature: Business Directory CMS Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  #This test_case covered mentioned below test case:
  #TestCase_id:RG_BD_CMS_01
  #TestCase_id:RG_BD_CMS_04
  @RG_BD_CMS_01 @bdcms @Regression @BD
  Scenario Outline: RG_BD_CMS_01 and RG_BD_CMS_04 Add a business directory listing and details page in CMS back office under Content node
    When Go to main home page
    Then Go to create page under main site
    And create business directory landing page "<Testcase ID>"
    Then verify business directory page in frontend
    Examples:
      | Testcase ID  |
      | RG_BDCMS_1.1 |

  #This test_case covered mentioned below test case:
  #TestCase_id:RG_BD_CMS_02
  #TestCase_id:RG_BD_CMS_03
  @RG_BD_CMS_02 @bdcms @Regression @BD
  Scenario Outline: RG_BD_CMS_02 and RG_BD_CMS_03 Link to the sector selection grid directly
    When Go to main home page
    When user go to created business directory landing page
    Then select business directory sector page
    And create business directory sector page "<Testcase ID>"
    Then verify user should be able to link to filtered searches (for each individual sector) directly
    Examples:
      | Testcase ID  |
      | RG_BDCMS_1.2 |
