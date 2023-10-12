/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-11
 * Created Time: 2:53 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class ContactInformation extends bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.ContactInformation {

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
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
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
     * Update Home Telephone
     *
     * @param homeTelephone passing Home Telephone
     */
    public ContactInformation enterHomeTelephone(String homeTelephone) throws InterruptedException {
        super.enterHomeTelephone(homeTelephone);
        return this;
    }

    /**
     * Update Business Telephone
     *
     * @param businessTelephone passing Business Telephone
     */
    public ContactInformation enterBusinessTelephone(String businessTelephone) throws InterruptedException {
        super.enterBusinessTelephone(businessTelephone);
        return this;
    }

    /**
     * Update Extension
     *
     * @param extension passing Extension
     */
    public ContactInformation enterExtension(String extension) throws InterruptedException {
        super.enterExtension(extension);
        return this;
    }

    /**
     * Update Email
     *
     * @param email passing Email address
     */
    public ContactInformation enterEmail(String email) throws InterruptedException {
        super.enterEmail(email);
        return this;
    }

    /**
     * Click on next link
     *
     * @return
     */
    public MotherMaidenName clickNext() {
        click(next, "Next navigates to Mothers Maiden Information");
        return new MotherMaidenName(webDriver);
    }
}
