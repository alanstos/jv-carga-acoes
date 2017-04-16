package br.com.jv.carga.acoes.model;

import com.opencsv.bean.CsvBindByName;

import br.com.jv.carga.acoes.util.DataUtil;

public class AcaoCsv {

	@CsvBindByName(column = "Acao")
	private String nome;

	@CsvBindByName(column = "Data")
	private String dataFechamento;

	@CsvBindByName(column = "Close")
	private double valorFechamento;

	@CsvBindByName(column = "Volume")
	private double volume;
	
	public Acao parseToAcao(){
		Acao acao = new Acao();
		acao.setNome(this.nome);
		acao.setData( DataUtil.convertStringToDate(this.dataFechamento) );
		acao.setValorFechamento(this.valorFechamento);
		acao.setVolume(this.volume);
		return acao;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getValorFechamento() {
		return valorFechamento;
	}

	public void setValorFechamento(double valorFechamento) {
		this.valorFechamento = valorFechamento;
	}

	@Override
	public String toString() {
		return "AcaoCsv [nome=" + nome + ", dataFechamento=" + dataFechamento + ", valorFechamento=" + valorFechamento
				+ ", volume=" + volume + "]";
	}

}
