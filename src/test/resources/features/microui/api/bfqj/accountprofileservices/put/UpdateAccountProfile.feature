@accountprofile
Feature: Account Profile - Update different types of an account


#  Input parameters - account_number, account_title1, account_title2, product_type, sub_product_code, state,
#  city, line_1_addr, line_2_addr, line_3_addr, postal_cd, country_cd
  @accountprofileupdate
  Scenario Outline: create account profile with address details
    Given updated account profile for "<Description>" "ACCOUNTPROFILE_API"
    Examples:
      | Description                                       |
      | update a relationship for an account and customer |
