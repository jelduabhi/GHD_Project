Feature: Sitemap Robot and RSS Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office
    When Go to content home


  @RG_XR_1.1 @sitemap @Regression @CMS
  Scenario: RG_XR_1.1 Home Sitemap XML should appear when sitemap xml file is loaded
    When user navigate to sitemap xml menu
    And user click navigate to  info link and click sitemap xml link
    Then verify sitemap xml or robot file should be loaded

  @RG_XR_1.2 @sitemap @Regression @CMS
  Scenario: RG_XR_1.2 Home Robot txt should appear when robot txt file is loaded
    When user navigate to robot txt menu
    And user click navigate to  info link and click robot txt link
    Then verify sitemap xml or robot file should be loaded

  @RG_XR_1.3 @sitemap @Regression @CMS
  Scenario Outline: RG_XR_1.3 Site Map should be updated real time for pages created in Home Node
    When user click home and create a page "<Testcase ID>"
    And user navigate to sitemap xml menu
    And user click navigate to  info link and click sitemap xml link
    Then verify sitemap xml or robot file should be loaded
    Examples:
      | Testcase ID |
      | RG_XR_1.3   |

  @RG_XR_1.4 @sitemap @Regression @CMS
  Scenario Outline: RG_XR_1.4 Site Map should be updated real time for pages created in Micro sites Subsite Homepage
    When user click subsite and create a page "<Testcase ID>"
    And user navigate to sitemap xml menu
    And user click navigate to  info link and click sitemap xml link
    Then verify sitemap xml or robot file should be loaded
    Examples:
      | Testcase ID |
      | RG_XR_1.4   |

  @RG_XR_1.5 @sitemap @Regression @CMS
  Scenario: RG_XR_1.5 verify visit (site)/news/rss, the links inside the document must be accessible and should not result in page not found
    When user open news_rss in new tab
    Then verify sitemap xml or robot file should be loaded