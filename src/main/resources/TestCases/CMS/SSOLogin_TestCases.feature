Feature: SSO Login Scenarios

# ===========================================================================================================================
  # This scenarios will be covered Following test cases
  # TC_GOVCMS317_1,TC_GOVCMS317_2,TC_GOVCMS317_3,TC_GOVCMS317_4
  # =========================================================================================================================
  @Regression @CMS @SSOLogin @Demo
  Scenario: TC_GOVCMS317_1_Validate Login function using SSO implementation
    Given user launch and login GovStack Back Office
    Then Dash board should be displayed

  @Regression @CMS @SSOLogin @SSOSingleLogin
  Scenario: TC_GOVCMS317_2_Validate that an already logged in SSO user will be able to enter by clicking SSO button
    Given Launch and login GovStack CMS Back Office

  @LoginMultipleTabs @Regression @CMS @SSOLogin
  Scenario: TC_GOVCMS317_3_TC_GOVCMS317_4_Validate a user logging into multiple tabs using same SSO login page
    Given user launch and login GovStack Back Office
    And Dash board should be displayed
    Then switch to new tab and validate Login page

# ===========================================================================================================================
  # This scenarios will be covered Following test cases
  # TC_GOVCMS317_6
  #TC_GOVCMS317_7
  # =========================================================================================================================
  @login @Regression @CMS @SSOLogin
  Scenario Outline: TC_GOVCMS317_6_TC_GOVCMS317_7 Validate as a Fed User, validate using an invalid/password
    Given user launch and login GovStack Back Office using fed user or local user with invalid username or password  "<Testcase ID>"
    Examples:
      | Testcase ID    |
      | TC_GOVCMS317_6 |


#  @login @Regression @CMS @SSOLogin
  Scenario Outline: TC_GOVCMS317_7 Validate as a local User, validate using an invalid/password
    Given user launch and login GovStack Back Office using fed user or local user with invalid username or password  "<Testcase ID>"
    Examples:
      | Testcase ID    |
      | TC_GOVCMS317_7 |
