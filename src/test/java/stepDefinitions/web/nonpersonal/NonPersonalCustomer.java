/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-18
 * Created Time: 3:08 p.m.
 */

package stepDefinitions.web.nonpersonal;

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
import stepDefinitions.managers.StepDefinitionManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@QAFTestStepProvider
public class NonPersonalCustomer {


    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;
    private final StepDefinitionManager stepDefinitionManager;
    private WebDriver driver = null;
    private ResultSet testData = null;

    public NonPersonalCustomer() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        stepDefinitionManager = StepDefinitionManager.getInstance();
        driver = DriverManager.getDriver();
    }


    @And("^located non-personal customer with legal name$")
    public void locatedNonPersonalCustomerWithLegalName() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getScotiaCardOrAccount().clickNonPersonalCustomer()
                .clickLegalName().enterName(testData.getString("Name"));

        ReportPortal.stepInfoWithScreenshot("Customer Locate/ Setup--> Non-Personal Customer");

        pageObjectManager.getScotiaCardOrAccount().clickFind();

    }

    @And("^created new non-personal customer$")
    public void createdNewNonPersonalCustomer() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getNonPersonalCustomer().clickNew();

        if (!testData.getString("CustomerNameLine2").equals(""))
            pageObjectManager.getHeaderNonPersonal().enterCustomerNameLine2(testData.getString("CustomerNameLine2"));

//                Business Address
        addBusinessAddress(testData);

        ReportPortal.stepInfoWithScreenshot("Customer Information--> Business Address");

//              Contact Information
        addContactInformation(testData);

        ReportPortal.stepInfoWithScreenshot("Customer Information--> Contact Information");

        // Business Information
        addBusinessInformation(testData);

        ReportPortal.stepInfoWithScreenshot("Customer Information--> Business Information");

        // Loan Administration
        addLoanAdministration(testData);

        ReportPortal.stepInfoWithScreenshot("Customer Information--> Loan Administration");

//        Customer Relationship
        addCustomerRelationship(testData);

        ReportPortal.stepInfoWithScreenshot("Customer Information--> Customer Relationship");

        pageObjectManager.getFooter().clickSubmit().clickSubmit().clickOk();

    }

    @Then("^captured created non-personal customer CID$")
    public void capturedCreatedNonPersonalCustomerCID() throws Exception {
        //  Read Non-Personal data from database
        ResultSet nonpersonalTestData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        pageObjectManager.getCustomerSelection().clickCustomer(nonpersonalTestData.getString("Name"), "Name");

        String cid = pageObjectManager.getHeaderNonPersonal().getCID().trim();
        //            Update Non-Personal CID in Non-Personal database table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "CIDNonPersonal", cid));

        ReportPortal.stepPassWithScreenshot("Customer created successfully - CID is " + cid);
    }

    @And("^located non-personal customer with cid$")
    public void locatedNonPersonalCustomerWithCid() throws Exception {
        //  Read Non- Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getScotiaCardOrAccount().
                enterCID(testData.getString("CIDNonPersonal")).
                clickFind();
    }

    @And("^updated non-personal customer details$")
    public void updatedNonPersonalCustomerDetails() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getProductsAndServicesNonPersonal().clickCustomerInformation().clickCustomerName().clickUpdate();

        //Update Customer Name
        updateCustomerName(testData);

        ReportPortal.stepInfoWithScreenshot("Customer Information -> Customer Name");
        pageObjectManager.getCustomerNameNonPersonal().clickNext();

        //Business Address
        updateBusinessAddress(testData);
        pageObjectManager.getBusinessAddressMaintenanceNonPersonal().clickNext();

        ReportPortal.stepInfoWithScreenshot("Customer Information -> Business Address");

//        Contact Information
        updateContactInformation(testData);
        pageObjectManager.getContactInformationMaintenanceNonPersonal().clickNext();

        ReportPortal.stepInfoWithScreenshot("Customer Information -> Contact Information");

//        Business Information
        updateBusinessInformation(testData);
        pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickNext();

        ReportPortal.stepInfoWithScreenshot("Customer Information -> Business Information");

