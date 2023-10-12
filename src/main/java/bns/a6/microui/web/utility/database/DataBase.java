/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-11
 * Created Time: 1:55 p.m.
 */

package bns.a6.microui.web.utility.database;

import java.sql.Connection;

public interface DataBase {

    Connection getConnection() throws Exception;


}

