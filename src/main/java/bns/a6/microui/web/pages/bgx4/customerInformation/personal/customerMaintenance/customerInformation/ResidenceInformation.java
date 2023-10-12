/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-11
 * Created Time: 2:52 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public final class ResidenceInformation extends bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.ResidenceInformation {

    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement update;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public ResidenceInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on Update
     */
    public ResidenceInformation clickUpdate() {
        click(update, "Update");
        return this;
    }


    /**
     * Update to Rent radio button
     */
    public ResidenceInformation selectRent() throws IOException {
        super.selectRent();
        return new ResidenceInformation(webDriver);
    }

    /**
     * Update to Own radio button
     */
    public ResidenceInformation selectOwn() throws IOException {
        super.selectOwn();
        return new ResidenceInformation(webDriver);
    }

    /**
     * Update  Rental type
     *
     * @param rentalType passing Province or State
     */
    public ResidenceInformation selectRentalType(String rentalType) {
        super.selectRentalType(rentalType);
        return this;
    }

    /**
     * Update Rental Amount
     *
     * @param rentalAmount passing Rental Amount
     */
    public ResidenceInformation enterRentalAmount(String rentalAmount) throws InterruptedException {
        super.enterRentalAmount(rentalAmount);
        return this;
    }

    /**
     * Update  Frequency Rent
     *
     * @param frequency passing Frequency for Rent
     */
    public ResidenceInformation selectFrequencyRent(String frequency) {
        super.selectFrequencyRent(frequency);
        return this;
    }


    /**
     * Update Year Purchased
     *
     * @param yearPurchased passing Year Purchased
     */
    public ResidenceInformation enterYearPurchased(String yearPurchased) throws InterruptedException {
        super.enterYearPurchased(yearPurchased);
        return this;
    }

    /**
     * Update Mortgage Payment
     *
     * @param mortgagePayment passing Year Purchased
     */
    public ResidenceInformation enterMortgagePayment(String mortgagePayment) throws InterruptedException {
        super.enterMortgagePayment(mortgagePayment);
        return this;
    }

    /**
     * Update Purchase price
     *
     * @param purchasePrice passing Year Purchased
     */
    public ResidenceInformation enterPurchasePrice(String purchasePrice) throws InterruptedException {
        super.enterPurchasePrice(purchasePrice);
        return this;
    }

    /**
     * Update  Frequency Own
     *
     * @param frequency passing Frequency for Own
     */
    public ResidenceInformation selectFrequencyOwn(String frequency) {
        super.selectFrequencyOwn(frequency);
        return this;
    }

    /**
     * Click on next link
     * @return
     */
    public ContactInformation clickNext() throws IOException {
        super.clickNext();
        return new ContactInformation(webDriver);
    }
}
