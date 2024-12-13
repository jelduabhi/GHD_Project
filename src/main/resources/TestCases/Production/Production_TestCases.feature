Feature: Production Scenarios


  @Prod
  Scenario Outline: CMS_PRD_1 to CMS_PRD_5 prod checklist
    Given User launch the production url "<ProdURL>" "<ClientName>"
    Then Validate the homepage content, navigation and CSS layout are loaded properly
    And Validate any js or CSS 500 Errors related to site builder bundle
    And user launch and login prod GovStack Back Office "<ProdURL>"
    Then Validate Logs for errors
    And Validate Examine Management
    Then Mode should be set to Nothing
    Examples:
      | ProdURL | ClientName |
      | https://brantfordpolice-002-ca.govstack.com | Brantford Police Service |
      | https://orilliarecreation-004-ca.govstack.com | City of Orillia Recreation |
#      | https://strathroy-caradoc-005-ca.govstack.com | Municipality of Strathroy-Caradocn |
#      | https://southhuron-005-ca.govstack.com | Municipality of South Huron |
#      | https://severn-005-ca.govstack.com | Township Of Severn |
#      | Prod_TC006 |
#      | Prod_TC007 |
#      | Prod_TC008 |
#      | Prod_TC009 |
#      | Prod_TC010 |
#      | Prod_TC011 |
#      | Prod_TC012 |
#      | Prod_TC013 |
#      | Prod_TC014 |
#      | Prod_TC015 |
#      | Prod_TC016 |
#      | Prod_TC017 |
#      | Prod_TC018 |
#      | Prod_TC019 |
#      | Prod_TC020 |
#      | Prod_TC021 |
#      | Prod_TC022 |
#      | Prod_TC023 |
#      | Prod_TC024 |
#      | Prod_TC025 |
#      | Prod_TC026 |
#      | Prod_TC027 |
#      | Prod_TC028 |
#      | Prod_TC029 |
#      | Prod_TC030 |
#      | Prod_TC031 |
#      | Prod_TC032 |
#      | Prod_TC033 |
#      | Prod_TC034 |
#      | Prod_TC035 |
#      | Prod_TC036 |
#      | Prod_TC037 |
#      | Prod_TC038 |
#      | Prod_TC039 |
#      | Prod_TC040 |
#      | Prod_TC041 |
#      | Prod_TC042 |
#      | Prod_TC043 |
#      | Prod_TC044 |
#      | Prod_TC045 |
#      | Prod_TC046 |
#      | Prod_TC047 |
#      | Prod_TC048 |
#      | Prod_TC049 |
#      | Prod_TC050 |
#      | Prod_TC051 |
#      | Prod_TC052 |
#      | Prod_TC053 |
#      | Prod_TC054 |
#      | Prod_TC055 |
#      | Prod_TC056 |
#      | Prod_TC057 |
#      | Prod_TC058 |
#      | Prod_TC059 |
#      | Prod_TC060 |
#      | Prod_TC061 |
#      | Prod_TC062 |
#      | Prod_TC063 |
#      | Prod_TC064 |
#      | Prod_TC065 |
#      | Prod_TC066 |
#      | Prod_TC067 |
#      | Prod_TC068 |
