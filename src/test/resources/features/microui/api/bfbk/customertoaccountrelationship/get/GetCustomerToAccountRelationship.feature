@customertoaccountrelationship
Feature: Get Customer related account information


#  Input parameters - customer_id
  @customertoaccountrelation
  Scenario Outline: get all accounts linked to a customer
    Given get all accounts linked to a customer for "<Description>" "CUSTOMERTOACCOUNTRELATIONSHIP_API"
    Examples:
      | Description                                |
      | Retrieve all accounts linked to a customer |
