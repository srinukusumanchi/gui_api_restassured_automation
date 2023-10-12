/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-22
 * Created Time: 4:11 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customersalesandservices;

import bns.a6.microui.web.pages.accounts.accountmaintenance.accounttitle.CustomerAccountTitleInquiry;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for Non-Personal Account maintenance
 */
public final class AccountMaintenance extends BasePage {

    @FindBy(id = "accountMaintenance")
    private WebElement accountMaintenance;

    @FindBy(id = "customerAccountMaintenance")
    private WebElement customerOrAccountMaintenance;

    @FindBy(id = "customerToAccountRelationship")
    private WebElement customerToAccountRelationship;

    @FindBy(id = "accountTitle")
    private WebElement accountTitle;
    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountMaintenance(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * click Account Maintenance
     */
    public AccountMaintenance clickAccountMaintenance() {
        click(accountMaintenance, "Account Maintenance");
        return this;
    }

    /**
     * click Customer/Account Maintenance
     */
    public AccountMaintenance clickCustomerOrAccountMaintenance() {
        click(customerOrAccountMaintenance, "Customer/Account Maintenance");
        return this;
    }

    /**
     * click Customer to account relationship
     */
    public AccountMaintenance clickCustomerToAccountRelationship() {
        click(customerToAccountRelationship, "Customer To Account Relationship");
        return this;
    }

    /**
     * click Account Title
     */
    public CustomerAccountTitleInquiry clickAccountTitle() {
        click(accountTitle, "Account Title");
        return new CustomerAccountTitleInquiry(webDriver);
    }
}
