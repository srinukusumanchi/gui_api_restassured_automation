/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-19
 * Created Time: 10:03 a.m.
 */

package stepDefinitions.api.bfbk;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.get.Mapper;
import bns.a6.microui.api.pojo.bfbk.customerprofile.utility.CustomerProfile;
import bns.a6.microui.api.pojo.bfbk.employment.utility.Employment;
import bns.a6.microui.api.pojo.bfbk.identification.personal.utility.Identification;
import bns.a6.microui.api.utility.worddocument.ReportToWord;
import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import stepDefinitions.managers.PageObjectManager;
import stepDefinitions.managers.StepDefinitionManager;

import java.sql.ResultSet;

@QAFTestStepProvider
public class PersonalCustomer {

    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private final StepDefinitionManager stepDefinitionManager;
    private final PageObjectManager pageObjectManagerAPI;
    private final bns.a6.microui.web.managers.PageObjectManager pageObjectManagerGUI;
    protected static Response response;

    public PersonalCustomer() {
        scenarioContext = ScenarioContext.getInstance();
        stepDefinitionManager = StepDefinitionManager.getInstance();
        pageObjectManagerAPI = PageObjectManager.getInstance();
        pageObjectManagerGUI = bns.a6.microui.web.managers.PageObjectManager.getInstance();
    }

    public static Response getResponse() {
        return response;
    }

    public static void setResponse(Response response) {
        PersonalCustomer.response = response;
    }


    @Given("^create a personal customer with customer profile service for \"([^\"]*)\" \"([^\"]*)\"$")
    public void createAPersonalCustomerWithCustomerProfileServiceFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        ReportToWord writeToWordDoc = new ReportToWord();

//        Generate Request body
        String requestBodyCustomerProfile = pageObjectManagerAPI.getCustomerProfileIndividualCreate().generateCustomerCreateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Create Request Body - Customer Profile \n" + requestBodyCustomerProfile);
        // Get Customer profile creation response
        CustomerProfile customerProfile = new CustomerProfile();
        Response responseCustomerProfile = customerProfile.getResponse(requestBodyCustomerProfile, "POST", "CREATE", ServiceNames.CUSTOMERPROFILE.name());

        writeToWordDoc.writeText("-----Personal Customer Creation----");
        writeToWordDoc.createTable(2, 2);
        writeToWordDoc.writeInToDocumentV2(requestBodyCustomerProfile, "Request");
        writeToWordDoc.writeInToDocumentV2(responseCustomerProfile.asPrettyString(), "Response");
//        Verifies response status code
        if (responseCustomerProfile.getStatusCode() == 201) {
            ReportPortal.stepPass("Customer Profile create request response code is as expected - 201");
        } else {
            ReportPortal.stepFailWithOutScreenshot("Customer Profile create request response code is as not expected, Actual:- " + responseCustomerProfile.getStatusCode() +
                    " and Expected:- 201");
        }


//        D-serialization (Get response of create customer profile)
        Mapper customerProfileResponse = customerProfile.getCustomerProfileResponse(responseCustomerProfile);
//        Retrieving customer_key value and Save in test data
        String cid = customerProfileResponse.getData().getCustomer_basic_information().getCustomer_key();

//        Saving customer cid into table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "customer_key", cid));


//        Add Identification to created customer

        //        Saving customer cid into table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("IDENTIFICATIONS_API", scenarioContext.getScenarioId(),
                                "customer_id", cid));

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("IDENTIFICATIONS_API",
                                scenarioContext.getScenarioId()));

//        Generate Request body
        String requestBodyIdentification = pageObjectManagerAPI.getIdentificationIndividualCreate().generateIdentificationCreateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Create Request Body - Identification \n" + requestBodyIdentification);


        // Get Customer profile creation response
        Identification identification = new Identification();
        Response responseIdentification = identification.getResponse(requestBodyIdentification, "POST", ServiceNames.IDENTIFICATION.name());


        writeToWordDoc.writeText("---- Identification ----");
        writeToWordDoc.createTable(2, 2);
        writeToWordDoc.writeInToDocumentV2(requestBodyIdentification, "Request");
        writeToWordDoc.writeInToDocumentV2(responseIdentification.asPrettyString(), "Response");

