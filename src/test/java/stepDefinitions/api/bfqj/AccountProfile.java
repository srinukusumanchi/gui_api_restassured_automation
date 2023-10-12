/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 10:26 a.m.
 */

package stepDefinitions.api.bfqj;

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
public class AccountProfile {

    protected static Response response;
    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;

    public AccountProfile() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
    }

    public static Response getResponse() {
        return response;
    }

    public static void setResponse(Response response) {
        AccountProfile.response = response;
    }


    private void getAccountProfileResponse() throws Exception {
        String requestBody = pageObjectManager.getAccountProfileGet().generateAccountProfileServiceGetRequest(testData);

        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer Search response
        bns.a6.microui.api.pojo.bfqj.accountprofile.utility.AccountProfile accountProfile = new
                bns.a6.microui.api.pojo.bfqj.accountprofile.utility.AccountProfile();
        Response response = accountProfile.getResponse(requestBody, "GET", ServiceNames.ACCOUNTPROFILE.name());
        setResponse(response);
    }

    @Given("^get account information for \"([^\"]*)\" \"([^\"]*)\"$")
    public void getAccountInformationFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

//        Call to account profile method to get response
        getAccountProfileResponse();

        Response response = getResponse();
//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Account Profile - Get Account profile request response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Account profile get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Account profile get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }



    @Given("^created account profile for \"([^\"]*)\" \"([^\"]*)\"$")
    public void createdAccountProfileFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getAccountProfileCreate().generateAccountProfileCreateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        bns.a6.microui.api.pojo.bfqj.accountprofile.utility.AccountProfile accountProfile = new
                bns.a6.microui.api.pojo.bfqj.accountprofile.utility.AccountProfile();
        Response response = accountProfile.getResponse(requestBody, "POST", ServiceNames.ACCOUNTPROFILE.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Account Profile - Created Account profile, response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Account profile create response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Account profile create response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }

    @Given("^updated account profile for \"([^\"]*)\" \"([^\"]*)\"$")
    public void updatedAccountProfileFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getAccountProfileUpdate().generateAccountProfileUpdateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        bns.a6.microui.api.pojo.bfqj.accountprofile.utility.AccountProfile accountProfile = new
                bns.a6.microui.api.pojo.bfqj.accountprofile.utility.AccountProfile();
        Response response = accountProfile.getResponse(requestBody, "PUT", ServiceNames.ACCOUNTPROFILE.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Account Profile - Updated Account profile, response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Account profile update response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Account profile update response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }
}

