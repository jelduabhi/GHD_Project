Feature: Sub Navigation Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  @RG_SN_1.1 @SubNav @Regression @CMS
  Scenario Outline: RG_SN_1.1_Main Page Back end Create Main Page for Sub Nav
    When Create Main Page, Navigate to Home or Main Site, click on the three dots and click Create, Select Page, choose a template '<TestcaseID>'
    And Add name and Page Title, Headings etc. '<TestcaseID>'
    And Choose a Layout Left or Right '<TestcaseID>'
    And Click Save and Publish
    Then Main Page created successfully under the Home or Main Site. '<TestcaseID>'
    Examples:
      | TestcaseID |
      | RG_SN_1.1  |

  @RG_SN_1.2 @SubNav @Regression @CMS
  Scenario Outline:  RG_SN_1.2_Sub Navigation Back End Create Secondary website navigation under subnav mainpage
    When Go to the created Test Page Main Page and Create a Sub Nav Page Click on the three dots and click Create, Select Page, choose a template '<TestcaseID>'
    And Add name and Page Title, Headings etc. '<TestcaseID>'
    And Choose a Layout Left or Right '<TestcaseID>'
    And Click Save and Publish
#    And Repeat steps 2-4 to create multiple Sub Nav '<TestcaseID>'
    Then Secondary website navigation sub nav created successfully under the Main Test Page. '<TestcaseID>'
    Examples:
      | TestcaseID |
      | RG_SN_1.2  |

  @RG_SN_1.3 @SubNav @Regression @CMS
  Scenario Outline: RG_SN_1.3_Secondary Sub Navigation Back End Create Custom secondary sub navigation under subnav subpage
    When Go to the Home  Content  Main Page  Sub Nav Page '<TestcaseID>'
    And Add name and Page Title, Headings etc. '<TestcaseID>'
    And Choose a Layout Left or Right '<TestcaseID>'
    And Click Save and Publish
#    And Repeat steps 2-4 to create multiple Secondary Sub Nav page under each Suba Nav Page, creating a Sub Nav Page structure
    Then Secondary sub navigation component is created successfully under the Sub Nav Page '<TestcaseID>'
    Examples:
      | TestcaseID |
      | RG_SN_1.3  |

  @RG_SN_1.4 @SubNav @Regression @CMS
  Scenario Outline: RG_SN_1.4_WebView Sub Navigation Front End Check the Custom secondary sub navigation component for website sidebars.
    When Go to the created Test Page Main Page and Navigate to the info '<TestcaseID>'
    And Click the link to view the front end page which includes the created sub navigation '<TestcaseID>'
    Then Verify Main Parent Page in bold format.'<TestcaseID>'
      #bold style not feasible instead verifying subnav mainpage presence
    Then Verify Custom secondary sub navigation component for website sidebar displaying following the selected lay out left or right and hierarchy structure. '<TestcaseID>'
    #Note: If Full lay out is selected on a page, sub nav won’t be visible.
    Then Verify Contextual sub navigation menu that shows only the navigation items specific to the subcategory of the page the user is on. '<TestcaseID>'
    Then Include links to all pages and child pages that are part of the parent vertical. '<TestcaseID>'
    Examples:
      | TestcaseID |
      | RG_SN_1.4  |

  @RG_SN_1.5 @SubNav @Regression @CMS
  Scenario Outline:   RG_SN_1.5_WebView Sub Nav front End Functionality
    When Navigate to the Front End page '<TestcaseID>'
    Then Scroll thru the Sub Nave structure, try to expand and collapse.
    #Verify Sub Nav Functionalities:
    #Structure the sub nav as accessible accordion/toggle menus
    #Support top and bottom sub navigation so that the bottom can be styled/controlled(expanded/collapsed) independent of the top
    #The subnav adjusts properly when expanded/contracted vertically.
    Examples:
      | TestcaseID |
      | RG_SN_1.5  |

  @RG_SN_1.6 @SubNav @Regression @CMS
  Scenario Outline:   RG_SN_1.6_WebView Sub Navigation Front End Functionality Select Page
    When Navigate to the Front End page '<TestcaseID>'
    And On the Sub Nav Structure select a page
    #Verify Sub Nav Functionalities when selecting page
    Then Support advanced sub navigation where the selected page or section automatically appears at the top of the sub navigation. below the Main Parent Page
    Then Navigation breadcrumbs should be included on lower left
    Examples:
      | TestcaseID |
      | RG_SN_1.6  |

  @RG_SN_1.8 @SubNav @Regression @CMS
  Scenario Outline:   RG_SN_1.8_WebView Sub Nav front End Functionality View Full Menu
    When Navigate to the Front End page '<TestcaseID>'
    And On the Sub Nav Structure, Click View Full Menu bullets button
    #Verify Sub Nav –  View Full Menu
    Then opening the view full menu list, the full sitemap should be displayed. we should see + toggles where pages have children.
    And On the Sub Nav Structure, Click Close Full Menu x close button
    Then View Full menu should remain open when selected unless Close Full Menu is clicked or if user select a specific page.
    Examples:
      | TestcaseID |
      | RG_SN_1.8  |

  @RG_SN_1.10 @SubNav @Regression @CMS
  Scenario Outline:   RG_SN_1.10_WebView  Sub Navigation Hide from all navigation
    When Go to the Home Content Main Page Sub Nav Page Secondary Sub Nav Page '<TestcaseID>'
    And Go to Navigation tab
    When On Hide from all navigation select Yes
    #And Do Step 2&3 for all Secondary Sub Nav Page under the selected ub Nav Page
    And Click Save and Publish
    When Navigate to the Front End page '<TestcaseID>'
    Then Parent page with only non visible child pages does not display a + symbol in the sub nav.
    Examples:
      | TestcaseID |
      | RG_SN_1.10 |