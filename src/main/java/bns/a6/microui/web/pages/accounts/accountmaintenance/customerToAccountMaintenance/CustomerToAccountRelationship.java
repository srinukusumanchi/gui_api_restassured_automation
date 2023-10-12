/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-20
 * Created Time: 2:43 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountmaintenance.customerToAccountMaintenance;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerToAccountRelationship extends BasePage {

    @FindBy(id = "main-table-relationships")
    private WebElement customerToAccountRelationshipMaintenanceTable;

    @FindBy(xpath = "//tr[@class='table__row table_row_account customer-to-account-table-row']")
    private List<WebElement> customerToAccountRelationshipMaintenanceTableDataRows;

    @FindBy(css = ".lcateBtnDiv>button")
    private WebElement locate;

    @FindBy(xpath = "//input[@id='yes1']/parent::label")
    private WebElement yes;

    @FindBy(xpath = "//input[@id='no1']/parent::label")
    private WebElement no;

    @FindBy(xpath = "(//button[@aria-current='true']/parent::li/following-sibling::li/button)[1]")
    private WebElement nextPage;

    private final static String customerToAccountRelationshipMaintenanceTableHeader = "thead/tr[1]/th/div/h2/span";
    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerToAccountRelationship(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    private Integer customerToAccountMaintenanceHeader(List<WebElement> customerFoundHeaderColumns, String columnName) {
        int columnIdentified = -1;
        for (int i = 0; i < customerFoundHeaderColumns.size(); i++) {
            if (getText( customerFoundHeaderColumns.get(i)).equals(columnName)) {
                columnIdentified = i;
            }
        }
        return columnIdentified + 1;
    }

    private WebElement getCustomerToAccountRelationshipMaintaintenanceWebTableElement(
            String accountNumber, String columnName) {
        int counter = 0;
        WebElement expectedElement = null;
        do {
            if (counter != 0) {
                clickNextPage();
            }

            int columnIndex = customerToAccountMaintenanceHeader(customerToAccountRelationshipMaintenanceTable.findElements
                    (By.xpath(customerToAccountRelationshipMaintenanceTableHeader)), columnName);

            int accountNumberIndex = customerToAccountMaintenanceHeader(customerToAccountRelationshipMaintenanceTable.findElements
                    (By.xpath(customerToAccountRelationshipMaintenanceTableHeader)), "Account Number");
            for (WebElement dataRow : customerToAccountRelationshipMaintenanceTableDataRows) {
                String accountNumberUI = dataRow.findElement(By.xpath("td[" + accountNumberIndex + "]")).getText()
                        .replaceAll("\\s+", "");

                if (accountNumberUI.equals(accountNumber.replaceAll("\\s+", ""))) {
                    expectedElement = dataRow.findElement(By.xpath("td[" + columnIndex + "]"));
                    break;
                }
            }
            counter = counter + 1;
        } while (isNextPageExists());

        return expectedElement;
    }

    /**
     * Select Action
     *
     * @param action passing Action
     */
    public CustomerToAccountRelationship selectAction(String accountNumber,
                                                      String action) {
        WebElement actionElement = getCustomerToAccountRelationshipMaintaintenanceWebTableElement(accountNumber, "Action");
        selectDropDownByVisibleText(actionElement.findElement(By.xpath("div//select")), action);
        return this;
    }

    /**
     * Select Relationship
     *
     * @param relationship passing Relationship
     */
    public CustomerToAccountRelationship selectRelationship(String accountNumber,
                                                            String relationship) {
        WebElement relationshipElement = getCustomerToAccountRelationshipMaintaintenanceWebTableElement(accountNumber, "Relationship");
        selectDropDownByVisibleText(relationshipElement.findElement(By.xpath("div//select")), relationship);
        return this;
    }

    /**
     * Get Status - returns status
     */
    public String getStatus(String accountNumber) {
        WebElement statusElement = getCustomerToAccountRelationshipMaintaintenanceWebTableElement(accountNumber, "Status");
        return getText(statusElement.findElement(By.xpath("span")));
    }

    /**
     * Click Radio button for third party 'Yes'
     */
    public CustomerToAccountRelationship clickYes() {
        click(yes, "Will this account be used by or on behalf of a third party?-Yes");
        return this;
    }

    /**
     * Click Radio button for third party 'No'
     */
    public CustomerToAccountRelationship clickNo() {
        click(no, "Will this account be used by or on behalf of a third party?-No");
        return this;
    }

    /**
     * Click Locate
     */
    public AccountLocate clickLocate() {
        click(locate, "Locate");
        return new AccountLocate(webDriver);
    }


    /**
     * Checks Pagination - Next page exists or not
     */
    private Boolean isNextPageExists() {
        boolean flag = false;
        try{
            String nextPageExistsOrNot =nextPage.getAttribute("disabled");
            if (nextPageExistsOrNot == null) {
                flag = true;
            }
        }catch(NoSuchElementException ignored){
        }


        return flag;
    }

    private void clickNextPage() {
        click(nextPage, "Next Page");
    }

}
