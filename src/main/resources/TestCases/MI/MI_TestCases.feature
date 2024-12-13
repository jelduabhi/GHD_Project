Feature: Meta Information Sample Templates AT

  Background: Login the page
    Given Launch and login GovStack CMS Back Office

  @TC_MI_01 @Meta_Information_Sample_Templates_AT @MI
  Scenario Outline: To be able to create media page for General Document Meta Information
    When On Media Pages > Subfolder Media Pages > Select Document Template "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Document Version > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select DepartmentDivision > Add Value
    And Settings > Under Meta Information > Add content > Text Area Fields > Select Description > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select AuthorIssuer > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit
    And Save and Publish
    And Go to Info > Links > Select URL link
    Then Verify meta information is on the front end url link and has its values: Document Version, DepartmentDivision, Description, AuthorIssuer, Status, Alternative Text, Related Document
    Examples:
      | Testcase ID    |
      | TC_MI_01       |

  @TC_MI_02 @Meta_Information_Sample_Templates_AT @MI
  Scenario Outline: To be able to create media page for By-Law Document Meta Information
    When On Media Pages > Subfolder Media Pages > Select Document Template "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Bylaw Number > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Document Version > Add Value
    And Settings > Under Meta Information > Add content > Text Area Fields > Select Description > Add Value
    And Settings > Under Meta Information > Add content > Date Fields > Select Date of Enactment > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Effective Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Link Fields > Select Amended By > Add > Insert Link > Insert Link Title > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Link Fields > Select Repealed By > > Add > Insert Link > Insert Link Title > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select AuthorIssuer > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit
    And Save and Publish
    And Go to Info > Links > Select URL link
    Then Verify meta information is on the front end url link and has its values: Bylaw Number, Document Version, DepartmentDivision, Description, Date of Enactment, Effective Date, Amended By, Repealed By, AuthorIssuer, Status, Alternative Text, Related Document "<Testcase ID>"

    Examples:
      | Testcase ID    |
      | TC_MI_02       |

  @TC_MI_03 @Meta_Information_Sample_Templates_AT @MI
  Scenario Outline: To be able to create media page for Permit and Licensing Meta Information
    When On Media Pages > Subfolder Media Pages > Select Document Template "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select DepartmentDivision > Add Value
    And Settings > Under Meta Information > Add content > Text Area Fields > Select Description > Add Value
    And Settings > Under Meta Information > Add content > Date Fields > Select Issue Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Effective Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Expiration Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Link Fields > Select Amended By > Add > Insert Link > Insert Link Title > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Link Fields > Select Repealed By > > Add > Insert Link > Insert Link Title > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select AuthorIssuer > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Contact Information > Link to Page > Search: Contact > Select any Contact Information > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit
    And Save and Publish
    And Go to Info > Links > Select URL link
    Then Verify meta information is on the front end url link and has its values: DepartmentDivision, Description, Issue Date, Effective Date, Expiration Date, Amended By, Repealed By, AuthorIssuer, Contact Information, Status, Alternative Text, Related Document "<Testcase ID>"

    Examples:
      | Testcase ID    |
      | TC_MI_03       |

  @TC_MI_04 @Meta_Information_Sample_Templates_AT @MI
  Scenario Outline: To be able to create media page for Meeting Agendas and Minutes Meta Information
    When On Media Pages > Subfolder Media Pages > Select Document Template "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Meeting Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Meeting Type > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Meeting Location > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select DepartmentDivision > Add Value
    And Settings > Under Meta Information > Add content > Text Area Fields > Select Description > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select AuthorIssuer > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit
    And Save and Publish
    And Go to Info > Links > Select URL link
    Then Verify meta information is on the front end url link and has its values: Meeting Date, Meeting Type, Meeting Location, DepartmentDivision, Description, AuthorIssuer, Status, Alternative Text, Related Document "<Testcase ID>"

    Examples:
      | Testcase ID    |
      | TC_MI_04       |

  @TC_MI_05 @Meta_Information_Sample_Templates_AT @MI
  Scenario Outline: To be able to create media page for Planning Application and Report Meta Information
    When On Media Pages > Subfolder Media Pages > Select Document Template "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select ApplicationReport Number > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Submission Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Review Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Approval Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Expiration Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Applicant Name > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Contact Information > Link to Page > Search: Contact > Select any Contact Information > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select DepartmentDivision > Add Value
    And Settings > Under Meta Information > Add content > Text Area Fields > Select Description > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Amended By > Add > Insert Link > Insert Link Title > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Link Fields > Select Repealed By > > Add > Insert Link > Insert Link Title > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit
    And Save and Publish
    And Go to Info > Links > Select URL link
    Then Verify meta information is on the front end url link and has its values: ApplicationReport Number, Submission Date, Review Date, Approval Date, Expiration Date, Applicant Name, Contact Information, DepartmentDivision, Description, Amended By, Repealed By, Status, Alternative Text, Related Document "<Testcase ID>"

    Examples:
      | Testcase ID    |
      | TC_MI_05       |


  @TC_MI_06 @Meta_Information_Sample_Templates_AT @MI
  Scenario Outline: To be able to create media page for Public Policy and Regulation Meta Information
    When On Media Pages > Subfolder Media Pages > Select Document Template "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select PolicyRegulation Number > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Adoption Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Effective Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select DepartmentDivision > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Amended By > Add > Insert Link > Insert Link Title > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Link Fields > Select Repealed By > > Add > Insert Link > Insert Link Title > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select AuthorIssuer > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit
    And Save and Publish
    And Go to Info > Links > Select URL link
    Then Verify meta information is on the front end url link and has its values: PolicyRegulation Number, Adoption Date, Effective Date, DepartmentDivision, Description, Amended By, Repealed By, AuthorIssuer, Status, Alternative Text, Related Document "<Testcase ID>"

    Examples:
      | Testcase ID    |
      | TC_MI_06       |

  @TC_MI_07 @Meta_Information_Sample_Templates_AT @MI
  Scenario Outline: To be able to create media page for Public Health and Safety Notice Meta Information
    When On Media Pages > Subfolder Media Pages > Select Document Template "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Notice Number > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Issue Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Effective Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Expiration Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select DepartmentDivision > Add Value
    And Settings > Under Meta Information > Add content > Text Area Fields > Select Description > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select AuthorIssuer > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Contact Information > Link to Page > Search: Contact > Select any Contact Information > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit
    And Save and Publish
    And Go to Info > Links > Select URL link
    Then Verify meta information is on the front end url link and has its values: Notice Number, Issue Date, Effective Date, Expiration Date, DepartmentDivision, Description, AuthorIssuer, Contact Information, Status, Alternative Text, Related Document "<Testcase ID>"

    Examples:
      | Testcase ID    |
      | TC_MI_07       |

  @TC_MI_11 @Meta_Information_Sample_Templates_AT @MI
  Scenario Outline: To be able to create media page for Legal and Compliance Document Meta Information
    When On Media Pages > Subfolder Media Pages > Select Document Template "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Document Number > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Issue Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Effective Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Date Fields > Select Expiration Date > Add Value "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Document Version > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select DepartmentDivision > Add Value
    And Settings > Under Meta Information > Add content > Text Area Fields > Select Description > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select AuthorIssuer > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Contact Information > Link to Page > Search: Contact > Select any Contact Information > Submit "<Testcase ID>"
    And Settings > Under Meta Information > Add content > Text Fields > Select Status > Add Value
    And Settings > Under Meta Information > Add content > Text Fields > Select Alternative Text > Add Value
    And Settings > Under Meta Information > Add content > Link Fields > Select Related Document > Link to Media > Select Media > Select any file > Submit
    And Save and Publish
    And Go to Info > Links > Select URL link
    Then Verify meta information is on the front end url link and has its values: Document Number, Issue Date, Effective Date, Expiration Date, Document Version, DepartmentDivision, Description, AuthorIssuer, Contact Information, Status, Alternative Text, Related Document "<Testcase ID>"

    Examples:
      | Testcase ID    |
      | TC_MI_11       |