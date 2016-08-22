package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Assert;
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
	@Test
	public void mesmoMinutoEhDoMesmoDia() {
		LocalDateTime agora = LocalDateTime.now();
		LocalDateTime mesmoMomento = agora;
		
		Negociacao negociacao = new Negociacao(100.0, 20, agora);
		
		Assert.assertTrue(negociacao.isMesmoDia(agora));
	}
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
		LocalDateTime manha = LocalDateTime.of(2016, 02, 25, 8, 30);
		LocalDateTime tarde = LocalDateTime.of(2016, 02, 25, 15, 30);
		
		Negociacao negociacao = new Negociacao(100.0,  20, manha);
		
		Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		LocalDateTime fevereiro = LocalDateTime.of(2016, 02, 25, 8, 30);
		LocalDateTime marco = LocalDateTime.of(2016, 03, 25, 8, 30);
		
		Negociacao negociacao = new Negociacao(100.0,  20, fevereiro);
		
		Assert.assertFalse(negociacao.isMesmoDia(marco));
	}
	@Test
	public void anosDiferentesNaoEhMesmoDia() {
		LocalDateTime ano2016 =  LocalDateTime.of(2016, 02, 25, 8, 30);
	    LocalDateTime ano2017 =  LocalDateTime.of(2017, 02, 25, 8, 30);
	    
	    Negociacao negociacao = new Negociacao(10.0, 100, ano2016);
	    
	    Assert.assertFalse(negociacao.isMesmoDia(ano2017));
	}
}
