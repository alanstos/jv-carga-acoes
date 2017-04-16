package br.com.jv.carga.acoes;

import java.math.BigDecimal;

public class CalculoRetornoService {
	
	public BigDecimal executa(Double fechamento, Double fechamentoAnterior){
		BigDecimal atual = new BigDecimal(fechamento);
		BigDecimal anterior = new BigDecimal(fechamentoAnterior);
		return atual.divide(anterior, BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.ONE);
	}

}
