Feature: News Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office


  # ####################################################################################################
  #   Author :-  Sai Kumar Jeldu
  #   This scenario will cover RG_NW_2.1,RG_NW_2.2,RG_NW_3.2.1 and RG_NW_3.2.2,RG_NW_3.2.3
  # ####################################################################################################
  @createAndPublishNews @News @Regression @CMS
  Scenario Outline: RG_NW_2.1_RG_NW_2.2_RG_NW_3.2.1_RG_NW_3.2.2_RG_NW_3.2.3 Create a news and publish
    When User selects the news
    And User enter all the details "<TestcaseID>"
    And User should be able to publish the news
    When User launch the News frond end application in new tab
    Then News should be posted to front end application
    Examples:
      | TestcaseID  |
      | RG_NW_2.1   |
      | RG_NW_3.2.1 |
      | RG_NW_3.2.3 |

  # ####################################################################################################
  #   Author :-  Sai Kumar Jeldu
  #   This scenario will cover RG_NW_2.8 and RG_NW_2.9
  # ####################################################################################################
  @Unpublish_News @News @Regression @CMS
  Scenario: RG_NW_2.8_RG_NW_2.9_User is able to un publish the published News
    When User selects the news
    And user unPublish the published news
    And User launch the News frond end application in new tab
    Then News should not be posted to front end application

  # ####################################################################################################
  #   Author :-  Sai Kumar Jeldu
  #   This scenario will cover RG_NW_2.10 and RG_NW_2.11
  # ####################################################################################################
  @publish_UnPublished_News @News @Regression @CMS
  Scenario: RG_NW_2.10_RG_NW_2.11_User is able to publish the un published News
    When User selects the news
    And user publish the un published news
    And User launch the News frond end application in new tab
    Then News should be posted to front end application

  # ####################################################################################################
  #   Author :-  Sai Kumar Jeldu
  #   This scenario will cover RG_NW_1,RG_NW_4.1 and RG_NW_4.2
  # Intentionally removed Regression tag from this test cases as it impacts all test cases
  # Do not add regression tag
  # ####################################################################################################
  @RG_NW_1
  Scenario: RG_NW_1_RG_NW_4.1_RG_NW_4.2 Verify News Widget is available and the following options are available and editable on the News Widget Setting
    When Go to Content Home and Navigate to News Posts
    And update News Widgets in Setting
    When User launch the News frond end application in new tab
    Then verify Widgets updated in front End

  @RG_NW_2.24 @News @Regression @CMS
  Scenario: RG_NW_2.24_Verify clicking Save and preview link will save the changes and direct the user to the front end news listing preview
    When Go to Content Home and Navigate to News Posts
    And user preview the news
    Then Preview page should be displayed

  # ####################################################################################################
  #   Author :-  Sai Kumar Jeldu
  #   This scenario will cover RG_NW_3.2.5 and RG_NW_3.2.6
  # ####################################################################################################
  @RG_NW_3.2.5_RG_NW_3.2.6 @News @Regression @CMS
  Scenario: RG_NW_3.2.5_RG_NW_3.2.6_Content: Update News Details - Hide Page Title
    When User selects the news
    And User selects existing news
    And User update the content hide page title
    And User should be able to publish the news
    And User launch the News frond end application in new tab
    Then News should be posted to front end application

  # ####################################################################################################
  #   Author :-  Kavya/Sai
  # ####################################################################################################

  @RG_NW_2.3_RG_NW_2.4 @UpdatePost @News @Regression @CMS
  Scenario Outline: RG_NW_2.3_RG_NW_2.4 Update News Post with Summary
    When User selects the news
    And User selects existing news
    And User update the Settings and Summary details "<TestcaseID>"
    And User should be able to publish the news
    And User launch the News frond end application in new tab
    Then News should be posted to front end application
    Examples:
      | TestcaseID |
      | RG_NW_2.3  |

  @RG_NW_2.5_RG_NW_2.6 @UpdatePost @News @Regression @CMS
  Scenario Outline: RG_NW_2.5_RG_NW_2.6Update Posting Date as Future Date
    When User selects the news
    And User selects existing news
      #(Sample: Create New Post Regression)
    And Navigate to Settings, update the following Post date Update to Future Date "<TestcaseID>"
    And Click Save and Publish
    And User launch the News frond end application in new tab
    Then News should not be posted to front end application
    Examples:
      | TestcaseID |  |
      | RG_NW_2.5  |  |

  @RG_NW_2.7 @UpdatePost @News @Regression @CMS
  Scenario Outline: RG_NW_2.7_Update Posting Date is Blank
    When User selects the news
    And User selects existing news
      #(Sample: Create New Post Regression)
    And Navigate to Settings, update the following Post date leave as blank "<TestcaseID>"
    And Click Save and Publish
    Then Verify Validation errors must be fixed before the item can be saved” is returned
    Then Verify Post date is a required field. Leaving is blank marked the field as “This property is invalid”
    Then Verify Validation Errors
    Examples:
      | TestcaseID |  |
      | RG_NW_2.7  |  |

  @RG_NW_3.2.7 @RG_NW_3.2.8 @UpdatePost @News @Regression @CMS
