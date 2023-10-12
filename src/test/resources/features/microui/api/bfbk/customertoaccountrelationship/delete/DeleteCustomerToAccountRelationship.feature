@customertoaccountrelationship
Feature: Customer to account relationship - Delete relationship between customer and account


#  Input parameters - customer_id, relationships-relationship_type, account_number, product_code
  @deletecustomertoaccountrelationship
  Scenario Outline: delete customer to account relationship
    Given deleted customer to account relationship for "<Description>" "CUSTOMERTOACCOUNTRELATIONSHIP_API"
    Examples:
      | Description                               |
      | Delete a customer to account relationship |
