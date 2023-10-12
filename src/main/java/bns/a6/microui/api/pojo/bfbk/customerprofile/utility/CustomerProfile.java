/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-27
 * Created Time: 11:28 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.post.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerProfile extends APIBasePage {

    public String getCustomerProfileRequest(Mapper createCustomerProfile) throws JsonProcessingException {
        return parseJavaObjectToString(createCustomerProfile);
    }

    public Response getResponse(String requestBody, String action, String serviceType, String serviceName) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName).body(requestBody);

        if (serviceName.equals(ServiceNames.CUSTOMERPROFILE.name())) {
            if (action.equalsIgnoreCase("POST")) {
                response = post(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.CUSTOMERPROFILE.name(), serviceType));
            } else if (action.equalsIgnoreCase("PUT")) {
                response = put(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.CUSTOMERPROFILE.name(), serviceType));
            }

        }

        return response;
    }

    public bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.get.Mapper getCustomerProfileResponse(Response response) throws JsonProcessingException {
        return (bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.get.Mapper)
                parseJsonStringToJavaObject(response.asPrettyString(), bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.get.Mapper.class);
    }

}
