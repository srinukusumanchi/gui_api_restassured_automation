/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-13
 * Created Time: 4:02 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation;

import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.CustomerRelationship;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanAdministration extends bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.LoanAdministration {

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement update;

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
     * Click on Update
     */
    public LoanAdministration clickUpdate() {
        click(update, "Update");
        return this;
    }

    /**
     * Select  Loan Administration Rating
     *
     * @param loanAdministrationRating passing Loan Administration Rating
     */
    public LoanAdministration selectLoanAdministrationRating(String loanAdministrationRating) {
        super.selectLoanAdministrationRating(loanAdministrationRating);
        return this;
    }

    /**
     * Select Profitability
     *
     * @param profitability passing Profitability
     */
    public LoanAdministration selectProfitability(String profitability) {
        super.selectProfitability(profitability);
        return this;
    }

    /**
     * Select Sensitivity
     *
     * @param sensitivity passing Sensitivity
     */
    public LoanAdministration selectSensitivity(String sensitivity) {
        super.selectSensitivity(sensitivity);
        return this;
    }

    /**
     * Click on next link
     */
    public CustomerRelationship clickNext() {
        click(next, "Next navigates to Relationships Page");
        return new CustomerRelationship(webDriver);
    }
}
