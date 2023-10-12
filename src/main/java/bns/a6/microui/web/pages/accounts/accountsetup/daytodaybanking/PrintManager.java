/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-06
 * Created Time: 9:08 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintManager extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'Return')]")
    private WebElement returnButton;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public PrintManager(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click Return
     */
    public DayToDayHighwayAccepted clickReturn() {
        click(returnButton, "Print");
        return new DayToDayHighwayAccepted(webDriver);
    }
}
