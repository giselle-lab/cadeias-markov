import java.util.ArrayList;

public class Partida {
    ArrayList<Set> sets = new ArrayList<>();
    Jogador ja, jb;
    int setsJa, setsJb;
    Jogador vencedor;

    public Partida(Jogador ja, Jogador jb) {
        this.ja = ja;
        this.jb = jb;
        this.setsJa = 0;
        this.setsJb = 0;
    }

    public void simula() {
        Set set = new Set(this.ja, this.jb);
        set.simula();
        this.vencedor = set.getVencedor();
        if(this.vencedor == this.ja) {
            this.setsJa++;
        } else {
            this.setsJb++;
        }

        if(this.setsJa > this.setsJb + 2) {
            //A venceu
            this.vencedor = this.ja;
        } else if(this.setsJb > this.setsJa + 2) {
            //B venceu
            this.vencedor = this.jb;
        } else if(this.setsJa == 1 && this.setsJb == 1){
            set.simula();
            this.vencedor = set.getVencedor();
        }
    }
    public String getVencedor(){
        return this.vencedor.getNome();
    }
}