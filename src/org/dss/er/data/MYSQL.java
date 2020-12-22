package org.dss.er.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MYSQL {

	static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    static Connection conn = null;
    static String username = "root";
    static String password = "";
    static String serverUrl = "jdbc:mysql://localhost:3306/?useUnicode=true&amp;amp;amp;useJDBCCompliantTimezoneShift=true&amp;amp;amp;useLegacyDatetimeCode=false&amp;amp;amp;serverTimezone=UTC";
    static Statement stmt = null;
    static String dbName = "essentials-reload";
    static String checkDb = "SHOW DATABASES";
    static ResultSet rs = null;
    boolean dbFound = false;
	
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
            	System.out.println("All is fine, database exist");
            	return;
            } else {
            	try {
	            	stmt = conn.createStatement();
	                String sql = "CREATE DATABASE `" + dbName + "`";
	                stmt.executeUpdate(sql);
	                System.out.println("Database created");
            	} catch (SQLException e) {
            		e.printStackTrace();
            	}
            }
        } catch (SQLException ex) {
        	System.out.println("Error " + ex.getMessage());
        }
	    return;
	}
}
