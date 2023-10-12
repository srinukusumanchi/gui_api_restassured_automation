/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:15 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate;

import bns.a6.microui.web.pages.bgx4.parentorguardian.PersonalCustomerName;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Class is created for entering Identification information
 */
public class Identification extends BasePage {

    @FindBy(id = "customerPresent")
    private WebElement customerPresent;

    @FindBy(id = "customerIdStatus")
    private WebElement customerIdStatus;

    @FindBy(xpath = "//input[@value='parent']/parent::label/span")
    private WebElement parent;

    @FindBy(xpath = "//input[@value='guardian']/parent::label/span")
    private WebElement guardian;

    @FindBy(xpath = "//input[@value='minor']/parent::label/span")
    private WebElement minor;

    @FindBy(xpath = "//span[text()='Yes' or text()='Oui']/parent::div")
    private WebElement willMinorBeASigningAuthorityYes;

    @FindBy(xpath = "//span[text()='No' or text()='Non']/parent::div")
    private WebElement willMinorBeASigningAuthorityNo;

    @FindBy(css = ".locateParentIdLink")
    private WebElement locateParentOrGuardian;

    @FindBy(id = "idMethod")
    private WebElement idMethod;

    @FindBy(id = "idDocumentType")
    private WebElement idOrDocumentType;

    @FindBy(id = "idDocumentSource")
    private WebElement idOrDocumentSource;

    @FindBy(id = "idRefAccountNumber-input")
    private WebElement idOrRefOrAccountNumber;

    @FindBy(id = "idDescription-input")
    private WebElement idDescription;

    @FindBy(id = "sourceDescription-input")
    private WebElement sourceDescription;

    @FindBy(id = "idExpiryDate-start-input")
    private WebElement expiryDate;

    @FindBy(id = "idCountry")
    private WebElement country;

    @FindBy(id = "provTerrState")
    private WebElement provTerrState;

    @FindBy(id = "placeOfBirth")
    private WebElement placeOfBirth;

    @FindBy(xpath = "//span[text()='Add' or text()='Ajouter']/parent::span/parent::button")
    private WebElement add;

    @FindBy(xpath = "//span[text()='Next' or text()='Suivant']")
    private WebElement next;

    private static final String idOrDocumentTypeDualMethod = "//optgroup[@class='groupName']/option[text()=\"<IDOrDocumentType>\"]";

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public Identification(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select  Customer present
     */
    public Identification selectCustomerPresent() {
        click(this.customerPresent, "Customer Present");
        return this;
    }

    /**
     * Select  Customer Id status
     *
     * @param customerIdStatus selecting Customer Id status
     */
    public Identification selectCustomerIdStatus(String customerIdStatus) {
        selectDropDownByVisibleText(this.customerIdStatus, customerIdStatus);
        return this;
    }

    /**
     * Get Customer Id status
     */
    public String getCustomerIdStatus() {
        return getSelctedOptionFromDropdown(this.customerIdStatus);
    }

    /**
     * Select  Parent
     */
    public Identification selectParent() {
        click(this.parent, "Parent");
        return this;
    }

    /**
     * Select  Guardian
     */
    public Identification selectGuardian() {
        click(this.guardian, "Guardian");
        return this;
    }

    /**
     * Select  Minor
     */
    public Identification selectMinor() {
        click(this.minor, "Minor");
        return this;
    }

    /**
     * Select  Will Minor be a Signing Authority? - YES
     */
    public Identification selectWillMinorBeASigningAuthorityYes() {
        click(this.willMinorBeASigningAuthorityYes, "Will Minor be a Signing Authority? - YES");
        return this;
    }

    /**
     * Select  Will Minor be a Signing Authority? - No
     */
    public Identification selectWillMinorBeASigningAuthorityNo() {
        click(this.willMinorBeASigningAuthorityNo, "Will Minor be a Signing Authority? - NO");
        return this;
    }


    /**
     * Select  Id Method
     *
     * @param idMethod selecting Id method
     */
    public Identification selectIdMethod(String idMethod) {
        selectDropDownByVisibleText(this.idMethod, idMethod);
        return this;
    }

    /**
     * Select  Id/Document Type for Single Id Method
     *
     * @param idOrDocumentType selecting Id or Document type
     */
    public Identification selectIdOrDocumentType(String idOrDocumentType) {
        selectDropDownByVisibleText(this.idOrDocumentType, idOrDocumentType);
        return this;
    }


    /**
     * Select  Id/Document Type for Dual Id Method
     *
     * @param idOrDocumentType selecting Id or Document type
     */
    public Identification selectIdOrDocumentTypeForDualMethod(String idOrDocumentType) throws IOException {
        click(webDriver.
                findElement(By.xpath(idOrDocumentTypeDualMethod.replace("<IDOrDocumentType>",
                        idOrDocumentType))), idOrDocumentType);
        return this;
    }


    /**
     * Select  Id/Document Source
     *
     * @param idOrDocumentSource selecting Id or Document source
     */
    public Identification selectIdOrDocumentSource(String idOrDocumentSource) {
        selectDropDownByVisibleText(this.idOrDocumentSource, idOrDocumentSource);
        return this;
    }

    /**
     * Enter Id/Ref/Account Number
     *
     * @param idOrRefOrAccountNumber passing Id or Ref or Account Number
     */
    public Identification enterIdOrRefOrAccountNumber(String idOrRefOrAccountNumber) throws InterruptedException {
        type(this.idOrRefOrAccountNumber, idOrRefOrAccountNumber,
                "Id/Ref/Account Number");
        return this;
    }

    /**
     * Enter Id/Ref/Account Number
     *
     * @param idDescription passing Id or Ref or Account Number
     */
    public Identification enterIdDescription(String idDescription) throws InterruptedException {
        type(this.idDescription, idDescription,
                "ID Description");
        return this;
    }

    /**
     * Enter Source Description
     *
     * @param sourceDescription passing Id or Ref or Account Number
     */
    public Identification enterSourceDescription(String sourceDescription) throws InterruptedException {
        type(this.sourceDescription, sourceDescription,
                "Source Description");
        return this;
    }

    /**
     * Enter Expiry date
     *
     * @param expiryDate passing Expiry date
     */
    public Identification enterExpiryDate(String expiryDate) throws InterruptedException {
        type(this.expiryDate, expiryDate,
                "Expiry Date");
        return this;
    }

    /**
     * Select  Country
     *
     * @param country selecting country
     */
    public Identification selectCountry(String country) {
        selectDropDownByVisibleText(this.country, country);
        return this;
    }

    /**
     * Select  Prov/ Terr/ State
     *
     * @param provOrrTerrOrState selecting Province or State
     */
    public Identification selectProvOrTerrOrState(String provOrrTerrOrState) {
        selectDropDownByVisibleText(this.provTerrState, provOrrTerrOrState);
        return this;
    }

    /**
     * Select  Place of birth
     *
     * @param placeOfBirth selecting place of birth
     */
    public Identification selectPlaceOfBirth(String placeOfBirth) {
        selectDropDownByVisibleText(this.placeOfBirth, placeOfBirth);
        return this;
    }

    /**
     * Click on Add
     */
    public PersonalCustomerName clickLocateParentOrGuardian() {
        click(locateParentOrGuardian, "Locate Parent/Guardian");
        return new PersonalCustomerName(webDriver);
    }


    /**
     * Click on Add
     */
    public Identification clickAdd() {
        click(add, "Add");
        return new Identification(webDriver);
    }

    /**
     * Click on next link
     */
    public EmploymentAndIncome clickNext() {
        click(next, "Next Employment and Income");
        return new EmploymentAndIncome(webDriver);
    }
}
