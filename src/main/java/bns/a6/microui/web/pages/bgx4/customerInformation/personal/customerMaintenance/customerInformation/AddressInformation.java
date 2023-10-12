/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-11
 * Created Time: 2:52 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public final class AddressInformation extends bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.AddressInformation {


    @FindBy(xpath = ".//input[@id='accountmailingAddresscheckbox']/parent::label/span")
    private WebElement accountMailingAddressIsTheSameAsResidentialAddress;

    @FindBy(id = "reason-input")
    private WebElement foreignJurisdictionReason;

    @FindBy(xpath = "//div[@class='inquiryHeader']/button/span/child::span[@class='ButtonCore__text']/parent::span/parent::button")
    private WebElement updateAddressInformation;

    @FindBy(xpath = "//div[@class='account-header-container']/button/span/child::span[@class='ButtonCore__text']")
    private WebElement updateAccountMailingAddresses;

//     Account Mailing addresses
    @FindBy(id = "main-table-account")
    private WebElement accountMailingAddressWebTable;

    @FindBy(id = "addressLine1-input")
    private WebElement addressLine1AccountMailing;

    @FindBy(id = "addressLine2-input")
    private WebElement addressLine2AccountMailing;

    @FindBy(id = "city-input")
    private WebElement cityAccountMailing;

    @FindBy(id = "province")
    private WebElement provinceAccountMailing;

    @FindBy(id = "zipCode-input")
    private WebElement postalAccountMailing;

    @FindBy(id = "country")
    private WebElement countryAccountMailing;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AddressInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Address Information Update
     */
    public AddressInformation clickUpdateAddressInformation() {
        click(updateAddressInformation, "Update-Address Information");
        return this;
    }

    /**
     * Update  Address Type for Residential type
     *
     * @param addressType passing Address Type
     */
    public AddressInformation selectAddressTypeResidntialType(String addressType) {
        super.selectAddressTypeResidntialType(addressType);
        return this;
    }

    /**
     * Update AddressLine1 for Residential type
     *
     * @param addressLine1 passing Address Line1
     */
    public AddressInformation enterAddressLine1ResidntialType(String addressLine1) throws InterruptedException {
        super.enterAddressLine1ResidntialType(addressLine1);
        return this;
    }

    /**
     * Update AddressLine2 for Residential type
     *
     * @param addressLine2 passing Address Line 2
     */
    public AddressInformation enterAddressLine2ResidntialType(String addressLine2) throws InterruptedException {
        super.enterAddressLine2ResidntialType(addressLine2);
        return this;
    }

    /**
     * Update City for Residential type
     *
     * @param city passing City
     */
    public AddressInformation enterCityResidntialType(String city) throws InterruptedException {
        super.enterCityResidntialType(city);
        return this;
    }

    /**
     * Update  Province or State for Residential type
     *
     * @param provinceOrState passing Province or State
     */
    public AddressInformation selectProvinceOrStateResidntialType(String provinceOrState) {
        super.selectProvinceOrStateResidntialType(provinceOrState);
        return this;
    }

    /**
     * Update  Country for Residential type
     *
     * @param country passing country
     */
    public AddressInformation selectCountryResidntialType(String country) {
        super.selectCountryResidntialType(country);
        return this;
    }

    /**
     * Update Postal/Zip code for Residential type
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public AddressInformation enterPostalOrZipcodeResidntialType(String postalOrZipCode) throws InterruptedException {
        super.enterPostalOrZipcodeResidntialType(postalOrZipCode);
        return this;
    }

    /**
     * Update Time at Address for Years
     *
     * @param timeAtAddressYears passing Time at Address for Years
     */
    public AddressInformation enterTimeAtAddressYears(String timeAtAddressYears) throws InterruptedException {
        super.enterTimeAtAddressYears(timeAtAddressYears);
        return this;
    }

    /**
     * Update Time at Address for Months
     *
     * @param timeAtAddressMonths passing Time at Address for Months
     */
    public AddressInformation enterTimeAtAddressMonths(String timeAtAddressMonths) throws InterruptedException {
        super.enterTimeAtAddressMonths(timeAtAddressMonths);
        return this;
    }


    /**
     * Update Profile Mailing Address is the same as Residential Address
     */
    public AddressInformation selectProfileMailingAddressIsSameAsResidentialAddress() {
        selectMailingAddressIsSameAsResidentialAddress();
        return this;
    }


    /**
     * Click on Account Mailing Address(es) Update
     */
    public AddressInformation clickUpdateAccountMailingAddresses() {
        click(updateAccountMailingAddresses, "Update-Account Mailing Address(es)");
        return this;
    }

    /**
     * Update  Address Type for Profile Mailing Address
     *
     * @param addressType passing Address Type
     */
    public AddressInformation selectAddressTypeProfileMailingAddress(String addressType) {
        super.selectAddressTypeMailingAddress(addressType);
        return this;
    }

    /**
     * Update AddressLine1 for Profile Mailing Address
     *
     * @param addressLine1 passing Address Line1
     */
    public AddressInformation enterAddressLine1ProfileMailingAddress(String addressLine1) {
        super.enterAddressLine1MailingAddress(addressLine1);
        return this;
    }

    /**
     * Update AddressLine2 for Profile Mailing Address
     *
     * @param addressLine2 passing Address Line 2
     */
    public AddressInformation enterAddressLine2ProfileMailingAddress(String addressLine2) {
        super.enterAddressLine2MailingAddress(addressLine2);
        return this;
    }

    /**
     * Update City for Profile Mailing Address
     *
     * @param city passing City
     */
    public AddressInformation enterCityProfileMailingAddress(String city) {
        super.enterCityMailingAddress(city);
        return this;
    }

    /**
     * Update  Province or State for Profile Mailing Address
     *
     * @param provinceOrState passing Province or State
     */
    public AddressInformation selectProvinceOrStateProfileMailingAddress(String provinceOrState) {
        super.selectProvinceOrStateMailingAddress(provinceOrState);
        return this;
    }

    /**
     * Update  Country for Profile Mailing Address
     *
     * @param country passing country
     */
    public AddressInformation selectCountryProfileMailingAddress(String country) {
        super.selectCountryMailingAddress(country);
        return this;
    }

    /**
     * Update Postal/Zip code for Profile Mailing Address
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public AddressInformation enterPostalOrZipcodeProfileMailingAddress(String postalOrZipCode) {
        super.enterPostalOrZipcodeMailingAddress(postalOrZipCode);
        return this;
    }

    /**
     * Enter Foreign Jurisdiction Reason for Profile Mailing Address
     *
     * @param foreignJurisdictionReason passing Postal or Zip code
     */
    public AddressInformation enterForeignJurisdictionReasonProfileMailingAddress(String foreignJurisdictionReason) {
        type(this.foreignJurisdictionReason, foreignJurisdictionReason,
                "Foreign Jurisdiction Reason");
        return this;
    }


    /**
     * Click on next link
     * @return It navigates to Residence Information class
     */
    public ResidenceInformation clickNext() throws IOException {
         super.clickNext();
        return new ResidenceInformation(webDriver);
    }


    //    Account Mailing Address(es)

    /**
     * Get Account Number Text
     *
     * @param accountNumber passing Account Number element
     */
    private String getAccountNumber(WebElement accountNumber) {
        return getText(accountNumber);
    }


    /**
     * Get List of Table rows
     */
    private List<WebElement> getAccountMailingAddressRows() {
        return accountMailingAddressWebTable.findElements(By.xpath("tbody/tr"));
    }

    /**
     * Get List of Table Headers columns
     */
    private List<WebElement> getAccountMailingAddressHeaderColumns() {
        return accountMailingAddressWebTable.findElements(By.xpath("thead/tr[1]/th/div/h1/span"));
    }

    /**
     * Get List of Products and Services Data columns data
     *
     * @param rowElement passing data row element
     */
    private List<WebElement> getAccountMailingAddressDataColumns(WebElement rowElement) {
        return rowElement.findElements(By.xpath("td"));
    }

    /**
     * Click action for an account number
     */
    public void clickOnAction(String accountNumber) {
        boolean accountNumberFlag = false;
        List<WebElement> rowsElements = getAccountMailingAddressRows();
        List<WebElement> columnsHeaders = getAccountMailingAddressHeaderColumns();

        for (WebElement rowsElement : rowsElements) {
            List<WebElement> dataColumns = getAccountMailingAddressDataColumns
                    (rowsElement);

            int accountNumberIndex = getColumnIndex(columnsHeaders, "Account Number");
            int actionIndex = getColumnIndex(columnsHeaders, "Action");

            String accountNumberActual = getAccountNumber(dataColumns.get(accountNumberIndex)).replaceAll("\\s+", "");
            if (accountNumberActual.equals(accountNumber)) {
                click(dataColumns.get(actionIndex).
                                findElement(By.xpath("div")),
                        "Action");
                accountNumberFlag = true;
                break;
            }
        }

            if (!accountNumberFlag)
                ReportPortal.stepFailWithScreenshot("Account Number:- "+accountNumber +" is not " +
                        " found in Account Mailing address(es) web table");

        }




    /**
     * Get Column Index
     *
     * @param element    passing Table headers
     * @param columnName Table header column name
     */
    private int getColumnIndex(List<WebElement> element, String columnName) {
        int columnIndex = -1;
        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getText().equals(columnName)) {
                columnIndex = i;
                break;
            }
        }
        return columnIndex;
    }

    /**
     * Get Address Line-1
     */
    public String getAddressLine1AccountMailing() {
        return getAttribute(addressLine1AccountMailing,"value");
    }

    /**
     * Get Address Line-2
     */
    public String getAddressLine2AccountMailing() {
        return getAttribute(addressLine2AccountMailing,"value");
    }

    /**
     * Get City/Address Line 3
     */
    public String getCityAccountMailing() {
        return getAttribute(cityAccountMailing,"value");
    }


    /**
     * Get Province/State
     */
    public String getProvinceAccountMailing() {
        return getAttribute(provinceAccountMailing,"value");
    }

    /**
     * Get Postal/Zip Code
     */
    public String getPostalAccountMailing() {
        return getAttribute(postalAccountMailing,"value");
    }

    /**
     * Get Country
     */
    public String getCountryAccountMailing() {
        return getSelctedOptionFromDropdown(countryAccountMailing);
    }

}
