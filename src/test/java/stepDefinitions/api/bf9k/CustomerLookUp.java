/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 10:26 a.m.
 */

package stepDefinitions.api.bf9k;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bf9k.customerlookup.mapper.get.Mapper;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.utility.database.MDMDB;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import stepDefinitions.managers.PageObjectManager;

import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

@QAFTestStepProvider
public class CustomerLookUp extends APIBasePage {

    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;
    private ResultSet testData = null;
    protected static Response response;

    public CustomerLookUp() {
        scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
    }

    public static Response getResponse() {
        return response;
    }

    public static void setResponse(Response response) {
        CustomerLookUp.response = response;
    }

    private void getCustomerLookupResponse(String firstNameMDMData, String lastNameMDMData,
                                           String birthDateMDMData, String phoneNumberMDMData,
                                           String postalCodeMDMData, String emailMDMData) throws Exception {

        String requestBody = pageObjectManager.getCustomerLookUpGet().
                generateCustomerSearchWithIndividualRequest(
                        firstNameMDMData, lastNameMDMData,
                        birthDateMDMData, phoneNumberMDMData,
                        postalCodeMDMData, emailMDMData);
        ReportPortal.stepInfoWithoutScreenshot("Request Body \n" + requestBody);

        // Get Customer Search response
        bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp customerLookUp = new
                bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp();
        Response response = customerLookUp.getResponse(requestBody, "POST", ServiceNames.CUSTOMERLOOKUP.name());
        ReportPortal.stepInfoWithoutScreenshot("Response Time (Milli Seconds) \n" + response.getTimeIn(TimeUnit.MILLISECONDS));
        setResponse(response);

    }


    public Boolean getUniqueMDMRecord(String firstNameMDMData, String lastNameMDMData,
                                      String birthDateMDMData, String phoneMDMData,
                                      String postalCodeMDMData, String emailMDMData,
                                      String matchingType) throws Exception {
        ResultSet mdmUniqueRecordResultSet = null;
        boolean flag = false;
        String query = null;
        utility.queries.mdm.customerlookup.CustomerLookUp customerWithProfileStatus = utility.queries.mdm.customerlookup.
                CustomerLookUp.valueOf(utility.queries.mdm.customerlookup.CustomerLookUp.CUSTOMER_LOOK_UP.name());
        if (utility.queries.mdm.customerlookup.CustomerLookUp.FIRSTNAMELASTNAME.name().equals(matchingType)) {
            if (firstNameMDMData != null &&
                    lastNameMDMData != null) {
                query = customerWithProfileStatus.getQuery().concat(utility.queries.mdm.customerlookup.
                        CustomerLookUp.FIRSTNAMELASTNAME.getQuery()).replace("<GIVENNAME>",
                        firstNameMDMData.replaceAll("'", "''")).replace("<LASTNAME>",
                        lastNameMDMData.replaceAll("'", "''"));
            }
        } else if (utility.queries.mdm.customerlookup.CustomerLookUp.DOB.name().equals(matchingType)) {
            if (firstNameMDMData != null &&
                    lastNameMDMData != null &&
                    birthDateMDMData != null) {
                query = customerWithProfileStatus.getQuery().concat(utility.queries.mdm.customerlookup.
                                CustomerLookUp.FIRSTNAMELASTNAME.getQuery()).replace("<GIVENNAME>",
                                firstNameMDMData.replaceAll("'", "''")).replace("<LASTNAME>",
                                lastNameMDMData.replaceAll("'", "''"))
                        .concat(utility.queries.mdm.customerlookup.
                                CustomerLookUp.DOB.getQuery()).replace("<DOB>",
                                birthDateMDMData);
            }
        } else if (utility.queries.mdm.customerlookup.CustomerLookUp.PHONENumber.name().equals(matchingType)) {
            query = customerWithProfileStatus.getQuery().concat(utility.queries.mdm.customerlookup.
                    CustomerLookUp.PHONENumber.getQuery()).replace("<PHONEOREMAIL>",
                    phoneMDMData);
        } else if (utility.queries.mdm.customerlookup.CustomerLookUp.POSTALCODE.name().equals(matchingType)) {
            query = customerWithProfileStatus.getQuery().concat(utility.queries.mdm.customerlookup.
                    CustomerLookUp.PHONENumber.getQuery()).replace("<PHONEOREMAIL>",
                    phoneMDMData).concat(utility.queries.mdm.customerlookup.
                    CustomerLookUp.POSTALCODE.getQuery()).replace("<POSTALCODE>",
                    postalCodeMDMData);
        } else if (utility.queries.mdm.customerlookup.CustomerLookUp.EMAIL.name().equals(matchingType)) {
            query = customerWithProfileStatus.getQuery().concat(utility.queries.mdm.customerlookup.
                    CustomerLookUp.EMAIL.getQuery()).replace("<PHONEOREMAIL>",
                    emailMDMData);
        }
        if (query != null) {
            mdmUniqueRecordResultSet = MDMDB.getInstance().getData(query);
            mdmUniqueRecordResultSet.last();
            if (mdmUniqueRecordResultSet.getRow() == 1) {
                flag = true;
            }
        }


        return flag;
    }

