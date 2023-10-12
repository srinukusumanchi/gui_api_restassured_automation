/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 10:26 a.m.
 */

package stepDefinitions.api.bf9k;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bf9k.customersearch.mapper.get.Mapper;
import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.utility.database.MDMDB;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import stepDefinitions.managers.PageObjectManager;

import java.sql.ResultSet;
import java.util.stream.Collectors;

@QAFTestStepProvider
public class CustomerSearch {

    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private final PageObjectManager pageObjectManager;
    protected static Response response;

    public CustomerSearch() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
    }

    public static Response getResponse() {
        return response;
    }

    public static void setResponse(Response response) {
        CustomerSearch.response = response;
    }


    private void getCustomerSearchResponse(String type) throws Exception {
        String requestBody = null;
        //        Generate Request body
        if (type.equalsIgnoreCase("ACCOUNT")) {
            requestBody = pageObjectManager.getCustomerSearchUsingAccountGet().generateCustomerSearchWithAccountNumberRequest(testData);
        } else if (type.equalsIgnoreCase("SIN")) {
            requestBody = pageObjectManager.getCustomerSearchUsingAccountGet().generateCustomerSearchWithSINRequest(testData);
        } else if (type.equalsIgnoreCase("PHONE")) {
            requestBody = pageObjectManager.getCustomerSearchUsingAccountGet().generateCustomerSearchWithPhoneRequest(testData);
        } else if (type.equalsIgnoreCase("CARD")) {
            requestBody = pageObjectManager.getCustomerSearchUsingAccountGet().generateCustomerSearchWithCardRequest(testData);
        } else if (type.equalsIgnoreCase("INSTITUTION")) {
            requestBody = pageObjectManager.getCustomerSearchUsingAccountGet().generateCustomerSearchWithNonPersonalRequest(testData);
        } else if (type.equalsIgnoreCase("INDIVIDUAL")) {
            requestBody = pageObjectManager.getCustomerSearchUsingAccountGet().generateCustomerSearchWithPersonalRequest(testData);
        } else if (type.equalsIgnoreCase("ADDRESS")) {
            requestBody = pageObjectManager.getCustomerSearchUsingAccountGet().generateCustomerSearchWithAddressRequest(testData);
        }

        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer Search response
        bns.a6.microui.api.pojo.bf9k.customersearch.utility.CustomerSearch customerSearch = new
                bns.a6.microui.api.pojo.bf9k.customersearch.utility.CustomerSearch();
        Response response = customerSearch.getResponse(requestBody, "POST", ServiceNames.CUSTOMERSEARCH.name());
        setResponse(response);
    }


    @Given("^get customer details for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void getCustomerDetailsFor(String scenarioId, String testDataDB, String type) throws Exception {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);
        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

//        Call to customer search method to get response
        getCustomerSearchResponse(type);

        Response response = getResponse();
//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Customer Search - Get Customer search request response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer Search get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer Search get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }

    private void getObjectIndex(Response response, String objectPath, String expectedValue) {

    }

    @Then("^validate customer search response in MDM database$")
    public void validateCustomerSearchResponseInMDMDatabase() throws Exception {
        String query = null;

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));


        bns.a6.microui.api.pojo.bf9k.customersearch.utility.CustomerSearch customerSearch = new bns.a6.microui.api.pojo.bf9k.customersearch.utility.CustomerSearch();

        //        D-serialization (Get response of create customer profile)
        Response responseCustomerSearch = getResponse();
        Mapper customerSearchResponse = customerSearch.getCustomerSearchResponse(responseCustomerSearch);

//        Retrieving  query for Customer profile
        utility.queries.mdm.customersearch.CustomerSearch customerSearchDB = utility.queries.mdm.customersearch.CustomerSearch.valueOf
                (utility.queries.mdm.customersearch.CustomerSearch.CUSTOMERSEARCH.name());


//        Search Using Account Number
        if (testData.getString("searchtype").equalsIgnoreCase("Account")) {
            query = customerSearchDB.getQuery().concat(utility.queries.mdm.customersearch.CustomerSearch.
                            ACCOUNTNUMBER.getQuery()).replace("<ACCOUNT_TYPE>", testData.getString("account_type"))
                    .replace("<ACCOUNT_NUMBER>", testData.getString("account_no"));
        }
        // Personal
        else if (testData.getString("searchtype").equalsIgnoreCase("Personal")) {
            query = customerSearchDB.getQuery().concat(utility.queries.mdm.customersearch.CustomerSearch.
                            PERSONALDETAILS.getQuery()).replace("<CUSTOMER_TYPE_CD>", testData.getString("customer_type_cd"))
                    .replace("<TITLE_NAME>", testData.getString("title_name"))
                    .replace("<FIRST_GIVEN_NAME>", testData.getString("customer_type_cd"))
                    .replace("<FIRST_LAST_NAME>", testData.getString("title_name"))
                    .replace("<FULL_NAME>", testData.getString("full_name"))
                    .replace("<BIRTH_DT>", testData.getString("birth_date"));
        }
