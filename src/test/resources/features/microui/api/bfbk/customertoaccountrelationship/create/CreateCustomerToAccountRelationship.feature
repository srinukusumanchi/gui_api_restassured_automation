@customertoaccountrelationship
Feature: Customer to account relationship - Create relationship between customer and account


#  Input parameters - customer_id, relationships-relationship_type, account_number, product_code
  @createcustomertoaccountrelationship
  Scenario Outline: create customer to account relationship
    Given created customer to account relationship for "<Description>" "CUSTOMERTOACCOUNTRELATIONSHIP_API"
    Examples:
      | Description                               |
      | Create a customer to account relationship |
