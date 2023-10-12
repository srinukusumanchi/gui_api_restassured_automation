/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-05-03
 * Created Time: 11:56 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerinquiry;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for inquiring Address Information
 */
public final class AddressInformation extends BasePage {

    @FindBy(xpath = "//span[text()='Address Line 1' or text()='Adresse ligne 1']/parent::div/following-sibling::div")
    private WebElement addressLine1ResidentialType;

    @FindBy(xpath = "//span[text()='Address Line 2' or text()='Adresse ligne 2']/parent::div/following-sibling::div")
    private WebElement addressLine2ResidentialType;

    @FindBy(xpath = "//span[text()='City' or text()='Ville']/parent::div/following-sibling::div")
    private WebElement cityResidentialType;

    @FindBy(xpath = "//span[text()='Province/State' or text()='Province/État']/parent::div/following-sibling::div")
    private WebElement provinceResidentialType;

    @FindBy(xpath = "//span[text()='Country' or text()='Pays']/parent::div/following-sibling::div")
    private WebElement countryResidentialType;

    @FindBy(xpath = "//span[text()='Postal/Zip Code' or text()='Code postal/Code postal américain']/parent::div/following-sibling::div")
    private WebElement postalOrZipCodeResidentialType;

    @FindBy(xpath = "//span[text()='Time at Address' or text()='À la même adresse depuis']/parent::div/following-sibling::div")
    private WebElement timeAtAddressYearsMonths;

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

    public String getAddressLine1ResidentialType() {
        return getText(addressLine1ResidentialType);
    }

    public String getAddressLine2ResidentialType() {
        return getText(addressLine2ResidentialType);
    }

    public String getCityResidentialType() {
        return getText(cityResidentialType);
    }

    public String getProvinceResidentialType() {
        return getText(provinceResidentialType);
    }

    public String getCountryResidentialType() {
        return getText(countryResidentialType);
    }

    public String getPostalOrZipCodeResidentialType() {
        return getText(postalOrZipCodeResidentialType);
    }

    public String getTimeAtAddressYears() {
        return getText(timeAtAddressYearsMonths);
    }

    public String getTimeAtAddressMonths() {
        return getText(timeAtAddressYearsMonths);
    }

}
