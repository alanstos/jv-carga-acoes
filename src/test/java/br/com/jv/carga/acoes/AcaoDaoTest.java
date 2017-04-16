package br.com.jv.carga.acoes;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.jv.carga.acoes.dao.AcaoDao;
import br.com.jv.carga.acoes.model.Acao;
import junit.framework.Assert;

public class AcaoDaoTest {
	
	private AcaoDao acaoDao;

	public AcaoDaoTest() {
		acaoDao = new AcaoDao();
	}

	@Test
	@Ignore
	public void insereTest(){
		acaoDao.insere(getNovaAcao());
		
		Assert.assertTrue(true);
		
	}
	
	@Test
	@Ignore
	public void maxFechamentoTest(){
		System.out.println("valor maximo");
		List<Acao> fechamentoMaximo = acaoDao.findFechamentoMaximo();
		
		for (Acao acao : fechamentoMaximo) {
			System.out.println(acao);
		}
	}
	
	@Test
	//@Ignore
	public void minFechamentoTest(){
		System.out.println("valor minimo");
		
		List<Acao> fechamentoMin = acaoDao.findFechamentoMinimo();
		
		for (Acao acao : fechamentoMin) {
			System.out.println(acao);
		}
	}	
	
	private Acao getNovaAcao(){
		Acao acao = new Acao();
		acao.setNome("ABCX");
		acao.setData(new Date());
		acao.setValorAbertura(100.0);
		acao.setValorFechamento(100.0);
		acao.setValorRetorno(1.0);
		acao.setVolume(1000.1);
		return acao;
	}

}
