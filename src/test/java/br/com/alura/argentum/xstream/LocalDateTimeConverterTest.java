package br.com.alura.argentum.xstream;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.modelo.Negociacao;

public class LocalDateTimeConverterTest {

	@Test
	public void deveRetornarUmXmlComDataCorreta() {
		LocalDateTime hoje = LocalDateTime.of(2016, 8, 5, 12, 00);
		Negociacao negociacao = new Negociacao(10.0, 4, hoje );
		
		XStream xstream = new XStream(new DomDriver());
		xstream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		xstream.alias("negociacao", Negociacao.class);
		String xmlConvertido = xstream.toXML(negociacao);
		
		String xmlEsperado = 
				  "<negociacao>\n"
				+ "  <preco>10.0</preco>\n"
				+ "  <quantidade>4</quantidade>\n"
				+ "  <data>\n"
				+ "    <time>1470409200000</time>\n"
				+ "    <timezone>America/Sao_Paulo</timezone>\n"
				+ "  </data>\n"
				+ "</negociacao>";
		Assert.assertEquals(xmlEsperado, xmlConvertido);
		
	}
	
	@Test
	public void deveConverterUmXmlParaUmaNegociacaoCorreta() {
		
		LocalDateTime hoje = LocalDateTime.of(2016, 8, 5, 12, 00);
		String xmlNegociacao = 
				  "<negociacao>\n"
				+ "  <preco>10.0</preco>\n"
				+ "  <quantidade>4</quantidade>\n"
				+ "  <data>\n"
				+ "    <time>1470409200000</time>\n"
				+ "    <timezone>America/Sao_Paulo</timezone>\n"
				+ "  </data>\n"
				+ "</negociacao>";
		
		Negociacao negociacaoEsperada = new Negociacao(10.0, 4, hoje);
		XStream xstream = new XStream(new DomDriver());
		xstream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		xstream.alias("negociacao", Negociacao.class);
		Negociacao negociacaoConvertida = (Negociacao)xstream.fromXML(xmlNegociacao);
		
		Assert.assertEquals(negociacaoEsperada, negociacaoConvertida);
		
		
	}

}
