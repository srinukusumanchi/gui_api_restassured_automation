/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-07
 * Created Time: 7:01 a.m.
 */

package bns.a6.microui.web.managers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
        /*        constructor is private inorder to avoid creating many object to this class in
        other classes*/
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();



//    private static WebDriver driver;

   /* public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }*/

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void unload() {
        driver.remove();
    }
}
