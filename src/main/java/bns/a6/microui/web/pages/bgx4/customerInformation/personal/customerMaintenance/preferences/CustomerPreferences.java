/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-18
 * Created Time: 5:17 p.m.
 */

package bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.preferences;

import bns.a6.microui.web.testbase.BasePage;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public final class CustomerPreferences extends BasePage {


    WebDriver webDriver = null;

    /**
     * Constructor for initializing webDriver object and page class elements
     *
     * @param webDriver Web driver object
     */
    public CustomerPreferences(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        switchToWindow("Customer Preferences");
    }

    /**
     * Get Page Title
     */
    public String getTitle() {
        return getPageTitle();
    }


    public void closeWindow() {
//        Close current Preferences window and switch to main window
        closeCurrentWindow("Customer Preferences");
    }


    public void closeCurrentWindow(String windowNames) {
        switchToWindow("customer-ui-component");
        String parentWindow = webDriver.getWindowHandle();
        String[] windows = windowNames.split("\\|");
        for (String window : windows) {
            for (String windowHandle : webDriver.getWindowHandles()) {
                try {
                    String title = webDriver.switchTo().window(windowHandle).getTitle();
                    if (title.contains(window)) {
                        webDriver.switchTo().window(windowHandle).close();
                        break;
                    }
                } catch (NoSuchWindowException e) {
                    throw new NoSuchWindowException("Unable to switch the window");
                }
            }
        }
        webDriver.switchTo().window(parentWindow);
    }

}
