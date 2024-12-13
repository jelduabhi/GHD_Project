Feature: Media Manager Listing Scenarios

  # ####################################################################################################
  #   Author :-  Hazel Bernadette Abiera
  # ####################################################################################################

  #   This scenario will cover MM_Listing_01, MM_Listing_02 and MM_Listing_03
  @MM_Listing_01_02_03 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  MM_Listing_01_02_03 A new “Media Manager Listing” component that displays the Media Pages in a feed on a regular page
    Given Launch and login GovStack CMS Back Office
    When Navigate to the Test Page '<TestcaseID>'
    And Add Media Manager Content
    And Click Save and Publish
    Examples:
      | TestcaseID          |
      | MM_Listing_01_02_03 |

  #   This scenario will cover MM_Listing_04
  @MM_Listing_04 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  MM_Listing_04 “Media Manager Listing” Content - Extra Content
    Given Launch and login GovStack CMS Back Office
    When Navigate to the Test Page '<TestcaseID>'
    And Navigate to Extra Content Tab
    And Add Media Manager Content in Extra Content Tab
    And Click Save and Publish
    Then Launch Media Manager front end application
    And Verify Extra Content in Front End
    Examples:
      | TestcaseID    |
      | MM_Listing_04 |

  #   This scenario will cover clean up step for MM_Listing_04
  @MM_Listing_04 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  Clean Up Step for Extra Content
    Given Launch and login GovStack CMS Back Office
    When Navigate to the Test Page '<TestcaseID>'
    And Navigate to Extra Content Tab
    And Remove Media Manager Content in Extra Content Tab
    And Click Save and Publish
    Examples:
      | TestcaseID    |
      | MM_Listing_04 |

  #   This scenario will cover MM_Listing_05
  @MM_Listing_05 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  MM_Listing_05 “Media Manager Listing” Settings - Design and Layout
    Given Launch and login GovStack CMS Back Office
    When Navigate to the Test Page '<TestcaseID>'
    And Navigate to Settings - Design and Layout
    And Configure Design and Layout for Grid View
    Then Remove Meta Info
    And Click Save and Publish
    Examples:
      | TestcaseID    |
      | MM_Listing_04 |

  #   This scenario will cover MM_Listing_06
  @MM_Listing_06 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  MM_Listing_06 “Media Manager Listing” Settings - Table View
    Given Launch and login GovStack CMS Back Office
    When Navigate to the Test Page '<TestcaseID>'
    And Navigate to Settings - Design and Layout
    And Select Table View as Presentation View
    Then Configure Table View Settings
    And Click Save and Publish
    Then Launch Media Manager front end application in new tab
    And Verify Table View configurations in Front End
    Examples:
      | TestcaseID    |
      | MM_Listing_06 |

  #   This scenario will cover MM_Listing_10 and MM_Listing_11
  @MM_Listing_10_11 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  MM_Listing_10_11 “Media Manager Listing” component - Filtering Options and Pagination
    Given Launch Media Manager front end application
    And Test Filtering Options '<TestcaseID>'
    Then Test Media Listing Pagination
    Examples:
      | TestcaseID    |
      | MM_Listing_10 |

  #   This scenario will cover MM_Listing_12 and MM_Listing_13
  @MM_Listing_12_13 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  MM_Listing_12_13_14 “Media Manager Listing” - Download and View File
    Given Launch Media Manager front end application
    And Test Download and View File '<TestcaseID>'
    Examples:
      | TestcaseID    |
      | MM_Listing_14 |

  #   This scenario will cover MM_Listing_14
  @MM_Listing_14 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  MM_Listing_14 “Media Manager Listing” - View Media Manager Listing Detail
    Given Launch Media Manager front end application
    Then View Media Listing Details '<TestcaseID>'
    Examples:
      | TestcaseID    |
      | MM_Listing_14 |

  #   This scenario will cover MM_Listing_14
  @MM_Listing_18 @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  MM_Listing_18 Changes in the Backoffice configuration for a Category, Meta Info or Media Page should be reflected immediately
    Given Launch and login GovStack CMS Back Office
    When Navigate to Categories
    And Rename and unpublish a category '<TestcaseID>'
    Then Launch Media Manager front end application in new tab
    And Verify renamed and unpublished category in Front End
    Examples:
      | TestcaseID    |
      | MM_Listing_18 |

  #   This scenario will cover the clean up step for Media Manager Listing
  @MM_Listing_18cleanup @MediaManagerListing @MediaManager @Regression @CMS
  Scenario Outline:  Clean up - Delete Content, Publish and Rename Category
    Given Launch and login GovStack CMS Back Office
    When Navigate to Categories
    And Rename and publish a category '<TestcaseID>'
    When Select MM Test Page
    Then Remove Media Manager Content
    And Click Save and Publish
    Examples:
      | TestcaseID    |
      | MM_Listing_18 |