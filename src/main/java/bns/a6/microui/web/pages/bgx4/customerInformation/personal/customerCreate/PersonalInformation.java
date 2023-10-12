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
 * Class is created for entering personal information
 */
public class PersonalInformation extends BasePage {

    @FindBy(id = "sin-input")
    private WebElement socialInsuranceNumber;

    @FindBy(id = "profileStatus")
    private WebElement profileStatus;

    @FindBy(id = "gender")
    private WebElement gender;

    @FindBy(id = "dependentsNum-input")
    private WebElement numberOfDependents;

    @FindBy(id = "bankruptcyDate-start-input")
    private WebElement bankruptcyDate;

    @FindBy(id = "languageChoice")
    private WebElement languageChoice;

    @FindBy(id = "maritalStatus")
    private WebElement maritalStatus;

    @FindBy(id = "sensitivityCode")
    private WebElement sensitivityCode;

    //    Tax Residency Information
    @FindBy(xpath = "//span[text()='Yes' or text()='Oui']")
    private WebElement yesTaxResidencyInformation;

    @FindBy(id = "taxCountry")
    private WebElement country1;

    @FindBy(id = "taxCountry2")
    private WebElement country2;

    @FindBy(id = "taxCountry3")
    private WebElement country3;

    @FindBy(id = "tin-input")
    private WebElement tin1;

    @FindBy(id = "tin2-input")
    private WebElement tin2;

    @FindBy(id = "tin3-input")
    private WebElement tin3;

    @FindBy(id = "noTinReasonCode")
    private WebElement noTinReasonCode1;

    @FindBy(id = "noTinReasonCode2")
    private WebElement noTinReasonCode2;

    @FindBy(id = "noTinReasonCode3")
    private WebElement noTinReasonCode3;

    @FindBy(id = "explanation-input")
    private WebElement explanation1;

    @FindBy(id = "explanation2-input")
    private WebElement explanation2;

    @FindBy(id = "explanation3-input")
    private WebElement explanation3;

    @FindBy(xpath = "//input[@name='privacyAgreementCheckbox']/parent::label/span")
    private WebElement customerConsentToPrivacyAgreement;

    @FindBy(xpath = "//span[text()='Add' or text()='Ajouter']/ancestor::button")
    private WebElement add;

    @FindBy(xpath = "//span[text()='No' or text()='Non']")
    private WebElement noTaxResidencyInformation;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public PersonalInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Enter Social Insurance Number
     *
     * @param socialInsuranceNumber passing Social Insurance Number
     */
    public PersonalInformation enterSocialInsuranceNumber(String socialInsuranceNumber) throws InterruptedException {
        type(this.socialInsuranceNumber, socialInsuranceNumber,
                "Social Insurance Number");
        return this;
    }


    /**
     * Select  Profile status
     *
     * @param profileStatus passing Profile Status
     */
    public PersonalInformation selectProfileStatus(String profileStatus) {
        selectDropDownByVisibleText(this.profileStatus, profileStatus);
        return this;
    }

    /**
     * Select  Gender
     *
     * @param gender passing Gender
     */
    public PersonalInformation selectGender(String gender) {
        selectDropDownByVisibleText(this.gender, gender);
        return this;
    }


    /**
     * Enter Number of dependents
     *
     * @param numberOfDependents passing Number of dependents
     */
    public PersonalInformation enterNumberOfDependents(String numberOfDependents) throws InterruptedException {
        type(this.numberOfDependents, numberOfDependents,
                "Number of dependents");
        return this;
    }

    /**
     * Enter Bankruptcy Date
     *
     * @param bankruptcy passing Bankruptcy Date
     */
    public PersonalInformation enterBankruptcyDate(String bankruptcy) throws InterruptedException {
        type(this.bankruptcyDate, bankruptcy,
                "Bankruptcy Date");
        return this;
    }


    /**
     * Select  Language choice
     *
     * @param languageChoice passing Gender
     */
    public PersonalInformation selectLanguageChoice(String languageChoice) {
        selectDropDownByVisibleText(this.languageChoice, languageChoice);
        return this;
    }

    /**
     * Select  Marital status
     *
     * @param maritalStatus passing Gender
     */
    public PersonalInformation selectMaritalStatus(String maritalStatus) {
        selectDropDownByVisibleText(this.maritalStatus, maritalStatus);
        return this;
    }

