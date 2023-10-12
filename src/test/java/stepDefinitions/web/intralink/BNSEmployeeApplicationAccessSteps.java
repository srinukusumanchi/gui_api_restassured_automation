/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-11
 * Created Time: 11:38 a.m.
 */

package stepDefinitions.web.intralink;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.driver.Driver;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.ReadPropertyFile;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.ResultSet;

@QAFTestStepProvider
public final class BNSEmployeeApplicationAccessSteps {

    private WebDriver driver = null;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;
    private final ScenarioContext scenarioContext;
    private File screenshot = null;

    public BNSEmployeeApplicationAccessSteps() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        Driver.initDriver();
        driver = DriverManager.getDriver();
        screenshot = ReportPortal.getScreenshot();
    }

    @Given("^officer login into intralink \"([^\"]*)\" \"([^\"]*)\"$")
    public void officerLoginIntoIntralink(String scenarioId, String testDataDB) throws Exception {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        String env = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(), "environment");

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("LOGIN", env));

//        Launch Intralink
        driver.get(testData.getString("URL"));
        driver.manage().window().maximize();

        pageObjectManager.getBnsEmployeeLogin().
                enterScotiaId(testData.getString("UserName")).
                enterPassword(testData.getString("Password"));

        ReportPortal.stepInfoWithScreenshot("Page--> BNS Employee Login");

        pageObjectManager.getBnsEmployeeLogin().clickLogOn();

        String environment = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(), "environment")
                .toLowerCase();

        pageObjectManager.getOfficerContext().
                selectEnvironment(environment);
    }


    @And("^accessed \"([^\"]*)\" application$")
    public void accessedApplication(String linkName) throws Throwable {

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getOfficerContext().selectLanguage(testData.getString("Language"));

        ReportPortal.stepInfoWithScreenshot("Page--> Officer Context");

        pageObjectManager.getOfficerContext().
                clickTransit(testData.getString("Transit")).
                clickSendAnyway().
                clickLinksTab();

        pageObjectManager.getIntralinkHomePage().waitForPageLoad();
        ReportPortal.stepInfoWithScreenshot("Page--> Intralink Home");

        if (linkName.equalsIgnoreCase("CIS Centre")) {
            pageObjectManager.getIntralinkHomePage().clickCisCentre();
        } else if (linkName.equalsIgnoreCase("Customer Sales & Service (New)")) {
            pageObjectManager.getIntralinkHomePage().clickCustomerSalesAndServicesNew();
        } else if (linkName.equalsIgnoreCase("Customer Sales & Service")) {
            pageObjectManager.getIntralinkHomePage().clickCustomerSalesAndServicesLegacy();
        } else if (linkName.equalsIgnoreCase("Access by Account")) {
            pageObjectManager.getIntralinkHomePage().clickAccessByAccount();
        }

    }

    @And("^accessed Customer Sales and Services \\(New\\) application$")
    public void accessedCustomerSalesAndServicesNewApplication() {
        ReportPortal.stepInfoWithScreenshot("Page--> Intralink Home");
        pageObjectManager.getIntralinkHomePage().clickCustomerSalesAndServicesNew();
    }

    @Then("^signed-off from intralink$")
    public void signedOffFromIntralink() {
        pageObjectManager.getIntralinkHeader().clickIntralinkImage().clickSignOff();
        ReportPortal.stepInfoWithScreenshot("Signed-Off");
//        Driver.quitDriver();
    }

    @And("^navigated back to intralink home$")
    public void navigatedBackToIntralinkHome() {
        pageObjectManager.getIntralinkHeaderLegacy().clickIntralinkImage();
    }



}
