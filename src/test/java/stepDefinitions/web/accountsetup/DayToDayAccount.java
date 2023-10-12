/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-06
 * Created Time: 9:40 a.m.
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
public class DayToDayAccount {
    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private WebDriver driver = null;

    public DayToDayAccount() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        driver = DriverManager.getDriver();
    }


    private void createSavingsAccount(ResultSet testData) throws Exception {
//        Will this account be used by or on behalf of a third party?
        if (testData.getString("ThirdPartyAccount").equalsIgnoreCase("Yes")) {
            pageObjectManager.getDayToDayHighwayOwnership().clickThirdPartyYes();
        } else if (testData.getString("ThirdPartyAccount").equalsIgnoreCase("No")) {
            pageObjectManager.getDayToDayHighwayOwnership().clickThirdPartyNo();
        } else {
            ReportPortal.stepFailWithScreenshot("Will this account be used by or on behalf of a third party? should be either" +
                    " Yes or No instead of " + testData.getString("ThirdPartyAccount"));
            Assertions.fail("Will this account be used by or on behalf of a third party? should be either" +
                    " Yes or No instead of " + testData.getString("ThirdPartyAccount"));
        }

//        Account Type
        pageObjectManager.getDayToDayHighwayOwnership()
                .selectAccountType(testData.getString("AccountType"))
                .closeIsThisChequingAccountRightForYou(testData.getString("AccountType"));
/*                .switchToDayToDayHighwayOptionsPage();
.closeEmptyWindow("Day-to-Day Highway - Ownership|" +
                "La voie des Opérations Bancaires Courantes - Propriété")*/
//        Is this the recommended solution?
        if (testData.getString("IsThisTheRecommendedSolution").equalsIgnoreCase("Yes")) {
            pageObjectManager.getDayToDayHighwayOwnership().clickIsThisTheRecommendedSolutionYes();
        } else if (testData.getString("IsThisTheRecommendedSolution").equalsIgnoreCase("No")) {
            pageObjectManager.getDayToDayHighwayOwnership().clickIsThisTheRecommendedSolutionNo();
        }

        if (testData.getString("EstateAccount").equalsIgnoreCase("Yes"))
            pageObjectManager.getDayToDayHighwayOwnership().clickEstate();

        if (testData.getString("TrustAccount").equalsIgnoreCase("Yes"))
            pageObjectManager.getDayToDayHighwayOwnership().clickTrustAccount();

        pageObjectManager.getDayToDayHighwayOwnership().
                selectRelationship(testData.getString("Relationship"));

        pageObjectManager.getDayToDayHighwayOwnership().clickKYCRefresh();

        if (pageObjectManager.getDayToDayHighwayOwnership().isAlertPresent()) {
            pageObjectManager.getDayToDayHighwayOwnership().acceptAlert();
        }

        if (pageObjectManager.getReviewProfile().getPageTitle().equals("KYC Refresh")) {
            // Review Profile
            pageObjectManager.getReviewProfile().waitForPageLoad();
            ReportPortal.stepInfoWithScreenshot("Page--> Customer Information Review");
            pageObjectManager.getFooter().clickContinue();

            // Review Residential Address
            pageObjectManager.getReviewResidentialAddress().waitForPageLoad();
            ReportPortal.stepInfoWithScreenshot("Page--> Review Residence Address");
            pageObjectManager.getFooter().clickContinue();

            // Review Employment Information
            pageObjectManager.getReviewEmploymentInformation().waitForPageLoad();
            ReportPortal.stepInfoWithScreenshot("Page--> Review Employment Address");
            pageObjectManager.getFooter().clickContinue();

            // Review Account Intended Use Information
            pageObjectManager.getReviewAccountIntendedUseInformation().waitForPageLoad();
            ReportPortal.stepInfoWithScreenshot("Page--> Review Account Intended use information");
            pageObjectManager.getFooter().clickFinish();
            pageObjectManager.getPopUps().clickOk();

            if (pageObjectManager.getDayToDayHighwayOwnership().isAlertPresent()) {
                pageObjectManager.getDayToDayHighwayOwnership().acceptAlert();
            }
        }

        pageObjectManager.getDayToDayHighwayOwnership().
                selectOwnershipSignatures(testData.getString("OwnershipSignatures"));
        ReportPortal.stepInfoWithScreenshot("Page--> Day-to-Day Highway Account Ownership");
        pageObjectManager.getDayToDayHighwayOwnership().clickContinue();

        if (pageObjectManager.getDayToDayHighwayOwnership().isAlertPresent()) {
            pageObjectManager.getDayToDayHighwayOwnership().acceptAlert();
        }


        if (pageObjectManager.getHB100CreditBureauRequest().getPageTitle().contains("HB100 - Demande du bureau de crédit") ||
                pageObjectManager.getHB100CreditBureauRequest().getPageTitle().contains("HB100 - Credit Bureau Request")) {
            //  Read Login data from database
           /* ResultSet personalData = TestDataDB.getInstance().getData(
                    TestDataQueries.getInstance().
                            getTableName(scenarioContext.getTableName(),
                                    scenarioContext.getScenarioId()));*/

          /*  //        Customer Name
            String title = personalData.getString("Title");
            String firstName = personalData.getString("FirstName");
            String initials = personalData.getString("Initials");
            String lastName = personalData.getString("LastName");
            String suffix = personalData.getString("Suffix");
            String compositName = (title + " " + firstName + " " + initials + " " + lastName + " " + suffix).toUpperCase();

            pageObjectManager.getHB100CreditBureauRequest().
                    selectRelationship(compositName, testData.getString("RelationshipCreditBureau")).
                    selectCreditBureau(compositName, testData.getString("CreditBureau")).
                    selectSIN(compositName, testData.getString("SIN")).
                    clickContinue();*/

            pageObjectManager.getHB100CreditBureauRequest().selectRelationship(testData.getString("RelationshipCreditBureau")).
                    selectCreditBureau(testData.getString("CreditBureau")).
                    selectSIN(testData.getString("SIN")).
                    clickContinue();

        }

//Account Number, Account Title-1, Short Name is given based on values present in application
        if (pageObjectManager.getDayToDayHighwayOptions().getAccountNumber().
                equals("Starter Kit") ||
                pageObjectManager.getDayToDayHighwayOptions().getAccountNumber().
                        equals("Trousse de départ")) {
            String accountNumber = getSavingsAccountNumber();
            pageObjectManager.getDayToDayHighwayOptions().
                    switchToDayToDayHighwayOptionsPage().
                    enterAccountNumber(accountNumber);
        }

        //  Read Day to Day to banking data from database
        ResultSet personalTestData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));


        // PIN field displays based on Account Type
        if (testData.getString("AccountType").equals("Agri-investissement")) {
            pageObjectManager.getDayToDayHighwayOptions().enterParticipantPin(personalTestData.getString("Transit"));
        }


        pageObjectManager.getDayToDayHighwayOptions().enterAccountTitle1(testData.getString("AccountTitle1"))
                .enterShortName(testData.getString("ShortName"));

