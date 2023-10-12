/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-07-15
 * Created Time: 12:56 a.m.
 */

package bns.a6.microui.api.pojo.bfbk.countrycodereference.utility;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.pojo.bfbk.countrycodereference.mapper.get.Mapper;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CountryCodeReference extends APIBasePage {


    public Mapper getCountryCodeReferenceResponse(Response response) throws JsonProcessingException {
        return (Mapper) parseJsonStringToJavaObject(response.asPrettyString(), Mapper.class);
    }


    public Response getResponse(String action, String serviceName, String language, String includeInActive) throws Exception {
        Response response = null;
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(serviceName);
        if (language != null) {
            requestSpecification.queryParam("language", language);
        }
        if (includeInActive != null) {
            requestSpecification.queryParam("include_inactive", includeInActive);
        }

        if (serviceName.equals(ServiceNames.COUNTRYCODEREFERENCE.name())) {
            if (action.equalsIgnoreCase("GET")) {
                response = get(requestSpecification, ServiceURLManager.getInstance().
                        getResourcePath(ServiceNames.COUNTRYCODEREFERENCE.name(), action));
            }

        }

        return response;
    }


}
