/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-09
 * Created Time: 5:43 p.m.
 */

package bns.a6.microui.web.pages.ciscentre;

import bns.a6.microui.web.pages.accounttocustomersummary.AccountDetails;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for Account Profile Setup and Maintenance
 * It can locate customer via account number or card number
 */
public final class AccountProfileSetupMaintenance extends BasePage {

    @FindBy(id = "selectorId")
    private WebElement product;

    @FindBy(name = "accountnumber")
    private WebElement cardOrAccountNumber;

    @FindBy(xpath = "//span[text()='Search']/parent::span/parent::button")
    private WebElement search;

    @FindBy(xpath = "//span[text()='Cancel']/parent::span/parent::button")
    private WebElement cancel;

    WebDriver webDriver = null;
    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountProfileSetupMaintenance(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select  Product
     *
     * @param product passing Product Name
     */
    public AccountProfileSetupMaintenance selectProduct(String product) {
        selectDropDownByVisibleText(this.product, product);
        return this;
    }

    /**
     * Enter Card/Account Number
     *
     * @param cardOrAccountNumber Can pass account or card number
     */
    public AccountProfileSetupMaintenance enterCardOrAccountNumber(String cardOrAccountNumber) {
        type(this.cardOrAccountNumber, cardOrAccountNumber, "Card/Account Number");
        return this;
    }

    /**
     * Click on Search
     */
    public AccountDetails clickSearch() {
        click(search, "Search");
        return new AccountDetails(webDriver);
    }

    /**
     * Click on Cancel
     */
    public CISCentre clickCancel() {
        click(cancel, "Cancel");
        return new CISCentre(webDriver);
    }

}
