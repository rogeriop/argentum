package br.com.alura.argentum.grafico;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.alura.argentum.indicadores.MediaMovelSimples;
import br.com.alura.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico {
	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		
		this.modeloGrafico = new LineChartModel();
		this.modeloGrafico.setLegendPosition("w");
		this.modeloGrafico.setTitle("Indicadores");
	}
	
	public void plotaMediaMovelSimples() {
		MediaMovelSimples indicador = new MediaMovelSimples();
		LineChartSeries linha = new LineChartSeries();
		linha.setLabel("MMS - Fechamento");
		for (int i = comeco; i <= fim; i++) {
			double valor = indicador.calcula(i, serie);
			linha.set(i, valor);
		}
		this.modeloGrafico.addSeries(linha);
	}
	public LineChartModel getModeloGrafico() {
		return this.modeloGrafico;
	}
}
