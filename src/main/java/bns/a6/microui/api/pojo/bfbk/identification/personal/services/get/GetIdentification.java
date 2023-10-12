/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 4:58 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.identification.personal.services.get;

import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.requestspecification.RequestDetails;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIdentification extends APIBasePage {

    private String customer_key;

    public void setCustomer_key(String customer_key) {
        this.customer_key = customer_key;
    }

    public String getCustomer_key() {
        return this.customer_key;
    }


    public String getIdentificationRequest(GetIdentification createCustomerProfile) throws JsonProcessingException {
        return parseJavaObjectToString(createCustomerProfile);
    }

    public Response getResponse(String requestBody) throws Exception {
        RequestSpecification requestSpecification = RequestDetails.builder().build().
                getRequestSpecification(ServiceNames.CUSTOMERPROFILE.name()).body(requestBody);
        return post(requestSpecification, ServiceURLManager.getInstance().
                getResourcePath(ServiceNames.CUSTOMERPROFILE.name(), "POST"));
    }
}
