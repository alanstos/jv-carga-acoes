package br.com.jv.carga.acoes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import br.com.jv.carga.acoes.dao.AcaoDao;
import br.com.jv.carga.acoes.model.Acao;
import br.com.jv.carga.acoes.model.AcaoCsv;

public class CargaService {
	
	private AcaoDao dao = new AcaoDao();

	public static void main(String[] args) throws IOException {
		new CargaService().readCsv();
	}

	public void readCsv() throws FileNotFoundException {
		CSVReader reader = new CSVReader(new FileReader("acoes.csv"));
		HeaderColumnNameMappingStrategy<AcaoCsv> strategy = new HeaderColumnNameMappingStrategy<AcaoCsv>();
		strategy.setType(AcaoCsv.class);
		CsvToBean<AcaoCsv> csvToBean = new CsvToBean<AcaoCsv>();
		List<AcaoCsv> list = csvToBean.parse(strategy, reader);

		CalculoRetornoService retorno = new CalculoRetornoService();
		for (int i = 0 ; i < list.size() ; i++) {
			AcaoCsv csv = list.get(i);
			//System.out.println(csv);
			
			Acao acao = csv.parseToAcao();
			
			AcaoCsv csvAnterior = (i == 0 ? null : list.get( i- 1 ));
			
			double fechamentoAnterior = fechamentoAnteriorAcao(csv, csvAnterior);			
			
			acao.setValorAbertura(fechamentoAnterior);
			acao.setValorRetorno( retorno.executa(acao.getValorFechamento(), acao.getValorAbertura()).doubleValue() );
			System.out.println(acao);
			
			dao.insere(acao);
		}
		
		System.out.println("carga realizada com sucesso");
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
}
