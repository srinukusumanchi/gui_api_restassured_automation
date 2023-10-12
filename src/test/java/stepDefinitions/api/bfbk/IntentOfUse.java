/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-22
 * Created Time: 8:03 a.m.
 */

package stepDefinitions.api.bfbk;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship;
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
public class IntentOfUse {

    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;

    public IntentOfUse() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
    }

    @Given("^created customer level intent of use for \"([^\"]*)\" \"([^\"]*)\"$")
    public void createdCustomerLevelIntentOfUseFor(String scenarioId, String testDataDB) throws Throwable {
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
        CustomerToAccountRelationship customerToAccountRelationship = new CustomerToAccountRelationship();
        Response response = customerToAccountRelationship.getResponse(requestBody, "POST", ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Customer to account relationship - Create customer to account relationship response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer to account relationship create response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer to account relationship create response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }

    @Given("^updated customer level intent of use for \"([^\"]*)\" \"([^\"]*)\"$")
    public void updatedCustomerLevelIntentOfUseFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getIntentOfUseUpdate().generateIntentOfUseUpdateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        bns.a6.microui.api.pojo.bfbk.intentofuse.utility.IntentOfUse intentOfUse = new bns.a6.microui.api.pojo.bfbk.intentofuse.utility.IntentOfUse();
        Response response = intentOfUse.getResponse(requestBody, "PUT", ServiceNames.INTENTOFUSE.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Intent of use - Update customer level intent of use response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Intent of use update response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Intent of use update response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200");
        }
    }

    @Given("^get all intent use accounts of a customer for \"([^\"]*)\" \"([^\"]*)\"$")
    public void getAllIntentUseAccountsOfACustomerFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getIntentOfUseInquiry().generateIntentOfUseGetRequest(testData);


        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Intent use response
        bns.a6.microui.api.pojo.bfbk.intentofuse.utility.IntentOfUse intentOfUse = new
                bns.a6.microui.api.pojo.bfbk.intentofuse.utility.IntentOfUse();
        Response response = intentOfUse.getResponse(requestBody, "POST", ServiceNames.INTENTOFUSE.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Intent Use - Get Intent use of account for a customer request response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Intent Use - Get Intent use of account for a customer request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Intent Use - Get Intent use of account for a customer request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }
}
