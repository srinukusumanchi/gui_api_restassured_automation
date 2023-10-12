@customerlookup
Feature: Customer Lookup - Checks customer is present in backend MDM or not

  Background:
#  In customer lookup API it can search whether customer present or not
#  1) Personal customer details - First Given Name, First Last name, Birthdate, Phone Number, Postal code, Email

#  Input parameters - First Given Name, First Last name, Birthdate, Phone Number, Postal code, Email
#  Customer Lookup allows profile status with Open and Derogatory status
#  It will not allow - Business credit, Closed, Involved Party, Prospective
  @customerexistsinmdm
  Scenario Outline: check customer exists for customer status open and derogatory
    Given checked customer present or not using individual details for "<Description>" "CUSTOMERLOOKUP_API"
    Then verified customer existed in MDM DB
    Examples:
      | Description                                                           |
#      Positive Test cases
      | Customer exists in MDM - OPEN - First and Last Name                   |
      | Customer exists in MDM - DEROGATORY - First, Last Name and Birth date |
      | Customer exists in MDM - OPEN - Phone Number                          |
      | Customer exists in MDM - DEROGATORY - Phone Number and Postal code    |
      | Customer exists in MDM - OPEN - Email                                 |


  @customerexistsinmdmotherthanopanddrstatus
  Scenario Outline: check customer does not exists for customer status business credit or closed or involved party or prospective
    Given checked customer present or not using individual details for "<Description>" "CUSTOMERLOOKUP_API"
    Then verified customer existed in MDM DB whose status is BC or CL or IP or PR
    Examples:
      | Description                                                         |
      | Customer exists in MDM - BUSINESS CREDIT - First and Last Name      |
      | Customer exists in MDM - CLOSED - First, Last Name and Birth date   |
      | Customer exists in MDM - INVOLVED PARTY - Phone Number              |
      | Customer exists in MDM - PROSPECTIVE - Phone Number and Postal code |
      | Customer exists in MDM - INVOLVED PARTY - Email                     |


  @customerdoesnotexistsinmdm
  Scenario Outline: check customer does not exists in MDM
    Given checked unknown customer not present in MDM for "<Description>" "CUSTOMERLOOKUP_API"
    Then verified customer not existed in MDM DB
    Examples:
      | Description                                                       |
      | Customer does not exists in MDM - First and Last Name             |
      | Customer does not exists in MDM - First, Last Name and Birth date |
      | Customer does not exists in MDM - Phone Number                    |
      | Customer does not exists in MDM - Phone Number and Postal code    |
      | Customer does not exists in MDM - Email                           |


#    Negative Test cases
#  First Name length should be less than or equal to 20 (Mandatory) - enter empty value, enter greater than 20 characters
#  Last Name length should be less than or equal to 33 (Mandatory) - enter empty value, enter greater than 33 characters
#  Birth date length should be less than or equal to 10 (Optional) - enter wrong format, enter greater than 10 characters
#  Phone Number length should be less than or equal to 16 (Mandatory) - enter empty value, enter alphabets, enter greater than 16 digits
#  Postal code length should be less than or equal to 9 (Optional) - enter emtpy value, enter postal code length greater than 9 characters
#  Email length should be less than or equal to 129 (Optional) - enter empty value, enter email lenght greater than 129 characters
#  Scenario Outline: check customer does not exists in MDM
#    Given checked unknown customer not present in MDM for "<Description>" "CUSTOMERLOOKUP_API"
#    Then verified customer not existed in MDM DB
#    Examples:
#      | Description                                                       |
#      | Customer does not exists in MDM - First and Last Name             |
