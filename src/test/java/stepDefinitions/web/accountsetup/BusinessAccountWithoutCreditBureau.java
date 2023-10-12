/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-06
 * Created Time: 10:12 p.m.
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
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

@QAFTestStepProvider
public class BusinessAccountWithoutCreditBureau {
    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private WebDriver driver = null;

    public BusinessAccountWithoutCreditBureau() {
        pageObjectManager = PageObjectManager.getInstance();
        this.scenarioContext = ScenarioContext.getInstance();
        driver = DriverManager.getDriver();
    }

    @And("^created bussiness account without credit bureau for non-personal customer$")
    public void createdBussinessAccountWithoutCreditBureauForNonPersonalCustomer() throws Exception {
//        pageObjectManager.getFooter().clickDone();

        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
//        Check Non-Personal customer
//        pageObjectManager.getCustomerSelection().checkCustomer(testData.getString("CIDNonPersonal"));
        pageObjectManager.getCustomerSelection().checkCustomer();
        //  Read Business account without credit bureau data from database
        ResultSet testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("BUSINESSACCOUNTWITHOUTCREDITBUREAU",
                                scenarioContext.getScenarioId()));

        pageObjectManager.getAccountSetup().clickAccountSetup().clickBusiness();;

        ReportPortal.stepInfoWithScreenshot("Customer Sales and Service-->Account Setup - Business Account Without Credit Bureau");
        pageObjectManager.getAccountSetup().clickBusinessAccountWithoutCreditBureau();

