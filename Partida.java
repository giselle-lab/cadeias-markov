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
        while (true) {
            Set set = new Set(this.ja, this.jb);
            set.simula();
            this.vencedor = set.getVencedor();
            if (this.vencedor == this.ja) {
                this.setsJa++;
                System.out.println();
                System.out.println("Jogador A Venceu o Set!");
                System.out.println("Set: " + this.setsJa + " x " + this.setsJb);
                System.out.println();
            } else {
                this.setsJb++;
                System.out.println();
                System.out.println("Jogador B Venceu o Set!");
                System.out.println("Set: " + this.setsJa + " x " + this.setsJb);
                System.out.println();
                //break;
            }

            if (this.setsJa >= this.setsJb + 2) {
                // A venceu
                set.setGames(set.getGamesA(), set.getGamesB(), false);
                this.vencedor = this.ja;
                System.out.println("Jogador A Venceu a Partida!");
                System.out.println("Partida: " + this.setsJa + " x " + this.setsJb);
                System.out.println();
                break;
            } else if (this.setsJb >= this.setsJa + 2) {
                // B venceu
                set.setGames(set.getGamesA(), set.getGamesB(), false);
                this.vencedor = this.jb;
                System.out.println("Jogador B Venceu a Partida!");
                System.out.println("Partida: " + this.setsJa + " x " + this.setsJb);
                System.out.println();
                break;
            } 
            if (this.setsJa == 1 && this.setsJb == 1) {
                set.setGames(0, 0, true);
                set.simula();
                this.vencedor = set.getVencedor();
                if (this.vencedor == this.ja) {
                    this.setsJa++;
                    System.out.println();
                    System.out.println("Jogador A Venceu o Set!");
                    System.out.println("Set: " + this.setsJa + " x " + this.setsJb);
                    System.out.println();
                } else {
                    this.setsJb++;
                    System.out.println();
                    System.out.println("Jogador B Venceu o Set!");
                    System.out.println("Set: " + this.setsJa + " x " + this.setsJb);
                    System.out.println();
                }
                //System.out.println("Jogador " + this.vencedor.getNome() + " Venceu a Partida!");
                System.out.println("Partida: " + this.setsJa + " x " + this.setsJb);
                break;
            }
        }
        System.out.println();
    }

    public String getVencedor() {
        return this.vencedor.getNome();
    }

    public void setSets(int a,int b){
        this.setsJa = a;
        this.setsJb = b;
    }
}