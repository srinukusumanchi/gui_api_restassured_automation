@personal_regression_mandatory @L1
Feature: Customer profile services - Personal customer


#   Create a Individual customer profile
#  Inquire a Individual customer profile details
#  Validate customer information against MDM database
  @personalcustomercreatewithservice
  Scenario Outline: setup and inquire personal customer in customer profile service and inquire customer details
    Given create a personal customer with customer profile service for "<Description>" "PERSONAL_API"
    And verified "Individual" customer details in inquiry service
    Then verified personal customer details in MDM database
#    Then verified customer in BGX4 application
    Examples:
      | Description                                |
      | Setup personal customer and verify in bgx4 |


  @personalcustomerupdatewithservice
  Scenario Outline: update personal customer in customer profile service and verify in bgx4
    Given create a personal customer with customer profile service for "<Description>" "PERSONAL_API"
    Given updated a personal customer with customer profile service for "<Description>" "PERSONAL_API"
#    And inquired customer information with customer profile service
    Then verified customer in BGX4 application
    Examples:
      | Description                                             |
      | Update and inquire personal customer and verify in bgx4 |