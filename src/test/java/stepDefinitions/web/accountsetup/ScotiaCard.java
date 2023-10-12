/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-10
 * Created Time: 9:30 p.m.
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

import java.sql.ResultSet;

@QAFTestStepProvider
public class ScotiaCard {

    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private WebDriver driver = null;

    public ScotiaCard() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        driver = DriverManager.getDriver();
    }

    private void createScotiaCard(ResultSet testData) throws Exception {
        String accountNumber = getScotiaAccountNumber();


        pageObjectManager.getAA3ASetupNewScotiaCard().switchToAA3aSetupNewScotiaCard().
                enterScotiaCardNumber(accountNumber);
        ReportPortal.stepInfoWithScreenshot("AA3a - Set-up new ScotiaCard- EJ --> Set-up New ScotiaCard");
        pageObjectManager.getAA3ASetupNewScotiaCard().clickNextButton();

        while (pageObjectManager.getAA3ASetupNewScotiaCard().getPageTitle().contains("AA3a - Établissement de la nouvelle Carte Scotia")) {
            if (pageObjectManager.getAA3ASetupNewScotiaCard().getErrorMessage().contains("Carte en utilisation. SVP choisir un autre numéro.")) {
                accountNumber = getScotiaAccountNumber();
                pageObjectManager.getAA3ASetupNewScotiaCard().switchToAA3aSetupNewScotiaCard().
                        enterScotiaCardNumber(accountNumber);
                pageObjectManager.getAA3ASetupNewScotiaCard().clickNextButton();
            } else {
                break;
            }
        }
        pageObjectManager.getAA3AAccountAccessChanges().selectContactlessFeature(testData.getString("ContactlessFeature")).
                enterMothersMaidenName(testData.getString("MothersMaidenName"));
        ReportPortal.stepInfoWithScreenshot("AA3a - Account Access Changes - EJ --> Set-up New ScotiaCard");

        String scotiaCardNumber = pageObjectManager.getAA3AAccountAccessChanges().getScotiaCardNumber();

        // Update Scotia card number in scotiacard table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("SCOTIACARD", scenarioContext.getScenarioId(),
                                "ScotiaCardNumber", scotiaCardNumber));

        pageObjectManager.getAA3AAccountAccessChanges().clickSubmit().clickDone();

        if (pageObjectManager.getPrintChoices().getPageTitle().contains("Choix D'Impression")) {
            pageObjectManager.getPrintChoices().clickCancel();
        }

    }

    @And("^created scotia card for personal customer$")
    public void createdScotiaCardForPersonalCustomer() throws Exception {
        //  Read Personal data from database
     /*   testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));*/
//        String cid = testData.getString("CIDPersonal");
//        pageObjectManager.getCustomerSelection().checkCustomer(cid);
        pageObjectManager.getCustomerSelection().checkCustomer();
        //  Read Day to Day to banking data from database
        ResultSet testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("SCOTIACARD",
                                scenarioContext.getScenarioId()));
        pageObjectManager.getAccountSetup().clickAccountSetup();
        ReportPortal.stepInfoWithScreenshot("Customer Sales and Service-->Account Setup - Others --> ScotiaCard");
        pageObjectManager.getAccountSetup().clickScotiaCard();
        createScotiaCard(testData);
    }


    private String getScotiaAccountNumber() throws Exception {
        pageObjectManager.getScotiaCardAccountNumber().launchTore().clickRetrieveAccountNumbers()
                .clickScotiaCardAccountNumbers();

        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //  Read Tore data from database
        ResultSet toreTestData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("Tore",
                                scenarioContext.getScenarioId()));

        pageObjectManager.getScotiaCardAccountNumber().
                selectEnvironment(toreTestData.getString("Environment")).
                selectLanguage(toreTestData.getString("Language")).
                selectCardType(toreTestData.getString("CardType"))
                .clickRetrieve().clickSubmit();

        pageObjectManager.getScotiaCardAccountNumber().clickRetrieve();
        String scotiacard = pageObjectManager.getScotiaCardAccountNumber().getAccountNumber();
//        pageObjectManager.getScotiaCardAccountNumber().closeCurrentWindow();
        return scotiacard;
    }

    @And("^update account title for scotia card$")
    public void updateAccountTitleForScotiaCard() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("SCOTIACARD",
                                scenarioContext.getScenarioId()));
        pageObjectManager.getProductsAndServicesPersonal().
                clickProductAndServices(testData.getString("ScotiaCardNumber"));

        pageObjectManager.getAA1AccountAdministration().clickSalesAndServices();

        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        String cid = testData.getString("CIDPersonal");
        pageObjectManager.getCustomerSelection().checkCustomer(cid);
        pageObjectManager.getAccountMaintenance().clickAccountMaintenance().
                clickAccountMaintenance().clickAccountTitle();

    }


}
