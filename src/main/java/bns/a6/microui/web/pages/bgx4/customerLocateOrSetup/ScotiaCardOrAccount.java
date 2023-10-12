/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 6:42 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerLocateOrSetup;

import bns.a6.microui.web.pages.bgx4.parentorguardian.CustomerFound;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for locating customer with Scotia card, CID,
 * Phone(Personal, Non-Personal), SIN, Account Number/ Card Number
 */
public final class ScotiaCardOrAccount extends BasePage {


    @FindBy(id = "customerLocateScotiaCardNumber-input")
    private  WebElement scotiaCard;

    @FindBy(id = "customerLocateCid-input")
    private WebElement cid;

    @FindBy(id = "customerLocatePhone-input")
    private WebElement phone;

    @FindBy(id = "customerLocatePersonalPhone")
    private WebElement personal;

    @FindBy(id = "customerLocateNonPersonalPhone")
    private WebElement nonPersonal;

    @FindBy(id = "customerLocateProduct")
    private WebElement product;

    @FindBy(id = "customerLocateAccountNumber-input")
    private WebElement accountNumber;

    @FindBy(css = "button:has(.button__text)")
    private WebElement find;

    @FindBy(id = "personalCustomerName")
    private WebElement personalCustomerName;

    @FindBy(id = "nonPersonalCustomer")
    private WebElement nonPersonalCustomer;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public ScotiaCardOrAccount(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Enter Scotia card account number
     *
     * @param scotiaCardNumber Customer Scotia card number
     */
    public ScotiaCardOrAccount enterScotiaCardAccountNumber(String scotiaCardNumber) {
        type(scotiaCard, scotiaCardNumber, "Scotia card account number");
        return this;
    }


    /**
     * Enter CID
     *
     * @param cid Customer Identification
     */
    public ScotiaCardOrAccount enterCID(String cid) {
        type(this.cid, cid, "Customer Identification");
        return this;
    }

    /**
     * Enter Phone
     *
     * @param phone Customer Phone number
     */
    public ScotiaCardOrAccount enterPhoneNumber(String phone) {
        type(this.phone, phone, "Customer Phone Number");
        return this;
    }

    /**
     * Click on Personal radio button
     */
    public ScotiaCardOrAccount clickPersonalPhone() {
        click(personal, "Personal Phone radio button");
        return this;
    }


    /**
     * Click on Non-Personal radio button
     */
    public ScotiaCardOrAccount clickNonPersonalPhone() {
        click(nonPersonal, "Non-Personal Phone radio button");
        return this;
    }


    /**
     * Select Product
     *
     * @param product Select customer account product name
     */
    public ScotiaCardOrAccount selectProduct(String product) {
        selectDropDownByVisibleText(this.product, product);
        return this;
    }


    /**
     * Enter customer account or card number
     *
     * @param accountOrCardNumber Customer Account/Card Number
     */
    public ScotiaCardOrAccount enterAccountOrCardNumber(String accountOrCardNumber) {
        type(this.accountNumber, accountOrCardNumber, "Account/Card Number");
        return this;
    }

    /**
     * Click on Find button
     */
    public CustomerFound clickFind() {
        click(find, "Find Button");
        return new CustomerFound(webDriver);
    }

    /**
     * Click on Personal Customer Name wrapper located in search by
     */
    public bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.PersonalCustomerName clickPersonalCustomerName() {
        click(personalCustomerName, "Personal Customer Name");
        return new bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.PersonalCustomerName(webDriver);
    }

    /**
     * Click on Non-Personal Customer wrapper located in search by
     */
    public bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.NonPersonalCustomer clickNonPersonalCustomer() {
        click(nonPersonalCustomer, "Non-Personal Customer");
        return new bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.NonPersonalCustomer(webDriver);
    }
}
