/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-03-20
 * Created Time: 3:08 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.business.businessaccountwithoutcreditbureau;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesAssignment extends BasePage {

    @FindBy(name="btnDone")
    private WebElement ok;


    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public SalesAssignment(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Done button
     */
    public BusinessAccountSummary clickOk() {
        click(ok, "Done");
        return new BusinessAccountSummary(webDriver);
    }
}