    @Given("^checked customer present or not using individual details for \"([^\"]*)\" \"([^\"]*)\"$")
    public void checkedCustomerPresentOrNotUsingIndividualDetailsFor(String scenarioId, String testDataDB) throws Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        //        Retrieving  query for customer with profile status
        utility.queries.mdm.customerlookup.CustomerLookUp customerWithProfileStatus = utility.queries.mdm.customerlookup.
                CustomerLookUp.valueOf(utility.queries.mdm.customerlookup.CustomerLookUp.CUSTOMER_LOOK_UP.name());

        String query = customerWithProfileStatus.getQuery().concat(utility.queries.mdm.customerlookup.
                CustomerLookUp.CUSTOMERSTATUS.getQuery()).replace("<CUSTOMERSTATUS>",
                testData.getString("status"));
        ResultSet mdmResultSet = MDMDB.getInstance().getData(query);

        while (mdmResultSet.next()) {

            if (testData.getString("first_given_name").equalsIgnoreCase("YES") &&
                    testData.getString("first_last_name").equalsIgnoreCase("YES") &&
                    testData.getString("birth_date").equalsIgnoreCase("YES")) {
                if (new stepDefinitions.api.bf9k.CustomerLookUp().getUniqueMDMRecord(mdmResultSet.getString("first_given_name"), mdmResultSet.getString("first_last_name"),
                        mdmResultSet.getString("birth_date"), mdmResultSet.getString("phone_or_email"),
                        mdmResultSet.getString("postal_cd"), mdmResultSet.getString("phone_or_email"),
                        utility.queries.mdm.customerlookup.CustomerLookUp.DOB.name())) {
                    getCustomerLookupResponse(mdmResultSet.getString("first_given_name"), mdmResultSet.getString("first_last_name"), mdmResultSet.getString("birth_date"),
                            null, null, null);
                    break;

                }
            } else if (testData.getString("first_given_name").equalsIgnoreCase("YES") &&
                    testData.getString("first_last_name").equalsIgnoreCase("YES")) {
                if (new stepDefinitions.api.bf9k.CustomerLookUp().getUniqueMDMRecord(mdmResultSet.getString("first_given_name"), mdmResultSet.getString("first_last_name"),
                        mdmResultSet.getString("birth_date"), mdmResultSet.getString("phone_or_email"),
                        mdmResultSet.getString("postal_cd"), mdmResultSet.getString("phone_or_email"),
                        utility.queries.mdm.customerlookup.CustomerLookUp.FIRSTNAMELASTNAME.name())) {
                    getCustomerLookupResponse(mdmResultSet.getString("first_given_name"), mdmResultSet.getString("first_last_name"), null,
                            null, null, null);
                    break;
                }
            } else if (testData.getString("phone_no").equalsIgnoreCase("YES")) {
                if (validatePhoneNumber(mdmResultSet.getString("phone_or_email"))) {
                    if (new stepDefinitions.api.bf9k.CustomerLookUp().getUniqueMDMRecord(mdmResultSet.getString("first_given_name"), mdmResultSet.getString("first_last_name"),
                            mdmResultSet.getString("birth_date"), mdmResultSet.getString("phone_or_email"),
                            mdmResultSet.getString("postal_cd"), mdmResultSet.getString("phone_or_email"),
                            utility.queries.mdm.customerlookup.CustomerLookUp.PHONENumber.name())) {

                        if (testData.getString("postal_cd").equalsIgnoreCase("YES")) {
                            getCustomerLookupResponse(null, null, null,
                                    mdmResultSet.getString("phone_or_email"), mdmResultSet.getString("postal_cd"), null);
                        } else {
                            getCustomerLookupResponse(null, null, null,
                                    mdmResultSet.getString("phone_or_email"), null, null);
                        }

                        break;
                    }
                }
            } else if (testData.getString("email").equalsIgnoreCase("YES")) {
                if (validateEmail(mdmResultSet.getString("phone_or_email"))) {
                    if (new stepDefinitions.api.bf9k.CustomerLookUp().getUniqueMDMRecord(mdmResultSet.getString("first_given_name"), mdmResultSet.getString("first_last_name"),
                            mdmResultSet.getString("birth_date"), mdmResultSet.getString("phone_or_email"),
                            mdmResultSet.getString("postal_cd"), mdmResultSet.getString("phone_or_email"),
                            utility.queries.mdm.customerlookup.CustomerLookUp.EMAIL.name())) {
                        if (testData.getString("email").equalsIgnoreCase("YES")) {
                            getCustomerLookupResponse(null, null, null,
                                    null, null, mdmResultSet.getString("phone_or_email"));
                        }
                        break;
                    }
                }
            }
        }
        response = getResponse();


//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Customer Look - Get Customer lookup request response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer Lookup get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer Lookup get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }


