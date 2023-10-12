/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:15 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Class is created for entering employment and income information
 */
public class EmploymentAndIncome extends BasePage {

    @FindBy(id = "businessOrEmployer-input")
    private WebElement businessOrEmployer;

    @FindBy(id = "employerTelephone-input")
    private WebElement employerTelephone;

    @FindBy(id = "employmentAddressLine1-input")
    private WebElement addressLine1;

    @FindBy(id = "employmentAddressLine2-input")
    private WebElement addressLine2;

    @FindBy(id = "employmentCity-input")
    private WebElement city;

    @FindBy(id = "employmentProvince")
    private WebElement provinceOrState;

    @FindBy(id = "employmentCountry")
    private WebElement country;

    @FindBy(id = "employmentZipCode-input")
    private WebElement postalOrZipCode;

    @FindBy(id = "employmentStatus")
    private WebElement employmentStatus;

    @FindBy(id = "employmentIndustry")
    private WebElement industry;

    @FindBy(id = "occupation_name")
    private WebElement occupation;

    @FindBy(xpath = "//div[@class='optionLabel']")
    private WebElement occupationOption;

    @FindBy(id = "lengthOfCurrentEmploymentYears-input")
    private WebElement lengthOfCurrentEmploymentYears;

    @FindBy(id = "lengthOfCurrentEmploymentMonths-input")
    private WebElement lengthOfCurrentEmploymentMonths;

    @FindBy(id = "lengthOfOccupationYears-input")
    private WebElement lengthOfOccupationYears;

    @FindBy(id = "lengthOfOccupationMonths-input")
    private WebElement lengthOfOccupationMonths;

    @FindBy(id = "grossMonthlyIncome-currency")
    private WebElement grossMonthlyIncome;

    @FindBy(id = "otherIncomeAmountPerMonth-currency")
    private WebElement otherIncomeAmountPerMonth;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public EmploymentAndIncome(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Enter Business/Employer for Employment and Income
     *
     * @param businessOrEmployer passing Business/Employer Name
     */
    public EmploymentAndIncome enterBusinessOrEmployer(String businessOrEmployer) throws InterruptedException {
        type(this.businessOrEmployer, businessOrEmployer,
                "Business/Employer");
        return this;
    }

    /**
     * Enter Telephone for Employment and Income
     *
     * @param employerTelephone passing Business/Employer Name
     */
    public EmploymentAndIncome enterEmployerTelephone(String employerTelephone) throws InterruptedException {
        type(this.employerTelephone, employerTelephone,
                "Employer Telephone");
        return this;
    }

    /**
     * Enter AddressLine1 for Business/Employer Address
     *
     * @param addressLine1 passing Address Line1
     */
    public EmploymentAndIncome enterAddressLine1(String addressLine1) throws InterruptedException {
        type(this.addressLine1, addressLine1,
                "Address Line 1");
        return this;
    }

    /**
     * Enter AddressLine2 for Business/Employer Address
     *
     * @param addressLine2 passing Address Line 2
     */
    public EmploymentAndIncome enterAddressLine2(String addressLine2) throws InterruptedException {
        type(this.addressLine2, addressLine2,
                "Address Line 2");
        return this;
    }

    /**
     * Enter City for Business/Employer Address
     *
     * @param city passing City
     */
    public EmploymentAndIncome enterCity(String city) throws InterruptedException {
        type(this.city, city,
                "City");
        return this;
    }

    /**
     * Select  Province or State for Business/Employer Address
     *
     * @param provinceOrState passing Province or State
     */
    public EmploymentAndIncome selectProvinceOrState(String provinceOrState) {
        selectDropDownByVisibleText(this.provinceOrState, provinceOrState);
        return this;
    }

    /**
     * Select  Country for Business/Employer Address
     *
     * @param country passing country
     */
    public EmploymentAndIncome selectCountry(String country) {
        selectDropDownByVisibleText(this.country, country);
        return this;
    }

    /**
     * Enter Postal/Zip code for Business/Employer Address
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public EmploymentAndIncome enterPostalOrZipcode(String postalOrZipCode) throws InterruptedException {
        type(this.postalOrZipCode, postalOrZipCode,
                "Postal Code");
        return this;
    }

    /**
     * Select  Employment for Business/Employer Address
     *
     * @param employmentStatus passing Employment
     */
    public EmploymentAndIncome selectEmploymentStatus(String employmentStatus) {
        selectDropDownByVisibleText(this.employmentStatus, employmentStatus);
        return this;
    }

    /**
     * Select  Industry for Business/Employer Address
     *
     * @param industry passing Industry
     */
    public EmploymentAndIncome selectIndustry(String industry) {
        selectDropDownByVisibleText(this.industry, industry);
        return this;
    }

    /**
     * Enter Occupation for Business/Employer Address
     *
     * @param occupation passing Occupation
     */
    public EmploymentAndIncome enterOccupation(String occupation) throws InterruptedException, IOException {
        type(this.occupation, occupation,
                "Occupation");
        click(occupationOption, "Occupation Option");
        return this;
    }

    /**
     * Enter Length of current employment for Years
     *
     * @param lengthOfCurrentEmploymentYears passing Length of current employment for Years
     */
    public EmploymentAndIncome enterLengthOfCurrentEmploymentYears(String lengthOfCurrentEmploymentYears) throws InterruptedException {
        type(this.lengthOfCurrentEmploymentYears, lengthOfCurrentEmploymentYears,
                "Employment Years");
        return this;
    }

    /**
     * Enter Length of current employment for Months
     *
     * @param lengthOfCurrentEmploymentMonths passing Length of current employment for Years
     */
    public EmploymentAndIncome enterLengthOfCurrentEmploymentMonths(String lengthOfCurrentEmploymentMonths) throws InterruptedException {
        type(this.lengthOfCurrentEmploymentMonths, lengthOfCurrentEmploymentMonths,
                "Employment Months");
        return this;
    }

    /**
     * Enter Length of occupation for Years
     *
     * @param lengthOfOccupationYears passing Length of occupation for Years
     */
    public EmploymentAndIncome enterLengthOfOccupationYears(String lengthOfOccupationYears) throws InterruptedException {
        type(this.lengthOfOccupationYears, lengthOfOccupationYears,
                "Occupation Years");
        return this;
    }

    /**
     * Enter Length of occupation for Months
     *
     * @param lengthOfOccupationtMonths passing Length of occupation for Months
     */
    public EmploymentAndIncome enterLengthOfOccupationMonths(String lengthOfOccupationtMonths) throws InterruptedException {
        type(this.lengthOfOccupationMonths, lengthOfOccupationtMonths,
                "Occupation Months");
        return this;
    }

    /**
     * Enter Gross Monthly Income
     *
     * @param grossMonthlyIncome passing Gross monthly income
     */
    public EmploymentAndIncome enterGrossMonthlyIncome(String grossMonthlyIncome) throws InterruptedException {
        type(this.grossMonthlyIncome, grossMonthlyIncome,
                "Gross Monthly Income");
        return this;
    }

    /**
     * Enter Other Income Amount Per Month
     *
     * @param otherIncomeAmountPerMonth passing Length of occupation for Months
     */
    public EmploymentAndIncome enterOtherIncomeAmountPerMonth(String otherIncomeAmountPerMonth) throws InterruptedException {
        type(this.otherIncomeAmountPerMonth, otherIncomeAmountPerMonth,
                "Other Income Amount Per Month");
        return this;
    }

    /**
     * Click on next link
     */
    public MulticulturalInformation clickNext() throws IOException {
        click(next, "Next navigates to Multicultural Information");
        return new MulticulturalInformation(webDriver);
    }
}
