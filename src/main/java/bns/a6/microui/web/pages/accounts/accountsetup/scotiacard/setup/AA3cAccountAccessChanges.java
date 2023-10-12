package bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.setup;


import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AA3cAccountAccessChanges extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Imprimer') or contains(text(),'Done')]")
    private WebElement done;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public AA3cAccountAccessChanges(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click Done Button
     */
    public AA3cAccountAccessChanges clickDone() {
        click(done, "Done Button");
        return new AA3cAccountAccessChanges(webDriver);
    }











}
