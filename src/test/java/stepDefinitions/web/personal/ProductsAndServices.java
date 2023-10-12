/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-12-22
 * Created Time: 6:34 p.m.
 */

package stepDefinitions.web.personal;

import bns.a6.microui.web.constants.TestDataQueries;
import bns.a6.microui.web.cucumber.ScenarioContext;
import bns.a6.microui.web.driver.Driver;
import bns.a6.microui.web.managers.DriverManager;
import bns.a6.microui.web.managers.PageObjectManager;
import bns.a6.microui.web.utility.database.TestDataDB;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import stepDefinitions.managers.StepDefinitionManager;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@QAFTestStepProvider
public class ProductsAndServices {

    private final ScenarioContext scenarioContext;
    private ResultSet testData = null;
    private final PageObjectManager pageObjectManager;
    private final StepDefinitionManager stepDefinitionManager;
    private WebDriver driver = null;

    public static List<Map<String, String>> getProductDetails() {
        return productDetails;
    }

    public static void setProductDetails(List<Map<String, String>> productDetails) {
        ProductsAndServices.productDetails = productDetails;
    }

    private static List<Map<String, String>> productDetails = null;


    public ProductsAndServices() {
        this.scenarioContext = ScenarioContext.getInstance();
        pageObjectManager = PageObjectManager.getInstance();
        stepDefinitionManager = StepDefinitionManager.getInstance();
        Driver.initDriver();
        driver = DriverManager.getDriver();
    }

    @And("^get products and services information$")
    public void getProductsAndServicesInformation() {
        productDetails = pageObjectManager.getProductsAndServicesPersonal().getProductsAndServicesInformation();
        setProductDetails(productDetails);
        ReportPortal.stepInfoWithScreenshot("Products and Services--> Products Details");
    }