//        Verifies response status code
        if (responseIdentification.getStatusCode() == 200) {
            ReportPortal.stepPass("Identification create request response code is as expected - 200");
        } else {
            ReportPortal.stepFailWithOutScreenshot("Identification create request response code is as not expected, Actual:- " + responseIdentification.getStatusCode() +
                    " and Expected:- 200");
        }

        //        Add Employment to created customer

        //        Saving customer cid into table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("EMPLOYMENT_API", scenarioContext.getScenarioId(),
                                "customer_id", cid));

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("EMPLOYMENT_API",
                                scenarioContext.getScenarioId()));

//        Generate Request body
        String requestBodyEmployment = pageObjectManagerAPI.getEmploymentCreate().generateEmploymentCreateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Create Request Body - Employment \n" + requestBodyEmployment);
        // Get Customer profile creation response
        Employment employment = new Employment();
        Response responseEmployment = employment.getResponse(requestBodyEmployment, "POST", ServiceNames.EMPLOYMENT.name());

        writeToWordDoc.writeText("---- Employment ----");
        writeToWordDoc.createTable(2, 2);
        writeToWordDoc.writeInToDocumentV2(requestBodyEmployment, "Request");
        writeToWordDoc.writeInToDocumentV2(responseEmployment.asPrettyString(), "Response");

//        Verifies response status code
        if (responseEmployment.getStatusCode() == 200) {
            ReportPortal.stepPass("Employment create request response code is as expected - 200");
        } else {
            ReportPortal.stepFailWithOutScreenshot("Employment create request response code is as not expected, Actual:- " + responseEmployment.getStatusCode() +
                    " and Expected:- 200");
        }

        writeToWordDoc.writeData();
    }


    @Given("^create a non-personal customer with customer profile service for \"([^\"]*)\" \"([^\"]*)\"$")
    public void createANonPersonalCustomerWithCustomerProfileServiceFor(String scenarioId, String testDataDB) throws Throwable {

        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        ReportToWord writeToWordDoc = new ReportToWord();

//        Generate Request body
        String requestBodyCustomerProfile = pageObjectManagerAPI.getCustomerProfileInstitutionCreate().generateCustomerCreateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Create Request Body - Customer Profile-Non-Personal \n" + requestBodyCustomerProfile);
        // Get Customer profile creation response
        CustomerProfile customerProfile = new CustomerProfile();
        Response responseCustomerProfile = customerProfile.getResponse(requestBodyCustomerProfile, "POST", "CREATE", ServiceNames.CUSTOMERPROFILE.name());

        writeToWordDoc.writeText("-----Personal Customer Creation----");
        writeToWordDoc.createTable(2, 2);
        writeToWordDoc.writeInToDocumentV2(requestBodyCustomerProfile, "Request");
        writeToWordDoc.writeInToDocumentV2(responseCustomerProfile.asPrettyString(), "Response");
//        Verifies response status code
        if (responseCustomerProfile.getStatusCode() == 201) {
            ReportPortal.stepPass("Customer Profile create request response code is as expected - 201");
        } else {
            ReportPortal.stepFailWithOutScreenshot("Customer Profile create request response code is as not expected, Actual:- " + responseCustomerProfile.getStatusCode() +
                    " and Expected:- 201");
        }


//        D-serialization (Get response of create customer profile)
        Mapper customerProfileResponse = customerProfile.getCustomerProfileResponse(responseCustomerProfile);
//        Retrieving customer_key value and Save in test data
        String cid = customerProfileResponse.getData().getCustomer_basic_information().getCustomer_key();

//        Saving customer cid into table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "customer_key", cid));

        writeToWordDoc.writeData();

    }


    @And("^verified \"([^\"]*)\" customer details in inquiry service$")
    public void verifiedCustomerDetailsInInquiryService(String customerType) throws Throwable {
        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        CustomerProfile customerProfile = new
                CustomerProfile();
        getCustomerProfileResponse();
        //        D-serialization (Get response of create customer profile)
        Response responseCustomerProfile = getResponse();
        bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.get.Mapper customerProfileResponse = customerProfile.getCustomerProfileResponse(responseCustomerProfile);

        if (customerType.equalsIgnoreCase("Individual")) {
//        Validate customer_basic_information block
            // customer_key
            String customerKeyActual = customerProfileResponse.getData().getCustomer_basic_information().getCustomer_key();
            String customerKeyExpected = testData.getString("customer_key");
            if (customerKeyActual.equals(customerKeyExpected)) {
                ReportPortal.stepPassWithScreenshot("Customer Key is as expected for Customer Profile services" +
                        " Customer Key:- " + customerKeyExpected);
            } else {
                ReportPortal.stepFailWithScreenshot("Customer Key is not as expected for Customer Profile services " +
                        " Actual Customer Key:- " + customerKeyActual +
                        " Expected Customer Key:- " + customerKeyExpected);
            }

        }
//        Validate Non-Personal customer
        else if (customerType.equalsIgnoreCase("Institution")) {

        }
    }


    @Then("^verified personal customer details in MDM database$")
    public void verifiedPersonalCustomerDetailsInMDMDatabase() {
    }

    @Then("^updated a personal customer with customer profile service for \"([^\"]*)\" \"([^\"]*)\"$")
    public void updatedAPersonalCustomerWithCustomerProfileServiceFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

