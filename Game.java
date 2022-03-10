import java.util.ArrayList;

public class Game extends Ponto{
    private ArrayList<Ponto> pontos = new ArrayList<>();
    private Jogador vencedor;
    private Jogador ja, jb;
    private int pontosA;
    private int pontosB;

    public Game(Jogador ja, Jogador jb){
        this.ja = ja;
        this.jb = jb;
        this.pontosA = 0;
        this.pontosB = 0;
    }

    public void simula() {
        while(true) {
            Ponto ponto = new Ponto();
            ponto.simula(this.ja,this.jb);
            pontos.add(ponto);
            this.vencedor = ponto.getVencedor();
            if(this.vencedor == this.ja) {
                this.pontosA++;
            }
            else {
                this.pontosB++;
            }
            if(this.pontosA > this.pontosB + 2 && this.pontosA >= 4) {
                // A venceu
                this.vencedor = this.ja;
                break;
            }
            else if (this.pontosB > this.pontosA + 2 && this.pontosB >= 4) {
                // B venceu
                this.vencedor = this.jb;
                break;
            }
        }
    } 

    public Jogador getVencedor() {
        return this.vencedor;
    }

}