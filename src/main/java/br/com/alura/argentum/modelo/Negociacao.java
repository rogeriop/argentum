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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidade;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Negociacao other = (Negociacao) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}


	public double getPreco() {
		return preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public double getVolume() {
		return this.preco * this.quantidade;
	}


	public boolean isMesmoDia(LocalDateTime outraData) {
		return this.data.getDayOfMonth() == outraData.getDayOfMonth()
				&& this.data.getMonth() == outraData.getMonth()
				&& this.data.getYear() == outraData.getYear();
	}
	
}
