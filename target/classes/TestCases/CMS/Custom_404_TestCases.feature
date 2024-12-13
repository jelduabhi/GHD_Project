Feature: Custom 404 Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office
    When Go to Content Home and Navigate to page not found page

  #Contains following test cases:
  # RG_CP_1.1
  # RG_CP_1.2

  @RG_CP_1.1 @Regression @CMS
  Scenario Outline: RG_CP_1.1 Configure 404 page from backend & Frontend
    When Create new page not found page "<Testcase ID>"
    And User should be able to publish the page
    When User launch the page not found frond end url in new tab
    Then validate the page not found message
    Examples:
      | Testcase ID |
      | RG_CP_1.1   |