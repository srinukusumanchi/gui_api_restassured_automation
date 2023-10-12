/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:14 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Class is created for entering Address Information
 */
public class AddressInformation extends BasePage {

    @FindBy(id = "addressType")
    private WebElement addressTypeResidentialType;

    @FindBy(id = "addressLine1-input")
    private WebElement addressLine1ResidentialType;

    @FindBy(id = "addressLine2-input")
    private WebElement addressLine2ResidentialType;

    @FindBy(id = "city-input")
    private WebElement cityResidentialType;

    @FindBy(id = "province")
    private WebElement provinceResidentialType;

    @FindBy(id = "country")
    private WebElement countryResidentialType;

    @FindBy(id = "zipCode-input")
    private WebElement postalOrZipCodeResidentialType;

    @FindBy(id = "timeAtAddressYear-input")
    private WebElement timeAtAddressYears;

    @FindBy(id = "timeAtAddressMonth-input")
    private WebElement timeAtAddressMonths;

    @FindBy(xpath = ".//input[@id='mailingAddresscheckbox']/parent::label/span")
    private WebElement mailingAddressIsTheSameAsResidentialAddress;

    @FindBy(id = "mailingAddresscheckbox")
    private WebElement mailingAddressIsTheSameAsResidentialAddressCheckbox;

    @FindBy(id = "mailingAddressType")
    private WebElement addressTypeMailingAddress;

    @FindBy(id = "mailingaddressLine1-input")
    private WebElement addressLine1MailingAddress;

    @FindBy(id = "mailingaddressLine2-input")
    private WebElement addressLine2MailingAddress;

    @FindBy(id = "mailingCity-input")
    private WebElement cityMailingAddress;

    @FindBy(id = "mailingProvince")
    private WebElement provinceMailingAddress;

    @FindBy(id = "mailingCountry")
    private WebElement countryMailingAddress;

    @FindBy(id = "mailingzipCode-input")
    private WebElement postalOrZipCodeMailingAddress;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AddressInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Select  Address Type for Residential type
     *
     * @param addressType passing Address Type
     */
    public AddressInformation selectAddressTypeResidntialType(String addressType) {
        selectDropDownByVisibleText(this.addressTypeResidentialType, addressType);
        return this;
    }

    /**
     * Enter AddressLine1 for Residential type
     *
     * @param addressLine1 passing Address Line1
     */
    public AddressInformation enterAddressLine1ResidntialType(String addressLine1) throws InterruptedException {
        type(this.addressLine1ResidentialType, addressLine1,
                "Address Line 1");
        return this;
    }

    /**
     * Enter AddressLine2 for Residential type
     *
     * @param addressLine2 passing Address Line 2
     */
    public AddressInformation enterAddressLine2ResidntialType(String addressLine2) throws InterruptedException {
        type(this.addressLine2ResidentialType, addressLine2,
                "Address Line 2");
        return this;
    }

    /**
     * Enter City for Residential type
     *
     * @param city passing City
     */
    public AddressInformation enterCityResidntialType(String city) throws InterruptedException {
        type(this.cityResidentialType, city,
                "City");
        return this;
    }

    /**
     * Select  Province or State for Residential type
     *
     * @param provinceOrState passing Province or State
     */
    public AddressInformation selectProvinceOrStateResidntialType(String provinceOrState) {
        selectDropDownByVisibleText(this.provinceResidentialType, provinceOrState);
        return this;
    }

    /**
     * Select  Country for Residential type
     *
     * @param country passing country
     */
    public AddressInformation selectCountryResidntialType(String country) {
        selectDropDownByVisibleText(this.countryResidentialType, country);
        return this;
    }

    /**
     * Enter Postal/Zip code for Residential type
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public AddressInformation enterPostalOrZipcodeResidntialType(String postalOrZipCode) throws InterruptedException {
        type(this.postalOrZipCodeResidentialType, postalOrZipCode,
                "Postal Code");
        return this;
    }

    /**
     * Enter Time at Address for Years
     *
     * @param timeAtAddressYears passing Time at Address for Years
     */
    public AddressInformation enterTimeAtAddressYears(String timeAtAddressYears) throws InterruptedException {
        type(this.timeAtAddressYears, timeAtAddressYears,
                "Years");
        return this;
    }

    /**
     * Enter Time at Address for Months
     *
     * @param timeAtAddressMonths passing Time at Address for Months
     */
    public AddressInformation enterTimeAtAddressMonths(String timeAtAddressMonths) throws InterruptedException {
        type(this.timeAtAddressMonths, timeAtAddressMonths,
                "Years");
        return this;
    }


    /**
     * Select  Mailing Address is the same as Residential Address
     */
    public AddressInformation selectMailingAddressIsSameAsResidentialAddress
    () {
        click(this.mailingAddressIsTheSameAsResidentialAddress,
                "Mailing Address is the same as Residential Address");
        return this;
    }

    /**
     * Select  Mailing Address is the same as Residential Address
     */
    public String isMailingAddressIsSameAsResidentialAddressChecked
    (String value) {
        return getAttribute(mailingAddressIsTheSameAsResidentialAddressCheckbox, value);
    }



    /**
     * Select  Address Type for Mailing Address
     *
     * @param addressType passing Address Type
     */
    public AddressInformation selectAddressTypeMailingAddress(String addressType) {
        selectDropDownByVisibleText(this.addressTypeMailingAddress, addressType);
        return this;
    }

    /**
     * Enter AddressLine1 for Mailing Address
     *
     * @param addressLine1 passing Address Line1
     */
    public AddressInformation enterAddressLine1MailingAddress(String addressLine1) {
        type(this.addressLine1MailingAddress, addressLine1,
                "Address Line 1");
        return this;
    }

    /**
     * Enter AddressLine2 for Mailing Address
     *
     * @param addressLine2 passing Address Line 2
     */
    public AddressInformation enterAddressLine2MailingAddress(String addressLine2) {
        type(this.addressLine2MailingAddress, addressLine2,
                "Address Line 2");
        return this;
    }

    /**
     * Enter City for Mailing Address
     *
     * @param city passing City
     */
    public AddressInformation enterCityMailingAddress(String city) {
        type(this.cityMailingAddress, city,
                "City");
        return this;
    }

    /**
     * Select  Province or State for Mailing Address
     *
     * @param provinceOrState passing Province or State
     */
    public AddressInformation selectProvinceOrStateMailingAddress(String provinceOrState) {
        selectDropDownByVisibleText(this.provinceMailingAddress, provinceOrState);
        return this;
    }

    /**
     * Select  Country for Mailing Address
     *
     * @param country passing country
     */
    public AddressInformation selectCountryMailingAddress(String country) {
        selectDropDownByVisibleText(this.countryMailingAddress, country);
        return this;
    }

    /**
     * Enter Postal/Zip code for Mailing Address
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public AddressInformation enterPostalOrZipcodeMailingAddress(String postalOrZipCode) {
        type(this.postalOrZipCodeMailingAddress, postalOrZipCode,
                "Postal Code");
        return this;
    }

    /**
     * Click on next link
     * @return
     */
    public ResidenceInformation clickNext() throws IOException {
        click(next, "Next navigates to Residence Information");
        return new ResidenceInformation(webDriver);
    }
}
