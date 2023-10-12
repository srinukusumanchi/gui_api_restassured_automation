@intentofusecustomerlevel
Feature: Intent of use customer - Update customer level Intent of use


#  Input parameters - customer_id
  @getintentofuse
  Scenario Outline: get all intent of use account for a customer
    Given get all intent use accounts of a customer for "<Description>" "INTENTOFUSE_API"
    Examples:
      | Description                                    |
      | Retrieve customer details with account details |
