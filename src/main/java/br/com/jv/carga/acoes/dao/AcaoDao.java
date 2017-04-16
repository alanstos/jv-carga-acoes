package br.com.jv.carga.acoes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.jv.carga.acoes.config.ConnectionFactory;
import br.com.jv.carga.acoes.model.Acao;

public class AcaoDao {
	
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

		
        PreparedStatement ps;
		try {
			ps = ConnectionFactory.getInstance().prepareStatement(sql);


	        // preenche os valores
	        ps.setString(1, acao.getNome());
	        
	        java.sql.Date dataParaGravar = new java.sql.Date(
	                acao.getData().getTime());
	        ps.setDate(2, dataParaGravar);
	        ps.setDouble(3, acao.getValorFechamento());
	        ps.setDouble(4, acao.getValorAbertura());
	        ps.setDouble(5, acao.getValorRetorno());
	        ps.setDouble(6, acao.getVolume());
	
	        // executa
	        ps.execute();
	        ps.close();
	
	        System.out.println("Gravado!");
	
		} catch (SQLException e) {
			throw new RuntimeException("erro ao adicionar acao",e);
		}
	}
	
	public List<Acao> findFechamentoMaximo(){
		
		String sql = "select ac.* from acao ac inner join"  
			+ " ( select  nome, max(valor_fechamento) as valor from acao  group by nome) x "
			+ " on ac.nome = x.nome and ac.valor_fechamento = x.valor ";
		
		try {
			PreparedStatement ps = ConnectionFactory.getInstance().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Acao> acoes = new ArrayList<Acao>();
			Acao acao;
			while(rs.next()){
				acao = new Acao();
				acao.setNome(rs.getString("nome"));
				Calendar cl = Calendar.getInstance();
				cl.setTime( rs.getDate("data") );
				acao.setData(  cl.getTime() );
				acao.setValorAbertura(rs.getDouble("valor_abertura"));
				acao.setValorFechamento(rs.getDouble("valor_fechamento"));
				acao.setValorRetorno(rs.getDouble("valor_retorno"));
				acao.setVolume(rs.getDouble("volume"));
				acoes.add(acao);
			}
			
			rs.close();
			ps.close();
			
			return acoes;
			
		} catch (Exception e) {
			throw new RuntimeException("erro ao buscar fechamento maximo",e);
		}		
	}
	
	public List<Acao> findFechamentoMinimo() {
		String sql = "select ac.* from acao ac inner join"
				+ " ( select  nome, min(valor_fechamento) as valor from acao  group by nome) x "
				+ " on ac.nome = x.nome and ac.valor_fechamento = x.valor ";

		try {
			PreparedStatement ps = ConnectionFactory.getInstance().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Acao> acoes = new ArrayList<Acao>();
			Acao acao;
			while (rs.next()) {
				acao = new Acao();
				acao.setNome(rs.getString("nome"));
				Calendar cl = Calendar.getInstance();
				cl.setTime(rs.getDate("data"));
				acao.setData(cl.getTime());
				acao.setValorAbertura(rs.getDouble("valor_abertura"));
				acao.setValorFechamento(rs.getDouble("valor_fechamento"));
				acao.setValorRetorno(rs.getDouble("valor_retorno"));
				acao.setVolume(rs.getDouble("volume"));
				acoes.add(acao);
			}

			rs.close();
			ps.close();

			return acoes;

		} catch (Exception e) {
			throw new RuntimeException("erro ao buscar fechamento minimo", e);
		}
	}

}
