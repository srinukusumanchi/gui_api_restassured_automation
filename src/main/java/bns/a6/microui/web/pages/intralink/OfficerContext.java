/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 5:32 p.m.
 */

package bns.a6.microui.web.pages.intralink;

import bns.a6.microui.web.testbase.BasePage;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Class is created for selecting environement, language and transit
 */
public final class OfficerContext extends BasePage {

    @FindBy(id = "select-language")
    private WebElement language;

    @FindBy(id = "select-environment")
    private WebElement environment;

    @FindBy(id = "transit-selection-table")
    private WebElement transitTable;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public OfficerContext(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Select  Language
     *
     * @param language passing Language value
     */
    public OfficerContext selectLanguage(String language) {
        selectDropDownByVisibleText(this.language, language);
        return this;
    }

    /**
     * Select  Environment
     *
     * @param environment passing environment value
     */
    public OfficerContext selectEnvironment(String environment) {
        selectDropDownByVisibleText(this.environment, environment);
        return this;
    }


    /**
     * Click  Transit
     *
     * @param transit passing transit value
     */
    public FormIsNotSecure clickTransit(String transit) {
        boolean flag = false;
        List<WebElement> transitRows = transitTable.findElement(By.xpath("tbody")).
                findElements(By.xpath("tr"));

        for (WebElement transitRow : transitRows) {
            if (getText(transitRow.findElement(By.xpath("td[1]"))).equals(transit)) {
                click(transitRow.findElement(By.xpath("td[1]")),
                        "Transit");
                flag = true;
                break;
            }
        }
        if (!flag){
            ReportPortal.stepFailWithScreenshot("Transit - " + transit + " is not present");
            Assertions.fail("Transit - " + transit + " is not present");
        }

        return new FormIsNotSecure(webDriver);
    }
}
