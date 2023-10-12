/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-11
 * Created Time: 10:45 a.m.
 */

package stepDefinitions.web.ay;

import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

@QAFTestStepProvider
public class AccessByAccount {
    private final ScenarioContext scenarioContext;
    private final PageObjectManager pageObjectManager;
    private WebDriver driver = null;
    private ResultSet testData = null;

    public AccessByAccount() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        driver = DriverManager.getDriver();
    }


    @And("^located with customer account number in access by account$")
    public void locatedWithCustomerAccountNumberInAccessByAccount() throws Exception {
        //  Read Access by account number data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getAccessByAccountNumber().selectProduct(testData.getString("Product"))
                .enterAccountNumber(testData.getString("AccountNumber")).clickContinue();
    }

    @Then("^verified account profile page opened with account linked to personal customer$")
    public void verifiedAccountProfilePageOpenedWithAccountLinkedToPersonalCustomer() {
        pageObjectManager.getAccountProfile().waitForPageLoad();
        ReportPortal.stepPassWithScreenshot("Page--> Personal customer Account profile page is displayed");
    }

    @Then("^verified account profile page opened with account linked to non-personal customer$")
    public void verifiedAccountProfilePageOpenedWithAccountLinkedToNonPersonalCustomer() {
        pageObjectManager.getBusinessAccountProfile().waitForPageLoad();
        ReportPortal.stepPassWithScreenshot("Page--> Non-Personal customer business account profile page is displayed");
    }


    @Then("^validated account mailing address with account profile address$")
    public void validatedAccountMailingAddressWithAccountProfileAddress() throws Exception {
        //  Read day to day banking data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));
        String addressLine1AccountProfile = pageObjectManager.getAccountProfile().getAddressLine1();
        String addressLine3AccountProfile = pageObjectManager.getAccountProfile().getAddressLine3();
        String provinceAccountProfile = pageObjectManager.getAccountProfile().getProvince();
        String postalAccountProfile = pageObjectManager.getAccountProfile().getPostal();
        String countryAccountProfile = pageObjectManager.getAccountProfile().getCountry();

       /* // Update AddressLine1 into daytoday banking database
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "AddressLine1", addressLine1AccountProfile));

        // Update AddressLine3 into daytoday banking database
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "AddressLine3", addressLine3AccountProfile));

        // Update Province into daytoday banking database
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "Province", provinceAccountProfile));

        // Update Postal code into daytoday banking database
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "PostalCode", postalAccountProfile));

        // Update Country into daytoday banking database
        TestDataDB.getInstance().updateData(
                TestDataQueries.getInstance().
                        updateTable(scenarioContext.getTableName(), scenarioContext.getScenarioId(),
                                "Country", countryAccountProfile));
*/
        pageObjectManager.getAccountProfile().clickReturn();

        pageObjectManager.getProductsAndServicesPersonal().
                clickCustomerInformation().clickAddressInformation()
                .clickOnAction(testData.getString("AccountOrCardNumber"));

        String addressLine1AccountMailingAddress = pageObjectManager.getAddressInformationUpdate().getAddressLine1AccountMailing();
        String addressLine3AccountMailingAddress = pageObjectManager.getAddressInformationUpdate().getCityAccountMailing();
        String provinceAccountMailingAddress = pageObjectManager.getAddressInformationUpdate().getProvinceAccountMailing();
        String postalAccountMailingAddress = pageObjectManager.getAddressInformationUpdate().getPostalAccountMailing();
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
        if (postalAccountProfile.replaceAll("\\s+","").
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

}
