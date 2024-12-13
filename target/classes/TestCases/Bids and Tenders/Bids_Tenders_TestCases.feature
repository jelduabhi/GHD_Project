Feature: Bids and tenders smoke test cases Scenarios

  Background: Login the page
    Given Launch and login Bids and tender Back Office


  @BT_SMOKE_01 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_01 Create Team Member
    When user go to team members
    And add a new team member with tag as purchaser and Assign to group with all permissions "<Testcase ID>"
    Then verify a new team member is created in pro with all permissions
    Examples:
      | Testcase ID    |
      | BT_SMOKE_01    |

  @BT_SMOKE_02 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_02_BT_SMOKE_03_BT_SMOKE_04_BT_SMOKE_05_BT_SMOKE_06_BT_SMOKE_13_BT_SMOKE_17_BT_SMOKE_18 Create a Project (wizard)
    #When user search for a project
  When user go to project tab select create a project
   And select create a new project option and select source card
    Then enter project details "<Testcase ID>"
   And in procurement method screen select invitational card and select procurement method
  And allow multiple submission and verify project created and user able to search created project
    And user enters the details details for BT
    And user enters Documents details
    And user enters the Submission Requirements details
   And user enters the invitation details
    And user enters the dates details
    Then user should be able to publish the project
    Then user upload a document to Addenda and Questions Section
    Then user download the submission
    Examples:
      | Testcase ID    |
      | BT_SMOKE_02    |

  @BT_SMOKE_07 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_07 Create new supplier account
    When user go to evaluator portal link
    Then click create account button
    And fill all supplier details "<Testcase ID>"
    #Then verify supplier is created
    #And verify supplier is able to logged in with new supplier account
    Examples:
      | Testcase ID    |
      | BT_SMOKE_07    |

  @BT_SMOKE_08 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_08 Update existing supplier account
    When user go to evaluator portal link
    Then login with existing supplier account "<Testcase ID>"
    And make some updates on the supplier details "<Testcase ID>"
    Then verify supplier account details should be updated successfully
    Examples:
      | Testcase ID    |
      | BT_SMOKE_08    |

  @BT_SMOKE_19 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_19 Start Contract
    When user go to project tab select create a project
    And select create a new project option and select contract card
    Then enter project details "<Testcase ID>"
    And allow multiple submission in contract criteria and verify project created and user able to search created project
    And select project from grid
    And select contract tab
    And add start date end date and project value
    And go to supplier tab and invite supplier
    When user click start contract button
    Then verify close contract button is visible
    Examples:
      | Testcase ID    |
      | BT_SMOKE_19    |

  @BT_SMOKE_20 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_20 Permissions by Department
    When user go to project tab select create a project
    And select create a new project option and select source card
    Then enter project details "<Testcase ID>"
    And in procurement method screen select invitational card and select procurement method
    And allow multiple submission and verify project created and user able to search created project
    And select project from grid
    When user go to add team member and assign the access
    #Then verify user should be only that project which assigned Teststeps is missing on test cases hence commenting this
    Examples:
      | Testcase ID    |
      | BT_SMOKE_02    |

  @BT_SMOKE_21 @bidsTenderSmokeTest
    Scenario: BT_SMOKE_21 Intake essentials
    When user click copy intake request url button
    Then verify intake request url open in new tab

  @BT_SMOKE_22 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_22 Create intake request
    When user click copy intake request url button
    Then verify intake request url open in new tab
    And click start request button
    And fill intake form mandatory field "<Testcase ID>"
    #When user click submit request button
    #Then verify intake request submitted successfully
    Examples:
      | Testcase ID    |
      | BT_SMOKE_22    |

  @BT_SMOKE_25 @bidsTenderSmokeTest
  Scenario: BT_SMOKE_25 Download intake request document
    When user go to project tab select find a project
    Then search a project
    And verify result is accurate based on search criteria
    And select the intake number
    When user click print request to pdf button
    Then verify report should be downloaded with accurate data

  @BT_SMOKE_27 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_27 Accept intake request
    When user click view button from manage option
    And select create a new project option and select source card
    Then enter project details for intake "<Testcase ID>"
    And in procurement method screen select invitational card and select procurement method
    And allow multiple submission and verify project created and user able to search created project
    Examples:
      | Testcase ID    |
      | BT_SMOKE_02    |


  @BT_SMOKE_29 @bidsTenderSmokeTest
  Scenario: BT_SMOKE_29 Search intake request
    When user go to project tab select find a project
    Then search a project
    And verify result is accurate based on search criteria

  @BT_SMOKE_26 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_26 Decline Intake request
    When On Main Dashboard, go to Intake: pending requests and look for the created intake request "<Testcase ID>"
    And Click on ‘View’ under manage column
    And On view page, click on ‘Decline’ button
    And On decline pop-up window, provide the reason for declining
    And Click on Decline button
    And Click on ‘View decline comment’ "<Testcase ID>"
#  Look for the uploaded document and click on Download button (skip for now)
#  Click on ‘Print request to PDF’ button
    Examples:
      | Testcase ID    |
      | BT_SMOKE_26    |

  @BT_SMOKE_23 @bidsTenderSmokeTest
  Scenario Outline: BT_SMOKE_23_BT_SMOKE_24 Print request to PDF
    When On Main Dashboard, go to Intake: pending requests and look for the created intake request "<Testcase ID>"
    And Click on ‘View’ under manage column
    Then On intake request view page, click on ‘Print request to PDF’ button
    Examples:
      | Testcase ID    |
      | BT_SMOKE_26    |