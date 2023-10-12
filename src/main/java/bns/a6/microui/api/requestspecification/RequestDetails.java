/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-19
 * Created Time: 12:55 p.m.
 */

package bns.a6.microui.api.requestspecification;

import bns.a6.microui.api.constants.FrameworkConstants;
import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.api.headers.CommonHeaders;
import bns.a6.microui.api.pojo.openam.OpenAM;
import bns.a6.microui.api.testbase.APIBasePage;
import bns.a6.microui.api.urlmanager.ServiceURLManager;
import bns.a6.microui.web.utility.ReadPropertyFile;
import io.restassured.specification.RequestSpecification;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder(setterPrefix = "set")
@Getter
public class RequestDetails extends APIBasePage {

    private String getHostURL(String serviceName) throws Exception {
        String host = null;
        String environment = null;
        String hostURL = null;
        host = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                FrameworkConstants.getApplicationproperties(), "apihost");

        environment = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                FrameworkConstants.getApplicationproperties(), "apienvironment");
        if (ServiceNames.CUSTOMERPROFILE.name().equals(serviceName)) {
            if (host.contains("IMU")) {
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatCCPath(),
                            FrameworkConstants.getURLFILENAME(), "customerprofileservices_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "customerprofileservices_host");
                }
            } else if (host.contains("IMI"))
                hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstUSE2Path(),
                        FrameworkConstants.getURLFILENAME(), "customerprofileservices_host");
        } else if (ServiceNames.IDENTIFICATION.name().equals(serviceName) ||
                ServiceNames.EMPLOYMENT.name().equals(serviceName)) {
            if (host.contains("IMU")) {
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatCCPath(),
                            FrameworkConstants.getURLFILENAME(), "customerservices_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "customerservices_host");
                }
            } else if (host.contains("IMI"))
                hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstUSE2Path(),
                        FrameworkConstants.getURLFILENAME(), "customerservices_host");
        } else if (ServiceNames.CUSTOMERSEARCH.name().equals(serviceName) ||
                ServiceNames.CUSTOMERLOOKUP.name().equals(serviceName)) {
            if (host.contains("IMU")) {
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatCCPath(),
                            FrameworkConstants.getURLFILENAME(), "customersearch_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "customersearch_host");
                }
            } else if (host.contains("IMI")) {
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstCCPath(),
                            FrameworkConstants.getURLFILENAME(), "customersearch_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "customersearch_host");
                }
            }
        } else if (ServiceNames.INTENTOFUSE.name().equals(serviceName) ||
                ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.name().equals(serviceName)) {
            if (host.contains("IMU")) {
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatCCPath(),
                            FrameworkConstants.getURLFILENAME(), "customeraccountservices_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "customeraccountservices_host");
                }
            } else if (host.contains("IMI"))
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstCCPath(),
                            FrameworkConstants.getURLFILENAME(), "customeraccountservices_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "customeraccountservices_host");
                }

        } else if (ServiceNames.COUNTRYCODEREFERENCE.name().equals(serviceName)) {
            if (host.contains("IMU")) {
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatCCPath(),
                            FrameworkConstants.getURLFILENAME(), "customerreference_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "customerreference_host");
                }
            } else if (host.contains("IMI")) {
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstCCPath(),
                            FrameworkConstants.getURLFILENAME(), "customerreference_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "customerreference_host");
                }
            }
        } else if (ServiceNames.ACCOUNTPROFILE.name().equals(serviceName)) {
            if (host.contains("IMU")) {
                if (environment.equalsIgnoreCase("CC")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatCCPath(),
                            FrameworkConstants.getURLFILENAME(), "accountprofile_host");
                } else if (environment.equalsIgnoreCase("USE2")) {
                    hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getUatUSE2Path(),
                            FrameworkConstants.getURLFILENAME(), "accountprofile_host");
                }
            } else if (host.contains("IMI"))
                hostURL = ReadPropertyFile.getInstance().getPropertyValue(FrameworkConstants.getIstUSE2Path(),
                        FrameworkConstants.getURLFILENAME(), "accountprofile_host");
        }

        return hostURL;
    }

    public String getResourcePath(String action) throws Exception {
        return ServiceURLManager.getInstance().getResourcePath(ServiceNames.CUSTOMERPROFILE.name(), action);
    }

    public RequestSpecification getRequestSpecification(String serviceName) throws Exception {
        RequestSpecification requestSpecification = null;

//        URL
        String url = getHostURL(serviceName);

        //        Access Token
        String accessToken = OpenAM.builder().build().getAccessToken(serviceName);

//        Headers
        Map<String, String> headers = CommonHeaders.builder().build().getHeaders();
        headers.put("Authorization", "Bearer " + accessToken);

        requestSpecification = uri(url);
        //           Headers
        requestSpecification = requestSpecification.headers(headers);

        return requestSpecification;
    }
}
