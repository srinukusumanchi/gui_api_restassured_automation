/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:14 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Class is created for entering residential information
 */
public class ResidenceInformation extends BasePage {

    @FindBy(xpath = "//span[text()='Update Residence Information' or text()='Mettre à jour les renseignements sur le domicile']/parent::p/parent::div/preceding-sibling::span")
    private WebElement updateResidenceInformation;

    @FindBy(xpath = "//input[@id='isResidenceRent']/parent::label/span")
    private WebElement rent;

    @FindBy(xpath = "//input[@id='isResidenceOwn']/parent::label/span")
    private WebElement own;

    @FindBy(id = "rentalType")
    private WebElement rentalType;

    @FindBy(id = "rentFrequency")
    private WebElement frequencyRent;

    @FindBy(id = "rentalAmount-currency")
    private WebElement rentalAmount;

    @FindBy(id = "yearPurchased-input")
    private WebElement yearPurchased;

    @FindBy(id = "mortgagePayment-currency")
    private WebElement mortgagePayment;

    @FindBy(id = "purchasePrice-currency")
    private WebElement purchasePrice;

    @FindBy(id = "ownFrequency")
    private WebElement frequencyOwn;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public ResidenceInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on Update Residence Information checkbox
     */
    public ResidenceInformation clickUpdateResidenceInformation() {
        click(updateResidenceInformation, "Update Residence Information");
        return new ResidenceInformation(webDriver);
    }

    /**
     * Select Rent radio button
     */
    public ResidenceInformation selectRent() throws IOException {
        click(rent, "Rent");
        return new ResidenceInformation(webDriver);
    }

    /**
     * Select Own radio button
     */
    public ResidenceInformation selectOwn() throws IOException {
        click(own, "Own");
        return new ResidenceInformation(webDriver);
    }

    /**
     * Select  Rental type
     *
     * @param rentalType passing Province or State
     */
    public ResidenceInformation selectRentalType(String rentalType) {
        selectDropDownByVisibleText(this.rentalType, rentalType);
        return this;
    }

    /**
     * Enter Rental Amount
     *
     * @param rentalAmount passing Rental Amount
     */
    public ResidenceInformation enterRentalAmount(String rentalAmount) throws InterruptedException {
        type(this.rentalAmount, rentalAmount,
                "Rental Amount");
        return this;
    }

    /**
     * Select  Frequency Rent
     *
     * @param frequency passing Frequency for Rent
     */
    public ResidenceInformation selectFrequencyRent(String frequency) {
        selectDropDownByVisibleText(this.frequencyRent, frequency);
        return this;
    }


    /**
     * Enter Year Purchased
     *
     * @param yearPurchased passing Year Purchased
     */
    public ResidenceInformation enterYearPurchased(String yearPurchased) throws InterruptedException {
        type(this.yearPurchased, yearPurchased,
                "Year Purchased");
        return this;
    }

    /**
     * Enter Mortgage Payment
     *
     * @param mortgagePayment passing Year Purchased
     */
    public ResidenceInformation enterMortgagePayment(String mortgagePayment) throws InterruptedException {
        type(this.mortgagePayment, mortgagePayment,
                "Mortgage Payment");
        return this;
    }

    /**
     * Enter Purchase price
     *
     * @param purchasePrice passing Year Purchased
     */
    public ResidenceInformation enterPurchasePrice(String purchasePrice) throws InterruptedException {
        type(this.purchasePrice, purchasePrice,
                "Purchase Price");
        return this;
    }

    /**
     * Select  Frequency Own
     *
     * @param frequency passing Frequency for Own
     */
    public ResidenceInformation selectFrequencyOwn(String frequency) {
        selectDropDownByVisibleText(this.frequencyOwn, frequency);
        return this;
    }

    /**
     * Click on next link
     * @return
     */
    public ContactInformation clickNext() throws IOException {
        click(next, "Next navigates to Contact Information");
        return new ContactInformation(webDriver);
    }
}
