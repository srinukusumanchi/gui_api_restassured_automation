/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-23
 * Created Time: 12:45 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customerlookup.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bf9k.customerlookup.mapper.get.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerLookUp extends APIBasePage {

    public String getCustomerLookUpRequest(Mapper getCustomerSearch) throws JsonProcessingException {
        return parseJavaObjectToString(getCustomerSearch);
    }

    public bns.a6.microui.api.pojo.bf9k.customerlookup.mapper.get.Mapper getCustomerLookupResponse(Response response) throws JsonProcessingException {
        return (bns.a6.microui.api.pojo.bf9k.customerlookup.mapper.get.Mapper) parseJsonStringToJavaObject(response.asPrettyString(), bns.a6.microui.api.pojo.bf9k.customerlookup.mapper.get.Mapper.class);
    }

    public Response getResponse(String requestBody, String action, String serviceName) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName).body(requestBody);

        if (serviceName.equals(ServiceNames.CUSTOMERLOOKUP.name())) {
            if (action.equalsIgnoreCase("POST")) {
                response = post(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.CUSTOMERLOOKUP.name(), action));
            }

        }

        return response;
    }

}
