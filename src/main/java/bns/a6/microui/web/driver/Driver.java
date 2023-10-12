/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-07
 * Created Time: 6:44 a.m.
 */

package bns.a6.microui.web.driver;

import bns.a6.microui.web.managers.DriverManager;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Objects;

public final class Driver {

    private Driver() {
/*        constructor is private inorder to avoid creating many object to this class in
        other classes*/
    }

    public static void initDriver() {
//        if(Objects.isNull(DriverManager.getDriver())){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, PageLoadStrategy.NONE);
//            chromeOptions.setBrowserVersion("115");
//        chromeOptions.setBinary("C:\\Users\\s3810121\\Downloads\\chrome-win32\\chrome.exe");
        DriverManager.setDriver(new WebDriverTestBase().getDriver());
//        DriverManager.setDriver(new ChromeDriver());
//        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
