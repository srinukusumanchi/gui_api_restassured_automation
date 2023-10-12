/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-10
 * Created Time: 11:26 a.m.
 */

package bns.a6.microui.web.pages.accountprofilemaintenance;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for to edit account details in account profile maintenance screen
 * under Account details section
 */
public final class AccountDetails extends BasePage {

    @FindBy(xpath = "//p[text()='Product']/following-sibling::div")
    private WebElement product;

    @FindBy(xpath = "//p[text()='Account Number']/following-sibling::div")
    private WebElement accountNumber;

    @FindBy(id = "accountTitle1-input")
    private WebElement accountTitle1;

    @FindBy(xpath = "accountTitle2-input")
    private WebElement accountTitle2;

    @FindBy(xpath = "//div[@class='addCustomer accountDetailsEdit']/button")
    private WebElement reset;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountDetails(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Get account product name
     */
    public String getProduct() {
        return getText(product);
    }

    /**
     * Get account number
     */
    public String getAccountNumber() {
        return getText(accountNumber);
    }

    /**
     * Enter customer account Title 1
     */
    public AccountDetails enterAccountTitle1(String accountTitle1) {
        type(this.accountTitle1, accountTitle1, "Account Title 1");
        return this;
    }

    /**
     * Enter customer account Title 2
     */
    public AccountDetails enterAccountTitle2(String accountTitle2) {
        type(this.accountTitle2, accountTitle2, "Account Title 2");
        return this;
    }

    /**
     * Click on Reset
     */
    public bns.a6.microui.web.pages.accounttocustomersummary.AccountDetails
    clickReset() {
        click(reset, "Edit");
        return new bns.a6.microui.web.pages.accounttocustomersummary.AccountDetails(webDriver);
    }


}
