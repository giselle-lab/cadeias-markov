import java.io.FileWriter;
import java.io.IOException;

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

    public void simula(FileWriter arq) throws IOException {
        try {
            while (true) {
                Set set = new Set(this.ja, this.jb);
                set.simula(arq);
                this.vencedor = set.getVencedor();
                if (this.vencedor == this.ja) {
                    this.setsJa++;
                    arq.write("\n");
                    arq.write("Jogador A Venceu o Set!\n");
                    arq.write("Set: " + this.setsJa + " x " + this.setsJb+"\n");
                    arq.write("\n");
                } else {
                    this.setsJb++;
                    arq.write("\n");
                    arq.write("Jogador B Venceu o Set!\n");
                    arq.write("Set: " + this.setsJa + " x " + this.setsJb+"\n");
                    arq.write("\n");
                    // break;
                }

                if (this.setsJa >= this.setsJb + 2) {
                    // A venceu
                    set.setGames(set.getGamesA(), set.getGamesB(), false);
                    this.vencedor = this.ja;
                    arq.write("Jogador A Venceu a Partida!\n");
                    arq.write("Partida: " + this.setsJa + " x " + this.setsJb+"\n");
                    arq.write("\n");
                    break;
                } else if (this.setsJb >= this.setsJa + 2) {
                    // B venceu
                    set.setGames(set.getGamesA(), set.getGamesB(), false);
                    this.vencedor = this.jb;
                    arq.write("Jogador B Venceu a Partida!\n");
                    arq.write("Partida: " + this.setsJa + " x " + this.setsJb+"\n");
                    arq.write("\n");
                    break;
                }
                if (this.setsJa == 1 && this.setsJb == 1) {
                    set.setGames(0, 0, true);
                    set.simula(arq);
                    this.vencedor = set.getVencedor();
                    if (this.vencedor == this.ja) {
                        this.setsJa++;
                        arq.write("\n");
                        arq.write("Jogador A Venceu o Set!");
                        arq.write("Set: " + this.setsJa + " x " + this.setsJb);
                        arq.write("\n");
                    } else {
                        this.setsJb++;
                        arq.write("\n");
                        arq.write("Jogador B Venceu o Set!");
                        arq.write("Set: " + this.setsJa + " x " + this.setsJb);
                        arq.write("\n");
                    }
                    // arq.write("Jogador " + this.vencedor.getNome() + " Venceu a
                    // Partida!");
                    arq.write("Partida: " + this.setsJa + " x " + this.setsJb);
                    break;
                }
            }
            arq.write("\n");
        } catch (Exception e) {
            throw new IOException();
        }
    }

    public String getVencedor() {
        return this.vencedor.getNome();
    }

    public void setSets(int a, int b) {
        this.setsJa = a;
        this.setsJb = b;
    }
}