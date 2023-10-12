/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 11:49 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerLocateOrSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class is created for selecting a required customer
 */
public final class CustomerFound {

    @FindBy(id = "main-table")
    private WebElement customerFoundTable;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerFound(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }



}
