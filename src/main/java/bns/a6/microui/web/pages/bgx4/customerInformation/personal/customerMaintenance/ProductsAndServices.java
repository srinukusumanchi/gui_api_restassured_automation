/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:07 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.preferences.Preferences;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.taxInformation.FATCA;
import bns.a6.microui.web.testbase.BasePage;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ProductsAndServices extends BasePage {

    @FindBy(id = "customerInformation")
    private WebElement customerInformation;

    @FindBy(id = "preferences")
    private WebElement preferences;

    @FindBy(id = "taxInformation")
    private WebElement taxInformation;

    @FindBy(id = "main-table")
    private WebElement productsAndServicesWebTable;

    @FindBy(xpath = "(//button[@aria-current='true']/parent::li/following-sibling::li/button)[1]")
    private WebElement nextPage;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public ProductsAndServices(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        waitForElementImplicit(FrameworkConstants.getImplicitWait());
        PageFactory.initElements(webDriver, this);
        switchToWindow("customer-ui-component");
    }

    /**
     * Click on Customer Information
     */
    public CustomerInformation clickCustomerInformation() {
        click(customerInformation, "Personal Customer Name");
        return new CustomerInformation(webDriver);
    }

    /**
     * Click on Preferences
     */
    public Preferences clickPreferences() {
        click(preferences, "Preferences");
        return new Preferences(webDriver);
    }


    /**
     * Click on Tax Information
     */
    public FATCA clickTaxInformation() {
        click(taxInformation, "Tax Information");
        return new FATCA(webDriver);
    }

    /**
     * Get List of Table rows
     */
    private List<WebElement> getProductsAndServicesRows() {
        return productsAndServicesWebTable.findElements(By.xpath("tbody/tr"));
    }

    /**
     * Get List of Table Headers columns
     */
    private List<WebElement> getProductsAndServicesHeaderColumns() {
        return productsAndServicesWebTable.findElements(By.xpath("thead/tr[1]/th/div/h2/span"));
    }

    /**
     * Get List of Products and Services Data columns data
     *
     * @param rowElement passing data row element
     */
    private List<WebElement> getProductsAndServicesDataColumns(WebElement rowElement) {
        return rowElement.findElements(By.xpath("td"));
    }

    /**
     * Get Products and Services Text
     *
     * @param productsAndServices passing Products and Services element
     */
    private String getProductAndServices(WebElement productsAndServices) {
        return getText(productsAndServices.findElement(By.xpath("a")));
    }

    /**
     * Get Account Number Text
     *
     * @param accountNumber passing Account Number element
     */
    private String getAccountNumber(WebElement accountNumber) {
        return getText(accountNumber);
    }

    /**
     * Get INS Text
     *
     * @param ins passing INS element
     */
    private String getINS(WebElement ins) {
        return getText(ins);
    }

    /**
     * Get Balance Text
     *
     * @param balance passing balance element
     */
    private String getBalance(WebElement balance) {
        return getText(balance);
    }

    /**
     * Get Status Text
     *
     * @param status passing status element
     */
    private String getStatus(WebElement status) {
        return status.findElements(By.xpath("span")).size() != 0 ?
                getText(status.findElement(By.xpath("span"))) : "";
    }

    /**
     * Get ARI Text
     *
     * @param ari passing ARI element
     */
    private String getARI(WebElement ari) {
        return getText(ari);
    }

    /**
     * Get Date Opened Text
     *
     * @param dateOpened passing date opened element
     */
    private String getDateOpened(WebElement dateOpened) {
        return getText(dateOpened);
    }

    /**
     * Get Relationship Text
     *
     * @param relationship passing relationship element
     */
    private String getRelationship(WebElement relationship) {
        return getText(relationship);
    }

    /**
     * Get BLT Text
     *
     * @param blt passing BLT element
     */
    private String getBLT(WebElement blt) {
        return getText(blt);
    }

    /**
     * Get Column Index
     *
     * @param element    passing Table headers
     * @param columnName Table header column name
     */
    private int getColumnIndex(List<WebElement> element, String columnName) {
        int columnIndex = -1;
        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getText().equals(columnName)) {
                columnIndex = i;
                break;
            }
        }
        return columnIndex;
    }

    /**
     * Get Products and Services Table information
     */
    public List<Map<String, String>> getProductsAndServicesData() {
        List<Map<String, String>> productsAndServicesInformation = new LinkedList<>();
        List<String> headerList = null;
        List<String> dataList = null;
        Map<String, String> sample = null;
        List<WebElement> rowsElements = getProductsAndServicesRows();
        List<WebElement> columnsElements = getProductsAndServicesHeaderColumns();

        headerList = new LinkedList<>();
        for (WebElement headerColumnElement : columnsElements) {
            headerList.add(headerColumnElement.getText());
        }

        for (WebElement rowsElement : rowsElements) {
            dataList = new LinkedList<>();
            sample = new LinkedHashMap<>();
            List<WebElement> dataColumns = getProductsAndServicesDataColumns
                    (rowsElement);
            for (int columns = 0; columns < dataColumns.size(); columns++) {
                switch (headerList.get(columns)) {
                    case "Products and Services":
                        dataList.add(getProductAndServices(dataColumns.get(columns)));
                        break;
                    case "Account Number":
                        dataList.add(getAccountNumber(dataColumns.get(columns)));
                        break;
                    case "INS":
                        dataList.add(getINS(dataColumns.get(columns)));
                        break;
                    case "Balance":
                        dataList.add(getBalance(dataColumns.get(columns)));
                        break;
                    case "Status":
                        dataList.add(getStatus(dataColumns.get(columns)));
                        break;
                    case "Date Opened":
                        dataList.add(getDateOpened(dataColumns.get(columns)));
                        break;
                    case "ARI":
                        dataList.add(getARI(dataColumns.get(columns)));
                        break;
                    case "Relationship":
                        dataList.add(getRelationship(dataColumns.get(columns)));
                        break;
                    case "BLT":
                        dataList.add(getBLT(dataColumns.get(columns)));
                        break;
                }
            }
            for (int i = 0; i < dataList.size(); i++) {
                sample.put(headerList.get(i), dataList.get(i));
            }
            productsAndServicesInformation.add(sample);


        }
        return productsAndServicesInformation;
    }

    public List<Map<String, String>> getProductsAndServicesInformation() {
        List<Map<String, String>> productsAndServicesInformation = new LinkedList<>();

        productsAndServicesInformation = getProductsAndServicesData();
        while (isNextPageExists()) {
            clickNextPage();
            List<Map<String, String>> productsAndServicesPageData = getProductsAndServicesData();
            productsAndServicesInformation.addAll(productsAndServicesPageData);
        }

        return productsAndServicesInformation;
    }


    public void clickProductAndServices(String accountNumber) {
        boolean accountNumberFlag = false;
        List<WebElement> rowsElements = getProductsAndServicesRows();
        List<WebElement> columnsHeaders = getProductsAndServicesHeaderColumns();
        for (WebElement rowsElement : rowsElements) {
            List<WebElement> dataColumns = getProductsAndServicesDataColumns
                    (rowsElement);
            int accountNumberIndex = getColumnIndex(columnsHeaders, "Account Number");
            int productsAndServicesIndex = getColumnIndex(columnsHeaders, "Products and Services");
            String accountNumberActual = getAccountNumber(dataColumns.get(accountNumberIndex)).replaceAll("\\s+", "");
            if (accountNumberActual.equals(accountNumber)) {
                click(dataColumns.get(productsAndServicesIndex).
                                findElement(By.xpath("a")),
                        "Products and Services");
                accountNumberFlag = true;
                break;
            }

        }
        if (!accountNumberFlag)
            ReportPortal.stepFailWithScreenshot("Account Number:- " + accountNumber + " is not " +
                    " found in Products and Services table");
    }

    private Boolean isNextPageExists() {
        boolean flag = false;
        try {
            //  Cannot use Base class method because products and services may or may not contains other pages
            String nextPageExistsOrNot = nextPage.getAttribute("disabled");
            if (nextPageExistsOrNot == null) {
                flag = true;
            }
        } catch (Exception noSuchElementException) {

        }

        return flag;
    }

    private void clickNextPage() {
        click(nextPage, "Next Page");
    }

}
