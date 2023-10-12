/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:11 a.m.
 */

package bns.a6.microui.web.pages.intralink;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * It is a header class which is constant for all screens
 */
public final class IntralinkHeader extends BasePage{

//    @FindBy(css = "button:has(#flying-s-1-title)")
    @FindBy(css = ":is(#ipb_IntralinkHREF, button:has(#flying-s-1-title))")
    private WebElement scotiaBank;

    @FindBy(css = "#language-select>span")
    private WebElement language;

    @FindBy(css = "a[href*='bns/home']+button")
    private WebElement officer;

    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement signOff;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     * @param webDriver Web driver object
     */
    public IntralinkHeader(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Scotia bank/Intralink Image
     */
    public IntralinkHeader clickIntralinkImage() {
        click(scotiaBank, "Scotia bank Image");
        return this;
    }

    /**
     * Get Language
     */
    public String getLanguage() {
        return getText(language);
    }

    /**
     * Click on Officer@Transit Environment
     */
    private IntralinkHeader clickOfficer() {
        click(officer, "Officer Options");
        return this;
    }

    /**
     * Click on Sign-Off
     */
    public IntralinkHeader clickSignOff() {
        clickOfficer();
        click(signOff, "Sign Off");
        return this;
    }
}
