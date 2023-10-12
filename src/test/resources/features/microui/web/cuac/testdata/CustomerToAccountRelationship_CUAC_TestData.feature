Feature: Create test data for customer to account relationship
  It retrieves CID's from MDM database and check its relationship values and update in test data database


  @changeRelationshipTestData
  Scenario Outline: change a primary relationship
#    Given read "crs" test data for "<Description>"
    And get customer accounts from MDM having "<Product>"
    And replace relationship status for customer accounts



    Given officer login into intralink "<ScenarioId>" "cuacRules"
    And accessed CIS Centre application
    And located account with account number
    Then officer changed "<Existing relationship>" primary relationship to "<New relationship>"
    And officer verified relationship changed to "<New relationship>"
    Examples:
      | ScenarioId                 | Product |
      | Change existing BOR to SOL | VAX     |