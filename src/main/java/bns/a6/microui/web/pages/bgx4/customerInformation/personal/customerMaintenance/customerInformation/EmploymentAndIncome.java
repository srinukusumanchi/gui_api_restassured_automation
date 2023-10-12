/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-11
 * Created Time: 2:54 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.MulticulturalInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public final class EmploymentAndIncome extends bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.EmploymentAndIncome {

    @FindBy(css ="button:has(.ButtonCore__text)")
    private WebElement update;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public EmploymentAndIncome(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Update
     */
    public EmploymentAndIncome clickUpdate() {
        click(update, "Update");
        return this;
    }

    /**
     * Update Business/Employer for Employment and Income
     *
     * @param businessOrEmployer passing Business/Employer Name
     */
    public EmploymentAndIncome enterBusinessOrEmployer(String businessOrEmployer) throws InterruptedException {
        super.enterBusinessOrEmployer(businessOrEmployer);
        return this;
    }

    /**
     * Update Telephone for Employment and Income
     *
     * @param employerTelephone passing Business/Employer Name
     */
    public EmploymentAndIncome enterEmployerTelephone(String employerTelephone) throws InterruptedException {
        super.enterEmployerTelephone(employerTelephone);
        return this;
    }

    /**
     * Update AddressLine1 for Business/Employer Address
     *
     * @param addressLine1 passing Address Line1
     */
    public EmploymentAndIncome enterAddressLine1(String addressLine1) throws InterruptedException {
        super.enterAddressLine1(addressLine1);
        return this;
    }

    /**
     * Update AddressLine2 for Business/Employer Address
     *
     * @param addressLine2 passing Address Line 2
     */
    public EmploymentAndIncome enterAddressLine2(String addressLine2) throws InterruptedException {
        super.enterAddressLine2(addressLine2);
        return this;
    }

    /**
     * Update City for Business/Employer Address
     *
     * @param city passing City
     */
    public EmploymentAndIncome enterCity(String city) throws InterruptedException {
        super.enterCity(city);
        return this;
    }

    /**
     * Update  Province or State for Business/Employer Address
     *
     * @param provinceOrState passing Province or State
     */
    public EmploymentAndIncome selectProvinceOrState(String provinceOrState) {
        super.selectProvinceOrState(provinceOrState);
        return this;
    }

    /**
     * Update  Country for Business/Employer Address
     *
     * @param country passing country
     */
    public EmploymentAndIncome selectCountry(String country) {
        super.selectCountry(country);
        return this;
    }

    /**
     * Update Postal/Zip code for Business/Employer Address
     *
     * @param postalOrZipCode passing Postal or Zip code
     */
    public EmploymentAndIncome enterPostalOrZipcode(String postalOrZipCode) throws InterruptedException {
        super.enterPostalOrZipcode(postalOrZipCode);
        return this;
    }

    /**
     * Update  Employment for Business/Employer Address
     *
     * @param employmentStatus passing Employment
     */
    public EmploymentAndIncome selectEmploymentStatus(String employmentStatus) {
        super.selectEmploymentStatus(employmentStatus);
        return this;
    }

    /**
     * Update  Industry for Business/Employer Address
     *
     * @param industry passing Industry
     */
    public EmploymentAndIncome selectIndustry(String industry) {
        super.selectIndustry(industry);
        return this;
    }

    /**
     * Update Occupation for Business/Employer Address
     *
     * @param occupation passing Occupation
     */
    public EmploymentAndIncome enterOccupation(String occupation) throws InterruptedException, IOException {
        super.enterOccupation(occupation);
        return this;
    }

    /**
     * Update Length of current employment for Years
     *
     * @param lengthOfCurrentEmploymentYears passing Length of current employment for Years
     */
    public EmploymentAndIncome enterLengthOfCurrentEmploymentYears(String lengthOfCurrentEmploymentYears) throws InterruptedException {
        super.enterLengthOfCurrentEmploymentYears(lengthOfCurrentEmploymentYears);
        return this;
    }

    /**
     * Update Length of current employment for Months
     *
     * @param lengthOfCurrentEmploymentMonths passing Length of current employment for Years
     */
    public EmploymentAndIncome enterLengthOfCurrentEmploymentMonths(String lengthOfCurrentEmploymentMonths) throws InterruptedException {
       super.enterLengthOfCurrentEmploymentMonths(lengthOfCurrentEmploymentMonths);
        return this;
    }

    /**
     * Update Length of occupation for Years
     *
     * @param lengthOfOccupationYears passing Length of occupation for Years
     */
    public EmploymentAndIncome enterLengthOfOccupationYears(String lengthOfOccupationYears) throws InterruptedException {
        super.enterLengthOfOccupationYears(lengthOfOccupationYears);
        return this;
    }

    /**
     * Update Length of occupation for Months
     *
     * @param lengthOfOccupationtMonths passing Length of occupation for Months
     */
    public EmploymentAndIncome enterLengthOfOccupationMonths(String lengthOfOccupationtMonths) throws InterruptedException {
        super.enterLengthOfOccupationMonths(lengthOfOccupationtMonths);
        return this;
    }

    /**
     * Update Gross Monthly Income
     *
     * @param grossMonthlyIncome passing Gross monthly income
     */
    public EmploymentAndIncome enterGrossMonthlyIncome(String grossMonthlyIncome) throws InterruptedException {
        super.enterGrossMonthlyIncome(grossMonthlyIncome);
        return this;
    }

    /**
     * Update Other Income Amount Per Month
     *
     * @param otherIncomeAmountPerMonth passing Length of occupation for Months
     */
    public EmploymentAndIncome enterOtherIncomeAmountPerMonth(String otherIncomeAmountPerMonth) throws InterruptedException {
        super.enterOtherIncomeAmountPerMonth(otherIncomeAmountPerMonth);
        return this;
    }


    /**
     * Click on next link
     */
    public MulticulturalInformation clickNext() throws IOException {
        super.clickNext();
        return new MulticulturalInformation(webDriver);
    }

}
