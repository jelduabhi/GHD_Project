Feature: Page Layout Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office


  @RG_PG_1.1 @pageLayout @Regression @CMS
  Scenario: RG_PG_1.1 Remove CENTER (NAV LEFT) and CENTER (NAV RIGHT) lay out options on the Blog Post Page
    When Go to Content Home and Navigate to Blog page
    Then Verify CENTER (NAV LEFT) and CENTER (NAV RIGHT) option not visible

  @RG_PG_1.2 @pageLayout @Regression @CMS
  Scenario: RG_PG_1.2 Remove CENTER (NAV LEFT) and CENTER (NAV RIGHT) lay out options on the News Page
    When Go to Content Home and Navigate to News Main page
    Then Verify CENTER (NAV LEFT) and CENTER (NAV RIGHT) option not visible

  @RG_PG_1.3 @pageLayout @Regression @CMS
  Scenario: RG_PG_1.3 Remove CENTER (NAV LEFT) and CENTER (NAV RIGHT) lay out options on the Parsers Page
    When Go to Content Home and Navigate to Parsers Main page
    Then Verify CENTER (NAV LEFT) and CENTER (NAV RIGHT) option not visible

  @RG_PG_1.4 @pageLayout @Regression @CMS
  Scenario: RG_PG_1.4 Remove CENTER (NAV LEFT) and CENTER (NAV RIGHT) lay out options on the Subscribe Page
    When Go to Content Home and Navigate to subscribe Main page
    Then Verify CENTER (NAV LEFT) and CENTER (NAV RIGHT) option not visible

  @RG_PG_1.5 @pageLayout @Regression @CMS
  Scenario: RG_PG_1.5 Remove CENTER (NAV LEFT) and CENTER (NAV RIGHT) lay out options on the Subscribe Confirm Page
    When Go to Content Home and Navigate to subscribe and click confirm page
    Then Verify CENTER (NAV LEFT) and CENTER (NAV RIGHT) option not visible

  @RG_PG_1.6 @pageLayout @Regression @CMS
  Scenario: RG_PG_1.5 Remove CENTER (NAV LEFT) and CENTER (NAV RIGHT) lay out options on the Subscribe Unsubscribe Page
    When Go to Content Home and Navigate to subscribe and click unsubscribe page
    Then Verify CENTER (NAV LEFT) and CENTER (NAV RIGHT) option not visible

  @RG_PG_1.7 @pageLayout @Regression @CMS
  Scenario: RG_PG_1.2 Remove CENTER (NAV LEFT) and CENTER (NAV RIGHT) lay out options on the Home Page
    When Go to main home page
    Then Verify CENTER (NAV LEFT) and CENTER (NAV RIGHT) option not visible

  @RG_PG_1.8 @pageLayout @Regression @CMS
  Scenario: RG_PG_1.2 Remove CENTER (NAV LEFT) and CENTER (NAV RIGHT) lay out options on the Page Layout Automation Page
    When Go to Content Home and Navigate to page layout automation page
    Then Verify CENTER (NAV LEFT) and CENTER (NAV RIGHT) option not visible
