package br.com.caelum.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorAbertuta;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean {

	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	private String nomeMedia;
	
	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getNomeIndicadorBase() {
		return nomeIndicadorBase;
	}

	public void setNomeIndicadorBase(String nomeIndicadorBase) {
		this.nomeIndicadorBase = nomeIndicadorBase;
	}

	private String nomeIndicadorBase;

	public ArgentumBean() {
		this.negociacoes = new ClienteWebService().getNegociacoes();
		geraGrafico();
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}

	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public void setModeloGrafico(ChartModel modeloGrafico) {
		this.modeloGrafico = modeloGrafico;
	}

	public void geraGrafico() {
		System.out.println("Plotando: " + nomeMedia + " de " + nomeIndicadorBase);
		List<Candle> candles = new CandlestickFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		

		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, serie.getUltimaPosicao());
		
		geradorGrafico.plotaIndicador(new IndicadorAbertuta());
		geradorGrafico.plotaIndicador(new IndicadorFechamento());
		
		geradorGrafico.plotaIndicador(new MediaMovelSimples(new IndicadorAbertuta(), 3));
		geradorGrafico.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento(), 3));
		geradorGrafico.plotaIndicador(new MediaMovelPonderada(new IndicadorAbertuta(), 3));
		geradorGrafico.plotaIndicador(new MediaMovelPonderada(new IndicadorFechamento(), 3));

		this.setModeloGrafico(geradorGrafico.getModeloGrafico());
	}
}