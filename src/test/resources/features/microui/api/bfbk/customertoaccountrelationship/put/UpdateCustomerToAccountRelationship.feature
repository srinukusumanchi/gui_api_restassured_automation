@customertoaccountrelationship
Feature: Customer to account relationship - Update relationship between customer and account


#  Input parameters - customer_id, relationships-relationship_type, account_number, product_code
  @updatecustomertoaccountrelationship
  Scenario Outline: update customer to account relationship
    Given updated customer to account relationship for "<Description>" "CUSTOMERTOACCOUNTRELATIONSHIP_API"
    Examples:
      | Description                               |
      | Update a customer to account relationship |
