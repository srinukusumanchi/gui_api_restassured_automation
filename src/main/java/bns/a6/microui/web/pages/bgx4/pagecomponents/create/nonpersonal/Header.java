/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-29
 * Created Time: 8:52 a.m.
 */

package bns.a6.microui.web.pages.bgx4.pagecomponents.create.nonpersonal;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BasePage {

    @FindBy(css = ".custNameId>h5")
    private WebElement cid;

    @FindBy(id = "customerNameLine1-input")
    private WebElement customerNameLine1;

    @FindBy(id = "customerNameLine2-input")
    private WebElement customerNameLine2;

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
     * Get CID
     */
    public String getCID() {
        String cid = getText(this.cid);
        return cid.split(":")[1];
    }

    /**
     * Enter Customer Name Line1
     *
     * @param customerNameLine1 Non-Personal Customer Name Line1
     */
    public Header enterCustomerNameLine1(String customerNameLine1) {
        type(this.customerNameLine1, customerNameLine1, "Customer Name Line 1");
        return this;
    }

    /**
     * Enter Customer Name Line2
     *
     * @param customerNameLine2 Non-Personal Customer Name Line1
     */
    public Header enterCustomerNameLine2(String customerNameLine2) {
        type(this.customerNameLine2, customerNameLine2, "Customer Name Line 2");
        return this;
    }

}
