package org.dss.er.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MYSQL {
	// TODO Teammate table (id ai int not null prim, uuid1, uuid2, (both varchars(30000) friendly fire used (int just 4fun) 
	public static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    public static Connection conn = null;
    public static String username = "root";
    public static String password = "";
    public static String serverUrl = "jdbc:mysql://localhost:3306/?useUnicode=true&amp;amp;amp;useJDBCCompliantTimezoneShift=true&amp;amp;amp;useLegacyDatetimeCode=false&amp;amp;amp;serverTimezone=UTC";
    public static Statement stmt = null;
    public static String dbName = "essentials-reload";
    public static String checkDb = "SHOW DATABASES";
    public static ResultSet rs = null;
    public boolean dbFound = false;
	private static String CREATE_HOME_TABLE = "CREATE TABLE IF NOT EXISTS `homes` ("
			+ "	`id` INT NOT NULL,"
			+ "	`worldname` MEDIUMTEXT NOT NULL,"
			+ "	`x` INT NOT NULL,"
			+ "	`y` INT NOT NULL,"
			+ "	`z` INT NOT NULL,"
			+ "	`name` MEDIUMTEXT NOT NULL,"
			+ "	`used` INT NOT NULL,"
			+ "	UNIQUE KEY `id` (`id`) USING BTREE,"
			+ "	PRIMARY KEY (`id`)"
			+ ");";
	private static String CREATE_TEAMMATES_TABLE = "CREATE TABLE IF NOT EXISTS `teammates` (`id` INT NOT NULL AUTO_INCREMENT, `uuid1` MEDIUMTEXT NOT NULL, `uuid2` MEDIUMTEXT NOT NULL, `ffused` INT NOT NULL, UNIQUE KEY `id` (`id`) USING BTREE, PRIMARY KEY (`id`));";
    
	public static void onInit() {
		try {
			Class.forName(jdbcDriver);
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Failed To Load");
            System.out.println(ex.getMessage());
        }
 
        try {
            //connecting to xampp server (Apache Server)
            conn = DriverManager.getConnection(serverUrl, username, password);
            System.out.println("Connected To Server Successfully");
        } catch (SQLException ex) {
            System.out.println("Failed To Connect To Server Successfully");
            System.out.println(ex.getMessage());
        }
        try {
        	stmt = conn.createStatement();
            if (stmt.execute("SHOW DATABASES;")) {
                rs = stmt.getResultSet();
            } else {
            	System.out.println("There was an error trying to get list o databases");
            }
            List<String> chujnia =  new ArrayList<String>();
            while (rs.next()) {
                System.out.println(rs.getString("Database"));
                chujnia.add(rs.getString("Database"));
            }
            if(chujnia.contains(dbName)) {
            	System.out.println("All is fine, database exists");
            } else {
            	try {
	            	stmt = conn.createStatement();
	                String sql = "CREATE DATABASE IF NOT EXIST `" + dbName + "`";
	                stmt.execute(sql);
	                System.out.println("Database created");
            	} catch (SQLException e) {
            		e.printStackTrace();
            	}
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, username, password);
            stmt = conn.createStatement();
            stmt.execute(CREATE_HOME_TABLE);
            System.out.println("Homes table created");
            stmt = conn.createStatement();
            stmt.execute(CREATE_TEAMMATES_TABLE);
            System.out.println("Teammates table created");
            conn.close();
        } catch (SQLException ex) {
        	System.out.println("Error " + ex.getMessage());
        }
	    return;
	}
}
