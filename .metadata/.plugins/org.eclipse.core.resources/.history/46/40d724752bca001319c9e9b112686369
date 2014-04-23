package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.caelum.argentum.modelo.CadlestickFactory;
import br.caelum.argentum.modelo.Candlestick;
import br.caelum.argentum.modelo.Nogociacao;

public class CandlestickFactoryTest {
	@Test
	public void sequenciaSimplesDeNegociacoes() {
		Calendar hoje = Calendar.getInstance();
		Nogociacao negociacao1 = new Nogociacao(40.5, 100, hoje);
		Nogociacao negociacao2 = new Nogociacao(45.0, 100, hoje);
		Nogociacao negociacao3 = new Nogociacao(39.8, 100, hoje);
		Nogociacao negociacao4 = new Nogociacao(42.3, 100, hoje);
		List<Nogociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4);
		CadlestickFactory fabrica = new CadlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void semNegociacoesGeraCandleComZeros() {
		Calendar hoje = Calendar.getInstance();
		List<Nogociacao> negociacoes = Arrays.asList();
		CadlestickFactory fabrica = new CadlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
		//Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
	}

	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();
		Nogociacao negociacao1 = new Nogociacao(40.5, 100, hoje);
		List<Nogociacao> negociacoes = Arrays.asList(negociacao1);
		CadlestickFactory fabrica = new CadlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void paraNegociacoesDeTresDiasDistintosGeraTresCandles() {
		Calendar hoje = Calendar.getInstance();
		Nogociacao negociacao1 = new Nogociacao(40.5, 100, hoje);
		Nogociacao negociacao2 = new Nogociacao(40.5, 100, hoje);
		Nogociacao negociacao3 = new Nogociacao(40.5, 100, hoje);
		Nogociacao negociacao4 = new Nogociacao(40.5, 100, hoje);

		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Nogociacao negociacao5 = new Nogociacao(48.8, 100, amanha);
		Nogociacao negociacao6 = new Nogociacao(49.3, 100, amanha);

		Calendar depois = (Calendar) amanha.clone();
		depois.add(Calendar.DAY_OF_MONTH, 1);

		Nogociacao negociacao7 = new Nogociacao(51.8, 100, depois);
		Nogociacao negociacao8 = new Nogociacao(52.3, 100, depois);
		
		List<Nogociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4, negociacao5, negociacao6,
				negociacao7, negociacao8);
		
		CadlestickFactory fabrica = new CadlestickFactory();
		
		List<Candlestick> candles = fabrica.constroiCandles(negociacoes);
		
		Assert.assertEquals(3, candles.size());
		Assert.assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
		//Assert.assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
		Assert.assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
		Assert.assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
		Assert.assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
		Assert.assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
	}

}