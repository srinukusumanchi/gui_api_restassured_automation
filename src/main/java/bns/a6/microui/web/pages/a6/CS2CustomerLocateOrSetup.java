/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-22
 * Created Time: 3:26 p.m.
 */

package bns.a6.microui.web.pages.a6;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CS2CustomerLocateOrSetup extends BasePage {

    @FindBy(id = "LocateBy_LocateByType")
    private WebElement cidDropDown;

    @FindBy(id = "LocateByCID_CID")
    private WebElement cidOrPhoneTextBox;

    @FindBy(id = "findByCID")
    private WebElement findCidOrPhone;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CS2CustomerLocateOrSetup(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        switchToWindow("CS2 - Customer Locate / Setup");
    }

    /**
     * Select CID
     *
     * @param cid Customer CID
     */
    private CS2CustomerLocateOrSetup selectCID(String cid){
        selectDropDownByVisibleText(this.cidDropDown, cid);
        return this;
    }

    /**
     * Enter CID/Phone
     *
     * @param cidOrPhoneType   Type of selection
     * @param cidOrPhoneNumber CID or Phone Number
     */
    public CS2CustomerLocateOrSetup enterCIDOrPhone
    (String cidOrPhoneType, String cidOrPhoneNumber) {
        selectCID(cidOrPhoneType);
        type(this.cidOrPhoneTextBox, cidOrPhoneNumber, "CID/Phone - Text Box");
        return this;
    }

    /**
     * Click on Find button
     */
    public CS4CustomerProductsAndServices clickFind() {
        click(findCidOrPhone, "Find - CID/Phone");
        return new CS4CustomerProductsAndServices(webDriver);
    }

}
