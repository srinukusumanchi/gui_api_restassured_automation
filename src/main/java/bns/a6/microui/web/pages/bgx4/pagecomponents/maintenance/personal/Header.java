/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-18
 * Created Time: 1:56 p.m.
 */

package bns.a6.microui.web.pages.bgx4.pagecomponents.maintenance.personal;


import bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.ScotiaCardOrAccount;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BasePage {

    @FindBy(css = ".custNameId>h4")
    private WebElement customerName;

    @FindBy(css = ".custNameId>h5")
    private WebElement cid;

    @FindBy(css = ".backSearchLabel")
    private WebElement backToCustomerSearch;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public Header(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Get Customer Name
     */
    public String getCustomerName() {
        return getText(this.customerName);
    }

    /**
     * Get CID
     */
    public String getCID() {
        String cid = getText(this.cid);
        return cid.split(":")[1];
    }

    /**
     * Click Back to customer search
     */
    public ScotiaCardOrAccount clickBackToCustomerSearch() {
        click(backToCustomerSearch, "Back to Customer Search");
        return new ScotiaCardOrAccount(webDriver);
    }



}
