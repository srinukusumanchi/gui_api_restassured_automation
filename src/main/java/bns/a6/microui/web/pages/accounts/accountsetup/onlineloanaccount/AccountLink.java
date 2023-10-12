/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-11
 * Created Time: 12:35 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.onlineloanaccount;

import bns.a6.microui.web.pages.bgx4.customersalesandservices.CustomerSelection;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLink extends BasePage {

    @FindBy(name = "AccountNumber")
    private WebElement accountNumber;

    @FindBy(name = "Done")
    private WebElement done;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountLink(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Enter Account Number
     *
     * @param accountNumber OLL Account Number
     */
    public AccountLink enterAccountNumber(String accountNumber) {
        type(this.accountNumber, accountNumber, "Account Number");
        return this;
    }

    /**
     * Click on Done button
     */
    public CustomerSelection clickDone() {
        click(done, "Done");
        return new CustomerSelection(webDriver);
    }

    /**
     * Switches to Account Link web page
     */
    public AccountLink switchToAccountLinkPage(){
        this.switchToWindow("Account Link");
        return this;
    }

}
