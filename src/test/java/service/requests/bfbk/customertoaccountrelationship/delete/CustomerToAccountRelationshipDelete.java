/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-23
 * Created Time: 9:01 a.m.
 */

package service.requests.bfbk.customertoaccountrelationship.delete;


import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.mapper.delete.Mapper;
import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.services.delete.Relationships;
import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility.CustomerToAccountRelationship;
import com.fasterxml.jackson.core.JsonProcessingException;
import service.requests.bfbk.customertoaccountrelationship.create.CustomerToAccountRelationshipCreate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomerToAccountRelationshipDelete extends CustomerToAccountRelationshipCreate {

    //     *********************************** Customer to account relationship ******************************************
    public String generateCustomerToAccountRelationshipRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //      Customer to account relationship
        List<Relationships> relationships
                = new LinkedList<>();
        Relationships relationship = new Relationships();
        relationship.setRelationship_type(resultset.getString("relationship_type"));
        relationship.setAccount_number(resultset.getString("account_number"));
        relationship.setProduct_code(resultset.getString("product_code"));
        relationship.setAction_type(resultset.getString("action_type"));
        relationships.add(relationship);
        Mapper mapper = new Mapper();


        mapper.setCustomer_id(resultset.getString("customer_id"));
        mapper.setRelationships(relationships);

        CustomerToAccountRelationship customerToAccountRelationship = new CustomerToAccountRelationship();
        return customerToAccountRelationship.getCustomerToAccountRelationship(mapper);
    }
}
