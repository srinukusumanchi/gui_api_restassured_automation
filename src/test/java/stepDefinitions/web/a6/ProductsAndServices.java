/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-22
 * Created Time: 6:30 p.m.
 */

package stepDefinitions.web.a6;

import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@QAFTestStepProvider
public class ProductsAndServices {

    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private final ResultSet testData = null;
    private WebDriver driver = null;


    public static List<Map<String, String>> getProductDetails() {
        return productDetails;
    }

    public static void setProductDetails(List<Map<String, String>> productDetails) {
        ProductsAndServices.productDetails = productDetails;
    }

    private static List<Map<String, String>> productDetails = null;

    public ProductsAndServices() {
        pageObjectManager = PageObjectManager.getInstance();
        this.scenarioContext = ScenarioContext.getInstance();
        driver = DriverManager.getDriver();
    }


    @And("^get products and services information from A(\\d+)$")
    public void getProductsAndServicesInformationFromA() {
        productDetails = pageObjectManager.getCS4ProductsAndServicesPersonal().getProductsAndServicesInformation();
        setProductDetails(productDetails);
        ReportPortal.stepInfoWithScreenshot("Page--> A6-> CS4- Products and Services");
    }



}
