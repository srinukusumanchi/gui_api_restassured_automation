/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-11
 * Created Time: 11:32 a.m.
 */

package bns.a6.microui.web.pages.accessbyaccount;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.enums.WaitStrategy;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.ProductsAndServices;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessAccountProfile extends BasePage {

    @FindBy(xpath = "//h3[contains(text(),'Account Profile')]")
    private WebElement accountProfile;

    @FindBy(xpath = "//td[text()='Address Line 1:']/following-sibling::td")
    private WebElement addressLine1;

    @FindBy(xpath = "//td[text()='Address Line 2:']/following-sibling::td")
    private WebElement addressLine2;

    @FindBy(xpath = "//td[text()='City/Address Line 3:']/following-sibling::td")
    private WebElement addressLine3;

    @FindBy(xpath = "//td[text()='Province/State:']/following-sibling::td")
    private WebElement province;

    @FindBy(xpath = "//td[text()='Postal/Zip Code:']/following-sibling::td")
    private WebElement postal;

    @FindBy(xpath = "//td[text()='Country:']/following-sibling::td")
    private WebElement country;

    @FindBy(name = "Exit")
    private WebElement exit;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public BusinessAccountProfile(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Wait till page loaded based on element
     */
    public BusinessAccountProfile waitForPageLoad() {
        addExplicitWait(accountProfile, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        return this;
    }


    /**
     * Get Address Line-1
     */
    public String getAddressLine1() {
        return getText(addressLine1);
    }

    /**
     * Get Address Line-1
     */
    public String getAddressLine2() {
        return getText(addressLine2);
    }

    /**
     * Get City/Address Line 3
     */
    public String getAddressLine3() {
        return getText(addressLine3);
    }


    /**
     * Get Province/State
     */
    public String getProvince() {
        return getText(province);
    }

    /**
     * Get Postal/Zip Code
     */
    public String getPostal() {
        return getText(postal);
    }

    /**
     * Get Country
     */
    public String getCountry() {
        return getText(country);
    }

    /**
     * Click Exit
     */
    public ProductsAndServices clickExit() {
        click(exit, "Exit");
        return new ProductsAndServices(webDriver);
    }
}
