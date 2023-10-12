/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-11
 * Created Time: 2:11 p.m.
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

public class TestDataDB implements DataBase {

    private static TestDataDB DBINSTANCE = null;
    private static Connection CONNECTION = null;

    private String getConnectionURL() throws Exception {
        return ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getTestPropertiesFilePath(),
                        FrameworkConstants.getTestDataDatabaseFileName(),
                        "connectionURL");
    }

    private String getSchema() throws Exception {
        return ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getTestPropertiesFilePath(),
                        FrameworkConstants.getTestDataDatabaseFileName(),
                        "schema");
    }


    private String getUserName() throws Exception {
        return ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getTestPropertiesFilePath(),
                        FrameworkConstants.getTestDataDatabaseFileName(),
                        "userName");
    }


    private String getPassword() throws Exception {
        return ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getTestPropertiesFilePath(),
                        FrameworkConstants.getTestDataDatabaseFileName(),
                        "password");
    }

    private void loadSQLDriver() {
        try {
            Class.forName(FrameworkConstants.getMysqldriverpath());
        } catch (ClassNotFoundException e) {
            Assertions.fail("Where is your MySQL JDBC Driver?" + Arrays.toString(e.getStackTrace()));
        }
        LoggingUtils.log("MySQL JDBC Driver Registered!");
    }

    public ResultSet getData(String query) throws Exception {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = TestDataDB.getInstance()
                    .getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        } catch (SQLException e) {
            Assertions.fail("Unable to fetch records from test data db" +
                    "for the query:- " + query +
                    "\n Error:- " + e);
        }

        return resultSet;
    }

    public void updateData(String query) throws Exception {
        try {
            Statement statement = TestDataDB.getInstance()
                    .getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
/*
            Assertions.fail("Unable to update record into test data db" +
                    "for the query:- " + query +
                    "\n Error:- " + e);
*/
        }
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

                loadSQLDriver();
                CONNECTION = DriverManager.getConnection(connectionURL + "/" + schema, username, password);
            } catch (SQLException ex) {
                Assertions.fail("Unable to connect to test data database"
                        + (Database.class.getName()), ex);
            }
        }

        return CONNECTION;
    }

    public static synchronized TestDataDB getInstance() {
        if (Objects.isNull(DBINSTANCE)) {
            DBINSTANCE = new TestDataDB();
        }
        return DBINSTANCE;
    }

}
