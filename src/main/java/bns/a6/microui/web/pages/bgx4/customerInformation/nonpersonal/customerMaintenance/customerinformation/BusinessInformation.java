/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-13
 * Created Time: 4:01 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation;

import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.LoanAdministration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class BusinessInformation extends bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.BusinessInformation {

    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement updatePage;

    @FindBy(id = "businessBankruptcyDateEN-start-input")
    private WebElement bankruptcyDate;

    @FindBy(id = "idTable")
    private WebElement iDTable;
    
    @FindBy(id = "idTbody")
    private WebElement businessIds;

    @FindBy(id = "edit")
    private WebElement updateExistingId;

    @FindBy(xpath = "(//select[@id='businessIdDocumentSource'])[2]")
    private WebElement idOrDocumentSourceExistingId;

    @FindBy(xpath = "//input[@id='businessIdNumber-input' and @aria-required='true']")
    private WebElement idOrRefAccountNumberExistingId;

    @FindBy(xpath = "(//input[@id='businessIdExpiryDate-start-input'])[2]")
    private WebElement expiryDateExistingId;

    @FindBy(xpath = "(//select[@id='businessIdCountry'])[2]")
    private WebElement countryExistingId;

    @FindBy(xpath = "(//select[@id='businessIdProvince'])[2]")
    private WebElement provinceExistingId;

    @FindBy(xpath = "//span[text()='Update' or text()='Mettre à jour']/parent::span/parent::button")
    private WebElement updateId;

    @FindBy(xpath = "//span[text()=\"Delete ID\" or text()=\"Supprimer p. d'identité\"]/parent::span/parent::button")
    private WebElement deleteId;

    private final String identificationLink = "//a[text()='<IdentificationName>']";

    private static final String businessIdName = "//div[@class='linkFocus']/a";

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
     * Click on Update
     */
    public BusinessInformation clickUpdatePage() {
        click(updatePage, "Update");
        return this;
    }

    /**
     * Click on ID Table
     */
    public BusinessInformation clickIDTable() {
        click(iDTable, "ID Table");
        return this;
    }

    /**
     * Enter Business Legal Name
     *
     * @param businessLegalName passing Business Legal Name
     */
    public BusinessInformation enterBusinessLegalName(String businessLegalName) throws InterruptedException {
        super.enterBusinessLegalName(businessLegalName);
        return this;
    }

    /**
     * Enter Business Trading Name
     *
     * @param businessTradingName passing Business Trading Name
     */
    public BusinessInformation enterBusinessTradingName(String businessTradingName) throws InterruptedException {
        super.enterBusinessTradingName(businessTradingName);
        return this;
    }


    /**
     * Select  Customer Type
     *
     * @param customerType passing Customer Type
     */
    public BusinessInformation selectCustomerType(String customerType) {
        super.selectCustomerType(customerType);
        return this;
    }

    /**
     * Select  Business Structure
     *
     * @param businessStructure passing Business Structure
     */
    public BusinessInformation selectBusinessStructure(String businessStructure) {
        super.selectBusinessStructure(businessStructure);
        return this;
    }

    /**
     * Select  Business sub Category
     *
     * @param businessSubCategory passing Business sub Category
     */
    public BusinessInformation selectBusinessSubCategory(String businessSubCategory) {
        super.selectBusinessSubCategory(businessSubCategory);
        return this;
    }

    /**
     * Enter Date Business Established
     *
     * @param dateBusinessEstablished passing Date Business Established
     */
    public BusinessInformation enterDateBusinessEstablished(String dateBusinessEstablished) throws InterruptedException {
        super.enterDateBusinessEstablished(dateBusinessEstablished);
        return this;
    }

    /**
     * Select  Language choice
     *
     * @param languageChoice passing Language choice
     */
    public BusinessInformation selectLanguageChoice(String languageChoice) {
        super.selectLanguageChoice(languageChoice);
        return this;
    }

    /**
     * Select Annual sales from Fin stmt
     *
     * @param annualSalesFromFinStatement passing Annual sales from Fin stmt
     */
    public BusinessInformation selectAnnualSalesFromFinStatement(String annualSalesFromFinStatement) {
        super.selectAnnualSalesFromFinStatement(annualSalesFromFinStatement);
        return this;
    }

    /**
     * Enter Annual sales from Fin stmt
     *
     * @param annualSalesFromFinStatement passing Annual sales from Fin stmt
     */
    public BusinessInformation enterAnnualSalesFromFinStatement(String annualSalesFromFinStatement) throws InterruptedException {
        super.enterAnnualSalesFromFinStatement(annualSalesFromFinStatement);
        return this;
    }

    /**
     * Select Number of Employees
     *
     * @param numberOfEmployees passing Number of employees
     */
    public BusinessInformation selectNumberOfEmployees(String numberOfEmployees) {
        super.selectNumberOfEmployees(numberOfEmployees);
        return this;
    }

    /**
     * Enter Number of Employees
     *
     * @param numberOfEmployees passing Number of employees
     */
    public BusinessInformation enterNumberOfEmployees(String numberOfEmployees) throws InterruptedException {
       super.enterNumberOfEmployees(numberOfEmployees);
        return this;
    }

    /**
     * Enter Month
     *
     * @param month passing Month
     */
    public BusinessInformation enterMonth(String month) throws InterruptedException {
      super.enterMonth(month);
        return this;
    }

    /**
     * Enter Year
     *
     * @param year passing Year
     */
    public BusinessInformation enterYear(String year) throws InterruptedException {
       super.enterYear(year);
        return this;
    }

    /**
     * Select Status
     *
     * @param status passing Status
     */
    public BusinessInformation selectStatus(String status) {
        super.selectStatus(status);
        return this;
    }

    /**
     * Enter Standard Industrial Code (SIC)
     *
     * @param sic passing Standard Industrial Code
     */
    public BusinessInformation enterStandardIndustrialCode(String sic) throws InterruptedException {
        super.enterStandardIndustrialCode(sic);
        return this;
    }

    /**
     * Enter Business Number
     *
     * @param businessNumber passing Business Number
     */
    public BusinessInformation enterBusinessNumber(String businessNumber) throws InterruptedException {
        super.enterBusinessNumber(businessNumber);
        return this;
    }

    /**
     * Enter Bankruptcy Date
     *
     * @param bankruptcyDate passing Business Number
     */
    public BusinessInformation enterBankruptcyDate(String bankruptcyDate) {
        type(this.bankruptcyDate, bankruptcyDate, "Bankruptcy Date");
        return this;
    }


    //  Add Business ID/Documents

    /**
     * Select ID/ Document Type
     *
     * @param idOrDocumentType passing Document Type
     */
    public BusinessInformation selectDocumentType(String idOrDocumentType) {
        super.selectDocumentType(idOrDocumentType);
        return this;
    }

    /**
     * Select ID/ Document Source
     *
     * @param idOrDocumentSource passing Document Source
     */
    public BusinessInformation selectDocumentSource(String idOrDocumentSource) {
        super.selectDocumentSource(idOrDocumentSource);
        return this;
    }

    /**
     * Enter ID/ Ref/ Account Number
     *
     * @param idOrRefOrAccountNumber passing ID/ Ref/ Account Number
     */
    public BusinessInformation enterIdOrRefOrAccountNumber(String idOrRefOrAccountNumber) throws InterruptedException {
        super.enterIdOrRefOrAccountNumber(idOrRefOrAccountNumber);
        return this;
    }

    /**
     * Enter Source Description
     *
     * @param sourceDescription passing ID/ Ref/ Account Number
     */
    public BusinessInformation enterSourceDescription(String sourceDescription) throws InterruptedException {
        super.enterSourceDescription(sourceDescription);
        return this;
    }


    /**
     * Enter Expiry date
     *
     * @param expiryDate passing Expiry date
     */
    public BusinessInformation enterExpiryDate(String expiryDate) throws InterruptedException {
        super.enterExpiryDate(expiryDate);
        return this;
    }

    /**
     * Country
     *
     * @param country passing Country
     */
    public BusinessInformation selectCountry(String country) {
        super.selectCountry(country);
        return this;
    }

    /**
     * Prov/ Terr/ State
     *
     * @param provOrTerrOrState passing Country
     */
    public BusinessInformation selectProvOrTerrOrState(String provOrTerrOrState) {
        super.selectProvOrTerrOrState(provOrTerrOrState);
        return this;
    }

    /**
     * Click on Add link
     */
    public BusinessInformation clickAdd() throws IOException {
        super.clickAdd();
        return new BusinessInformation(webDriver);
    }


    /**
     * Enter Last Name 1
     *
     * @param lastName1 passing Last Name 1
     */
    public BusinessInformation enterLastName1(String lastName1) throws InterruptedException {
        super.enterLastName1(lastName1);
        return this;
    }

    /**
     * Enter First Name 1
     *
     * @param firstName1 passing First Name 1
     */
    public BusinessInformation enterFirstName1(String firstName1) throws InterruptedException {
        super.enterFirstName1(firstName1);
        return this;
    }

    /**
     * Enter Initials 1
     *
     * @param initials1 passing First Name 1
     */
    public BusinessInformation enterInitials1(String initials1) throws InterruptedException {
        super.enterInitials1(initials1);
        return this;
    }

    /**
     * Enter Last Name 2
     *
     * @param lastName2 passing Last Name 2
     */
    public BusinessInformation enterLastName2(String lastName2) throws InterruptedException {
        super.enterLastName2(lastName2);
        return this;
    }

    /**
     * Enter First Name 2
     *
     * @param firstName2 passing First Name 2
     */
    public BusinessInformation enterFirstName2(String firstName2) throws InterruptedException {
        super.enterFirstName2(firstName2);
        return this;
    }

    /**
     * Enter Initials 2
     *
     * @param initials2 passing First Name 1
     */
    public BusinessInformation enterInitials2(String initials2) throws InterruptedException {
        super.enterInitials2(initials2);
        return this;
    }

    /**
     * Enter Last Name 3
     *
     * @param lastName3 passing Last Name 3
     */
    public BusinessInformation enterLastName3(String lastName3) throws InterruptedException {
        super.enterLastName3(lastName3);
        return this;
    }

    /**
     * Enter First Name 3
     *
     * @param firstName3 passing First Name 3
     */
    public BusinessInformation enterFirstName3(String firstName3) throws InterruptedException {
        super.enterFirstName3(firstName3);
        return this;
    }

    /**
     * Enter Initials 3
     *
     * @param initials3 passing First Name 1
     */
    public BusinessInformation enterInitials3(String initials3) throws InterruptedException {
        super.enterInitials3(initials3);
        return this;
    }


    /**
     * Click on next link
     */
    public LoanAdministration clickNext() throws IOException {
        super.clickNext();
        return new LoanAdministration(webDriver);
    }

    /**
     * Click on the Identification document name
     */
    public BusinessInformation clickIdentificationDocument(String DocumentType) {
        click(webDriver.
                findElement(By.xpath(identificationLink.replace("<IdentificationName>", DocumentType))), "Identification document Link - " + DocumentType);
        return this;

    }

    public BusinessInformation clickUpdateID() {
        click(updateId, "Update Identification document");
        return this;
    }

    /**
     * Verify Business Id exists or not
     *
     * @param id passing Passing business Id
     * @return flag - It returns Business Id exists or not
     */
    public Boolean isBusinessIdOrDocumentExists(String id) {
        boolean flag = false;
        List<WebElement> businessIds = this.businessIds.findElements(By.xpath(businessIdName));
        for (WebElement businessId : businessIds) {
            if (getText( businessId).equals(id)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    /**
     * Clicks business Id
     *
     * @param id passing Passing business Id
     */
    public void clickBusinessId(String id) {
        List<WebElement> businessIds = this.businessIds.findElements(By.xpath(businessIdName));
        for (WebElement businessId : businessIds) {
            if (getText(businessId).equals(id)) {
                click(businessId, id);
                break;
            }
        }
    }

    /**
     * Click on Update button for Business Id documents
     */
    public BusinessInformation clickUpdateExistingId() {
        click(updateExistingId, "Update-ID");
        return this;
    }

    /**
     * Select  ID/Document Source for updating business existing Id
     *
     * @param idOrDocumentSource selecting place of birth
     */
    public BusinessInformation selectIdOrDocumentSourceExistingId(String idOrDocumentSource) {
        selectDropDownByVisibleText(idOrDocumentSourceExistingId, idOrDocumentSource);
        return this;
    }

    /**
     * Enter Id/Ref/Account Number for updating business existing Id
     *
     * @param idOrRefOrAccountNumber passing Id or Ref or Account Number
     */
    public BusinessInformation enterIdOrRefOrAccountNumberExistingId(String idOrRefOrAccountNumber) {
        type(this.idOrRefAccountNumberExistingId, idOrRefOrAccountNumber,
                "Id/Ref/Account Number - Existing Id");
        return this;
    }

    /**
     * Enter Source Description for updating business existing Id
     *
     * @param sourceDescription passing Id or Ref or Account Number
     */
    public BusinessInformation enterSourceDescriptionExistingId(String sourceDescription) {
        type(this.idOrRefAccountNumberExistingId, sourceDescription,
                "Id/Ref/Account Number - Existing Id");
        return this;
    }

    /**
     * Enter Expiry date for updating business existing Id
     *
     * @param expiryDate passing Expiry date
     */
    public BusinessInformation enterExpiryDateExistingId(String expiryDate) {
        type(this.expiryDateExistingId, expiryDate,
                "Expiry Date");
        return this;
    }

    /**
     * Select Country for updating business existing Id
     *
     * @param country selecting country
     */
    public BusinessInformation selectCountryExistingId(String country) {
        selectDropDownByVisibleText(this.countryExistingId, country);
        return this;
    }

    /**
     * Select Province for updating business existing Id
     *
     * @param province selecting Province
     */
    public BusinessInformation selectProvinceExistingId(String province) {
        selectDropDownByVisibleText(this.provinceExistingId, province);
        return this;
    }

    /**
     * Click Delete ID
     */
    public BusinessInformation clickDeleteId() {
        click(deleteId, "Delete ID");
        return this;
    }

    /**
     * Click Update ID
     */
    public BusinessInformation clickUpdate() {
        click(updateId, "Update ID");
        return this;
    }


}
