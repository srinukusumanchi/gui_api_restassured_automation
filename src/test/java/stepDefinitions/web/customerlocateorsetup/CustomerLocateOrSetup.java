/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-21
 * Created Time: 8:30 p.m.
 */

package stepDefinitions.web.customerlocateorsetup;

import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.driver.Driver;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

@QAFTestStepProvider
public class CustomerLocateOrSetup {


    private WebDriver driver = null;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;
    private final ScenarioContext scenarioContext;

    public CustomerLocateOrSetup() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        Driver.initDriver();
        driver = DriverManager.getDriver();
    }



    @And("^located \"([^\"]*)\" customer with cid$")
    public void locatedCustomerWithCid(String customerType) throws Throwable {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        if (customerType.equalsIgnoreCase("Personal")) {
            pageObjectManager.getScotiaCardOrAccount().
                    enterCID(testData.getString("CIDPersonal")).
                    clickFind();
            ReportPortal.stepInfoWithScreenshot("Customer Locate/ Setup--> ScotiaCard or Account--> Search by Personal CID");
        }else if(customerType.equalsIgnoreCase("NonPersonal")){
            pageObjectManager.getScotiaCardOrAccount().
                    enterCID(testData.getString("CIDNonPersonal")).
                    clickFind();
            ReportPortal.stepInfoWithScreenshot("Customer Locate/ Setup--> ScotiaCard or Account--> Search by Non-Personal CID");
        }else{
            ReportPortal.stepFailWithScreenshot("Customer Type should be either 'Personal' or 'NonPersonal'" +
                    " but it is "+customerType);
            Assertions.fail("Customer Type should be either 'Personal' or 'NonPersonal'" +
                    " but it is "+customerType);
        }

    }


}
