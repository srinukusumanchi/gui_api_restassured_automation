/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-10
 * Created Time: 8:23 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation;

import bns.a6.microui.web.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public final class Identification extends bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.Identification {


    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement updatePage;

    @FindBy(xpath = "customerVerified")
    private WebElement customerVerified;

    @FindBy(id = "idTable")
    private WebElement customerIds;

    @FindBy(css = "button:has(.ButtonCore__text):nth-child(1)")
    private WebElement updateExistingId;

    @FindBy(xpath = "//input[@id='idRefAccountNumberForUpdate-input' and @aria-required='true']")
    private WebElement idOrRefAccountNumberExistingId;

    @FindBy(xpath = "//input[@id='idExpiryDateForUpdate-start-input']")
    private WebElement expiryDateExistingId;

    @FindBy(xpath = "//select[@id='placeOfBirthForUpdate']")
    private WebElement placeOfBirthExistingId;

    @FindBy(xpath = "//span[text()='Confirm' or text()='Confirmer']/parent::span/parent::button")
    private WebElement confirm;

    @FindBy(xpath = "//span[text()='Update' or text()='Mettre à jour']/parent::span/parent::button")
    private WebElement updateId;

    @FindBy(xpath = "//span[text()=\"Delete ID\" or text()=\"Supprimer p. d'identité\"]/parent::span/parent::button")
    private WebElement deleteId;

    @FindBy(xpath = "//span[text()=\"OK\" or text()=\"D'accord\"]")
    private WebElement ok;

    private static final String customerIdName = "div/a/span";

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public Identification(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Click on Update on Identification page
     */
    public Identification clickUpdatePage() {
        click(updatePage, "Update");
        return this;
    }

    /**
     * Click on Customer Verified checkbox
     */
    public Identification clickCustomerVerified() {
        click(customerVerified, "Customer Verified");
        return this;
    }

    /**
     * Select  Customer Id status
     *
     * @param customerIdStatus selecting Customer Id status
     */
    public Identification selectCustomerIdStatus(String customerIdStatus) {
        super.selectCustomerIdStatus(customerIdStatus);
        return this;
    }

    /**
     * Select  Id Method
     *
     * @param idMethod selecting Id method
     */
    public Identification selectIdMethod(String idMethod) {
        super.selectIdMethod(idMethod);
        return this;
    }

    /**
     * Select  Id/Document Type for Single Id Method
     *
     * @param idOrDocumentType selecting Id or Document type
     */
    public Identification selectIdOrDocumentType(String idOrDocumentType) {
        super.selectIdOrDocumentType(idOrDocumentType);
        return this;
    }


    /**
     * Select  Id/Document Type for Dual Id Method
     *
     * @param idOrDocumentType selecting Id or Document type
     */
    public Identification selectIdOrDocumentTypeForDualMethod(String idOrDocumentType) throws IOException {
        super.selectIdOrDocumentTypeForDualMethod(idOrDocumentType);
        return this;
    }


    /**
     * Select  Id/Document Source
     *
     * @param idOrDocumentSource selecting Id or Document source
     */
    public Identification selectIdOrDocumentSource(String idOrDocumentSource) {
        super.selectIdOrDocumentSource(idOrDocumentSource);
        return this;
    }

    /**
     * Enter Id/Ref/Account Number
     *
     * @param idOrRefOrAccountNumber passing Id or Ref or Account Number
     */
    public Identification enterIdOrRefOrAccountNumber(String idOrRefOrAccountNumber) throws InterruptedException {
        super.enterIdOrRefOrAccountNumber(idOrRefOrAccountNumber);
        return this;
    }

    /**
     * Enter Id Description
     *
     * @param idDescription passing Id or Ref or Account Number
     */
    public Identification enterIdDescription(String idDescription) throws InterruptedException {
        super.enterIdDescription(idDescription);
        return this;
    }

    /**
     * Enter Source Description
     *
     * @param sourceDescription passing Id or Ref or Account Number
     */
    public Identification enterSourceDescription(String sourceDescription) throws InterruptedException {
        super.enterSourceDescription(sourceDescription);
        return this;
    }

    /**
     * Enter Expiry date
     *
     * @param expiryDate passing Expiry date
     */
    public Identification enterExpiryDate(String expiryDate) throws InterruptedException {
        super.enterExpiryDate(expiryDate);
        return this;
    }

    /**
     * Select  Country
     *
     * @param country selecting country
     */
    public Identification selectCountry(String country) {
        super.selectCountry(country);
        return this;
    }

    /**
     * Select  Prov/ Terr/ State
     *
     * @param provOrrTerrOrState selecting Province or State
     */
    public Identification selectProvOrTerrOrState(String provOrrTerrOrState) {
        super.selectProvOrTerrOrState(provOrrTerrOrState);
        return this;
    }

    /**
     * Select  Place of birth
     *
     * @param placeOfBirth selecting place of birth
     */
    public Identification selectPlaceOfBirth(String placeOfBirth) {
        super.selectPlaceOfBirth(placeOfBirth);
        return this;
    }

    /**
     * Verify Customer Id exists or not
     *
     * @param id passing Passing customer Id
     * @return flag - It returns Customer Id exists or not
     */
    public Boolean isCustomerIdExists(String id) {
        boolean flag = false;
        List<WebElement> customerIds = this.customerIds.findElements(By.xpath(customerIdName));
        for (WebElement customerId : customerIds) {
            if (getText( customerId).equals(id)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Clicks customer Id
     *
     * @param id passing customer Id
     */
    public void clickCustomerId(String id) {
        List<WebElement> customerIds = this.customerIds.findElements(By.xpath(customerIdName));
        for (WebElement customerId : customerIds) {
            if (getText(customerId).equals(id)) {
                click(customerId, id);
                break;
            }
        }
    }

//     Update Customer Id methods

    /**
     * Click on Update button for Id documents
     */
    public Identification clickUpdateExistingId() {
        click(updateExistingId, "Update-ID");
        return this;
    }


    /**
     * Enter Id/Ref/Account Number for updating customer existing Id
     *
     * @param idOrRefOrAccountNumber passing Id or Ref or Account Number
     */
    public Identification enterIdOrRefOrAccountNumberExistingId(String idOrRefOrAccountNumber) {
        type(this.idOrRefAccountNumberExistingId, idOrRefOrAccountNumber,
                "Id/Ref/Account Number - Existing Id");
        return this;
    }


    /**
     * Enter Expiry date for updating customer existing Id
     *
     * @param expiryDate passing Expiry date
     */
    public Identification enterExpiryDateExistingId(String expiryDate) {
        type(this.expiryDateExistingId, expiryDate,
                "Expiry Date");
        return this;
    }


    /**
     * Select  Place of birth for updating customer existing Id
     *
     * @param placeOfBirth selecting place of birth
     */
    public Identification selectPlaceOfBirthExistingId(String placeOfBirth) {
        selectDropDownByVisibleText(this.placeOfBirthExistingId, placeOfBirth);
        return this;
    }

    /**
     * Click Delete ID
     */
    public Identification clickDeleteId() {
        click(deleteId, "Delete ID");
        return this;
    }

    /**
     * Click Update ID
     */
    public Identification clickUpdate() {
        click(updateId, "Update ID");
        return this;
    }

    /**
     * Click Confirm
     */
    public Identification clickConfirm() {
        click(confirm, "Confirm");
        return this;
    }

    /**
     * Click on ok button
     */
    public Identification clickOk() {
        clickUsingJavascriptExecutor(ok, "Ok Button");
        return new Identification(webDriver);
    }
}
