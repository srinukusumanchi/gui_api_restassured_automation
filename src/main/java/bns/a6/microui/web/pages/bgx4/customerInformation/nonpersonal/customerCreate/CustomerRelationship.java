/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-18
 * Created Time: 4:20 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate;


import bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.ScotiaCardOrAccount;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class CustomerRelationship extends BasePage {

    @FindBy(id = "nonPersonalrelationship0")
    private WebElement relationship;

    @FindBy(id = "ownership-input")
    private WebElement ownership;

    @FindBy(id = "action0")
    private WebElement action;

    @FindBy(id = "nonPersonalRelationship")
    private WebElement nonPersonalRelationship;

    @FindBy(xpath = "//span[text()='Locate' or text()='Rechercher']/parent::p/parent::span/parent::span/parent::button")
    private WebElement locate;

    WebDriver webDriver = null;
    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerRelationship(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Locate
     */
    public ScotiaCardOrAccount clickLocate() {
        click(locate, "Locate-> Business Address Page");
        return new ScotiaCardOrAccount(webDriver);
    }

    /**
     * Select  Relationship
     *
     * @param relationship passing relationship value
     */
    public CustomerRelationship selectRelationship(String relationship) {
        selectDropDownByVisibleText(this.relationship, relationship);
        return this;
    }

    /**
     * Enter  Ownership
     *
     * @param ownership passing relationship value
     */
    public CustomerRelationship enterOwnership(String ownership) {
        this.ownership.sendKeys(Keys.BACK_SPACE);
        this.ownership.sendKeys(Keys.BACK_SPACE);
        type(this.ownership, ownership, "Ownership");
        return this;
    }

    /**
     * Select  Action
     *
     * @param action passing Action
     */
    public CustomerRelationship selectAction(String action) {
        selectDropDownByVisibleText(this.action, action);
        return this;
    }

    /**
     * Select  Non-Personal Relationship
     *
     * @param relationship passing Non-Personal Relationship
     */
    public CustomerRelationship selectRelationshipNonPersonal(String relationship) {
        selectDropDownByVisibleText(this.nonPersonalRelationship, relationship);
        return this;
    }
}
