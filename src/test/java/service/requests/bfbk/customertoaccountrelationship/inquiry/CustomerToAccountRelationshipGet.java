/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-23
 * Created Time: 8:38 a.m.
 */

package service.requests.bfbk.customertoaccountrelationship.inquiry;


import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.mapper.get.Mapper;
import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerToAccountRelationshipGet {

    //     ***********************************Customer to account relationship ******************************************
    public String generateCustomerToAccountRelationshipGetRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
//        Customer to account relationship
        Mapper mapper = new Mapper();
        mapper.setCustomer_id(resultset.getString("customer_id"));

        CustomerToAccountRelationship customerToAccountRelationship = new CustomerToAccountRelationship();
        return customerToAccountRelationship.getCustomerToAccountRelationship(mapper);
    }
}