    @Given("^checked unknown customer not present in MDM for \"([^\"]*)\" \"([^\"]*)\"$")
    public void checkedUnknownCustomerNotPresentInMDMFor(String scenarioId, String testDataDB) throws
            Throwable {
        scenarioContext.setScenarioId(scenarioId);
        scenarioContext.setTableName(testDataDB);

        //  Read Login data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        do {
            String firstName = getRandomFirstName();
            String lastName = getRandomLastName();
            String birthDate = getRandomBirthDate("yyyy-MM-dd");
            String phoneNumber = getRandomPhoneNumber().replaceAll("-", "");
            String postalCode = getRandomPostalCode();
            String email = getRandomEmail();

            if (testData.getString("first_given_name").equalsIgnoreCase("YES") &&
                    testData.getString("first_last_name").equalsIgnoreCase("YES") &&
                    testData.getString("birth_date").equalsIgnoreCase("YES")) {
                if (!(new stepDefinitions.api.bf9k.CustomerLookUp().getUniqueMDMRecord(firstName, lastName, birthDate, phoneNumber,
                        postalCode, email, utility.queries.mdm.customerlookup.CustomerLookUp.DOB.name()))) {
                    getCustomerLookupResponse(firstName, lastName, birthDate,
                            null, null, null);
                    break;

                }
            } else if (testData.getString("first_given_name").equalsIgnoreCase("YES") &&
                    testData.getString("first_last_name").equalsIgnoreCase("YES")) {
                if (!(new stepDefinitions.api.bf9k.CustomerLookUp().getUniqueMDMRecord(firstName, lastName, birthDate, phoneNumber,
                        postalCode, email, utility.queries.mdm.customerlookup.CustomerLookUp.FIRSTNAMELASTNAME.name()))) {
                    getCustomerLookupResponse(firstName, lastName, null,
                            null, null, null);
                    break;
                }
            } else if (testData.getString("phone_no").equalsIgnoreCase("YES")) {
                if (validatePhoneNumber(phoneNumber)) {
                    if (!(new stepDefinitions.api.bf9k.CustomerLookUp().getUniqueMDMRecord(firstName, lastName, birthDate, phoneNumber,
                            postalCode, email, utility.queries.mdm.customerlookup.CustomerLookUp.PHONENumber.name()))) {

                        if (testData.getString("postal_cd").equalsIgnoreCase("YES")) {
                            getCustomerLookupResponse(null, null, null,
                                    phoneNumber, postalCode, null);
                        } else {
                            getCustomerLookupResponse(null, null, null,
                                    phoneNumber, null, null);
                        }
                        break;
                    }
                }
            } else if (testData.getString("email").equalsIgnoreCase("YES")) {
                if (validateEmail(email)) {
                    if (!(new stepDefinitions.api.bf9k.CustomerLookUp().getUniqueMDMRecord(firstName, lastName, birthDate, phoneNumber,
                            postalCode, email, utility.queries.mdm.customerlookup.CustomerLookUp.EMAIL.name()))) {
                        if (testData.getString("email").equalsIgnoreCase("YES")) {
                            getCustomerLookupResponse(null, null, null,
                                    null, null, email);
                        }
                        break;
                    }
                }
            }
        }
        while (true);

