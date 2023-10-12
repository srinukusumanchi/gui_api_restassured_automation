/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-02
 * Created Time: 5:03 p.m.
 */

package stepDefinitions.web.involvedparty;

import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

@QAFTestStepProvider
public class InvolvedParty {
    private final PageObjectManager pageObjectManager;

    private WebDriver driver = null;

    public InvolvedParty() {
        pageObjectManager = PageObjectManager.getInstance();
        driver = DriverManager.getDriver();
    }


    private void nameOnboarding(ResultSet testData) throws SQLException {

        if (testData.getString("Title").equals("")) {
            ReportPortal.stepFailWithScreenshot("Title is mandatory field in Involved Party Information Setup for Parent/Guardian" +
                    " screen,so pass Title in test data");
            Assertions.fail("Title is mandatory field in Involved Party Information Setup for Parent/Guardian" +
                    " screen,so pass Title in test data");
        } else if (pageObjectManager.getHeaderInvolvedParty().getTitle().equals("Choose"))
            pageObjectManager.getHeaderInvolvedParty().selectTitle(testData.getString("Title"));

        if (testData.getString("FirstName").equals(""))
            Assertions.fail("First Name is mandatory field in Involved Party Information Setup for Parent/Guardian" +
                    " screen,so pass First Name in test data");
        else if (pageObjectManager.getHeaderInvolvedParty().getFirstName().equals(""))
            pageObjectManager.getHeaderInvolvedParty().enterFirstName(testData.getString("FirstName"));

        if (testData.getString("LastName").equals("")){
            ReportPortal.stepFailWithScreenshot("Last Name is mandatory field in Involved Party Information Setup for Parent/Guardian" +
                    " screen,so pass Last Name in test data");
            Assertions.fail("Last Name is mandatory field in Involved Party Information Setup for Parent/Guardian" +
                    " screen,so pass Last Name in test data");
        }

        else if (pageObjectManager.getHeaderInvolvedParty().getLastName().equals(""))
            pageObjectManager.getHeaderInvolvedParty().enterLastName(testData.getString("LastName"));

        if (testData.getString("BirthDate").equals(""))
            Assertions.fail("Birth Date is mandatory field in Involved Party Information Setup for Parent/Guardian" +
                    " screen,so pass Birth Date in test data");
        else if (pageObjectManager.getHeaderInvolvedParty().getBirthDate().equals(""))
            pageObjectManager.getHeaderInvolvedParty().enterBirthDate(testData.getString("BirthDate"));

        if (!pageObjectManager.getHeaderInvolvedParty().getInitials().equals(""))
            pageObjectManager.getHeaderInvolvedParty().
                    enterInitials(testData.getString("Initials"));

        if (!pageObjectManager.getHeaderInvolvedParty().getSuffix().equals(""))
            pageObjectManager.getHeaderInvolvedParty().
                    selectSuffix(testData.getString("Suffix"));
    }

    private void personalInformation(ResultSet testData) throws SQLException {
        pageObjectManager.getPersonalInformationInvolvedParty().
                selectLanguageChoice(testData.getString("LanguageChoice")).
                clickNext();
    }

    private void addressInformation(ResultSet testData) throws SQLException {
        pageObjectManager.getAddressInformationInvolvedParty().
                selectAddressType(testData.getString("AddressType")).
                enterAddressLine1(testData.getString("AddressLine1")).
                enterAddressLine2(testData.getString("AddressLine2")).
                enterCity(testData.getString("City")).
                selectProvinceOrState(testData.getString("ProvinceOrState")).
                selectCountry(testData.getString("Country")).
                enterPostalOrZipcode(testData.getString("PostalOrZipCode")).
                clickNext();
    }

    private void employment(ResultSet testData) throws SQLException {
        pageObjectManager.getEmployment().enterBusinessOrEmployer(testData.getString("BusinessEmployer")).
                selectEmploymentStatus(testData.getString("EmploymentStatus")).
                selectIndustry(testData.getString("Industry")).
                enterOccupation(testData.getString("Occupation"));
    }


    public void involvedPartySetupForParentOrGuardian(ResultSet testData) throws SQLException {
        pageObjectManager.getIdentificationCreate().clickLocateParentOrGuardian();
        if (!testData.getString("Title").equals(""))
            pageObjectManager.getPersonalCustomerNameInvolvedParty().selectTitle(testData.getString("Title"));

        if (!testData.getString("FirstName").equals(""))
            pageObjectManager.getPersonalCustomerNameInvolvedParty().enterFirstName(testData.getString("FirstName"));
        else {
            ReportPortal.stepFailWithScreenshot("First Name is mandatory field in Involved party Customer Locate/Setup screen," +
                    " so pass First Name in test data");
            Assertions.fail("First Name is mandatory field in Involved party Customer Locate/Setup screen," +
                    " so pass First Name in test data");
        }


        if (!testData.getString("LastName").equals(""))
            pageObjectManager.getPersonalCustomerNameInvolvedParty().enterLastName(testData.getString("LastName"));
        else
            Assertions.fail("Last Name is mandatory field in Involved party Customer Locate/Setup screen," +
                    " so pass Last Name in test data");

        if (!testData.getString("Initials").equals(""))
            pageObjectManager.getPersonalCustomerNameInvolvedParty().
                    enterInitials(testData.getString("Initials"));

        if (!testData.getString("Suffix").equals(""))
            pageObjectManager.getPersonalCustomerNameInvolvedParty().
                    selectSuffix(testData.getString("Suffix"));

        if (!testData.getString("BirthDate").equals(""))
            pageObjectManager.getPersonalCustomerNameInvolvedParty().
                    enterBirthDate(testData.getString("BirthDate"));

        if (!testData.getString("PostalCode").equals(""))
            pageObjectManager.getPersonalCustomerNameInvolvedParty().
                    enterPostalCode(testData.getString("PostalCode"));

        if (!testData.getString("StreetNumber").equals(""))
            pageObjectManager.getPersonalCustomerNameInvolvedParty().enterStreetNumber(testData.getString("StreetNumber"));

        pageObjectManager.getPersonalCustomerNameInvolvedParty().clickFind();

        ReportPortal.stepInfoWithScreenshot("Involved Party -> Customer Locate/Setup -> Personal Customer Name");

//        Customer Name
        String title = testData.getString("Title");
        String firstName = testData.getString("FirstName");
        String lastName = testData.getString("LastName");
        String compositName = title + " " + firstName + " " + lastName;

//        Customer Address - Line-1
        String addressLine1 = testData.getString("AddressLine1");

        if (pageObjectManager.getCustomerFoundInvolvedParty().customerFound(compositName, addressLine1)) {
            pageObjectManager.getCustomerFoundInvolvedParty().clickOnCustomer(compositName, addressLine1);
            pageObjectManager.getFooter().clickDone();
        } else {
            pageObjectManager.getPersonalCustomerNameInvolvedParty().clickNew();

//     Name onboarding
            nameOnboarding(testData);

//        Personal Information
            personalInformation(testData);
            ReportPortal.stepInfoWithScreenshot("Involved Party Information Setup for Parent/Guardian -> Personal Information");

//        Address Information
            addressInformation(testData);
            ReportPortal.stepInfoWithScreenshot("Involved Party Information Setup for Parent/Guardian -> Address Information");

//      Employment
            employment(testData);
            ReportPortal.stepInfoWithScreenshot("Involved Party Information Setup for Parent/Guardian -> Employment");

            pageObjectManager.getFooter().clickSubmit();
            pageObjectManager.getPopUpsInvolvedParty().clickSubmit().clickOk();
        }


    }
}
