/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-18
 * Created Time: 5:30 p.m.
 */

package bns.a6.microui.web.pages.bgx4.pagecomponents;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.PopUps;
import bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.ScotiaCardOrAccount;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for both personal and non-personal footer elements
 */
public final class Footer extends BasePage {

    @FindBy(xpath = "//span[text()='Submit' or text()='Terminée']")
    private WebElement submit;

    @FindBy(xpath = "//span[text()='Cancel' or text()='Annuler']/parent::button")
    private WebElement cancel;

    @FindBy(xpath = "//span[text()='Done' or text()='Terminée']/parent::button")
    private WebElement done;

    @FindBy(xpath = "//span[text()='Update' or text()='Mettre à jour']/parent::button")
    private WebElement update;

    @FindBy(xpath = "//span[text()='Continue' or text()='Continuer']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[text()='Finish' or text()='Terminer']")
    private WebElement finish;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public Footer(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on submit button
     */
    public PopUps clickSubmit() {
        clickUsingJavascriptExecutor(submit, "Submit Button");
        return new PopUps(webDriver);
    }

    /**
     * Click on Done link
     */
    public Footer clickDone() {
        click(done, "Done");
        return this;
    }

    /**
     * Click on cancel link
     */
    public ScotiaCardOrAccount clickCancel() {
        click(cancel, "Cancel");
        return new ScotiaCardOrAccount(webDriver);
    }


    /**
     * Click on update button
     */
    public Footer clickUpdate() {
        click(update, "Update");
        return this;
    }


    /**
     * Click on continue button
     */
    public Footer clickContinue() {
        waitForLoad(FrameworkConstants.getExplicitWait());
        clickUsingJavascriptExecutor(continueButton, "Continue Button");
        return this;
    }

    /**
     * Click on Finish button
     */
    public Footer clickFinish() {
        waitForLoad(FrameworkConstants.getExplicitWait());
        clickUsingJavascriptExecutor(finish, "Finish");
        return this;
    }

}
