/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-13
 * Created Time: 4:00 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation;

import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.ContactInformation;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public final class BusinessAddress extends bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.BusinessAddress {


    @FindBy(xpath = "//div[@class='inquiryHeader']/button/span/child::span[@class='ButtonCore__text']/parent::span/parent::button")
    private WebElement updateBusinessAddress;

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
    public BusinessAddress(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Update for Business Address
     */
    public BusinessAddress clickUpdateBusinessAddress() {
        click(updateBusinessAddress, "Update-Business Address");
        return this;
    }

    /**
     * Enter AddressLine1
     *
     * @param addressLine1 passing Address Line1
     */
    public BusinessAddress enterAddressLine1(String addressLine1) throws InterruptedException {
        super.enterAddressLine1(addressLine1);
        return this;
    }

    /**
     * Enter AddressLine2
     *
     * @param addressLine2 passing Address Line 2
     */
    public BusinessAddress enterAddressLine2(String addressLine2) throws InterruptedException {
        super.enterAddressLine2(addressLine2);
        return this;
    }


    /**
     * Enter City
     *
     * @param city passing City
     */
    public BusinessAddress enterCity(String city) throws InterruptedException {
        super.enterCity(city);
        return this;
    }

    /**
     * Select  Province or State
     *
     * @param provinceOrState passing Province or State
     */
    public BusinessAddress selectProvinceOrState(String provinceOrState) {
        super.selectProvinceOrState(provinceOrState);
        return this;
    }

    /**
     * Select  Country
     *
     * @param country passing country
     */
    public BusinessAddress selectCountry(String country) {
        super.selectCountry(country);
        return this;
    }

    /**
     * Enter Postal/Zip code
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public BusinessAddress enterPostalOrZipcode(String postalOrZipCode) throws InterruptedException {
        super.enterPostalOrZipcode(postalOrZipCode);
        return this;
    }

    /**
     * Click on next link
     */
    public ContactInformation clickNext() throws IOException {
        super.clickNext();
        return new ContactInformation(webDriver);
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
