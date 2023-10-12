@non-personal_regression_mandatory @L1
Feature: Customer profile services - Non-Personal customer


#   Create a Non-Personal customer profile
#  Inquire a Non-Personal customer profile details
#  Validate Non-Personal customer information against MDM database
  @nonpersonalcustomercreatewithservice
  Scenario Outline: setup and inquire non-personal customer in customer profile service and inquire customer details
    Given create a non-personal customer with customer profile service for "<Description>" "Non_PERSONAL_API"
    And verified "Institution" customer details in inquiry service
    Then verified non-personal customer details in MDM database
#    Then verified customer in BGX4 application
    Examples:
      | Description                                                          |
      | Setup non-personal customer and verify in details in Inquiry service |