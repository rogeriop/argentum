package br.com.alura.argentum.modelo;

public class IdentidadeBuilder {
    private int numero;
    private String nome;
    private String nomeDaMae;
    private String nomeDoPai;
    private String estadoOndeNasceu;
    
    public IdentidadeBuilder numero(int numero) {
    	this.numero = numero;
    	return this;
    }
    
    public IdentidadeBuilder nome(String nome) {
    	this.nome = nome;
    	return this;
    }

    public IdentidadeBuilder nomeDaMae(String nomeDaMae) {
    	this.nomeDaMae = nomeDaMae;
    	return this;
    }
    public IdentidadeBuilder nomeDoPai(String nomeDoPai) {
    	this.nomeDoPai = nomeDoPai;
    	return this;
    }
    
    public IdentidadeBuilder estadoOndeNasceu(String estadoOndeNasceu) {
    	this.estadoOndeNasceu = estadoOndeNasceu;
    	return this;
    }

    public Identidade gera() {
    	return new Identidade(numero, nome, nomeDaMae, nomeDoPai, estadoOndeNasceu);
    }
}
