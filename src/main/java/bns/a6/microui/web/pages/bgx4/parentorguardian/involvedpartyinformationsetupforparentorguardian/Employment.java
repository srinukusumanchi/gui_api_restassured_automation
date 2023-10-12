/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:15 a.m.
 */

package bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for entering employment information
 */
public final class Employment extends BasePage {

    @FindBy(id = "involvedParty_businessOrEmployer-input")
    private WebElement businessOrEmployer;

    @FindBy(id = "involvedParty_employmentStatus")
    private WebElement employmentStatus;

    @FindBy(id = "involvedParty_employmentIndustry")
    private WebElement industry;

    @FindBy(id = "occupation_name")
    private WebElement occupation;

    @FindBy(xpath = "//div[@class='optionLabel']")
    private WebElement occupationOption;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public Employment(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Enter Business/Employer for Employment and Income
     *
     * @param businessOrEmployer passing Business/Employer Name
     */
    public Employment enterBusinessOrEmployer(String businessOrEmployer) {
        type(this.businessOrEmployer, businessOrEmployer,
                "Business/Employer");
        return this;
    }

    /**
     * Select  Employment for Business/Employer Address
     *
     * @param employmentStatus passing Employment
     */
    public Employment selectEmploymentStatus(String employmentStatus) {
        selectDropDownByVisibleText(this.employmentStatus, employmentStatus);
        return this;
    }

    /**
     * Select  Industry for Business/Employer Address
     *
     * @param industry passing Industry
     */
    public Employment selectIndustry(String industry) {
        selectDropDownByVisibleText(this.industry, industry);
        return this;
    }

    /**
     * Enter Occupation for Business/Employer Address
     *
     * @param occupation passing Occupation
     */
    public Employment enterOccupation(String occupation) {
        type(this.occupation, occupation,
                "Occupation");
        click(occupationOption, "Occupation Option");
        return this;
    }
}
