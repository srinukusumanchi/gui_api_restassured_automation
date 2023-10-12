Feature: Non - Personal customer creation
  It creates a non-personal customer for below customer types
  Sm-Small Business,
  Sm-Ass'ns/Not For Profit-Small Bus,
  Sm-Aboriginal-Small Business,
  Sm-First Nations Band/Council/Small,
  Com-Commercial Business,
  Com-Commercial Real Estate,
  Com-Fraternal Assoc Comm Bus,
  Com-Aboriginal-Commercial Bus,
  Com-First Nations Band/Council/Com,
  Corp-Corporate Real Estate,
  Corp-Corporate Non Real Estate

#   @NonPersonalCustomerCreation
  Scenario Outline: create non-personal customer
    Given officer login into intralink "<ScenarioId>" "NonPersonal"
    And accessed "Customer Sales & Service (New)" application
    And located non-personal customer with legal name
    And created new non-personal customer
#    And created new personal customer

    Examples:
      | ScenarioId                     |
      | Non-Personal customer creation |