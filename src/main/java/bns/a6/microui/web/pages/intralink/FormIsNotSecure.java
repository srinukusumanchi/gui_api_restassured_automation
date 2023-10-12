/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-15
 * Created Time: 12:36 p.m.
 */

package bns.a6.microui.web.pages.intralink;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created to handle not secured page
 */
public final class FormIsNotSecure extends BasePage {

    @FindBy(id = "proceed-button")
    private WebElement sendAnyway;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public FormIsNotSecure(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitForLoad(30);
    }

    /**
     * Switches to Form is not secure web page
     */
    public FormIsNotSecure switchToFormIsNotSecurePage() {
        this.switchToWindow("Form is not secure");
        return this;
    }

    /**
     * Click on send anyways
     */
    public IntraLinkHomePage clickSendAnyway() {
        if (getPageTitle().equals("Form is not secure")) {
            click(sendAnyway, "Send anyway");
        }
        return new IntraLinkHomePage(webDriver);
    }
}
