package br.caelum.argentum.reader;

import java.io.InputStream;
import java.util.List;

import br.caelum.argentum.modelo.Nogociacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LeitorXML {
	public List<Nogociacao> carrega(InputStream inputStream) {
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Nogociacao.class);
		return (List<Nogociacao>) stream.fromXML(inputStream);
	}
}
