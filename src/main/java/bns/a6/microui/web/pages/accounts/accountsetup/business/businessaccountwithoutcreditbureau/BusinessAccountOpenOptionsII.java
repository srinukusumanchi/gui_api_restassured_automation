package bns.a6.microui.web.pages.accounts.accountsetup.business.businessaccountwithoutcreditbureau;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class BusinessAccountOpenOptionsII extends BasePage {

    @FindBy(id = "ovdCreditType")
    private WebElement creditType;

    @FindBy(name = "ovdCreditLimit")
    private WebElement limit;

    @FindBy(id = "ovdWaiveFeePeriod")
    private WebElement waiveFeePeriod;

    @FindBy(name = "ovdAccountNumber")
    private WebElement accountNumber;

    @FindBy(id = "ovdAccountRelationship")
    private WebElement accountRelationship;

    @FindBy(xpath = "//input[@value='CAD']")
    private WebElement currency;

    @FindBy(name = "ovdManagerCode")
    private WebElement managerCode;

    @FindBy(name = "ovdShortName")
    private WebElement shortName;

    @FindBy(name = "ovdSimpleSwitch")
    private WebElement simpleSwitch;

    @FindBy(name = "placeFrozenHold")
    private WebElement placeFrozenHold;

    @FindBy(name = "ovdTrustAccount")
    private WebElement trustAccount;

    @FindBy(xpath = "//input[@value='PTA']")
    private WebElement professionalTrustee;

    @FindBy(xpath = "//input[@value='GTA']")
    private WebElement generalTrust;

    @FindBy(name = "ovdAttestationSignedDate")
    private WebElement attestationSignedDate;

    @FindBy(name = "Next")
    private WebElement next;

    @FindBy(name = "Back")
    private WebElement back;

    @FindBy(name = "Reset")
    private WebElement reset;

    @FindBy(name = "Cancel")
    private WebElement cancel;

    @FindBy(xpath = "//a[text()='Professional Trustee Account Attestation Eform']")
    private WebElement professionalTrusteeAccountAttestationEform;


    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public BusinessAccountOpenOptionsII(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select CreditType
     *
     * @param creditType passing Credit Type
     */
    public BusinessAccountOpenOptionsII selectCreditType(String creditType) {
        selectDropDownByVisibleText(this.creditType, creditType);
        return this;
    }

    /**
     * Enter Limit
     *
     * @param limit Customer Limit
     */
    public BusinessAccountOpenOptionsII enterLimit(String limit) {
        type(this.limit, limit, "Limit");
        return this;
    }

    /**
     * Select Waive Fee Period
     *
     * @param waiveFeePeriod passing Waive Fee Period
     */
    public BusinessAccountOpenOptionsII selectWaiveFeePeriod(String waiveFeePeriod) {
        selectDropDownByVisibleText(this.waiveFeePeriod, waiveFeePeriod);
        return this;
    }

    /**
     * Enter Account Number
     *
     * @param accountNumber Customer Account Number
     */
    public BusinessAccountOpenOptionsII enterAccountNumber(String accountNumber) {
        type(this.accountNumber, accountNumber, "Account Number");
        return this;
    }

    /**
     * Select Account Relationship
     *
     * @param accountRelationship passing Account Relationship
     */
    public BusinessAccountOpenOptionsII selectAccountRelationship(String accountRelationship) {
        selectDropDownByVisibleText(this.accountRelationship, accountRelationship);
        return this;
    }

    /**
     * Click on Currency radio button as CAD
     *
     * @return
     */
    public BusinessAccountOpenOptionsII clickCurrency() {
        click(currency, "Currency");
        return this;
    }

    /**
     * Enter Manager Code
     *
     * @param managerCode Customer Manager Code
     */
    public BusinessAccountOpenOptionsII enterManagerCode(String managerCode) {
        type(this.managerCode, managerCode, "Manager Code");
        return this;
    }

    /**
     * Enter Short Name
     *
     * @param shortName Customer Short Name
     */
    public BusinessAccountOpenOptionsII enterShortName(String shortName) {
        type(this.shortName, shortName, "Short Name");
        return this;
    }

    /**
     * Click on Next
     */
    public BusinessAccountOpenOptionsII clickNext() {
        click(next, "Next");
        return this;
    }

    /**
     * Switches to Day To Day Highway Options web page
     */
    public BusinessAccountOpenOptionsII switchToBusinessAccountOpenOptionsIIPage(){
        switchToWindow("Business Account Open - Options II");
        return this;
    }
}