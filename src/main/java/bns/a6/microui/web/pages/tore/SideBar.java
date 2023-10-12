/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-29
 * Created Time: 6:56 p.m.
 */

package bns.a6.microui.web.pages.tore;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar extends BasePage {
    @FindBy(id = "tocNAAN_link")
    private WebElement retrieveAccountNumbers;

    @FindBy(xpath = "//a[text()='Savings Account Numbers']")
    private WebElement savingsAccountNumbers;

    @FindBy(xpath = "//a[text()='DDA Account Numbers']")
    private WebElement ddaAccountNumbers;

    @FindBy(xpath = "//a[text()='ScotiaCard Account Numbers']")
    private WebElement scotiaCardAccountNumbers;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public SideBar(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click Retrieve Account Numbers
     */
    public SideBar clickRetrieveAccountNumbers() {
        switchToFrameByName("toc");
        click(retrieveAccountNumbers, "Retrieve");
        switchToParentFrame();
        return this;
    }

    /**
     * Click Savings Account Numbers
     */
    public SideBar clickSavingsAccountNumbers() {
        switchToFrameByName("toc");
        click(savingsAccountNumbers, "Savings Account Numbers");
        switchToParentFrame();
        return this;
    }

    /**
     * Click DDA Account Numbers
     */
    public SideBar clickDDAAccountNumbers() {
        switchToFrameByName("toc");
        click(ddaAccountNumbers, "DDA Account Numbers");
        switchToParentFrame();
        return this;
    }

    /**
     * Click Scotia card Account Numbers
     */
    public SideBar clickScotiaCardAccountNumbers() {
        switchToFrameByName("toc");
        click(scotiaCardAccountNumbers, "Scotia card Account Numbers");
        switchToParentFrame();
        return this;
    }
}
