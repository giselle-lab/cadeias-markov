import java.util.ArrayList;

public class TieBreak {
    private ArrayList<Ponto> pontos = new ArrayList<>();
    private Jogador vencedor;
    private Jogador ja, jb;
    private int pontosA;
    private int pontosB;

    public TieBreak(Jogador ja, Jogador jb){
        this.ja = ja;
        this.jb = jb;
        this.pontosA = 0;
        this.pontosB = 0;
    }

    //ganha quem chegar a 7 pontos primeiro com pelo menos 2 porntos de margem.
    //ou se ficar 6-6, ganham quem ficar com 2 pontos de margem
    public void simula() {
        while(true) {
            Ponto ponto = new Ponto();
            ponto.simula(this.ja,this.jb);
            pontos.add(ponto);
            this.vencedor = ponto.getVencedor();
            if(this.vencedor == this.ja) {
                this.pontosA++;
                System.out.println("Jogador A Pontuou!");
                System.out.println("Pontuação: "+ this.pontosA + " x " + this.pontosB);
            }
            else {
                this.pontosB++;
                System.out.println("Jogador B Pontuou!");
                System.out.println("Pontuação: "+ this.pontosA + " x " + this.pontosB);
            }

            if(this.pontosA >= this.pontosB + 2 && this.pontosA >= 7) {
                // A venceu
                this.vencedor = this.ja;
                System.out.println();
                System.out.println("Jogador A fez um Game!");
                System.out.println("Pontuação do Game: "+ this.pontosA + " x " + this.pontosB);
                break;
            }
            else if (this.pontosB >= this.pontosA + 2 && this.pontosB >= 7) {
                // B venceu
                this.vencedor = this.jb;
                System.out.println();
                System.out.println("Jogador B fez um Game!");
                System.out.println("Pontuação do Game: "+ this.pontosA + " x " + this.pontosB);
                break;
            }
        }
        System.out.println();

    } 

    public Jogador getVencedor() {
        return this.vencedor;
    }

}
