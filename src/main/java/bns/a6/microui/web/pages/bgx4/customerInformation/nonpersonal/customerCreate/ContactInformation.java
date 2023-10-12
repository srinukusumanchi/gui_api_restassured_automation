/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-18
 * Created Time: 4:19 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Class is created for entering contact information for non personal customer
 */
public class ContactInformation extends BasePage {
    @FindBy(id = "contactName-input")
    private WebElement contactName;

    @FindBy(id = "contactTitle-input")
    private WebElement contactTitle;

    @FindBy(id = "contactPhoneNumber-input")
    private WebElement contactPhoneNumber;

    @FindBy(id = "extension-input")
    private WebElement ext;

    @FindBy(id = "email-input")
    private WebElement email;

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
     * Enter Contact Name
     *
     * @param contactName passing Contact Name
     */
    public ContactInformation enterContactName(String contactName) throws InterruptedException {
        type(this.contactName, contactName,
                "Contact Name");
        return this;
    }

    /**
     * Enter Contact Title
     *
     * @param contactTitle passing Address Line 2
     */
    public ContactInformation enterContactTitle(String contactTitle) throws InterruptedException {
        type(this.contactTitle, contactTitle,
                "Contact Title");
        return this;
    }

    /**
     * Enter Contact Phone Number
     *
     * @param contactPhoneNumber passing Contact Phone Number
     */
    public ContactInformation enterContactPhoneNumber(String contactPhoneNumber) throws InterruptedException {
        type(this.contactPhoneNumber, contactPhoneNumber,
                "Contact Phone Number");
        return this;
    }

    /**
     * Enter Extension
     *
     * @param extension passing Extension
     */
    public ContactInformation enterExt(String extension) throws InterruptedException {
        type(this.ext, extension,
                "Ext");
        return this;
    }

    /**
     * Enter Email
     *
     * @param email passing Email
     */
    public ContactInformation enterEmail(String email) throws InterruptedException {
        type(this.email, email,
                "Email");
        return this;
    }

    /**
     * Click on next link
     */
    public BusinessInformation clickNext() throws IOException {
        click(next,"Next navigates to Business Information Page");
        return new BusinessInformation(webDriver);
    }
}