        response = getResponse();


//        Verifies response status code
        if (response.getStatusCode() == 200) {
            ReportPortal.stepPassWithoutScreenshot("Customer Look - Get Customer lookup request response code is as expected - 200");
        } else {
//            System.err.println("Customer Profile update request response code is as not expected, Actual:- " + response.getStatusCode() +
//                    " and Expected:- 204 - Scenario Id-" + scenarioContext.getScenarioId());
            Assertions.fail("Customer Lookup get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
            ReportPortal.stepFailWithOutScreenshot("Customer Lookup get request response code is as not expected, Actual:- " + response.getStatusCode() +
                    " and Expected:- 200 - Scenario Id-" + scenarioContext.getScenarioId());
        }
    }

    @Then("^verified customer existed in MDM DB$")
    public void verifiedCustomerExistedInMDMDB() throws Exception {
        String query = null;
        bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp customerLookUp = new bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp();

        //        D-serialization (Get response of create customer profile)
        Response responseCustomerLookup = getResponse();
        Mapper customerLookupResponse = customerLookUp.getCustomerLookupResponse(responseCustomerLookup);

//        Validate Basic Information block
        boolean matchingProfileInd = customerLookupResponse.getData().getMatching_profile_ind();

        if (matchingProfileInd) {
            ReportPortal.stepPassWithoutScreenshot("Customer Look - Customer Exists in MDM, Response " + response.getBody().asPrettyString() +
                    " Scenario ID - " + scenarioContext.getScenarioId());
        } else {
            ReportPortal.stepFailWithOutScreenshot("Customer Look - Customer Exists in MDM, Response " + response.getBody().asPrettyString());
            Assertions.fail("Customer Look - Customer Exists in MDM, Response " + response.getBody().asPrettyString() +
                    " Scenario ID - " + scenarioContext.getScenarioId());
        }

    }

    @Then("^verified customer not existed in MDM DB$")
    public void verifiedCustomerNotExistedInMDMDB() throws JsonProcessingException {
        String query = null;
        bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp customerLookUp = new bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp();

        //        D-serialization (Get response of create customer profile)
        Response responseCustomerLookup = getResponse();
        Mapper customerLookupResponse = customerLookUp.getCustomerLookupResponse(responseCustomerLookup);

//        Validate Basic Information block
        boolean matchingProfileInd = customerLookupResponse.getData().getMatching_profile_ind();

        if (!matchingProfileInd) {
            ReportPortal.stepPassWithoutScreenshot("Customer Look - Customer does not exists in MDM, Response " + response.getBody().asPrettyString()
                    + " Scenario ID - " + scenarioContext.getScenarioId());
        } else {
            ReportPortal.stepFailWithOutScreenshot("Customer Look - Customer exists in MDM, Response " + response.getBody().asPrettyString());
            Assertions.fail("Customer Look - Customer exists in MDM, Response " + response.getBody().asPrettyString() +
                    " Scenario ID - " + scenarioContext.getScenarioId());
        }

    }


    @Then("^verified customer existed in MDM DB whose status is BC or CL or IP or PR$")
    public void verifiedCustomerExistedInMDMDBWhoseStatusIsBCOrCLOrIPOrPR() throws JsonProcessingException {

        String query = null;
        bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp customerLookUp = new bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp();

        //        D-serialization (Get response of create customer profile)
        Response responseCustomerLookup = getResponse();
        Mapper customerLookupResponse = customerLookUp.getCustomerLookupResponse(responseCustomerLookup);

//        Validate Basic Information block
        boolean matchingProfileInd = customerLookupResponse.getData().getMatching_profile_ind();

        if (!matchingProfileInd) {
            ReportPortal.stepPassWithoutScreenshot("Customer Look - Customer does not exists in MDM, Response " + response.getBody().asPrettyString()
                    + " Scenario ID - " + scenarioContext.getScenarioId());
        } else {
            ReportPortal.stepFailWithOutScreenshot("Customer Look - Customer exists in MDM, Response " + response.getBody().asPrettyString());
            Assertions.fail("Customer Look - Customer exists in MDM, Response " + response.getBody().asPrettyString() +
                    " Scenario ID - " + scenarioContext.getScenarioId());
        }

    }

}

