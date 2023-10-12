/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-29
 * Created Time: 1:37 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountmaintenance.customerToAccountMaintenance;

import bns.a6.microui.web.pages.bgx4.parentorguardian.CustomerFound;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLocate extends BasePage {

    @FindBy(id = "customerLocateScotiaCardNumber-input")
    private WebElement scotiaCard;

    @FindBy(id = "customerLocateProduct")
    private WebElement product;

    @FindBy(id = "customerLocateAccountNumber-input")
    private WebElement accountNumber;

    @FindBy(css = "button:has(.button__text)")
    private WebElement find;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountLocate(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Enter Scotia card number
     *
     * @param scotiaCardNumber Customer Scotia card number
     */
    public AccountLocate enterScotiaCard(String scotiaCardNumber) {
        type(scotiaCard, scotiaCardNumber, "Scotia card");
        return this;
    }

    /**
     * Select Product
     *
     * @param product Select customer account product name
     */
    public AccountLocate selectProduct(String product) {
        selectDropDownByVisibleText(this.product, product);
        return this;
    }


    /**
     * Enter customer account or card number
     *
     * @param accountOrCardNumber Customer Account/Card Number
     */
    public AccountLocate enterAccountOrCardNumber(String accountOrCardNumber) {
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


}
