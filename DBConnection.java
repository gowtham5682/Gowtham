package com.hexaware.persistence;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.logging.PrintStreamLog;;

public class DBConnection {
    /**
     * Connecting to MYSQL DB.
     * 
     * @return database Connection.
     */
    public final DBI getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbc = System.getenv("DB_CONNECTION");
            if (dbc == null || dbc.equals("")) {
                dbc = "localhost:3306";
            }
            DBI dbi = new DBI("jdbc:mysql://" + dbc + "/carsDemo", "root", "Password123");
            dbi.setSQLLog(new PrintStreamLog());
            return dbi;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}