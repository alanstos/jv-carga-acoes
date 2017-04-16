package br.com.jv.carga.acoes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection;
	
	public Connection getConnection(){
		try {
			//return DriverManager.getConnection("jdbc:mysql://localhost:3306/carga-acoes?useTimezone=true&serverTimezone=UTC",
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/carga-acoes?",		
					"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getInstance(){
		if (connection == null){
			connection = new ConnectionFactory().getConnection();
		}
		
		return connection;
	}

}
