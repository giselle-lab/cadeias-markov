import java.util.ArrayList;

public class Jogo extends Jogador {
    private int setAtual;
    private int partidaAtual;
    private int pontoAtual;
    private ArrayList<Jogador> jogadores = new ArrayList();

    public Jogo(Jogador j1, Jogador j2){
        super();
        this.setAtual = 0;
        this.partidaAtual = 0;
        this.pontoAtual = 0;
        adicionaJogador(j1);
        adicionaJogador(j2);
    }

    public void adicionaJogador(Jogador j) {
        jogadores.add(j);
    }

    public void alteraPartidas(Jogador j) {
        this.partidaAtual++;
        j.alteraPartidasJogador();
    }

    public void alteraSet(Jogador j) {
        this.setAtual++;
        j.alteraSetJogador();
    }

    public void alteraPontos(Jogador j) {
        this.pontoAtual++;
        j.alteraPontosJogador();
    }
}