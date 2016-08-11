package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.List;

public class ClandlestickFactory {

	
	public Candlestick controiCandleParaData(List<Negociacao> negociacoes, LocalDateTime data) {
		
		double abertura = negociacoes.get(0).getPreco();
		double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		double minimo = negociacoes.get(0).getPreco();
		double maximo = negociacoes.get(0).getPreco();
		double volume = 0;

		
		for (Negociacao negociacao : negociacoes) {
			if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			} else if (negociacao.getPreco() > maximo) { 
				maximo = negociacao.getPreco();
			}
			volume += negociacao.getPreco() * negociacao.getQuantidade();
		}
		
		return  new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
