@BGX4_regression_mandatory @L1
Feature: BGX4 high level functionalities

#  @NonPersonalCustomerCreation
#    @English @SmallBusiness
#    @BusinessAccountWithoutCreditBureauAccount @L1
#  Scenario Outline: create non-personal customer and link business account
#    Given officer login into intralink "<ScenarioId>" "NonPersonal"
#    And accessed "Customer Sales & Service (New)" application
#    And located non-personal customer with legal name
#    And created new non-personal customer
#    And created bussiness account without credit bureau for non-personal customer
#    Then captured created non-personal customer CID
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                                                         |
#      | Small Business with business account without credit bureau account |

#  @PersonalCustomerCreation
#    @English @SingleId
#    @AgeGreaterThan16 @SavingsAccount @L1
#  Scenario Outline: create personal customer age greater than 16 and link savings account
#    Given officer login into intralink "<ScenarioId>" "Personal"
#    And accessed "Customer Sales & Service (New)" application
#    And located personal customer with his/her details
#    And created new personal customer
#    And created savings account for personal customer
#    Then captured created personal customer CID
#    Then verified personal customer information
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                                         |
#      | Single-ID Age greater than 16 with savings account |


#  @PersonalCustomerCreation
#    @English @DualId
#    @AgeBetween12-15 @ScotiaAccount @L1
#  Scenario Outline: create personal customer age between 12-15 and link scotia account
#    Given officer login into intralink "<ScenarioId>" "Personal"
#    And accessed "Customer Sales & Service (New)" application
#    And located personal customer with his/her details
#    And created new personal customer
##    And verifed customer
#    And created savings account for personal customer
#    And created scotia card for personal customer
#    Then captured created personal customer CID
#    Then verified personal customer information
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                                    |
#      | Dual-ID Age between 12-15 with scotia account |

#  @PersonalCustomerCreation
#    @French @DualId
#    @AgeLessThan12 @SavingsAccount @L1
#  Scenario Outline: create personal customer age less than 12 and link savings account
#    Given officer login into intralink "<ScenarioId>" "Personal"
#    And accessed "Customer Sales & Service (New)" application
#    And located personal customer with his/her details
#    And created new personal customer
#    And created savings account for personal customer
#    Then captured created personal customer CID
#    Then verified personal customer information
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId               |
#      | Dual-ID Age less than 12 |


#  @PersonalCustomerCreation
#    @French @ABBSID
#    @AgeGreaterThan16 @scotiacard @L1
#  Scenario Outline: create personal customer age greater than 16 (ABBS) and link scotia card
#    Given officer login into intralink "<ScenarioId>" "Personal"
#    And accessed "Customer Sales & Service (New)" application
#    And located personal customer with his/her details
#    And created new personal customer
#    And created savings account for personal customer
#    And created scotia card for personal customer
#    Then captured created personal customer CID
#    Then verified personal customer information
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                  |
#      | ABBS ID Age greater than 16 |

#  @PersonalCustomerUpdate
#    @English @French @L1
#  Scenario Outline: update personal customer details
#    Given officer login into intralink "<ScenarioId>" "Personal"
#    And accessed "Customer Sales & Service (New)" application
#    And get "Personal" "CIDPersonal" to "Personal"
#    And located "Personal" customer with cid
#    And updated personal customer details
#    And created savings account for personal customer
#    Then verified personal customer information
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                          |
#      | Update Personal customer details-EN |
#      | Update Personal customer details-FR |

#  @NonPersonalCustomerUpdate
#    @English @L1
#  Scenario Outline: update non-personal customer details
#    Given officer login into intralink "<ScenarioId>" "NonPersonal"
#    And accessed "Customer Sales & Service (New)" application
#    And get a non-personal cid
#    And located non-personal customer with cid
#    And updated non-personal customer details
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                              |
##      English
#      | Update Non-Personal customer details-EN |


#  @locatecustomerwithaccountnumber
#    @launchmarketingpreferences
#    @English @L1
#  Scenario Outline: locate personal customer with account number and launch customer preferences page
#    Given officer login into intralink "<ScenarioId>" "Personal"
#    And accessed "Customer Sales & Service (New)" application
#    And located customer with account number in customer locate/setup
#    Then officer verified personal customer located successfully
#    And launched marketing preferences page
#    Then verified customer preferences page launched
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                                               |
#      | Locate personal customer with day-to-day banking account |

#  @fatca
#    @changedocumentstatuspendingtocomplete
#    @English @L1
#  Scenario Outline: changing document status from pending to complete in FATCA for manually identified indicia
#    Given officer login into intralink "<ScenarioId>" "FATCA"
#    And accessed "Customer Sales & Service (New)" application
#    And get "FATCA" "CIDPersonal" to "Personal"
#    And located "Personal" customer with cid
#    And launched "FATCA" from tax information
#    Then verified documentation status changed complete
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                                                                   |
#      | Documentation status changed to complete while US Indicator checked manually |

#  @RKO
#    @accountstatementrko
#    @preferences
#    @English @L1
#  Scenario Outline: updating RKO preference options in preferences tab
#    Given officer login into intralink "<ScenarioId>" "Personal"
#    And accessed "Customer Sales & Service (New)" application
#    And located "Personal" customer with cid
#    And launched preferences page
#    And updated account statement rko preference from 'Yes-No' or 'No-Yes'
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                               |
#      | Update account statement RKO Preferences |

#
#  @cuac @personal
#    @addcuacrelationship
#    @English @L1
#  Scenario Outline: add cuac relationships for personal customer
#    Given officer login into intralink "<ScenarioId>" "Personal"
#    And accessed "Customer Sales & Service (New)" application
#    And get "Personal" "CIDPersonal" to "Personal"
#    And located "Personal" customer with cid
#    And get referenceId from "Personal" and retrieve "DAYTODAYBANKING" "AccountNumber" to "CustomerToAccountRelationship"
#    And get referenceId from "Personal" and retrieve "DAYTODAYBANKING" "AccountNumber" to "AccountLocate"
#    And maintained "Customer To Account Relationship"
#    And deleted and added relationship
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                              |
#      | Add CUAC relation for personal customer |
#
#
#  @cuac @nonpersonal
#    @updatecuacrelationship
#    @English @L1
#  Scenario Outline: update cuac relationships for non-personal customer
#    Given officer login into intralink "<ScenarioId>" "NonPersonal"
#    And accessed "Customer Sales & Service (New)" application
#    And get "NonPersonal" "CIDNonPersonal" to "NonPersonal"
#    And located "NonPersonal" customer with cid
#    And get referenceId from "NonPersonal" and retrieve "BusinessAccountWithoutCreditBureau" "AccountNumber" to "CustomerToAccountRelationship"
#    And maintained "Customer To Account Relationship"
#    And changed relationship
#    Then signed-off from intralink
#    Examples:
#      | ScenarioId                                     |
#      | Update CUAC relation for non-personal customer |


  @productsandservices @personal
    @English @L1
  Scenario Outline: verify all products displays in legacy a6 are present in BGX4
    Given officer login into intralink "<ScenarioId>" "Personal"
    And accessed "Customer Sales & Service" application
    And located customer with cid in A6
    And get products and services information from A6
    And navigated back to intralink home
    And accessed Customer Sales and Services (New) application
    And located "Personal" customer with cid
    And get products and services information
    Then validate BGX4 products and services information with A6
    Then signed-off from intralink
    Examples:
      | ScenarioId                                             |
      | Compare BGX4 Products and Services information with A6 |