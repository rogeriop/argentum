package br.com.alura.argentum.indicadores;

import br.com.alura.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {
	private Indicador outroIndicador;

	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0;
		
		for (int i = posicao; i > posicao - 3; i--) {
			soma += outroIndicador.calcula(i, serie);
		}
		
		return soma / 3;
	}
	
	public String toString() {
		return "MMS " + this.outroIndicador.toString();
	}
	

}
