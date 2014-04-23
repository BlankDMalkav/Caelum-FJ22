package br.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CadlestickFactory {
	public Candlestick constroiCandleParaData(Calendar data,
			List<Nogociacao> negociacoes) {
		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;

		for (Nogociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			}
			if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco();
		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);
	}

	public List<Candlestick> constroiCandles(List<Nogociacao> todasNegociacoes) {

		List<Candlestick> candles = new ArrayList<Candlestick>();
		List<Nogociacao> negociacoesDoDia = new ArrayList<Nogociacao>();
		Calendar dataAtual = todasNegociacoes.get(0).getData();

		for (Nogociacao negociacao : todasNegociacoes) {
			if (!negociacao.isMesmoDia(dataAtual)) {
				Candlestick candleDoDia = constroiCandleParaData(dataAtual,
						negociacoesDoDia);
				candles.add(candleDoDia);
				negociacoesDoDia = new ArrayList<Nogociacao>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}

		Candlestick candleDoDia = constroiCandleParaData(dataAtual,
				negociacoesDoDia);
		candles.add(candleDoDia);
		return candles;
	}
}