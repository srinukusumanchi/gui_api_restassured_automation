/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-04
 * Created Time: 3:27 p.m.
 */

package bns.a6.microui.web.testbase;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.enums.WaitStrategy;
import com.quantum.utils.LogHelper;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage {

    WebDriver webDriver = null;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * This function is to pass a text into an input field within UI
     *
     * @param element     - Element that performs entering action
     * @param value       - Text value which is to be sent to the input field
     * @param locatorName - Name of the locator to declared. i.e., Name of the
     *                    locator_Button,Name of the locator_Link,etc
     */
    protected void type(WebElement element, String value, String locatorName) {
        try {
            //clickable,presence,visibility
            addExplicitWait(element, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
            String s = Keys.chord(Keys.CONTROL, "a");
            element.sendKeys(s);
            element.sendKeys(Keys.DELETE);
//            element.clear();
            element.sendKeys(value);
        } catch (NoSuchElementException e) {
            Assertions.fail("The element " + locatorName + " -> "
                    + element
                    + " is not found");

        }
    }

    /**
     * This function is to check whether a webelement is enabled or not
     *
     * @param element - webelement which is to be checked either it is enabled
     * @return boolean - returns true if the specified webelement is enabled,
     * else it will return false
     */
    public boolean isElementEnabled(WebElement element) {

        LogHelper.logger.info("element is enabled");
        LogHelper.logger.info("The element with is enabled");
        return element.isEnabled();
    }

    /**
     * This function clicks on the element which can be located by the By Object
     *
     * @param element     - Element that performs clicking action
     * @param locatorName - Name of the locator to declared. i.e., Name of the
     *                    locator_Button,Name of the locator_Link,etc
     */
    protected void click(WebElement element, String locatorName) {
        try {
            addExplicitWait(element, WaitStrategy.CLICKABLE, FrameworkConstants.getExplicitWait());//clickable,presence,visibility
            element.click();
            Thread.sleep(3000);
        } catch (NoSuchElementException | InterruptedException e) {
            Assertions.fail("The web element " + locatorName + " with"
                    + element
                    + " not found:-" + e.fillInStackTrace());
        }
    }

    protected void highlight(WebElement element) {
        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
            javascriptExecutor.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red;');", element);
            Thread.sleep(1000);
            javascriptExecutor.executeScript("arguments[0].setAttribute('style','border:2px solid white;');", element);
        } catch (Exception e) {

            Assertions.fail("The element "
                    + element
                    + " is not found");
        }

    }

    /**
     * This function is to get the visible text of an element within UI
     *
     * @param element - element to locate the element from which the text has
     *                to be taken
     * @return String - returns the innertext of the specified element
     */
    protected String getText(WebElement element) {
        String text = null;
        try {
            text = element.getText();
        } catch (NoSuchElementException e) {
            Assertions.fail("Unable to get the text. The element with"
                    + element + " not found:--" + e.fillInStackTrace());
        }
        return text;
    }


    /**
     * This function is to get the attribute value of an element within UI
     *
     * @param element       - element to locate the element from which gets the attribute value
     * @param attributeName - element's attribute key
     * @return String - returns the innertext of the specified element
     */
    protected String getAttribute(WebElement element, String attributeName) {
        String text = null;
        try {
            text = element.getAttribute(attributeName);
        } catch (NoSuchElementException e) {
            Assertions.fail("Unable to get the attribute value. The element with"
                    + element + " not found:--" + e.fillInStackTrace());
        }
        return text;
    }

//    -------------------------------------------Waits---------------------------------------------------

    /**
     * @param time - Maximum time waits for all elements in web page until it find
     *             This function is to make the webDriver wait Implicitly for few seconds.
     */
    public void waitForElementImplicit(long time) {
        webDriver.manage().timeouts().implicitlyWait(time, SECONDS);
    }


    /**
     * This function is to make the webDriver wait explicitly for a condition to be
     * satisfied
     *
     * @param element - waits for an element
     *                visibility/presence/clickability has to be checked
     */
    public void addExplicitWait(WebElement element, WaitStrategy condition, int inttimeoutinseconds) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, inttimeoutinseconds);
        try {
            if (WaitStrategy.VISIBILITY == condition) {
                webDriverWait.until(ExpectedConditions.visibilityOf(element));
                highlight(element);

            } else if (WaitStrategy.CLICKABLE == condition) {
                webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
                highlight(element);

            } else if (WaitStrategy.PRESENCE == condition) {
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By) element));
                highlight(element);

            } else {
                Assertions.fail("Condition String should be visibility or clickable or presence");
            }
        } catch (NoSuchElementException e) {
            Assertions.fail("The element with"
                    + element
                    + " not found:--" + e.fillInStackTrace());
        } catch (UnsupportedCommandException e) {
            Assertions.fail("The condition given to check the element with"
                    + element
                    + " is invalid:-" + e.fillInStackTrace());
        }
    }


