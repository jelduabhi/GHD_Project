Feature: Search Engine Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office
    #Given Launch and login GovStack Dashboard

  @SearchEngine @Regression @CMS
    Scenario Outline: SE_Config_001_002_003_004_Set up google Google Search Engine
      When user navigate to Search Engine Configuration
      And user create google search "<Test Case ID>"
      Then search engine should be created
     # When user create a new Theme configuration for Topnav Search Engine
     # And Theme should be created
      #Then validate in Front End if
    Examples:
        | Test Case ID |
        |SE_Config_001 |
        |SE_Config_002 |
        |SE_Config_003 |
        |SE_Config_004 |