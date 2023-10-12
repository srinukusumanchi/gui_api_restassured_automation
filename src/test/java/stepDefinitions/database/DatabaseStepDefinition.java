/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-31
 * Created Time: 10:29 a.m.
 */

package stepDefinitions.database;

import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.GetAccountRelationships;
import bns.a6.microui.web.utility.database.MDMDB;
import bns.a6.microui.web.utility.database.TestDataDB;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import cucumber.api.java.en.And;
import utility.Queries;

import java.sql.ResultSet;

@QAFTestStepProvider
public class DatabaseStepDefinition {
    @And("^replace relationship status for customer accounts$")
    public void replaceRelationshipStatusForCustomerAccounts() throws Exception {
        Queries accountProductsQueryTestData = Queries.valueOf("ACCOUNTNUMBERPRODUCTS_TESTDATA");
        String query = accountProductsQueryTestData.getQuery();
        ResultSet resultSet = TestDataDB.getInstance().getData(query);

//        String accessToken = OpenAM.builder().build().getAccessToken();

        while (resultSet.next()) {
            String cid = resultSet.getString("CID");
            GetAccountRelationships getAccountRelationships = new GetAccountRelationships();
            getAccountRelationships.setCustomer_id(cid);

        }
    }


    @And("^get customer accounts from MDM having \"([^\"]*)\"$")
    public void getCustomerAccountsFromMDMHaving(String productValue) throws Throwable {
        Queries customerProductsQuery = Queries.valueOf("CUSTOMERPRODUCTS_MDM");
        String query = customerProductsQuery.getQuery().replace("<Product>", productValue);
        ResultSet resultSet = MDMDB.getInstance().getData(query);
        System.out.println(resultSet.getString(2));
    }
}
