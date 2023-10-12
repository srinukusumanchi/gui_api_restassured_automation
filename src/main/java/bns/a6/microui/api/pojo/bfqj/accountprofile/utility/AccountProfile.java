/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 1:42 p.m.
 */

package bns.a6.microui.api.pojo.bfqj.accountprofile.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfqj.accountprofile.mapper.get.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AccountProfile extends APIBasePage {

    public String getAccountProfileRequest(Mapper getAccountProfile) throws JsonProcessingException {
        return parseJavaObjectToString(getAccountProfile);
    }

    public String getAccountProfileRequest(bns.a6.microui.api.pojo.bfqj.accountprofile.mapper.create.Mapper getAccountProfile) throws JsonProcessingException {
        return parseJavaObjectToString(getAccountProfile);
    }

    public String getAccountProfileRequest(bns.a6.microui.api.pojo.bfqj.accountprofile.mapper.put.Mapper getAccountProfile) throws JsonProcessingException {
        return parseJavaObjectToString(getAccountProfile);
    }

    public Mapper getAccountProfileResponse(Response response) throws JsonProcessingException {
        return (Mapper) parseJsonStringToJavaObject(response.asPrettyString(), Mapper.class);
    }

    public Response getResponse(String requestBody, String action, String serviceName) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName).body(requestBody);

        if (serviceName.equals(ServiceNames.ACCOUNTPROFILE.name())) {
            if (action.equalsIgnoreCase("GET") ||
                    action.equalsIgnoreCase("POST")) {
                response = post(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.ACCOUNTPROFILE.name(), action));
            } else if (action.equalsIgnoreCase("PUT")) {
                response = put(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.ACCOUNTPROFILE.name(), action));
            }

        }

        return response;
    }

}
