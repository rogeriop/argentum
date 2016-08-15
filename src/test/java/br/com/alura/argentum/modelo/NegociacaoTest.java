package br.com.alura.argentum.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class NegociacaoTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10.0, 100, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComPrecoNegativo() {
		new Negociacao(-10.0, 100, LocalDateTime.now());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComQuantidadeZero() {
		new Negociacao(-10.0, 0, LocalDateTime.now());
	}
}