//        Address
        else if (testData.getString("searchtype").equalsIgnoreCase("Address")) {
            query = customerSearchDB.getQuery().concat(utility.queries.mdm.customersearch.CustomerSearch.
                            PERSONALDETAILS.getQuery()).replace("<CUSTOMER_TYPE_CD>", testData.getString("customer_type_cd"))
                    .replace("<TITLE_NAME>", testData.getString("title_name"))
                    .replace("<FIRST_GIVEN_NAME>", testData.getString("customer_type_cd"))
                    .replace("<FIRST_LAST_NAME>", testData.getString("title_name"))
                    .replace("<FULL_NAME>", testData.getString("full_name"))
                    .replace("<BIRTH_DT>", testData.getString("birth_date"));
        }
//        Card
        else if (testData.getString("searchtype").equalsIgnoreCase("Card")) {
            query = customerSearchDB.getQuery().concat(utility.queries.mdm.customersearch.CustomerSearch.
                            CARD.getQuery()).replace("<CARD_TYPE>", testData.getString("card_type"))
                    .replace("<CARD_ID>", testData.getString("card_id"));
        }
//        Non-Personal
        else if (testData.getString("searchtype").equalsIgnoreCase("NonPersonal")) {
            query = customerSearchDB.getQuery().concat(utility.queries.mdm.customersearch.CustomerSearch.
                            NONPERSONALDETAILS.getQuery()).replace("<CUSTOMER_TYPE_CD>", testData.getString("customer_type_cd"))
                    .replace("<ORGANIZATION_NAME>", testData.getString("organization_name"))
                    .replace("<NAME_TYPE>", testData.getString("name_type"))
                    .replace("<POSTAL_CD>", testData.getString("postal_cd"));
        }
//        Phone
        else if (testData.getString("searchtype").equalsIgnoreCase("Phone")) {
            query = customerSearchDB.getQuery().concat(utility.queries.mdm.customersearch.CustomerSearch.
                            PHONENUMBER.getQuery()).replace("<CUSTOMER_TYPE_CD>", testData.getString("customer_type_cd"))
                    .replace("<PHONE_NO>", testData.getString("phone_no"));
        }

//        SIN
        else if (testData.getString("searchtype").equalsIgnoreCase("SIN")) {
            query = customerSearchDB.getQuery().concat(utility.queries.mdm.customersearch.CustomerSearch.
                            SINNUMBER.getQuery()).replace("<CUSTOMER_TYPE_CD>", testData.getString("customer_type_cd"))
                    .replace("<SIN>", testData.getString("sin"));
        }


        //        Stores all country information in list that comes from MDM
        ResultSet mdmResultSet = MDMDB.getInstance().getData(query);


//        Verify Number of records in API and MDM
        int numberOfRecordsAPI = customerSearchResponse.getData().size();
        mdmResultSet.last();
        int numberOfRecordsDatabase = mdmResultSet.getRow();
