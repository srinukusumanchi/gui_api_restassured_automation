/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:16 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Class is created for entering multicultural information
 */
public class MulticulturalInformation extends BasePage {

    @FindBy(xpath = "//p[@aria-label='Multicultural Programs Yes' or @aria-label='Programmes multiculturels Oui']/parent::div/parent::div/preceding-sibling::span")
    private WebElement multiculturalProgramsYes;

    @FindBy(xpath = "//p[@aria-label='Multicultural Programs No' or @aria-label='Programmes multiculturels Non']/parent::div/parent::div/preceding-sibling::span")
    private WebElement multiculturalProgramsNo;

    @FindBy(xpath = "//p[@aria-label='Multicultural Programs Yes' or @aria-label='Programmes multiculturels Oui']/parent::div/parent::div/preceding-sibling::span/preceding-sibling::input")
    private WebElement ismulticulturalProgramsYesChecked;

    @FindBy(id = "dateOfArrival-start-input")
    private WebElement dateOfArrival;

    @FindBy(xpath = "//span[text()='Not Provided' or text()='Non disponible']/parent::p/parent::div/preceding-sibling::span")
    private WebElement notProvided;

    @FindBy(id = "householdLanguage")
    private WebElement houseHoldLanguage;

    @FindBy(id = "source")
    private WebElement source;

    @FindBy(id = "IMMCategory")
    private WebElement immCategory;

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
     * Select  Multicultural Programs - Yes
     */
    public MulticulturalInformation selectMultiCulturalProgramsYes() throws IOException {
            click(multiculturalProgramsYes, "Yes");
        return this;
    }

    /**
     * Select  Multicultural Programs - No
     */
    public MulticulturalInformation selectMultiCulturalProgramsNo() {
        click(multiculturalProgramsNo, "No");
        return this;
    }

    /**
     * Select  Multicultural Program checked for -Yes
     */
    public String isMultiCulturalProgramYesChecked
    (String value) throws IOException {
        return getAttribute(ismulticulturalProgramsYesChecked,value);
    }

    /**
     * Enter Date of Arrival
     *
     * @param dateOfArrival passing Date of Arrival
     */
    public MulticulturalInformation enterDateOfArrival(String dateOfArrival) throws InterruptedException {
        type(this.dateOfArrival, dateOfArrival,
                "Date of Arrival");
        return this;
    }

    /**
     * Select Date of Arrival Not Provided
     */
    public MulticulturalInformation selectNotProvided() throws IOException {
        click(notProvided, "Not Provided");
        return new MulticulturalInformation(webDriver);
    }

    /**
     * Select  House hold language
     *
     * @param houseHoldLanguage passing country
     */
    public MulticulturalInformation selectHouseHoldLanguage(String houseHoldLanguage) {
        selectDropDownByVisibleText(this.houseHoldLanguage, houseHoldLanguage);
        return this;
    }

    /**
     * Select  Source
     *
     * @param source passing country
     */
    public MulticulturalInformation selectSource(String source) {
        selectDropDownByVisibleText(this.source, source);
        return this;
    }

    /**
     * Select  IMM Category
     *
     * @param immCategory passing country
     */
    public MulticulturalInformation selectIMMCategory(String immCategory) {
        selectDropDownByVisibleText(this.immCategory, immCategory);
        return this;
    }
}
