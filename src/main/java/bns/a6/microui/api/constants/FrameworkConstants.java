/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-21
 * Created Time: 12:03 p.m.
 */

package bns.a6.microui.api.constants;

public class FrameworkConstants {

    private static final String PROJECTRESOURCESPATH = "/resources/";
    private static final String APPLICATIONPROPERTIESFILENAME = "application.properties";
    private static final String URLUATCCPATH = "/src/main/resources/config/api/urls/uat/cc/";
    private static final String URLUATUSE2PATH = "/src/main/resources/config/api/urls/uat/use2/";
    private static final String URLISTCCPATH = "/src/main/resources/config/api/urls/ist/cc/";
    private static final String URLISTUSE2PATH = "/src/main/resources/config/api/urls/ist/use2/";
    private static final String OPENAMUATPATH = "/src/main/resources/config/api/urls/uat/openam/";
    private static final String OPENAMISTPATH = "/src/main/resources/config/api/urls/ist/openam/";
    private static final String APIENVIRONMENTSPATH = "/src/main/resources/config/api/environment/";
    private static final String PATHPARAMETERSPATH = "/src/main/resources/config/api/pathparameters/";
    private static final String CLIENTCREDENTIALSUATPATH = "/src/main/resources/config/api/clientCredentials/uat/";
    private static final String CLIENTCREDENTIALSISTPATH = "/src/main/resources/config/api/clientCredentials/ist/";
    private static final String HEADERSUATPATH = "/src/main/resources/config/api/headers/uat/";
    private static final String HEADERSISTPATH = "/src/main/resources/config/api/headers/ist/";
    private static final String URLFILENAME = "url.properties";
    private static final String PATHPARAMETERFILENAME = "pathparameter.properties";
    private static final String APIENVIRONMENTFILENAME = "EnvironmentMapping.properties";
    private static final String CLIENTCREDENTIALSFILENAME = "clientCredentials.properties";
    private static final String HEADERSFILENAME = "headers.properties";

    // Headers Keys
    private static final String CONTENTTYPE = "Content-Type";
    private static final String XCHANNELID = "x-channel-id";
    private static final String XUSERCONTEXT = "x-user-context";
    private static final String XCOUNTRYCODE = "x-country-code";
    private static final String XORIGINATINGAPPLCODE = "x-originating-appl-code";

    private FrameworkConstants() {

    }


    public static String getProjectresourcespath() {
        return System.getProperty("user.dir") + PROJECTRESOURCESPATH;
    }

    public static String getApplicationproperties() {
        return APPLICATIONPROPERTIESFILENAME;
    }

    public static String getUatCCPath() {
        return System.getProperty("user.dir") + URLUATCCPATH;
    }

    public static String getUatUSE2Path() {
        return System.getProperty("user.dir") + URLUATUSE2PATH;
    }

    public static String getIstCCPath() {
        return System.getProperty("user.dir") + URLISTCCPATH;
    }

    public static String getIstUSE2Path() {
        return System.getProperty("user.dir") + URLISTUSE2PATH;
    }

    public static String getURLFILENAME() {
        return URLFILENAME;
    }

    public static String getApiEnvironmentsPath() {
        return System.getProperty("user.dir") + APIENVIRONMENTSPATH;
    }

    public static String getApienvironmentfilename() {
        return APIENVIRONMENTFILENAME;
    }


    public static String getPathparameterspath() {
        return System.getProperty("user.dir") + PATHPARAMETERSPATH;
    }

    public static String getPathparameterfilename() {
        return PATHPARAMETERFILENAME;
    }

    public static String getClientcredentialsuatpath() {
        return System.getProperty("user.dir") + CLIENTCREDENTIALSUATPATH;
    }

    public static String getClientcredentialsistpath() {
        return System.getProperty("user.dir") + CLIENTCREDENTIALSISTPATH;
    }

    public static String getClientcredentialsfilename() {
        return CLIENTCREDENTIALSFILENAME;
    }

    public static String getOpenamuatpath() {
        return System.getProperty("user.dir") + OPENAMUATPATH;
    }

    public static String getOpenamistpath() {
        return System.getProperty("user.dir") + OPENAMISTPATH;
    }

    public static String getHeadersuatpath() {
        return System.getProperty("user.dir") + HEADERSUATPATH;
    }

    public static String getHeadersistpath() {
        return System.getProperty("user.dir") + HEADERSISTPATH;
    }

    public static String getHeadersfilename() {
        return HEADERSFILENAME;
    }


//    Headers

    public static String getContenttype() {
        return CONTENTTYPE;
    }

    public static String getXchannelid() {
        return XCHANNELID;
    }

    public static String getXusercontext() {
        return XUSERCONTEXT;
    }

    public static String getXcountrycode() {
        return XCOUNTRYCODE;
    }

    public static String getXoriginatingapplcode() {
        return XORIGINATINGAPPLCODE;
    }
}
