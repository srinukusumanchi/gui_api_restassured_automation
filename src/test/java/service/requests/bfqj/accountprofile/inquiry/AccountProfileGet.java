/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-23
 * Created Time: 8:38 a.m.
 */

package service.requests.bfqj.accountprofile.inquiry;


import bns.a6.microui.api.pojo.bfqj.accountprofile.mapper.get.Mapper;
import bns.a6.microui.api.pojo.bfqj.accountprofile.utility.AccountProfile;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountProfileGet {

    //     *********************************** Account Profile Services ******************************************
    public String generateAccountProfileServiceGetRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //      Account Profile
        Mapper mapper = new Mapper();
        mapper.setAccount_number(resultset.getString("account_number"));
        mapper.setProduct_type(resultset.getString("product_type"));
        mapper.setSub_product_code(resultset.getString("sub_product_code"));
        AccountProfile accountProfile = new AccountProfile();
        return accountProfile.getAccountProfileRequest(mapper);
    }
}
