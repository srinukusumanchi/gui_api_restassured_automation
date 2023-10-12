@countrycodereference
Feature: Get country list

  @mdmcountrylist
  Scenario Outline: validate all countries in database are correct
    Given get all country list for "<Description>" "COUNTRYCODEREFERENCE_API"
    Given validate mdm countries with respect to RDM
    Examples:
      | Description                                   |
      | verify mdm country list against RDM - English |
      | verify mdm country list against RDM - French  |

  @countrycodelist
  Scenario Outline: get all country list and validate against MDM
    Given get all country list for "<Description>" "COUNTRYCODEREFERENCE_API"
    Then validated country list with MDM database
    Examples:
      | Description                                             |
      | Retrieve all Active and Inactive country list - English |
      | Retrieve all Active and Inactive country list - French  |
      | Retrieve all Active country list - English              |
      | Retrieve all Active country list - French               |