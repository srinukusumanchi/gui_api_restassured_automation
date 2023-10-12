/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-15
 * Created Time: 12:55 p.m.
 */

package stepDefinitions.web.cis;

import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.database.TestDataDB;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

@QAFTestStepProvider
public final class CustomerToAccountRelationship {

    private WebDriver driver = null;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;
    private final ScenarioContext scenarioContext;

    public CustomerToAccountRelationship() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        driver = DriverManager.getDriver();
    }


    @And("^located account with account number$")
    public void locateAccountWithAccountNumber() throws Exception {
        //  Read CUAC Rules data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getCISCentre().
                clickAccountProfileSetupMaintenance().
                selectProduct(testData.getString("Product")).
                enterCardOrAccountNumber(testData.getString("AccountNumber")).
                clickSearch();

    }

    @Then("^officer changed \"([^\"]*)\" primary relationship to \"([^\"]*)\"$")
    public void officerChangedPrimaryRelationshipTo(String existingRelationship, String newRelationShip) throws Exception {

        //  Read CUAC Rules data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));


        //        Verify linked account relationship is displaying correctly
        String relationShipExisting = pageObjectManager.getExistingCutomersLinkToAccount().
                getRelationShip(testData.getString("LinkedAccountCID"), existingRelationship);


        pageObjectManager.getExistingCutomersLinkToAccount().
                clickEdit().modifyRelationShip(testData.getString("LinkedAccountCID")
                        , newRelationShip);

        pageObjectManager.getAccountProfileMaintenaceFooter().
                clickUpdate();

        pageObjectManager.getAccountToSummaryFooter().clickDone();
    }

    @And("^officer verified relationship changed to \"([^\"]*)\"$")
    public void officerVerifiedRelationshipChangedTo(String arg0) {
        System.out.println();
    }



}
