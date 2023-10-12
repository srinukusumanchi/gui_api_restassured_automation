/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 5:04 p.m.
 */

package stepDefinitions.api.bfbk;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.customerprofile.utility.CustomerProfile;
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
public class ContactMethod {

    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private final PageObjectManager pageObjectManager;

    public ContactMethod() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
    }

    @Given("^updated customer contact method details for \"([^\"]*)\" \"([^\"]*)\"$")
    public void updatedCustomerContactMethodDetailsFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Generate Request body
        String requestBody = pageObjectManager.getCustomerProfileContactMethodUpdate().generateCustomerContactUpdateRequest(testData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);
        // Get Customer profile creation response
        CustomerProfile customerProfile = new CustomerProfile();
        Response response = customerProfile.getResponse(requestBody, "PUT", "UPDATE", ServiceNames.CONTACTMETHOD.name());

//        Verifies response status code
        if (response.getStatusCode() == 204) {
            ReportPortal.stepPassWithoutScreenshot("Customer Profile - Update Contact request response code is as expected - 204");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 204");
        }
    }

}
