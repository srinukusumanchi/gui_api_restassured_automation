/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-22
 * Created Time: 9:56 p.m.
 */

package bns.a6.microui.web.pages.a6;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class IntralinkHeader  extends BasePage {

    @FindBy(id = "ipb_IntralinkHREF")
    private WebElement intralink;


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
        click(intralink, "Intralink Image - Legacy");
        return this;
    }
}
