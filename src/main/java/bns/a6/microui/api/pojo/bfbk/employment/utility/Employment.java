/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-27
 * Created Time: 11:28 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.employment.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.employment.mapper.post.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Employment extends APIBasePage {

    public String getEmploymentRequestCreate(Mapper createEmployment) throws JsonProcessingException {
        return parseJavaObjectToString(createEmployment);
    }

    public String getEmploymentRequestUpdate(bns.a6.microui.api.pojo.bfbk.employment.mapper.put.Mapper updateEmployment) throws JsonProcessingException {
        return parseJavaObjectToString(updateEmployment);
    }

    public Response getResponse(String requestBody, String action, String serviceName) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName).body(requestBody);

        if (serviceName.equals(ServiceNames.EMPLOYMENT.name())) {
            if (action.equalsIgnoreCase("POST")) {
                response = post(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.EMPLOYMENT.name(), action));
            } else if (action.equalsIgnoreCase("PUT")) {
                response = put(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.EMPLOYMENT.name(), action));
            }

        }

        return response;
    }

    public Mapper getEmploymentResponse(Response response) throws JsonProcessingException {
        return (Mapper) parseJsonStringToJavaObject(response.asPrettyString(), Mapper.class);
    }
}
