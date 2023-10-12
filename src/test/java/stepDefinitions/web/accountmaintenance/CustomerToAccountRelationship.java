/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-21
 * Created Time: 8:35 p.m.
 */

package stepDefinitions.web.accountmaintenance;

import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import stepDefinitions.managers.StepDefinitionManager;

import java.sql.ResultSet;

@QAFTestStepProvider
public class CustomerToAccountRelationship {

    private WebDriver driver = null;
    private final PageObjectManager pageObjectManager;
    private final StepDefinitionManager stepDefinitionManager;
    private final ResultSet testData = null;
    private final ScenarioContext scenarioContext;

    public CustomerToAccountRelationship() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        stepDefinitionManager = StepDefinitionManager.getInstance();
        driver = DriverManager.getDriver();
    }


    @And("^deleted and added relationship$")
    public void deletedAndAddedRelationship() throws Throwable {

        //  Read Customer to account relationship data from database
        ResultSet testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("CUSTOMERTOACCOUNTRELATIONSHIP",
                                scenarioContext.getScenarioId()));

        String accountNumber = testData.getString("AccountNumber");

        String[] actions = testData.getString("Action").split("\\|");

        for (String action : actions) {
            if (action.equalsIgnoreCase("DELETE")) {
                pageObjectManager.getCustomerToAccountRelationship().selectAction(accountNumber,
                        action);
                pageObjectManager.getFooter().clickUpdate();

                String status = pageObjectManager.getCustomerToAccountRelationship().getStatus(accountNumber);
                if (status.equals("DELETE_SUCCESS")) {
                    ReportPortal.stepPassWithScreenshot("Status is as expected Actual Value:- " + status);
                } else {
                    ReportPortal.stepFailWithScreenshot("Status is not as expected Actual Value:- " + status +
                            " Expected Value:- 'DELETE_SUCCESS'");
                    Assertions.fail("Status is not as expected Actual Value:- " + status +
                            " Expected Value:- 'DELETE_SUCCESS'");
                }

                pageObjectManager.getFooter().clickDone();

            } else if (action.equalsIgnoreCase("ADD")) {
                //            Add account
                stepDefinitionManager.
                        getAccountMaintenance().
                        maintained("Customer To Account Relationship");

                ResultSet accountLocate = TestDataDB.getInstance().getData(
                        TestDataQueries.getInstance().
                                getTableName("AccountLocate",
                                        scenarioContext.getScenarioId()));

                pageObjectManager.getCustomerToAccountRelationship().clickLocate().
                        selectProduct(accountLocate.getString("Product")).
                        enterAccountOrCardNumber(accountLocate.getString("AccountNumber")).
                        clickFind();

                pageObjectManager.getFooter().clickDone();

                pageObjectManager.getCustomerToAccountRelationship().
                        selectRelationship(accountNumber, testData.getString("Relationship"))
                        .clickNo();

                String status = pageObjectManager.getCustomerToAccountRelationship().getStatus(accountNumber);
                if (status.equals("ADD_SUCCESS")) {
                    ReportPortal.stepPassWithScreenshot("Status is as expected Actual Value:- " + status);
                } else {
                    ReportPortal.stepFailWithScreenshot("Status is not as expected Actual Value:- " + status +
                            " Expected Value:- 'ADD_SUCCESS'");
                    Assertions.fail("Status is not as expected Actual Value:- " + status +
                            " Expected Value:- 'ADD_SUCCESS'");
                }

                pageObjectManager.getFooter().clickUpdate().clickDone();


            }


        }


    }


    @And("^changed relationship$")
    public void changedRelationship() throws Exception {
        //  Read Customer to account relationship data from database
        ResultSet testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("CUSTOMERTOACCOUNTRELATIONSHIP",
                                scenarioContext.getScenarioId()));

        String accountNumber = testData.getString("AccountNumber");
        pageObjectManager.getCustomerToAccountRelationship().selectAction(accountNumber,
                testData.getString("Action")).selectRelationship(accountNumber,
                testData.getString("Relationship"));

        if (testData.getString("WillThisAccountBeUsedByOrOnBehalfOfAThirdParty").equalsIgnoreCase("No")) {
            pageObjectManager.getCustomerToAccountRelationship().clickNo();
        } else if (testData.getString("WillThisAccountBeUsedByOrOnBehalfOfAThirdParty").equalsIgnoreCase("Yes")) {
            pageObjectManager.getCustomerToAccountRelationship().clickYes();
        }

        pageObjectManager.getFooter().clickUpdate();

        String status = pageObjectManager.getCustomerToAccountRelationship().getStatus(accountNumber);
        if (status.equals("CHANGE_SUCCESS")) {
            ReportPortal.stepPassWithScreenshot("Customer To Account Relationship Maintenance --> Details are updated and status is 'CHANGE_SUCCESS' " );
        } else {
            ReportPortal.stepFailWithScreenshot("Customer To Account Relationship Maintenance --> Status is not as expected Actual Value:- " + status +
            " Expected Value:- 'CHANGE_SUCCESS'" );
            Assertions.fail("Status is not as expected Actual Value:- " + status +
                    " Expected Value:- 'CHANGE_SUCCESS'");
        }
        pageObjectManager.getFooter().clickDone();

    }


}
