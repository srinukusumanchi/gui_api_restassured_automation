/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-22
 * Created Time: 6:31 p.m.
 */

package stepDefinitions.web.a6;

import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

@QAFTestStepProvider
public class CustomerLocateOrSetup {

    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private WebDriver driver = null;
    public CustomerLocateOrSetup() {
        pageObjectManager = PageObjectManager.getInstance();
        this.scenarioContext = ScenarioContext.getInstance();
        driver = DriverManager.getDriver();
    }


    @And("^located customer with cid in A(\\d+)$")
    public void locatedCustomerWithCidInA() throws Exception {

        //  Read Personal/NonPersonl data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        pageObjectManager.getCS2CustomerLocateOrSetup().enterCIDOrPhone("CID",testData.getString("CIDPersonal"))
                .clickFind();

        ReportPortal.stepInfoWithScreenshot("Page--> A6-> CS2- Customer Locate or Setup");
    }



}
