/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-31
 * Created Time: 10:56 a.m.
 */

package bns.a6.microui.web.utility.database;

import bns.a6.microui.web.constants.FrameworkConstants;
import bns.a6.microui.web.utility.ReadPropertyFile;
import com.quantum.utility.LoggingUtils;
import org.assertj.core.api.Assertions;
import org.h2.engine.Database;

import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

public class MDMDB implements DataBase {
    private static MDMDB DBINSTANCE = null;
    private static Connection CONNECTION = null;

    private String getConnectionURL() throws Exception {
        String environment = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(),
                        "host");
        if (environment.contains("IMU")) {
            return ReadPropertyFile.getInstance().
                    getPropertyValue(FrameworkConstants.getMdmpropertiesuatfilepath(),
                            FrameworkConstants.getMDMDatabaseFileName(),
                            "connectionURL");
        } else if (environment.contains("IMI")) {
            return ReadPropertyFile.getInstance().
                    getPropertyValue(FrameworkConstants.getMdmpropertiesistfilepath(),
                            FrameworkConstants.getMDMDatabaseFileName(),
                            "connectionURL");
        }


        return ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getMdmpropertiesuatfilepath(),
                        FrameworkConstants.getMDMDatabaseFileName(),
                        "connectionURL");
    }

    private String getPort() throws Exception {
        String port = null;

        String environment = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(),
                        "host");
        if (environment.contains("IMU")) {
            if (environment.equalsIgnoreCase("IMU12")) {
                port = ReadPropertyFile.getInstance().
                        getPropertyValue(FrameworkConstants.getMdmpropertiesuatfilepath(),
                                FrameworkConstants.getMDMDatabaseFileName(),
                                "portUAT12");
            } else if (environment.equalsIgnoreCase("IMU78")) {
                port = ReadPropertyFile.getInstance().
                        getPropertyValue(FrameworkConstants.getMdmpropertiesuatfilepath(),
                                FrameworkConstants.getMDMDatabaseFileName(),
                                "portUAT78");
            }
        } else if (environment.contains("IMI")) {
            if (environment.equalsIgnoreCase("IMI12")) {
                port = ReadPropertyFile.getInstance().
                        getPropertyValue(FrameworkConstants.getMdmpropertiesistfilepath(),
                                FrameworkConstants.getMDMDatabaseFileName(),
                                "portIST12");
            } else if (environment.equalsIgnoreCase("IMI34")) {
                port = ReadPropertyFile.getInstance().
                        getPropertyValue(FrameworkConstants.getMdmpropertiesistfilepath(),
                                FrameworkConstants.getMDMDatabaseFileName(),
                                "portIST34");
            }
        }

        return port;

    }

    private String getSchema() throws Exception {
        String schema = null;
        String environment = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(),
                        "host");
        if (environment.contains("IMU")) {
            schema = ReadPropertyFile.getInstance().
                    getPropertyValue(FrameworkConstants.getMdmpropertiesuatfilepath(),
                            FrameworkConstants.getMDMDatabaseFileName(),
                            "schema");
        } else if (environment.contains("IMI")) {
            schema = ReadPropertyFile.getInstance().
                    getPropertyValue(FrameworkConstants.getMdmpropertiesistfilepath(),
                            FrameworkConstants.getMDMDatabaseFileName(),
                            "schema");
        }
        return schema;
    }

    private String getUserName() throws Exception {
        String userName = null;
        String environment = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(),
                        "host");
        if (environment.contains("IMU")) {
            userName = ReadPropertyFile.getInstance().
                    getPropertyValue(FrameworkConstants.getMdmpropertiesuatfilepath(),
                            FrameworkConstants.getMDMDatabaseFileName(),
                            "userName");
        } else if (environment.contains("IMI")) {
            userName = ReadPropertyFile.getInstance().
                    getPropertyValue(FrameworkConstants.getMdmpropertiesistfilepath(),
                            FrameworkConstants.getMDMDatabaseFileName(),
                            "userName");
        }
        return userName;

    }


    private String getPassword() throws Exception {
        String password = null;

        String environment = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(),
                        "host");
        if (environment.contains("IMU")) {
            password = ReadPropertyFile.getInstance().
                    getPropertyValue(FrameworkConstants.getMdmpropertiesuatfilepath(),
                            FrameworkConstants.getMDMDatabaseFileName(),
                            "password");
        } else if (environment.contains("IMI")) {
            password = ReadPropertyFile.getInstance().
                    getPropertyValue(FrameworkConstants.getMdmpropertiesistfilepath(),
                            FrameworkConstants.getMDMDatabaseFileName(),
                            "password");
        }
        return password;
    }

    private void loadDB2Driver() {
        try {
            Class.forName(FrameworkConstants.getDB2driverpath());
        } catch (ClassNotFoundException e) {
            Assertions.fail("Where is your MySQL JDBC Driver?" + Arrays.toString(e.getStackTrace()));
        }
        LoggingUtils.log("MySQL JDBC Driver Registered!");
    }

    public ResultSet getData(String query) throws Exception {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = MDMDB.getInstance()
                    .getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        } catch (SQLException e) {
            Assertions.fail("Unable to fetch records from test data db" +
                    "for the query:- " + query +
                    "\n Error:- " + e);
        }

        return resultSet;
    }

    //    Connection con = Database.getInstance().getConnection();
    @Override
    public Connection getConnection() throws Exception {
        if (Objects.isNull(CONNECTION)) {
            try {
                String connectionURL = getConnectionURL();
                String schema = getSchema();
                String username = getUserName();
                String password = getPassword();
                String port = getPort();

                loadDB2Driver();
                CONNECTION = DriverManager.getConnection(connectionURL + ":" + port + "/" + schema, username, password);
            } catch (SQLException ex) {
                Assertions.fail("Unable to connect to test data database"
                        + (Database.class.getName()), ex);
            }
        }

        return CONNECTION;
    }

    public static synchronized MDMDB getInstance() {
        if (Objects.isNull(DBINSTANCE)) {
            DBINSTANCE = new MDMDB();
        }
        return DBINSTANCE;
    }
}
