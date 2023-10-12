/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-11
 * Created Time: 2:54 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public final class MulticulturalInformation extends bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.MulticulturalInformation {

    @FindBy(css ="button:has(.ButtonCore__text)")
    private WebElement update;

    @FindBy(css ="#multiculturalInformation")
    private WebElement multiculturalInformation;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public MulticulturalInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Update
     */
    public MulticulturalInformation clickUpdate() {
        click(update, "Update");
        return this;
    }

    /**
     * Click on Multicultural Information
     */
    public MulticulturalInformation clickMulticulturalInformation() {
        click(multiculturalInformation, "Multicultural Information");
        return this;
    }



    /**
     * Update  Multicultural Programs - Yes
     */
    public MulticulturalInformation selectMultiCulturalProgramsYes() throws IOException {
        super.selectMultiCulturalProgramsYes();
        return this;
    }

    /**
     * Select  Multicultural Program checked for -Yes
     */
    public String isMultiCulturalProgramYesChecked
    (String value) throws IOException {
        return super.isMultiCulturalProgramYesChecked("value");
    }

    /**
     * Update Date of Arrival
     *
     * @param dateOfArrival passing Date of Arrival
     */
    public MulticulturalInformation enterDateOfArrival(String dateOfArrival) throws InterruptedException {
        super.enterDateOfArrival(dateOfArrival);
        return this;
    }

    /**
     * Update Date of Arrival Not Provided
     */
    public MulticulturalInformation selectNotProvided() throws IOException {
        super.selectNotProvided();
        return new MulticulturalInformation(webDriver);
    }

    /**
     * Update  House hold language
     *
     * @param houseHoldLanguage passing country
     */
    public MulticulturalInformation selectHouseHoldLanguage(String houseHoldLanguage) {
        super.selectHouseHoldLanguage(houseHoldLanguage);
        return this;
    }

    /**
     * Update  Source
     *
     * @param source passing country
     */
    public MulticulturalInformation selectSource(String source) {
        super.selectSource(source);
        return this;
    }

    /**
     * Update  IMM Category
     *
     * @param immCategory passing country
     */
    public MulticulturalInformation selectIMMCategory(String immCategory) {
        super.selectIMMCategory(immCategory);
        return this;
    }

}
