/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-18
 * Created Time: 4:19 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for entering load administration for non personal customer
 */
public class LoanAdministration extends BasePage {

    @FindBy(name = "loanAdministrationRating")
    private WebElement loadAdministrationRating;

    @FindBy(name = "profitability")
    private WebElement profitability;

    @FindBy(name = "sensitivity")
    private WebElement sensitivity;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    WebDriver webDriver = null;
    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public LoanAdministration(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select  Loan Administration Rating
     *
     * @param loanAdministrationRating passing Loan Administration Rating
     */
    public LoanAdministration selectLoanAdministrationRating(String loanAdministrationRating) {
        selectDropDownByVisibleText(this.loadAdministrationRating, loanAdministrationRating);
        return this;
    }

    /**
     * Select Profitability
     *
     * @param profitability passing Profitability
     */
    public LoanAdministration selectProfitability(String profitability) {
        selectDropDownByVisibleText(this.profitability, profitability);
        return this;
    }

    /**
     * Select Sensitivity
     *
     * @param sensitivity passing Sensitivity
     */
    public LoanAdministration selectSensitivity(String sensitivity) {
        selectDropDownByVisibleText(this.sensitivity, sensitivity);
        return this;
    }

    /**
     * Click on next link
     */
    public CustomerRelationship clickNext() {
        click(next, "Next navigates to Customer Relationship Page");
        return new CustomerRelationship(webDriver);
    }
}
