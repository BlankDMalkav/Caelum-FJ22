package br.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import br.caelum.argentum.modelo.CadlestickFactory;
import br.caelum.argentum.modelo.Candlestick;
import br.caelum.argentum.modelo.Nogociacao;

public class TestaCandlestickFactorySemNegociacoes {

	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		List<Nogociacao> negociacoes = Arrays.asList();
		CadlestickFactory fabrica = new CadlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println("Abertura: 	" + candle.getAbertura());
		System.out.println("Fechamento: 	" + candle.getFechamento());
		System.out.println("Minimo :	" + candle.getMinimo());
		System.out.println("Maximo: 	" + candle.getMaximo());
		System.out.println("Volume: 	" + candle.getVolume());
	}
}