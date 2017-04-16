package br.com.jv.carga.acoes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import br.com.jv.carga.acoes.model.AcaoCsv;

public class ReadCsvService {
	
	public List<AcaoCsv> readCsv() {
		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader("acoes.csv"));

			HeaderColumnNameMappingStrategy<AcaoCsv> strategy = new HeaderColumnNameMappingStrategy<AcaoCsv>();
			strategy.setType(AcaoCsv.class);
			CsvToBean<AcaoCsv> csvToBean = new CsvToBean<AcaoCsv>();
			List<AcaoCsv> list = csvToBean.parse(strategy, reader);
			return list;
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
	}	

}
