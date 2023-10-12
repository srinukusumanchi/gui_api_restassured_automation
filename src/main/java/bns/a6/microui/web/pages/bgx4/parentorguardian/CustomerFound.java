/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 11:49 p.m.
 */

package bns.a6.microui.web.pages.bgx4.parentorguardian;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.enums.WaitStrategy;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Class is created for selecting a required customer
 */
public final class CustomerFound extends BasePage {

    @FindBy(xpath = "//tr[@class='table__row table_row']")
    private WebElement customerFoundTableHeaderRow;

    @FindBy(xpath = "//tr[@class='table__row']")
    private List<WebElement> customerFoundTableDataRow;

    private static final String headerPath = "th/div/h2/span";

    private final PageObjectManager pageObjectManager;

    WebDriver webDriver = null;


    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerFound(WebDriver webDriver) {
        super(webDriver);
        pageObjectManager = PageObjectManager.getInstance();
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    private Integer customerFoundHeader(List<WebElement> customerFoundHeaderColumns, String columnName) {
        int columnIdentified = -1;
        for (int i = 0; i < customerFoundHeaderColumns.size(); i++) {
            if (getText( customerFoundHeaderColumns.get(i)).equals(columnName)) {
                columnIdentified = i;
            }
        }
        return columnIdentified + 1;
    }

    public Boolean customerFound(String customerName, String addressLine1) {
        boolean customerFound = false;
        addExplicitWait(customerFoundTableHeaderRow, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        List<WebElement> customerFoundHeaderValues = customerFoundTableHeaderRow.findElements(By.xpath(headerPath));
        for (WebElement element : customerFoundTableDataRow) {
            if (getText(element.findElement(By.xpath("td[" + getNameCounter(customerFoundHeaderValues) + "]/a"))).
                    equals(customerName.toUpperCase()) &&
                    getText(element.findElement(By.xpath("td[" + getAddressCounter(customerFoundHeaderValues) + "]"))).
                            equals(addressLine1.toUpperCase())) {
                customerFound = true;
                break;
            }

        }
        return customerFound;
    }

    private Integer getNameCounter(List<WebElement> webTableHeaderColumns) {
        int nameCounter = 0;
        String language = pageObjectManager.getIntralinkHeader().getLanguage();
        if (language.equalsIgnoreCase("EN")) {
            nameCounter = customerFoundHeader(webTableHeaderColumns, "Name");
        } else if (language.equalsIgnoreCase("FR")) {
            nameCounter = customerFoundHeader(webTableHeaderColumns, "Nom");
        }

        return nameCounter;
    }

    private Integer getAddressCounter(List<WebElement> webTableHeaderColumns) {
        int addressCounter = 0;
        String language = pageObjectManager.getIntralinkHeader().getLanguage();
        if (language.equalsIgnoreCase("EN")) {
            addressCounter = customerFoundHeader(webTableHeaderColumns, "Address");
        } else if (language.equalsIgnoreCase("FR")) {
            addressCounter = customerFoundHeader(webTableHeaderColumns, "Adresse");
        }
        return addressCounter;
    }

    public void clickOnCustomer(String customerName, String addressLine1) {
        addExplicitWait(customerFoundTableHeaderRow, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
        List<WebElement> customerFoundHeaderValues = customerFoundTableHeaderRow.findElements(By.xpath(headerPath));
        for (WebElement element : customerFoundTableDataRow) {
            if (getText(element.findElement(By.xpath("td[" + getNameCounter(customerFoundHeaderValues) + "]/a"))).
                    equals(customerName.toUpperCase()) &&
                    getText(element.findElement(By.xpath("td[" + getAddressCounter(customerFoundHeaderValues) + "]"))).
                            equals(addressLine1.toUpperCase())) {
                click(element.findElement(By.xpath("td[" + getNameCounter(customerFoundHeaderValues) + "]/a")), customerName);
                break;
            }

        }
    }


}
