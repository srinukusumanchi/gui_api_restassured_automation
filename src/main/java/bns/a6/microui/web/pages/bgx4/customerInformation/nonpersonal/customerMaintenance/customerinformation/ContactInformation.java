/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-13
 * Created Time: 4:01 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation;

import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.BusinessInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactInformation extends bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.ContactInformation {

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
    public ContactInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Update
     */
    public ContactInformation clickUpdate() {
        click(update, "Update");
        return this;
    }

    /**
     * Enter Extension
     *
     * @param extension passing Extension
     */
    public ContactInformation enterExt(String extension) throws InterruptedException {
        super.enterExt(extension);
        return this;
    }

    /**
     * Enter Contact Title
     *
     * @param contactTitle passing Address Line 2
     */
    public ContactInformation enterContactTitle(String contactTitle) throws InterruptedException {
        super.enterContactTitle(contactTitle);
        return this;
    }

    /**
     * Enter Contact Phone Number
     *
     * @param contactPhoneNumber passing Contact Phone Number
     */
    public ContactInformation enterContactPhoneNumber(String contactPhoneNumber) throws InterruptedException {
        super.enterContactPhoneNumber(contactPhoneNumber);
        return this;
    }

    /**
     * Enter Contact Name
     *
     * @param contactName passing Contact Name
     */
    public ContactInformation enterContactName(String contactName) throws InterruptedException {
        super.enterContactName(contactName);
        return this;
    }

    /**
     * Enter Email
     *
     * @param email passing Email
     */
    public ContactInformation enterEmail(String email) throws InterruptedException {
        super.enterEmail(email);
        return this;
    }

    /**
     * Click on next link
     */
    public BusinessInformation clickNext() throws IOException {
        super.clickNext();
        return new BusinessInformation(webDriver);
    }

}
