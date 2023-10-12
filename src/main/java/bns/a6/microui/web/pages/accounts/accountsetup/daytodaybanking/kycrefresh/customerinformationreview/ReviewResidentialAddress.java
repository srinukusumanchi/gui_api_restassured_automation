/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-29
 * Created Time: 4:55 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking.kycrefresh.customerinformationreview;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.enums.WaitStrategy;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewResidentialAddress extends BasePage {

    @FindBy(css = ".AddressHome")
    private WebElement reviewResidentialAddressPage;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public ReviewResidentialAddress(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Wait till page loaded based on element
     */
    public ReviewResidentialAddress waitForPageLoad() {
        switchToFrameByName("Address-container");
        addExplicitWait(reviewResidentialAddressPage, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        switchToParentFrame();
        return this;
    }
}
