package com.cg.airline.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	public static Connection conn;
	public static InitialContext ic;
	public static Connection makeconnection(){
		try{
			ic=new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/OracleDSnew");
			conn = ds.getConnection();
		}
		catch(NamingException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
}
