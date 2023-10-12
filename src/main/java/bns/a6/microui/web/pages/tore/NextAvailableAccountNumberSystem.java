/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-19
 * Created Time: 9:03 p.m.
 */

package bns.a6.microui.web.pages.tore;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class NextAvailableAccountNumberSystem extends BasePage {

    @FindBy(xpath = "//a[text()='Savings Account Numbers']")
    private WebElement savingsAccountNumbers;

    @FindBy(xpath = "//a[text()='DDA Account Numbers']")
    private WebElement ddaAccountNumbers;

    @FindBy(xpath = "//a[text()='ScotiaCard Account Numbers']")
    private WebElement scotiaCardAccountNumbers;

    WebDriver webDriver = null;
    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public NextAvailableAccountNumberSystem(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Savings Account Numbers
     */
    public SavingsAccountNumber clickSavingsAccountNumbers() {
        click(savingsAccountNumbers, "Savings Account Numbers");
        return new SavingsAccountNumber(webDriver);
    }

    /**
     * Click on DDA Account Numbers
     */
    public DDAAccountNumbers clickDDAAccountNumbers() {
        click(ddaAccountNumbers, "DDA Account Numbers");
        return new DDAAccountNumbers(webDriver);
    }

    /**
     * Click on ScotiaCard Account Numbers
     */
    public ScotiaCardAccountNumbers clickScotiaCardAccountNumbers() {
        click(scotiaCardAccountNumbers, "ScotiaCard Account Numbers");
        return new ScotiaCardAccountNumbers(webDriver);
    }
}
