Feature: Calender Scenarios

  # ===========================================================================================================================
  # Author: - Sai Kumar Jeldu
  # This scenarios will be covered Following test cases
  # GOVCMS-1360_02 to GOVCMS-1360_06,GOVCMS-1360_08
  # =========================================================================================================================
  @GOVCMS-1360_04
  Scenario Outline: GOVCMS-1360_02_GOVCMS-1360_03_Verify that if no calendar is configured in Tenant Services, an error message is present
    Given user launch tenant application
    When user submit tenant app with or without calender "<TestCase ID>"
    And user launch the CMS application
    And create a new page under main with calendar content
    And validate calender in front end page
    #Then an error message should be displayed
    Examples:
      | TestCase ID    |
     # | GOVCMS-1360_02 |
     # | GOVCMS-1360_03 |
     # | GOVCMS-1360_04 |
     # | GOVCMS-1360_05 |
      | GOVCMS-1360_06 |

  @GOVCMS-1360_02
  Scenario Outline: GOVCMS-1360_04_Verify that if no calendar is configured in Tenant Services, an error message is present
    Given user launch tenant application
    When user submit tenant app with or without calender "<TestCase ID>"
    And user launch the CMS application
    And create a new page under main with calendar content
    And validate calender in front end page
    #Then an error message should be displayed
    Examples:
      | TestCase ID    |
      | GOVCMS-1360_02 |
      | GOVCMS-1360_03 |
