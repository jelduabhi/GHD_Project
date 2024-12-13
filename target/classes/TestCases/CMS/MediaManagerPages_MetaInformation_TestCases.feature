Feature: Media Manager Pages AT - Meta Information Fields Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  # ===========================================================================================================================
  # Author: - Sai Kumar Jeldu
  # This scenarios will be covered Following test cases
  # TC_MP_01 to TC_MP_018
  # =========================================================================================================================
  @TC_MP_01 @MediaManagerMetaInformation @MediaManager
  Scenario Outline: TC_MP_01 to TC_MP_018 Verify if able to create media pages for Meta Information Fields with Text Fields
    When user create a Subfolder Media Pages
    And user create Media Page for Meta Information fields with Text Fields "<TestCase ID>"
    Then Values should be successfully added and working on frontend.
    Examples:
      | TestCase ID |
      | TC_MP_02    |