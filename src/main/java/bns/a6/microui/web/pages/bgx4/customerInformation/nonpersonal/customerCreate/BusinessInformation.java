/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-18
 * Created Time: 4:19 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate;

import bns.a6.microui.web.testbase.BasePage;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Class is created for entering business information for non personal customer
 */
public class BusinessInformation extends BasePage {

    @FindBy(id = "businessLegalName-input")
    private WebElement businessLegalName;

    @FindBy(id = "businessTradingName-input")
    private WebElement businessTradingName;

    @FindBy(name = "businessCustomerType")
    private WebElement customerType;

    @FindBy(name = "businessStructure")
    private WebElement businessStructure;

    @FindBy(id = "businessSubCategory")
    private WebElement businessSubCategory;

    @FindBy(xpath = "//input[@id='dateBusinessEstablishedEN-start-input' or @id='dateBusinessEstablishedFR-start-input']")
    private WebElement dateBusinessEstablished;

    @FindBy(name = "businessLanguageChoice")
    private WebElement languageChoice;

    @FindBy(name = "annualSalesFromFinStmtSelect")
    private WebElement annualSalesFromFinStmtDropDown;

    @FindBy(name = "annualSalesFromFinStmtText")
    private WebElement annualSalesFromFinStmtText;

    @FindBy(xpath = "//input[@id='date-input-latestAnnualFinStmtEN-0' or @id='date-input-latestAnnualFinStmtFR-0']")
    private WebElement latestAnnualFinStmtMonth;

    @FindBy(xpath = "//input[@id='date-input-latestAnnualFinStmtEN-1' or @id='date-input-latestAnnualFinStmtFR-1']")
    private WebElement latestAnnualFinStmtYear;

    @FindBy(id = "numberOfEmployeesSelect")
    private WebElement numberOfEmployeesDropDown;

    @FindBy(name = "numberOfEmployeesText")
    private WebElement numberOfEmployeesText;

    @FindBy(name = "businessStatus")
    private WebElement status;

    @FindBy(name = "standardIndustrialCode")
    private WebElement standardIndustrialCode;

    @FindBy(name = "businessNumber")
    private WebElement businessNumber;

    //    Add Business ID/Documents
    @FindBy(id = "businessIdDocumentType")
    private WebElement idOrDocumentType;

    @FindBy(id = "businessIdDocumentSource")
    private WebElement idOrDocumentSource;



    @FindBy(id = "businessIdNumber-input")
    private WebElement idOrRefAccountNumber;

    @FindBy(id = "businessIdDesc-input")
    private WebElement sourceDescription;

    @FindBy(id = "businessIdExpiryDate-start-input")
    private WebElement expiryDate;

    @FindBy(id = "businessIdCountry")
    private WebElement country;

    @FindBy(id = "businessIdProvince")
    private WebElement provTerrState;

    @FindBy(xpath = "//span[text()='Add' or text()='Ajouter']/parent::span/parent::button")
    private WebElement add;

    @FindBy(xpath = "//span[text()=\"Summary of Business ID/Documents\" or text()=\"Sommaire - Identification ou documents d'entreprise\"]")
    private WebElement summaryofBusinessIDDocuments;

    @FindBy(id = "businessHolderLastName-input")
    private WebElement lastName1;

    @FindBy(id = "businessHolderFirstName-input")
    private WebElement firstName1;

    @FindBy(id = "businessHolderInitials-input")
    private WebElement initials1;

    @FindBy(id = "businessHolderLastName2-input")
    private WebElement lastName2;

    @FindBy(id = "businessHolderFirstName2-input")
    private WebElement firstName2;

    @FindBy(id = "businessHolderInitials2-input")
    private WebElement initials2;

    @FindBy(id = "businessHolderLastName3-input")
    private WebElement lastName3;

    @FindBy(id = "businessHolderFirstName3-input")
    private WebElement firstName3;

    @FindBy(id = "businessHolderInitials3-input")
    private WebElement initials3;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    //Incorporation details
    @FindBy(id = "incorporationNumber-input")
    private WebElement incorporationNumber;

    @FindBy(id = "businessInfoCountry")
    private WebElement businessInfoCountry;

    @FindBy(id="businessInfoProvinceState")
    private WebElement businessInfoProvinceState;


    //    Tax Residency Information
    @FindBy(xpath = "//div[text()='Yes' or text()='Oui']")
    private WebElement yesTaxResidencyInformation;

    @FindBy(xpath = "//div[text()='No' or text()='Non']")
    private WebElement noTaxResidencyInformation;

        @FindBy(xpath = "//table/tbody/tr[3]/td/div/div[2]/div[3]/div/input")
    private WebElement idOrRefAccountNumber_Update;

