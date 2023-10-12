/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-11
 * Created Time: 12:40 p.m.
 */

package stepDefinitions.web.accountsetup;

import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import stepDefinitions.managers.StepDefinitionManager;

import java.sql.ResultSet;

@QAFTestStepProvider
public class OnlineLoanAccount {

    private final PageObjectManager pageObjectManager;
    private final StepDefinitionManager stepDefinitionManager;
    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private WebDriver driver = null;


    public OnlineLoanAccount() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        stepDefinitionManager = StepDefinitionManager.getInstance();
        driver = DriverManager.getDriver();
    }

    @And("^created online loan account to customer$")
    public void createdOnlineLoanAccountToCustomer() throws Exception {
        pageObjectManager.getFooter().clickDone();

        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
//        Check Non-Personal customer
        pageObjectManager.getCustomerSelection().checkCustomer(testData.getString("CIDNonPersonal"));

        pageObjectManager.getAccountSetup().clickAccountSetup().clickOnlineLoanAccountToCustomer();
        ReportPortal.stepInfoWithScreenshot("Customer Sales and Service-->Account Setup - Online loan account to customer");

        createOnlineLoanAccountToCustomer(testData);

    }


    private void createOnlineLoanAccountToCustomer(ResultSet testData) throws Exception {
//        Get Account number from Tore
        String accountNumber = stepDefinitionManager.getBusinessAccountWithoutCreditBureau().
                getDDAAccountNumber().
                replaceAll("\\s+", "");
        pageObjectManager.getAccountLink().switchToAccountLinkPage()
                .enterAccountNumber(accountNumber).
                clickDone();

        //            Update Account Number in Online loan account database table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("ONLINELOANACCOUNT", scenarioContext.getScenarioId(),
                                "AccountNumber", accountNumber));

        //            Update Account number in Non-Personal database table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "AccountNumber", accountNumber));

    }



}
