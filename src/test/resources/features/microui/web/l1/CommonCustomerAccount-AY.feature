@AY_regression_mandatory @L1
Feature: AY high level functionalities


  @nonpersonal
    @english @onlineloanaccount
    @L1
  Scenario Outline: setup online loan account for non-personal customer
    Given officer login into intralink "<ScenarioId>" "NonPersonal"
    And accessed "Customer Sales & Service (New)" application
    And get "NonPersonal" "CIDNonPersonal" to "NonPersonal"
    And get "NonPersonal" "Name" to "NonPersonal"
    And located "NonPersonal" customer with cid
    And created online loan account to customer
    Then verified non-personal account created successfully
    Then signed-off from intralink
    Examples:
      | ScenarioId                                          |
      | Setup online loan account for Non-Personal customer |


  @personal
    @english @accessbyaccount
    @L1
  Scenario Outline: verify the access by account screen is functioning correctly with account linked to personal customer
    Given officer login into intralink "<ScenarioId>" "AccessByAccountNumber"
    And accessed "Access by Account" application
    And located with customer account number in access by account
    Then verified account profile page opened with account linked to personal customer
    Then signed-off from intralink
    Examples:
      | ScenarioId                                                            |
      | Account Profile displayed with an account linked to personal customer |


  @non-personal
    @english @accessbyaccount
    @L1
  Scenario Outline: verify the access by account screen is functioning correctly with account linked to non-personal customer
    Given officer login into intralink "<ScenarioId>" "AccessByAccountNumber"
    And accessed "Access by Account" application
    And located with customer account number in access by account
    Then verified account profile page opened with account linked to non-personal customer
    Then signed-off from intralink
    Examples:
      | ScenarioId                                                                |
      | Account Profile displayed with an account linked to non-personal customer |

        # Functionality is not working - Need to work on this scenario
  @personal
    @english @scotiacard
    @L1 @accounttitlechange
  Scenario Outline: verify account title can be updated via EJ for customer having scotia card
    Given officer login into intralink "<ScenarioId>" "Personal"
    And accessed "Customer Sales & Service (New)" application
    And get "Personal" "CIDPersonal" to "Personal"
    And located "Personal" customer with cid
    And get "Scotiacard" "ScotiaCardNumber" to "Scotiacard"
    And update account title for scotia card
    Then verified account profile page opened with account linked to non-personal customer
    Then signed-off from intralink
    Examples:
      | ScenarioId                                                  |
      | Update Account title via EJ for customer having scotia card |


  @personal @nonpersonal
    @english
    @L1 @accountmailingaddress
  Scenario Outline: verify personal customer account address details in accounting mailing screen are displayed correctly
    Given officer login into intralink "<ScenarioId>" "Personal"
    And accessed "Customer Sales & Service (New)" application
    And located customer with account number in customer locate/setup
    And clicked on personal customer product
    Then validated account mailing address with account profile address
    Then signed-off from intralink
    Examples:
      | ScenarioId                                                                                |
      | Account address details in account mailing screen display correctly for personal customer |


  @nonpersonal
    @english
    @L1 @businessaccountmailingaddress
  Scenario Outline: verify non-personal customer account address details in accounting mailing screen are displayed correctly
    Given officer login into intralink "<ScenarioId>" "NonPersonal"
    And accessed "Customer Sales & Service (New)" application
    And located non-personal customer with cid
    And clicked on non-personal customer product
    Then validated account mailing address with business account profile address
    Then signed-off from intralink
    Examples:
      | ScenarioId                                                                                             |
      | Business account address details in account mailing screen display correctly for non-personal customer |
