Feature: Dashboard Ribbon Scenarios

  Background: Login the page
    Given Launch and login GovStack Dashboard


  @GOV_DSHBRD_0011 @ribbon @appSwitcher @Regression @CMS @DashBoardRibbon
  Scenario: GOV_DSHBRD_0011_Validate user can access Dashboard
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal

  @GOVPORT_005 @ribbon @Regression @CMS @DashBoardRibbon
  Scenario: GOVPORT_005_user click citizen portal link then verify citizen portal url is open
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click citizen portal link then verify citizen portal url is open


  @GOVPORT_011 @help @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOVPORT_011_Dashboard Help
    Then Verify Dashboard Help "<TestcaseID>"
    Examples:
      | TestcaseID |
      | RG_DB_1.6  |

  @GOVPORT_012 @help @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOVPORT_012_Dashboard Help support link
    Then Verify Dashboard Help "<TestcaseID>"
    When Click support link
    Then verify support link open i new tab
    Examples:
      | TestcaseID |
      | RG_DB_1.6  |

  @GOVPORT_013 @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOVPORT_013_Dashboard Help learning center
    Then Verify Dashboard Help "<TestcaseID>"
    When Click learning center link
    Then verify learning center link open i new tab
    Examples:
      | TestcaseID  |
      | GOVPORT_013 |

  @GOV_DSHBRD_0020 @userProfile @Regression @CMS @DashBoardRibbon
  Scenario: GOV_DSHBRD_0020_Govstack logo redirects to dashboard
    When click on govstack logo
    Then verify dashboard url will be open

  @GOV_DSHBRD_0025 @userProfile @Regression @CMS @DashBoardRibbon
  Scenario: GOV_DSHBRD_0025_Validate user can access User Profile
    When Click User profile

  @GOV_DSHBRD_0027 @userProfile @Regression @CMS @DashBoardRibbon
  Scenario: GOV_DSHBRD_0027_Validate user can access Manage Users
    When Click User profile
    And Click manage user link
    Then verify manage use link open i new tab

  @GOV_DSHBRD_0028 @userProfile @Regression @CMS @DashBoardRibbon
  Scenario: GOV_DSHBRD_0028_Validate user can Sign Out
    When Click User profile
    Then Click User signout

  @GOV_DSHBRD_0016 @appSwitcher @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0016_Validate user can access Business Directory  thru the App Switcher
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click business Directory link
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url               |
      | businessdirectory |

  @GOV_DSHBRD_0017 @appSwitcher @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0017_Validate user can access Parks and Facilities  thru the App Switcher
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click park and facilities link
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url                |
      | parksandfacilities |

  @GOV_DSHBRD_0018 @appSwitcher @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0018_Validate user can access Subscription Management thru the App Switcher
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click subscription management link
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url          |
      | subscription |

  @GOV_DSHBRD_0019 @appSwitcher
  Scenario Outline: GOV_DSHBRD_0019_Validate user can access Tenant Services thru the App Switcher
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click tenant service link
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url           |
      | tenantservice |

  @GOV_DSHBRD_0006 @card @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0006_Validate user can access Citizen thru the Card
    When user click "<url>" card
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url           |
      | citizenportal |

  @GOV_DSHBRD_0007 @card @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0007_Validate user can access Business Directory thru the Card
    When user click "<url>" card
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url               |
      | businessdirectory |

  @GOV_DSHBRD_0008 @card @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0008_Validate user can access Parks and Facilities thru the Card
    When user click "<url>" card
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url                |
      | parksandfacilitie |

  @GOV_DSHBRD_0009 @card @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0009_Validate user can access Subscription Management thru the Card
    When user click "<url>" card
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url          |
      | subscription |

  # =========================================================
  # Waiting for deployment in STAGE
  #=============================================================

  @GOV_DSHBRD_0010 @card
  Scenario Outline: GOV_DSHBRD_0010_Validate user can access Tenant Services thru the Card
    When user click "<url>" card
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url           |
      | tenantservice |

  @GOV_DSHBRD_0004 @cardQaEnvt @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0004_Validate user can access events  thru the Card
    When user click "<url>" card
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url      |
      | calendar |

  @GOV_DSHBRD_0005 @cardQaEnvt @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0005_Validate user can access Forms  thru the Card
    When user click "<url>" card
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url         |
      | formbuilder |

  @GOV_DSHBRD_0002 @cardQaEnvt @Regression @CMS @DashBoardRibbon
  Scenario: GOV_DSHBRD_0002_Validate Govstack Application Cards
    Then verify cards visible

  @GOV_DSHBRD_0021 @cardQaEnvt @Regression @CMS @DashBoardRibbon
  Scenario: GOV_DSHBRD_0021_Validate user can access Top Navigation Settings - Role Management Module
    When user click setting link and manage user link
    Then verify manage use link open i new tab

  @GOV_DSHBRD_0013 @cardQaEnvt @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0013_Validate user can access Events  thru the App Switcher
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click events link
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url      |
      | calendar |

  @GOV_DSHBRD_0012 @cardQaEnvt @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0012_Validate user can access Events  thru the App Switcher
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click cms link
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url         |
      | govstackcms |

  @GOV_DSHBRD_0014 @cardQaEnvt @Regression @CMS @DashBoardRibbon
  Scenario Outline: GOV_DSHBRD_0014_Validate user can access Forms  thru the App Switcher
    Then Verify nav icon click with list of CMS, Events, Forms, Citizen Portal
    When user click forms link
    Then verify url is open "<url>"
    When click on govstack logo
    Then verify dashboard url will be open
    Examples:
      | url  |
      | form |