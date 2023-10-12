/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-29
 * Created Time: 3:02 p.m.
 */

package bns.a6.microui.api.pojo.openam;

import bns.a6.microui.api.constants.FrameworkConstants;
import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.web.utility.ReadPropertyFile;

import java.util.HashMap;
import java.util.Map;

public class ClientCredentials {


    protected Map<String, String> getOpenAMClientCredentials(String serviceName) throws Exception {
        Map<String, String> formParam = new HashMap<>();
        String grantType = null;
        String scope = null;
        String clientId = null;
        String clientSecret = null;

        String host = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(),
                        "apihost");
        if (host.contains("IMU")) {
            grantType = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsuatpath() + "/",
                    FrameworkConstants.getClientcredentialsfilename(), "grantType");

            scope = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsuatpath() + "/",
                    FrameworkConstants.getClientcredentialsfilename(), "scope");

            if (serviceName.equals(ServiceNames.CUSTOMERSEARCH.name())
                    || serviceName.equals(ServiceNames.CUSTOMERLOOKUP.name())) {
                clientId = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsuatpath() + "/",
                        FrameworkConstants.getClientcredentialsfilename(), "clientId_CustomerSearch");

                clientSecret = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsuatpath() + "/",
                        FrameworkConstants.getClientcredentialsfilename(), "clientSecret_CustomerSearch");
            } else {
                clientId = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsuatpath() + "/",
                        FrameworkConstants.getClientcredentialsfilename(), "clientId");

                clientSecret = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsuatpath() + "/",
                        FrameworkConstants.getClientcredentialsfilename(), "clientSecret");
            }

        } else if (host.contains("IMI")) {
            grantType = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsistpath() + "/",
                    FrameworkConstants.getClientcredentialsfilename(), "grantType");

            scope = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsistpath() + "/",
                    FrameworkConstants.getClientcredentialsfilename(), "scope");

            if (serviceName.equals(ServiceNames.CUSTOMERSEARCH.name())
                    || serviceName.equals(ServiceNames.CUSTOMERLOOKUP.name())) {
                clientId = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsistpath() + "/",
                        FrameworkConstants.getClientcredentialsfilename(), "clientId_CustomerSearch");

                clientSecret = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsistpath() + "/",
                        FrameworkConstants.getClientcredentialsfilename(), "clientSecret_CustomerSearch");
            } else {
                clientId = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsistpath() + "/",
                        FrameworkConstants.getClientcredentialsfilename(), "clientId");

                clientSecret = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getClientcredentialsistpath() + "/",
                        FrameworkConstants.getClientcredentialsfilename(), "clientSecret");
            }
        }


        formParam.put("grant_type", grantType);
        formParam.put("scope", scope);
        formParam.put("client_id", clientId);
        formParam.put("client_secret", clientSecret);
        return formParam;
    }

}
