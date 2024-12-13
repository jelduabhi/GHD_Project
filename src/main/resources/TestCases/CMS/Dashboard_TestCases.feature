Feature: Dashboard Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  # ================================================================================================
  #  Author: - Kavya
  # ===============================================================================================

  @RG_DB_1.1 @RG_DB_1.2 @Dashboard @Regression @CMS
  Scenario Outline:  RG_DB_1.1_1.2_Login in Dashboard as an Admin And Verify Welcome Message
    Then Verify Dashboard Welcome message "<TestcaseID>"
    Examples:
      | TestcaseID |  |
      | RG_DB_1.2  |  |

  @RG_DB_1.3 @Dashboard @Regression @CMS
  Scenario Outline: RG_DB_1.3_Dashboard Recent Activities
    Then Verify Dashboard Recent Activities "<TestcaseID>"
    Examples:
      | TestcaseID |
      | RG_DB_1.3  |

  @RG_DB_1.4 @Dashboard @Regression @CMS
  Scenario Outline: RG_DB_1.4_Dashboard My recent Activites
    Then Verify Dashboard My recent Activites "<TestcaseID>"
    Examples:
      | TestcaseID |
      | RG_DB_1.4  |

  @RG_DB_1.5 @Dashboard @Regression @CMS
  Scenario Outline: RG_DB_1.5_Dashboard Unpublished Content
    Then Verify Dashboard Pending Content "<TestcaseID>"
    Examples:
      | TestcaseID |
      | RG_DB_1.5  |

  @RG_DB_1.6 @Dashboard @Regression @CMS
  Scenario Outline: RG_DB_1.6_Dashboard Help
    Then Verify Dashboard Help "<TestcaseID>"
    Examples:
      | TestcaseID |
      | RG_DB_1.6  |
