/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-10
 * Created Time: 8:39 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.EmploymentAndIncome;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.*;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CustomerInformation extends BasePage {

    @FindBy(id = "customerName")
    private WebElement customerName;

    @FindBy(id = "personalInformation")
    private WebElement personalInformation;

    @FindBy(id = "addressInformation")
    private WebElement addressInformation;

    @FindBy(id = "residenceInformation")
    private WebElement residenceInformation;

    @FindBy(id = "contactInformation")
    private WebElement contactInformation;

    @FindBy(id = "mothersMaidenName")
    private WebElement mothersMaidenName;

    @FindBy(id = "identification")
    private WebElement identification;

    @FindBy(id = "employmentAndIncome")
    private WebElement employmentAndIncome;

    @FindBy(id = "multiculturalInformation")
    private WebElement multiculturalInformation;


    WebDriver webDriver = null;


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
    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.CustomerName clickCustomerName() throws IOException {
        click(customerName, "Customer Name");
        return new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.CustomerName(webDriver);
    }

    /**
     * Click Personal Information
     */
    public PersonalInformation clickPersonalInformation() {
        click(personalInformation, "Personal Information");
        return new PersonalInformation(webDriver);
    }

    /**
     * Click Address Information
     */
    public AddressInformation clickAddressInformation() {
        click(addressInformation, "Address Information");
        return new AddressInformation(webDriver);
    }

    /**
     * Click Residence Information
     */
    public ResidenceInformation clickResidenceInformation() {
        click(residenceInformation, "Residence Information");
        return new ResidenceInformation(webDriver);
    }

    /**
     * Click Contact Information
     */
    public ContactInformation clickContactInformation() {
        click(contactInformation, "Contact Information");
        return new ContactInformation(webDriver);
    }

    /**
     * Click Mothers Maiden Name
     */
    public MotherMaidenName clickMotherMaidenName() {
        click(mothersMaidenName, "Mothers Maiden Name");
        return new MotherMaidenName(webDriver);
    }

    /**
     * Click on Identification
     */
    public Identification clickIdentification() {
        click(identification, "Identification");
        return new Identification(webDriver);
    }

    /**
     * Click on Employment and Income
     */
    public EmploymentAndIncome clickEmploymentAndIncome() {
        click(employmentAndIncome, "Employment and Income");
        return new EmploymentAndIncome(webDriver);
    }


    /**
     * Click on Multicultural Information
     */
    public MulticulturalInformation clickMulticulturalInformation() {
        click(multiculturalInformation, "Multicultural Information");
        return new MulticulturalInformation(webDriver);
    }



}
