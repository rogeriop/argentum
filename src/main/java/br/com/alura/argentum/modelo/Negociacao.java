package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

public final class Negociacao {
	private final double preco;
	private final int quantidade;
	private final LocalDateTime data;
	
	public Negociacao(double preco, int quantidade, LocalDateTime data) {
		if (preco < 0) {
			throw new IllegalArgumentException ("Preco nao pode ser negativo");
		}
		if (quantidade < 1) {
			throw new IllegalArgumentException("Quantidade deve ser pelo menos 1");
		}
		if (data == null) {
			throw new IllegalArgumentException("Data nao pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
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
