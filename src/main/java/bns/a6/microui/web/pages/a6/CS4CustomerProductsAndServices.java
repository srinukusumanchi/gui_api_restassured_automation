/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-22
 * Created Time: 3:44 p.m.
 */

package bns.a6.microui.web.pages.a6;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CS4CustomerProductsAndServices extends BasePage {

    @FindBy(xpath = "//td[@class='tbColHeader']/parent::tr/parent::tbody")
    private WebElement productsAndServicesWebTable;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CS4CustomerProductsAndServices(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Get List of Table rows
     */
    private List<WebElement> getProductsAndServicesRows() {
        return productsAndServicesWebTable.findElements(By.xpath("tr"));
    }

    /**
     * Get List of Table Headers columns
     */
    private List<WebElement> getProductsAndServicesHeaderColumns() {
        return productsAndServicesWebTable.findElements(By.xpath("tr[1]/td"));
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
        return getText(status);
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
     * Get Products and Services Table information
     */
    public List<Map<String, String>> getProductsAndServicesInformation() {
        List<Map<String, String>> productsAndServicesInformation = new LinkedList<>();
        List<String> headerList = null;
        List<String> dataList = null;
        Map<String, String> sample = null;
        List<WebElement> rowsElements = getProductsAndServicesRows();
        List<WebElement> columnsElements = getProductsAndServicesHeaderColumns();

        for (int rows = 0; rows < rowsElements.size(); rows++) {
            if (rows == 0) {
                headerList = new LinkedList<>();
                for (WebElement headerColumnElement : columnsElements) {
                    headerList.add(headerColumnElement.getText());
                }
            } else {
                dataList = new LinkedList<String>();
                sample = new LinkedHashMap<String, String>();
                List<WebElement> dataColumns = getProductsAndServicesDataColumns
                        (rowsElements.get(rows));
                for (int columns = 0; columns < dataColumns.size(); columns++) {
                    switch (headerList.get(columns)) {
                        case "Products & Services":
                            dataList.add(getProductAndServices(dataColumns.get(columns)));
                            break;
                        case "Account Number":
                            dataList.add(getAccountNumber(dataColumns.get(columns)));
                            break;
                        case "Ins":
                            dataList.add(getINS(dataColumns.get(columns)));
                            break;
                        case "Balance":
                            dataList.add(getBalance(dataColumns.get(columns)));
                            break;
                        case "Status":
                            dataList.add(getStatus(dataColumns.get(columns)));
                            break;
                        case "Date\n" + "Opened":
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
        }
        return productsAndServicesInformation;
    }


}
