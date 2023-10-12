/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-27
 * Created Time: 11:28 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.identification.personal.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.identification.personal.post.mapper.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Identification extends APIBasePage {

    public String getIdentificationRequest(Mapper createIdentification) throws JsonProcessingException {
        return parseJavaObjectToString(createIdentification);
    }

    public Response getResponse(String requestBody, String action, String serviceName) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName).body(requestBody);

        if (serviceName.equals(ServiceNames.IDENTIFICATION.name())) {
            if (action.equalsIgnoreCase("POST")) {
                response = post(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.IDENTIFICATION.name(), action));
            } else if (action.equalsIgnoreCase("PUT")) {
                response = put(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.IDENTIFICATION.name(), action));
            }

        }

        return response;
    }

    public Mapper getIdentificationResponse(Response response) throws JsonProcessingException {
        return (Mapper) parseJsonStringToJavaObject(response.asPrettyString(), Mapper.class);
    }

}
