@customersearch
Feature: Customer Search - Get Customer Information

#  In customer search API it can search with different combinations like below
#  1) Account Number  and Account type
#  2) Personal customer details - Given Name, Last Name, Birthdate, Sin, Phone Number, Postal code, Profile type
#     Customer status code, City, Line 1 address, state, address type code
#  3) Card - Card Id, Card type
#  4) Non Personal customer details - Organization name, Name type, Postal code
#  5) Phone Number
#  6) Sin

#  Input parameters - Account Number, Account type
  @customersearchusingaccount
  Scenario Outline: search customer with account details
    Given get customer details for "<Description>" "CUSTOMERSEARCH_API" "ACCOUNT"
    Then validate customer search response in MDM database
    Examples:
      | Description                                    |
      | Retrieve customer details with account details |


    #  Input parameters - Customer Type code, SIN
  @customersearchusingsin
  Scenario Outline: search customer with SIN details
    Given get customer details for "<Description>" "CUSTOMERSEARCH_API" "SIN"
    Then validate customer search response in MDM database
    Examples:
      | Description                                |
      | Retrieve customer details with sin details |

#  Input parameters - Customer Type code, phone_no
  @customersearchusingphonenumber
  Scenario Outline: search customer with SIN details
    Given get customer details for "<Description>" "CUSTOMERSEARCH_API" "PHONE"
    Then validate customer search response in MDM database
    Examples:
      | Description                                  |
      | Retrieve customer details with phone details |


    #  Input parameters - Customer Type code, phone_no
  @customersearchusingcardnumber
  Scenario Outline: search customer with card details
    Given get customer details for "<Description>" "CUSTOMERSEARCH_API" "CARD"
    Then validate customer search response in MDM database
    Examples:
      | Description                                 |
      | Retrieve customer details with card details |


    #  Input parameters - Customer Type code, Organization name, Name type, Postal code
  @customersearchusingnonpersonaldetails
  Scenario Outline: search customer with non personal customer details
    Given get customer details for "<Description>" "CUSTOMERSEARCH_API" "INSTITUTION"
    Then validate customer search response in MDM database
    Examples:
      | Description                                        |
      | Retrieve customer details with institution details |

    #  Input parameters - Customer Type code, Title name, First Given Name, First Last Name, Full Name, Birth date
  @customersearchusingpersonaldetails
  Scenario Outline: search customer with personal customer details
    Given get customer details for "<Description>" "CUSTOMERSEARCH_API" "INDIVIDUAL"
    Then validate customer search response in MDM database
    Examples:
      | Description                                       |
      | Retrieve customer details with individual details |

        #  Input parameters - Customer Type code, Address type code, Line 1 address, Line 2 address, City, State,
        #  Postal code, Country code
  @customersearchusingaddressdetails
  Scenario Outline: search customer with address details
    Given get customer details for "<Description>" "CUSTOMERSEARCH_API" "ADDRESS"
    Then validate customer search response in MDM database
    Examples:
      | Description                                    |
      | Retrieve customer details with address details |