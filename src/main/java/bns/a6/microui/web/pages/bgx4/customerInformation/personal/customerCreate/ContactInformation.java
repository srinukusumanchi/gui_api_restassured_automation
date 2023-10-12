/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:15 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate;

import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.MotherMaidenName;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for entering Contact Information
 */
public class ContactInformation extends BasePage {

    @FindBy(id = "homePhoneNumber-input")
    private WebElement homeTelephone;

    @FindBy(id = "businessPhoneNumber-input")
    private WebElement businessTelephone;

    @FindBy(id = "extension-input")
    private WebElement extension;

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
     * Enter Home Telephone
     *
     * @param homeTelephone passing Home Telephone
     */
    public ContactInformation enterHomeTelephone(String homeTelephone) throws InterruptedException {
        type(this.homeTelephone, homeTelephone,
                "Home Telephone");
        return this;
    }

    /**
     * Enter Business Telephone
     *
     * @param businessTelephone passing Business Telephone
     */
    public ContactInformation enterBusinessTelephone(String businessTelephone) throws InterruptedException {
        type(this.businessTelephone, businessTelephone,
                "Home Telephone");
        return this;
    }

    /**
     * Enter Extension
     *
     * @param extension passing Extension
     */
    public ContactInformation enterExtension(String extension) throws InterruptedException {
        type(this.extension, extension,
                "Extension");
        return this;
    }

    /**
     * Enter Email
     *
     * @param email passing Email address
     */
    public ContactInformation enterEmail(String email) throws InterruptedException {
        type(this.email, email,
                "Email");
        return this;
    }

    /**
     * Click on next link
     *
     * @return
     */
    public MotherMaidenName clickNext() {
        click(next, "Next navigates to Identification");
        return new MotherMaidenName(webDriver);
    }
}
