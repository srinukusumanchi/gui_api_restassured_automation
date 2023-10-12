/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-29
 * Created Time: 1:03 p.m.
 */

package bns.a6.microui.web.pages.bgx4.parentorguardian;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.enums.WaitStrategy;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class PopUps extends BasePage {

    @FindBy(xpath = "//span[text()='Submit' or text()='Terminée']]")
    private WebElement submit;

    @FindBy(id = "modal-dialog-label")
    private WebElement verifiedAddress;

    @FindBy(xpath = "//span[text()='OK']")
    private WebElement ok;

    @FindBy(xpath = ".//div[@class='successLabel']")
    private WebElement customerCreatedSuccessfully;

    WebDriver webDriver = null;
    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public PopUps(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * We found a verified address for your entry
     * Click on submit button
     * We found a single match for your address.
     * Please confirm if you wish to proceed with the address you entered or
     * cancel and change your address.
     */
    public PopUps clickSubmit() {
        addExplicitWait(verifiedAddress, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        clickUsingJavascriptExecutor(submit, "Submit Button");
        return new PopUps(webDriver);
    }

    /**
     * Click on ok button
     */
    public PopUps clickOk() {
        addExplicitWait(customerCreatedSuccessfully, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        clickUsingJavascriptExecutor(ok, "Ok Button");
        return new PopUps(webDriver);
    }


}
