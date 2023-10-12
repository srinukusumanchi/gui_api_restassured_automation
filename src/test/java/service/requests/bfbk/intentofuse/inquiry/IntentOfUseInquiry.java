/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-23
 * Created Time: 8:38 a.m.
 */

package service.requests.bfbk.intentofuse.inquiry;

import bns.a6.microui.api.pojo.bfbk.intentofuse.mapper.put.Mapper;
import bns.a6.microui.api.pojo.bfbk.intentofuse.utility.IntentOfUse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntentOfUseInquiry {

    //     *********************************** Intent of Use Customer level ******************************************
    public String generateIntentOfUseGetRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //      Intent use accounts
        Mapper mapper = new Mapper();
        mapper.setCustomer_id(resultset.getString("customer_id"));

        IntentOfUse intentOfUse = new IntentOfUse();
        return intentOfUse.getIntentOfUseRequest(mapper);
    }
}
