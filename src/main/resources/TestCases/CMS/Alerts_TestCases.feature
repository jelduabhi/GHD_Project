Feature: Alert Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office
    When Go to Content Home and Navigate to Alerts page
# ===========================================================================================================================
  # Author: - Sai Kumar Jeldu
  # This scenarios will be covered Following test cases
  # RG_AL_1.1, RG_AL_1.2, RG_AL_1.3,RG_AL_1.4, RG_AL_3.1,RG_AL_3.2 RG_AL_3.3, RG_AL_3.4,RG_AL_3.5, RG_AL_3.6
  # RG_AL_3.7 RG_AL_3.8 and RG_AL_4.1
  # =========================================================================================================================
  @createAlert @Alerts @Sanity @Regression @CMS
  Scenario Outline: RG_AL_1.1_3.1_3.3_3.5_3.7_3.8_4.1_Create Alerts Page -  Popup
    When Create new alerts "<Testcase ID>"
    And Should be able to post the alert
    Then Alerts will be display under Alerts item
    And User launch the Alert frond end application in new tab
    Then User should be able to see Alert details
    Examples:
      | Testcase ID       |
      | RG_AL_1.1_Info    |
      | RG_AL_1.1_Success |
      | RG_AL_1.1_Warning |
      | RG_AL_1.1_Danger  |
      | RG_AL_3.1         |
      | RG_AL_3.3         |
      | RG_AL_3.5         |
      | RG_AL_3.7         |

  @UpdateAlert @Alerts @Regression @CMS
  Scenario Outline: RG_AL_1.3_Update Alert - Popup
    When User update the alert details "<Testcase ID>"
    And User launch the Alert frond end application in new tab
    Then User should be able to see Alert details
    Examples:
      | Testcase ID      |
      | RG_AL_1.3_Update |

  # ================================================================================================
  #  Author: - Sai Kumar Jeldu
  # This scenarios will be covered Following test cases
  # RG_AL_2.1, RG_AL_2.2, RG_AL_2.3, RG_AL_2.4 and RG_AL_4.3
  # ===============================================================================================
  @createAndUpdateAlert_Banner @Alerts @Regression @CMS
  Scenario Outline: RG_AL_2.1_2.2_2.3_2.4_4.3_Create Alerts Page -  Banner
    When Create new alerts "<Testcase ID>"
    And Should be able to post the alert
    Then Alerts will be display under Alerts item
    And User launch the Alert frond end application in new tab
    Then User should be able to see Alert details in banner
    Examples:
      | Testcase ID       |
      | RG_AL_2.1_Info    |
      | RG_AL_2.1_Success |
      | RG_AL_2.1_Warning |
      | RG_AL_2.1_Danger  |

  @UpdateBannerAlert @Alerts @Regression @CMS
  Scenario Outline: RG_AL_2.4_Update Alert - Banner
    When User update the alert details "<Testcase ID>"
    And User launch the Alert frond end application in new tab
    Then User should be able to see Alert details in banner
    Examples:
      | Testcase ID      |
      | RG_AL_2.1_Update |

  # ================================================================================================
  #  Author: - Sai Kumar Jeldu
  # This scenarios will be covered Following test cases
  # RG_AL_1.5, RG_AL_1.6,RG_AL_2.5 and RG_AL_2.6
  # ===============================================================================================
  @deleteAlert @Alerts @Regression @CMS
  Scenario Outline: RG_AL_1.5,RG_AL_1.6,RG_AL_2.5 and RG_AL_2.6_Delete Update Alerts Page Popup
    When user selects existing alert and delete alert "<Alert Type>"
    And deleted alert should be displayed in recycle bin
    And User launch the Alert frond end application in new tab
    Then deleted alert should not be posted to front end
    Examples:
      | Alert Type |
      | Pop up     |
      | Banner     |

  # ================================================================================================
  #  Author: - Nitin
  # ===============================================================================================
  @RG_AL_3.9 @Alerts @Regression @CMS
  Scenario Outline: RG_AL_3.9 Alert without start date validation message should be visible
    When Create new alerts "<Testcase ID>" without start date
    And validation message will be visible to user
    Examples:
      | Testcase ID |
      | RG_AL_3.9   |

  @RG_AL_3.10 @Alerts @Regression @CMS
  Scenario Outline: RG_AL_3.10 Alert without end date
    When Create new alerts "<Testcase ID>"
    And Should be able to post the alert
    Then Alerts will be display under Alerts item
    When User launch the Alert frond end application in new tab
    Then User should be able to see Alert details
    Examples:
      | Testcase ID |
      | RG_AL_3.10  |



