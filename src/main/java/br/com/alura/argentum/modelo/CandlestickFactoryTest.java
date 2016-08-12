package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class CandlestickFactoryTest {

	@Test
	public void sequenciaSimplesDeNigociacoes() {
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		Candlestick candlestick = new CandlestickFactory().controiCandleParaData(negociacoes, hoje);
		
		assertEquals(40.5, candlestick.getAbertura(), 0.000001);
		assertEquals(42.3, candlestick.getFechamento(), 0.000001);
		assertEquals(39.8, candlestick.getMinimo(), 0.000001);
		assertEquals(45.0, candlestick.getMaximo(), 0.000001);
		assertEquals(16760.0, candlestick.getVolume(), 0.000001);
		

		
	}
}
