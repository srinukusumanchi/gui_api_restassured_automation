/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-27
 * Created Time: 12:44 a.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.setup;

import bns.a6.microui.web.pages.bgx4.customersalesandservices.CustomerSelection;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintChoices extends BasePage {

    @FindBy(name = "Cancel")
    private WebElement cancel;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public PrintChoices(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click Done Button
     */
    public CustomerSelection clickCancel() {
        click(cancel, "Cancel Button");
        return new CustomerSelection(webDriver);
    }
}