#  RG_NW_3.2.7
  Scenario Outline: Content Delete News Details
    When Go to Content Home and Navigate to News Posts
    And User selects existing news
    And On Posts, open the created post "<TestcaseID>"
    And Navigate to Content and Delete or Remove the values for  the following fields
      #Page Title
      #Secondary Heading (select font size)
      #Main Content - Add Content (Sample: Gallery Image)
    And Click Save and Publish
    #Then Verify “Content published: English (United States) published and visible on the website” message is returned "<TestcaseID>"
    Then Verify the following content fields are now empty
      #Page Title
      #Secondary Heading (select font size)
      #Main Content

#  RG_NW_3.2.8
    When Navigate to News Listings Page
    And Navigate to All Post, select and open a News Post.
    Then Verify the following fields fields are  no longer available
      #Page Title
      #Secondary Heading
      #Main Content (Sample: Gallery Image)
   # Then Verify available links should direct user to the corresponding links/URL "<TestcaseID>" - irrelevant step, tc need to be updated
      #  Links (All Posts, Categories)
      #  Subscribe button
      #  Breadcrumbs navigation at the right bottom part
    Examples:
      | TestcaseID  |  |
      | RG_NW_3.2.7 |  |


# ####################################################################################################
  #   Author :-  Nitin
  # ####################################################################################################


  @deleteNews @News @Regression @CMS
  Scenario: PASSRG_NW_2.12 Delete news scenario
    When User selects the news
    And User delete the news
    Then News should be deleted


  @deleteNews @RG_NW_2.23 @News @Regression @CMS
  Scenario: RG_NW_2.23 News Listing Page - Backend
    When Go to Content Home and Navigate to News Posts
    And User delete the news
    Then Verify all created Posts are listed.
    And Verify Create News Post button is available
    And Verify View Option button is available ( Grid and List)
    And Verify Search button is available.
    And Verify searching a keyword would return valid values.

    # This Test case is not required for the automation as it is covered in create news cases
  @RG_NW_3.1
  Scenario: RG_NW_3.1 Verify setting page of news default field are available
    When User selects the news
    And I click on create post button
    Then Verify following fields available on Setting Page ie Post Title, Post Date, Categories,Author,Disable Comments,Send Subscriber Notification,Custom Message


  @deleteNews @News @Regression @CMS
  Scenario: RG_NW_3.4 Verify summary page of news default fields are available
    When User selects the news
    And I click on create post button
    And click on summary tab
    Then verify following fields available on summary page ie Heading,Secondary Heading,Text,Image

  @deleteNews @News @Regression @CMS
  Scenario: RG_NW_3.5 Verify navigation page of post default fields are available
    When User selects the news
    And I click on create post button
    And click on navigation tab
    Then verify following fields available on navigation page ie Hide from all navigation, Hide from internal search, Hide breadcrumb, Breadcrumb link text

  @RG_NW_3.8 @News @Regression @CMS
  Scenario: RG_NW_3.8 Verify advance page of post default field are available
    When User selects the news
    And I click on create post button
    And I click on advanced tab
    Then Verify following fields available on advanced page ie Hide website header,Hide website footer,Override design style,Override website logo,Override content,Custom page classes,Disable delete

  @test @News @Regression @CMS
  Scenario: RG_NW_3.6 Verify SEO and share page of post default field are available
    When User selects the news
    And I click on create post button
    And I click on seo and share tab
    Then verify default field available in seo and share page.

  @RG_NW_3.7 @News @Regression @CMS
  Scenario: RG_NW_3.7 Verify on script page default field are available
    When User selects the news
    And I click on create post button
    And I click on scripts tab
    Then verify default field are available

  @RG_NW_4.3 @News @Regression @CMS
  Scenario: RG_NW_4.3 Verify Items per page field is editable in news screen
    When I selects the custom new button
    And Update the following: Items per page
    And Click Save and Publish
    Then Verify Content published message will be returned after Save and Publish.

  @RG_NW_3.3 @News @Regression @CMS
  Scenario: RG_NW_3.3 Verify on extra content page default field are available
    When User selects the news
    And I click on create post button
    And I click on extra content tab
    Then verify default field are available in extra content page

  @RG_NW_5.1 @News @Regression @CMS
  Scenario: RG_NW_5.1 News Search - search panel is located below all articles on mobile
    When I Go to Govstack QA Frontend News | Prestige
    And Try to Search and Filter News
    When Select Article date within the selected date
    Then Check if displaying the article

  # ####################################################################################################
  #   This is covered in End to End cases. So do not add any tags to execute
  # ####################################################################################################
  Scenario: RG_NW_5.2 News Search - no news within the selected date range on mobile
    When I Go to Govstack QA Frontend News | Prestige
    And  Try to Search and Filter News with no news within the selected date range, then it should display “No Articles were found”
    Then Check if not displaying the article


  @frontend @RG_NW_5.3 @News @Regression @CMS
  Scenario: RG_NW_5.3 Search and filtering criteria with  selected date range is greater than the todays date
    When I Go to Govstack QA Frontend News | Prestige
    And Try to Search and Filter News with the selected date range is greater than the todays date, then then it should display “No Articles were found”
    Then Check if not displaying the article

  @RG_NW_2.14 @News @Regression @CMS
  Scenario: RG_NW_2.14 verify default field available in news form in frontend
    When I Go to Govstack QA Frontend News | Prestige
    Then Verify following field available in news form ie Search field,Filter by news categories,start date, end date, search and clear button

  @RG_NW_2.19 @News @Regression @CMS
  Scenario: RG_NW_2.19 verify on click clear button search criteria will be deleted
    When I Go to Govstack QA Frontend News | Prestige
    And Try to Search and Filter News
    When Select Article date within the selected date
    Then Check if displaying the article
    And Click clear button
    Then Verify search criteria will be deleted and date field is in default current date

  @RG_NW_2.22 @News @Regression @CMS
  Scenario: RG_NW_2.22 verify subscribe button is visible on news section in frontend page
    When I Go to Govstack QA Frontend News | Prestige
    And click on subscribe news button
    Then verify user will be navigate to subscribe news page

  @RG_NW_2.20 @News @Regression @CMS
  Scenario: RG_NW_2.20 Verify selected category list should be displayed in news
    When I Go to Govstack QA Frontend News | Prestige
    And Select the news category
    When Select Article date within the selected date
    Then Check if displaying the article