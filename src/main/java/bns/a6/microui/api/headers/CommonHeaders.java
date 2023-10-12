/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-09-01
 * Created Time: 12:59 p.m.
 */

package bns.a6.microui.api.headers;

import bns.a6.microui.api.constants.FrameworkConstants;
import bns.a6.microui.web.utility.ReadPropertyFile;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Builder(setterPrefix = "set")
@Getter
public class CommonHeaders {

    // Header Keys
    private static final String contentType = "Content-Type";

    public Map<String, String> getHeaders() throws Exception {
        Map<String, String> headers = new HashMap<>();

        String host = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(),
                        "apihost");
        if (host.contains("IMU")) {
            headers.put(FrameworkConstants.getContenttype(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersuatpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getContenttype()));

            headers.put(FrameworkConstants.getXchannelid(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersuatpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getXchannelid()));

            headers.put(FrameworkConstants.getXusercontext(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersuatpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getXusercontext()));

            headers.put(FrameworkConstants.getXcountrycode(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersuatpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getXcountrycode()));

            headers.put(FrameworkConstants.getXoriginatingapplcode(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersuatpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getXoriginatingapplcode()));

        } else if (host.contains("IMI")) {
            headers.put(FrameworkConstants.getContenttype(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersistpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getContenttype()));

            headers.put(FrameworkConstants.getXchannelid(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersistpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getXchannelid()));

            headers.put(FrameworkConstants.getXusercontext(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersistpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getXusercontext()));

            headers.put(FrameworkConstants.getXcountrycode(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersistpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getXcountrycode()));

            headers.put(FrameworkConstants.getXoriginatingapplcode(), ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getHeadersistpath(),
                    FrameworkConstants.getHeadersfilename(), FrameworkConstants.getXoriginatingapplcode()));

        }

        return headers;
    }
}
