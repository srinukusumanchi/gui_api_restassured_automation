/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 7:16 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerLocateOrSetup;

import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.BusinessAddress;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for locating non personal customer with Legal name or Trading name
 */
public final class NonPersonalCustomer extends BasePage {

    @FindBy(xpath = "//input[@id='customerLocateLegalName']/parent::label/span")
    private WebElement legalName;

    @FindBy(id = "customerLocateTradingName")
    private WebElement tradingName;

    @FindBy(id = "customerLocateName-input")
    private WebElement name;

    @FindBy(id = "nonPersonalLocatePostalCode-input")
    private WebElement postalCode;

    @FindBy(id = "nonPersonalLocateStreetNumber-input")
    private WebElement streetNumber;

    @FindBy(xpath = "//span[text()='Find' or text()='Chercher']")
    private WebElement find;

    @FindBy(xpath = "//span[text()='New' or text()='Nouveau']")
    private WebElement newButton;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public NonPersonalCustomer(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on Legal Name radio button
     */
    public NonPersonalCustomer clickLegalName() {
        click(legalName, "Non-Personal legal name radio button");
        return this;
    }

    /**
     * Click on Trading Name radio button
     */
    public NonPersonalCustomer clickTradeName() {
        click(tradingName, "Non-Personal Trading name radio button");
        return this;
    }

    /**
     * Enter Name
     *
     * @param name Non-Personal Customer Name
     */
    public NonPersonalCustomer enterName(String name) {
        type(this.name, name, "Name");
        return this;
    }

    /**
     * Enter Postal Code
     *
     * @param postalCode Non-Personal postal code
     */
    public NonPersonalCustomer enterPostalCode(String postalCode) {
        type(this.postalCode, postalCode, "Postal Code");
        return this;
    }

    /**
     * Click on Find button
     */
    public bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.CustomerFound clickFind() {
        clickUsingJavascriptExecutor(find, "Find Button");
        return new bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.CustomerFound(webDriver);
    }

    /**
     * Click on Find button
     */
    public BusinessAddress clickNew() {
        clickUsingJavascriptExecutor(newButton, "New Button");
        return new BusinessAddress(webDriver);
    }

    /**
     * Enter Street Number
     *
     * @param streetNumber Non-Personal Street Number code
     */
    public NonPersonalCustomer enterStreetNumber(String streetNumber) {
        type(this.streetNumber, streetNumber, "Street Number");
        return this;
    }

}
