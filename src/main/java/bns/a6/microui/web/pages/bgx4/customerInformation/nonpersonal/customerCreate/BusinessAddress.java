/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-18
 * Created Time: 4:19 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


/**
 * Class is created for entering business address for non personal customer
 */
public class BusinessAddress extends BasePage {

    @FindBy(id = "nonPersonalAddressType")
    private WebElement addressType;

    @FindBy(id = "residentialAddressSearch")
    private WebElement searchStretNameOrPostalCode;

    @FindBy(id = "nonPersonalAddressLine1-input")
    private WebElement addressLine1;

    @FindBy(id = "nonPersonalAddressLine2-input")
    private WebElement addressLine2;

    @FindBy(id = "nonPersonalCity-input")
    private WebElement city;

    @FindBy(id = "nonPersonalProvince")
    private WebElement provinceOrState;

    @FindBy(id = "nonPersonalCountry")
    private WebElement country;

    @FindBy(id = "nonPersonalZipCode-input")
    private WebElement postalOrZipCode;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

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
     * Select  Address Type
     *
     * @param addressType passing Address Type
     */
    public BusinessAddress selectAddressType(String addressType) {
        selectDropDownByVisibleText(this.addressType, addressType);
        return this;
    }

    /**
     * Search street name or postal code
     *
     * @param streetNameOrPostalCode passing Street name or postal code
     */
    public BusinessAddress enterStreetNameOrPostalCode(String streetNameOrPostalCode) {
        type(this.searchStretNameOrPostalCode, streetNameOrPostalCode,
                "Street Name or Postal code");
        return this;
    }

    /**
     * Enter AddressLine1
     *
     * @param addressLine1 passing Address Line1
     */
    public BusinessAddress enterAddressLine1(String addressLine1) throws InterruptedException {
        type(this.addressLine1, addressLine1,
                "Address Line 1");
        return this;
    }

    /**
     * Enter AddressLine2
     *
     * @param addressLine2 passing Address Line 2
     */
    public BusinessAddress enterAddressLine2(String addressLine2) throws InterruptedException {
        type(this.addressLine2, addressLine2,
                "Address Line 2");
        return this;
    }


    /**
     * Enter City
     *
     * @param city passing City
     */
    public BusinessAddress enterCity(String city) throws InterruptedException {
        type(this.city, city,
                "City");
        return this;
    }

    /**
     * Select  Province or State
     *
     * @param provinceOrState passing Province or State
     */
    public BusinessAddress selectProvinceOrState(String provinceOrState) {
        selectDropDownByVisibleText(this.provinceOrState, provinceOrState);
        return this;
    }

    /**
     * Select  Country
     *
     * @param country passing country
     */
    public BusinessAddress selectCountry(String country) {
        selectDropDownByVisibleText(this.country, country);
        return this;
    }

    /**
     * Enter Postal/Zip code
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public BusinessAddress enterPostalOrZipcode(String postalOrZipCode) throws InterruptedException {
        type(this.postalOrZipCode, postalOrZipCode,
                "Postal Code");
        return this;
    }

    /**
     * Click on next link
     */
    public ContactInformation clickNext() throws IOException {
        click(next,"Next navigates to Contact Information Page");
        return new ContactInformation(webDriver);
    }

}
