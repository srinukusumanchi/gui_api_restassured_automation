/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-07
 * Created Time: 6:42 a.m.
 */

package bns.a6.microui.web.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {

    }
    private static final int ALERTWAIT = 20;
    private static final int IMPLICITWAIT = 30;
    private static final int EXPLICITWAIT = 60;
    private static final String DATABASETESTPROPERTIESFILEPATH = "/src/test/resources/config/database/";
    private static final String WEBTESTPROPERTIESPATH = "/src/test/resources/config/web/";
    private static final String IDORDOCUMENTTYPEPROPERTIESPATH = "/identification/idordocumenttype/";
    private static final String PROJECTRESOURCESPATH = "/resources/";
    private static final String APPLICATIONPROPERTIESFILENAME = "application.properties";
    private static final String TESTDATADATABASEFILEName = "testdataDatabase.properties";
    private static final String DOCUMENTTYPEFILENAME = "documentType.properties";
    private static final String MYSQLDRIVERPATH = "com.mysql.cj.jdbc.Driver";
    private static final String DB2DRIVERPATH = "com.ibm.db2.jcc.DB2Driver";
    private static final String MDMPROPERTIESUATFILEPATH = "/src/main/resources/config/database/uat/";
    private static final String MDMPROPERTIESISTFILEPATH = "/src/main/resources/config/database/ist/";
    private static final String MDMDATABASEFILEName = "mdmDatabase.properties";

    public static Integer getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static Integer getAlertWait() {
        return ALERTWAIT;
    }


    public static Integer getImplicitWait() {
        return IMPLICITWAIT;
    }

    public static String getTestPropertiesFilePath() {
        return System.getProperty("user.dir") + DATABASETESTPROPERTIESFILEPATH;
    }

    public static String getTestDataDatabaseFileName() {
        return TESTDATADATABASEFILEName;
    }

    public static String getMysqldriverpath() {
        return MYSQLDRIVERPATH;
    }

    public static String getProjectresourcespath() {
        return System.getProperty("user.dir") + PROJECTRESOURCESPATH;
    }

    public static String getApplicationproperties() {
        return APPLICATIONPROPERTIESFILENAME;
    }

    public static String getMdmpropertiesuatfilepath() {
        return System.getProperty("user.dir") + MDMPROPERTIESUATFILEPATH;
    }

    public static String getMdmpropertiesistfilepath() {
        return System.getProperty("user.dir") + MDMPROPERTIESISTFILEPATH;
    }

    public static String getMDMDatabaseFileName() {
        return MDMDATABASEFILEName;
    }

    public static String getDB2driverpath() {
        return DB2DRIVERPATH;
    }

    public static String getWebtestpropertiespath() {
        return System.getProperty("user.dir") + WEBTESTPROPERTIESPATH;
    }

    public static String getIdordocumenttypepropertiespath() {
        return IDORDOCUMENTTYPEPROPERTIESPATH;
    }

    public static String getDocumenttypefilename() {
        return DOCUMENTTYPEFILENAME;
    }
}
