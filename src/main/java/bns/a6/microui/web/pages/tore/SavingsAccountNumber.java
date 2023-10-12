/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-19
 * Created Time: 9:01 p.m.
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

public final class SavingsAccountNumber extends BasePage {

    @FindBy(id = "ddlEnv")
    private WebElement environment;

    @FindBy(id = "ddlAccountType")
    private WebElement accountType;

    @FindBy(id = "ddlTransit")
    private WebElement transit;

    @FindBy(id = "btnGet")
    private WebElement retrieve;

    @FindBy(id = "txtNext")
    private WebElement savingsAccountNumber;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public SavingsAccountNumber(WebDriver webDriver) {
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
    public SavingsAccountNumber selectEnvironment(String environment) {
        switchToFrameByName("main");
        Select dropdown = new Select(this.environment);
        dropdown.selectByVisibleText(environment);
        switchToParentFrame();
        return this;
    }

    /**
     * Select  Account Type
     *
     * @param accountType passing Account Type
     */
    public SavingsAccountNumber selectAccountType(String accountType) {
        switchToFrameByName("main");
        Select dropdown = new Select(this.accountType);
        dropdown.selectByVisibleText(accountType);
        switchToParentFrame();
        return this;
    }

    /**
     * Select  Transit
     *
     * @param transit passing Transit
     */
    public SavingsAccountNumber selectTransit(String transit) {
        switchToFrameByName("main");
        Select dropdown = new Select(this.transit);
        dropdown.selectByVisibleText(transit);
        switchToParentFrame();
        return this;
    }

    /**
     * Click Retrieve
     */
    public SavingsAccountNumber clickRetrieve() {
        switchToFrameByName("main");
        this.retrieve.click();
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
        String accountNumber = getAttribute(savingsAccountNumber, "value");
        switchToParentFrame();
        return accountNumber;
    }

    /**
     * Click Ok Alert
     * Please copy the number down once retrieved.
     * The account number will be deleted from the database now.
     */
    public SavingsAccountNumber clickOk() {
        acceptAlert();
        return this;
    }

}
