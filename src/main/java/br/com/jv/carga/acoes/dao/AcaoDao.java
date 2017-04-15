package br.com.jv.carga.acoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.jv.carga.acoes.config.ConnectionFactory;
import br.com.jv.carga.acoes.model.Acao;

public class AcaoDao {
	
	private Connection con;
	
	public AcaoDao() {
		con = new ConnectionFactory().getConnection();
	}
	
	public void insere(Acao acao) {
		String sql = "INSERT INTO acao " +
						 " ( " +
						 " nome," +
						 " data," +
						 " valor_fechamento," +
						 " valor_abertura," +
						 " valor_retorno," +
						 " volume)" +
						 " VALUES" +
						 " ( " +
						 " ?," +
						 " ?," +
						 " ?," +
						 " ?," +
						 " ?," +
						 " ?);";

		
        PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);


	        // preenche os valores
	        stmt.setString(1, acao.getNome());
	        
	        java.sql.Date dataParaGravar = new java.sql.Date(
	                acao.getData().getTime());
	        stmt.setDate(2, dataParaGravar);
	        stmt.setDouble(3, acao.getValorFechamento());
	        stmt.setDouble(4, acao.getValorAbertura());
	        stmt.setDouble(5, acao.getValorRetorno());
	        stmt.setDouble(6, acao.getVolume());
	
	        // executa
	        stmt.execute();
	        stmt.close();
	
	        System.out.println("Gravado!");
	
	        con.close();
        
		} catch (SQLException e) {
			throw new RuntimeException("erro ao adicionar acao",e);
		}
	}

}
