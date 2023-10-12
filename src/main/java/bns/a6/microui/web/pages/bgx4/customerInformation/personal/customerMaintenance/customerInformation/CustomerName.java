/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-11
 * Created Time: 2:51 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.pages.bgx4.pagecomponents.create.personal.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class CustomerName extends Header {

    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement update;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    @FindBy(xpath = "//span[text()=\"OK\" or text()=\"D'accord\"]")
    private WebElement ok;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerName(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Update  Title
     *
     * @param title passing Title
     */
    public CustomerName selectTitle(String title) {
        super.selectTitle(title);
        return this;
    }

    /**
     * Update First Name
     *
     * @param firstName passing First Name
     */
    public CustomerName enterFirstName(String firstName) throws InterruptedException {
        super.enterFirstName(firstName);
        return this;
    }

    /**
     * Update Last Name
     *
     * @param lastName passing Last Name
     */
    public CustomerName enterLastName(String lastName) throws InterruptedException {
        super.enterLastName(lastName);
        return this;
    }

    /**
     * Update Birth Date
     *
     * @param birthDate passing Birth Date
     */
    public CustomerName enterBirthDate(String birthDate) throws InterruptedException {
        super.enterBirthDate(birthDate);
        return this;
    }

    /**
     * Update Initials
     *
     * @param initials passing Birth Date
     */
    public CustomerName enterInitials(String initials) throws InterruptedException {
        super.enterInitials(initials);
        return this;
    }

    /**
     * Update  Suffix
     *
     * @param suffix passing Title
     */
    public CustomerName selectSuffix(String suffix) {
        super.selectSuffix(suffix);
        return this;
    }

    /**
     * Click on Update
     */
    public CustomerName clickUpdate() {
        click(update, "Update");
        return this;
    }

    /**
     * Click on next link
     */
    public PersonalInformation clickNext() {
        click(next, "Next navigates to Personal Information");
        return new PersonalInformation(webDriver);
    }

    /**
     * Click on ok button
     */
    public CustomerName clickOk() {
        clickUsingJavascriptExecutor(ok, "Ok Button");
        return new CustomerName(webDriver);
    }

}
