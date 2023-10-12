/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 1:14 p.m.
 */

package bns.a6.microui.web.pages.intralink;


import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for Scotia Bank officer login page
 */
public final class BNSEmployeeLogin extends BasePage {

    @FindBy(id = "idToken1")
    private WebElement scotiaID;

    @FindBy(id = "idToken2")
    private WebElement password;

    @FindBy(id = "loginButton_0")
    private WebElement logOn;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public BNSEmployeeLogin(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Enter officer Id
     *
     * @param userName officer Id
     */
    public BNSEmployeeLogin enterScotiaId(String userName) {
        type(scotiaID, userName, "Scotia ID");
        return this;
    }

    /**
     * Enter officer Password
     *
     * @param password officer password
     */
    public BNSEmployeeLogin enterPassword(String password) {
        type(this.password, password, "Password");
        return this;
    }

    /**
     * Click on Log On button
     */
    public OfficerContext clickLogOn() {
        click(logOn, "Log On");
        return new OfficerContext(webDriver);
    }
}
