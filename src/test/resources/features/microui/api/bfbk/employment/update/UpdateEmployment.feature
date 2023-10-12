@BFBK_regression_mandatory @L1
Feature: Employment services - BFBK high level functionalities


  @employmentupdate
  Scenario Outline: update personal customer employment details
    Given create a personal customer with customer profile service for "<Description>" "PERSONAL_API"
    Given updated customer employment details for "<Description>" "EMPLOYMENT_API"
    Examples:
      | Description                                |
      | Setup personal customer and verify in bgx4 |