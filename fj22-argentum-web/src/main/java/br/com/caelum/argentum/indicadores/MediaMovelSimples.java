package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private int tamanhoIndicador;
	private Indicador outroIndicador;

	public MediaMovelSimples(Indicador outroIndicador, int tamanhoIndicador) {
		this.outroIndicador = outroIndicador;
		this.tamanhoIndicador = tamanhoIndicador;
	}

	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao; i > posicao - 3; i--) {
			soma += outroIndicador.calcula(i, serie);
		}
		return soma / 3;
	}

	public String toString() {
		return "MMS";
	}

	@Override
	public int getTamanhoIndicador() {
		return this.tamanhoIndicador;
	}

}