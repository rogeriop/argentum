package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CandlestickFactory {

	
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

	public List<Candlestick> constroiCandles(List<Negociacao> negociacoes) {
	    // Cria a lista de negociações do dia e a lista de Candles que devemos retornar
	    List<Candlestick> candlesticks = new ArrayList<>();

	    List<Negociacao> negociacoesDoDia = new ArrayList<>();

	    LocalDateTime dataAtual = negociacoes.get(0).getData();

	    // Vamos percorrendo a lista com todas as negociacoes.        
	    for (Negociacao negociacao : negociacoes) {
	        // se for mesmo dia, adiciona na lista de Negociacoes daquele dia
	        if(negociacao.isMesmoDia(dataAtual)){
	            negociacoesDoDia.add(negociacao);
	        }else{
	            // se não for mesmo dia, fecha o candle e reinicia variáveis
	            Candlestick candle = controiCandleParaData(negociacoesDoDia, dataAtual);
	            candlesticks.add(candle);


	            negociacoesDoDia = new ArrayList<>();

	            // Aqui precisamos adicionar o item que caiu no else na nova lista, caso constrário só serão adicionados os itens das próximas iterações.
	            negociacoesDoDia.add(negociacao);

	            dataAtual = negociacao.getData();
	        }

	    }
	    // adiciona último candle
	    Candlestick candle = controiCandleParaData(negociacoesDoDia, dataAtual);
	    candlesticks.add(candle);

	    return candlesticks;	}
}
