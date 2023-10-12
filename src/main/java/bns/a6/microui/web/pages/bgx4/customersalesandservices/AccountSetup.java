/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-22
 * Created Time: 4:10 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customersalesandservices;

import bns.a6.microui.web.pages.accounts.accountsetup.business.businessaccountwithoutcreditbureau.BusinessAccountOpenOwnership;
import bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking.DayToDayHighwayOwnership;
import bns.a6.microui.web.pages.accounts.accountsetup.onlineloanaccount.AccountLink;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Class is created for Non-Personal Account setup
 */
public final class AccountSetup extends BasePage {

    @FindBy(id = "accountSetup")
    private WebElement accountSetup;

    @FindBy(id = "business")
    private WebElement business;

    @FindBy(id = "dayToDayBanking")
    private WebElement dayToDayBanking;

    @FindBy(id = "dayToDayBankAccount")
    private WebElement dayToDayBankAccount;

    @FindBy(id = "businessAcctWithoutCreditBureau")
    private WebElement businessAccountWithoutCreditBureau;

    @FindBy(id = "other")
    private WebElement other;

    @FindBy(id = "link")
    private WebElement link;

    @FindBy(id = "onlineLoan")
    private WebElement onlineLoanAccountToCustomer;

    @FindBy(id = "scotiaCard")
    private WebElement scotiaCard;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountSetup(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * click AccountSetup
     */
    public AccountSetup clickAccountSetup() {
        click(accountSetup, "Account Setup");
        return this;
    }

    /**
     * click Day-to-Day Banking
     */
    private void clickDayToDayBanking() {
        click(dayToDayBanking, "Day-to-Day Banking");
    }

    /**
     * click Business
     */
    public AccountSetup clickBusiness() {
        click(business, "Business");
        return this;
    }

    /**
     * click Business Account Without Credit Bureau
     */
    public BusinessAccountOpenOwnership clickBusinessAccountWithoutCreditBureau() {
        click(businessAccountWithoutCreditBureau, "Business Account Without Credit Bureau");
        return new BusinessAccountOpenOwnership(webDriver);
    }

    /**
     * click Day-to-Day Bank Account
     */
    public DayToDayHighwayOwnership clickDayToDayBankAccount() {
        clickDayToDayBanking();
        click(dayToDayBankAccount, "Day-to-Day Bank Account");
        return new DayToDayHighwayOwnership(webDriver);
    }


    /**
     * click Other
     */
    private AccountSetup clickOther() {
        click(other, "Other");
        return this;
    }

    /**
     * click ScotiaCard
     */
    public AccountSetup clickScotiaCard() {
        clickOther();
        click(scotiaCard, "ScotiaCard");
        return this;
    }

    /**
     * click Link
     */
    private void clickLink() {
        click(link, "Link");
    }

    /**
     * click On-Line Loan Account to Customer
     */
    public AccountLink clickOnlineLoanAccountToCustomer() {
        clickLink();
        click(onlineLoanAccountToCustomer, "On-Line Loan Account to Customer");
        return new AccountLink(webDriver);
    }
}
