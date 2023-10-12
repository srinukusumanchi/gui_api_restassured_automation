/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-21
 * Created Time: 7:47 p.m.
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
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.ResultSet;

@QAFTestStepProvider
public class AccountMaintenance {

    private WebDriver driver = null;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;
    private final ScenarioContext scenarioContext;
    private File screenshot = null;

    public AccountMaintenance() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        driver = DriverManager.getDriver();
        screenshot = ReportPortal.getScreenshot();
    }


    @And("^maintained \"([^\"]*)\"$")
    public void maintained(String customerAccountMaintenanceServices) throws Throwable {
        if (driver.getPageSource().contains("Products and Services")) {
            pageObjectManager.getFooter().clickDone();
        }

        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        String cid = null;
        if (scenarioContext.getTableName().equalsIgnoreCase("Personal")) {
            cid = testData.getString("CIDPersonal");
        } else if (scenarioContext.getTableName().equalsIgnoreCase("NonPersonal")) {
            cid = testData.getString("CIDNonPersonal");
        }

        pageObjectManager.getCustomerSelection().
                checkCustomer(cid);


        pageObjectManager.getAccountMaintenance().clickAccountMaintenance();

        ReportPortal.stepInfoWithScreenshot("Customer Sales and Service --> Account Maintenance --> Customer To Account Relationship" );

        pageObjectManager.getAccountMaintenance().clickCustomerOrAccountMaintenance();
        if (customerAccountMaintenanceServices.equalsIgnoreCase("Customer To Account Relationship")) {
            pageObjectManager.getAccountMaintenance().clickCustomerToAccountRelationship();
        }
    }



}
