package database;

import config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.exit;

/**
 * The type Connection database.
 */
class ConnectionDatabase {
    private Settings set;
    private static final String JDBC_URL = "jdbc:sqlite:/home/marcus/user_db";

    protected ConnectionDatabase(){
        set = new Settings();
    }

    /**
     * Connection  connect into database
     * @return the connection
     */
    protected Connection connection(){
        try{
            return DriverManager.getConnection(JDBC_URL);
        }
        catch (SQLException e){
            Config.log(e.toString(), "danger");
            exit(-1);
            return null;
        }
    }
}