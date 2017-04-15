package br.com.jv.carga.acoes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import br.com.jv.carga.acoes.model.Acao;

public class CargaService {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new CargaService().readParseColuns();
	}

	public void read() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("acoes.csv"));
		List<String[]> myEntries = reader.readAll();

		for (String[] o : myEntries) {
			System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3]);
		}

	}

	public void readParse() throws FileNotFoundException {
		CSVReader reader = new CSVReader(new FileReader("acoes.csv"));
		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(Acao.class);
		String[] columns = new String[] { "nome", "dataFechamento", "valor", "volume" }; // the
																				
		strat.setColumnMapping(columns);

		CsvToBean csv = new CsvToBean();
		List<Acao> list = csv.parse(strat, reader);

		for (Acao acao : list) {
			System.out.println(acao);
		}
	}

	public void readParseColuns() throws FileNotFoundException {
		CSVReader reader = new CSVReader(new FileReader("acoes.csv"));
		HeaderColumnNameMappingStrategy<Acao> strategy = new HeaderColumnNameMappingStrategy<Acao>();
		strategy.setType(Acao.class);
		CsvToBean<Acao> csvToBean = new CsvToBean<Acao>();
		List<Acao> list = csvToBean.parse(strategy, reader);
		
		for (Acao acao : list) {
			System.out.println(acao);
		}
	}
}