//        Generate Request body
        String requestBody = pageObjectManagerAPI.getCustomerProfileIndividualUpdate().generateCustomerUpdateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        CustomerProfile customerProfile = new CustomerProfile();
        Response response = customerProfile.getResponse(requestBody, "PUT", "UPDATE", ServiceNames.CUSTOMERPROFILE.name());

        //        Verifies response status code
        if (response.getStatusCode() == 204) {
            ReportPortal.stepPassWithoutScreenshot("Customer Profile - Update Personal customer request response code is as expected - 204");
        } else {
            System.err.println("Customer Profile  update request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 204");
        }


        //        Add Identification to created customer
        //        Saving customer cid into table
        String cid = testData.getString("customer_key");
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("IDENTIFICATIONS_API", scenarioContext.getScenarioId(),
                                "customer_id", cid));

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("IDENTIFICATIONS_API",
                                scenarioContext.getScenarioId()));

//        Generate Request body
        String requestBodyIdentification = pageObjectManagerAPI.getIdentificationIndividualUpdate().generateIdentificationUpdateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Update Request Body - Identification \n" + requestBodyIdentification);

        // Get Customer profile creation response
        Identification identification = new Identification();
        Response responseIdentification = identification.getResponse(requestBodyIdentification, "PUT", ServiceNames.IDENTIFICATION.name());

//        Verifies response status code
        if (responseIdentification.getStatusCode() == 200) {
            ReportPortal.stepPass("Identification create request response code is as expected - 200");
        } else {
            ReportPortal.stepFailWithOutScreenshot("Identification create request response code is as not expected, Actual:- " + responseIdentification.getStatusCode() +
                    " and Expected:- 200");
        }


    }


    private void getCustomerProfileResponse() throws Exception {
        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManagerAPI.getCustomerProfileIndividualInquiry().generateCustomerInquiryRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer Search response
        CustomerProfile customerProfile = new
                CustomerProfile();

        Response response = customerProfile.getResponse(requestBody, "POST", "INQUIRY", ServiceNames.CUSTOMERPROFILE.name());
        setResponse(response);
    }


    @Then("^verified customer in BGX(\\d+) application$")
    public void verifiedCustomerInBGXApplication(int arg0) throws Throwable {

        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

//        make use of existing methods written in other step defintion classes for logging into intralink and verifying customer cid information
        stepDefinitionManager.getBNSEmployeeApplicationAccessSteps().
                officerLoginIntoIntralink(scenarioContext.getScenarioId(), scenarioContext.getTableName());

        stepDefinitionManager.getBNSEmployeeApplicationAccessSteps().accessedApplication("Customer Sales & Service (New)");


        pageObjectManagerGUI.getScotiaCardOrAccount().enterCID(testData.getString("customer_key")).clickFind();

        String actualCID = pageObjectManagerGUI.getHeaderNonPersonal().getCID().trim();
        String expectedCID = testData.getString("customer_key");

        //        Verifies response status code
        if (actualCID.equals(expectedCID)) {
            ReportPortal.stepPassWithoutScreenshot("Customer created/update in API can able to locate in BGX4");
        } else {
            System.err.println("Customer created/updated in API cannot able to locate in BGX4");
            ReportPortal.stepFailWithOutScreenshot("Customer created in API cannot able to locate in BGX4");
        }

        pageObjectManagerGUI.getIntralinkHeader().clickIntralinkImage().clickSignOff();


    }


}
