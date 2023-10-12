/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-18
 * Created Time: 12:57 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class Page1_ConcentToReceiptOfElectronicDocuments extends BasePage {

    @FindBy(xpath = "//*[text()='Close' or text()='Fermer']")
    private WebElement close;


    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public Page1_ConcentToReceiptOfElectronicDocuments(WebDriver webDriver)  {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }



    /**
     * Switches to Day To Day Highway Options web page
     * Consent to Receipt of Electronic Documents T & C with Signatory
     */
    public Page1_ConcentToReceiptOfElectronicDocuments switchToPage1() {
        this.switchToWindow("PAGE1 ");
        return this;
    }


    /**
     * Click Continue Button
     */
    public DayToDayHighwayAccepted clickClose() {
        click(close, "Close Button");
        return new DayToDayHighwayAccepted(webDriver);
    }

}
