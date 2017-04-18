package br.com.jv.carga.acoes.main;

import br.com.jv.carga.acoes.service.CargaService;

public class Main {
	
	public static void main(String[] args) {
		try {
			System.out.println("iniciando");
			new CargaService().carga();
		} catch (Exception e) {
			System.out.println("Erro ao realizar carga do csv: " + e.getMessage());
		}
	}



}
