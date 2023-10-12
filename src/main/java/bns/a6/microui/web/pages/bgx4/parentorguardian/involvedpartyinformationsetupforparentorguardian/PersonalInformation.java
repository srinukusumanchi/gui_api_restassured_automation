/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:14 a.m.
 */

package bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian;

import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.AddressInformation;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for entering personal information
 */
public final class PersonalInformation extends BasePage {

    @FindBy(id = "involvedParty_languageChoice")
    private WebElement languageChoice;

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
     * Select  Language choice
     *
     * @param languageChoice passing Gender
     */
    public PersonalInformation selectLanguageChoice(String languageChoice) {
        selectDropDownByVisibleText(this.languageChoice, languageChoice);
        return this;
    }


    /**
     * Click on next link
     */
    public AddressInformation clickNext() {
        click(next, "Next navigates to Address Information");
        return new AddressInformation(webDriver);
    }

}
