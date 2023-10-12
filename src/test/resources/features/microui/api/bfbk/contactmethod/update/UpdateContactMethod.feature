@contactmethod
Feature: Customer profile services - Update contact method

#  Input parameters - CID, Customer Type- P, O and Email Id
  @updatecontactmethod
  Scenario Outline: update personal or non-personal customer contact methods with customer profile service
    Given updated customer contact method details for "<Description>" "PERSONAL_API"
    Examples:
      | Description                                |
      | Update personal customer contact method381 |




