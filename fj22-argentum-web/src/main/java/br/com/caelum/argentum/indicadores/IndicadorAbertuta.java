package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorAbertuta implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getAbertura();
	}

	public String toString() {
		return "Abertura";
	}

	@Override
	public int getTamanhoIndicador() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
