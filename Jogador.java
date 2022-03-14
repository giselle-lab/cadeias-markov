import java.io.IOException;
import java.io.FileWriter;

public class Jogador {
	private String nome;
	private double probabilidade;
	private int partidas; // numero de partidas ganhas
	private int tiebreaks;//número de tie breaks ganhos
	private int sets; //numero de sets ganhos
	private int games; //games ganhos em cada Set
	private int pontos; //pontos feitos

	public Jogador(String nome, double probabilidade) {
		this.nome = nome;
		this.probabilidade = probabilidade;
	}

	public String getNome() {
		return this.nome;
	}

	public double getProbabilidade() {
		return this.probabilidade;
	}

	public int getPartidas(){
		return this.partidas;
	}

	public int getSets(){
		return this.sets;
	} 

	public int getGames(){
		return this.games;
	}

	public void resetetGames(){
		this.games = 0;
	}

	public void resetetTieBreaks(){
		this.tiebreaks = 0;
	}

	public int getPontos(){
		return this.pontos;
	}

	public int getTieBreakes(){
		return this.tiebreaks;
	}

	public void alteraPartidasJogador() {
		this.partidas++;
	}

	public void alteraSetsJogador() {
		this.sets++;
	}

	public void alteraGamesJogador() {
		this.games++;
	}

	public void alteraPontosJogador() {
		this.pontos++;
	}

	public void alteraTieBreaks(){
		this.tiebreaks++;
	}

	 public void imprimeGames(FileWriter arq, int totalGames)throws IOException{
        //games
        arq.write("Jogador "+this.nome+" ganhou " + this.games+ "/" + totalGames + " games \n");
    }

    public void imprimeTieBreak(FileWriter arq, int totalTieBreaks)throws IOException{
        //tie breaks
        arq.write("Jogador "+this.nome+" ganhou " + this.tiebreaks + "/" + totalTieBreaks + " tie breaks\n");
    }

	public void imprimeTotalGamesGanhos(FileWriter arq, int total)throws IOException{
        //total games ganhos
		int totalgamesganhos = this.tiebreaks + this.games;
        arq.write("Jogador "+this.nome+" ganhou " + totalgamesganhos + "/" + total + " games no total\n");
    }

	public void imprimePartidas(FileWriter arq) throws IOException{
        //partidas
        arq.write("Jogador "+this.nome+" ganhou " + this.partidas + "/" + 30 + " partidas\n");
        //arq.close();
    }

}