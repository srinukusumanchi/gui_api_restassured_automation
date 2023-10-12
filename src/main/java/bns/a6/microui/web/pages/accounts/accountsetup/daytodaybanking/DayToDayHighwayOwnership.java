/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-30
 * Created Time: 2:27 p.m.
 */

package bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking;

import bns.a6.microui.web.pages.bgx4.customersalesandservices.CustomerSelection;
import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class DayToDayHighwayOwnership extends BasePage {

    @FindBy(xpath = "//input[@name='AccountUsedForOther' and @value='N']")
    private WebElement thirdPartyNo;

    @FindBy(xpath = "//input[@name='AccountUsedForOther' and @value='Y']")
    private WebElement thirdPartyYes;

    @FindBy(id = "AccountType")
    private WebElement accountType;

    @FindBy(xpath = "//input[@name='IsRecommendedSoltuion' and @value='N']")
    private WebElement isThisTheRecommendedSolutionNo;

    @FindBy(xpath = "//input[@name='IsRecommendedSoltuion' and @value='Y']")
    private WebElement isThisTheRecommendedSolutionYes;

    @FindBy(name = "Estate")
    private WebElement estate;

    @FindBy(name = "TrustAccount")
    private WebElement trustAccount;

    @FindBy(id = "Customer_Relationship_0")
    private WebElement relationship;

    @FindBy(name = "RefreshKYC")
    private WebElement refresh;

    @FindBy(id = "MultipleSignatures")
    private WebElement ownershipSignatures;

    @FindBy(name = "Continue")
    private WebElement continueButton;

    @FindBy(name = "Reset")
    private WebElement reset;

    @FindBy(name = "Cancel")
    private WebElement cancel;


    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public DayToDayHighwayOwnership(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Click Radio button for third party 'No'
     */
    public DayToDayHighwayOwnership clickThirdPartyNo() {
        click(thirdPartyNo, "Third Party-No");
        return new DayToDayHighwayOwnership(webDriver);
    }

    /**
     * Click Radio button for third party 'No'
     */
    public DayToDayHighwayOwnership clickThirdPartyYes() {
        click(thirdPartyYes, "Third Party-Yes");
        return new DayToDayHighwayOwnership(webDriver);
    }

    /**
     * Select  Account Type
     *
     * @param accountType passing Type of account
     */
    public DayToDayHighwayOwnership selectAccountType(String accountType) {
        selectDropDownByVisibleText(this.accountType, accountType);
        return this;
    }

    /**
     * Closes Is this Chequing Account right for you window
     *
     * @param accountType passing Type of account
     */

    public void closeIsThisChequingAccountRightForYou(String accountType) {
        if (!(accountType.equals("AgriInvest")||
                accountType.equals("Agri-investissement"))) {
            // Store the current window handle
            String winHandleBefore = webDriver.getWindowHandle();
            // Switch to new window opened
            for (String winHandle : webDriver.getWindowHandles()) {
                System.out.println("Window ID:- " + winHandle);
                webDriver.switchTo().window(winHandle);
            }
            webDriver.close();

            // Switch back to original browser (first window)
            webDriver.switchTo().window(winHandleBefore);

        }

    }


    /**
     * Click Is this the recommended solution 'NO'
     */
    public DayToDayHighwayOwnership clickIsThisTheRecommendedSolutionNo() {
        click(isThisTheRecommendedSolutionNo, "Is this the recommended solution - NO");
        return this;
    }

    /**
     * Click Is this the recommended solution 'Yes'
     */
    public DayToDayHighwayOwnership clickIsThisTheRecommendedSolutionYes() {
        click(isThisTheRecommendedSolutionYes, "Is this the recommended solution - Yes");
        return this;
    }

    /**
     * Click Estate
     */
    public DayToDayHighwayOwnership clickEstate() {
        click(estate, "Estate");
        return this;
    }

    /**
     * Click Trust Account
     */
    public DayToDayHighwayOwnership clickTrustAccount() {
        click(trustAccount, "Trust Account");
        return this;
    }

    /**
     * Select Relationship
     *
     * @param relationship passing Relationship
     */
    public DayToDayHighwayOwnership selectRelationship(String relationship) {
        selectDropDownByVisibleText(this.relationship, relationship);
        return this;
    }

    /**
     * Click KYC Refresh
     */
    public DayToDayHighwayOwnership clickKYCRefresh() {
        click(refresh, "KYC Refresh");
        return new DayToDayHighwayOwnership(webDriver);
    }


    /**
     * Select Ownership Signatures
     *
     * @param ownershipSignatures passing Ownership Signatures
     */
    public DayToDayHighwayOwnership selectOwnershipSignatures(String ownershipSignatures) {
        selectDropDownByVisibleText(this.ownershipSignatures, ownershipSignatures);
        return this;
    }

    /**
     * Click Continue Button
     */
    public DayToDayHighwayOptions clickContinue() {
        click(continueButton, "Continue Button");
        return new DayToDayHighwayOptions(webDriver);
    }

    /**
     * Click on Reset button
     */
    public DayToDayHighwayOwnership clickReset() {
        click(reset, "Reset");
        return this;
    }

    /**
     * Click on Cancel button
     */
    public CustomerSelection clickCancel() {
        click(cancel, "Cancel");
        return new CustomerSelection(webDriver);
    }

    /**
     * Closes empty title window
     * or
     * closes other child windows except parent window
     */
    public DayToDayHighwayOwnership closeEmptyWindow(String windows) {
        String[] windowsArray = windows.split("\\|");
        int counter = 0;
        for (String window : windowsArray) {
            for (String windowHandle : webDriver.getWindowHandles()) {
                try {
                    if (counter == 0) {
                        String title = webDriver.switchTo().window(windowHandle).getTitle();
                        if (title.contains(window)) {
                            counter = counter + 1;
                        }
                    } else {
                        webDriver.switchTo().window(windowHandle).close();
                    }
                } catch (NoSuchWindowException e) {
                    throw new NoSuchWindowException("Unable to switch the window");
                }
            }
        }


        return this;
    }


    /**
     * Switches to Day To Day Highway Ownership web page
     */
    public DayToDayHighwayOwnership switchToDayToDayHighwayOptionsPage() {
        this.switchToWindow("Day-to-Day Highway - Ownership|La voie des Opérations Bancaires Courantes - Propriété");
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
