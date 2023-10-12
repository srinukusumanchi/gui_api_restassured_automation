@accountprofileservices
Feature: Get account details


#  Input parameters - account_number, product_type, sub_product_code
  @accountprofileservicesget
  Scenario Outline: get account information
    Given get account information for "<Description>" "ACCOUNTPROFILE_API"
    Examples:
      | Description                  |
      | Retrieve account Information |
