/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-10
 * Created Time: 11:23 a.m.
 */

package bns.a6.microui.web.pages.accounttocustomersummary;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Class is created for to verify account mailing address in Account to Customer summary screen
 * under Account Mailing Address
 */
public final class ExistingCustomerLinkedToAccount extends BasePage {

    @FindBy(xpath = "//div[@class='addCustomer existingCustomerEdit']/button")
    private WebElement edit;

    @FindBy(css = ".existingRelationsTable")
    private List<WebElement> accountRows;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public ExistingCustomerLinkedToAccount(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on Edit
     */
    public bns.a6.microui.web.pages.accountprofilemaintenance.ExistingCustomerLinkedToAccount
    clickEdit() {
        click(edit, "Edit");
        return new bns.a6.microui.web.pages.accountprofilemaintenance.ExistingCustomerLinkedToAccount(webDriver);
    }

    /**
     * Get Relationship
     */
    public String
    getRelationShip(String cid, String relationShip) {
        for (WebElement accountRow : accountRows) {
            if (accountRow.
                    findElement(By.xpath("div[@class='Columnstyle__Wrapper-canvas-core__z9aox0-0 kKUJmI Column__container']/child::div/input[@name='cid']")).
                    getAttribute("value").
                    equals(cid)) {
                selectDropDownByVisibleText(accountRow.findElement(By.xpath("div[@class='Columnstyle__Wrapper-canvas-core__z9aox0-0 kKUJmI Column__container']/child::div/div/child::select")),
                        relationShip);
                break;
            }

        }
        return null;
    }


}
