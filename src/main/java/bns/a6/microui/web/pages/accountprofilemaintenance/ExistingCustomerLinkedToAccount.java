/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-10
 * Created Time: 11:26 a.m.
 */

package bns.a6.microui.web.pages.accountprofilemaintenance;

import bns.a6.microui.web.testbase.BasePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public final class ExistingCustomerLinkedToAccount extends BasePage {

    @FindBy(xpath = "//div[@class='addCustomer onaddCustomerClickedSummary']/button")
    private WebElement addCustomer;

    @FindBy(xpath = "//div[@class='addCustomer existingCustomerEdit']/button")
    private WebElement reset;

    @FindBy(xpath = "//div[@class='relationCard']/div")
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
     * Click on Add Customer
     */
    public ExistingCustomerLinkedToAccount
    clickAddCustomer() {
        click(addCustomer, "Add Customer");
        return this;
    }

    /**
     * Click on Reset
     */
    public bns.a6.microui.web.pages.accounttocustomersummary.ExistingCustomerLinkedToAccount
    clickReset() {
        click(reset, "Reset");
        return new bns.a6.microui.web.pages.accounttocustomersummary.ExistingCustomerLinkedToAccount(webDriver);
    }

    /**
     * Modify/Update Relationship
     */
    public ExistingCustomerLinkedToAccount
    modifyRelationShip(String cid, String relationShip) {
        boolean flag = false;
        for (WebElement accountRow : accountRows) {
            if (accountRow.
                    findElement(By.xpath("div[@class='Columnstyle__Wrapper-canvas-core__z9aox0-0 kKUJmI Column__container']/child::div/input[@name='cid']")).
                    getAttribute("value").
                    equals(cid)) {
                selectDropDownByVisibleText( accountRow.findElement(By.xpath("div[@class='Columnstyle__Wrapper-canvas-core__z9aox0-0 kKUJmI Column__container']/child::div/div/child::select")),
                        relationShip);
                flag = true;
                break;
            }

        }
//        verify relationship is existing relationship is changed to new relationship
        if (!flag) {
            Assertions.fail("Relation ship is not changed to " + relationShip);
        }
        return new ExistingCustomerLinkedToAccount(webDriver);
    }

}
