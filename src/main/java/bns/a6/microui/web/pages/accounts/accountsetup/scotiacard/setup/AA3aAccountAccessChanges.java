package bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.setup;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AA3aAccountAccessChanges extends BasePage {

    @FindBy(xpath = "//label[text()='ScotiaCard Number:' or text()='N° de Carte Scotia:']/following-sibling::input")
    private WebElement scotiaCardNumber;

    @FindBy(name = "CONTACTLESSFEATURE")
    private WebElement contactlessFeature;

    @FindBy(name = "MOTHERSMAIDENNAME")
    private WebElement mothersMaidenName;

    @FindBy(name = "done")
    private WebElement submit;

    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     */
    public AA3aAccountAccessChanges(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Get Scotia Card Number Text
     */
    public String getScotiaCardNumber() {
        return getText(scotiaCardNumber);
    }

    /**
     * Select Contactless Feature
     *
     * @param contactlessFeature passing Source of Funds.
     */
    public AA3aAccountAccessChanges selectContactlessFeature(String contactlessFeature) {
        selectDropDownByVisibleText(this.contactlessFeature, contactlessFeature);
        return this;
    }

    /**
     * Enter Mother maiden name
     *
     * @param mothersMaidenName Customer Account Number
     */
    public AA3aAccountAccessChanges enterMothersMaidenName(String mothersMaidenName) {
        type(this.mothersMaidenName, mothersMaidenName, "Mothers Maiden Name");
        return this;
    }

    /**
     * Click on Submit button
     */
    public AA3cAccountAccessChanges clickSubmit() {
        click(submit, "Submit");
        return new AA3cAccountAccessChanges(webDriver);
    }


}
