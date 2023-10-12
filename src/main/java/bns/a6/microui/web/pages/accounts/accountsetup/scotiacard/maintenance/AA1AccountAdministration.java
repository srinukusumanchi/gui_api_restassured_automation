/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-12
 * Created Time: 4:18 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.maintenance;

import bns.a6.microui.web.pages.bgx4.customersalesandservices.CustomerSelection;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AA1AccountAdministration extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Sales & Service')]")
    private WebElement salesAndService;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     */
    public AA1AccountAdministration(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click Sales and Services
     */
    public CustomerSelection clickSalesAndServices() {
        click(salesAndService, "Sales & Service");
        return new CustomerSelection(webDriver);
    }
}
