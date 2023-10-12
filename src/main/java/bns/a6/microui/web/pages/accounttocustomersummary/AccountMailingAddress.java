/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-10
 * Created Time: 11:24 a.m.
 */

package bns.a6.microui.web.pages.accounttocustomersummary;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for to verify existing customer linked accounts account in Account to Customer summary screen
 * under Existing customer(s) Linked to Account
 *
 * Customer link to account details
 * a) Customer Name
 * b) Relationship
 * c) CID
 * d) TSYS Customer ID
 */
public final class AccountMailingAddress extends BasePage {

    @FindBy(xpath = "//div[@class='addCustomer existingCustomerEdit']/button")
    private WebElement edit;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountMailingAddress(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }




    /**
     * Click on Edit
     */
    public bns.a6.microui.web.pages.accountprofilemaintenance.AccountMailingAddress
    clickEdit() {
        click(edit, "Edit");
        return new bns.a6.microui.web.pages.accountprofilemaintenance.AccountMailingAddress(webDriver);
    }
}
