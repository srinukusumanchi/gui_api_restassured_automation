/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 7:15 p.m.
 */

package bns.a6.microui.web.pages.bgx4.parentorguardian;

import bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.CustomerFound;
import bns.a6.microui.web.pages.bgx4.pagecomponents.create.personal.Header;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for locating personal customer with personal customer details
 */
public final class PersonalCustomerName extends BasePage {

    @FindBy(id = "locateTitle")
    private WebElement title;

    @FindBy(id = "locateFirstName-input")
    private WebElement firstName;

    @FindBy(id = "locateLastName-input")
    private WebElement lastName;

    @FindBy(id = "locateInitial-input")
    private WebElement initials;

    @FindBy(id = "locateSuffix")
    private WebElement suffix;

    @FindBy(id = "dateOfBirth-start-input")
    private WebElement birthDate;

    @FindBy(id = "locatePostalCode-input")
    private WebElement postalCode;

    @FindBy(id = "locateStreetNumber-input")
    private WebElement streetNumber;

    @FindBy(xpath = "//span[text()='Find' or text()='Chercher']/ancestor::button")
    private WebElement find;

    @FindBy(xpath = "//span[text()='New' or text()='Nouveau']/ancestor::button")
    private WebElement newButton;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public PersonalCustomerName(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select  Title
     *
     * @param title customer title
     */
    public PersonalCustomerName selectTitle(String title) {
        selectDropDownByVisibleText(this.title, title);
        return this;
    }

    /**
     * Enter First Name
     *
     * @param firstName Customer First Name
     */
    public PersonalCustomerName enterFirstName(String firstName) {
        type(this.firstName, firstName, "First Name");
        return this;
    }

    /**
     * Enter Last Name
     *
     * @param lastName Customer Last Name
     */
    public PersonalCustomerName enterLastName(String lastName) {
        type(this.lastName, lastName, "Last Name");
        return this;
    }

    /**
     * Enter Initials
     *
     * @param initials Customer Initials
     */
    public PersonalCustomerName enterInitials(String initials) {
        type(this.initials, initials, "Initials");
        return this;
    }

    /**
     * Select  Suffix
     *
     * @param suffix customer suffix
     */
    public PersonalCustomerName selectSuffix(String suffix) {
        selectDropDownByVisibleText(this.suffix, suffix);
        return this;
    }

    /**
     * Enter Birth date
     *
     * @param birthDate Customer birth date
     */
    public PersonalCustomerName enterBirthDate(String birthDate) {
        type(this.birthDate, birthDate, "Birth Date");
        return this;
    }

    /**
     * Enter Postal code
     *
     * @param postalCode Customer Postal Code
     */
    public PersonalCustomerName enterPostalCode(String postalCode) {
        type(this.postalCode, postalCode, "Postal Code");
        return this;
    }

    /**
     * Enter Street Number
     *
     * @param streetNumber Customer Street Number
     */
    public PersonalCustomerName enterStreetNumber(String streetNumber) {
        type(this.streetNumber, streetNumber, "Street Number");
        return this;
    }


    /**
     * Click on Find button
     */
    public CustomerFound clickFind() {
        clickUsingJavascriptExecutor(find, "Find Button");
        return new CustomerFound(webDriver);
    }

    /**
     * Click on New button
     */
    public Header clickNew() {
        clickUsingJavascriptExecutor(newButton, "New Button");
        return new Header(webDriver);
    }

}
