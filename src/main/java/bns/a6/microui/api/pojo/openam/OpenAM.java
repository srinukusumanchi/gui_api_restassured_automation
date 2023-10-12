/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-04-12
 * Created Time: 1:46 p.m.
 */

package bns.a6.microui.api.pojo.openam;

import bns.a6.microui.api.constants.FrameworkConstants;
import bns.a6.microui.api.headers.OpenAMHeaders;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.web.utility.ReadPropertyFile;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Builder;
import lombok.Getter;
import org.assertj.core.api.Assertions;

import java.util.Map;

@Builder(setterPrefix = "set")
@Getter
public class OpenAM extends APIBasePage {
    private String grantType;
    private String scope;
    private String clientId;
    private String clientSecret;


    private String getOpenAMHost() throws Exception {
        String host = null;
        String openAMHost = null;
        host = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                FrameworkConstants.getApplicationproperties(), "host");
        if (host.contains("IMU"))
            openAMHost = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getOpenamuatpath(),
                    FrameworkConstants.getURLFILENAME(), "host");
        else if (host.contains("IMI"))
            openAMHost = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getOpenamistpath(),
                    FrameworkConstants.getURLFILENAME(), "host");
        return openAMHost;
    }

    private JsonPath getOpenAMResponse(String serviceName) throws Exception {
        RequestSpecification requestSpecification = null;
        ClientCredentials clientCredentials = new ClientCredentials();
        Map<String, String> formParam = clientCredentials.getOpenAMClientCredentials(serviceName);
        Map<String, String> headers = OpenAMHeaders.builder().build().getHeaders();

        /*ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getPathparameterspath(),
                FrameworkConstants.getPathparameterfilename(), "openAm_postPathParameter");

*/
        requestSpecification = uri(getOpenAMHost());
        //           Headers
        requestSpecification = requestSpecification.headers(headers);

        //           Body - ("x-www-form-urlencoded)
        requestSpecification = requestSpecification.formParams(formParam);

        //          HTTP Method - POST
        String resourcePath = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getPathparameterspath(),
                FrameworkConstants.getPathparameterfilename(), "openAm_postPathParameter");
        Response response = post(requestSpecification, resourcePath);
        if (!(response.statusCode() == 200)) {
            Assertions.fail("Authorization failed, Status code :-" + response.statusCode() +
                    " Reason - " + response.getBody().asPrettyString());
        }
        //         Parse Response body
        return parseJsonString(response.asString());

    }

    public String getAccessToken(String serviceName) throws Exception {
        JsonPath openAMResponse = getOpenAMResponse(serviceName);
        return getStringResponse(openAMResponse, "access_token");
    }

}
