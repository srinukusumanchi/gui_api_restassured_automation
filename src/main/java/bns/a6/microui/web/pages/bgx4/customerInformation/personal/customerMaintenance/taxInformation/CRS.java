/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:17 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.taxInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class CRS extends BasePage {

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

    @FindBy(xpath = "//span[text()='Add' or text()='Ajouter']/ancestor::button")
    private WebElement add;

    @FindBy(xpath = "//span[text()='No' or text()='Non']")
    private WebElement noTaxResidencyInformation;


    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CRS(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click Yes for Tax Residency Information
     */
    public CRS clickYesTaxResidencyInformation() {
        click(yesTaxResidencyInformation, "Yes - Are you required to file a tax return " +
                "in any country other than the U.S or Canada?");
        return this;
    }

    /**
     * Select Country1
     *
     * @param country1 passing Country
     */
    public CRS selectCountry1(String country1) {
        selectDropDownByVisibleText(this.country1, country1);
        return this;
    }

    /**
     * Select Country2
     *
     * @param country2 passing Country
     */
    public CRS selectCountry2(String country2) {
        selectDropDownByVisibleText(this.country2, country2);
        return this;
    }

    /**
     * Select Country3
     *
     * @param country3 passing Country
     */
    public CRS selectCountry3(String country3) {
        selectDropDownByVisibleText(this.country3, country3);
        return this;
    }

    /**
     * Enter TIN1
     *
     * @param tin1 passing TIN1
     */
    public CRS enterTin1(String tin1) {
        type(this.tin1, tin1, "TIN-1");
        return this;
    }

    /**
     * Enter TIN2
     *
     * @param tin2 passing TIN2
     */
    public CRS enterTin2(String tin2) {
        type(this.tin2, tin2, "TIN-2");
        return this;
    }

    /**
     * Enter TIN3
     *
     * @param tin3 passing TIN3
     */
    public CRS enterTin3(String tin3) {
        type(this.tin3, tin3, "TIN-3");
        return this;
    }

    /**
     * Select No TIN Reason Code1
     *
     * @param noTinReasonCode1 passing No TIN Reason Code1
     */
    public CRS selectNoTinReasonCode1(String noTinReasonCode1) {
        selectDropDownByVisibleText(this.noTinReasonCode1, noTinReasonCode1);
        return this;
    }

    /**
     * Select No TIN Reason Code2
     *
     * @param noTinReasonCode2 passing No TIN Reason Code2
     */
    public CRS selectNoTinReasonCode2(String noTinReasonCode2) {
        selectDropDownByVisibleText(this.noTinReasonCode2, noTinReasonCode2);
        return this;
    }

    /**
     * Select No TIN Reason Cod3
     *
     * @param noTinReasonCode3 passing No TIN Reason Code3
     */
    public CRS selectNoTinReasonCode3(String noTinReasonCode3) {
        selectDropDownByVisibleText(this.noTinReasonCode3, noTinReasonCode3);
        return this;
    }

    /**
     * Enter Explanation1
     *
     * @param explanation1 passing Explanation1
     */
    public CRS enterExplanation1(String explanation1) {
        type(this.explanation1, explanation1, "Explanation-1");
        return this;
    }

    /**
     * Enter Explanation2
     *
     * @param explanation2 passing Explanation1
     */
    public CRS enterExplanation2(String explanation2) {
        type(this.explanation2, explanation2, "Explanation-2");
        return this;
    }

    /**
     * Enter Explanation3
     *
     * @param explanation3 passing Explanation1
     */
    public CRS enterExplanation3(String explanation3) {
        type(this.explanation3, explanation3, "Explanation-3");
        return this;
    }

    /**
     * Click Add
     */
    public CRS clickAdd() {
        click(add, "Add");
        return this;
    }

    /**
     * Click No for Tax Residency Information
     */
    public CRS clickNoTaxResidencyInformation() {
        click(noTaxResidencyInformation, "No - Are you required to file a tax return " +
                "in any country other than the U.S or Canada?");
        return this;
    }

}
