/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-21
 * Created Time: 11:56 a.m.
 */

package bns.a6.microui.api.urlmanager;

import bns.a6.microui.api.constants.FrameworkConstants;
import bns.a6.microui.api.enums.ServiceNames;
import bns.a6.microui.web.utility.ReadPropertyFile;

import java.util.Objects;

public class ServiceURLManager {

    private static ServiceURLManager INSTANCE = null;

    private ServiceURLManager() {

    }

    public String getResourcePath(String serviceName, String serviceType) throws Exception {
        String resourcePath = null;
//       -------------------------------  BFBK -------------------------------------
        if (serviceName.equalsIgnoreCase(ServiceNames.CUSTOMERPROFILE.toString())) {
            if (serviceType.equalsIgnoreCase("CREATE")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customerprofile_postpathParameter");
            } else if (serviceType.equalsIgnoreCase("UPDATE")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customerprofile_putpathParameter");
            } else if (serviceType.equalsIgnoreCase("INQUIRY")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customerprofile_getpathParameter");
            }

        } else if (serviceName.equalsIgnoreCase(ServiceNames.CUSTOMERTOACCOUNTRELATIONSHIP.toString())) {
            if (serviceType.equalsIgnoreCase("GET")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customertoaccountrelationship_getpathParameter");
            } else if (serviceType.equalsIgnoreCase("POST")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customertoaccountrelationship_postpathParameter");
            } else if (serviceType.equalsIgnoreCase("PUT")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customertoaccountrelationship_putpathParameter");
            } else if (serviceType.equalsIgnoreCase("DELETE")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customertoaccountrelationship_deletepathParameter");
            }


        } else if (serviceName.equalsIgnoreCase(ServiceNames.CONTACTMETHOD.toString())) {
            resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                    (FrameworkConstants.getPathparameterspath(),
                            FrameworkConstants.getPathparameterfilename(), "contactmethod_putpathParameter");
        } else if (serviceName.equalsIgnoreCase(ServiceNames.IDENTIFICATION.toString())) {
            if (serviceType.equalsIgnoreCase("POST")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "identification_postpathParameter");
            } else if (serviceType.equalsIgnoreCase("PUT")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "identification_putpathParameter");
            } else if (serviceType.equalsIgnoreCase("GET")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "identification_getpathParameter");
            }
        } else if (serviceName.equalsIgnoreCase(ServiceNames.EMPLOYMENT.toString())) {
            if (serviceType.equalsIgnoreCase("POST")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "employment_postpathParameter");
            } else if (serviceType.equalsIgnoreCase("PUT")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "employment_putpathParameter");
            } else if (serviceType.equalsIgnoreCase("GET")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "employment_getpathParameter");
            }

        } else if (serviceName.equalsIgnoreCase(ServiceNames.INTENTOFUSE.toString())) {
            if (serviceType.equalsIgnoreCase("PUT")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "intentOfUse_updatepathParameter");
            } else if (serviceType.equalsIgnoreCase("GET")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "intentOfUse_getpathParameter");
            }
        } else if (serviceName.equalsIgnoreCase(ServiceNames.COUNTRYCODEREFERENCE.toString())) {
            if (serviceType.equalsIgnoreCase("GET")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "countryCodeReference_getpathParameter");
            }
        }


        //       -------------------------------  BF9K -------------------------------------

        else if (serviceName.equalsIgnoreCase(ServiceNames.CUSTOMERSEARCH.toString())) {
            if (serviceType.equalsIgnoreCase("POST")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customerSearch_getpathParameter");
            }
        } else if (serviceName.equalsIgnoreCase(ServiceNames.CUSTOMERLOOKUP.toString())) {
            if (serviceType.equalsIgnoreCase("POST")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "customerLookUp_getpathParameter");
            }
        }

        //       -------------------------------  BF9K -------------------------------------
        else if (serviceName.equalsIgnoreCase(ServiceNames.ACCOUNTPROFILE.toString())) {
            if (serviceType.equalsIgnoreCase("POST")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "accountProfile_postpathParameter");
            } else if (serviceType.equalsIgnoreCase("PUT")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "accountProfile_updatepathParameter");
            } else if (serviceType.equalsIgnoreCase("GET")) {
                resourcePath = ReadPropertyFile.getInstance().getPropertyValue
                        (FrameworkConstants.getPathparameterspath(),
                                FrameworkConstants.getPathparameterfilename(), "accountProfile_getpathParameter");
            }
        }

        return resourcePath;
    }


    private String getOpenAMURL() throws Exception {
        String url = null;
        String hostName = null;
        String host = ReadPropertyFile.getInstance().getPropertyValue
                (FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(), "host");

        if (host.equals("IMU")) {
            hostName = ReadPropertyFile.getInstance().getPropertyValue
                    (FrameworkConstants.getOpenamuatpath(),
                            FrameworkConstants.getURLFILENAME(), "host");
        } else if (host.equals("IMI")) {
            hostName = ReadPropertyFile.getInstance().getPropertyValue
                    (FrameworkConstants.getOpenamistpath(),
                            FrameworkConstants.getURLFILENAME(), "host");
        }

        String cuac_getpathParameter = ReadPropertyFile.getInstance().getPropertyValue
                (FrameworkConstants.getPathparameterspath(),
                        FrameworkConstants.getPathparameterfilename(), "customertoaccountrelationship_getpathParameter");

        url = hostName + cuac_getpathParameter;
        return url;
    }

    public static synchronized ServiceURLManager getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new ServiceURLManager();
        }
        return INSTANCE;
    }
}
