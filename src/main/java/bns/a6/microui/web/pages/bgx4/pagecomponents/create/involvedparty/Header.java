/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-21
 * Created Time: 9:49 a.m.
 */

package bns.a6.microui.web.pages.bgx4.pagecomponents.create.involvedparty;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for entering customer information like title, firstname, lastname...etc
 */
public final class Header extends BasePage {

    @FindBy(id = "involvedPartyTitle")
    private WebElement title;

    @FindBy(id = "involvedPartyFirstName-input")
    private WebElement firstName;

    @FindBy(id = "involvedPartyLastName-input")
    private WebElement lastName;

    @FindBy(id = "involvedPartyDateOfBirth-start-input")
    private WebElement birthDate;

    @FindBy(id = "involvedPartyInitial-input")
    private WebElement initials;

    @FindBy(id = "involvedPartySuffix")
    private WebElement suffix;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public Header(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Select  Title
     *
     * @param title passing Title
     */
    public Header selectTitle(String title) {
        selectDropDownByVisibleText(this.title, title);
        return this;
    }

    /**
     * Get  Title
     */
    public String getTitle() {
        return getSelctedOptionFromDropdown(this.title);
    }

    /**
     * Enter First Name
     *
     * @param firstName passing First Name
     */
    public Header enterFirstName(String firstName) {
        type(this.firstName, firstName,
                "First Name");
        return this;
    }

    /**
     * Get  First Name
     */
    public String getFirstName() {
        return getAttribute(this.firstName,"value");
    }

    /**
     * Enter Last Name
     *
     * @param lastName passing Last Name
     */
    public Header enterLastName(String lastName) {
        type(this.lastName, lastName,
                "Last Name");
        return this;
    }

    /**
     * Get  Last Name
     */
    public String getLastName() {
        return getAttribute(this.lastName,"value");
    }

    /**
     * Enter Birth Date
     *
     * @param birthDate passing Birth Date
     */
    public Header enterBirthDate(String birthDate) {
        type(this.birthDate, birthDate,
                "Birth Date");
        return this;
    }

    /**
     * Get  Birth date
     */
    public String getBirthDate() {
        return getAttribute(this.birthDate,"value");
    }

    /**
     * Enter Initials
     *
     * @param initials passing Birth Date
     */
    public Header enterInitials(String initials) {
        type(this.initials, initials,
                "Initials");
        return this;
    }

    /**
     * Get  Initials
     */
    public String getInitials() {
        return getAttribute(this.initials,"value");
    }

    /**
     * Select  Suffix
     *
     * @param suffix passing Title
     */
    public Header selectSuffix(String suffix) {
        selectDropDownByVisibleText(this.suffix, suffix);
        return this;
    }

    /**
     * Get  Suffix
     */
    public String getSuffix() {
        return getAttribute(this.suffix,"value");
    }
}
