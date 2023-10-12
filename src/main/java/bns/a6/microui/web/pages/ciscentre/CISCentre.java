/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-09
 * Created Time: 5:43 p.m.
 */

package bns.a6.microui.web.pages.ciscentre;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for Account Profile Setup and Maintenance
 */
public final class CISCentre extends BasePage {

    @FindBy(xpath = "//label[text()='Account Profile Setup/Maintenance']")
    private WebElement accountProfileSetupOrMaintenance;

    WebDriver webDriver = null;
    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CISCentre(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on Account Profile Setup/Maintenance
     */
    public AccountProfileSetupMaintenance clickAccountProfileSetupMaintenance() {
        clickUsingJavascriptExecutor(accountProfileSetupOrMaintenance, "Account Profile Setup/Maintenance");
        return new AccountProfileSetupMaintenance(webDriver);
    }
}
