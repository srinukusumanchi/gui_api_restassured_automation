/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-29
 * Created Time: 1:56 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountmaintenance.customerToAccountMaintenance;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountToCustomerDetails extends BasePage {

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AccountToCustomerDetails(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


}
