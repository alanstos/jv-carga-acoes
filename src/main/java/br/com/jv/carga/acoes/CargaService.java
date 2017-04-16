package br.com.jv.carga.acoes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.jv.carga.acoes.dao.AcaoDao;
import br.com.jv.carga.acoes.model.Acao;
import br.com.jv.carga.acoes.model.AcaoCsv;

public class CargaService {
	
	private AcaoDao dao = new AcaoDao();

	public static void main(String[] args) throws IOException {
		new CargaService().carga();
	}

	public void carga() throws FileNotFoundException {
		
		List<AcaoCsv> acoesCsv = new ReadCsvService().readCsv();

		CalculoRetornoService retorno = new CalculoRetornoService();
		for (int i = 0 ; i < acoesCsv.size() ; i++) {
			AcaoCsv csv = acoesCsv.get(i);
			
			Acao acao = csv.parseToAcao();
			
			AcaoCsv csvAnterior = (i == 0 ? null : acoesCsv.get( i- 1 ));
			
			double fechamentoAnterior = fechamentoAnteriorAcao(csv, csvAnterior);			
			
			acao.setValorAbertura(fechamentoAnterior);
			acao.setValorRetorno( retorno.executa(acao.getValorFechamento(), acao.getValorAbertura()).doubleValue() );
			System.out.println(acao);
			
			dao.insere(acao);
		}
		
		System.out.println("carga realizada com sucesso");
		
		imprimirResultado();
	}
	


	private double fechamentoAnteriorAcao(AcaoCsv csv, AcaoCsv csvAnterior) {
		double fechamentoAnterior = 0;
		if (csvAnterior != null && csvAnterior.getNome().equals(csv.getNome())){
			fechamentoAnterior = csvAnterior.getValorFechamento();
		}else{
			fechamentoAnterior = csv.getValorFechamento();
		}
		return fechamentoAnterior;
	}
	
	private void imprimirResultado(){
		
		imprime( dao.findFechamentoMaximo(), "fechamento maximo" );
		
		imprime( dao.findFechamentoMinimo(), "fechamento minimo" );
		
		imprime( dao.findRetornoMaximo(), "retorno maximo" );
		
		imprime( dao.findRetornoMinimo(), "retorno minimo" );
		
		imprime( dao.findVolumeMedio(), "volume medio" );
		
	}
	
	private void imprime(List<Acao> valores, String titulo){
		System.out.println(titulo);
		
		for (Acao acao : valores) {
			System.out.println(acao);
		}
	}
}
