Feature: Redirect Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  @RG_RP_1.1 @redirect @Regression @CMS
  Scenario: RG_RP_1.1 Verify Skybrud Redirects package visible
    When go to redirect tab
    Then verify redirect screen is visible

  #This RG_RP_1.2 test contains mentioned below test case id:
  #RG_RP_1.3
  #RG_RP_1.5
  #RG_RP_1.6
  #RG_RP_1.7
  #RG_RP_1.9
  @RG_RP_1.2 @redirect @Regression @CMS
  Scenario Outline: RG_RP_1.2 RG_RP_1.3 RG_RP_1.5 RG_RP_1.6 RG_RP_1.7 RG_RP_1.9 Redirects are configurable - Link existing pages
    When go to redirect tab
    Then click add new redirect button
    And type original url and select destination url "<Testcase ID>"
    Then verify should be able to see Redirects are configurable
    When user click orignal url from list
    Then verify configured redirects are working as expected and directing to the intended pages
    Examples:
      | Testcase ID |
      | RG_RP_1.2   |
      | RG_RP_1.5   |
      | RG_RP_1.6   |
      | RG_RP_1.7   |
      | RG_RP_1.9   |


  @RG_RP_1.10 @redirect @Regression @CMS
  Scenario Outline: RG_RP_1.10 Redirect pointing to an existing media file
    When go to redirect tab
    Then click add new redirect button
    And type original url and select media file "<Testcase ID>"
    Then verify should be able to see Redirects are configurable
    When user click orignal url from list
    Then verify redirect pointing to an existing media file works as expected
    Examples:
      | Testcase ID |
      | RG_RP_1.10  |

  @RG_RP_1.4 @redirect @Regression @CMS
  Scenario Outline: RG_RP_1.4 Redirect support permanent or temporary redirects
    When go to redirect tab
    Then click add new redirect button
    And type original url and select destination url with temporay redirect optin "<Testcase ID>"
    Then verify should be able to see Redirects are configurable
    When user click orignal url from list
    Then verify configured redirects are working as expected and directing to the intended pages
    Examples:
      | Testcase ID |
      | RG_RP_1.4   |