package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

public final class Negociacao {
	private final double preco;
	private final int quantidade;
	private final LocalDateTime data;
	
	public Negociacao(double preco, int quantidade, LocalDateTime date) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = date;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public LocalDateTime getDate() {
		return data;
	}
	
	public double getVolume() {
		return this.preco * this.quantidade;
	}
	
}
