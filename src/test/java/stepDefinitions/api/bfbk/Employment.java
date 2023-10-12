/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-12
 * Created Time: 12:33 p.m.
 */

package stepDefinitions.api.bfbk;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import stepDefinitions.managers.PageObjectManager;

import java.sql.ResultSet;

public class Employment {


    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private final PageObjectManager pageObjectManager;

    public Employment() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
    }


    @Given("^updated customer employment details for \"([^\"]*)\" \"([^\"]*)\"$")
    public void updatedCustomerEmploymentDetailsFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getEmploymentUpdate().generateEmploymentUpdateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        bns.a6.microui.api.pojo.bfbk.employment.utility.Employment employment = new bns.a6.microui.api.pojo.bfbk.employment.utility.Employment();
        Response response = employment.getResponse(requestBody, "PUT", ServiceNames.EMPLOYMENT.name());

//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Employment - Update Contact request response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Employment update request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Employment update request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200");
        }
    }


}
