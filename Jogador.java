public class Jogador {
	private String nome;
	private float probabilidade;
	private int partidas; // numero de partidas ganhas
	private int set; // numero de sets ganhos
	private int pontos; // pontos feitos

	public Jogador(){

	}
	
	public Jogador(String nome, float probabilidade) {
		this.nome = nome;
		this.probabilidade = probabilidade;
		this.partidas = 0;
		this.set = 0;
		this.pontos = 0;
	}

	public String getNome() {
		return nome;
	}

	public float getProbabilidade() {
		return probabilidade;
	}

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