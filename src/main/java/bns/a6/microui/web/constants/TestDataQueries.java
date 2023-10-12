/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-12
 * Created Time: 10:40 a.m.
 */

package bns.a6.microui.web.constants;

import bns.a6.microui.web.utility.ReadPropertyFile;
import org.assertj.core.api.Assertions;

import java.util.Objects;

public final class TestDataQueries {

    private TestDataQueries() {

    }

    private static TestDataQueries INSTANCE = null;
    private static final String LOGIN = "logindetails";
    private static final String CUSTOMERTOACCOUNTRELATIONSHIPRULES = "cuacRules";
    private static final String NONPERSONAL = "nonpersonal";
    private static final String PERSONAL = "personal";
    private static final String INVOLVEDPARTY = "involvedparty";
    private static final String DAYTODAYBANKING = "daytodaybanking";
    private static final String BUSINESSACCOUNTWITHOUTCREDITBUREAU = "businessAccountWithOutCreditBureau";
    private static final String SCOTIACARD = "scotiacard";
    private static final String FATCA = "fatca";
    private static final String CUSTOMERTOACCOUNTRELATIONSHIP = "customertoaccountrelationship";
    private static final String PREFERENCES = "preferences";
    private static final String ACCOUNTLOCATE = "accountlocate";
    private static final String TORE = "tore";
    private static final String ACCESSBYACCOUNTNUMBER = "accessbyaccountNumber";