//    -------------------------------------------Drop Down Helper---------------------------------------------------

    /**
     * This function is to select a dropdown option using its index
     *
     * @param element - element to locate the dropdown which is to be selected
     * @param index   - index of the dropdown option to be selected
     */
    public void selectDropDownByIndex(WebElement element, int index) {
        try {
            addExplicitWait(element, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
            Select dropDown = new Select(element);
            dropDown.selectByIndex(index);

        } catch (NoSuchElementException e) {
            Assertions.fail("Unable to select the dropdown; The element with"
                    + element
                    + " not found:-" + e.fillInStackTrace());
        }
    }

    /**
     * This function is to select the dropdown options that have a value
     * matching the argument
     *
     * @param element - element to locate the dropdown which is to be selected
     * @param value   - value to match against the dropdown option to be selected
     */
    public void selectDropDownByValue(WebElement element, String value) {
        try {
            addExplicitWait(element, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
            Select dropDown = new Select(element);
            dropDown.selectByValue(value);
        } catch (NoSuchElementException e) {
            Assertions.fail("Unable to select the dropdown; The element with"
                    + element
                    + " not found:--" + e.fillInStackTrace());
        }
    }

    /**
     * This function is to select the dropdown options that have a text
     * matching the argument
     *
     * @param element - element to locate the dropdown which is to be selected
     * @param value   - value to match against the dropdown option to be selected
     */
    public void selectDropDownByVisibleText(WebElement element, String value) {
        try {
            addExplicitWait(element, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(value);
        } catch (NoSuchElementException e) {
            Assertions.fail("Unable to select the dropdown; The element with"
                    + element
                    + " not found:--" + e.fillInStackTrace());
        }
    }

    /**
     * This function is to get selected value from dropdown
     *
     * @param element - element to get selected value from dropdown
     */
    public String getSelctedOptionFromDropdown(WebElement element) {
        String selectedOption = null;
        try {
            addExplicitWait(element, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
            Select select = new Select(element);
            selectedOption = select.getFirstSelectedOption().getText();
        } catch (NoSuchElementException e) {
            Assertions.fail("Unable to get the selected dropdown value; The element with"
                    + element
                    + " not found:--" + e.fillInStackTrace());
        }
        return selectedOption;
    }

//    -------------------------------------------WebPage generic Helper---------------------------------------------------

    /**
     * This function returns the Current Window Title
     *
     * @return String - returns the Current Window Title
     */
    public String getPageTitle() {
        String title = null;
        try {
            waitForLoad(FrameworkConstants.getExplicitWait());
            title = webDriver.getTitle();
        } catch (Exception e) {
            Assertions.fail("Webpage title is not retrived :--"
                    + e.fillInStackTrace());
        }

        return title;
    }

    /**
     * This function is used to handle the page load - Page Sync
     *
     * @param timeOutInSeconds
     */
    public void waitForLoad(int timeOutInSeconds) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(pageLoadCondition);
    }

    /**
     * This function closes the Current Browser Window
     */
    public void closeCurrentWindow() {
        webDriver.close();
    }

    //--------------------------------------------JavaScriptHelper-----------------------------------------------------------

    /**
     * This function is to click on a webelemet using JavascriptExecutor
     *
     * @param element - Name of the elemenet to click. *
     */
    public void clickUsingJavascriptExecutor(WebElement element, String locatorName) {
        try {
            addExplicitWait(element, WaitStrategy.CLICKABLE, FrameworkConstants.getExplicitWait());
            JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;
            javaScriptExecutor.executeScript("arguments[0].click();", element);
        } catch (NoSuchElementException e) {
            Assertions.fail("The web element " + locatorName + " with"
                    + element
                    + " not found:-" + e.fillInStackTrace());
            throw new NoSuchElementException("The element with not found");
        }
    }


    /**
     * This function is to open new window using JavascriptExecutor
     */
    public void launchNewWindow(String url) {
        try {
            ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0])", url);
        } catch (NoSuchElementException e) {
            Assertions.fail("New web page cannot be opened:- "
                    + e.fillInStackTrace());
        }
    }

    /**
     * This function is to switch into a frame using the frame name
     *
     * @param frameName - name of the frame to which driver has to be switched
     *                  into
     */
    public void switchToFrameByName(String frameName) {
        try {
            webDriver.switchTo().frame(frameName);
        } catch (NoSuchFrameException e) {
            Assertions.fail("Unable to switch to frame:- "
                    + e.fillInStackTrace());
        }
    }

    /**
     * This function is to switch into a parent frame
     */
    public void switchToParentFrame() {
        try {
            webDriver.switchTo().parentFrame();
        } catch (NoSuchFrameException e) {
            Assertions.fail("Unable to switch to parent frame:- "
                    + e.fillInStackTrace());
        }
    }

    //-----------------------------------------------------------Alert Helper------------------------------------------------------

    /**
     * This function is to handle the alert; Will Click on OK button First get a
     * handle to the open alert, prompt or confirmation and then accept the
     * alert.
     */
    public void acceptAlert() {
        try {
            waitForAlert();
            Alert alertBox = webDriver.switchTo().alert();
            alertBox.accept();
        } catch (NoAlertPresentException | InterruptedException e) {
            Assertions.fail("Alert is not present");
        }
    }

    public boolean isAlertPresent() throws InterruptedException {
        boolean flag = false;
        int iterations = 0;
        while (iterations++ < FrameworkConstants.getAlertWait()) {
            try {
                webDriver.switchTo().alert();
                flag = true;
                break;
            } catch (Exception e) {
                Thread.sleep(1000);
            }
        }
        return flag;
    }

    /**
     * This function is to wait for an alert for 30 secs it exists it returns true
     */
    public Boolean waitForAlert() throws InterruptedException {
        boolean flag = false;
        int iterations = 0;
        while (iterations++ < FrameworkConstants.getExplicitWait()) {
            try {
                webDriver.switchTo().alert();
                flag = true;
                break;
            } catch (NoAlertPresentException e) {
                Thread.sleep(1000);
            }
        }
        return flag;
    }


    /**
     * This function is to switch the driver from Current Window to newly opened
     * Window
     */
    public Boolean switchToWindow(String windowNames) {
        boolean flag = false;
        String parentWindow = webDriver.getWindowHandle();
        String[] windows = windowNames.split("\\|");
        for (String window : windows) {
            for (String windowHandle : webDriver.getWindowHandles()) {
                try {
                    String title = webDriver.switchTo().window(windowHandle).getTitle();
                    if (title.contains(window)) {
                        webDriver.switchTo().window(windowHandle);
                        flag = true;
                        break;
                    } else {
                        webDriver.switchTo().window(parentWindow);
                    }
                } catch (NoSuchWindowException e) {
                    throw new NoSuchWindowException("Unable to switch the window");
                }
            }
            if (flag) break;
        }
        return flag;
    }


    /**
     * This function is to handle the alert; It will enter credentials
     */
    public void enterCredentialsIntoAlert(String userName, String password) {
        try {
            Alert alertBox = webDriver.switchTo().alert();
            alertBox.sendKeys(userName + Keys.TAB + password);
            acceptAlert();
        } catch (NoAlertPresentException noAlertPresentException) {
            Assertions.fail("Alert is not present:- "
                    + noAlertPresentException.getMessage());
        }
    }


    //    ---------------------------------------------------Action Helper-----------------------------------------------------

    /**
     * This function is to perform double click on a webelement
     *
     * @param element - By object of the webelement on which double click has to
     *                be performed
     */
    public void doubleClick(WebElement element, String locator) {
        try {
            addExplicitWait(element, WaitStrategy.VISIBILITY, FrameworkConstants.getExplicitWait());
            Actions builder = new Actions(webDriver);
            builder.doubleClick(element).perform();
        } catch (NoSuchElementException e) {
            Assertions.fail("The web element " + locator + " with"
                    + element
                    + " not found:-" + e.fillInStackTrace());
        }
    }

}

