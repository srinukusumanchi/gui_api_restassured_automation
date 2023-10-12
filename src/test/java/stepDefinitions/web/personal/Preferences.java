/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-28
 * Created Time: 3:29 p.m.
 */

package stepDefinitions.web.personal;

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
public class Preferences {

    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private WebDriver driver = null;

    public Preferences() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        driver = DriverManager.getDriver();
    }

    @And("^launched marketing preferences page$")
    public void launchedMarketingPreferencesPage() {
        pageObjectManager.getProductsAndServicesPersonal().clickPreferences().clickMarketingPreferences();

        ReportPortal.stepInfoWithScreenshot("Preferences -->  Marketing Preferences Link");
    }

    @And("^launched preferences page$")
    public void launchedPreferencesPage() {
        pageObjectManager.getProductsAndServicesPersonal().clickPreferences();
    }

    @And("^updated account statement rko preference$")
    public void updatedAccountStatementRkoPreference() throws Exception {
        pageObjectManager.getPreferences().clickUpdate();

        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //  Read Preferences data from database
        ResultSet preferencesTestData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("PREFERENCES",
                                testData.getString("ReferenceScenarioId")));

        String[] accountNumbers = preferencesTestData.getString("AccountNumber").split("\\|");
        String[] yesOrNo = preferencesTestData.getString("PaperlessRecordKeepingOption").split("\\|");
        for (int rkos = 0; rkos < accountNumbers.length; rkos++) {
            pageObjectManager.getPreferences().
                    updatePaperlessRecordKeepingOption(accountNumbers[rkos],
                            yesOrNo[rkos]);
        }

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getFooter().clickDone();
    }

    @And("^updated account statement rko preference from 'Yes-No' or 'No-Yes'$")
    public void updatedAccountStatementRkoPreferenceFromYesNoOrNoYes() {
        pageObjectManager.getPreferences().clickUpdate();
        ReportPortal.stepInfoWithScreenshot("Preferences --> Before Update");
        pageObjectManager.getPreferences().
                updatePaperlessRecordKeepingOptionYesToNoAndNoToYes();
        ReportPortal.stepInfoWithScreenshot("Preferences --> After Update");
        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getFooter().clickDone();
    }
}
