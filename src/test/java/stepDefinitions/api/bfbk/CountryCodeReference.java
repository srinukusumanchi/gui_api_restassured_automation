/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-07-15
 * Created Time: 12:32 a.m.
 */

package stepDefinitions.api.bfbk;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.countrycodereference.mapper.get.Mapper;
import bns.a6.microui.api.pojo.bfbk.countrycodereference.services.get.countrylist.CountryList;
import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.utility.database.MDMDB;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import stepDefinitions.managers.PageObjectManager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

@QAFTestStepProvider
public class CountryCodeReference {

    protected static Response response;
    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;

    public CountryCodeReference() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
    }

    public static Response getResponse() {
        return response;
    }

    public static void setResponse(Response response) {
        CountryCodeReference.response = response;
    }

    @Given("^get all country list for \"([^\"]*)\" \"([^\"]*)\"$")
    public void getAllCountryListFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Call to customer search method to get response
//        Passing Path params
        getCountryCodeReferenceResponse(testData.getString("Language"),
                testData.getString("IncludeInactive"));

        Response response = getResponse();
//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Country code reference - Get  all country list request response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Country code reference get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Country code reference get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }

    }

    private int getMDMRecordsSize(ResultSet mdmResultSet) throws SQLException {
        mdmResultSet.last();
        return mdmResultSet.getRow();
    }

    private List<String> getColumnNames(ResultSet mdmResultSet) throws SQLException {
        ResultSetMetaData rsmd = mdmResultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        List<String> coulumnName = new LinkedList<>();
        for (int i = 1; i <= columnCount; i++) {
            coulumnName.add(rsmd.getColumnName(i));
        }
        return coulumnName;
    }

    private Map<String, List<Map<String, String>>> getMDMCountryList(ResultSet mdmResultSet) throws SQLException {
        Map<String, List<Map<String, String>>> countryListMDM = new HashMap<>();
        List<Map<String, String>> otherColumnHeaders = null;

        List<String> coulumnNames = getColumnNames(mdmResultSet);
        mdmResultSet.beforeFirst();
        while (mdmResultSet.next()) {
            otherColumnHeaders = new LinkedList<>();
            for (String columnName : coulumnNames) {
//                Assuming Description as primary key
                if (!columnName.equalsIgnoreCase("NAME")) {
                    Map<String, String> otherColumnHeaderValues = new HashMap<>();

                    otherColumnHeaderValues.put(columnName, mdmResultSet.getString(columnName));
                    otherColumnHeaders.add(otherColumnHeaderValues);
                }
            }

            countryListMDM.put(mdmResultSet.getString("NAME"), otherColumnHeaders);
        }
        return countryListMDM;
    }

    private String getValueFromListObjects(List<Map<String, String>> listObject, String key) {
        String value = null;
        for (Map<String, String> obj : listObject) {
            if (obj.containsKey((key))) {
                value = obj.get(key);
                break;
            }
        }
        return value;
    }

    @Then("^validated country list with MDM database$")
    public void validatedCountryListWithMDMDatabase() throws Exception {

        String query = null;
        //  Read Country code reference data
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        bns.a6.microui.api.pojo.bfbk.countrycodereference.utility.CountryCodeReference countryCodeReference = new bns.a6.microui.api.pojo.bfbk.countrycodereference.utility.CountryCodeReference();

        //        D-serialization (Get response of create customer profile)
        Response responseCountryCodeReference = getResponse();
        Mapper countryCodeReferenceResponse = countryCodeReference.getCountryCodeReferenceResponse(responseCountryCodeReference);

//        Stores all country information in list that comes from API
        List<CountryList> country_list = countryCodeReferenceResponse.getData().getCountry_list();

        //        Retrieving  query for Country table
        utility.queries.mdm.countrycodereference.CountryCodeReference countryCodeReferenceDB = utility.queries.mdm.
                countrycodereference.CountryCodeReference.valueOf
                        (utility.queries.mdm.countrycodereference.CountryCodeReference.COUNTRY_CODE_REFERENCE.name());

        if (testData.getString("lang_tp_cd") != null) {
            if (!testData.getString("lang_tp_cd").equals("")) {
                query = countryCodeReferenceDB.getQuery().concat(utility.queries.mdm.countrycodereference.
                        CountryCodeReference.LANGUAGE.getQuery()).replace("<LANGUAGE_CODE>",
                        testData.getString("lang_tp_cd"));
            }


        }
        if (testData.getString("active_flag") != null) {
            if (!testData.getString("active_flag").equals("")) {
                assert query != null;
                query = query.concat(utility.queries.mdm.countrycodereference.
                        CountryCodeReference.ACTIVEFLAG.getQuery()).replace("<ACTIVE_FLAG>",
                        testData.getString("active_flag"));
            }

        }

        //        Stores all country information in list that comes from MDM
        ResultSet mdmResultSet = MDMDB.getInstance().getData(query);

//        Compare country list from MDM and API
//        First compare mdm list of countries and api list of countries
        int countryListSize_MDM = getMDMRecordsSize(mdmResultSet);
        int countryListSize_API = country_list.size();
        if (countryListSize_API == countryListSize_MDM) {
            ReportPortal.stepPassWithoutScreenshot("Country code reference country list size is equal - Size" + countryListSize_MDM
                    + " Scenario ID - " + scenarioContext.getScenarioId());
        } else {
            ReportPortal.stepFailWithOutScreenshot("Country code reference country list size is not equal - API Country Size " + countryListSize_API +
                    " and MDM Country Size " + countryListSize_MDM);
            Assertions.fail("Customer Look - Customer exists in MDM, Response " + response.getBody().asPrettyString() +
                    " Scenario ID - " + scenarioContext.getScenarioId());
        }


        Map<String, List<Map<String, String>>> mdmCountryList = getMDMCountryList(mdmResultSet);

//        Itereate API Array and verify agains MDM

        for (CountryList countryBlock : country_list) {

//            Validating Country description
            if (mdmCountryList.containsKey(countryBlock.getCountry_iso2_code())) {
                ReportPortal.stepPassWithoutScreenshot(countryBlock.getCountry_iso2_code() + " Country ISO-2 is as expected - " + countryBlock.getCountry_iso2_code());

                List<Map<String, String>> countryInformations = mdmCountryList.get(countryBlock.getCountry_iso2_code());

//                for (Map<String, String> countryInformation : countryInformations) {

//                    Validating Country code DESCRIPTION
                String description = getValueFromListObjects(countryInformations, "DESCRIPTION");
                if (countryBlock.getDescription().equals(description)) {
                    ReportPortal.stepPassWithoutScreenshot(countryBlock.getCountry_iso2_code() + " Country Description is as expected - " + countryBlock.getDescription());
                } else {
                    ReportPortal.stepFailWithOutScreenshot(countryBlock.getDescription() + " Country Description is not as expected - API ISO-2" + countryBlock.getCountry_iso2_code() +
                            " and MDM ISO-2 " + description);
                    System.err.println(countryBlock.getDescription() + " Country Description is not as expected - API ISO-2 " + countryBlock.getDescription() +
                            " and MDM ISO-2 " + description);
                }

                //                    Validating ISO-3 Contry code
                String iso3Db = getValueFromListObjects(countryInformations, "ISO_CODE_3");
                if (Objects.equals(countryBlock.getCountry_iso3_code(), iso3Db)) {
                    ReportPortal.stepPassWithoutScreenshot(countryBlock.getDescription() + " Country ISO-3 is as expected - " + countryBlock.getCountry_iso3_code());
                } else {
                    ReportPortal.stepFailWithOutScreenshot(countryBlock.getDescription() + " Country ISO-3 is not as expected - API ISO-3" + countryBlock.getCountry_iso3_code() +
                            " and MDM ISO-3 " + iso3Db);
                    System.err.println(countryBlock.getDescription() + " Country ISO-3 is not as expected - API ISO-3" + countryBlock.getCountry_iso3_code() +
                            " and MDM ISO-3 " + iso3Db);
                }

                //                    Validating Active flag Contry code
                String activeFlagDb = getValueFromListObjects(countryInformations, "ACTIVE_FLAG");
                String flagDb = (activeFlagDb != null) ? String.valueOf(activeFlagDb.equals("Y")) : "null";
                if (Objects.equals(String.valueOf(countryBlock.getActive_flag()), flagDb)) {
                    ReportPortal.stepPassWithoutScreenshot(countryBlock.getDescription() + " Active Flag is as expected - " + countryBlock.getActive_flag());
                } else {
                    ReportPortal.stepFailWithOutScreenshot(countryBlock.getDescription() + " Active Flag is not as expected - API Active flag" + countryBlock.getActive_flag() +
                            " and MDM Active flag " + flagDb);
                    System.err.println(countryBlock.getDescription() + " Active Flag is not as expected - API Active flag" + countryBlock.getActive_flag() +
                            " and MDM Active flag " + flagDb);
                }
//                }
            } else {
                ReportPortal.stepFailWithOutScreenshot("MDM does not contains country description " + countryBlock.getDescription());
                System.err.println("MDM does not contains country description " + countryBlock.getDescription());
            }
        }



        /*if (!country_list) {
            ReportPortal.stepPassWithoutScreenshot("Customer Look - Customer does not exists in MDM, Response " + response.getBody().asPrettyString()
                    + " Scenario ID - " + scenarioContext.getScenarioId());
        } else {
            ReportPortal.stepFailWithOutScreenshot("Customer Look - Customer exists in MDM, Response " + response.getBody().asPrettyString());
            Assertions.fail("Customer Look - Customer exists in MDM, Response " + response.getBody().asPrettyString() +
                    " Scenario ID - " + scenarioContext.getScenarioId());
        }*/

    }

    // It validates only active countries
    @Given("^validate mdm countries with respect to RDM$")
    public void validateMdmCountriesWithRespectToRDM() throws Exception {
        String query = null;
        //  Read Country code reference data
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

//        bns.a6.microui.api.pojo.bfbk.countrycodereference.utility.CountryCodeReference countryCodeReference = new bns.a6.microui.api.pojo.bfbk.countrycodereference.utility.CountryCodeReference();

        //        D-serialization (Get response of create customer profile)
//        Response responseCountryCodeReference = getResponse();
//        Mapper countryCodeReferenceResponse = countryCodeReference.getCountryCodeReferenceResponse(responseCountryCodeReference);

//        Stores all country information in list that comes from API
//        List<CountryList> country_list = countryCodeReferenceResponse.getData().getCountry_list();

        //        Retrieving  query for Country table
        utility.queries.mdm.countrycodereference.CountryCodeReference countryCodeReferenceDB = utility.queries.mdm.
                countrycodereference.CountryCodeReference.valueOf
                        (utility.queries.mdm.countrycodereference.CountryCodeReference.COUNTRY_CODE_REFERENCE.name());


        if (testData.getString("lang_tp_cd") != null) {
            if (!testData.getString("lang_tp_cd").equals("")) {
                query = countryCodeReferenceDB.getQuery().concat(utility.queries.mdm.countrycodereference.
                        CountryCodeReference.LANGUAGE.getQuery()).replace("<LANGUAGE_CODE>",
                        testData.getString("lang_tp_cd"));
            }


        }
        if (testData.getString("active_flag") != null) {
            if (!testData.getString("active_flag").equals("")) {
                assert query != null;
                query = query.concat(utility.queries.mdm.countrycodereference.
                        CountryCodeReference.ACTIVEFLAG.getQuery()).replace("<ACTIVE_FLAG>",
                        testData.getString("active_flag"));
            }

        }

        //        Stores all country information in list that comes from MDM
        ResultSet mdmResultSet = MDMDB.getInstance().getData(query);

//        Compare country list from MDM and API
//        First compare mdm list of countries and api list of countries
        int countryListSize_MDM = getMDMRecordsSize(mdmResultSet);
        int countryListSize_TestData = (testData.getString("country_list").split("\\|").length);
        if (countryListSize_TestData == countryListSize_MDM) {
            ReportPortal.stepPassWithoutScreenshot("Country code reference country list size is equal - Size" + countryListSize_MDM
                    + " Scenario ID - " + scenarioContext.getScenarioId());
        } else {
            ReportPortal.stepFailWithOutScreenshot("Country code reference country list size is not equal - Test data (Expected) Country Size " + countryListSize_TestData +
                    " and MDM Country Size " + countryListSize_MDM);
//            Assertions.fail("Customer Look - Customer exists in MDM, Response " + response.getBody().asPrettyString() +
//                    " Scenario ID - " + scenarioContext.getScenarioId());
        }

//        Iterate and validate country list against MDM and API
        for (String countryInformation : testData.getString("country_list").split("\\|")) {
            String countryNameTestData = countryInformation.split(";")[0];
            String activeOrInactiveFlagTestData = countryInformation.split(";")[1];
            String iso2TestData = countryInformation.split(";")[2];
            String iso3TestData = countryInformation.split(";")[3];

            boolean flag = false;
            if (!mdmResultSet.isBeforeFirst()) mdmResultSet.beforeFirst();
            while (mdmResultSet.next()) {
                // Validating Country Name
                if (mdmResultSet.getString("DESCRIPTION").equals(countryNameTestData)) {

                    // Validating Active Flag
                    ReportPortal.stepPassWithoutScreenshot("Country Name is as expected " + countryNameTestData);
                    if (mdmResultSet.getString("ACTIVE_FLAG").equals(activeOrInactiveFlagTestData)) {
                        ReportPortal.stepPassWithoutScreenshot("Active flag is as expected " + activeOrInactiveFlagTestData);
                    } else {
                        ReportPortal.stepFailWithOutScreenshot("Active flag is not as expected, MDM Active Flag:- " + mdmResultSet.getString("ACTIVE_FLAG") +
                                "Expected(Test Data) Active Flag:- " + activeOrInactiveFlagTestData);
                    }

                    // Validating ISO-2
                    if (mdmResultSet.getString("NAME").equals(iso2TestData)) {
                        ReportPortal.stepPassWithoutScreenshot("ISO-2 is as expected " + iso2TestData);
                    } else {
                        ReportPortal.stepFailWithOutScreenshot("ISO-2 is not as expected, MDM ISO-2:- " + mdmResultSet.getString("NAME") +
                                "Expected(Test Data) ISO-2:- " + iso2TestData);
                    }

                    // Validating ISO-3
                    if (mdmResultSet.getString("ISO_CODE_3").equals(iso3TestData)) {
                        ReportPortal.stepPassWithoutScreenshot("ISO-3 is as expected " + iso3TestData);
                    } else {
                        ReportPortal.stepFailWithOutScreenshot("ISO-3 is not as expected, MDM ISO-3:- " + mdmResultSet.getString("ISO_CODE_3") +
                                " Expected(Test Data) ISO-3:- " + iso3TestData);
                    }
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                ReportPortal.stepFailWithOutScreenshot("Country is not present in MDM Database " + countryNameTestData);
            }
        }


    }

    private void getCountryCodeReferenceResponse(String language, String includeInactive) throws Exception {
        //        Generate Request body
        // Get Country code reference response
        bns.a6.microui.api.pojo.bfbk.countrycodereference.utility.CountryCodeReference countryCodeReference = new bns.a6.microui.api.pojo.bfbk.countrycodereference.utility.CountryCodeReference();
        Response response = countryCodeReference.getResponse("GET", ServiceNames.COUNTRYCODEREFERENCE.name(),
                language, includeInactive);
        setResponse(response);
    }


}
