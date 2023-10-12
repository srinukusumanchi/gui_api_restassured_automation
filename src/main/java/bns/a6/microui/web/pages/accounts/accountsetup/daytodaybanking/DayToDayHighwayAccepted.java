/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-30
 * Created Time: 3:46 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class DayToDayHighwayAccepted extends BasePage {

    @FindBy(xpath = "//td[text()='Account Number:' or text()='Numéro du compte:']/following-sibling::td")
    private WebElement accountNumber;

    @FindBy(name = "print")
    private WebElement print;

    @FindBy(name = "PrintTermsAndConditions")
    private WebElement printTermsAndConditions;

    @FindBy(name = "Done")
    private WebElement done;



    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public DayToDayHighwayAccepted(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Get Account Number
     */
    public String getAccountNumber() {
        return getText(this.accountNumber);
    }

    /**
     * Click Print
     */
    public PrintManager clickPrint() {
        click(print, "Print");
        return new PrintManager(webDriver);
    }

    /**
     * Click Print Terms and Conditions
     */
    public DayToDayHighwayAccepted clickPrintTermsAndConditions() {
        click(printTermsAndConditions, "Print Terms and Conditions");
        return this;
    }


    /**
     * Click Done
     */
    public DayToDayHighwayAccepted clickDone() {
        click(done, "Done");
        return this;
    }


    /**
     * Switches to Day To Day Highway Options web page
     */
    public DayToDayHighwayAccepted switchToDayToDayHighwayAccepted() {
        this.switchToWindow("Day-to-Day Highway - Accepted|La voie des Opérations Bancaires Courantes - Accepté");
        return this;
    }



    /**
     * This function is to switch the driver from Current Window to newly opened
     * Window
     */
    public Boolean switchToWindow(String windowNames) {
        boolean flag = false;
        String[] windows = windowNames.split("\\|");
        for (String window : windows) {
            for (String windowHandle : webDriver.getWindowHandles()) {
                try {
                    String title = webDriver.switchTo().window(windowHandle).getTitle();
                    if (title.contains(window)) {
                        webDriver.switchTo().window(windowHandle);
                        flag = true;
                        break;
                    }
                } catch (NoSuchWindowException e) {
                    throw new NoSuchWindowException("Unable to switch the window");
                }
            }
            if (flag) break;
        }
        return flag;
    }

}
