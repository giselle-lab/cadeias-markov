import java.util.Random;

public class Ponto {
    float generatedNumber;
    Jogador vencedor;

    public Ponto() {
        this.generatedNumber = 0;
        this.vencedor =  null;
    }

    public void simula(Jogador ja, Jogador jb){
        Random rand = new Random();
        this.generatedNumber = rand.nextFloat();
        if(this.generatedNumber < ja.getProbabilidade()) {
            this.vencedor = ja;
            ja.alteraPontosJogador();
        }
        else {
            this.vencedor = jb;
            jb.alteraPontosJogador();
        }
    }

    public Jogador getVencedor() {
        return this.vencedor;
    }

}