//        Record keeping
        if (testData.getString("RecordKeeping").
                equalsIgnoreCase("Paperless")) {
            pageObjectManager.getDayToDayHighwayOptions().clickPaperless();
        } else if (testData.getString("RecordKeeping").
                equalsIgnoreCase("Statement")) {
            pageObjectManager.getDayToDayHighwayOptions().clickStatement();
        } else if (testData.getString("RecordKeeping").
                equalsIgnoreCase("Statement with Cheque Image Return")) {
            pageObjectManager.getDayToDayHighwayOptions().clickStatementwithChequeImageReturn();
        } else if (testData.getString("RecordKeeping").
                equalsIgnoreCase("Braille Statement")) {
            pageObjectManager.getDayToDayHighwayOptions().clickBrailleStatement();
        } else if (testData.getString("RecordKeeping").
                equalsIgnoreCase("Braille Statement with Cheque Image Return")) {
            pageObjectManager.getDayToDayHighwayOptions().clickBrailleStatementWithChequeImageReturn();
        }

//        Interest Arrangement
        if (!testData.getString("InterestArrangement").equals("")) {
            pageObjectManager.getDayToDayHighwayOptions().selectInterestArrangement(testData.getString("InterestArrangement"));
        }

        //        Intended Use
        pageObjectManager.getDayToDayHighwayOptions().selectIntendedUse(testData.getString("IntendedUse"));

//        Intended Use
        pageObjectManager.getDayToDayHighwayOptions().selectIntendedUse(testData.getString("IntendedUse"))
//        Reason for Account Open
                .selectReasonForAccountOpen(testData.getString("ReasonForAccountOpen")).
//                Source of Funds
        selectSourceOfFunds(testData.getString("SourceOfFunds"));
//                ScotiaCard Account Access
//                selectScotiaCardAccountAccess(testData.getString("ScotiaCardAccountAccess"));

