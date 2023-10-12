/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:09 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.taxInformation;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public final class FATCA extends BasePage {

    @FindBy(id = "fatca")
    private WebElement fatca;

    //    FATCA Documentation
    @FindBy(xpath = "//input[@id='yes']/parent::label/span")
    private WebElement yes;

    @FindBy(xpath = "//input[@id='no']/parent::label/span")
    private WebElement no;

    @FindBy(xpath = "//input[@id='unknown']/parent::label/span")
    private WebElement unknown;

    @FindBy(id = "crs")
    private WebElement crs;

    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement update;

    @FindBy(id = "accordion-item-btn-0")
    private WebElement usIndicator;

    @FindBy(css = ".fatca-table-body")
    private WebElement usIndicatorTable;

    @FindBy(id = "accordion-item-btn-1")
    private WebElement fatcaDocumentation;

    @FindBy(xpath = "//span[text()='Documentation Status']/parent::div/following-sibling::div")
    private WebElement documentationStatus;

    @FindBy(xpath = "//select[@id='w9']")
    private WebElement w9;

    @FindBy(id = "tinSSN-input")
    private WebElement tinOrSSN;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public FATCA(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click FATCA
     */
    public FATCA clickFATCA() {
        click(fatca, "FATCA");
        return this;
    }

    /**
     * Click 'Yes' radio button for Are you a tax resident or citizen of the United States?
     */
    public FATCA selectYes() {
        click(this.yes, "Yes-Are you a tax resident or citizen of the United States?");
        return this;
    }

    /**
     * Click 'No' radio button for Are you a tax resident or citizen of the United States?
     */
    public FATCA selectNo() {
        click(this.no, "No-Are you a tax resident or citizen of the United States?");
        return this;
    }

    /**
     * Click 'Unknown' radio button for Are you a tax resident or citizen of the United States?
     */
    public FATCA selectUnknown() {
        click(this.unknown, "Unknown-Are you a tax resident or citizen of the United States?");
        return this;
    }

    /**
     * Click on Update
     */
    public FATCA clickUpdate() {
        click(update, "Update");
        return this;
    }

    /**
     * Click US Indicator
     */
    public FATCA clickUSIndicator() {
        click(usIndicator, "US Indicator");
        return this;
    }

    /**
     * Click FATCA Documentation
     */
    public FATCA clickFATCADocumentation() {
        click(fatcaDocumentation, "FATCA Documentation");
        return this;
    }


    /**
     * Click Manually Identified US Indicators
     */
    public FATCA checkManuallyIdentifiedForUSIndicator(String indicators) {
        String[] usIndicatorNames = indicators.split("\\|");
        List<WebElement> usIndicatorTableElements = usIndicatorTable.findElements(By.xpath("tr"));
        for (String usIndicatorName : usIndicatorNames) {
            for (int indicator = 1; indicator < usIndicatorTableElements.size(); indicator++) {
                String indicatorName = getText(this.usIndicatorTable.findElement(By.xpath("tr[" + indicator + "]/td[1]/span")));
                if (indicatorName.equals(usIndicatorName)) {
                    click(this.usIndicatorTable.findElement(By.xpath("tr[" + indicator + "]/td[3]")), usIndicatorName);
                }
            }
        }

        return this;
    }

    /**
     * Select  w9
     *
     * @param w9 selecting w9
     */
    public FATCA selectW9(String w9) {
        selectDropDownByVisibleText(this.w9, w9);
        return this;
    }

    /**
     * Enter TIN/SSN
     *
     * @param tinOrSSN passing TIN Or SSN Number
     */
    public FATCA enterTINorSSN(String tinOrSSN) {
        type(this.tinOrSSN, tinOrSSN,
                "TIN/SSN");
        return this;
    }

    /**
     * Get Documentation Status
     *
     * @return documentationstatus
     */
    public String getDocumentationStatus() {
        return getText(this.documentationStatus);
    }

    /**
     * Click CRS
     */
    public CRS clickCRS() {
        click(crs, "CRS");
        return new CRS(webDriver);
    }

}
