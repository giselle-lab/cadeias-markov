
public class Jogador {
	private String nome;
	private double probabilidade;

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

}