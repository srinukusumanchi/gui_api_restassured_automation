/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-30
 * Created Time: 2:38 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class DayToDayHighwayOptions extends BasePage {

    @FindBy(name = "AccountNumber")
    private WebElement accountNumber;

    @FindBy(name = "StarterKitNumber")
    private WebElement staterKitNumber;

    @FindBy(name = "ParticipantPIN")
    private WebElement participantPin;

    @FindBy(name = "AccountTitle1")
    private WebElement accountTitle1;

    @FindBy(name = "ShortName")
    private WebElement shortName;

    @FindBy(xpath = "//input[@value='OnlineStatement']")
    private WebElement paperless;

    @FindBy(xpath = "//input[@value='Statement']")
    private WebElement statement;

    @FindBy(xpath = "//input[@value='StatementWithChequeReturn']")
    private WebElement statementWithChequeImageReturn;

    @FindBy(xpath = "//input[@value='BrailleStatement']")
    private WebElement brailleStatement;

    @FindBy(name = "//input[@value='BrailleWithChequeReturn']")
    private WebElement brailleStatementWithChequeImageReturn;

    @FindBy(id = "IntendedUseOptions")
    private WebElement intendedUse;

    @FindBy(id = "InterestArrangement")
    private WebElement interestArrangement;

    @FindBy(id = "ReasonForAccountOpen")
    private WebElement reasonForAccountOpen;

    @FindBy(id = "SourceOfFunds")
    private WebElement sourceOfFunds;

    @FindBy(name = "NewAccountMessage")
    private WebElement applyNewAccountMessage;

    @FindBy(name = "CardNumber")
    private WebElement scotiaCardAccountAccess;

    @FindBy(name = "SimpleSwitch")
    private WebElement additionalServices;

    @FindBy(name = "PayrollCheckBox0")
    private WebElement payrollDirectDepositInstructions;

    @FindBy(name = "CompanyCheckBox0")
    private WebElement companyPreAuthorized;

    @FindBy(name = "InitialDeposit")
    private WebElement initialDeposit;

    @FindBy(name = "Done")
    private WebElement done;

    @FindBy(name = "Back")
    private WebElement back;

    @FindBy(name = "Reset")
    private WebElement reset;

    @FindBy(name = "Cancel")
    private WebElement cancel;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public DayToDayHighwayOptions(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Enter Account number
     *
     * @param accountNumber passing Account Number
     */
    public DayToDayHighwayOptions enterAccountNumber(String accountNumber) {
        type(this.staterKitNumber, accountNumber, "Account Number");
        return this;
    }


    /**
     * Enter Participant pin
     *
     * @param participantpin passing Participant pin
     */
    public DayToDayHighwayOptions enterParticipantPin(String participantpin) {
        type(this.participantPin, participantpin, "Participant PIN");
        return this;
    }

    /**
     * Get Account number
     */
    public String getAccountNumber() {
        return getSelctedOptionFromDropdown(this.accountNumber);
    }


    /**
     * Enter Account Title 1
     *
     * @param accountTitle1 passing Account Title 1
     */
    public DayToDayHighwayOptions enterAccountTitle1(String accountTitle1) {
        type(this.accountTitle1, accountTitle1, "Account Title 1");
        return this;
    }

    /**
     * Enter shortName
     *
     * @param shortName Customer shortName
     */
    public DayToDayHighwayOptions enterShortName(String shortName) {
        type(this.shortName, shortName, "Short Name");
        return this;
    }

    /**
     * Click on paperless radio button
     */
    public DayToDayHighwayOptions clickPaperless() {
        click(paperless, "Paperless");
        return this;
    }

    /**
     * Click on Statement radio button
     */
    public DayToDayHighwayOptions clickStatement() {
        click(statement, "Statement");
        return this;
    }

    /**
     * Click on Statement with Cheque Image Return radio button
     */
    public DayToDayHighwayOptions clickStatementwithChequeImageReturn() {
        click(statementWithChequeImageReturn, "Statement with Cheque Image Return");
        return this;
    }

    /**
     * Click on Braille Statement radio button
     */
    public DayToDayHighwayOptions clickBrailleStatement() {
        click(brailleStatement, "Braille Statement");
        return this;
    }

    /**
     * Click on Braille Statement with Cheque Image Return radio button
     */
    public DayToDayHighwayOptions clickBrailleStatementWithChequeImageReturn() {
        click(brailleStatementWithChequeImageReturn, "Braille Statement with Cheque Image Return");
        return this;
    }


    /**
     * Select  Interest Arrangement
     *
     * @param intrestArrangement passing Intended Use
     */
    public DayToDayHighwayOptions selectInterestArrangement(String intrestArrangement) {
        selectDropDownByVisibleText(this.interestArrangement, intrestArrangement);
        return this;
    }

    /**
     * Select  intendedUse
     *
     * @param intendedUse passing Intended Use
     */
    public DayToDayHighwayOptions selectIntendedUse(String intendedUse) {
        selectDropDownByVisibleText(this.intendedUse, intendedUse);
        return this;
    }

    /**
     * Select  Reason for Account Open.
     *
     * @param reasonForAccountOpen passing Reason for Account Open
     */
    public DayToDayHighwayOptions selectReasonForAccountOpen(String reasonForAccountOpen) {
        selectDropDownByVisibleText(this.reasonForAccountOpen, reasonForAccountOpen);
        return this;
    }

    /**
     * Select  Source of Funds.
     *
     * @param sourceOfFunds passing Source of Funds.
     */
    public DayToDayHighwayOptions selectSourceOfFunds(String sourceOfFunds) {
        selectDropDownByVisibleText(this.sourceOfFunds, sourceOfFunds);
        return this;
    }


    /**
     * click Apply New Account Message
     */
    public DayToDayHighwayOptions clickApplyNewAccountMessage() {
        click(applyNewAccountMessage, "Apply New Account Message ");
        return this;
    }

    /**
     * Select  ScotiaCard Account access
     *
     * @param scotiacardAccountAccess passing Source of Funds.
     */
    public DayToDayHighwayOptions selectScotiaCardAccountAccess(String scotiacardAccountAccess) {
        selectDropDownByVisibleText(this.scotiaCardAccountAccess, scotiacardAccountAccess);
        return this;
    }


    /**
     * click Additional Services
     */
    public DayToDayHighwayOptions clickAdditionalServices() {
        click(additionalServices, "Additional Services");
        return this;
    }

    /**
     * click Payroll Direct Deposit Instructions
     */
    public DayToDayHighwayOptions clickPayrollDirectDepositInstructions() {
        click(payrollDirectDepositInstructions, "Payroll Direct Deposit Instructions");
        return this;
    }

    /**
     * click Company Pre-Authorized Payment Instructions
     */
    public DayToDayHighwayOptions clickCompanyPreAuthorizedPaymentInstructions() {
        click(companyPreAuthorized, "Company Pre-Authorized Payment Instructions");
        return this;
    }

    /**
     * Enter Initial Deposit
     *
     * @param initialDeposit Customer initialDeposit
     */
    public DayToDayHighwayOptions enterInitialDeposit(String initialDeposit) {
        type(this.initialDeposit, initialDeposit, "Initial Deposit");
        return this;
    }


    /**
     * Click on Done button
     */
    public DayToDayHighwayOptions clickDone() {
        click(done, "Done");
        return this;
    }

    /**
     * Click on Back button
     */
    public DayToDayHighwayOptions clickBack() {
        click(back, "Back");
        return this;
    }

    /**
     * Click on Reset button
     */
    public DayToDayHighwayOptions clickReset() {
        click(reset, "Reset");
        return this;
    }

    /**
     * Click on cancel button
     */
    public DayToDayHighwayOwnership clickCancel() {
        click(cancel, "Cancel");
        return new DayToDayHighwayOwnership(webDriver);
    }

    /**
     * Switches to Day To Day Highway Options web page
     */
    public DayToDayHighwayOptions switchToDayToDayHighwayOptionsPage() {
        this.switchToWindow("Day-to-Day Highway - Options|La voie des Opérations Bancaires Courantes - Options");
        return this;
    }


    /**
     * Overrides Base page switchToWindow method
     * by iterating multiple page names based on pipe delimited
     * In this project it is pipe delimited because of english and french names
     *
     * @return
     */
    public Boolean switchToWindow(String window) {
        boolean flag = false;
        String[] webPageNames = window.split("\\|");
        for (String webPageName : webPageNames) {
            flag = super.switchToWindow(webPageName);
            if (flag) {
                break;
            }
        }
        return flag;
    }


}
