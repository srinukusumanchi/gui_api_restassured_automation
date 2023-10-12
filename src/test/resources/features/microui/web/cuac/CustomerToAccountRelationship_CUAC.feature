Feature: Change a relation to a customer having an account
  It is allowed to change the primary relationship from BOR to SOL (death/divorce scenario)


  @changeRelationship
  Scenario Outline: change a primary relationship
    Given officer login into intralink "<ScenarioId>" "cuacRules"
    And accessed "CIS Centre" application
    And located account with account number
    Then officer changed "<Existing relationship>" primary relationship to "<New relationship>"
    And officer verified relationship changed to "<New relationship>"
    Examples:
      | ScenarioId                 | Existing relationship | New relationship |
      | Change existing BOR to SOL | SPOUSE                | COSIGNER         |