/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-25
 * Created Time: 5:19 p.m.
 */

package stepDefinitions.web.personal.customerinformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.ReadPropertyFile;
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
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

@QAFTestStepProvider
public class PersonalCustomer {

    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private final PageObjectManager pageObjectManager;
    private final StepDefinitionManager stepDefinitionManager;
    private WebDriver driver = null;

    public PersonalCustomer() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        stepDefinitionManager = StepDefinitionManager.getInstance();
        driver = DriverManager.getDriver();
    }

    private void addPersonalInformation(ResultSet testData) throws SQLException, InterruptedException {
        pageObjectManager.getPersonalInformationCreate().
                enterSocialInsuranceNumber(testData.getString("SocialInsuranceNumber")).
                selectProfileStatus(testData.getString("ProfileStatus")).
                selectGender(testData.getString("Gender")).
                enterNumberOfDependents(testData.getString("NumberOfDependents")).
                enterBankruptcyDate(testData.getString("BankruptcyDate")).
                selectLanguageChoice(testData.getString("LanguageChoice")).
                selectMaritalStatus(testData.getString("MaritalStatus")).
                selectSensitivityCode(testData.getString("SensitivityCode"));

    }

    private void checkCustomerConsentToPrivacyAgreement(ResultSet testData) throws SQLException {
      /*Check Privacy agreement checkbox (It is only enabled when profile status is Open)
                                              And
   While updating customer Privacy agreement will enable when changing profile status from Prospect to Open*/
        if (testData.getString("ProfileStatus").equals("Open") ||
                testData.getString("ProfileStatus").equals("Ouvert")) {
            pageObjectManager.getPersonalInformationCreate().checkCustomerConsentToPrivacyAgreement();
        }
    }


    private void addTaxResidencyInformation(ResultSet testData) throws SQLException {
//                Need to keep  Tax residency methods.
        if (testData.getString("TaxResidencyInformation").equalsIgnoreCase("YES")) {
            pageObjectManager.getPersonalInformationCreate().clickYesTaxResidencyInformation().
//                    1st country tax residency information
        selectCountry1(testData.getString("Country1"));
            if (!testData.getString("Tin1").equals("")) {
                pageObjectManager.getPersonalInformationCreate().enterTin1(testData.getString("Tin1"));
            } else {
                pageObjectManager.getPersonalInformationCreate().selectNoTinReasonCode1(testData.getString("NoTinReasonCode1"));
                if (testData.getString("NoTinReasonCode1").equals("C"))
                    pageObjectManager.getPersonalInformationCreate().enterExplanation1(testData.getString("Explanation1"));
            }

            //   2nd country tax residency information
            if (!testData.getString("Country2").equals("")) {
                pageObjectManager.getPersonalInformationCreate().clickAdd().
                        selectCountry2(testData.getString("Country2"));
                if (!testData.getString("Tin2").equals("")) {
                    pageObjectManager.getPersonalInformationCreate().enterTin2(testData.getString("Tin2"));
                } else {
                    pageObjectManager.getPersonalInformationCreate().selectNoTinReasonCode2(testData.getString("NoTinReasonCode2"));
                    if (testData.getString("NoTinReasonCode2").equals("C"))
                        pageObjectManager.getPersonalInformationCreate().enterExplanation2(testData.getString("Explanation2"));
                }
            }

            //   3rd country tax residency information
            if (!testData.getString("Country3").equals("")) {
                pageObjectManager.getPersonalInformationCreate().clickAdd().
                        selectCountry3(testData.getString("Country3"));
                if (!testData.getString("Tin3").equals("")) {
                    pageObjectManager.getPersonalInformationCreate().enterTin3(testData.getString("Tin3"));
                } else {
                    pageObjectManager.getPersonalInformationCreate().selectNoTinReasonCode3(testData.getString("NoTinReasonCode3"));
                    if (testData.getString("NoTinReasonCode3").equals("C"))
                        pageObjectManager.getPersonalInformationCreate().enterExplanation3(testData.getString("Explanation3"));
                }
            }


        } else if (testData.getString("TaxResidencyInformation").
                equalsIgnoreCase("NO"))
            pageObjectManager.getPersonalInformationCreate().
                    clickNoTaxResidencyInformation();

    }


    private void addAddressInformation(ResultSet testData) throws SQLException, InterruptedException {
//                        Address Information
        pageObjectManager.getAddressInformationPersonal().selectAddressTypeResidntialType(testData.getString("AddressTypeResidential")).
                enterAddressLine1ResidntialType(testData.getString("AddressLine1Residential")).
                enterAddressLine2ResidntialType(testData.getString("AddressLine2Residential")).
                enterCityResidntialType(testData.getString("CityResidential")).
                selectProvinceOrStateResidntialType(testData.getString("ProvinceResidential")).
                selectCountryResidntialType(testData.getString("CountryResidential")).
                enterPostalOrZipcodeResidntialType(testData.getString("PostalResidential")).
                enterTimeAtAddressYears(testData.getString("YearsTimeAtAddress")).
                enterTimeAtAddressMonths(testData.getString("MonthsTimeAtAddress"));
        // Mailing Address
        if (testData.getString("MailingAddress").

                equalsIgnoreCase("YES"))
            pageObjectManager.getAddressInformationPersonal().
                    selectMailingAddressIsSameAsResidentialAddress().
                    selectAddressTypeMailingAddress(testData.getString("AddressTypeMailing")).
                    enterAddressLine1MailingAddress(testData.getString("AddressLine1Mailing")).
                    enterAddressLine2MailingAddress(testData.getString("AddressLine2Mailing")).
                    enterCityMailingAddress(testData.getString("CityMailing")).
                    selectProvinceOrStateMailingAddress(testData.getString("ProvinceMailing")).
                    selectCountryMailingAddress(testData.getString("CountryMailing")).
                    enterPostalOrZipcodeMailingAddress(testData.getString("PostalMailing"));

    }

    private void addResidenceInformation(ResultSet testData) throws SQLException, IOException, InterruptedException {
        if (testData.getString("UpdateResidenceInformation").
                equalsIgnoreCase("Yes")) {
            pageObjectManager.getResidenceInformationCreate().clickUpdateResidenceInformation();
            if (testData.getString("RentOrOwn").equalsIgnoreCase("Rent"))
                pageObjectManager.getResidenceInformationCreate().selectRent().
                        selectRentalType(testData.getString("RentalType")).
                        enterRentalAmount(testData.getString("RentalAmount")).
                        selectFrequencyRent(testData.getString("Frequency"));
            else if (testData.getString("RentOrOwn").equalsIgnoreCase("Own"))
                pageObjectManager.getResidenceInformationCreate().selectOwn().
                        enterYearPurchased(testData.getString("YearPurchased")).
                        enterMortgagePayment(testData.getString("MortgagePayment")).
                        enterPurchasePrice(testData.getString("PurchasePrice")).
                        selectFrequencyOwn(testData.getString("Frequency"));
            else {
                ReportPortal.stepFailWithScreenshot("Residence Information should be either Own or Rent " +
                        " instead of " + testData.getString("RentOrOwn"));
                Assertions.fail("Residence Information should be either Own or Rent " +
                        " instead of " + testData.getString("RentOrOwn"));
            }

        }
    }

    private void addContactInformation(ResultSet testData) throws SQLException, InterruptedException {
        pageObjectManager.getContactInformationCreate().
                enterHomeTelephone(testData.getString("HomeTelephone")).
                enterBusinessTelephone(testData.getString("BusinessTelephone")).
                enterExtension(testData.getString("Ext")).
                enterEmail(testData.getString("Email"));

    }

    private void addEmploymentIncome(ResultSet testData) throws SQLException, InterruptedException, IOException {
        pageObjectManager.getEmploymentAndIncomeCreate().
                enterBusinessOrEmployer(testData.getString("BusinessOrEmployer")).
                enterEmployerTelephone(testData.getString("EmployerTelephone")).
                enterAddressLine1(testData.getString("AddressLine1Employment")).
                enterAddressLine2(testData.getString("AddressLine2Employment")).
                enterCity(testData.getString("CityEmployment")).
                selectProvinceOrState(testData.getString("ProvinceEmployment")).
                selectCountry(testData.getString("CountryEmployment")).
                enterPostalOrZipcode(testData.getString("PostalEmployment")).
                selectEmploymentStatus(testData.getString("EmploymentStatus")).
                selectIndustry(testData.getString("Industry")).
                enterOccupation(testData.getString("Occupation")).
                enterLengthOfCurrentEmploymentYears(testData.getString("YearsLengthOfCurrentEmployment")).
                enterLengthOfCurrentEmploymentMonths(testData.getString("MonthsLengthOfCurrentEmployment")).
                enterLengthOfOccupationYears(testData.getString("YearsLengthOfOccupation")).
                enterLengthOfOccupationMonths(testData.getString("MonthsLenghtOfOccupation")).
                enterGrossMonthlyIncome(testData.getString("GrossMonthlyIncome")).
                enterOtherIncomeAmountPerMonth(testData.getString("OtherIncomeAmountPerMonth"));
    }

    private void addMulticulturalInformation(ResultSet testData) throws IOException, SQLException, InterruptedException {
        if (testData.getString("MulticulturalPrograms").
                equalsIgnoreCase("YES")) {
            pageObjectManager.getMultiCulturalInformationCreate().selectMultiCulturalProgramsYes().
                    enterDateOfArrival(testData.getString("DateOfArrival"));

            if (testData.getString("NotProvided").equalsIgnoreCase("Yes"))
                pageObjectManager.getMultiCulturalInformationCreate().selectNotProvided();
            pageObjectManager.getMultiCulturalInformationCreate().selectHouseHoldLanguage(testData.getString("HouseHoldingLanguage")).
                    selectSource(testData.getString("Source")).
                    selectIMMCategory(testData.getString("IMMCategory"));
        } else if (testData.getString("MulticulturalPrograms").
                equalsIgnoreCase("NO"))
            pageObjectManager.getMultiCulturalInformationCreate().
                    selectMultiCulturalProgramsNo();
        else {
            Assertions.fail("Multicultural programs should be either 'Yes' or 'No' " +
                    " but not " + testData.getString("MulticulturalPrograms"));
        }

    }

    public void createNewPersonalCustomer(ResultSet testData) throws Exception {
        pageObjectManager.getPersonalHeaderCreate().
                selectTitle(testData.getString("Title")).
                enterBirthDate(testData.getString("BirthDate")).
                enterInitials(testData.getString("Initials")).
                selectSuffix(testData.getString("Suffix"));

//      Personal Information
        addPersonalInformation(testData);
//      Tax Residency Information
        addTaxResidencyInformation(testData);

        //      Customer’s consent to Privacy Agreement
        checkCustomerConsentToPrivacyAgreement(testData);

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Personal Information");

        pageObjectManager.getPersonalInformationCreate().clickNext();


//      Address Information
        addAddressInformation(testData);

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Address Information");

        pageObjectManager.getAddressInformationPersonal().clickNext();

//      Residence Information
        addResidenceInformation(testData);

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Residence Information");

        pageObjectManager.getResidenceInformationCreate().clickNext();

//      Contact Information
        addContactInformation(testData);

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Contact Information");

        pageObjectManager.getContactInformationCreate().clickNext();

//      Identification
        addIdentification(testData);
        addCustomerId(testData);

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Identification");

        pageObjectManager.getIdentificationCreate().clickNext();

//      Employment Income
        addEmploymentIncome(testData);

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Employment and Income");

        pageObjectManager.getEmploymentAndIncomeCreate().clickNext();

// Multicultural Information
        addMulticulturalInformation(testData);

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Multicultural Information");

        pageObjectManager.getFooter().
                clickSubmit();

        pageObjectManager.getPopUps().clickSubmit().clickOk();

    }


    @And("^located personal customer with his/her details$")
    public void locatedPersonalCustomerWithHisHerDetails() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getScotiaCardOrAccount().clickPersonalCustomerName().
                enterFirstName(testData.getString("FirstName")).
                enterLastName(testData.getString("LastName"));

        pageObjectManager.getPersonalCustomerName().clickFind();

        ReportPortal.stepInfoWithScreenshot(
                "Customer Locate/ Setup -> Personal Customer Name");

        pageObjectManager.getPersonalCustomerName().clickNew();


    }


    private void addSingleMethod(String idMethod, String idOrDocumentType,
                                 String idOrRefOrAccountNumber,
                                 String expiryDate, String country,
                                 String provinceOrTerrOrState, String placeOfBirth) throws InterruptedException {
        pageObjectManager.getIdentificationCreate().
                selectIdMethod(idMethod).
                selectIdOrDocumentType(idOrDocumentType);

//        ID/ Ref/ Account Number
        pageObjectManager.getIdentificationCreate().enterIdOrRefOrAccountNumber(idOrRefOrAccountNumber);

//        Expiry date
        if (!(idOrDocumentType.equalsIgnoreCase("Certificate of Naturalization") ||
                idOrDocumentType.equalsIgnoreCase("Citizenship Card (Issued Prior to 2012)")))
            pageObjectManager.getIdentificationCreate().enterExpiryDate(expiryDate);

//        Country
        if (idOrDocumentType.equalsIgnoreCase("Foreign Driver's Licence") ||
                idOrDocumentType.equalsIgnoreCase("Foreign Passport") ||
                idOrDocumentType.equalsIgnoreCase("National Identity Card"))
            pageObjectManager.getIdentificationCreate().selectCountry(country);

//        Prov/ Terr/ State
        if (idOrDocumentType.equalsIgnoreCase("Driver's Licence Issued in Canada") ||
                idOrDocumentType.equalsIgnoreCase("Provincial Health Card") ||
                idOrDocumentType.equalsIgnoreCase("US Driver's License") ||
                idOrDocumentType.equalsIgnoreCase("US Permanent Resident Card"))
            pageObjectManager.getIdentificationCreate().selectProvOrTerrOrState(provinceOrTerrOrState);

//        Place Of Birth
        if (idOrDocumentType.equalsIgnoreCase("Canadian Passport") ||
                idOrDocumentType.equalsIgnoreCase("Passeport canadien") ||
                idOrDocumentType.equalsIgnoreCase("Foreign Passport") ||
                idOrDocumentType.equalsIgnoreCase("IMM 1442 Study Permit") ||
                idOrDocumentType.equalsIgnoreCase("IMM 1442 Temporary Resident Permit") ||
                idOrDocumentType.equalsIgnoreCase("IMM 1442 Visitor Record") ||
                idOrDocumentType.equalsIgnoreCase("IMM 1442 Work Permit") ||
                idOrDocumentType.equalsIgnoreCase("US Permanent Resident Card"))
            pageObjectManager.getIdentificationCreate().selectPlaceOfBirth(placeOfBirth);

    }

    private Boolean identificationFieldsEnableOrDisableBasedOnDocumentType(String propertyKey, String idOrDocumentType) throws Exception {
        String propertyValue = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getWebtestpropertiespath() +
                        FrameworkConstants.getIdordocumenttypepropertiespath(),
                FrameworkConstants.getDocumenttypefilename(), propertyKey);
        List<String> propertyValues = Arrays.asList(propertyValue.split("\\|"));
        return propertyValues.contains(idOrDocumentType);

    }

    //    Please provide either a piece of ID from the two pieces of IDs from the Dual Method, each being from a different category and by different issuer/source.
    private void addDualMethod(String idMethod, String idOrDocumentType,
                               String idOrDocumentSource, String idOrRefOrAccountNumber,
                               String sourceDescription, String expiryDate,
                               String provinceOrTerrOrState) throws Exception {
        pageObjectManager.getIdentificationCreate().
                selectIdMethod(idMethod).
                selectIdOrDocumentTypeForDualMethod(idOrDocumentType);

        //  Read Personal data from database
        ResultSet testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        int year = Integer.parseInt(testData.getString("BirthDate").split("-")[0]);
        int month = Integer.parseInt(testData.getString("BirthDate").split("-")[1]);
        int date = Integer.parseInt(testData.getString("BirthDate").split("-")[2]);
        if (calculateAge(LocalDate.of(year, month, date), LocalDate.now()) >= 12) {
            if (identificationFieldsEnableOrDisableBasedOnDocumentType("documentSourceEnable.documentType.ageGreaterThanEqualTo12.english", idOrDocumentType))
                pageObjectManager.getIdentificationCreate().selectIdOrDocumentSource(idOrDocumentSource);

            pageObjectManager.getIdentificationCreate().enterIdOrRefOrAccountNumber(idOrRefOrAccountNumber);

            if (identificationFieldsEnableOrDisableBasedOnDocumentType("sourceDescription.documentType.ageGreaterThanEqualTo12.english", idOrDocumentType))
                pageObjectManager.getIdentificationCreate().enterSourceDescription(sourceDescription);

            if (identificationFieldsEnableOrDisableBasedOnDocumentType("expiryDateEnable.documentType.ageGreaterThanEqualTo12.english", idOrDocumentType))
                pageObjectManager.getIdentificationCreate().enterExpiryDate(expiryDate);

            if (identificationFieldsEnableOrDisableBasedOnDocumentType("provinceOrTerrOrStateEnable.documentType.ageGreaterThanEqualTo12.english", idOrDocumentType))
                pageObjectManager.getIdentificationCreate().selectProvOrTerrOrState(provinceOrTerrOrState);


        } else if (calculateAge(LocalDate.of(year, month, date), LocalDate.now()) < 12) {
            String language = pageObjectManager.getIntralinkHeader().getLanguage();
            if (language.equals("EN") ?
                    identificationFieldsEnableOrDisableBasedOnDocumentType("documentSourceEnable.documentType.ageLessThan12.english", idOrDocumentType)
                    : identificationFieldsEnableOrDisableBasedOnDocumentType("documentSourceEnable.documentType.ageLessThan12.french", idOrDocumentType))
                pageObjectManager.getIdentificationCreate().selectIdOrDocumentSource(idOrDocumentSource);

            pageObjectManager.getIdentificationCreate().enterIdOrRefOrAccountNumber(idOrRefOrAccountNumber);


            if (language.equals("EN") ?
                    identificationFieldsEnableOrDisableBasedOnDocumentType("sourceDescription.documentType.ageLessThan12.english", idOrDocumentType)
                    : identificationFieldsEnableOrDisableBasedOnDocumentType("sourceDescription.documentType.ageLessThan12.french", idOrDocumentType))
                pageObjectManager.getIdentificationCreate().enterSourceDescription(sourceDescription);

//            Expiry date is disbale for all Document Types

            if (language.equals("EN") ?
                    identificationFieldsEnableOrDisableBasedOnDocumentType("provinceOrTerrOrStateEnable.documentType.ageLessThan12.english", idOrDocumentType)
                    : identificationFieldsEnableOrDisableBasedOnDocumentType("provinceOrTerrOrStateEnable.documentType.ageLessThan12.french", idOrDocumentType))
                pageObjectManager.getIdentificationCreate().selectProvOrTerrOrState(provinceOrTerrOrState);

            //  Place of birth is disbale for all Document Types


        }

    }


    private void abbsAgeGreaterThanOrEqualTo16(String idOrDocumentType, String idDescription,
                                               String idOrRefOrAccountNumber, String expiryDate,
                                               String country, String provinceOrTerrOrState,
                                               String placeOfBirth) throws Exception {

        pageObjectManager.getIdentificationCreate().
                selectIdOrDocumentType(idOrDocumentType);

//        ID Description
        String language = pageObjectManager.getIntralinkHeader().getLanguage();
        if (language.equals("EN") ? identificationFieldsEnableOrDisableBasedOnDocumentType("idDescriptionEnable.documentType.abbs.ageGreaterThan16.english", idOrDocumentType)
                : identificationFieldsEnableOrDisableBasedOnDocumentType("idDescriptionEnable.documentType.abbs.ageGreaterThan16.french", idOrDocumentType))
            pageObjectManager.getIdentificationCreate().enterIdDescription(idDescription);

        //       ID/ Ref/ Account Number
        if (language.equals("EN") ? identificationFieldsEnableOrDisableBasedOnDocumentType("idOrRefOrAccountNumberEnable.documentType.abbs.ageGreaterThan16.english", idOrDocumentType)
                : identificationFieldsEnableOrDisableBasedOnDocumentType("idOrRefOrAccountNumberEnable.documentType.abbs.ageGreaterThan16.french", idOrDocumentType))
            pageObjectManager.getIdentificationCreate().enterIdOrRefOrAccountNumber(idOrRefOrAccountNumber);

//        Expiry date
        if (language.equals("EN") ? identificationFieldsEnableOrDisableBasedOnDocumentType("expiryDateEnable.documentType.abbs.ageGreaterThan16.english", idOrDocumentType)
                : identificationFieldsEnableOrDisableBasedOnDocumentType("expiryDateEnable.documentType.abbs.ageGreaterThan16.french", idOrDocumentType))
            pageObjectManager.getIdentificationCreate().enterExpiryDate(expiryDate);

        //        Expiry date
        if (language.equals("EN") ? identificationFieldsEnableOrDisableBasedOnDocumentType("countryEnable.documentType.abbs.ageGreaterThan16.english", idOrDocumentType)
                : identificationFieldsEnableOrDisableBasedOnDocumentType("countryEnable.documentType.abbs.ageGreaterThan16.french", idOrDocumentType))
            pageObjectManager.getIdentificationCreate().selectCountry(country);

        //       Prov/ Terr/ State
        if (language.equals("EN") ? identificationFieldsEnableOrDisableBasedOnDocumentType("provinceOrTerrOrStateEnable.documentType.abbs.ageGreaterThan16.english", idOrDocumentType)
                : identificationFieldsEnableOrDisableBasedOnDocumentType("provinceOrTerrOrStateEnable.documentType.abbs.ageGreaterThan16.french", idOrDocumentType))
            pageObjectManager.getIdentificationCreate().selectProvOrTerrOrState(provinceOrTerrOrState);

        //       Place Of Birth
        if (language.equals("EN") ? identificationFieldsEnableOrDisableBasedOnDocumentType("placeOfBirthEnable.documentType.abbs.ageGreaterThan16.english", idOrDocumentType)
                : identificationFieldsEnableOrDisableBasedOnDocumentType("placeOfBirthEnable.documentType.abbs.ageGreaterThan16.french", idOrDocumentType))
            pageObjectManager.getIdentificationCreate().selectPlaceOfBirth(placeOfBirth);
    }

    private void locateParentOrGuardian(ResultSet testData) throws SQLException {
        stepDefinitionManager.getInvolvedParty().involvedPartySetupForParentOrGuardian(testData);
    }

    private void addIdentification(ResultSet testData) throws SQLException {
        // Check/Uncheck checkbox for Customer present
        if (testData.getString("CustomerPresent").
                equalsIgnoreCase("NO"))
            pageObjectManager.getIdentificationCreate().
                    selectCustomerPresent();

        // It will only enter if customer Id status is greater than equal to 16 years old or ABBS
        if (!testData.getString("CustomerIdStatus").equals("")) {
            pageObjectManager.getIdentificationCreate().
                    selectCustomerIdStatus(testData.getString("CustomerIdStatus"));
        } else {
//            CustomerIdStatus - Customers 12-15 years old
            String minorProfileEstablishedBy = testData.getString("MinorProfileEstablishedBy");
            if (minorProfileEstablishedBy.
                    equalsIgnoreCase("Parent")) {
                pageObjectManager.getIdentificationCreate().selectParent();
            } else if (minorProfileEstablishedBy.
                    equalsIgnoreCase("Guardian")) {
                pageObjectManager.getIdentificationCreate().selectGuardian();
            } else if (minorProfileEstablishedBy.
                    equalsIgnoreCase("Minor")) {
                pageObjectManager.getIdentificationCreate().selectMinor();
            } else {
                ReportPortal.stepFailWithScreenshot("Minor Profile Established by should be either " +
                        " 'Parent/Guardian/Minor' but not " + minorProfileEstablishedBy);

                Assertions.fail("Minor Profile Established by should be either " +
                        " 'Parent/Guardian/Minor' but not " + minorProfileEstablishedBy);
            }

            // Will minors be signing authority - Yes/No - This field present only for Parent and Guardian
            if (minorProfileEstablishedBy.
                    equalsIgnoreCase("Parent") ||
                    minorProfileEstablishedBy.
                            equalsIgnoreCase("Guardian")) {
                String willMinorBeASigningAuthority = testData.getString("WillMinorBeASigningAuthority");

                if (willMinorBeASigningAuthority.equalsIgnoreCase("Yes")) {
                    pageObjectManager.getIdentificationCreate().selectWillMinorBeASigningAuthorityYes();
                } else if (willMinorBeASigningAuthority.equalsIgnoreCase("No")) {
                    pageObjectManager.getIdentificationCreate().selectWillMinorBeASigningAuthorityNo();
                } else {
                    ReportPortal.stepFailWithScreenshot("Will minors be signing Authority should be either Yes or No" +
                            " for Parent/Guardian instead of " + willMinorBeASigningAuthority);

                    Assertions.fail("Will minors be signing Authority should be either Yes or No" +
                            " for Parent/Guardian instead of " + willMinorBeASigningAuthority);
                }
            }
        }


    }

    private void addCustomerId(String idMethod, String idOrDocumentType,
                               String idOrDocumentSource, String sourceDescription,
                               String iDDescription, String idOrRefOrAccountNumber,
                               String expiryDate, String country,
                               String provOrTerrOrState, String placeOfBirth) throws Exception {

        if (idMethod.equalsIgnoreCase("Single Method")
                || idMethod.equalsIgnoreCase("Méthode unique")) {
            addSingleMethod(idMethod, idOrDocumentType,
                    idOrRefOrAccountNumber, expiryDate,
                    country, provOrTerrOrState, placeOfBirth);
        } else if (idMethod.equalsIgnoreCase("Dual Method")
                || idMethod.equalsIgnoreCase("Méthode double")) {
            addDualMethod(idMethod, idOrDocumentType,
                    idOrDocumentSource, idOrRefOrAccountNumber,
                    sourceDescription, expiryDate,
                    provOrTerrOrState);
        } else {
            ReportPortal.stepFailWithScreenshot("ID method should be either Single or Dual but not"
                    + idMethod);

            Assertions.fail("ID method should be either Single or Dual but not"
                    + idMethod);
        }

        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
//             Locate Parent/Guardian when document type is P/G
        if (idOrDocumentType.contains("P/G")) {
            if (testData.getString("InvolvedPartyTable").equalsIgnoreCase("Yes")) {
                //  Read Personal data from database
                ResultSet testDataInvolvedParty = TestDataDB.getInstance().getData(
                        TestDataQueries.getInstance().
                                getTableName("INVOLVEDPARTY",
                                        scenarioContext.getScenarioId()));
                locateParentOrGuardian(testDataInvolvedParty);
            } else {
                ReportPortal.stepFailWithScreenshot("In Personal customer table column Name InvolvedPartyTable should be 'Yes'" +
                        " instead of " + testData.getString("InvolvedPartyTable"));

                Assertions.fail("In Personal customer table column Name InvolvedPartyTable should be 'Yes'" +
                        " instead of " + testData.getString("InvolvedPartyTable"));
            }

        }
        pageObjectManager.getIdentificationCreate().clickAdd();


    }


    private void addCustomerId(ResultSet testData) throws Exception {
        String[] idMethods = testData.getString("IDMethod").split("\\|");
        String[] idOrDocumentTypes = testData.getString("IDOrDocumentType").split("\\|");
        String[] idOrDocumentSources = testData.getString("IDOrDocumentSource").split("\\|");
        String[] sourceDescriptions = testData.getString("SourceDescription").split("\\|");
        String[] iDDescription = testData.getString("IDDescription").split("\\|");
        String[] idOrRefOrAccountNumbers = testData.getString("IDOrRefOrAccountNumber").split("\\|");
        String[] expiryDates = testData.getString("ExpiryDate").split("\\|");
        String[] countries = testData.getString("Country").split("\\|");
        String[] provOrTerrOrStates = testData.getString("ProvOrTerrOrState").split("\\|");
        String[] placeOfBirths = testData.getString("PlaceOfBirth").split("\\|");
        if (pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Customers >= 16 years old")
                || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Client âgé de 16 ans ou plus")
                || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Customers < 12 years old")
                || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Client âgé de moins de 12 ans")
                || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Customers 12-15 years old")) {
            for (int ids = 0; ids < idMethods.length; ids++) {
                addCustomerId(idMethods[ids], idOrDocumentTypes[ids],
                        idOrDocumentSources[ids], sourceDescriptions[ids],
                        iDDescription[ids], idOrRefOrAccountNumbers[ids],
                        expiryDates[ids], countries[ids], provOrTerrOrStates[ids],
                        placeOfBirths[ids]);
            }
        } else if (pageObjectManager.getIdentificationCreate().getCustomerIdStatus().
                equalsIgnoreCase("Customers >=16 years old (ABBS)")
                || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().
                equalsIgnoreCase("Client âgé de 16 ans ou plus (ASBB)")) {

            for (int idTypes = 0; idTypes < idOrDocumentTypes.length; idTypes++) {
                abbsAgeGreaterThanOrEqualTo16(idOrDocumentTypes[idTypes], iDDescription[idTypes],
                        idOrRefOrAccountNumbers[idTypes], expiryDates[idTypes], countries[idTypes],
                        provOrTerrOrStates[idTypes], placeOfBirths[idTypes]);

                pageObjectManager.getIdentificationCreate().clickAdd();

            }

        }

    }


    private void updateCustomerId(ResultSet testData) throws Exception {
        // check customer id present in Summary of Customer Id, If exists update else add new Id to customer
        String[] idMethods = testData.getString("IDMethod").split("\\|");
        String[] idOrDocumentTypes = testData.getString("IDOrDocumentType").split("\\|");
        String[] idOrDocumentSources = testData.getString("IDOrDocumentSource").split("\\|");
        String[] sourceDescriptions = testData.getString("SourceDescription").split("\\|");
        String[] iDDescription = testData.getString("IDDescription").split("\\|");
        String[] idOrRefOrAccountNumbers = testData.getString("IDOrRefOrAccountNumber").split("\\|");
        String[] expiryDates = testData.getString("ExpiryDate").split("\\|");
        String[] countries = testData.getString("Country").split("\\|");
        String[] provOrTerrOrStates = testData.getString("ProvOrTerrOrState").split("\\|");
        String[] placeOfBirths = testData.getString("PlaceOfBirth").split("\\|");
        for (int ids = 0; ids < idMethods.length; ids++) {
            if (pageObjectManager.getIdentificationUpdate().isCustomerIdExists(idOrDocumentTypes[ids])) {
                pageObjectManager.getIdentificationUpdate().clickCustomerId(idOrDocumentTypes[ids]);
                pageObjectManager.getIdentificationUpdate().clickUpdateExistingId();
                if (!idOrRefOrAccountNumbers[ids].equals(""))
                    pageObjectManager.getIdentificationUpdate().enterIdOrRefOrAccountNumberExistingId(idOrRefOrAccountNumbers[ids]);
                if (!expiryDates[ids].equals(""))
                    pageObjectManager.getIdentificationUpdate().enterExpiryDateExistingId(expiryDates[ids]);
                if (!placeOfBirths[ids].equals(""))
                    pageObjectManager.getIdentificationUpdate().selectPlaceOfBirthExistingId(placeOfBirths[ids]);

                pageObjectManager.getIdentificationUpdate().clickConfirm();
//                pageObjectManager.getIdentificationUpdate().clickOk();
            } else {
                if (pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Customers >= 16 years old")
                        || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Client âgé de 16 ans ou plus")
                        || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Customers < 12 years old")
                        || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().equals("Client âgé de moins de 12 ans")) {
                    addCustomerId(idMethods[ids], idOrDocumentTypes[ids],
                            idOrDocumentSources[ids], sourceDescriptions[ids],
                            iDDescription[ids], idOrRefOrAccountNumbers[ids],
                            expiryDates[ids], countries[ids], provOrTerrOrStates[ids],
                            placeOfBirths[ids]);
                } else if (pageObjectManager.getIdentificationCreate().getCustomerIdStatus().
                        equalsIgnoreCase("Customers >=16 years old (ABBS)")
                        || pageObjectManager.getIdentificationCreate().getCustomerIdStatus().
                        equalsIgnoreCase("Client âgé de 16 ans ou plus (ASBB)")) {
                    for (int idTypes = 0; ids < idOrDocumentTypes.length; idTypes++) {
                        abbsAgeGreaterThanOrEqualTo16(idOrDocumentTypes[idTypes], iDDescription[idTypes],
                                idOrRefOrAccountNumbers[idTypes], expiryDates[idTypes], countries[idTypes],
                                provOrTerrOrStates[idTypes], placeOfBirths[idTypes]);

                        pageObjectManager.getIdentificationCreate().clickAdd();

                    }
                }
            }
        }
    }

    @And("^created new personal customer$")
    public void createdNewPersonalCustomer() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        stepDefinitionManager.getPersonalCustomer().createNewPersonalCustomer(testData);

