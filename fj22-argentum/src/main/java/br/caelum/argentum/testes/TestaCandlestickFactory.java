package br.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import br.caelum.argentum.modelo.CadlestickFactory;
import br.caelum.argentum.modelo.Candlestick;
import br.caelum.argentum.modelo.Nogociacao;

public class TestaCandlestickFactory {
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();

		Nogociacao negociacao1 = new Nogociacao(40.5, 100, hoje);
		Nogociacao negociacao2 = new Nogociacao(45.0, 100, hoje);
		Nogociacao negociacao3 = new Nogociacao(39.8, 100, hoje);
		Nogociacao negociacao4 = new Nogociacao(42.3, 100, hoje);
		Nogociacao negociacao5 = new Nogociacao(45.0, 100, hoje);
		Nogociacao negociacao6 = new Nogociacao(49.8, 100, hoje);
		Nogociacao negociacao7 = new Nogociacao(53.3, 100, hoje);

		List<Nogociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4, negociacao5, negociacao6, negociacao7);
		CadlestickFactory fabrica = new CadlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		System.out.println("Abertura: 	" + candle.getAbertura());
		System.out.println("Fechamento: 	" + candle.getFechamento());
		System.out.println("Minimo :	" + candle.getMinimo());
		System.out.println("Maximo: 	" + candle.getMaximo());
		System.out.println("Volume: 	" + candle.getVolume());
	}
}