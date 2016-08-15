package br.com.alura.argentum.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class CandleBuilderTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		Candlestick candle = new CandleBuilder().abertura(10.0).fechamento(30.0)
				.minimo(35.0).maximo(11.0).volume(100)
				.data(LocalDateTime.now()).geraCandle();
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candlestick candle = new CandleBuilder().abertura(10.0).fechamento(10.0)
				.minimo(11.0).maximo(35.0).volume(100)
				.data(LocalDateTime.now()).geraCandle();
		assertTrue(candle.isAlta());
	}

}
