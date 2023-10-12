/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-19
 * Created Time: 10:33 a.m.
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
import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

@QAFTestStepProvider
public class FatcaOrCrs {

    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private WebDriver driver = null;

    public FatcaOrCrs() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        driver = DriverManager.getDriver();
    }

    @And("^launched \"([^\"]*)\" from tax information$")
    public void launchedFromTaxInformation(String crsOrFatca) {
        if (crsOrFatca.equalsIgnoreCase("FATCA")) {
            pageObjectManager.getProductsAndServicesPersonal().clickTaxInformation();
            ReportPortal.stepInfoWithScreenshot("Tax Information--> FATCA");
            pageObjectManager.getFATCA().clickFATCA();
        } else if (crsOrFatca.equalsIgnoreCase("CRS")) {
            pageObjectManager.getProductsAndServicesPersonal().clickTaxInformation();
            ReportPortal.stepInfoWithScreenshot("Tax Information--> CRS");
            pageObjectManager.getFATCA().clickCRS();
        }

    }

    @Then("^verified documentation status changed complete$")
    public void verifiedDocumentationStatusChangedComplete() throws Exception {
        //  FATCA Information from personal customer test data
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        pageObjectManager.getFATCA().clickUpdate().clickUSIndicator()
                .checkManuallyIdentifiedForUSIndicator(testData.getString("ManuallyIdentified"))
                .clickFATCADocumentation();

        if (testData.getString("AreYouATaxResidentOrCitizenOfTheUnitedStates").
                equalsIgnoreCase("Yes")) {
            pageObjectManager.getFATCA().selectYes();
        } else if (testData.getString("AreYouATaxResidentOrCitizenOfTheUnitedStates").
                equalsIgnoreCase("No")) {
            pageObjectManager.getFATCA().selectNo();
        } else if (testData.getString("AreYouATaxResidentOrCitizenOfTheUnitedStates")
                .equalsIgnoreCase("Unknown")) {
            pageObjectManager.getFATCA().selectUnknown();
        } else {
            ReportPortal.stepFailWithScreenshot("Are you a tax resident or citizen of the United States? should be" +
                    " either 'Yes' or 'No' or 'Unknown' but not" +
                    testData.getString("AreYouATaxResidentOrCitizenOfTheUnitedStates"));

            ReportPortal.stepFailWithScreenshot("Are you a tax resident or citizen of the United States? should be" +
                    " either 'Yes' or 'No' or 'Unknown' but not" +
                    testData.getString("AreYouATaxResidentOrCitizenOfTheUnitedStates"));

            Assertions.fail("Are you a tax resident or citizen of the United States? should be" +
                    " either 'Yes' or 'No' or 'Unknown' but not" +
                    testData.getString("AreYouATaxResidentOrCitizenOfTheUnitedStates"));
        }

        pageObjectManager.getFATCA().selectW9(testData.getString("W9")).
                enterTINorSSN(testData.getString("TinOrSsn"));

        pageObjectManager.getFooter().clickUpdate();

//        verify documenation status
        if (pageObjectManager.getFATCA().getDocumentationStatus().equals("Complete")){
            ReportPortal.stepPassWithScreenshot("Documenation status is as expected, Value:- "+
                    pageObjectManager.getFATCA().getDocumentationStatus());
        }else{
            ReportPortal.stepFailWithScreenshot("Documenation status should be 'Complete' but not "+
                    pageObjectManager.getFATCA().getDocumentationStatus());

            Assertions.fail("Documenation status should be 'Complete' but not "+
                    pageObjectManager.getFATCA().getDocumentationStatus());
        }

        pageObjectManager.getFooter().clickDone();
    }
}