    @FindBy(xpath = "//table/tbody/tr[3]/td/div/div[3]/div/div/input")
    private WebElement sourceDescription_Update;

    @FindBy(xpath = "//table/tbody/tr[3]/td/div/div[4]/div[1]/div/div/div/div[1]/div/div/div/div/input")
    private WebElement expiryDate_Update;

    @FindBy(xpath = "//table/tbody/tr[3]/td/div/div[4]/div[2]/div/div[1]/select")
    private WebElement country_Update;

    @FindBy(xpath = "//table/tbody/tr[3]/td/div/div[4]/div[3]/div/div[1]/select")
    private WebElement provTerrState_Update;

    @FindBy(xpath = "//table/tbody/tr[3]/td/div/div[5]/button[2]")
    private WebElement updateID;



    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public BusinessInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Enter Business Legal Name
     *
     * @param businessLegalName passing Business Legal Name
     */
    public BusinessInformation enterBusinessLegalName(String businessLegalName) throws InterruptedException {
        type(this.businessLegalName, businessLegalName,
                "Business Legal Name");
        return this;
    }

    /**
     * Enter Business Trading Name
     *
     * @param businessTradingName passing Business Trading Name
     */
    public BusinessInformation enterBusinessTradingName(String businessTradingName) throws InterruptedException {
        type(this.businessTradingName, businessTradingName,
                "Business Trading Name");
        return this;
    }


    /**
     * Select  Customer Type
     *
     * @param customerType passing Customer Type
     */
    public BusinessInformation selectCustomerType(String customerType) {
        selectDropDownByVisibleText(this.customerType, customerType);
        return this;
    }

    /**
     * Select  Business Structure
     *
     * @param businessStructure passing Business Structure
     */
    public BusinessInformation selectBusinessStructure(String businessStructure) {
        selectDropDownByVisibleText(this.businessStructure, businessStructure);
        return this;
    }

    /**
     * Select  Business sub Category
     *
     * @param businessSubCategory passing Business sub Category
     */
    public BusinessInformation selectBusinessSubCategory(String businessSubCategory) {
        selectDropDownByVisibleText(this.businessSubCategory, businessSubCategory);
        return this;
    }

    /**
     * Enter Date Business Established
     *
     * @param dateBusinessEstablished passing Date Business Established
     */
    public BusinessInformation enterDateBusinessEstablished(String dateBusinessEstablished) throws InterruptedException {
        type(this.dateBusinessEstablished, dateBusinessEstablished,
                "Date Business Established");
        return this;
    }

    /**
     * Select  Language choice
     *
     * @param languageChoice passing Language choice
     */
    public BusinessInformation selectLanguageChoice(String languageChoice) {
        selectDropDownByVisibleText(this.languageChoice, languageChoice);
        return this;
    }

    /**
     * Select Annual sales from Fin stmt
     *
     * @param annualSalesFromFinStatement passing Annual sales from Fin stmt
     */
    public BusinessInformation selectAnnualSalesFromFinStatement(String annualSalesFromFinStatement) {
        selectDropDownByVisibleText(this.annualSalesFromFinStmtDropDown, annualSalesFromFinStatement);
        return this;
    }

    /**
     * Enter Annual sales from Fin stmt
     *
     * @param annualSalesFromFinStatement passing Annual sales from Fin stmt
     */
    public BusinessInformation enterAnnualSalesFromFinStatement(String annualSalesFromFinStatement) throws InterruptedException {
        type(this.annualSalesFromFinStmtText, annualSalesFromFinStatement,
                "Annual sales from Fin stmt");
        return this;
    }

    /**
     * Select Number of Employees
     *
     * @param numberOfEmployees passing Number of employees
     */
    public BusinessInformation selectNumberOfEmployees(String numberOfEmployees) {
        selectDropDownByVisibleText(this.numberOfEmployeesDropDown, numberOfEmployees);
        return this;
    }

    /**
     * Enter Number of Employees
     *
     * @param numberOfEmployees passing Number of employees
     */
    public BusinessInformation enterNumberOfEmployees(String numberOfEmployees) throws InterruptedException {
        type(this.numberOfEmployeesText, numberOfEmployees,
                "Number of Employees");
        return this;
    }

    /**
     * Enter Month
     *
     * @param month passing Month
     */
    public BusinessInformation enterMonth(String month) throws InterruptedException {
        type(this.latestAnnualFinStmtMonth, month,
                "Month");
        return this;
    }

    /**
     * Enter Year
     *
     * @param year passing Year
     */
    public BusinessInformation enterYear(String year) throws InterruptedException {
        type(this.latestAnnualFinStmtYear, year,
                "Year");
        return this;
    }