    //    API's
    private static final String PERSONAL_API = "personal_api";
    private static final String NONPERSONAL_API = "non_personal_api";
    private static final String IDENTIFICATIONS_API = "identifications_api";
    private static final String EMPLOYMENT_API = "employment_api";
    private static final String CUSTOMERSEARCH_API = "customersearch_api";
    private static final String CUSTOMERLOOKUP_API = "customerlookup_api";
    private static final String ACCOUNTPROFILE_API = "accountprofile_api";
    private static final String CUSTOMERTOACCOUNTRELATIONSHIP_API = "customertoaccountrelationship_api";
    private static final String COUNTRYREFERENCE_API = "countryreference_api";
    private String getSchema() throws Exception {
        return ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getTestPropertiesFilePath(),
                        FrameworkConstants.getTestDataDatabaseFileName(),
                        "schema");
    }

    public String getLogin(String env) throws Exception {
        String query = null;
        if (env.contains("UAT")) {
            query = "SELECT * FROM " + getSchema() + "." + LOGIN +
                    " WHERE Environment = 'UAT'";
        } else if (env.contains("IST")) {
            query = "SELECT * FROM " + getSchema() + "." + LOGIN +
                    " WHERE Environment = 'IST'";
        } else {
            Assertions.fail("Environment is not correct and it is mentioned in property file as " +
                    env);
        }
        return query;
    }


    public static String getTableData(String tableName, String scenarioId) throws Exception {
        String query = null;
        String host = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(), "host");
        query = "SELECT * FROM " + tableName + " WHERE ScenarioID = '" + scenarioId + "' AND HOST='" + host + "'";
        return query;
    }


    // Update queries
    public String updateTable(String table, String scenarioId, String columnName, String columnValue) throws Exception {
        String query = null;
        String host = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(), "host");
        query = "UPDATE " + table + " SET " + columnName + " = '" + columnValue + "'  WHERE ScenarioID = '" + scenarioId + "'" +
                " AND HOST = '" + host + "' ";
        return query;
    }

    public String updateNonPersonal(String scenarioId, String columnName, String columnValue) throws Exception {
        String query = null;
        String host = ReadPropertyFile.getInstance().
                getPropertyValue(FrameworkConstants.getProjectresourcespath(),
                        FrameworkConstants.getApplicationproperties(), "host");
        query = "UPDATE " + NONPERSONAL + " SET " + columnName + " = '" + columnValue + "' WHERE ScenarioID = '" + scenarioId + "'" +
                " AND HOST = '" + host + "' ";
        return query;
    }


    public String getTableName(String table, String sceanrioId) throws Exception {
        String databaseTableName = null;
        if (table.equalsIgnoreCase("LOGIN")) {
            databaseTableName = getLogin(sceanrioId);
        } else if (table.equalsIgnoreCase("CUACRULES")) {
            databaseTableName = getTableData(CUSTOMERTOACCOUNTRELATIONSHIPRULES, sceanrioId);
        } else if (table.equalsIgnoreCase("NONPERSONAL")) {
            databaseTableName = getTableData(NONPERSONAL, sceanrioId);
        } else if (table.equalsIgnoreCase("PERSONAL")) {
            databaseTableName = getTableData(PERSONAL, sceanrioId);
        } else if (table.equalsIgnoreCase("INVOLVEDPARTY")) {
            databaseTableName = getTableData(INVOLVEDPARTY, sceanrioId);
        } else if (table.equalsIgnoreCase("DAYTODAYBANKING")) {
            databaseTableName = getTableData(DAYTODAYBANKING, sceanrioId);
        } else if (table.equalsIgnoreCase("BUSINESSACCOUNTWITHOUTCREDITBUREAU")) {
            databaseTableName = getTableData(BUSINESSACCOUNTWITHOUTCREDITBUREAU, sceanrioId);
        } else if (table.equalsIgnoreCase("SCOTIACARD")) {
            databaseTableName = getTableData(SCOTIACARD, sceanrioId);
        } else if (table.equalsIgnoreCase("FATCA")) {
            databaseTableName = getTableData(FATCA, sceanrioId);
        } else if (table.equalsIgnoreCase("CUSTOMERTOACCOUNTRELATIONSHIP")) {
            databaseTableName = getTableData(CUSTOMERTOACCOUNTRELATIONSHIP, sceanrioId);
        } else if (table.equalsIgnoreCase("PREFERENCES")) {
            databaseTableName = getTableData(PREFERENCES, sceanrioId);
        } else if (table.equalsIgnoreCase("ACCOUNTLOCATE")) {
            databaseTableName = getTableData(ACCOUNTLOCATE, sceanrioId);
        } else if (table.equalsIgnoreCase("ACCESSBYACCOUNTNUMBER")) {
            databaseTableName = getTableData(ACCESSBYACCOUNTNUMBER, sceanrioId);
        } else if (table.equalsIgnoreCase("TORE")) {
            databaseTableName = getTableData(TORE, sceanrioId);
        }

//        API's tables
        else if (table.equalsIgnoreCase("PERSONAL_API")) {
            databaseTableName = getTableData(PERSONAL_API, sceanrioId);
        } else if (table.equalsIgnoreCase("IDENTIFICATIONS_API")) {
            databaseTableName = getTableData(IDENTIFICATIONS_API, sceanrioId);
        }else if (table.equalsIgnoreCase("EMPLOYMENT_API")) {
            databaseTableName = getTableData(EMPLOYMENT_API, sceanrioId);
        } else if (table.equalsIgnoreCase("NON_PERSONAL_API")) {
            databaseTableName = getTableData(NONPERSONAL_API, sceanrioId);
        } else if (table.equalsIgnoreCase("CUSTOMERSEARCH_API")) {
            databaseTableName = getTableData(CUSTOMERSEARCH_API, sceanrioId);
        } else if (table.equalsIgnoreCase("CUSTOMERTOACCOUNTRELATIONSHIP_API")) {
            databaseTableName = getTableData(CUSTOMERTOACCOUNTRELATIONSHIP_API, sceanrioId);
        } else if (table.equalsIgnoreCase("CUSTOMERLOOKUP_API")) {
            databaseTableName = getTableData(CUSTOMERLOOKUP_API, sceanrioId);
        } else if (table.equalsIgnoreCase("COUNTRYCODEREFERENCE_API")) {
            databaseTableName = getTableData(COUNTRYREFERENCE_API, sceanrioId);
        } else if (table.equalsIgnoreCase("ACCOUNTPROFILE_API")) {
            databaseTableName = getTableData(ACCOUNTPROFILE_API, sceanrioId);
        }

        return databaseTableName;
    }


    public static synchronized TestDataQueries getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new TestDataQueries();
        }
        return INSTANCE;
    }

}
