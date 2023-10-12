/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-26
 * Created Time: 12:07 p.m.
 */

package stepDefinitions.api.bfbk;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import stepDefinitions.managers.PageObjectManager;

import java.sql.ResultSet;

@QAFTestStepProvider
public class CustomerToAccountRelationship {


    protected static Response response;
    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;

    public CustomerToAccountRelationship() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
    }

    public static Response getResponse() {
        return response;
    }

    public static void setResponse(Response response) {
        CustomerToAccountRelationship.response = response;
    }

    private void getCustomerToAccountResponse() throws Exception {
        //        Generate Request body
        String requestBody = pageObjectManager.getCustomerRelatiionShipGet().generateCustomerToAccountRelationshipGetRequest(testData);

        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer Search response
        bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship customerToAccountRelationship = new
                bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship();
        Response response = customerToAccountRelationship.getResponse(requestBody, "POST", ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name());
        setResponse(response);
    }

    @Given("^get all accounts linked to a customer for \"([^\"]*)\" \"([^\"]*)\"$")
    public void getAllAccountsLinkedToACustomerFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

//        Call to customer search method to get response
        getCustomerToAccountResponse();

        Response response = getResponse();
//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Customer To Account Relationship - Get all accounts linked to a cusotmer request response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer to account relationship get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer to account relationship get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }

    @Given("^created customer to account relationship for \"([^\"]*)\" \"([^\"]*)\"$")
    public void createdCustomerToAccountRelationshipFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getCustomerRelationShipCreate().generateCustomerToAccountRelationshipRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship customerAccountRelationship =
                new bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship();
        Response response = customerAccountRelationship.getResponse(requestBody, "POST", ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Customer Account relationship - Create customer relationship response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer Account relationship - Create customer relationship response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer Account relationship - Create customer relationship response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }

    }

    @Given("^updated customer to account relationship for \"([^\"]*)\" \"([^\"]*)\"$")
    public void updatedCustomerToAccountRelationshipFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getCustomerRelationShipUpdate().generateCustomerToAccountRelationshipRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship customerAccountRelationship =
                new bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship();
        Response response = customerAccountRelationship.getResponse(requestBody, "PUT", ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Customer Account relationship - Update customer relationship response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer Account relationship - Update customer relationship response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer Account relationship - Update customer relationship response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }

    }


    @Given("^deleted customer to account relationship for \"([^\"]*)\" \"([^\"]*)\"$")
    public void deletedCustomerToAccountRelationshipFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getCustomerRelationShipDelete().generateCustomerToAccountRelationshipRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship customerAccountRelationship =
                new bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship();
        Response response = customerAccountRelationship.getResponse(requestBody, "PUT", ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Customer Account relationship - Delete customer relationship response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer Account relationship - Delete customer relationship response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer Account relationship - Delete customer relationship response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }
}
