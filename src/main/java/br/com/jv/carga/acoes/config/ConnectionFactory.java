package br.com.jv.carga.acoes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection;
	
	private Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/carga-acoes?", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException("erro ao tentar conectar ao banco", e);
		}
	}
	
	public static Connection getInstance(){
		if (connection == null){
			connection = new ConnectionFactory().getConnection();
		}
		
		return connection;
	}

}
