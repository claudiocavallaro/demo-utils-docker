package com.example.testdb.demodb.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.example.testdb.demodb.utils.PropertyService;
import com.example.testdb.demodb.utils.Utils;



public class DBManager {
	
	private final static String DB_ENV = "dbEnv";
	
	public static Connection createConnection() throws SQLException{
		final PropertyService propertyService = Utils.getProperty();
		final String dbEnv = System.getProperty(DB_ENV);
		final Properties props = new Properties();
		String url = null, user = null, password = null;
		if (dbEnv == null) {
			url = propertyService.getUrl();
			user = propertyService.getUser();
			password = propertyService.getPassword();
		} else if (dbEnv.equals("docker")) {
			url = propertyService.getUrlDocker();
			user = propertyService.getUserDocker();
			password = propertyService.getPasswordDocker();
		}
		
		props.setProperty("user", user);
		props.setProperty("password", password);
		
		Connection conn = DriverManager.getConnection(url, props);

		return conn;
	}

}
