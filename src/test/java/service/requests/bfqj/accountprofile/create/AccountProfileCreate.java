/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-27
 * Created Time: 11:12 a.m.
 */

package service.requests.bfqj.accountprofile.create;


import bns.a6.microui.api.pojo.bfqj.accountprofile.mapper.create.Mapper;
import bns.a6.microui.api.pojo.bfqj.accountprofile.services.post.address.Address;
import bns.a6.microui.api.pojo.bfqj.accountprofile.services.post.countrycode.Country_cd;
import bns.a6.microui.api.pojo.bfqj.accountprofile.utility.AccountProfile;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountProfileCreate {

    //     *********************************** Account Profile******************************************
    public String generateAccountProfileCreateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        Address address = new Address();
        address.setState(resultset.getString("state"));
        address.setCity(resultset.getString("city"));
        address.setLine_1_addr(resultset.getString("line_1_addr"));
        address.setLine_2_addr(resultset.getString("line_2_addr"));
        address.setPostal_cd(resultset.getString("postal_cd"));

        Country_cd country_cd = new Country_cd();
        country_cd.setCode(resultset.getString("code"));

        address.setCountry_cd(country_cd);

        Mapper mapper = new Mapper();
        mapper.setAccount_number(resultset.getString("account_number"));
        mapper.setAccount_title1(resultset.getString("account_title1"));
        mapper.setAccount_title2(resultset.getString("account_title2"));
        mapper.setProduct_type(resultset.getString("product_type"));
        mapper.setSub_product_code(resultset.getString("sub_product_code"));

        mapper.setAddress(address);

        AccountProfile accountProfile = new AccountProfile();
        return accountProfile.getAccountProfileRequest(mapper);
    }
}
