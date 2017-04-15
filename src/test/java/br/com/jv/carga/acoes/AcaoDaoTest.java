package br.com.jv.carga.acoes;

import java.util.Date;

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
	public void insereTest(){
		acaoDao.insere(getNovaAcao());
		
		Assert.assertTrue(true);
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