    /**
     * Select Status
     *
     * @param status passing Status
     */
    public BusinessInformation selectStatus(String status) {
        selectDropDownByVisibleText(this.status, status);
        return this;
    }

    /**
     * Enter Standard Industrial Code (SIC)
     *
     * @param sic passing Standard Industrial Code
     */
    public BusinessInformation enterStandardIndustrialCode(String sic) throws InterruptedException {
        type(this.standardIndustrialCode, sic,
                "SIC");
        return this;
    }

    /**
     * Enter Business Number
     *
     * @param businessNumber passing Business Number
     */
    public BusinessInformation enterBusinessNumber(String businessNumber) throws InterruptedException {
        type(this.businessNumber, businessNumber,
                "Business Number");
        return this;
    }


    //  Add Business ID/Documents

    /**
     * Select ID/ Document Type
     *
     * @param idOrDocumentType passing Document Type
     */
    public BusinessInformation selectDocumentType(String idOrDocumentType) {
        selectDropDownByVisibleText(this.idOrDocumentType, idOrDocumentType);
        return this;
    }

    /**
     * Select ID/ Document Source
     *
     * @param idOrDocumentSource passing Document Source
     */
    public BusinessInformation selectDocumentSource(String idOrDocumentSource) {
        selectDropDownByVisibleText(this.idOrDocumentSource, idOrDocumentSource);
        return this;
    }


    /**
     * Enter ID/ Ref/ Account Number
     *
     * @param IdOrRefOrAccountNumber passing ID/ Ref/ Account Number
     */
    public BusinessInformation enterIdOrRefOrAccountNumber(String IdOrRefOrAccountNumber) throws InterruptedException {
        type(this.idOrRefAccountNumber, IdOrRefOrAccountNumber,
                "ID/ Ref/ Account Number");
        return this;
    }

    /**
     * Enter Source Description
     *
     * @param sourceDescription passing ID/ Ref/ Account Number
     */
    public BusinessInformation enterSourceDescription(String sourceDescription) throws InterruptedException {
        type(this.sourceDescription, sourceDescription,
                "Source Description");
        return this;
    }


    /**
     * Enter Expiry date
     *
     * @param expiryDate passing Expiry date
     */
    public BusinessInformation enterExpiryDate(String expiryDate) throws InterruptedException {
        type(this.expiryDate, expiryDate,
                "Expiry Date");
        return this;
    }

    /**
     * Country
     *
     * @param country passing Country
     */
    public BusinessInformation selectCountry(String country) {
        selectDropDownByVisibleText(this.country, country);
        return this;
    }

    /**
     * Prov/ Terr/ State
     *
     * @param provOrTerrOrState passing Country
     */
    public BusinessInformation selectProvOrTerrOrState(String provOrTerrOrState) {
        selectDropDownByVisibleText(this.provTerrState, provOrTerrOrState);
        return this;
    }

    /**
     * Click on Add link
     */
    public BusinessInformation clickAdd() throws IOException {
        click(add, "Add button in Add Business ID/Documents");
        return new BusinessInformation(webDriver);
    }

    /**
     * Click on Summary of ID Documents
     */
    public BusinessInformation clickSummaryOfIDDocuments() {
        summaryofBusinessIDDocuments.click();
        return new BusinessInformation(webDriver);
    }

    /**
     * Enter Last Name 1
     *
     * @param lastName1 passing Last Name 1
     */
    public BusinessInformation enterLastName1(String lastName1) throws InterruptedException {
        type(this.lastName1, lastName1,
                "Last Name 1");
        return this;
    }

    /**
     * Enter First Name 1
     *
     * @param firstName1 passing First Name 1
     */
    public BusinessInformation enterFirstName1(String firstName1) throws InterruptedException {
        type(this.firstName1, firstName1,
                "First Name 1");
        return this;
    }

    /**
     * Enter Initials 1
     *
     * @param initials1 passing First Name 1
     */
    public BusinessInformation enterInitials1(String initials1) throws InterruptedException {
        type(this.initials1, initials1,
                "Initials 1");
        return this;
    }

    /**
     * Enter Last Name 2
     *
     * @param lastName2 passing Last Name 2
     */
    public BusinessInformation enterLastName2(String lastName2) throws InterruptedException {
        type(this.lastName2, lastName2,
                "Last Name 2");
        return this;
    }

    /**
     * Enter First Name 2
     *
     * @param firstName2 passing First Name 2
     */
    public BusinessInformation enterFirstName2(String firstName2) throws InterruptedException {
        type(this.firstName2, firstName2,
                "First Name 2");
        return this;
    }

