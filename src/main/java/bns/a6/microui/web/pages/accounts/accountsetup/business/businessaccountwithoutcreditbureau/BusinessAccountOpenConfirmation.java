/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-10
 * Created Time: 6:48 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.business.businessaccountwithoutcreditbureau;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessAccountOpenConfirmation extends BasePage {

    @FindBy(name="Done")
    private WebElement done;

    @FindBy(xpath="//td[text()='Business Account#']/following-sibling::td[2]")
    private WebElement businessAccountNumber;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public BusinessAccountOpenConfirmation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Get Business account number
     */
    public String getBusinessAccountNumber() {
        return getText(businessAccountNumber);
    }

    /**
     * Click on Done button
     */
    public BusinessAccountSummary clickDone() {
        click(done, "Done");
        return new BusinessAccountSummary(webDriver);
    }
}
