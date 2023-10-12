

package bns.a6.microui.web.pages.accounts.accountsetup.business.businessaccountwithoutcreditbureau;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class BusinessAccountOpenOwnership extends BasePage {

    @FindBy(name = "ownBusinessTradingName1")
    private WebElement alsoTradingAs1;

    @FindBy(name = "ownBusinessTradingName2")
    private WebElement alsoTradingAs2;

    @FindBy(id= "smallBusinessSegment")
    private WebElement smallBusinessSegment;

    @FindBy(id= "ownAccountType")
    private WebElement accountType;

    @FindBy(xpath = "//input[@value='BUSINESS_OWNED_BY_ANOTHER_COMPANY_NO']")
    private WebElement IsTheBusinessOwnedByAnotherCompanyNo;

    @FindBy(xpath = "//input[@value='BUSINESS_OWNED_BY_ANOTHER_COMPANY_YES']")
    private WebElement IsTheBusinessOwnedByAnotherCompanyYes;

    @FindBy(name="ownSigningOfficerAccount0")
    private WebElement signingOfficerAccount;

    @FindBy(name="ownSigningOfficerBorrowing0")
    private WebElement signingOfficerBorrowing;

    @FindBy(name="ownDirector0")
    private WebElement director;

    @FindBy(xpath = "//a[contains(@href,\"javascript:showAssociatedPerson('0');\")]")
    private WebElement name;

    @FindBy(name="ownTitle0")
    private WebElement title;

    @FindBy(xpath = "//a[contains(@href,\"javascript:addASigningOfficer();\")]")
    private WebElement addASigningOfficer;

    @FindBy(xpath = "//a[contains(@href,\"javascript:addADirector();\")]")
    private WebElement addADirector;

    @FindBy(id="ownCombinationOfSignaturesOperating")
    private WebElement combinationOfSignaturesAnyToSignForInstructionVerificationAndApprovals;

    @FindBy(id="ownCombinationOfSignaturesBorrowing")
    private WebElement combinationOfSignaturesAnyToSignForBorrowing;

    @FindBy(name="Cancel")
    private WebElement cancel;

    @FindBy(name="Next")
    private WebElement next;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public BusinessAccountOpenOwnership(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select  small Business Segment
     * @param smallBusinessSegment passing small Business Segment
     */
    public BusinessAccountOpenOwnership selectSmallBusinessSegment(String smallBusinessSegment) {
        selectDropDownByVisibleText(this.smallBusinessSegment, smallBusinessSegment);
        return this;
    }

    /**
     * Select  account Type
     * @param accountType passing accountType
     */
    public BusinessAccountOpenOwnership selectAccountType(String accountType) {
        selectDropDownByVisibleText(this.accountType, accountType);
        return this;
    }


    /**
     * Click Is the Business Owned By Another Company as  'No'
     */
    public BusinessAccountOpenOwnership clickIsTheBusinessOwnedByAnotherCompanyNo() {
        click(IsTheBusinessOwnedByAnotherCompanyNo, "Is the Business Owned By Another Company - NO");
        return this;
    }

    /**
     * Click Is the Business Owned By Another Company as  'Yes'
     *
     */
    public BusinessAccountOpenOwnership clickIsTheBusinessOwnedByAnotherCompanyYes() {
        click(IsTheBusinessOwnedByAnotherCompanyYes, "Is the Business Owned By Another Company - Yes");
        return this;
    }

    /**
     * Select  Title from title dropdown
     * @param Title passing owner Title
     */
    public BusinessAccountOpenOwnership selectTitle(String Title) {
        selectDropDownByVisibleText(this.title, Title);
        return this;
    }

    /**
     * Check signing Officer Account checkbox
     *
     */
    public BusinessAccountOpenOwnership clickSigningOfficerAccount() {
        click(signingOfficerAccount, "Signing Officer Account");
        return this;
    }

    /**
     * Check signing Officer Borrowing checkbox
     *
     */
    public BusinessAccountOpenOwnership clickSigningOfficerBorrowing() {
        click(signingOfficerBorrowing, "Signing Officer Borrowing");
        return this;
    }

    /** Check Director checkbox for Owner
     *
     */
    public BusinessAccountOpenOwnership clickDirector() {
        click(director, "Director");
        return this;
    }

    /**
     * Select  Combination of Signatures, Any to sign for insturctions verifications and approvals
     * @param combinationOfSignaturesAnyToSignForInstructionVerificationAndApprovals
     * passing Combination of Signatures, Any to sign for insturctions verifications and approvals
     */
    public BusinessAccountOpenOwnership
    selectCombinationOfSignaturesAnyToSignForInstructionVerificationAndApprovals
    (String combinationOfSignaturesAnyToSignForInstructionVerificationAndApprovals) {
        selectDropDownByVisibleText(this.combinationOfSignaturesAnyToSignForInstructionVerificationAndApprovals, combinationOfSignaturesAnyToSignForInstructionVerificationAndApprovals);
        return this;
    }

    /**
     * Select  Combination of signatures, Any to sign for borrowing
     * @param combinationOfSignaturesAnyToSignForBorrowing
     * passing Combination of signatures, Any to sign for borrowing
     */
    public BusinessAccountOpenOwnership selectCombinationOfSignatureBorrowing(String combinationOfSignaturesAnyToSignForBorrowing) {
        selectDropDownByVisibleText(this.combinationOfSignaturesAnyToSignForBorrowing, combinationOfSignaturesAnyToSignForBorrowing);
        return this;
    }

    /**
     * Click on Next button
     */
    public BusinessAccountOpenOwnership clickNext() {
        click(next, "Next");
        return this;
    }

    /**
     * Click on Cancel button
     */
    public BusinessAccountOpenOwnership clickCancel() {
        click(cancel, "Cancel");
        return this;
    }

}
