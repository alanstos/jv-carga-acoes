package br.com.jv.carga.acoes.model;

import java.util.Date;

import br.com.jv.carga.acoes.util.DataUtil;

public class Acao {

	private String nome;

	private double valorFechamento;

	private double volume;
	
	private double valorAbertura;
	
	private double valorRetorno;
	
	private Date data;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public double getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(double valorAbertura) {
		this.valorAbertura = valorAbertura;
	}

	public double getValorRetorno() {
		return valorRetorno;
	}

	public void setValorRetorno(double valorRetorno) {
		this.valorRetorno = valorRetorno;
	}
	
	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Acao [nome=" + nome + ", valorFechamento=" + valorFechamento + ", volume=" + volume + ", valorAbertura="
				+ valorAbertura + ", valorRetorno=" + valorRetorno + ", data=" + DataUtil.convertDateToString(data) + "]";
	}



}
