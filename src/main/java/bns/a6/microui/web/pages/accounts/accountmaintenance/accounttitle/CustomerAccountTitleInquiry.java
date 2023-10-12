/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-12
 * Created Time: 4:31 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountmaintenance.accounttitle;

import bns.a6.microui.web.pages.accountprofilemaintenance.AccountProfileMaintenaceFooter;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAccountTitleInquiry extends BasePage {

    @FindBy(xpath = "//span[text()='Update']/parent::p")
    private WebElement update;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerAccountTitleInquiry(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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
