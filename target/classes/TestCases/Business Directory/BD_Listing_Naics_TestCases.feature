Feature: Business Directory Listing Backoffice Scenarios

  Background: Login the page
    Given Launch and login Business Directory Back Office

  @RG_BD_LS_BO_01 @bdNaics @BD
  Scenario: RG_BD_LS_BO_01 Triggering Create Business
    When user Go to Listings tab
    Then click add business
    And verify general tab is open by default

  @RG_BD_LS_BO_03 @bdNaics @BD
  Scenario Outline: RG_BD_LS_BO_03 NAICS Code Text Field
    When user Go to Listings tab
    Then click add business
    And on NAICS code enter the code "<Testcase ID>"
    Examples:
      | Testcase ID        |
      | RG_BD_LS_BO_03     |

  @RG_BD_LS_BO_03 @bdNaics @BD @naicsneg
  Scenario Outline: RG_BD_LS_BO_03 NAICS Code Text Field - With Invalid code and special character negative use case
    When user Go to Listings tab
    Then click add business
    And on NAICS code enter the code with invalid code or special character negative use case "<Testcase ID>"
    Examples:
      | Testcase ID                    |
      | RG_BD_LS_BO_03_invalidcode     |
      | RG_BD_LS_BO_03_specialchar     |

  # This test case id : RG_BD_LS_BO_04 contains mentioned below test cases
  # Test case id : RG_BD_LS_BO_04 New NAICS Code Lookup field
  # Test case id : RG_BD_LS_BO_05 NAICS Code Lookup window with table header content and search bar
  @RG_BD_LS_BO_04 @bdNaics @BD
  Scenario: RG_BD_LS_BO_04 New NAICS Code Lookup field and RG_BD_LS_BO_05 NAICS Code Lookup window with table header content and search bar
    When user Go to Listings tab
    Then click add business
    And click NAICS look up button
    Then verify NAICS look up window is open
    And verify NAICS look up window should have search bar and table column NAICS_code,Industry_title and Copycode is visible

  @RG_BD_LS_BO_07 @bdNaics @BD
  Scenario Outline: RG_BD_LS_BO_07 NAICS Code Lookup window - Search Bar by NAICS code or Title
    When user Go to Listings tab
    Then click add business
    And click NAICS look up button
    Then Search the NAISC code by code or title "<Testcase ID>"
    Examples:
      | Testcase ID          |
      | RG_BD_LS_BO_07_cd    |
      | RG_BD_LS_BO_07_nm    |


  @RG_BD_LS_BO_06 @bdNaics @BD
  Scenario: RG_BD_LS_BO_06 NAICS Code Loopup window - Expand/Collapse items
    When user Go to Listings tab
    Then click add business
    And click NAICS look up button
    And verify that user able to expand and collapse NAICS list grid

  @RG_BD_LS_BO_08 @bdNaics @BD
  Scenario Outline: RG_BD_LS_BO_08 NAICS Code Loopup window - Copy Code
    When user Go to Listings tab
    Then click add business
    And click NAICS look up button
    Then Search the NAISC code by code or title "<Testcase ID>"
    And click copy icon
    Then paste the copied code in NAICS text field
    Examples:
      | Testcase ID       |
      | RG_BD_LS_BO_08    |

    #BD Listing Backoffice test cases started here

  @RG_BD_LS_BO_13 @bdNaics @BD @bdBck
  Scenario: RG_BD_LS_BO_13 Ensure Presence of “Return to Listings” Button in Top Left Corner of Every Listing
    When user Go to Listings tab
    Then click add business
    And verify return to listing button is visible

  @RG_BD_LS_BO_18 @bdNaics @BD @bdBck
  Scenario Outline: RG_BD_LS_BO_18 Grid Clear Search button on Grid
    When user Go to Listings tab
    Then search listing from grid "<Testcase ID>"
    When user click clear button
    Then verify user should be able to a clear search using clear button from grid
    Examples:
      | Testcase ID    |
      | RG_BD_LS_BO_18 |

  @RG_BD_LS_BO_11 @bdNaics @BD @bdBck
  Scenario Outline: RG_BD_LS_BO_11 Click “Keep Editing” to stay on the page and continue editing. Choose “Save Changes”
    When user Go to Listings tab
    Then click edit button
    And do any edit like typing additional character on the name "<Testcase ID>"
    And click return listing button
    Then verify notification message will appear with an option of keep editing or go to listings
    And click keep editing button and save
    Then verify general tab is open by default
    Examples:
      | Testcase ID    |
      | RG_BD_LS_BO_11 |


  @RG_BD_LS_BO_12 @bdNaics @BD @bdBck
  Scenario Outline: RG_BD_LS_BO_12 Return to the Listings page when you're done
    When user Go to Listings tab
    Then click edit button
    And do any edit like typing additional character on the name "<Testcase ID>"
    And click return listing button
    Then verify notification message will appear with an option of keep editing or go to listings
    And click go to listing
    Then verify user is on grid listing
    Examples:
      | Testcase ID    |
      | RG_BD_LS_BO_12 |

  @RG_BD_LS_BO_17 @bdNaics @BD @bdBck
  Scenario Outline: RG_BD_LS_BO_17 GRID - Delete Listing
    When user Go to Listings tab
    Then search listing from grid "<Testcase ID>"
    When click delete button
    Then verify bd listing is deleted from grid
    Examples:
      | Testcase ID    |
      | RG_BD_LS_BO_17 |