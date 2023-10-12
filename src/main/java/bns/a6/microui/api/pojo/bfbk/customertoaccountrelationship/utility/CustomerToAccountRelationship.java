/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 1:42 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.mapper.get.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerToAccountRelationship extends APIBasePage {

    public String getCustomerToAccountRelationship(Mapper customerToAccountRelationship) throws JsonProcessingException {
        return parseJavaObjectToString(customerToAccountRelationship);
    }

    public String getCustomerToAccountRelationship(bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.mapper.post.Mapper customerToAccountRelationship) throws JsonProcessingException {
        return parseJavaObjectToString(customerToAccountRelationship);
    }

    public String getCustomerToAccountRelationship(bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.mapper.put.Mapper customerToAccountRelationship) throws JsonProcessingException {
        return parseJavaObjectToString(customerToAccountRelationship);
    }

    public String getCustomerToAccountRelationship(bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.mapper.delete.Mapper customerToAccountRelationship) throws JsonProcessingException {
        return parseJavaObjectToString(customerToAccountRelationship);
    }

    public Response getResponse(String requestBody, String action, String serviceName) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName).body(requestBody);

        if (serviceName.equals(ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name())) {
            if (action.equalsIgnoreCase("POST")) {
                response = post(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name(), action));
            } else if (action.equalsIgnoreCase("PUT")) {
                response = put(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name(), action));
            }

        }

        return response;
    }

}
