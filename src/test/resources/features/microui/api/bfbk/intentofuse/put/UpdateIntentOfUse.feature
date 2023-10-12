@intentofusecustomerlevel
Feature: Intent of use customer - Update customer level Intent of use


#  Input parameters - Updated customer Id, Intent account number, Intended use type, updated transaction date, relationship,
#    product type, sub product type, capture type, aml trigger, last updated user id
  @updateintentofuse
  Scenario Outline: update intent of use account (customer level)
    Given updated customer level intent of use for "<Description>" "INTENTOFUSE_API"
    Examples:
      | Description                                    |
      | Retrieve customer details with account details |
