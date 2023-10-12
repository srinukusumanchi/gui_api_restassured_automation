/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-21
 * Created Time: 4:52 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountmaintenance.customerToAccountMaintenance;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalCourierApplication extends BasePage {

    @FindBy(xpath = "(//div[text()='Close'])[1]/ancestor::button")
    private WebElement close;


    WebDriver webDriver = null;
    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public DigitalCourierApplication(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click Radio button for third party 'No'
     */
    public DigitalCourierApplication clickYes() {
        click(close, "Close");
        return this;
    }

}
