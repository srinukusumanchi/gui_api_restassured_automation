/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-11
 * Created Time: 2:52 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public final class PersonalInformation extends bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.PersonalInformation {


    @FindBy(id = "dateDeceased-start-input")
    private WebElement dateDeceased;

    @FindBy(id = "transit-input")
    private WebElement transit;

    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement update;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public PersonalInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Update Social Insurance Number
     *
     * @param socialInsuranceNumber passing Social Insurance Number
     */
    public PersonalInformation enterSocialInsuranceNumber(String socialInsuranceNumber) throws InterruptedException {
        super.enterSocialInsuranceNumber(socialInsuranceNumber);
        return this;
    }


    /**
     * Update  Profile status
     *
     * @param profileStatus passing Profile Status
     */
    public PersonalInformation selectProfileStatus(String profileStatus) {
        super.selectProfileStatus(profileStatus);
        return this;
    }

    /**
     * Update  Gender
     *
     * @param gender passing Gender
     */
    public PersonalInformation selectGender(String gender) {
        super.selectGender(gender);
        return this;
    }


    /**
     * Update Number of dependents
     *
     * @param numberOfDependents passing Number of dependents
     */
    public PersonalInformation enterNumberOfDependents(String numberOfDependents) throws InterruptedException {
        super.enterNumberOfDependents(numberOfDependents);
        return this;
    }

    /**
     * Update Bankruptcy Date
     *
     * @param bankruptcy passing Bankruptcy Date
     */
    public PersonalInformation enterBankruptcyDate(String bankruptcy) throws InterruptedException {
        super.enterBankruptcyDate(bankruptcy);
        return this;
    }

    /**
     * Update Date deceased Date
     *
     * @param dateDeceased passing Bankruptcy Date
     */
    public PersonalInformation enterDateDeceasedDate(String dateDeceased) {
        type(this.dateDeceased, dateDeceased,
                "Date Deceased");
        return this;
    }

    /**
     * Update  Language choice
     *
     * @param languageChoice passing Gender
     */
    public PersonalInformation selectLanguageChoice(String languageChoice) {
        super.selectLanguageChoice(languageChoice);
        return this;
    }

    /**
     * Update  Marital status
     *
     * @param maritalStatus passing Gender
     */
    public PersonalInformation selectMaritalStatus(String maritalStatus) {
        super.selectMaritalStatus(maritalStatus);
        return this;
    }

    /**
     * Update Transit
     *
     * @param transit passing transit
     */
    public PersonalInformation enterTransit(String transit) {
        type(this.transit, transit,
                "Transit");
        return this;
    }


    /**
     * Update Sensitivity Code
     *
     * @param sensitivityCode passing Sensitivity Code
     */
    public PersonalInformation selectSensitivityCode(String sensitivityCode) {
        super.selectSensitivityCode(sensitivityCode);
        return this;
    }


    /**
     * Click on Update
     */
    public PersonalInformation clickUpdate() {
        click(update, "Update");
        return this;
    }

    /**
     * Click on next link
     *
     * @return
     */
    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.AddressInformation clickNext() throws IOException {
        super.clickNext();
        return new bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.AddressInformation(webDriver);
    }

}
