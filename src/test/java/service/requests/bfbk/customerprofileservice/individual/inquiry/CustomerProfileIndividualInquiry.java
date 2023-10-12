/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 2:03 p.m.
 */

package service.requests.bfbk.customerprofileservice.individual.inquiry;

import bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.post.Mapper;
import bns.a6.microui.api.pojo.bfbk.customerprofile.utility.CustomerProfile;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerProfileIndividualInquiry {


    // Personal customer inquiry request body - Customer Profile
    public String generateCustomerInquiryRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        Mapper mapper = new Mapper();
        mapper.setCustomer_key(resultset.getString("customer_key"));

        CustomerProfile customerProfile = new CustomerProfile();
        return customerProfile.getCustomerProfileRequest(mapper);

    }

}
