/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-19
 * Created Time: 9:02 p.m.
 */

package bns.a6.microui.web.pages.tore;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.testbase.BasePage;
import bns.a6.microui.web.utility.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ScotiaCardAccountNumbers extends BasePage {

    @FindBy(id = "ddlEnv")
    private WebElement environment;

    @FindBy(id = "ddlLang")
    private WebElement language;

    @FindBy(id = "ddlAccountType")
    private WebElement cardType;

    @FindBy(id = "btnGet")
    private WebElement retrieve;

    @FindBy(id = "btnSubmit")
    private WebElement submit;

    @FindBy(id = "btnCancel")
    private WebElement cancel;

    @FindBy(id = "txtNext")
    private WebElement scotiacardAccountNumber;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public ScotiaCardAccountNumbers(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Launch New browser and pass tore url
     */
    public SideBar launchTore() throws Exception {
        String toreURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                FrameworkConstants.getApplicationproperties(), "tore.url");
        launchNewWindow(toreURL);
        switchToWindow("Next Available Account Number System");
        return new SideBar(webDriver);
    }

    /**
     * Select  Environment
     *
     * @param environment passing environment
     */
    public ScotiaCardAccountNumbers selectEnvironment(String environment) {
        switchToFrameByName("main");
        Select dropdown = new Select(this.environment);
        dropdown.selectByVisibleText(environment);
        switchToParentFrame();
        return this;
    }

    /**
     * Select  Language
     *
     * @param language passing Language
     */
    public ScotiaCardAccountNumbers selectLanguage(String language) {
        switchToFrameByName("main");
        Select dropdown = new Select(this.language);
        dropdown.selectByVisibleText(language);
        switchToParentFrame();
        return this;
    }

    /**
     * Select  Card Type
     *
     * @param cardType passing Card Type
     */
    public ScotiaCardAccountNumbers selectCardType(String cardType) {
        switchToFrameByName("main");
        Select dropdown = new Select(this.cardType);
        dropdown.selectByVisibleText(cardType);
        switchToParentFrame();
        return this;
    }

    /**
     * Click Retrieve
     */
    public ScotiaCardAccountNumbers clickRetrieve() {
        switchToFrameByName("main");
        this.retrieve.click();
        switchToParentFrame();
        return this;
    }


    /**
     * Click Submit
     */
    public ScotiaCardAccountNumbers clickSubmit() {
        switchToFrameByName("main");
        this.submit.click();
        acceptAlert();
        switchToParentFrame();
        return this;
    }

    /**
     * Get Savings Account Number
     *
     * @return savings account number
     */
    public String getAccountNumber() {
        switchToFrameByName("main");
        String accountNumber = getAttribute(scotiacardAccountNumber, "value");
        switchToParentFrame();
        return accountNumber;
    }

    /**
     * Click Ok Alert
     * Have you copied the number down?
     * The account number will be deleted from the database now.
     */
    public ScotiaCardAccountNumbers clickOk() {
        acceptAlert();
        return this;
    }
}
