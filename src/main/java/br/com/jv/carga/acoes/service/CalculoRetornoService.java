package br.com.jv.carga.acoes.service;

import java.math.BigDecimal;

public class CalculoRetornoService {
	
	public BigDecimal calcula(Double fechamento, Double fechamentoAnterior){
		BigDecimal atual = new BigDecimal(fechamento);
		BigDecimal anterior = new BigDecimal(fechamentoAnterior);
		return atual.divide(anterior, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.ONE);
	}

}