    /**
     * Select Sensitivity Code
     *
     * @param sensitivityCode passing Sensitivity Code
     */
    public PersonalInformation selectSensitivityCode(String sensitivityCode) {
        selectDropDownByVisibleText(this.sensitivityCode, sensitivityCode);
        return this;
    }

    /**
     * Click Yes for Tax Residency Information
     */
    public PersonalInformation clickYesTaxResidencyInformation() {
        click(yesTaxResidencyInformation, "Yes - Are you required to file a tax return " +
                "in any country other than the U.S or Canada?");
        return new PersonalInformation(webDriver);
    }

    /**
     * Select Country1
     *
     * @param country1 passing Country
     */
    public PersonalInformation selectCountry1(String country1) {
        selectDropDownByVisibleText(this.country1, country1);
        return this;
    }

    /**
     * Select Country2
     *
     * @param country2 passing Country
     */
    public PersonalInformation selectCountry2(String country2) {
        selectDropDownByVisibleText(this.country2, country2);
        return this;
    }

    /**
     * Select Country3
     *
     * @param country3 passing Country
     */
    public PersonalInformation selectCountry3(String country3) {
        selectDropDownByVisibleText(this.country3, country3);
        return this;
    }

    /**
     * Enter TIN1
     *
     * @param tin1 passing TIN1
     */
    public PersonalInformation enterTin1(String tin1) {
        type(this.tin1, tin1, "TIN-1");
        return this;
    }

    /**
     * Enter TIN2
     *
     * @param tin2 passing TIN2
     */
    public PersonalInformation enterTin2(String tin2) {
        type(this.tin2, tin2, "TIN-2");
        return this;
    }

    /**
     * Enter TIN3
     *
     * @param tin3 passing TIN3
     */
    public PersonalInformation enterTin3(String tin3) {
        type(this.tin3, tin3, "TIN-3");
        return this;
    }

    /**
     * Select No TIN Reason Code1
     *
     * @param noTinReasonCode1 passing No TIN Reason Code1
     */
    public PersonalInformation selectNoTinReasonCode1(String noTinReasonCode1) {
        selectDropDownByVisibleText(this.noTinReasonCode1, noTinReasonCode1);
        return this;
    }

    /**
     * Select No TIN Reason Code2
     *
     * @param noTinReasonCode2 passing No TIN Reason Code2
     */
    public PersonalInformation selectNoTinReasonCode2(String noTinReasonCode2) {
        selectDropDownByVisibleText(this.noTinReasonCode2, noTinReasonCode2);
        return this;
    }

    /**
     * Select No TIN Reason Cod3
     *
     * @param noTinReasonCode3 passing No TIN Reason Code3
     */
    public PersonalInformation selectNoTinReasonCode3(String noTinReasonCode3) {
        selectDropDownByVisibleText(this.noTinReasonCode3, noTinReasonCode3);
        return this;
    }

    /**
     * Enter Explanation1
     *
     * @param explanation1 passing Explanation1
     */
    public PersonalInformation enterExplanation1(String explanation1) {
        type(this.explanation1, explanation1, "Explanation-1");
        return this;
    }

    /**
     * Enter Explanation2
     *
     * @param explanation2 passing Explanation1
     */
    public PersonalInformation enterExplanation2(String explanation2) {
        type(this.explanation2, explanation2, "Explanation-2");
        return this;
    }

    /**
     * Enter Explanation3
     *
     * @param explanation3 passing Explanation1
     */
    public PersonalInformation enterExplanation3(String explanation3) {
        type(this.explanation3, explanation3, "Explanation-3");
        return this;
    }

    /**
     * Click Add
     */
    public PersonalInformation clickAdd() {
        click(add, "Add");
        return new PersonalInformation(webDriver);
    }

    /**
     * Click No for Tax Residency Information
     */
    public PersonalInformation clickNoTaxResidencyInformation() {
        click(noTaxResidencyInformation, "No - Are you required to file a tax return " +
                "in any country other than the U.S or Canada?");
        return new PersonalInformation(webDriver);
    }

    /**
     * Click No for Tax Residency Information
     */
    public PersonalInformation checkCustomerConsentToPrivacyAgreement() {
        click(customerConsentToPrivacyAgreement, "Customer’s consent to Privacy Agreement");
        return new PersonalInformation(webDriver);
    }

    /**
     * Click on next link
     *
     * @return
     */
    public AddressInformation clickNext() throws IOException {
        click(next, "Next navigates to Address Information");
        return new AddressInformation(webDriver);
    }

}
