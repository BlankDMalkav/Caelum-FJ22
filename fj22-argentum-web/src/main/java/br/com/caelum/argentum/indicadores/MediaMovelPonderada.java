package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {
	
	private int tamanhoIndicador;
	private Indicador outroIndicador;

	public MediaMovelPonderada(Indicador outroIndicador, int tamanhoIndicador) {
		this.outroIndicador = outroIndicador;
		this.tamanhoIndicador = tamanhoIndicador;
	}

	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		int peso = 3;
		for (int i = posicao; i > posicao - 3; i--) {
			Candle c = serie.getCandle(i);
			soma += outroIndicador.calcula(i, serie);
			peso--;
		}
		return soma / 6;
	}

	public String toString() {
		return "MMP";
	}

	@Override
	public int getTamanhoIndicador() {
		// TODO Auto-generated method stub
		return this.tamanhoIndicador;
	}
}
