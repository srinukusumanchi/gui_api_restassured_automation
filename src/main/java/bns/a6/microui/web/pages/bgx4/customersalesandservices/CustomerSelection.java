/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-22
 * Created Time: 4:12 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customersalesandservices;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.enums.WaitStrategy;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for Non-Personal Account setup
 */
public final class CustomerSelection extends BasePage {

    @FindBy(css = ".inquiryHeader")
    private WebElement customerSalesAndServicesLabel;

    @FindBy(css = ".checkbox")
    private WebElement customerCheckbox;

    private final String customerLink = "/parent::label/parent::td/a";
    private final String customerLinkName = "//a[text()='<CustomerName>']";
    private final String customerCheckBox = "//input[@value='<CID>']/parent::label/span";

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerSelection(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select customer checkbox
     */
    public CustomerSelection checkCustomer(String cid) {
        WebElement checkBox = webDriver.
                findElement(By.xpath(customerCheckBox.replace("<CID>", cid)));
        click(checkBox, "Customer check box");
        return new CustomerSelection(webDriver);
    }

    /**
     * Select customer checkbox
     */
    public CustomerSelection checkCustomer() {
        click(customerCheckbox, "Customer check box");
        return new CustomerSelection(webDriver);
    }

    /**
     * Click on customer
     */
    public CustomerSelection clickCustomer(String customerIdOrName, String cidOrName) {
        if (cidOrName.equalsIgnoreCase("CID")) {
            click(webDriver.findElement(By.xpath(customerCheckBox.replace("<CID>", customerIdOrName) + customerLink)),
                    "Customer Link - " +
                            getText(webDriver.findElement(By.xpath(
                                    customerCheckBox.replace("<CID>", customerIdOrName) + customerLink))));
        } else if (cidOrName.equalsIgnoreCase("Name")) {
            click(webDriver.
                    findElement(By.xpath(customerLinkName.replace("<CustomerName>", customerIdOrName))), "Customer Link - " + customerIdOrName);
        }


        return this;
    }

    /**
     * Wait for Customer sales and services label
     */
    public CustomerSelection getCustomerSalesAndServicePage() {
        addExplicitWait(customerSalesAndServicesLabel, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        return this;
    }

}
