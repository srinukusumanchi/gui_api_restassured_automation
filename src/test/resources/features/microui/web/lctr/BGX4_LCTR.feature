@LCTR
Feature: BGX4 high level functionalities

  @NonPersonalCustomerCreation_LCTR
    @English @SmallBusiness
  Scenario Outline: create non-personal customer
    Given officer login into intralink "<ScenarioId>" "NonPersonal"
    And accessed "Customer Sales & Service (New)" application
    And located non-personal customer with legal name
    And Enter name and Business address
    And Enter Contact Information details
    And Enter Business Information details
    And Enter Loan Administration details
    And create non personal customer with relationship details added
    And click submit and reprofile the customer created
    Then captured created non-personal customer CID
    Then Validate the Contact Information
    Then Validate the Business Information provided
    Then Validate the Identification section
    Then signed-off from intralink
    Examples:
      | ScenarioId |
      |Setup_Com-Commercial Business_OP_EN |


  @NonPersonalCustomerCreation_LCTR_AllIDs
  Scenario Outline: create non-personal customer
    Given officer login into intralink "<ScenarioId>" "NonPersonal"
    And accessed "Customer Sales & Service (New)" application
    And located non-personal customer with legal name
    And Enter name and Business address
    And Enter Contact Information details
    And Enter Business Information details
    And Enter Loan Administration details
    And create non personal customer with relationship details added
    And click submit and reprofile the customer created
    Then captured created non-personal customer CID
    Then Validate the Contact Information
    Then Validate the Business Information provided
    Then Validate the Identification section
    Then signed-off from intralink
    Examples:
      | ScenarioId |
      |ID_setup-Sole Proprietorship-All Valid IDs |
      |ID_setup-Partnerships-All Valid IDs|
      |ID_setup-Corporation-All Valid IDs         |
      |ID_setup-Not-for-Profit/Charity-All Valid IDs|
      |ID_setup-Trust-All Valid IDs|
      |ID_setup-Joint Ventures-All Valid IDs|
      |ID_setup-Co-Operative-All Valid IDs|
      |ID_setup-Estate-All Valid IDs|

  @NonPersonalCustomerUpdate_LCTR    @English
  Scenario Outline: update non-personal customer details
    Given officer login into intralink "<ScenarioId>" "NonPersonal"
    And accessed "Customer Sales & Service (New)" application
    And located "NonPersonal" customer with cid
    And updated non-personal customer details
    And click on customer name
    Then Validate the Contact Information
    Then Validate the Business Information provided
    Then Validate the Identification section
    Then signed-off from intralink

    Examples:
      | ScenarioId                                        |
      |Update_Sm-Small Business_OP_FR                     |
      #|Update_Com-Commercial Business_OP_EN               |
      #|Update_Com-Commercial Real Estate_OP_EN            |
      #|Update_Com-Fraternal Assoc Comm Bus_OP_EN          |
      #|Update_Com-Aboriginal-Commercial Bus_OP_EN         |
      #|Update_Com-First Nations Band/Council/Com_OP_EN    |
      #|Update_Com-Commercial Business_PR_EN               |
      #|Update_Com-Commercial Real Estate_PR_EN            |
      #|Update_Com-Fraternal Assoc Comm Bus_PR_EN          |
      #|Update_Com-Aboriginal-Commercial Bus_PR_EN         |
      #|Update_Com-First Nations Band/Council/Com_PR_EN    |
      #|Update_Com-Commercial Business_DR_EN               |
      #|Update_Com-Commercial Real Estate_DR_EN            |
      #|Update_Com-Fraternal Assoc Comm Bus_DR_EN          |
      #|Update_Com-Aboriginal-Commercial Bus_DR_EN         |
      #|Update_Com-First Nations Band/Council/Com_DR_EN    |
      #|Update_Com-Commercial Business_IP_EN               |
      #|Update_Com-Commercial Real Estate_IP_EN            |
      #|Update_Com-Fraternal Assoc Comm Bus_IP_EN          |
      #|Update_Com-Aboriginal-Commercial Bus_IP_EN         |
      #|Update_Com-First Nations Band/Council/Com_IP_EN    |
      #|Update_Corp-Corporate Real Estate_OP_EN            |
      #|Update_Corp-Corporate Non Real Estate_OP_EN        |
      #|Update_Corp-Corporate Real Estate_PR_EN            |
      #|Update_Corp-Corporate Non Real Estate_PR_EN        |
      #|Update_Corp-Corporate Real Estate_DR_EN            |
      #|Update_Corp-Corporate Non Real Estate_DR_EN        |
      #|Update_Corp-Corporate Real Estate_IP_EN            |
      #|Update_Corp-Corporate Non Real Estate_IP_EN        |
      #|Update_Sm-Small Business_OP_EN                     |
      #|Update_Sm-Aboriginal-Small Business_OP_EN          |
      #|Update_Sm-First Nations Band/Council/Small_OP_EN   |
      #|Update_Sm-Ass'ns/Not For Profit-Small Bus_OP_EN    |
      #|Update_Sm-Small Business_PR_EN                     |
      #|Update_Sm-Aboriginal-Small Business_PR_EN          |
      #|Update_Sm-First Nations Band/Council/Small_PR_EN   |
      #|Update_Sm-Ass'ns/Not For Profit-Small Bus_PR_EN    |
      #|Update_Sm-Small Business_DR_EN                     |
      #|Update_Sm-Aboriginal-Small Business_DR_EN          |
      #|Update_Sm-First Nations Band/Council/Small_DR_EN   |
      #|Update_Sm-Ass'ns/Not For Profit-Small Bus_DR_EN    |
      #|Update_Sm-Small Business_IP_EN                     |
      #|Update_Sm-Aboriginal-Small Business_IP_EN          |
      #|Update_Sm-First Nations Band/Council/Small_IP_EN   |
      #|Update_Sm-Ass'ns/Not For Profit-Small Bus_IP_EN    |

  @NonPersonalCustomerUpdate_DeleteID_LCTR    @English
  Scenario Outline: update non-personal customer details and delete existing ID document
    Given officer login into intralink "<ScenarioId>" "NonPersonal"
    And accessed "Customer Sales & Service (New)" application
    And located "NonPersonal" customer with cid
    And Navigate to Identification section in Business Information
    And delete the existing ID document
    And click on customer name
    Then Validate the Identification section
    Then signed-off from intralink

    Examples:
      | ScenarioId                                        |
      #|DeleteID_Declaration_Dye & Durham              |
      |DeleteID_Declaration_Paper              |
      #|DeleteID_Declaration_Teranet             |
      #|DeleteID_Declaration_CIDREQ              |
      #|DeleteID_Declaration_Federal              |
      #|DeleteID_Sole Proprietorship-All Valid IDs	|
      #|DeleteID_Partnerships-All Valid IDs          	|
      #|DeleteID_Corporation-All Valid IDs			|
      #|DeleteID_Not-for-Profit/Charity-All Valid IDs	|
      #|DeleteID_Trust-All Valid IDs                 	|
      #|DeleteID_Joint Ventures-All Valid IDs        	|
      #|DeleteID_Co-Operative-All Valid IDs      		|
      #|DeleteID_Estate-All Valid IDs              	|
