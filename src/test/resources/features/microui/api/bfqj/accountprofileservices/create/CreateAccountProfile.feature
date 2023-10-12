@accountprofile
Feature: Account Profile - Create different types of an account


#  Input parameters - account_number, account_title1, account_title2, product_type, sub_product_code, state,
#  city, line_1_addr, line_2_addr, line_3_addr, postal_cd, country_cd
  @accountprofilecreate
  Scenario Outline: create account profile with product and sub-product
    Given created account profile for "<Description>" "ACCOUNTPROFILE_API"
    Examples:
      | Description                                      |
      | Setup a relationship for an account and customer |
