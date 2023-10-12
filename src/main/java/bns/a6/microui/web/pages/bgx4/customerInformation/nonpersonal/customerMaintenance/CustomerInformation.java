/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-13
 * Created Time: 8:24 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessAddress;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessInformation;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.CustomerName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public final class CustomerInformation extends bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.CustomerInformation {

    WebDriver webDriver = null;

    @FindBy(xpath = "//span[text()='Business Address']")
    private WebElement businessAddressTab;

    @FindBy(xpath = "//span[text()='Business Information' or text()='Informations entreprise']")
    private WebElement businessInformationTab;

    @FindBy(xpath = "//span[text()='Loan Administration' or text()='Administration']")
    private WebElement loanAdministrationTab;

    @FindBy(xpath = "//span[text()='Customer Relationship' or text()='Relation Client']")
    private WebElement relationshipTab;
    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerInformation(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click on Customer Name
     * @return
     */
    public CustomerName clickCustomerName() throws IOException {
       super.clickCustomerName();
        return new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.CustomerName(webDriver);
    }



    /**
     * Click on Business Information Tab
     */
    public BusinessAddress clickBusinessAddress() {
        click(businessAddressTab, "Non-Personal Business Address Tab");
        return new BusinessAddress(webDriver);
    }

    /**
     * Click on Business Information Tab
     */
    public BusinessInformation clickBusinessInformation() {
        click(businessInformationTab, "Non-Personal Business Information Tab");
        return new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessInformation(webDriver);
    }

    /**
     * Click on Loan Administartion Tab
     */
    public BusinessInformation clickLoanAdministration() {
        click(loanAdministrationTab, "Non-Personal loanAdministration Tab");
        return new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessInformation(webDriver);
    }

    /**
     * Click on Relationship Tab
     */
    public BusinessInformation clickCustomerRelationship() {
        click(relationshipTab, "Non-Personal customer relationship Tab");
        return new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessInformation(webDriver);
    }



}
