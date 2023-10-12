/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 6:27 p.m.
 */

package bns.a6.microui.web.pages.intralink;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.enums.WaitStrategy;
import bns.a6.microui.web.pages.a6.CS2CustomerLocateOrSetup;
import bns.a6.microui.web.pages.accessbyaccount.AccountProfile;
import bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.ScotiaCardOrAccount;
import bns.a6.microui.web.pages.ciscentre.CISCentre;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for navigating customer systems application
 */
public final class IntraLinkHomePage extends BasePage {

    @FindBy(id = "react-tabs-2")
    private WebElement links;

    @FindBy(xpath = "//span[text()='Customer Sales & Service (New)' or text()='Vente et service clientèle (Nouveau)']")
    private WebElement customerSalesAndServicesNew;

    @FindBy(xpath = "//span[text()='Customer Sales & Service' or text()='Vente et service clientèle']")
    private WebElement customerSalesAndServicesLegacy;

    @FindBy(xpath = "//span[text()='Access by Account']")
    private WebElement accessByAccount;

    @FindBy(xpath = "//span[text()='CIS Centre']")
    private WebElement cisCentre;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public IntraLinkHomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Wait till page loaded based on element
     */
    public IntraLinkHomePage waitForPageLoad() {
        addExplicitWait(links, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        return this;
    }

    /**
     * Click on Links Tab
     */
    public IntraLinkHomePage clickLinksTab() {
        click(links, "Links Tab");
        return this;
    }


    /**
     * Click on New Customer Sales and Services Link
     */
    public ScotiaCardOrAccount clickCustomerSalesAndServicesNew() {
        click(customerSalesAndServicesNew, "Customer Sales & Service (New)");
        return new ScotiaCardOrAccount(webDriver);
    }

    /**
     * Click on Legacy Customer Sales and Services Link
     */
    public CS2CustomerLocateOrSetup clickCustomerSalesAndServicesLegacy() {
        click(customerSalesAndServicesLegacy, "Customer Sales & Service");
        return new CS2CustomerLocateOrSetup(webDriver);
    }

    /**
     * Click on Access by account Link
     */
    public AccountProfile clickAccessByAccount() {
        click(accessByAccount, "Access by Account");
        return new AccountProfile(webDriver);
    }

    /**
     * Click on CIS Centre link
     */
    public CISCentre clickCisCentre() {
        click(cisCentre, "CIS Centre");
        return new CISCentre(webDriver);
    }

}
