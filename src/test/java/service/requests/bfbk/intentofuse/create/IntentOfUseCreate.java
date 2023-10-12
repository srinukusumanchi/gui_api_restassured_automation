/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-23
 * Created Time: 9:01 a.m.
 */

package service.requests.bfbk.intentofuse.create;

import bns.a6.microui.api.pojo.bfbk.intentofuse.mapper.put.Mapper;
import bns.a6.microui.api.pojo.bfbk.intentofuse.services.put.intentuseaccounts.IntentUseOfUse;
import bns.a6.microui.api.pojo.bfbk.intentofuse.utility.IntentOfUse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntentOfUseCreate {

    //     *********************************** Intent of Use Customer level ******************************************
    public String generateIntentOfUseCreateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //      Intent use accounts
        IntentUseOfUse intentUseOfAccounts = new IntentUseOfUse();
        intentUseOfAccounts.setUpdated_customer_id(resultset.getString("updated_customer_id"));
        intentUseOfAccounts.setIntent_account_number(resultset.getString("intent_account_number"));
        intentUseOfAccounts.setIntended_use_type(resultset.getString("intended_use_type"));
        intentUseOfAccounts.setUpdated_transaction_date(resultset.getString("updated_transaction_date"));
        intentUseOfAccounts.setRelationship(resultset.getString("relationship"));
        intentUseOfAccounts.setProduct_type(resultset.getString("product_type"));
        intentUseOfAccounts.setSub_product_type(resultset.getString("sub_product_type"));
        intentUseOfAccounts.setCapture_type(resultset.getString("capture_type"));
        intentUseOfAccounts.setAml_trigger(resultset.getString("aml_trigger"));
        intentUseOfAccounts.setLast_update_user_id(resultset.getString("last_update_user_id"));

        Mapper mapper = new Mapper();
        mapper.setIntentUseOfAccounts(intentUseOfAccounts);


        IntentOfUse intentOfUse = new IntentOfUse();
        return intentOfUse.getIntentOfUseRequest(mapper);
    }
}