        createBusinessAccountWithoutCreditBureau(testData);




    }

    private void createBusinessAccountWithoutCreditBureau(ResultSet testData) throws Exception {

        pageObjectManager.getBusinessAccountOpenOwnership().selectSmallBusinessSegment(testData.getString("SmallBusinessSegment")).
                selectAccountType(testData.getString("AccountType"));

        if (testData.getString("IsTheBusinessOwnedByAnotherCompany").equalsIgnoreCase("Yes"))
            pageObjectManager.getBusinessAccountOpenOwnership().clickIsTheBusinessOwnedByAnotherCompanyYes();
        else if (testData.getString("IsTheBusinessOwnedByAnotherCompany").equalsIgnoreCase("No"))
            pageObjectManager.getBusinessAccountOpenOwnership().clickIsTheBusinessOwnedByAnotherCompanyNo();
        else{
            ReportPortal.stepFailWithScreenshot("Is the Business owned by another Company(s)? should be either 'Yes' or 'No' " +
                    " but not " + testData.getString("IsTheBusinessOwnedByAnotherCompany"));
            Assertions.fail("Is the Business owned by another Company(s)? should be either 'Yes' or 'No' " +
                    " but not " + testData.getString("IsTheBusinessOwnedByAnotherCompany"));
        }


        pageObjectManager.getBusinessAccountOpenOwnership().selectTitle(testData.getString("Title"));

        ReportPortal.stepInfoWithScreenshot("Page--> Business Account Open - Ownership");

        pageObjectManager.getBusinessAccountOpenOwnership().clickNext().clickNext();

        pageObjectManager.getBusinessAccountOpenOptions1().selectIntendedUseOfAccount(testData.getString("IntendedUseOfAccount"));

        if (testData.getString("WillYouBeReceivingInstructionsFromAthirdPartyOnHowToUseAccount").equalsIgnoreCase("Yes"))
            pageObjectManager.getBusinessAccountOpenOptions1().clickWillYouBeReceivingInstructionsFromAThirdPartyOnHowToUseTheAccountYes();
        else if (testData.getString("WillYouBeReceivingInstructionsFromAthirdPartyOnHowToUseAccount").equalsIgnoreCase("No"))
            pageObjectManager.getBusinessAccountOpenOptions1().clickWillYouBeReceivingInstructionsFromAThirdPartyOnHowToUseTheAccountNo();
        else
            Assertions.fail("Will you be receiving instructions from a third party on how to use the account? should be either 'Yes' or 'No' " +
                    " but not " + testData.getString("WillYouBeReceivingInstructionsFromAthirdPartyOnHowToUseAccount"));


//        Account Type - Account Plan/Basic Business Account
        if (testData.getString("AccountPlan").equalsIgnoreCase("Yes"))
            pageObjectManager.getBusinessAccountOpenOptions1().clickAccountPlan();
        else if (testData.getString("BasicBusinessAccount").equalsIgnoreCase("Yes"))
            pageObjectManager.getBusinessAccountOpenOptions1().clickBasicBusinessAccount();
        if (testData.getString("ChangeStandaloneElectroincBankingFee").equalsIgnoreCase("Yes"))
            pageObjectManager.getBusinessAccountOpenOptions1().clickChargeStandaloneElectronicBankingFeeYes();
        else if (testData.getString("ChangeStandaloneElectroincBankingFee").equalsIgnoreCase("No"))
            pageObjectManager.getBusinessAccountOpenOptions1().clickChargeStandaloneElectronicBankingFeeNo();
        else{
            ReportPortal.stepFailWithScreenshot("Charge Standalone Electronic Banking Fee should be either 'Yes' or 'No' " +
                    " but not " + testData.getString("ChangeStandaloneElectroincBankingFee"));
            Assertions.fail("Charge Standalone Electronic Banking Fee should be either 'Yes' or 'No' " +
                    " but not " + testData.getString("ChangeStandaloneElectroincBankingFee"));
        }


        ReportPortal.stepInfoWithScreenshot("Page--> Business Account Open - Options I");

        pageObjectManager.getBusinessAccountOpenOptions1().clickNext();

//        Get Account number from Tore
        String accountNumber = getDDAAccountNumber().replaceAll("\\s+", "");
        pageObjectManager.getBusinessAccountOpenOptions2()
                .switchToBusinessAccountOpenOptionsIIPage()
                .enterAccountNumber(accountNumber)
                .selectAccountRelationship(testData.getString("AccountRelationship"))
                .enterShortName(testData.getString("ShortName"));

        ReportPortal.stepInfoWithScreenshot("Page--> Business Account Open - Options II");
        pageObjectManager.getBusinessAccountOpenOptions2().clickNext();

        String businessAccountNumber = pageObjectManager.getBusinessAccountOpenConfirmation().
                getBusinessAccountNumber();

        // Update Transit from Non-Personal table to Tore table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("BUSINESSACCOUNTWITHOUTCREDITBUREAU", scenarioContext.getScenarioId(),
                                "AccountNumber", businessAccountNumber));

        ReportPortal.stepInfoWithScreenshot("Page--> Business Account Open Confirmation");

        pageObjectManager.getBusinessAccountOpenConfirmation().clickDone();

        if (pageObjectManager.getSalesAssignment().getPageTitle().contains("Sales Assignment")) {
            pageObjectManager.getSalesAssignment().clickOk();
        }
        pageObjectManager.getBusinessAccountOpenConfirmation().clickDone();
    }


    protected String getDDAAccountNumber() throws Exception {
        pageObjectManager.getDDAAccountNumber().launchTore().clickRetrieveAccountNumbers()
                .clickDDAAccountNumbers();

        //  Read Tore data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        // Update Transit from Non-Personal table to Tore table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("Tore", scenarioContext.getScenarioId(),
                                "Transit", testData.getString("Transit")));

        //  Read Tore data from database
        ResultSet toreTestData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("Tore",
                                scenarioContext.getScenarioId()));

        pageObjectManager.getDDAAccountNumber().
                selectEnvironment(toreTestData.getString("Environment")).
                selectAccountType(toreTestData.getString("AccountType")).
                selectLanguage(toreTestData.getString("Language")).
                selectTransit(toreTestData.getString("Transit"))
                .clickRetrieve();
        String accountNumber = pageObjectManager.getDDAAccountNumber().getAccountNumber();

        // Insert Account number into Tore table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("Tore", scenarioContext.getScenarioId(),
                                "AccountNumber", accountNumber));

        return accountNumber;
    }



}