//        Apply New Account Message
        if (testData.getString("ApplyNewAccountMessages").
                equalsIgnoreCase("No")) {
            pageObjectManager.getDayToDayHighwayOptions().clickApplyNewAccountMessage();
        }

//        Additional Services
        if (testData.getString("AdditionalServices").
                equalsIgnoreCase("Yes")) {
            pageObjectManager.getDayToDayHighwayOptions().clickAdditionalServices();
        }

        if (testData.getString("PayrollDirectDepositInstructions").
                equalsIgnoreCase("Yes")) {
            pageObjectManager.getDayToDayHighwayOptions().clickPayrollDirectDepositInstructions();
        }

        if (testData.getString("CompanyPreAuthorizedPaymentInstructions").
                equalsIgnoreCase("Yes")) {
            pageObjectManager.getDayToDayHighwayOptions().clickCompanyPreAuthorizedPaymentInstructions();
        }

        pageObjectManager.getDayToDayHighwayOptions().enterInitialDeposit(testData.getString("InitialDeposit"));
        ReportPortal.stepInfoWithScreenshot("Page--> Day-to-Day Highway Account Options");
        pageObjectManager.getDayToDayHighwayOptions().clickDone().acceptAlert();

        if (pageObjectManager.getDayToDayHighwayAccepted().isAlertPresent()) {
            pageObjectManager.getDayToDayHighwayAccepted().acceptAlert();
        }
        ReportPortal.stepInfoWithScreenshot("Page--> Day-to-Day Highway Account Setup Accepted");
        String accountNumber = pageObjectManager.getDayToDayHighwayAccepted().getAccountNumber();
        // Update Transit from Non-Personal table to Tore table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("DAYTODAYBANKING", scenarioContext.getScenarioId(),
                                "AccountNumber", accountNumber));
        ReportPortal.stepPass("Day to Day account created successfully, Account Number:- " + accountNumber);

        if (!(testData.getString("AccountType").equals("Agri-investissement"))) {
            pageObjectManager.getDayToDayHighwayAccepted().clickPrintTermsAndConditions();
            pageObjectManager.getFormisnotSecure().switchToFormIsNotSecurePage().clickSendAnyway();
//            pageObjectManager.getPage1_concentToReceiptOfElectronicDocuments().clickClose();
        }

        pageObjectManager.getDayToDayHighwayAccepted().switchToDayToDayHighwayAccepted().clickPrint().clickReturn();

        pageObjectManager.getDayToDayHighwayAccepted().clickDone();
        if (pageObjectManager.getSalesAttribution().getPageTitle().contains("Attribution des ventes")
                || pageObjectManager.getSalesAttribution().getPageTitle().contains("Sales Assignment")) {
            pageObjectManager.getSalesAttribution().clickOk();
        }

    }

    @And("^created savings account for personal customer$")
    public void createdSavingsAccountForPersonalCustomer() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

//        String cid = testData.getString("CIDPersonal").replaceAll("\\s+", "");
//        pageObjectManager.getCustomerSelection().checkCustomer(cid);
        pageObjectManager.getCustomerSelection().checkCustomer();
        //  Read Day to Day to banking data from database
        ResultSet testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("DAYTODAYBANKING",
                                scenarioContext.getScenarioId()));
        pageObjectManager.getAccountSetup().clickAccountSetup();
        ReportPortal.stepInfoWithScreenshot("Customer Sales and Service --> Account Setup --> Day-to-Day Bank Account");
        pageObjectManager.getAccountSetup().clickDayToDayBankAccount();
        createSavingsAccount(testData);
    }

    private String getSavingsAccountNumber() throws Exception {
        pageObjectManager.getSavingsAccountNumber().launchTore().clickRetrieveAccountNumbers()
                .clickSavingsAccountNumbers();

        //  Read Tore data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //  Update Transit from Personal database to tore database
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable("Tore", scenarioContext.getScenarioId(),
                                "Transit", testData.getString("Transit")));

        //  Read Tore data from database
        ResultSet toreTestData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName("Tore",
                                scenarioContext.getScenarioId()));

        pageObjectManager.getSavingsAccountNumber().
                selectEnvironment(toreTestData.getString("Environment")).
                selectAccountType(toreTestData.getString("AccountType")).
                selectTransit(toreTestData.getString("Transit"))
                .clickRetrieve();

        return pageObjectManager.getSavingsAccountNumber().getAccountNumber();
    }

}
