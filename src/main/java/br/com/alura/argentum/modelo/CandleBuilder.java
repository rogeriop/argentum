package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

public class CandleBuilder {
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private LocalDateTime data;

	public CandleBuilder abertura(double abertura) {
		this.abertura = abertura;
		return this;
	}
	
	public CandleBuilder fechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}
	
	public CandleBuilder minimo(double minimo) {
		this.minimo = minimo;
		return this;
	}
	
	public CandleBuilder maximo(double maximo) {
		this.maximo = maximo;
		return this;
	}
	
	public CandleBuilder volume(double volume) {
		this.volume = volume;
		return this;
	}
	
	public CandleBuilder data(LocalDateTime data) {
		this.data = data;
		return this;
	}
	
	public Candlestick geraCandle() {
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
	
}
