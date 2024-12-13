Feature: Business Directory Scenarios

  Background: Login the page
    Given Launch and login Business Directory Back Office


  @RG_BD_UM_01 @bdusermgt @Regression @BD
  Scenario: RG_BD_UM_01 Able to login directly to BD dashboard/listing
    Then Business directory page should be displayed

  @RG_BD_UM_04 @bdusermgt @Regression @BD
  Scenario: RG_BD_UM_04 Log out from Business Directory
    When Business directory page should be displayed
    Then Click User profile
    And Click User signout
    Then verify user navigated to dashboard page

  @RG_BD_UM_03 @bdusermgt @Regression @BD
  Scenario: RG_BD_UM_03 Switch from BD to other Applications thru the Govstack Dashboard
    When Business directory page should be displayed
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click dashboard link
    Then verify user navigated to dashboard page

  @RG_BD_UM_02 @bdusermgt @Regression @BD
  Scenario: RG_BD_UM_02 Govstack Ribbon is available on BD pages
    When Business directory page should be displayed
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    And Click User profile
    When click on govstack logo
    Then verify dashboard url will be open

  @RG_BD_UM_07 @bdusermgt @Regression @BD
  Scenario: RG_BD_UM_07 GHD account with Approved BD provisioning status can access BD
    Then Business directory page should be displayed