/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-10
 * Created Time: 11:58 a.m.
 */

package bns.a6.microui.web.pages.accounttocustomersummary;

import bns.a6.microui.web.pages.ciscentre.AccountProfileSetupMaintenance;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for Account to summary footer
 */
public final class AccountToSummaryFooter extends BasePage {

    @FindBy(xpath = "//span[text()='Done']/ancestor::button")
    private WebElement done;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountToSummaryFooter(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on Done
     */
    public AccountProfileSetupMaintenance
    clickDone() {
        click(done, "Done");
        return new AccountProfileSetupMaintenance(webDriver);
    }
}
