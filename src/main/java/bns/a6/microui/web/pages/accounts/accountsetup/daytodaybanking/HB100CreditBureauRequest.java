/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-30
 * Created Time: 2:27 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.testbase.BasePage;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public final class HB100CreditBureauRequest extends BasePage {

    @FindBy(name = "Customer_0_Relationship")
    private WebElement customerRelationship;

    @FindBy(xpath = "//input[@name='Customer_0_CB' and @value='YES']")
    private WebElement creditBureauYes;

    @FindBy(xpath = "//input[@name='Customer_0_CB' and @value='NO']")
    private WebElement creditBureauNo;

    @FindBy(xpath = "//input[@name='Customer_0_SIN' and @value='YES']")
    private WebElement sinYes;

    @FindBy(xpath = "//input[@name='Customer_0_SIN' and @value='NO']")
    private WebElement sinNo;

    @FindBy(xpath = "//th[text()='Customers' or text()='Clients']/parent::tr/parent::tbody/parent::table")
    private WebElement creditBureauRequestTable;

    @FindBy(xpath = "//th[text()='Customers' or text()='Clients']/parent::tr/parent::tbody/parent::table/tbody/tr")
    private List<WebElement> creditBureauRequestTableDataRows;

    @FindBy(className = "done")
    private WebElement continueButton;

    @FindBy(className = "reset")
    private WebElement reset;

    private static final String yes = "input[@value='YES']";
    private static final String no = "input[@value='NO']";

    WebDriver webDriver = null;

    private final static String creditBureauRequestTableHeader = "tbody/tr[2]/td/b";

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public HB100CreditBureauRequest(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Select Credit Bureau Request Relationship
     *
     * @param relationship passing Relationship
     */
    public HB100CreditBureauRequest selectRelationship(String customerName,
                                                       String relationship) {
        WebElement relationshipElement = getCreditBureauRequestWebTableElement(customerName, "Relationship|Relation");
        selectDropDownByVisibleText(relationshipElement.findElement(By.xpath("select")), relationship);
        return this;
    }

    /**
     * Select Credit Bureau Request Relationship
     */
    public HB100CreditBureauRequest selectRelationship(String relationship) {
        selectDropDownByVisibleText(customerRelationship, relationship);
        return this;
    }

    /**
     * Select Credit Bureau
     *
     * @param creditBureau passing Credit Bureau either Yes or No
     */
    public HB100CreditBureauRequest selectCreditBureau(String customerName,
                                                       String creditBureau) {
        WebElement creditBureauElement = getCreditBureauRequestWebTableElement(customerName, "Credit Bureau|Bureau de crédit");
        if (creditBureau.equalsIgnoreCase("Yes")) {
            clickYes(creditBureauElement);
        } else if (creditBureau.equalsIgnoreCase("No")) {
            clickNo(creditBureauElement);
        } else {
            ReportPortal.stepFailWithScreenshot("Credit Bureau should be either 'Yes' or 'No'" +
                    " instead of " + creditBureau);
            Assertions.fail("Credit Bureau should be either 'Yes' or 'No'" +
                    " instead of " + creditBureau);
        }
        return this;
    }

    /**
     * Select Credit Bureau
     */
    public HB100CreditBureauRequest selectCreditBureau(String creditBureau) {
        if (!getAttribute(creditBureauYes, "type").equals("hidden")) {
            if (creditBureau.equalsIgnoreCase("Yes")) {
                click(creditBureauYes, "Credit Bureau - Yes");
            } else if (creditBureau.equalsIgnoreCase("No")) {
                click(creditBureauNo, "Credit Bureau - No");
            } else {
                ReportPortal.stepFailWithScreenshot("Credit Bureau should be either 'Yes' or 'No'" +
                        " instead of " + creditBureau);
                Assertions.fail("Credit Bureau should be either 'Yes' or 'No'" +
                        " instead of " + creditBureau);
            }
        }


        return this;
    }

    /**
     * Click Yes - Paperless Record Keeping option
     */
    private HB100CreditBureauRequest clickYes(WebElement element) {
        click(element.findElement(By.xpath(yes)), "Paperless Record Option - Yes");
        return this;
    }

    /**
     * Click No - Paperless Record Keeping option
     */
    private HB100CreditBureauRequest clickNo(WebElement element) {
        click(element.findElement(By.xpath(no)), "Paperless Record Option - No");
        return this;
    }

    /**
     * Select SIN
     *
     * @param sin passing Credit Bureau either Yes or No
     */
    public HB100CreditBureauRequest selectSIN(String customerName,
                                              String sin) {
        WebElement sinElement = getCreditBureauRequestWebTableElement(customerName, "SIN|NAS");
        if (sin.equalsIgnoreCase("Yes")) {
            clickYes(sinElement);
        } else if (sin.equalsIgnoreCase("No")) {
            clickNo(sinElement);
        } else {
            ReportPortal.stepFailWithScreenshot("SIN should be either 'Yes' or 'No'" +
                    " instead of " + sin);
            Assertions.fail("SIN should be either 'Yes' or 'No'" +
                    " instead of " + sin);
        }
        return this;
    }

    /**
     * Select SIN
     */
    public HB100CreditBureauRequest selectSIN(String sin) {
        if (!getAttribute(sinYes, "type").equals("hidden")) {
            if (sin.equalsIgnoreCase("Yes")) {
                click(sinYes, "SIN-Yes");
            } else if (sin.equalsIgnoreCase("No")) {
                click(sinNo, "SIN-Yes");
            } else {
                ReportPortal.stepFailWithScreenshot("SIN should be either 'Yes' or 'No'" +
                        " instead of " + sin);
                Assertions.fail("SIN should be either 'Yes' or 'No'" +
                        " instead of " + sin);
            }
        }

        return this;
    }

    private WebElement getCreditBureauRequestWebTableElement(
            String customerName, String columnName) {
        WebElement expectedElement = null;

        int columnIndex = creditBureauHeader(creditBureauRequestTable.findElements
                (By.xpath(creditBureauRequestTableHeader)), columnName);

        int customerNameIndex = creditBureauHeader(creditBureauRequestTable.findElements
                (By.xpath(creditBureauRequestTableHeader)), "Client");
        for (int row = 2; row <= creditBureauRequestTableDataRows.size(); row++) {
            String customerNameUI = creditBureauRequestTableDataRows.get(row).findElement(By.xpath("td[" + customerNameIndex + "]")).getText();
            if (customerNameUI.equals(customerName)) {
                expectedElement = creditBureauRequestTableDataRows.get(row).findElement(By.xpath("td[" + columnIndex + "]"));
                break;
            }
        }

        return expectedElement;
    }

    private Integer creditBureauHeader(List<WebElement> customerFoundHeaderColumns, String columnName) {
        int columnIdentified = -1;
        boolean flag = false;
        for (String column : columnName.split("\\|")) {
            for (int i = 0; i < customerFoundHeaderColumns.size(); i++) {
                if (getText(customerFoundHeaderColumns.get(i)).equals(column)) {
                    columnIdentified = i;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        return columnIdentified + 1;
    }


    /**
     * Click on continue button
     */
    public HB100CreditBureauRequest clickContinue() {
        waitForLoad(FrameworkConstants.getExplicitWait());
        clickUsingJavascriptExecutor(continueButton, "Continue Button");
        return this;
    }

}