    private Boolean isAccountNumberExists(List<Map<String, String>> bgx4ProductsAndServices,
                                          String a6AccountNumber) {
        boolean flag = false;
        for (Map<String, String> bgx4Product : bgx4ProductsAndServices) {
            if (bgx4Product.get("Account Number").trim().equals(a6AccountNumber.trim())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private Map<String, String> getAccountDetails(List<Map<String, String>> productsAndServicesBGX4,
                                                  String accountNumber) {
        Map<String, String> productBGX4 = new HashMap<>();
        for (Map<String, String> product : productsAndServicesBGX4) {
            if (product.get("Account Number").trim().equals(accountNumber.trim())) {
                productBGX4 = product;
                break;
            }
        }
        return productBGX4;
    }

    @Then("^validate BGX(\\d+) products and services information with A(\\d+)$")
    public void validateBGXProductsAndServicesInformationWithA() {
        List<Map<String, String>> productsAndServicesA6 = stepDefinitionManager.getCs4ProductsAndServices().getProductDetails();
        List<Map<String, String>> productsAndServicesBGX4 = getProductDetails();

//         Compare Products details in A6 and BGX4
        for (Map<String, String> productsA6 : productsAndServicesA6) {
            if (isAccountNumberExists(productsAndServicesBGX4, productsA6.get("Account Number"))) {
                Map<String, String> productBGX4 = getAccountDetails
                        (productsAndServicesBGX4, productsA6.get("Account Number"));
//                Products and Services
                if (productBGX4.get("Products and Services").trim()
                        .equals(productsA6.get("Products & Services").trim())) {
                    ReportPortal.stepPass("Products and Services is as expected for A6 and BGX6" +
                            " Product and Services:- " + productsA6.get("Products & Services"));
                } else {
                    ReportPortal.stepFailWithOutScreenshot("Products and Services is not as expected for A6 and BGX6" +
                            " A6 Product and Services:- " + productsA6.get("Products & Services") +
                            " BGX4 Product and Services:- " + productBGX4.get("Products and Services"));
                }

//                Account Number
                if (productBGX4.get("Account Number").trim()
                        .equals(productsA6.get("Account Number").trim())) {
                    ReportPortal.stepPass("Account Number is as expected for A6 and BGX6" +
                            " Account Number:- " + productBGX4.get("Account Number"));
                } else {
                    ReportPortal.stepFailWithOutScreenshot("Account Number is not as expected for A6 and BGX6" +
                            " A6 Account Number:- " + productsA6.get("Account Number") +
                            " BGX4 Account Number:- " + productBGX4.get("Account Number"));
                }

                //  INS
                if (productBGX4.get("INS").trim()
                        .equals(productsA6.get("Ins").trim())) {
                    ReportPortal.stepPass("Ins is as expected for A6 and BGX6" +
                            " Ins:- " + productBGX4.get("INS"));
                } else {
                    ReportPortal.stepFailWithOutScreenshot("INS is not as expected for A6 and BGX6" +
                            " A6 INS:- " + productsA6.get("INS") +
                            " BGX4 INS:- " + productBGX4.get("INS"));
                }

                //  Balance
                if (productBGX4.get("Balance").trim()
                        .equals(productsA6.get("Balance").trim())) {
                    ReportPortal.stepPass("Balance is as expected for A6 and BGX6" +
                            " Balance:- " + productBGX4.get("Balance"));
                } else {
                    ReportPortal.stepFailWithOutScreenshot("Balance is not as expected for A6 and BGX6" +
                            " A6 Balance:- " + productsA6.get("Balance") +
                            " BGX4 Balance:- " + productBGX4.get("Balance"));
                }


                //  Status
                if (productBGX4.get("Status").trim()
                        .equals(productsA6.get("Status").trim())) {
                    ReportPortal.stepPass("Status is as expected for A6 and BGX6" +
                            " Status:- " + productBGX4.get("Status"));
                } else {
                    ReportPortal.stepFailWithOutScreenshot("Status is not as expected for A6 and BGX6" +
                            " A6 Status:- " + productsA6.get("Status") +
                            " BGX4 Status:- " + productBGX4.get("Status"));
                }

                //  Date Opened
                if (productBGX4.get("Date Opened").trim()
                        .equals(productsA6.get("Date\n" + "Opened").trim())) {
                    ReportPortal.stepPass("Date Opened is as expected for A6 and BGX6" +
                            " Date Opened:- " + productBGX4.get("Date Opened"));
                } else {
                    ReportPortal.stepFailWithOutScreenshot("Date Opened is not as expected for A6 and BGX6" +
                            " A6 Date Opened:- " + productsA6.get("Date\n" + "Opened").trim() +
                            " BGX4 Date Opened:- " + productBGX4.get("Date Opened"));
                }

//                Relationship
                if (productBGX4.get("Relationship").trim()
                        .equals(productsA6.get("Relationship").trim())) {
                    ReportPortal.stepPass("Relationship is as expected for A6 and BGX6" +
                            " Relationship:- " + productBGX4.get("Relationship"));
                } else {
                    ReportPortal.stepFailWithOutScreenshot("Relationship is not as expected for A6 and BGX6" +
                            " A6 Relationship:- " + productsA6.get("Relationship") +
                            " BGX4 Relationship:- " + productBGX4.get("Relationship"));
                }

//                BLT
                if (productBGX4.get("BLT").trim()
                        .equals(productsA6.get("BLT").trim())) {
                    ReportPortal.stepPass("BLT is as expected for A6 and BGX6" +
                            " BLT:- " + productBGX4.get("BLT"));
                } else {
                    ReportPortal.stepFailWithOutScreenshot("BLT is not as expected for A6 and BGX6" +
                            " A6 BLT:- " + productsA6.get("BLT") +
                            " BGX4 BLT:- " + productBGX4.get("BLT"));
                }
            } else {
                ReportPortal.stepFailWithOutScreenshot("A6 Account Number:- " + productsA6.get("Account Number") +
                        " from Products and Services does not exists in BGX4 Products page");
            }
        }
        pageObjectManager.getPersonalHeaderUpdate().clickBackToCustomerSearch();
        pageObjectManager.getFooter().clickCancel();
    }

    @Then("^verified non-personal account created successfully$")
    public void verifiedNonPersonalAccountCreatedSuccessfully() throws Exception {
        //  Read Non-Personal data from database
        testData = TestDataDB.getInstance().getData(
                TestDataQueries.getInstance().
                        getTableName(scenarioContext.getTableName(),
                                scenarioContext.getScenarioId()));

        pageObjectManager.getCustomerSelection().clickCustomer(testData.getString("CIDNonPersonal"),"CID");

        Map<String,String> accountDetails = pageObjectManager.getProductsAndServicesNonPersonal().getAccountDetails(testData.getString("AccountNumber"));
        if(accountDetails.get("Account Number").replaceAll("\\s+","")
                .equals(testData.getString("AccountNumber"))){
            ReportPortal.stepPassWithScreenshot("Products and Services--> Customer account details are found, " +
                    " Account Number:- "+testData.getString("AccountNumber"));
        }else{
            ReportPortal.stepFailWithScreenshot("Products and Services--> Customer account details are not found, " +
                    " Expected account number:- "+testData.getString("AccountNumber"));
        }
    }


}
