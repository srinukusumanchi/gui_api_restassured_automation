/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:14 a.m.
 */

package bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian;

import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.ResidenceInformation;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for entering Address Information
 */
public final class AddressInformation extends BasePage {

    @FindBy(id = "addressType")
    private WebElement addressType;

    @FindBy(id = "addressLine1-input")
    private WebElement addressLine1;

    @FindBy(id = "addressLine2-input")
    private WebElement addressLine2;

    @FindBy(id = "city-input")
    private WebElement city;

    @FindBy(id = "province")
    private WebElement province;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "involvedPartyZipCode-input")
    private WebElement postalOrZipCode;

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
    public AddressInformation selectAddressType(String addressType) {
        selectDropDownByVisibleText(this.addressType, addressType);
        return this;
    }

    /**
     * Enter AddressLine1 for Residential type
     *
     * @param addressLine1 passing Address Line1
     */
    public AddressInformation enterAddressLine1(String addressLine1) {
        type(this.addressLine1, addressLine1,
                "Address Line 1");
        return this;
    }

    /**
     * Enter AddressLine2 for Residential type
     *
     * @param addressLine2 passing Address Line 2
     */
    public AddressInformation enterAddressLine2(String addressLine2) {
        type(this.addressLine2, addressLine2,
                "Address Line 2");
        return this;
    }

    /**
     * Enter City for Residential type
     *
     * @param city passing City
     */
    public AddressInformation enterCity(String city) {
        type(this.city, city,
                "City");
        return this;
    }

    /**
     * Select  Province or State for Residential type
     *
     * @param provinceOrState passing Province or State
     */
    public AddressInformation selectProvinceOrState(String provinceOrState) {
        selectDropDownByVisibleText(this.province, provinceOrState);
        return this;
    }

    /**
     * Select  Country for Residential type
     *
     * @param country passing country
     */
    public AddressInformation selectCountry(String country) {
        selectDropDownByVisibleText(this.country, country);
        return this;
    }

    /**
     * Enter Postal/Zip code for Residential type
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public AddressInformation enterPostalOrZipcode(String postalOrZipCode) {
        type(this.postalOrZipCode, postalOrZipCode,
                "Postal Code");
        return this;
    }

    /**
     * Click on next link
     */
    public ResidenceInformation clickNext() {
        click(next, "Next navigates to Residence Information");
        return new ResidenceInformation(webDriver);
    }
}
