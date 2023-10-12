/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-21
 * Created Time: 9:49 a.m.
 */

package bns.a6.microui.web.pages.bgx4.pagecomponents.create.personal;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for entering customer information like title, firstname, lastname...etc
 */
public class Header extends BasePage {

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(id = "firstName-input")
    private WebElement firstName;

    @FindBy(id = "lastName-input")
    private WebElement lastName;

    @FindBy(id = "dateOfBirth-start-input")
    private WebElement birthDate;

    @FindBy(id = "initial-input")
    private WebElement initials;

    @FindBy(id = "suffix")
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
     * Enter First Name
     *
     * @param firstName passing First Name
     */
    public Header enterFirstName(String firstName) throws InterruptedException {
        type(this.firstName, firstName,
                "First Name");
        return this;
    }

    /**
     * Enter Last Name
     *
     * @param lastName passing Last Name
     */
    public Header enterLastName(String lastName) throws InterruptedException {
        type(this.lastName, lastName,
                "Last Name");
        return this;
    }

    /**
     * Enter Birth Date
     *
     * @param birthDate passing Birth Date
     */
    public Header enterBirthDate(String birthDate) throws InterruptedException {
        type(this.birthDate, birthDate,
                "Birth Date");
        return this;
    }

    /**
     * Enter Initials
     *
     * @param initials passing Birth Date
     */
    public Header enterInitials(String initials) throws InterruptedException {
        type(this.initials, initials,
                "Initials");
        return this;
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

}
