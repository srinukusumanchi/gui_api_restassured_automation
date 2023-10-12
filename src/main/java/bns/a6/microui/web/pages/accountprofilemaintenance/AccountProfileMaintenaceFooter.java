/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-10
 * Created Time: 11:53 a.m.
 */

package bns.a6.microui.web.pages.accountprofilemaintenance;

import bns.a6.microui.web.pages.accounttocustomersummary.AccountDetails;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for Account Profile Maintenance footer
 */
public final class AccountProfileMaintenaceFooter extends BasePage {

    @FindBy(xpath = "//span[text()='Cancel']/ancestor::button")
    private WebElement cancel;

    @FindBy(xpath = "//span[text()='Update']/ancestor::button")
    private WebElement update;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountProfileMaintenaceFooter(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on Cancel
     */
    public AccountDetails
    clickCancel() {
        click(cancel, "Cancel");
        return new AccountDetails(webDriver);
    }

    /**
     * Click on Update
     */
    public AccountProfileMaintenaceFooter
    clickUpdate() {
        click(update, "Update");
        return new AccountProfileMaintenaceFooter(webDriver);
    }
}
