package bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.setup;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AA3aSetupNewScotiaCard extends BasePage{

    @FindBy(xpath = "//div[@class='RUIFW-alert-danger  has-icon alert alert-danger']")
    private WebElement errorMessage;

    @FindBy(name = "SCOTIACARDNUMBER")
    private WebElement scotiaCardNumber;

    @FindBy(name = "next")
    private WebElement nextButton;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AA3aSetupNewScotiaCard(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Get Error message
     */
    public String getErrorMessage() {
        return getText(this.errorMessage);
    }



    /**
     * Enter ScotiaCard Number
     *
     * @param scotiaCardNumber passing scotiaCard Number
     */
    public AA3aSetupNewScotiaCard enterScotiaCardNumber(String scotiaCardNumber) {
        type(this.scotiaCardNumber, scotiaCardNumber, "Scotia CardNumber");
        return this;
    }

    /**
     * Click on Next Button
     */
    public AA3aAccountAccessChanges clickNextButton() {
        click(nextButton, "Next Button");
        return new AA3aAccountAccessChanges(webDriver);
    }


    /**
     * Switches to Day To Day Highway Options web page
     */
    public AA3aSetupNewScotiaCard switchToAA3aSetupNewScotiaCard(){
        switchToWindow("AA3a - Set-up new ScotiaCard|AA3a - Établissement de la nouvelle Carte Scotia");
        return this;
    }
}