//        Waits till customer sales and services displays
        pageObjectManager.getCustomerSelection().getCustomerSalesAndServicePage();

        ReportPortal.stepInfoWithScreenshot(
                "Page--> Customer Sales and Service");

    }

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    @Then("^captured created personal customer CID$")
    public void capturedCreatedPersonalCustomerCID() throws Exception {
        //  Read Personal data from database
        ResultSet personalTestData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        pageObjectManager.getCustomerSelection().clickCustomer(
                personalTestData.getString("Title").toUpperCase() + " " +
                        personalTestData.getString("FirstName") + " " +
                        personalTestData.getString("LastName"), "Name");

        String cid = pageObjectManager.getHeaderNonPersonal().getCID().trim();
        //            Update Personal CID in Personal database table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "CIDPersonal", cid));

        ReportPortal.stepPassWithScreenshot("Customer created successfully - CID is " + cid);

        pageObjectManager.getFooter().clickDone();

    }


    @And("^updated personal customer details$")
    public void updatedPersonalCustomerDetails() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

//        Customer Name
        pageObjectManager.getProductsAndServicesPersonal().clickCustomerInformation().clickCustomerName().clickUpdate();
        if (!testData.getString("Title").equals(""))
            pageObjectManager.getCustomerNamePersonal().selectTitle(testData.getString("Title"));

        if (!testData.getString("FirstName").equals(""))
            pageObjectManager.getCustomerNamePersonal().enterFirstName(testData.getString("FirstName"));

        if (!testData.getString("LastName").equals(""))
            pageObjectManager.getCustomerNamePersonal().enterLastName(testData.getString("LastName"));

        if (!testData.getString("BirthDate").equals("")) {
            pageObjectManager.getCustomerNamePersonal().enterBirthDate(testData.getString("BirthDate"));
            pageObjectManager.getCustomerNamePersonal().clickOk();
        }

        if (!testData.getString("Initials").equals(""))
            pageObjectManager.getCustomerNamePersonal().enterInitials(testData.getString("Initials"));

        if (!testData.getString("Suffix").equals(""))
            pageObjectManager.getCustomerNamePersonal().selectSuffix(testData.getString("Suffix"));

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Customer Name");

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getFooter().clickCancel();
        pageObjectManager.getCustomerNamePersonal().clickNext();

