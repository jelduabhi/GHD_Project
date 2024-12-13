Feature: Disable Links For Non Page Nodes Scenarios

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  @RG_DN_1.1 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.1_News Categories Non-page nodes must not have public facing links.
    When Go to News Categories '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.1  |

  @RG_DN_1.2 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.2_News Authors Non-page nodes must not have public facing links.
    When Go to News Authors '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.2  |

  @RG_DN_1.3 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.3_News Authors Items Non-page nodes must not have public facing links.
    When Go to News Authors Items '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.3  |

  @RG_DN_1.4 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.4_News Post Non-page nodes must not have public facing links.
    When Go to News Post '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.4  |

  @RG_DN_1.5 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.5_Alerts Non-page nodes must not have public facing links.
    When Go to Alerts '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.5  |

  @RG_DN_1.6 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.6_Alerts Items Non-page nodes must not have public facing links.
    When Go to Alerts Items '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.6  |

  @RG_DN_1.7 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.7_Parsers Non-page nodes must not have public facing links.
    When Go to Parsers Pages '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.7  |

  @RG_DN_1.8 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.8_Custom Integration Non-page nodes must not have public facing links.
    When Go to Custom Integration '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.8  |

  @RG_DN_1.9 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.9_Contact Categories Non-page nodes must not have public facing links.
    When Go to Contact  Directory Contacts '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.9  |

  @RG_DN_1.10 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.10_Contact Items Non-page nodes must not have public facing links.
    When Go to Contact  Directory  Contacts  Click any Contact items '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.10 |

  @RG_DN_1.11 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.11_Contact Phone Numbers Non-page nodes must not have public facing links.
    When Go to Contact  Directory  Contacts List '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.11 |

  @RG_DN_1.12 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.12_Search Engine Config Non-page nodes must not have public facing links.
    When Go to Search Engine Config '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.12 |

  @RG_DN_1.13 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.13_Search Engines Non-page nodes must not have public facing links.
    When Go to Search Engine Config Search Engines '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.13 |

  @RG_DN_1.14 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.14_Theme Configuration Non-page nodes must not have public facing links.
    When Go to Search Engine Config Theme Configuration '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.14 |

  @RG_DN_1.15 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.15_Main News Node Nodes that must have public facing links.
    When Go to News '<TestcaseID>'
    And Navigate to Info
    Then Check if there is a nodes link
    Examples:
      | TestcaseID |
      | RG_DN_1.15 |

  @RG_DN_1.16 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.16_News Posts Nodes that must have public facing links.
    When Go to News  Posts  News Posts '<TestcaseID>'
    And Navigate to Info
    Then Check if there is a nodes link
    Examples:
      | TestcaseID |
      | RG_DN_1.16 |

  @RG_DN_1.17 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.17_Parser Items Nodes that must have public facing links.
    When Go to  Parser Pages  Click any Parsers Items Calendar and Forms '<TestcaseID>'
    And Navigate to Info
    Then Check if there is a nodes link
    Examples:
      | TestcaseID |
      | RG_DN_1.17 |

  @RG_DN_1.18 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.18_Main Contacts node Nodes that must have public facing links.
    When Go to  Contact Directory '<TestcaseID>'
    And Navigate to Info
    Then Check if there is a nodes link
    Examples:
      | TestcaseID |
      | RG_DN_1.18 |

  @RG_DN_1.19 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.19_Contact list and Contacts List Redirected URL Management links should be hide for Contact list and Contacts List
    When Go to Contact Directory  Contact List and Contacts List '<TestcaseID>'
    And Navigate to Info
    Then Redirected URL Management links should not be displayed for Contact list and Contacts List
    Examples:
      | TestcaseID |
      | RG_DN_1.19 |

  @RG_DN_1.20 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.20_Design Non-page nodes must not have public facing links.
    When Go to Design '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.20 |

  @RG_DN_1.21 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.21_Design Item Non-page nodes must not have public facing links.
    When Go to Design Design Item '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.21 |

  @RG_DN_1.22 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.22_Global Non-page nodes must not have public facing links.
    When Go to Global '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.22 |

  @RG_DN_1.23 @DisableLinksForNonPageNodes @Regression @CMS
  Scenario Outline: RG_DN_1.23_Global Items Non-page nodes must not have public facing links.
    When Go to Global Global Items '<TestcaseID>'
    And Navigate to Info
    Then Check if disabled links for Non Page Nodes
    Examples:
      | TestcaseID |
      | RG_DN_1.23 |