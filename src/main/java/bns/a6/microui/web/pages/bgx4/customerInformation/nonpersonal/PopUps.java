/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-22
 * Created Time: 3:44 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.enums.WaitStrategy;
import bns.a6.microui.web.pages.bgx4.customersalesandservices.CustomerSelection;
import bns.a6.microui.web.pages.bgx4.pagecomponents.Footer;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for Non-Personal Pop-Ups
 */
public final class PopUps extends BasePage {

    @FindBy(id = "modal-dialog-label")
    private WebElement verifiedAddress;

    @FindBy(xpath = "//span[text()='Submit' or text()='Terminée']")
    private WebElement submit;

    @FindBy(xpath = "//span[text()='Cancel' or text()='Annuler']")
    private WebElement cancel;

    @FindBy(xpath = ".//div[@class='successLabel']")
    private WebElement customerCreatedSuccessfully;

    @FindBy(xpath = "//span[text()=\"OK\" or text()=\"D'accord\"]")
    private WebElement ok;

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
     * Click on submit button
     */
    public PopUps clickSubmit() {
        addExplicitWait(verifiedAddress, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        clickUsingJavascriptExecutor(submit, "Submit Button");
        return new PopUps(webDriver);
    }

    /**
     * Click on cancel button
     */
    public Footer clickCancel() {
        click(cancel, "Cancel Button");
        return new Footer(webDriver);
    }

    /**
     * Click on ok button
     */
    public CustomerSelection clickOk() {
        addExplicitWait(customerCreatedSuccessfully, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        clickUsingJavascriptExecutor(ok, "OK Button");
        return new CustomerSelection(webDriver);
    }


}