//        Personal Information
        pageObjectManager.getPersonalInformationUpdate().clickUpdate();
        if (!testData.getString("SocialInsuranceNumber").equals(""))
            pageObjectManager.getPersonalInformationUpdate().enterSocialInsuranceNumber(testData.getString("SocialInsuranceNumber"));

        if (!testData.getString("ProfileStatus").equals(""))
            pageObjectManager.getPersonalInformationUpdate().selectProfileStatus(testData.getString("ProfileStatus"));

        if (!testData.getString("Gender").equals(""))
            pageObjectManager.getPersonalInformationUpdate().selectGender(testData.getString("Gender"));

        if (!testData.getString("NumberOfDependents").equals(""))
            pageObjectManager.getPersonalInformationUpdate().enterNumberOfDependents(testData.getString("NumberOfDependents"));

        if (!testData.getString("BankruptcyDate").equals(""))
            pageObjectManager.getPersonalInformationUpdate().enterBankruptcyDate(testData.getString("BankruptcyDate"));

        if (!testData.getString("DateDeceased").equals(""))
            pageObjectManager.getPersonalInformationUpdate().enterDateDeceasedDate(testData.getString("DateDeceased"));

        if (!testData.getString("LanguageChoice").equals(""))
            pageObjectManager.getPersonalInformationUpdate().selectLanguageChoice(testData.getString("LanguageChoice"));

        if (!testData.getString("MaritalStatus").equals(""))
            pageObjectManager.getPersonalInformationUpdate().selectMaritalStatus(testData.getString("MaritalStatus"));

        if (!testData.getString("Transit").equals(""))
            pageObjectManager.getPersonalInformationUpdate().enterTransit(testData.getString("Transit"));

        if (!testData.getString("SensitivityCode").equals(""))
            pageObjectManager.getPersonalInformationUpdate().selectSensitivityCode(testData.getString("SensitivityCode"));

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Personal Information");

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getPersonalInformationUpdate().clickNext();

