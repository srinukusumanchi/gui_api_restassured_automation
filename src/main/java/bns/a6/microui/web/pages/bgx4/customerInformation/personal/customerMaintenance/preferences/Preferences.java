/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-05
 * Created Time: 12:08 a.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.preferences;

import bns.a6.microui.web.testbase.BasePage;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public final class Preferences extends BasePage {

    @FindBy(id = "preferenceInfo")
    private WebElement marketingPreferences;

    @FindBy(id = "accountStatement-table")
    private WebElement accountStatementRKOPreferenceWebTable;

    private static final String yes = "div/fieldset/div[1]/label";
    private static final String no = "div/fieldset/div[2]/label";
    private static final String yesNo = "div//input";
    @FindBy(css = "button:has(.ButtonCore__text)")
    private WebElement update;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public Preferences(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        switchToWindow("customer-ui-component");
    }

    /**
     * Click on Update
     */
    public Preferences clickUpdate() {
        click(update, "Update");
        return this;
    }

    /**
     * Click Marketing Preferences link
     */
    public CustomerPreferences clickMarketingPreferences() {
        click(marketingPreferences, "Marketing Preferences");
        return new CustomerPreferences(webDriver);
    }

    /**
     * Get List of Table rows
     */
    private List<WebElement> getAccountStatementRKOPreferenceRows() {
        return accountStatementRKOPreferenceWebTable.findElements(By.xpath("tbody/tr"));
    }

    /**
     * Get List of Table Headers columns
     */
    private List<WebElement> getProductsAndServicesHeaderColumns() {
        return accountStatementRKOPreferenceWebTable.findElements(By.xpath("thead/tr[1]/th/div/h1/span"));
    }

    /**
     * Click Yes - Paperless Record Keeping option
     */
    private Preferences clickYes(WebElement accountStatementRKOPreference) {
        click(accountStatementRKOPreference.findElement(By.xpath(yes)), "Paperless Record Option - Yes");
        return this;
    }

    /**
     * Click No - Paperless Record Keeping option
     */
    private Preferences clickNo(WebElement accountStatementRKOPreference) {
        click(accountStatementRKOPreference.findElement(By.xpath(no)), "Paperless Record Option - No");
        return this;
    }


    /**
     * Get Account Type
     *
     * @param accountType passing Account Type element
     */
    private String getAccountType(WebElement accountType) {
        return getText( accountType);
    }

    /**
     * Get Account Number
     *
     * @param accountNumber passing Account Number element
     */
    private String getAccountNumber(WebElement accountNumber) {
        return getText( accountNumber);
    }

    /**
     * Get Relationship
     *
     * @param relationship passing Relationship element
     */
    private String getRelationship(WebElement relationship) {
        return getText( relationship);
    }

    /**
     * Click Paperless Record Keeping Option
     *
     * @param paperlessRecordKeepingOption passing Paperless Record Keeping Option element
     */
    private Preferences clickPaperlessRecordKeepingOption(WebElement paperlessRecordKeepingOption,
                                                          String yesOrNo) {
        if (yesOrNo.equalsIgnoreCase("Yes")) {
            clickYes(paperlessRecordKeepingOption);
        } else if (yesOrNo.equalsIgnoreCase("No")) {
            clickNo(paperlessRecordKeepingOption);
        } else {
            ReportPortal.stepFailWithScreenshot("Paperless record keeping option should be either 'Yes' or 'No'" +
                    " instead of " + yesOrNo);
            Assertions.fail("Paperless record keeping option should be either 'Yes' or 'No'" +
                    " instead of " + yesOrNo);
        }
        return this;
    }

    private int getPaperlessRecordKeepingOptionHeaderIndex(List<WebElement> rkoHeaderRowElements,
                                                           String rkoHeaderName) {
        int counter = -1;
        for (int rkoHeader = 0; rkoHeader < rkoHeaderRowElements.size(); rkoHeader++) {
            if (getText( rkoHeaderRowElements.get(rkoHeader))
                    .equals(rkoHeaderName)) {
                counter = rkoHeader;
                break;
            }
        }
        return counter + 1;
    }

    public Preferences updatePaperlessRecordKeepingOption(String accountNumber,
                                                          String yesOrNo) {
        List<WebElement> rkoRowElements = getAccountStatementRKOPreferenceRows();
        List<WebElement> rkoHeaderRowElements = getProductsAndServicesHeaderColumns();
        for (WebElement rkoRowWebElement : rkoRowElements) {
            int accountNumberIndex = getPaperlessRecordKeepingOptionHeaderIndex(rkoHeaderRowElements, "Account Number");
            if (getAccountNumber(rkoRowWebElement.
                    findElement(By.xpath("td[" + accountNumberIndex + "]"))).
                    replaceAll("\\s+", "").equals(accountNumber)) {
                clickPaperlessRecordKeepingOption(rkoRowWebElement, yesOrNo);

            }
        }

        return this;
    }

    private Boolean isChecked(WebElement yesOrNoRadioButton) {
        boolean flag = false;
        String attributeValue = getAttribute( yesOrNoRadioButton, "checked");
        if (attributeValue==null) {
            flag = false;
        }else if(attributeValue.equals("true")){
            flag = true;
        }
        return flag;
    }

    public Preferences updatePaperlessRecordKeepingOptionYesToNoAndNoToYes() {
        List<WebElement> rkoRowElements = getAccountStatementRKOPreferenceRows();
        for (WebElement rkoRowWebElement : rkoRowElements) {
            List<WebElement> yesOrNoRadioButtons = rkoRowWebElement.findElements(By.xpath(yesNo));
            for (WebElement yesOrNoRadioButton : yesOrNoRadioButtons)
                if (!isChecked(yesOrNoRadioButton)) {
                    click(yesOrNoRadioButton.findElement(By.xpath("parent::label")),
                            "RKO Radio button");
                    break;
                }
        }
        return this;
    }


    /**
     * Switches to Day To Day Highway Options web page
     */
    public Preferences switchToPreferencesPage() {
        this.switchToWindow("Customer Preferences");
        return this;
    }


    /**
     * Overrides Base page switchToWindow method
     * by iterating multiple page names based on pipe delimited
     * In this project it is pipe delimited because of english and french names
     *
     * @return
     */
    public Boolean switchToWindow(String window) {
        boolean flag = false;
        String[] webPageNames = window.split("\\|");
        for (String webPageName : webPageNames) {
            flag = super.switchToWindow(webPageName);
            if (flag) {
                break;
            }
        }
        return flag;
    }

}
