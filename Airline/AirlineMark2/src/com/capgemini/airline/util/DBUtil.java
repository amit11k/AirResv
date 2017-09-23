package com.capgemini.airline.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.airline.exception.AirlineException;

public class DBUtil {
static Connection connection = null;
	
	public static Connection getDatabaseConnection() throws AirlineException{
		try{
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
		}catch(SQLException e){
			throw new AirlineException("Not able to connect to database");
		}
		return connection;
}
}