//        Address Information - Residential Address
        pageObjectManager.getAddressInformationUpdate().clickUpdateAddressInformation();
        if (!testData.getString("AddressTypeResidential").equals(""))
            pageObjectManager.getAddressInformationUpdate().selectAddressTypeResidntialType(testData.getString("AddressTypeResidential"));

        if (!testData.getString("AddressLine1Residential").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterAddressLine1ResidntialType(testData.getString("AddressLine1Residential"));

        if (!testData.getString("AddressLine2Residential").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterAddressLine2ResidntialType(testData.getString("AddressLine2Residential"));

        if (!testData.getString("CityResidential").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterCityResidntialType(testData.getString("CityResidential"));

        if (!testData.getString("ProvinceResidential").equals(""))
            pageObjectManager.getAddressInformationUpdate().selectProvinceOrStateResidntialType(testData.getString("ProvinceResidential"));

        if (!testData.getString("CountryResidential").equals(""))
            pageObjectManager.getAddressInformationUpdate().selectCountryResidntialType(testData.getString("CountryResidential"));

        if (!testData.getString("PostalResidential").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterPostalOrZipcodeResidntialType(testData.getString("PostalResidential"));

        if (!testData.getString("YearsTimeAtAddress").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterTimeAtAddressYears(testData.getString("YearsTimeAtAddress"));

        if (!testData.getString("MonthsTimeAtAddress").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterTimeAtAddressMonths(testData.getString("MonthsTimeAtAddress"));

        // Mailing Address
        if (testData.getString("MailingAddress").
                equalsIgnoreCase("YES") &&
                Boolean.parseBoolean(pageObjectManager.getAddressInformationPersonal().isMailingAddressIsSameAsResidentialAddressChecked("value"))) {
            pageObjectManager.getAddressInformationPersonal().
                    selectMailingAddressIsSameAsResidentialAddress();
        }
        if (!testData.getString("AddressTypeMailing").equals(""))
            pageObjectManager.getAddressInformationUpdate().selectAddressTypeProfileMailingAddress(testData.getString("AddressTypeMailing"));

        if (!testData.getString("AddressLine1Mailing").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterAddressLine1ProfileMailingAddress(testData.getString("AddressLine1Mailing"));

        if (!testData.getString("AddressLine2Mailing").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterAddressLine2ProfileMailingAddress(testData.getString("AddressLine2Mailing"));

        if (!testData.getString("CityMailing").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterCityProfileMailingAddress(testData.getString("CityMailing"));

        if (!testData.getString("ProvinceMailing").equals(""))
            pageObjectManager.getAddressInformationUpdate().selectProvinceOrStateProfileMailingAddress(testData.getString("ProvinceMailing"));

        if (!testData.getString("CountryMailing").equals(""))
            pageObjectManager.getAddressInformationUpdate().selectCountryProfileMailingAddress(testData.getString("CountryMailing"));

        if (!testData.getString("PostalMailing").equals(""))
            pageObjectManager.getAddressInformationUpdate().enterPostalOrZipcodeProfileMailingAddress(testData.getString("PostalMailing"));

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Address Information");

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getPopUps().clickSubmit();
        pageObjectManager.getAddressInformationUpdate().clickNext();

        // Residence Information
        pageObjectManager.getResidenceInformationUpdate().clickUpdate();
        if (testData.getString("RentOrOwn").equalsIgnoreCase("Rent")) {
            pageObjectManager.getResidenceInformationUpdate().selectRent();
            if (!testData.getString("RentalType").equals(""))
                pageObjectManager.getResidenceInformationUpdate().selectRentalType(testData.getString("RentalType"));

            if (!testData.getString("RentalAmount").equals(""))
                pageObjectManager.getResidenceInformationUpdate().enterRentalAmount(testData.getString("RentalAmount"));

            if (!testData.getString("Frequency").equals(""))
                pageObjectManager.getResidenceInformationUpdate().selectFrequencyRent(testData.getString("Frequency"));

        } else if (testData.getString("RentOrOwn").equalsIgnoreCase("Own")) {
            pageObjectManager.getResidenceInformationUpdate().selectOwn();
            if (!testData.getString("YearPurchased").equals(""))
                pageObjectManager.getResidenceInformationUpdate().enterYearPurchased(testData.getString("YearPurchased"));

            if (!testData.getString("MortgagePayment").equals(""))
                pageObjectManager.getResidenceInformationUpdate().enterMortgagePayment(testData.getString("MortgagePayment"));

            if (!testData.getString("PurchasePrice").equals(""))
                pageObjectManager.getResidenceInformationUpdate().enterPurchasePrice(testData.getString("PurchasePrice"));

            if (!testData.getString("Frequency").equals(""))
                pageObjectManager.getResidenceInformationUpdate().selectFrequencyOwn(testData.getString("Frequency"));

        }

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Residence Information");

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getResidenceInformationUpdate().clickNext();

//        Contact Information
        pageObjectManager.getContactInformationUpdate().clickUpdate();
        if (!testData.getString("HomeTelephone").equals(""))
            pageObjectManager.getContactInformationUpdate().enterHomeTelephone(testData.getString("HomeTelephone"));

        if (!testData.getString("BusinessTelephone").equals(""))
            pageObjectManager.getContactInformationUpdate().enterBusinessTelephone(testData.getString("BusinessTelephone"));

        if (!testData.getString("Ext").equals(""))
            pageObjectManager.getContactInformationUpdate().enterExtension(testData.getString("Ext"));

        if (!testData.getString("Email").equals(""))
            pageObjectManager.getContactInformationUpdate().enterEmail(testData.getString("Email"));

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Contact Information");

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getContactInformationUpdate().clickNext();

/*
//        Mother's Maiden Name
        pageObjectManager.getMothersMaidenName().clickUpdate();
        if (!testData.getString("CardNumber").equals(""))
            pageObjectManager.getMothersMaidenName().selectCardNumber(testData.getString("CardNumber"));

        if (!testData.getString("PrimaryOrSoleMothersMaidenName").equals(""))
            pageObjectManager.getMothersMaidenName().enterPrimaryOrSoleMothersMaidenName(testData.getString("PrimaryOrSoleMothersMaidenName"));


        pageObjectManager.getMothersMaidenName().clickVerify();
*/

//        Identification
        pageObjectManager.getIdentificationUpdate().clickUpdatePage();
        updateCustomerId(testData);

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Identification");

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getIdentificationUpdate().clickNext();

//        Employment and Income
        pageObjectManager.getEmploymentAndIncomeUpdate().clickUpdate();
        if (!testData.getString("BusinessOrEmployer").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterBusinessOrEmployer(testData.getString("BusinessOrEmployer"));

        if (!testData.getString("EmployerTelephone").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterEmployerTelephone(testData.getString("EmployerTelephone"));

        if (!testData.getString("AddressLine1Employment").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterAddressLine1(testData.getString("AddressLine1Employment"));

        if (!testData.getString("AddressLine2Employment").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterAddressLine2(testData.getString("AddressLine2Employment"));

        if (!testData.getString("CityEmployment").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterCity(testData.getString("CityEmployment"));

        if (!testData.getString("ProvinceEmployment").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().selectProvinceOrState(testData.getString("ProvinceEmployment"));

        if (!testData.getString("CountryEmployment").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().selectCountry(testData.getString("CountryEmployment"));

        if (!testData.getString("PostalEmployment").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterPostalOrZipcode(testData.getString("PostalEmployment"));

        if (!testData.getString("EmploymentStatus").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().selectEmploymentStatus(testData.getString("EmploymentStatus"));

        if (!testData.getString("Industry").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().selectIndustry(testData.getString("Industry"));

        if (!testData.getString("Occupation").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterOccupation(testData.getString("Occupation"));

        if (!testData.getString("YearsLengthOfCurrentEmployment").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterLengthOfCurrentEmploymentYears(testData.getString("YearsLengthOfCurrentEmployment"));

        if (!testData.getString("MonthsLengthOfCurrentEmployment").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterLengthOfCurrentEmploymentMonths(testData.getString("MonthsLengthOfCurrentEmployment"));

        if (!testData.getString("YearsLengthOfOccupation").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterLengthOfOccupationYears(testData.getString("YearsLengthOfOccupation"));

        if (!testData.getString("MonthsLenghtOfOccupation").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterLengthOfOccupationMonths(testData.getString("MonthsLenghtOfOccupation"));

        if (!testData.getString("GrossMonthlyIncome").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterGrossMonthlyIncome(testData.getString("GrossMonthlyIncome"));

        if (!testData.getString("OtherIncomeAmountPerMonth").equals(""))
            pageObjectManager.getEmploymentAndIncomeUpdate().enterOtherIncomeAmountPerMonth(testData.getString("OtherIncomeAmountPerMonth"));

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Employment and Income");

        pageObjectManager.getFooter().clickUpdate();
        if (pageObjectManager.getReviewProfile().getPageTitle().equals("KYC Refresh")) {
            // Review Profile
            pageObjectManager.getReviewProfile().waitForPageLoad();
            pageObjectManager.getFooter().clickContinue();

            // Review Residential Address
            pageObjectManager.getReviewResidentialAddress().waitForPageLoad();
            pageObjectManager.getFooter().clickContinue();

            // Review Employment Information
            pageObjectManager.getReviewEmploymentInformation().waitForPageLoad();
            pageObjectManager.getFooter().clickContinue();

            // Review Account Intended Use Information
            pageObjectManager.getReviewAccountIntendedUseInformation().waitForPageLoad();
            pageObjectManager.getFooter().clickFinish();
            pageObjectManager.getPopUps().clickOk();
        }

        //        Multicultural Information
        pageObjectManager.getMulticulturalInformationUpdate().clickMulticulturalInformation();

        pageObjectManager.getMulticulturalInformationUpdate().clickUpdate();
        if (testData.getString("MulticulturalPrograms").equalsIgnoreCase("Yes")) {

            if (!Boolean.parseBoolean(pageObjectManager.getMulticulturalInformationUpdate().
                    isMultiCulturalProgramYesChecked("value"))) {
                pageObjectManager.getMulticulturalInformationUpdate().selectMultiCulturalProgramsYes();
            }


            if (!testData.getString("DateOfArrival").equals(""))
                pageObjectManager.getMulticulturalInformationUpdate().enterDateOfArrival(testData.getString("DateOfArrival"));

            if (testData.getString("NotProvided").equalsIgnoreCase("No"))
                pageObjectManager.getMulticulturalInformationUpdate().selectNotProvided();


            if (!testData.getString("HouseHoldingLanguage").equals(""))
                pageObjectManager.getMulticulturalInformationUpdate().selectHouseHoldLanguage(testData.getString("HouseHoldingLanguage"));

            if (!testData.getString("Source").equals(""))
                pageObjectManager.getMulticulturalInformationUpdate().selectSource(testData.getString("Source"));

            if (!testData.getString("IMMCategory").equals(""))
                pageObjectManager.getMulticulturalInformationUpdate().selectIMMCategory(testData.getString("IMMCategory"));
        }

        ReportPortal.stepInfoWithScreenshot(
                "Customer Information -> Multicultural Information");

        pageObjectManager.getFooter().clickUpdate();
        pageObjectManager.getFooter().clickDone();

    }

    @Then("^verified personal customer information$")
    public void verifiedPersonalCustomerInformation() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        /*pageObjectManager.getCustomerSelection().clickCustomer(
                testData.getString("Title").toUpperCase() + " " +
                        testData.getString("FirstName") + " " +
                        testData.getString("LastName"), "Name");*/
        String cid = testData.getString("CIDPersonal");
        pageObjectManager.getCustomerSelection().clickCustomer(cid, "CID");
        pageObjectManager.getProductsAndServicesPersonal().clickCustomerInformation().clickAddressInformation();

//        Address Information - Residential Address
        if (!testData.getString("YearsTimeAtAddress").equals("")) {
            int timeAtAddressYearsActual = Integer.parseInt(pageObjectManager.getAddressInformationInquiry().getTimeAtAddressYears().split("Years")[0].trim());
            int timeAtAddressYearsExpected = Integer.parseInt(testData.getString("YearsTimeAtAddress").trim());
            if (timeAtAddressYearsActual == timeAtAddressYearsExpected) {
                ReportPortal.stepPass("Address Information - Time at Address -Years is as expected " +
                        " Years Time at Address:- " + timeAtAddressYearsActual);
            } else {
                ReportPortal.stepFailWithOutScreenshot("Address Information - Time at Address -Years is not as expected " +
                        " Actual Years Time at address:- " + timeAtAddressYearsActual +
                        " Expected Years Time at address:- " + timeAtAddressYearsExpected);
            }
        }


        if (!testData.getString("MonthsTimeAtAddress").equals("")) {
            int timeAtAddressMonthsActual = Integer.parseInt(pageObjectManager.getAddressInformationInquiry().getTimeAtAddressMonths().split("Years")[1].split("Months")[0].trim());
            int timeAtAddressMonthsExpected = Integer.parseInt(testData.getString("MonthsTimeAtAddress").trim());
            if (timeAtAddressMonthsActual == timeAtAddressMonthsExpected) {
                ReportPortal.stepPass("Address Information - Time at Address -Months is as expected " +
                        " Months Time at Address:- " + timeAtAddressMonthsActual);
            } else {
                ReportPortal.stepFailWithOutScreenshot("Address Information - Time at Address -Months is not as expected " +
                        " Actual Months Time at address:- " + timeAtAddressMonthsActual +
                        " Expected Months Time at address:- " + timeAtAddressMonthsExpected);
            }
        }

    }

    @And("^get \"([^\"]*)\" \"([^\"]*)\" to \"([^\"]*)\"$")
    public void getTo(String sourceTable, String columnName, String targetTable) throws Throwable {
        //  Read data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(sourceTable,
                                scenarioContext.getScenarioId()));

        String referenceScenarioId = testData.getString("ReferenceScenarioId");
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(targetTable,
                                referenceScenarioId));

        // Update query in database table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(sourceTable, scenarioContext.getScenarioId(),
                                columnName, testData.getString(columnName)));
    }


    @And("^get referenceId from \"([^\"]*)\" and retrieve \"([^\"]*)\" \"([^\"]*)\" to \"([^\"]*)\"$")
    public void getReferenceIdFromAndRetrieveTo(String mainTable, String sourceTable, String columnName, String targetTable) throws Throwable {
        ResultSet main = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(mainTable,
                                scenarioContext.getScenarioId()));

        String referenceScenarioId = main.getString("ReferenceScenarioId");

        ResultSet source = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(sourceTable,
                                referenceScenarioId));
        String columnValue = source.getString(columnName);

        // Update query in database table
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(targetTable, scenarioContext.getScenarioId(),
                                columnName, columnValue));
    }


    @And("^verifed customer$")
    public void verifedCustomer() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        String cid = testData.getString("CIDPersonal");
        pageObjectManager.getCustomerSelection().clickCustomer(cid, "CID");


        pageObjectManager.getProductsAndServicesPersonal().clickCustomerInformation().
                clickIdentification().
                clickUpdatePage().clickCustomerVerified();

        pageObjectManager.getFooter().clickUpdate().clickDone();
    }

    @And("^located customer with account number in customer locate/setup$")
    public void locatedCustomerWithAccountNumberInCustomerLocateSetup() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        pageObjectManager.getScotiaCardOrAccount().selectProduct(testData.getString("Product"))
                .enterAccountOrCardNumber(testData.getString("AccountOrCardNumber")).clickFind();

        ReportPortal.stepInfoWithScreenshot("Customer Locate/ Setup --> Search by Product & Account/Card Number");
    }

    @And("^located customer with scotiacard in customer locate/setup$")
    public void locatedCustomerWithScotiacardInCustomerLocateSetup() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

    }

    @Then("^officer verified personal customer located successfully$")
    public void officerVerifiedPersonalCustomerLocatedSuccessfully() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        String cid = pageObjectManager.getPersonalHeaderUpdate().getCID().trim();
//        get customer name from API
        String customerNameAPI = null;
        String customerNameGUI = pageObjectManager.getPersonalHeaderUpdate().getCustomerName();

        if (cid.equals(testData.getString("CIDPersonal"))) {
            ReportPortal.stepPassWithScreenshot("Personal Customer CID is expected Customer CID:- " + cid);
        } else {
            ReportPortal.stepFailWithScreenshot("Personal Customer CID is not as expected Actual Customer CID:- " + cid +
                    " Expected CID:-  " + testData.getString("CIDPersonal"));
            Assertions.fail("Personal Customer CID is not as expected Actual Customer CID:- " + cid +
                    " Expected CID:-  " + testData.getString("CIDPersonal"));
        }

        if (customerNameGUI.equals(customerNameAPI)) {

        } else {

        }
    }


    @Then("^verified customer preferences page launched$")
    public void verifiedCustomerPreferencesPageLaunched() {
        String preferecesPageTitleActual = pageObjectManager.getCustomerPreferences().getTitle();
        if (preferecesPageTitleActual.equals("Customer Preferences")) {
            ReportPortal.stepPassWithScreenshot("Customer Preferences page is displayed as expected" +
                    "Page Title:- " + preferecesPageTitleActual);
        } else {
            ReportPortal.stepFailWithScreenshot("Customer Preferences page is not displayed" +
                    " Actual Page Title:- " + preferecesPageTitleActual +
                    " Expected Page Title:- 'Customer Preferences'");

            Assertions.fail("Customer Preferences page is not displayed" +
                    " Actual Page Title:- " + preferecesPageTitleActual +
                    " Expected Page Title:- 'Customer Preferences'");
        }
        //   It close Preferences page and points to "customer-ui-component" main page
        pageObjectManager.getCustomerPreferences().closeWindow();

        pageObjectManager.getPersonalHeaderUpdate().clickBackToCustomerSearch();
        pageObjectManager.getFooter().clickCancel();

    }


    @And("^clicked on personal customer product$")
    public void clickedOnPersonalCustomerProduct() throws Exception {
        //  Read Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        pageObjectManager.getProductsAndServicesPersonal().
                clickProductAndServices(testData.getString("AccountOrCardNumber"));
    }


}