    /**
     * Enter Initials 2
     *
     * @param initials2 passing First Name 1
     */
    public BusinessInformation enterInitials2(String initials2) throws InterruptedException {
        type(this.initials2, initials2,
                "Initials 2");
        return this;
    }

    /**
     * Enter Last Name 3
     *
     * @param lastName3 passing Last Name 3
     */
    public BusinessInformation enterLastName3(String lastName3) throws InterruptedException {
        type(this.lastName3, lastName3,
                "Last Name 3");
        return this;
    }

    /**
     * Enter First Name 3
     *
     * @param firstName3 passing First Name 3
     */
    public BusinessInformation enterFirstName3(String firstName3) throws InterruptedException {
        type(this.firstName3, firstName3,
                "First Name 3");
        return this;
    }

    /**
     * Enter Initials 3
     *
     * @param initials3 passing First Name 1
     */
    public BusinessInformation enterInitials3(String initials3) throws InterruptedException {
        type(this.initials3, initials3,
                "Initials 3");
        return this;
    }

    /**
     * Enter Incorporation details
     *
     * @param IncNumber passing incorporation number
     */
    public BusinessInformation enterIncorporationNumber(String IncNumber) {
        type(this.incorporationNumber, IncNumber,
                "Incorporation Number");
        return this;
    }

    /**
     * Enter Incorporation Business info Country
     *
     * @param businessInfoCountry passing incorporation number
     */
    public BusinessInformation selectIncBusinessInfoCountry(String businessInfoCountry) {
        type(this.businessInfoCountry, businessInfoCountry,
                "Incorporation businessInfoCountry");
        return this;
    }


    /**
     * Enter Incorporation Business info State/Province
     *
     * @param businessInfoProvState passing incorporation number
     */
    public BusinessInformation selectIncBusinessInfoProvinceState(String businessInfoProvState) {

        if (businessInfoProvinceState.isEnabled()) {
            type(this.businessInfoProvinceState, businessInfoProvState,
                    "Incorporation businessInfo Province or State");
        }
        return this;
    }


    /**
     * Select Yes/No for Tax Residency Information
     */
    public BusinessInformation selectTaxResidencyInformation(String taxResidencyInformation) {
        if (taxResidencyInformation.equalsIgnoreCase("YES")) {
            click(yesTaxResidencyInformation, "Next navigates to Load Administration Page");
        } else if (taxResidencyInformation.equalsIgnoreCase("NO")) {
            click(noTaxResidencyInformation, "Next navigates to Load Administration Page");
        } else {
            ReportPortal.stepFailWithScreenshot("Tax Residency is Neither 'Yes' nor 'No' but value is:- " + taxResidencyInformation);
            Assertions.fail("Tax Residency is Neither 'Yes' nor 'No' but value is:- " + taxResidencyInformation);
        }
        return new BusinessInformation(webDriver);
    }

    /**
     * Click on next link
     */
    public LoanAdministration clickNext() throws IOException {
        click(next, "Next navigates to Load Administration Page");
        return new LoanAdministration(webDriver);
    }

    /**
     * Enter ID/ Ref/ Account Number
     *
     * @param IdOrRefOrAccountNumber passing ID/ Ref/ Account Number
     */
    public BusinessInformation enterIdOrRefOrAccountNumber_Update(String IdOrRefOrAccountNumber) {
        type(this.idOrRefAccountNumber_Update, IdOrRefOrAccountNumber,
                "ID/ Ref/ Account Number");
        return this;
    }

    /**
     * Enter Source Description
     *
     * @param sourceDescription passing ID/ Ref/ Account Number
     */
    public BusinessInformation enterSourceDescription_Update(String sourceDescription) {
        type(this.sourceDescription_Update, sourceDescription,
                "Source Description");
        return this;
    }


    /**
     * Enter Expiry date
     *
     * @param expiryDate passing Expiry date
     */
    public BusinessInformation enterExpiryDate_Update(String expiryDate) {
        type(this.expiryDate_Update, expiryDate,
                "Expiry Date");
        return this;
    }

    /**
     * Country
     *
     * @param country passing Country
     */
    public BusinessInformation selectCountry_Update(String country) {
        selectDropDownByVisibleText(this.country_Update, country);
        return this;
    }

    /**
     * Prov/ Terr/ State
     *
     * @param provOrTerrOrState passing Country
     */
    public BusinessInformation selectProvOrTerrOrState_Update(String provOrTerrOrState) {
        selectDropDownByVisibleText(this.provTerrState_Update, provOrTerrOrState);
        return this;
    }

    /**
     * Click on updateID link
     */
    public BusinessInformation clickUpdateID() {
        clickUsingJavascriptExecutor(updateID, "Update button in update Business ID/Documents");
        return new BusinessInformation(webDriver);
    }
}
