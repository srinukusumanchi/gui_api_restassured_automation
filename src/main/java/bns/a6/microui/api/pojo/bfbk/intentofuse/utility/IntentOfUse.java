/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 1:42 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.intentofuse.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.intentofuse.mapper.put.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IntentOfUse extends APIBasePage {

    public String getIntentOfUseRequest(Mapper getIntentOfUse) throws JsonProcessingException {
        return parseJavaObjectToString(getIntentOfUse);
    }


    public Response getResponse(String requestBody, String action, String serviceName) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName).body(requestBody);

        if (serviceName.equals(ServiceNames.INTENTOFUSE.name())) {
            if (action.equalsIgnoreCase("POST")) {
                response = post(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.INTENTOFUSE.name(), action));
            } else if (action.equalsIgnoreCase("PUT")) {
                response = put(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.INTENTOFUSE.name(), action));
            }

        }

        return response;
    }

}
