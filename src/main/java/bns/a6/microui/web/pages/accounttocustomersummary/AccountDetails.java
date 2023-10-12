/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-09
 * Created Time: 6:05 p.m.
 */

package bns.a6.microui.web.pages.accounttocustomersummary;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for to verify account details in Account to customer summary screen
 * under account details section
 */
public final class AccountDetails extends BasePage {

    @FindBy(xpath = "//p[text()='Product']/following-sibling::div")
    private WebElement product;

    @FindBy(xpath = "//p[text()='Account Number']/following-sibling::div")
    private WebElement accountNumber;

    @FindBy(xpath = "//p[text()='Account Title 1']/following-sibling::div")
    private WebElement accountTitle1;

    @FindBy(xpath = "//p[text()='Account Title 2']/following-sibling::div")
    private WebElement accountTitle2;

    @FindBy(xpath = "//div[@class='addCustomer accountDetailsEdit']/button")
    private WebElement edit;

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
     * Get customer account Title 1
     */
    public String getAccountTitle1() {
        return getText(accountTitle1);
    }

    /**
     * Get customer account Title 2
     */
    public String getAccountTitle2() {
        return getText(accountTitle2);
    }

    /**
     * Click on Edit
     */
    public bns.a6.microui.web.pages.accountprofilemaintenance.AccountDetails
    clickEdit() {
        click(edit, "Edit");
        return new bns.a6.microui.web.pages.accountprofilemaintenance.AccountDetails(webDriver);
    }
}
