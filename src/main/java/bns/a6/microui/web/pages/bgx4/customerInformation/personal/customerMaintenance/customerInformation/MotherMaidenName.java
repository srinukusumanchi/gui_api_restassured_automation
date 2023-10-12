/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-11
 * Created Time: 2:53 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MotherMaidenName extends BasePage {

    @FindBy(id = "mothersMaidenNamecardNumber")
    private WebElement cardNumber;

    @FindBy(id = "primarySoleMothersMaidenName-input")
    private WebElement primaryOrSoleMothersMaidenName;

    @FindBy(xpath = "//span[text()='Verify']/parent::button")
    private WebElement verify;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public MotherMaidenName(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select  CardNumber
     *
     * @param cardNumber passing Address Type
     */
    public MotherMaidenName selectCardNumber(String cardNumber) {
        selectDropDownByVisibleText(this.cardNumber, cardNumber);
        return this;
    }

    /**
     * Enter Primary/Sole Mother's Maiden Name
     *
     * @param primaryOrSoleMothersMaidenName passing Email address
     */
    public MotherMaidenName enterPrimaryOrSoleMothersMaidenName(String primaryOrSoleMothersMaidenName) {
        type(this.primaryOrSoleMothersMaidenName, primaryOrSoleMothersMaidenName,
                "Primary/Sole Mother's Maiden Name");
        return this;
    }

    /**
     * Click Verify
     */
    public MotherMaidenName clickVerify() {
        click(verify, "Verify");
        return this;
    }

}
