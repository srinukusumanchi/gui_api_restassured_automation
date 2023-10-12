package bns.a6.microui.web.pages.accounts.accountsetup.business.businessaccountwithoutcreditbureau;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public final class BusinessAccountOpenOptionsI extends BasePage {

    @FindBy(name="intendedUseOfAccount")
    private WebElement intendedUseOfAccount;

    @FindBy(xpath = "//input[@value='OPT_THIRDPARTY_NO']")
    private WebElement willYoubeReceivingInstructionsFromAThirdPartyOnHowToUseAccountNo;

    @FindBy(xpath = "//input[@value='OPT_THIRDPARTY_YES']")
    private WebElement willYoubeReceivingInstructionsFromAThirdPartyOnHowToUseAccountYes;

    @FindBy(xpath = "//input[@value='typeAccountPlan']")
    private WebElement accountPlan;

    @FindBy(xpath = "//input[@value='typeBasicBusiness']")
    private WebElement basicBusinessAccount;

    @FindBy(xpath = "//a[contains(@href,'javascript:trdpartyEformLink();')]")
    private WebElement thirdPartyEform;

    @FindBy(xpath = "//a[contains(@href,'javascript:openHelp(thirdPartyDeterminationURL)')]")
    private WebElement thirdPartyDetermination;

    @FindBy(name="optionsForSpecialtyAccountPlan")
    private WebElement specialityAccountPlanOptions;

    @FindBy(name="optionsForTieredAccountPlan")
    private WebElement tieredPricingOptions;

    @FindBy(name="optWaiveFeePeriod")
    private WebElement waiveFeePeriod;

    @FindBy(name="optPromotionCode")
    private WebElement promotionCode;

    @FindBy(xpath = "//input[@name='optElectronicBanking' and @value = '1']")
    private WebElement changeStandaloneElectronicBankingFeeYes;

    @FindBy(xpath = "//input[@name='optElectronicBanking' and @value = '0']")
    private WebElement changeStandaloneElectronicBankingFeeNo;

    @FindBy(name="recordKeepingTypeOption")
    private WebElement recordKeepingOption;

    @FindBy(name="assocAffilFranchisee")
    private WebElement assosciationOrAffiliation;

    @FindBy(name="Next")
    private WebElement next;

    @FindBy(name="Back")
    private WebElement back;

    @FindBy(name="Reset")
    private WebElement reset;

    @FindBy(name="Cancel")
    private WebElement cancel;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public BusinessAccountOpenOptionsI(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select Intended Use Of Account
     *
     * @param intendedUseOfAccount passing Intended Use Of Account
     */
    public BusinessAccountOpenOptionsI selectIntendedUseOfAccount(String intendedUseOfAccount) {
        selectDropDownByVisibleText(this.intendedUseOfAccount, intendedUseOfAccount);
        return this;
    }

    /**
     * Click on Will you be Receiving Instructions from a third party on how to use the account - No
     */
    public BusinessAccountOpenOptionsI clickWillYouBeReceivingInstructionsFromAThirdPartyOnHowToUseTheAccountNo() {
        click(willYoubeReceivingInstructionsFromAThirdPartyOnHowToUseAccountNo,
                "Will you be Receiving Instructions from a third party on how to use the account - No");
        return this;
    }

    /**
     * Click on Account Type - Account Plan
     *
     */
    public BusinessAccountOpenOptionsI clickAccountPlan() {
        click(willYoubeReceivingInstructionsFromAThirdPartyOnHowToUseAccountNo,
                "Will you be Receiving Instructions from a third party on how to use the account - No");
        return this;
    }

    /**
     * Click on Will you be Receiving Instructions from a third party on how to use the account - Yes
     *
     */
    public BusinessAccountOpenOptionsI clickWillYouBeReceivingInstructionsFromAThirdPartyOnHowToUseTheAccountYes() {
        click(willYoubeReceivingInstructionsFromAThirdPartyOnHowToUseAccountYes,
                "Will you be Receiving Instructions from a third party on how to use the account - Yes");
        return this;
    }


    /**
     * Click on Basic Business Account radio button
     *
     */
    public BusinessAccountOpenOptionsI clickBasicBusinessAccount() {
        click(basicBusinessAccount, "Basic Business Account");
        return this;
    }


    /**
     * Click on Charge standalone electronic Banking Fee - NO
     *
     */
    public BusinessAccountOpenOptionsI clickChargeStandaloneElectronicBankingFeeNo() {
        click(changeStandaloneElectronicBankingFeeNo, "Charge standalone electronic Banking Fee - NO");
        return this;
    }

    /**
     * Click on Charge standalone electronic Banking Fee - Yes
     *
     */
    public BusinessAccountOpenOptionsI clickChargeStandaloneElectronicBankingFeeYes() {
        click(changeStandaloneElectronicBankingFeeYes, "Charge standalone electronic Banking Fee - Yes");
        return this;
    }

    /**
     * Select Record Keeping Option
     *
     * @param recordKeepingOption passing Record KeepingOption
     */
    public BusinessAccountOpenOptionsI selectRecordKeepingOption(String recordKeepingOption) {
        selectDropDownByVisibleText(this.recordKeepingOption, recordKeepingOption);
        return this;
    }

    /**
     * Click on Next button
     *
     */
    public BusinessAccountOpenOptionsI clickNext() {
        click(next, "Next");
        acceptAlert();
        return this;
    }
}