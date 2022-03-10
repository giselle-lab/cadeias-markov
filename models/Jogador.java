package models;

public class Jogador {
	private String nome;
	private double probabilidade;
	private int partidas; // numero de partidas ganhas
	private int set; // numero de sets ganhos
	private int pontos; // pontos feitos

	public Jogador(){

	}

	public Jogador(String nome, double probabilidade) {
		this.nome = nome;
		this.probabilidade = probabilidade;
		this.partidas = 0;
		//this.set = 0;
		this.pontos = 0;
	}

	public String getNome() {
		return nome;
	}

	public double getProbabilidade() {
		return probabilidade;
	}

	public int getSetJogador() {
		return set;
	}

	public int getPartidasJogador() {
		return partidas;
	}

	public int getPontosJogador() {
		return pontos;
	}

	//games
	public void alteraPartidasJogador() {
		this.partidas++;
	}

	public void alteraSetJogador() {
		this.set++;
	}

	public void alteraPontosJogador() {
		this.pontos++;
	}
}