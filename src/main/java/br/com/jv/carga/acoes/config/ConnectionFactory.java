package br.com.jv.carga.acoes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/carga-acoes?useTimezone=true&serverTimezone=UTC",
					
					"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
