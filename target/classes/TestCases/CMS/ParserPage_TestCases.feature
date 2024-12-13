Feature: Parser Page Scenarios

  # ####################################################################################################
  #   Author :-  Hazel Bernadette Abiera
  # ####################################################################################################

  #   This scenario will cover RG_PP_1.1 and RG_PP_1.3
  @RG_PP_1.1 @RG_PP_1.3 @setupParserOnCMS @ParserPage @Regression @CMS
  Scenario Outline: RG_PP_1.1 and RG_PP_1.3 Set up Parser on CMS
    Given Launch and login GovStack CMS Back Office
    And Go to Content Home and Navigate to Parsers Main page
    And Create New Parser Page "<TestcaseID>"
    Then User should be able to publish the parser
    Examples:
      | TestcaseID  |
      | RG_PP_1.1   |
      | RG_PP_1.3   |

  #   This scenario will cover RG_PP_1.2
  @RG_PP_1.2 @configEventsMgt @ParserPage @Regression @CMS
  Scenario Outline: RG_PP_1.2 Configuration on Events Management - Calendar
    Given Launch and Login to Calendar Event Management "<TestcaseID>"
    When Navigate to Configuration Tab - Templates
    And Update the Remote URL and Verify Element ID "<TestcaseID>"
    And Save Calendar Template
    Then Calendar Template should be updated in Management View "<TestcaseID>"
    Examples:
      | TestcaseID  |
      | RG_PP_1.2   |

  #   This scenario will cover RG_PP_1.4
  @RG_PP_1.4 @setupParserOnCMSFormBuilder @ParserPage @Regression @CMS
  Scenario Outline: RG_PP_1.4 Configuration on Forms Management
    Given Launch and Login to Form Management "<TestcaseID>"
    When Navigate to FB Configuration Tab - Templates
    And Update the Remote URL and Verify Element ID "<TestcaseID>"
    And Save Form Builder Template
    Then Verify Demo Form should be updated "<TestcaseID>"
    Examples:
      | TestcaseID  |
      | RG_PP_1.4   |

  #   This scenario will cover RG_PP_1.5, RG_PP_1.6, RG_PP_1.7
  @RG_PP_1.5 @testFormBuilderParser @ParserPage @Regression @CMS
  Scenario Outline: RG_PP_1.5 Test Form Builder with Parser Page
    Given Launch Demo Form "<TestcaseID>"
    When Test Parser Page with Test Form
    And Verify Thank You Message should appear
    Examples:
      | TestcaseID  |
      | RG_PP_1.4   |

  #   This scenario will cover RG_PP_1.8, RG_PP_1.9
  @RG_PP_1.8 @RG_PP_1.9 @topNavigationParser @ParserPage @Regression @CMS
  Scenario Outline: RG_PP_1.8 Validate Top Navigation is responsive
    Given Launch Demo Form "<TestcaseID>"
    When Verify Top Navigation is responsive
    Examples:
      | TestcaseID  |
      | RG_PP_1.4   |


  #   Clean up
  @deleteParser @ParserPage @Cleanup @Regression @CMS
  Scenario Outline: Delete Parser on CMS
    Given Launch and login GovStack CMS Back Office
    And Go to Content Home and Navigate to Parsers
    And Delete Parser "<TestcaseID>"
    Examples:
      | TestcaseID  |
      | RG_PP_1.1   |
      | RG_PP_1.3   |

  #   Revert Events Config
  @revertEventsConfig @ParserPage @Cleanup @Regression @CMS
  Scenario Outline: Revert Events Config
    Given Launch and Login to Calendar Event Management "<TestcaseID>"
    When Navigate to Configuration Tab - Templates
    And Update the Remote URL and Verify Element ID "<TestcaseID>"
    And Save Calendar Template
    Then Calendar Template should be updated in Management View "<TestcaseID>"
    Examples:
      | TestcaseID        |
      | RG_PP_1.2_Revert  |

  #   Revert Forms Config
  @revertFormsConfig @ParserPage @Cleanup @Regression @CMS
  Scenario Outline: Revert Forms Config
    Given Launch and Login to Form Management "<TestcaseID>"
    When Navigate to FB Configuration Tab - Templates
    And Update the Remote URL and Verify Element ID "<TestcaseID>"
    And Save Form Builder Template
    Then Verify Demo Form should be updated "<TestcaseID>"
    Examples:
      | TestcaseID        |
      | RG_PP_1.4_Revert  |