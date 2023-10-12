/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-10
 * Created Time: 5:37 p.m.
 */

package bns.a6.microui.web.pages.accessbyaccount;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessByAccountNumber extends BasePage {
    @FindBy(id = "Product")
    private WebElement product;

    @FindBy(id = "AccountNumber")
    private WebElement accountNumber;

    @FindBy(id = "Continue")
    private WebElement continueButton;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccessByAccountNumber(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select  Product
     */
    public AccessByAccountNumber selectProduct(String product) {
        selectDropDownByVisibleText(this.product, product);
        return this;
    }

    /**
     * Enter Account Number
     */
    public AccessByAccountNumber enterAccountNumber(String accountNumber) {
        type(this.accountNumber, accountNumber, "Account Number");
        return this;
    }

    /**
     * Click on Continue
     */
    public AccessByAccountNumber clickContinue() {
        click(this.continueButton, "Continue");
        return this;
    }

}
