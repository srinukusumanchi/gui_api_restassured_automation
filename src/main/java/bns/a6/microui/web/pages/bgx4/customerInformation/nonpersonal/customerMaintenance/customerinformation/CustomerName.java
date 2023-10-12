/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-13
 * Created Time: 4:00 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class CustomerName extends BasePage {

    @FindBy(id = "customerNameLine1-input")
    private WebElement customerNameLine1;

    @FindBy(id = "customerNameLine2-input")
    private WebElement customerNameLine2;

    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement update;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerName(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Update Customer Name Line-1
     *
     * @param customerNameLine1 passing Customer Name Line-1
     */
    public CustomerName enterCustomerNameLine1(String customerNameLine1) {
        type(this.customerNameLine1, customerNameLine1,
                "Customer Name Line-1");
        return this;
    }

    /**
     * Update Customer Name Line-2
     *
     * @param customerNameLine2 passing Customer Name Line-2
     */
    public CustomerName enterCustomerNameLine2(String customerNameLine2) {
        type(this.customerNameLine2, customerNameLine2,
                "Customer Name Line-2");
        return this;
    }

    /**
     * Click on next link
     */
    public BusinessAddress clickNext() {
        click(next, "Next navigates to Contact Information Page");
        return new BusinessAddress(webDriver);
    }


    /**
     * Click on Update
     */
    public CustomerName clickUpdate() {
        click(update, "Update");
        return this;
    }
}