//        compare count size
        if (numberOfRecordsAPI == numberOfRecordsDatabase) {
            ReportPortal.stepPassWithoutScreenshot("Number of records in API and Database are equal - Size :- " + numberOfRecordsAPI +
                    " for Scenario Id-" + scenarioContext.getScenarioId());
            mdmResultSet.beforeFirst();

            while (mdmResultSet.next()) {
                String cid = mdmResultSet.getString("CID");
                int index = customerSearchResponse.getData().stream().map(x -> x.getBasic_information().getCustomer_key()).collect(Collectors.toList()).indexOf(cid);

//        Validate customer_basic_information block

                //   Customer Key
                String customerkeyAPI = customerSearchResponse.getData().get(index).getBasic_information().getCustomer_key();
                String customerkeyMdmDb = mdmResultSet.getString("CID");
                if (customerkeyAPI.equals(customerkeyMdmDb)) {
                    ReportPortal.stepPassWithScreenshot("Customer Key is as expected for Customer Search" +
                            " Customer Key:- " + customerkeyMdmDb);
                } else {
                    ReportPortal.stepFailWithScreenshot("Customer Key is not as expected for Customer Search " +
                            " Actual Customer Key:- " + customerkeyAPI +
                            " Expected Customer Key:- " + customerkeyMdmDb);
                }


                // customer_Type
                String customerTypeAPI = customerSearchResponse.getData().get(index).getBasic_information().getCustomer_type();
                String customerTypeMdmDb = mdmResultSet.getString("CUSTOMER_TYPE");
                if (customerTypeAPI.equals(customerTypeMdmDb)) {
                    ReportPortal.stepPassWithScreenshot("Customer Type is as expected for Customer Search" +
                            " Customer Type:- " + customerTypeMdmDb);
                } else {
                    ReportPortal.stepFailWithScreenshot("Customer Type is not as expected for Customer Search " +
                            " Actual Customer Type:- " + customerTypeAPI +
                            " Expected Customer Type:- " + customerTypeMdmDb);
                }


                // customer_status
                String customerStatusAPI = customerSearchResponse.getData().get(index).getBasic_information().getCustomer_status();
                String customerStatusMdmDb = mdmResultSet.getString("CUSTOMER_STATUS");
                if (customerStatusAPI.equals(customerStatusMdmDb)) {
                    ReportPortal.stepPassWithScreenshot("Customer Status is as expected for Customer Search" +
                            " Customer Status:- " + customerStatusMdmDb);
                } else {
                    ReportPortal.stepFailWithScreenshot("Customer Status is not as expected for Customer Search " +
                            " Actual Customer Status:- " + customerStatusAPI +
                            " Expected Customer Status:- " + customerStatusMdmDb);
                }

            }

        } else {
            ReportPortal.stepFailWithOutScreenshot("Number of records in API and Database are not equal, " +
                    " API records count Actual:- " + numberOfRecordsAPI +
                    " Database records count Expected:- " + numberOfRecordsDatabase +
                    " for Scenarios Id:- " + scenarioContext.getScenarioId());
        }

//        Need to develop and it is completely developed
//        Validate Basic Information block
      /*  customerSearchResponse.getData().get(0).getBasic_information().getCustomer_key();

        customerSearchResponse.getData().get(0).getBasic_information().getCustomer_type();
        customerSearchResponse.getData().get(0).getBasic_information().getCustomer_status();
        customerSearchResponse.getData().get(0).getBasic_information().getProfile_type();
        customerSearchResponse.getData().get(0).getBasic_information().getSensitivity_cd();
        customerSearchResponse.getData().get(0).getBasic_information().getExternal_customer_id();
//      Basic Information -> Information
        customerSearchResponse.getData().get(0).getBasic_information().getIndividual().getTitle_name();
        customerSearchResponse.getData().get(0).getBasic_information().getIndividual().getFirst_given_name();
        customerSearchResponse.getData().get(0).getBasic_information().getIndividual().getFirst_last_name();
        customerSearchResponse.getData().get(0).getBasic_information().getIndividual().getFull_name();
        customerSearchResponse.getData().get(0).getBasic_information().getIndividual().getBirth_date();

        //      Basic Information -> Information
//        Time being keeping address list to '0'
        customerSearchResponse.getData().get(0).getBasic_information().getAddress_list().get(0).getAddress_type_cd();
        customerSearchResponse.getData().get(0).getBasic_information().getAddress_list().get(0).getLine_1_addr();
        customerSearchResponse.getData().get(0).getBasic_information().getAddress_list().get(0).getLine_2_addr();
        customerSearchResponse.getData().get(0).getBasic_information().getAddress_list().get(0).getLine_3_addr();
        customerSearchResponse.getData().get(0).getBasic_information().getAddress_list().get(0).getCity();
        customerSearchResponse.getData().get(0).getBasic_information().getAddress_list().get(0).getState();
        customerSearchResponse.getData().get(0).getBasic_information().getAddress_list().get(0).getPostal_cd();
        customerSearchResponse.getData().get(0).getBasic_information().getAddress_list().get(0).getCountry_cd();

//        Accounts associated
        customerSearchResponse.getData().get(0).getAccount_associated().getAccount_no();
        customerSearchResponse.getData().get(0).getAccount_associated().getAccount_type();
        customerSearchResponse.getData().get(0).getAccount_associated().getRelationship();*/

    }


}