//        Loan Administration
        updateLoanAdministration(testData);
        pageObjectManager.getLoanAdministrationMaintenanceNonPersonal().clickNext();
        ReportPortal.stepInfoWithScreenshot("Customer Information -> Business Information");

        pageObjectManager.getFooter().clickDone();
    }

    private void addBusinessAddress(ResultSet testData) throws SQLException, InterruptedException {
        pageObjectManager.getBusinessAddress().selectAddressType(testData.getString("AddressType")).
                enterAddressLine1(testData.getString("Address1")).
                enterAddressLine2(testData.getString("Address2")).
                enterCity(testData.getString("City")).
                selectProvinceOrState(testData.getString("Province")).
                selectCountry(testData.getString("Country")).
                enterPostalOrZipcode(testData.getString("Postal"));
    }

    private void addContactInformation(ResultSet testData) throws SQLException, InterruptedException {
        pageObjectManager.getCustomerInformation().clickContactInformation();
        pageObjectManager.getContactInformationNonPersonal().enterContactName(testData.getString("ContactName")).
                enterContactTitle(testData.getString("ContactTitle")).
                enterContactPhoneNumber(testData.getString("ContactPhoneNumber"));
        if (!(testData.getString("Ext").trim().equals(""))) {
            pageObjectManager.getContactInformationNonPersonal().enterExt(testData.getString("Ext"));
        }

        pageObjectManager.getContactInformationNonPersonal().enterEmail(testData.getString("Email"));
    }

    private void addIdDocuments(ResultSet testData) throws SQLException, InterruptedException, IOException {
        String[] documentTypes = testData.getString("DocumentType").split("\\|");
        String[] documentSources = testData.getString("DocumentSource").split("\\|");
        String[] idOrRefOrAccountNumbers = testData.getString("IDOrRefOrAccountNumber").split("\\|");
        String[] sourceDescription = testData.getString("SourceDescription").split("\\|");
        String[] expiryDates = testData.getString("ExpiryDate").split("\\|");
        String[] countries = testData.getString("IdDocumentCountry").split("\\|");
        String[] provOrTerrOrStates = testData.getString("ProvOrTerrOrState").split("\\|");

        for (int ids = 0; ids < documentTypes.length; ids++) {
            addIdDocument(documentTypes[ids], documentSources[ids],
                    idOrRefOrAccountNumbers[ids], sourceDescription[ids],
                    expiryDates[ids], countries[ids], provOrTerrOrStates[ids]);
        }

    }

    private void addIdDocument(String documentType, String documentSource,
                               String idOrRefOrAccountNumber, String sourceDescription,
                               String expiryDate, String country,
                               String provOrTerrOrState) throws InterruptedException, IOException {

        pageObjectManager.getBusinessInformation().
                selectDocumentType(documentType).
                selectDocumentSource(documentSource);

        if (!idOrRefOrAccountNumber.trim().equals(""))
            pageObjectManager.getBusinessInformation().enterIdOrRefOrAccountNumber(idOrRefOrAccountNumber);
        if (!sourceDescription.trim().equals(""))
            pageObjectManager.getBusinessInformation().enterSourceDescription(sourceDescription);
        if (!expiryDate.trim().equals(""))
            pageObjectManager.getBusinessInformation().enterExpiryDate(expiryDate);
        if (!country.trim().equals(""))
            pageObjectManager.getBusinessInformation().selectCountry(country);
        if (!provOrTerrOrState.trim().equals(""))
            pageObjectManager.getBusinessInformation().selectProvOrTerrOrState(provOrTerrOrState);

        pageObjectManager.getBusinessInformation().clickSummaryOfIDDocuments().clickAdd();
    }

    private void updateIdDocuments(ResultSet testData) throws SQLException, InterruptedException {
        String[] documentTypes = testData.getString("DocumentType").split("\\|");
        String[] documentSources = testData.getString("DocumentSource").split("\\|");
        String[] idOrRefOrAccountNumbers = testData.getString("IDOrRefOrAccountNumber").split("\\|");
        String[] sourceDescription = testData.getString("SourceDescription").split("\\|");
        String[] idMethods = testData.getString("DocumentType").split("\\|");
        String[] expiryDates = testData.getString("ExpiryDate").split("\\|");
        String[] idDocumentCountries = testData.getString("IdDocumentCountry").split("\\|");
        String[] provOrTerrOrStates = testData.getString("ProvOrTerrOrState").split("\\|");

        for (int ids = 0; ids < idMethods.length; ids++) {
            pageObjectManager.getBusinessInformation().
                    selectDocumentSource(documentSources[ids]);

            if (!idOrRefOrAccountNumbers[ids].trim().equals(""))
                pageObjectManager.getBusinessInformation().enterIdOrRefOrAccountNumber(idOrRefOrAccountNumbers[ids]);
            if (!sourceDescription[ids].trim().equals(""))
                pageObjectManager.getBusinessInformation().enterSourceDescription(sourceDescription[ids]);
            if (!expiryDates[ids].trim().equals(""))
                pageObjectManager.getBusinessInformation().enterExpiryDate(expiryDates[ids]);
            if (!idDocumentCountries[ids].trim().equals(""))
                pageObjectManager.getBusinessInformation().selectCountry(idDocumentCountries[ids]);
            if (!provOrTerrOrStates[ids].trim().equals(""))
                pageObjectManager.getBusinessInformation().selectProvOrTerrOrState(provOrTerrOrStates[ids]).
                        clickUpdateID();

        }

    }

    private void addAccountHolderPrincipaloftheBusiness(ResultSet testData) throws SQLException, InterruptedException {

        if (!testData.getString("LastName1").equals(""))
            pageObjectManager.getBusinessInformation().
                    enterLastName1(testData.getString("LastName1"));
        else {
            ReportPortal.stepFailWithScreenshot("Last Name1 is mandatory in Summary of Business ID/Documents section," +
                    " so please pass data in test data");
            Assertions.fail("Last Name1 is mandatory in Summary of Business ID/Documents section," +
                    " so please pass data in test data");
        }


        if (!testData.getString("FirstName1").equals(""))
            pageObjectManager.getBusinessInformation().
                    enterFirstName1(testData.getString("FirstName1"));
        else
            Assertions.fail("First Name1 is mandatory in Summary of Business ID/Documents section," +
                    " so please pass data in test data");

        if (!testData.getString("Initials1").equals(""))
            pageObjectManager.getBusinessInformation().
                    enterInitials1(testData.getString("Initials1"));
        if (!testData.getString("LastName2").equals(""))
            pageObjectManager.getBusinessInformation().enterLastName2(testData.getString("LastName2"));
        if (!testData.getString("FirstName2").equals(""))
            pageObjectManager.getBusinessInformation().enterFirstName2(testData.getString("FirstName2"));
        if (!testData.getString("Initials2").equals(""))
            pageObjectManager.getBusinessInformation().enterInitials2(testData.getString("Initials2"));
        if (!testData.getString("LastName3").equals(""))
            pageObjectManager.getBusinessInformation().enterLastName3(testData.getString("LastName3"));
        if (!testData.getString("FirstName3").equals(""))
            pageObjectManager.getBusinessInformation().enterFirstName3(testData.getString("FirstName3"));
        if (!testData.getString("Initials3").equals(""))
            pageObjectManager.getBusinessInformation().enterInitials3(testData.getString("Initials3"));


    }

    // Incorporation details
    private void addIncorporationDetails(ResultSet testData) throws SQLException {

        pageObjectManager.getBusinessInformation().enterIncorporationNumber(testData.getString("IncorporationNumber"));
        pageObjectManager.getBusinessInformation().selectIncBusinessInfoCountry(testData.getString("IncBusinessInfoCountry"));
        pageObjectManager.getBusinessInformation().selectIncBusinessInfoProvinceState(testData.getString("IncBusinessInfoProvState"));
    }

    private void addTaxResidencyInformation(ResultSet testData) throws SQLException {
        if ((testData.getString("CustomerType").equalsIgnoreCase("Com-Commercial Business") ||
                testData.getString("CustomerType").equalsIgnoreCase("Com-Commercial Real Estate") ||
                testData.getString("CustomerType").equalsIgnoreCase("Com-Fraternal Assoc Comm Bus") ||
                testData.getString("CustomerType").equalsIgnoreCase("Com-Aboriginal-Commercial Bus") ||
                testData.getString("CustomerType").equalsIgnoreCase("Com-First Nations Band/Council/Com") ||
                testData.getString("CustomerType").equalsIgnoreCase("Corp-Corporate Real Estate") ||
                testData.getString("CustomerType").equalsIgnoreCase("Corp-Corporate Non Real Estate"))
                && (testData.getString("Status").equalsIgnoreCase("Open") ||
                testData.getString("Status").equalsIgnoreCase("Derogatory")))
            pageObjectManager.getBusinessInformation().selectTaxResidencyInformation(testData.getString("TaxResidencyInformation"));
    }

    private void addBusinessInformation(ResultSet testData) throws IOException, SQLException, InterruptedException {

        pageObjectManager.getCustomerInformationNonPersonal().clickBusinessInformation();
        //              Business Information
        if (!(testData.getString("BusinessLegalName").trim().equals(""))) {
            pageObjectManager.getBusinessInformation().enterBusinessLegalName(testData.getString("BusinessLegalName"));
        }
        pageObjectManager.getBusinessInformation().
                enterBusinessTradingName(testData.getString("BusinessTradingName")).
                selectCustomerType(testData.getString("CustomerType")).
                selectBusinessStructure(testData.getString("BusinessStructure"));

        /*  ----- Business sub category is disabled when Business Structure is
          Sole Proprietorship,Joint Venture and  Co-Operative*/
        if (!(testData.getString("BusinessSubCategory").trim().equalsIgnoreCase(""))) {
            pageObjectManager.getBusinessInformation().selectBusinessSubCategory(testData.getString("BusinessSubCategory"));
        }

        pageObjectManager.getBusinessInformation().enterDateBusinessEstablished(testData.getString("DateBusinessEstablished")).
                selectLanguageChoice(testData.getString("LangageChoice"));

        if (!(testData.getString("AnnualSalesfromFinStmt").trim().equalsIgnoreCase(""))) {
            pageObjectManager.getBusinessInformation().
                    selectAnnualSalesFromFinStatement(testData.getString("AnnualSalesfromFinStmt"));
        }

        pageObjectManager.getBusinessInformation().enterMonth(testData.getString("Month")).
                enterYear(testData.getString("Year"));
        if (testData.getString("NumberOfEmployees").trim().matches("[0-9]*")) {
            pageObjectManager.getBusinessInformation().enterNumberOfEmployees(testData.getString("NumberOfEmployees"));
        } else {
            pageObjectManager.getBusinessInformation().selectNumberOfEmployees(testData.getString("NumberOfEmployees"));
        }

        pageObjectManager.getBusinessInformation().selectStatus(testData.getString("Status")).
                enterStandardIndustrialCode(testData.getString("StandardIndustrialCode")).
                enterBusinessNumber(testData.getString("BusinessNumber"));

        // Add Business ID/Documents
        addIdDocuments(testData);

        // Account Holder/Principal of the Business OR Incorporation details

        if ((testData.getString("BusinessStructure").equalsIgnoreCase("Corporation")) ||
                (testData.getString("BusinessStructure").equalsIgnoreCase("Société Par Actions"))) {

            //Incorporation details
            addIncorporationDetails(testData);

        } else {
            // Account Holder/Principal of the Business for incorporated Businesses
            addAccountHolderPrincipaloftheBusiness(testData);
        }


//     Tax Residency Information
        addTaxResidencyInformation(testData);


    }

    private void addLoanAdministration(ResultSet testData) throws SQLException {

        pageObjectManager.getCustomerInformationNonPersonal().clickLoanAdministration();
//              Loan Administration
        if (!(testData.getString("LoanAdministrationRating").trim().equalsIgnoreCase(""))) {
            pageObjectManager.getLoanAdministrationCreatePersonal().selectLoanAdministrationRating(testData.getString("LoanAdministrationRating"));
        }
        if (!(testData.getString("Profitability").trim().equalsIgnoreCase(""))) {
            pageObjectManager.getLoanAdministrationCreatePersonal().selectProfitability(testData.getString("Profitability"));
        }

        if (!(testData.getString("Sensitivity").trim().equalsIgnoreCase(""))) {
            pageObjectManager.getLoanAdministrationCreatePersonal().selectSensitivity(testData.getString("Sensitivity"));
        }


    }

    private void addCustomerRelationship(ResultSet testData) throws Exception {


//              Customer Relationship
        if (!(testData.getString("Relationship").trim().equalsIgnoreCase(""))) {
            // if (testData.getString("CustomerType").equalsIgnoreCase("Sm-Small Business") ||
            //        testData.getString("CustomerType").equalsIgnoreCase("Sm-Ass'ns/Not For Profit-Small Bus") ||
            //       testData.getString("CustomerType").equalsIgnoreCase("Sm-Aboriginal-Small Business") ||
            //      testData.getString("CustomerType").equalsIgnoreCase("Sm-First Nations Band/Council/Small")) {
//              Customer Relationship
            pageObjectManager.getCustomerInformationNonPersonal().clickCustomerRelationship();
            pageObjectManager.getCustomerRelationship().clickLocate();


            ResultSet personalCustomerTestData = TestDataDB.getInstance().getData(
                    TestDataQueries.getInstance().
                            getTableName("personal",
                                    testData.getString("ReferenceScenarioId")));

            pageObjectManager.getScotiaCardOrAccount().clickPersonalCustomerName().
                    enterFirstName(personalCustomerTestData.getString("FirstName")).
                    enterLastName(personalCustomerTestData.getString("LastName")).
                    clickFind();

            pageObjectManager.getPersonalCustomerName().clickNew();


            stepDefinitionManager.getPersonalCustomer().createNewPersonalCustomer(personalCustomerTestData);

            pageObjectManager.getCustomerRelationship().selectRelationship(testData.getString("Relationship"))
                    .enterOwnership(testData.getString("Ownership")).
                    selectAction(testData.getString("Action")).
                    selectRelationshipNonPersonal(testData.getString("RelationshipNonPersonal"));

        }
    }

    //    Update  Non-Personal customer details

    //        Customer Name
    private void updateCustomerName(ResultSet testData) throws SQLException {
        if (!testData.getString("Name").equals(""))
            pageObjectManager.getCustomerNameNonPersonal().enterCustomerNameLine1(testData.getString("Name"));

        if (!testData.getString("CustomerNameLine2").equals(""))
            pageObjectManager.getCustomerNameNonPersonal().enterCustomerNameLine2(testData.getString("CustomerNameLine2"));

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getFooter().clickCancel();


    }

    //    Business Address
    private void updateBusinessAddress(ResultSet testData) throws SQLException, InterruptedException {
        pageObjectManager.getBusinessAddressMaintenanceNonPersonal().clickUpdateBusinessAddress();
        if (!testData.getString("AddressType").equals(""))
            pageObjectManager.getBusinessAddressMaintenanceNonPersonal().selectAddressType(testData.getString("AddressType"));

        if (!testData.getString("Address1").equals(""))
            pageObjectManager.getBusinessAddressMaintenanceNonPersonal().enterAddressLine1(testData.getString("Address1"));

        if (!testData.getString("Address2").equals(""))
            pageObjectManager.getBusinessAddressMaintenanceNonPersonal().enterAddressLine2(testData.getString("Address2"));

        if (!testData.getString("City").equals(""))
            pageObjectManager.getBusinessAddressMaintenanceNonPersonal().enterCity(testData.getString("City"));

        if (!testData.getString("Province").equals(""))
            pageObjectManager.getBusinessAddressMaintenanceNonPersonal().enterCity(testData.getString("Province"));

        if (!testData.getString("Country").equals(""))
            pageObjectManager.getBusinessAddressMaintenanceNonPersonal().selectCountry(testData.getString("Country"));

        if (!testData.getString("Postal").equals(""))
            pageObjectManager.getBusinessAddressMaintenanceNonPersonal().enterPostalOrZipcode(testData.getString("Postal"));

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getPopUps().clickSubmit();

    }

    //    Contact Information
    private void updateContactInformation(ResultSet testData) throws SQLException, InterruptedException {
        pageObjectManager.getContactInformationMaintenanceNonPersonal().clickUpdate();

        if (!testData.getString("ContactName").equals(""))
            pageObjectManager.getContactInformationMaintenanceNonPersonal().enterContactName(testData.getString("ContactName"));

        if (!testData.getString("ContactTitle").equals(""))
            pageObjectManager.getContactInformationMaintenanceNonPersonal().enterContactTitle(testData.getString("ContactTitle"));

        if (!testData.getString("ContactPhoneNumber").equals(""))
            pageObjectManager.getContactInformationMaintenanceNonPersonal().enterContactPhoneNumber(testData.getString("ContactPhoneNumber"));

        if (!testData.getString("Ext").equals(""))
            pageObjectManager.getContactInformationMaintenanceNonPersonal().enterExt(testData.getString("Ext"));

        if (!testData.getString("Email").equals(""))
            pageObjectManager.getContactInformationMaintenanceNonPersonal().enterEmail(testData.getString("Email"));

        pageObjectManager.getFooter().clickUpdate();

    }

    //    Business Information
    private void updateBusinessInformation(ResultSet testData) throws Exception {
        pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickUpdatePage();

        if (!testData.getString("BusinessLegalName").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterBusinessLegalName(testData.getString("BusinessLegalName"));

        if (!testData.getString("BusinessTradingName").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterBusinessTradingName(testData.getString("BusinessTradingName"));

        if (!testData.getString("DateBusinessEstablished").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterDateBusinessEstablished(testData.getString("DateBusinessEstablished"));

        if (!testData.getString("LangageChoice").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().selectLanguageChoice(testData.getString("LangageChoice"));

        if (!testData.getString("AnnualSalesfromFinStmt").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().selectAnnualSalesFromFinStatement(testData.getString("AnnualSalesfromFinStmt"));

//        Clear Annual Sales from Fin stmt amount when it is To be Determined, Not Applicable, Declined
        if (testData.getString("AnnualSalesfromFinStmt").equals("To Be Determined") ||
                testData.getString("AnnualSalesfromFinStmt").equals("Declined") ||
                testData.getString("AnnualSalesfromFinStmt").equals("Not Applicable") ||
                testData.getString("AnnualSalesfromFinStmt").equals("À Déterminer") ||
                testData.getString("AnnualSalesfromFinStmt").equals("Non Applicable") ||
                testData.getString("AnnualSalesfromFinStmt").equals("Refusée")) {
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterAnnualSalesFromFinStatement("");
        }

        if (!testData.getString("Month").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterMonth(testData.getString("Month"));

        if (!testData.getString("Year").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterYear(testData.getString("Year"));

        if (!testData.getString("NumberOfEmployees").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().selectNumberOfEmployees(testData.getString("NumberOfEmployees"));

        //   Clear Number of Employees when it is To be Determined, Not Applicable, Declined
        if (testData.getString("NumberOfEmployees").equals("To Be Determined") ||
                testData.getString("NumberOfEmployees").equals("Declined") ||
                testData.getString("NumberOfEmployees").equals("Not Applicable") ||
                testData.getString("NumberOfEmployees").equals("À Déterminer") ||
                testData.getString("NumberOfEmployees").equals("Non Applicable") ||
                testData.getString("NumberOfEmployees").equals("Refusée")) {
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterNumberOfEmployees("");
        }

        if (!testData.getString("Status").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().selectStatus(testData.getString("Status"));

        if (!testData.getString("StandardIndustrialCode").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterStandardIndustrialCode(testData.getString("StandardIndustrialCode"));

        if (!testData.getString("BusinessNumber").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterBusinessNumber(testData.getString("BusinessNumber"));

        if (!testData.getString("BankruptcyDate").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterBankruptcyDate(testData.getString("BankruptcyDate"));

        // Add Business ID/Documents
        updateBusinessIdOrDocuments(testData);

//        Summary of Business ID/Documents
        if (!testData.getString("LastName1").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterLastName1(testData.getString("LastName1"));

        if (!testData.getString("FirstName1").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterFirstName1(testData.getString("FirstName1"));

        if (!testData.getString("Initials1").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterInitials1(testData.getString("Initials1"));

        if (!testData.getString("LastName2").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterLastName2(testData.getString("LastName2"));

        if (!testData.getString("FirstName2").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterFirstName2(testData.getString("FirstName2"));

        if (!testData.getString("Initials2").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterInitials2(testData.getString("Initials2"));

        if (!testData.getString("LastName3").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterLastName3(testData.getString("LastName3"));

        if (!testData.getString("FirstName3").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterFirstName3(testData.getString("FirstName3"));

        if (!testData.getString("Initials3").equals(""))
            pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterInitials3(testData.getString("Initials3"));

        pageObjectManager.getFooter().clickUpdate();

    }

    //    Loan Administration
    private void updateLoanAdministration(ResultSet testData) throws SQLException {
        pageObjectManager.getLoanAdministrationMaintenanceNonPersonal().clickUpdate();

        if (!testData.getString("LoanAdministrationRating").equals(""))
            pageObjectManager.getLoanAdministrationMaintenanceNonPersonal().selectLoanAdministrationRating(testData.getString("LoanAdministrationRating"));

        if (!testData.getString("Profitability").equals(""))
            pageObjectManager.getLoanAdministrationMaintenanceNonPersonal().selectProfitability(testData.getString("Profitability"));

        if (!testData.getString("Sensitivity").equals(""))
            pageObjectManager.getLoanAdministrationMaintenanceNonPersonal().selectSensitivity(testData.getString("Sensitivity"));

        pageObjectManager.getFooter().clickUpdate();
    }

    @And("^get a non-personal cid$")
    public void getANonPersonalCid() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        String referenceScenarioId = testData.getString("ReferenceScenarioId");
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                referenceScenarioId));

        //            Update Personal CID in Personal database table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateNonPersonal(scenarioContext.getScenarioId(),
                                "CIDNonPersonal", testData.getString("CIDNonPersonal")));
    }


    @Then("^Validate the Business Information provided$")
    public void validateTheBusinessInformationProvided() {
        pageObjectManager.getProductsAndServicesNonPersonal().clickCustomerInformation();
        pageObjectManager.getProductsAndServicesNonPersonal().clickCustomerInformation().clickBusinessInformation();
    }

    @Then("^Validate the Identification section$")
    public void validateTheIdentificationSection() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        pageObjectManager.getProductsAndServicesNonPersonal().clickCustomerInformation().clickBusinessInformation().clickIDTable();
        if (pageObjectManager.getBusinessInformationMaintenanceNonPersonal().isBusinessIdOrDocumentExists(testData.getString("DocumentType"))) {

            pageObjectManager.getProductsAndServicesNonPersonal().clickCustomerInformation().clickBusinessInformation()
                    .clickIdentificationDocument(testData.getString("DocumentType"));
        }

    }


    @And("^Enter name and Business address$")
    public void enterNameAndBusinessAddress() throws Exception {

        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getNonPersonalCustomer().clickNew();

        if (!testData.getString("CustomerNameLine2").equals(""))
            pageObjectManager.getHeaderNonPersonal().enterCustomerNameLine2(testData.getString("CustomerNameLine2"));

//                Business Address
        addBusinessAddress(testData);

    }

    @And("^Enter Contact Information details$")
    public void enterContactInformationDetails() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        //              Contact Information
        addContactInformation(testData);
    }

    @And("^Enter Business Information details$")
    public void enterBusinessInformationDetails() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //              Business Information
        addBusinessInformation(testData);
    }

    @And("^Enter Loan Administration details$")
    public void enterLoanAdministrationDetails() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //              Loan Administration
        addLoanAdministration(testData);
    }

    @And("^create non personal customer with relationship details added$")
    public void createNonPersonalCustomerWithRelationshipdetailsAdded() throws Exception {

        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Customer Relationship
        addCustomerRelationship(testData);


    }

    @Then("^Validate the Contact Information$")
    public void validateTheContactInformation() {
        pageObjectManager.getProductsAndServicesNonPersonal().clickCustomerInformation();
        pageObjectManager.getProductsAndServicesNonPersonal().clickCustomerInformation().clickContactInformation();
    }

    @And("^click on customer name$")
    public void clickOnCustomerName() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getCustomerSelection().clickCustomer(testData.getString("CIDNonPersonal"), "CID");
    }

    private void updateBusinessIdOrDocuments(ResultSet testData) throws Exception {

        String[] documentAction = testData.getString("DocumentAction").split("\\|");
        String[] documentTypes = testData.getString("DocumentType").split("\\|");
        String[] documentSources = testData.getString("DocumentSource").split("\\|");
        String[] idOrRefOrAccountNumbers = testData.getString("IDOrRefOrAccountNumber").split("\\|");
        String[] sourceDescription = testData.getString("SourceDescription").split("\\|");
        String[] idMethods = testData.getString("DocumentType").split("\\|");
        String[] expiryDates = testData.getString("ExpiryDate").split("\\|");
        String[] countries = testData.getString("IdDocumentCountry").split("\\|");
        String[] provOrTerrOrStates = testData.getString("ProvOrTerrOrState").split("\\|");

        for (int ids = 0; ids < idMethods.length; ids++) {

            if (pageObjectManager.getBusinessInformationMaintenanceNonPersonal().isBusinessIdOrDocumentExists(documentTypes[ids])) {
                pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickBusinessId(documentTypes[ids]);
                pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickUpdateExistingId();
                if (documentAction[ids].equalsIgnoreCase("DELETE")) {
                    pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickDeleteId();
                } else {
                    if (!documentSources[ids].equals(""))
                        pageObjectManager.getBusinessInformationMaintenanceNonPersonal().selectIdOrDocumentSourceExistingId(documentSources[ids]);

                    if (!idOrRefOrAccountNumbers[ids].equals(""))
                        pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterIdOrRefOrAccountNumberExistingId(idOrRefOrAccountNumbers[ids]);

                    if (!sourceDescription[ids].equals(""))
                        pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterSourceDescription(sourceDescription[ids]);

                    if (!expiryDates[ids].equals(""))
                        pageObjectManager.getBusinessInformationMaintenanceNonPersonal().enterExpiryDateExistingId(expiryDates[ids]);

                    if (!countries[ids].equals(""))
                        pageObjectManager.getBusinessInformationMaintenanceNonPersonal().selectCountryExistingId(countries[ids]);

                    if (!provOrTerrOrStates[ids].equals(""))
                        pageObjectManager.getBusinessInformationMaintenanceNonPersonal().selectProvinceExistingId(provOrTerrOrStates[ids]);

                    pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickUpdate();
                }
            } else {
                addIdDocument(documentTypes[ids], documentSources[ids],
                        idOrRefOrAccountNumbers[ids], sourceDescription[ids],
                        expiryDates[ids], countries[ids], provOrTerrOrStates[ids]);
            }
        }

    }

    private void deleteBusinessIdOrDocuments(ResultSet testData) throws Exception {
        String[] documentTypes = testData.getString("DocumentType").split("\\|");
        String[] documentSources = testData.getString("DocumentSource").split("\\|");
        String[] idOrRefOrAccountNumbers = testData.getString("IDOrRefOrAccountNumber").split("\\|");
        String[] sourceDescription = testData.getString("SourceDescription").split("\\|");
        String[] idMethods = testData.getString("DocumentType").split("\\|");
        String[] expiryDates = testData.getString("ExpiryDate").split("\\|");
        String[] countries = testData.getString("IdDocumentCountry").split("\\|");
        String[] provOrTerrOrStates = testData.getString("ProvOrTerrOrState").split("\\|");

        for (int ids = 0; ids < idMethods.length; ids++) {
            if (pageObjectManager.getBusinessInformationMaintenanceNonPersonal().isBusinessIdOrDocumentExists(documentTypes[ids])) {
                pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickBusinessId(documentTypes[ids]);
                pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickUpdateExistingId();

                pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickDeleteId();
            }
        }

    }

    @And("^click submit and reprofile the customer created$")
    public void clickSubmitAndReprofileTheCustomerCreated() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getFooter().clickSubmit().clickSubmit().clickOk()
                .clickCustomer(testData.getString("CIDNonPersonal"), "CID");
    }

    @And("^delete the existing ID document$")
    public void deleteTheExistingIDDocument() throws Exception {

        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));


        //        deleteExistingIDDocument
        deleteExistingIDDocument(testData);

        pageObjectManager.getFooter().clickUpdate();

        pageObjectManager.getFooter().clickDone();
    }

    private void deleteExistingIDDocument(ResultSet testData) throws Exception {


        String[] documentAction = testData.getString("DocumentAction").split("\\|");
        String[] documentTypes = testData.getString("DocumentType").split("\\|");

        for (int ids = 0; ids < documentTypes.length; ids++) {

            if (pageObjectManager.getBusinessInformationMaintenanceNonPersonal().isBusinessIdOrDocumentExists(documentTypes[ids])) {
                pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickBusinessId(documentTypes[ids]);
                pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickUpdateExistingId();
                pageObjectManager.getBusinessInformationMaintenanceNonPersonal().clickDeleteId();
            }
        }
    }

    @And("^Navigate to Identification section in Business Information$")
    public void navigateToIdentificationSectionInBusinessInformation() {
        pageObjectManager.getProductsAndServicesNonPersonal().clickCustomerInformation().clickBusinessInformation().
                clickUpdatePage().clickIDTable();
    }

    @Then("^validated account mailing address with business account profile address$")
    public void validatedAccountMailingAddressWithBusinessAccountProfileAddress() throws Exception {
        //  Read day to day banking data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        String addressLine1AccountProfile = pageObjectManager.getBusinessAccountProfile().
                getAddressLine1().trim();
        String addressLine2AccountProfile = pageObjectManager.getBusinessAccountProfile().
                getAddressLine2().trim();
        String addressLine3AccountProfile = pageObjectManager.getBusinessAccountProfile()
                .getAddressLine3().trim();
        String provinceAccountProfile = pageObjectManager.getBusinessAccountProfile().
                getProvince().trim();
        String postalAccountProfile = pageObjectManager.getBusinessAccountProfile().
                getPostal().trim();
        String countryAccountProfile = pageObjectManager.getBusinessAccountProfile().
                getCountry().trim();


        pageObjectManager.getBusinessAccountProfile().clickExit();

        pageObjectManager.getProductsAndServicesNonPersonal().
                clickCustomerInformation().clickBusinessAddress()
                .clickOnAction(testData.getString("AccountNumber"));

        String addressLine1AccountMailingAddress = pageObjectManager.getBusinessAddressMaintenanceNonPersonal().getAddressLine1AccountMailing();
        String addressLine2AccountMailingAddress = pageObjectManager.getBusinessAddressMaintenanceNonPersonal().getAddressLine2AccountMailing();
        String addressLine3AccountMailingAddress = pageObjectManager.getBusinessAddressMaintenanceNonPersonal().getCityAccountMailing();
        String provinceAccountMailingAddress = pageObjectManager.getBusinessAddressMaintenanceNonPersonal().getProvinceAccountMailing();
        String postalAccountMailingAddress = pageObjectManager.getBusinessAddressMaintenanceNonPersonal().getPostalAccountMailing();
        String countryAccountMailingAddress = pageObjectManager.getAddressInformationUpdate().getCountryAccountMailing();

        // Address Line 1
        if (addressLine1AccountProfile.equals(addressLine1AccountMailingAddress)) {
            ReportPortal.stepPassWithScreenshot("Address Line-1 is as expected for Account Profile and Account Mailing address" +
                    " Address Line-1:- " + addressLine1AccountProfile);
        } else {
            ReportPortal.stepFailWithScreenshot("Address Line-1 is not as expected for Account Profile and Account Mailing address" +
                    " Account Profile AddressLine-1:- " + addressLine1AccountProfile +
                    " Account Mailing address AddressLine-1:- " + addressLine1AccountMailingAddress);
        }

        // Address Line 2
        if (addressLine2AccountProfile.equals(addressLine2AccountMailingAddress)) {
            ReportPortal.stepPassWithScreenshot("Address Line-2 is as expected for Account Profile and Account Mailing address" +
                    " Address Line-2:- " + addressLine2AccountProfile);
        } else {
            ReportPortal.stepFailWithScreenshot("Address Line-1 is not as expected for Account Profile and Account Mailing address" +
                    " Account Profile AddressLine-1:- " + addressLine1AccountProfile +
                    " Account Mailing address AddressLine-1:- " + addressLine1AccountMailingAddress);
        }


        // Address Line 3 or City
        if (addressLine3AccountProfile.equals(addressLine3AccountMailingAddress)) {
            ReportPortal.stepPassWithScreenshot("Address Line-3/City is as expected for Account Profile and Account Mailing address" +
                    " Address Line-3/City:- " + addressLine3AccountProfile);
        } else {
            ReportPortal.stepFailWithScreenshot("Address Line-3/City is not as expected for Account Profile and Account Mailing address" +
                    " Account Profile AddressLine-3/City:- " + addressLine3AccountProfile +
                    " Account Mailing address AddressLine-3/City:- " + addressLine3AccountMailingAddress);
        }

        // Province
        if (provinceAccountProfile.equals(provinceAccountMailingAddress)) {
            ReportPortal.stepPassWithScreenshot("Province is as expected for Account Profile and Account Mailing address" +
                    " Province:- " + provinceAccountProfile);
        } else {
            ReportPortal.stepFailWithScreenshot("Province is not as expected for Account Profile and Account Mailing address" +
                    " Account Profile Province:- " + provinceAccountProfile +
                    " Account Mailing address Province:- " + provinceAccountMailingAddress);
        }

        // Postal/Zip code
        if (postalAccountProfile.replaceAll("\\s+", "").
                equals(postalAccountMailingAddress)) {
            ReportPortal.stepPassWithScreenshot("Postal/Zip code is as expected for Account Profile and Account Mailing address" +
                    " Postal/Zip code:- " + postalAccountProfile);
        } else {
            ReportPortal.stepFailWithScreenshot("Province is not as expected for Account Profile and Account Mailing address" +
                    " Account Profile Postal/Zip code:- " + postalAccountProfile +
                    " Account Mailing address Postal/Zip code:- " + postalAccountMailingAddress);
        }

        // Country
        if (countryAccountProfile.equals(countryAccountMailingAddress)) {
            ReportPortal.stepPassWithScreenshot("Country is as expected for Account Profile and Account Mailing address" +
                    " Country:- " + countryAccountProfile);
        } else {
            ReportPortal.stepFailWithScreenshot("Country is not as expected for Account Profile and Account Mailing address" +
                    " Account Profile Country:- " + countryAccountProfile +
                    " Account Mailing address Country:- " + countryAccountMailingAddress);
        }

        pageObjectManager.getFooter().clickCancel();
    }


    @And("^clicked on non-personal customer product$")
    public void clickedOnNonPersonalCustomerProduct() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        pageObjectManager.getProductsAndServicesNonPersonal().
                clickProductAndServices(testData.getString("AccountNumber"));
    }


}