/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 1:42 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customersearch.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bf9k.customersearch.mapper.get.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerSearch extends APIBasePage {

    public String getCustomerSearchRequest(Mapper getCustomerSearch) throws JsonProcessingException {
        return parseJavaObjectToString(getCustomerSearch);
    }

    public Mapper getCustomerSearchResponse(Response response) throws JsonProcessingException {
        return (Mapper) parseJsonStringToJavaObject(response.asPrettyString(), Mapper.class);
    }

    public Response getResponse(String requestBody, String action, String serviceName) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName).body(requestBody);

        if (serviceName.equals(ServiceNames.CUSTOMERSEARCH.name())) {
            if (action.equalsIgnoreCase("POST")) {
                response = post(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.CUSTOMERSEARCH.name(), action));
            }

        }

        return response;
    }

}
