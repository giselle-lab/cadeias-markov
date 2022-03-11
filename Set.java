import java.io.IOException;
import java.io.FileWriter;

import java.util.ArrayList;

public class Set {
    ArrayList<Game> games = new ArrayList<>();
    Jogador vencedor;
    Jogador ja, jb;
    int gamesA;
    int gamesB;

    public Set(Jogador ja, Jogador jb) {
        this.ja = ja;
        this.jb = jb;
        this.gamesA = 0;
        this.gamesB = 0;
    }

    public int getGamesA() {
        return this.gamesA;
    }

    public int getGamesB() {
        return this.gamesB;
    }

    public void setGames(int a, int b, boolean x) {
        if (x) {
            this.gamesA = a;
            this.gamesB = b;
        }
    }

    public void simula(FileWriter arq) throws IOException {
        try {
            while (true) {
                Game game = new Game(this.ja, this.jb);
                games.add(game);
                game.simula(arq);
                this.vencedor = game.getVencedor();
                if (this.vencedor == this.ja) {
                    this.gamesA++;
                    arq.write("Jogador A ganhou: " + gamesA + " game(s)\n");
                } else {
                    this.gamesB++;
                    arq.write("Jogador B ganhou: " + gamesB + " game(s)\n");
                }

                if (this.gamesA >= this.gamesB + 2 && this.gamesA >= 6) {
                    // A venceu
                    this.vencedor = this.ja;
                    arq.write("Jogador A Venceu Set!"+"\n");
                    arq.write("Pontuação Games: " + this.gamesA + " x " + this.gamesB +"\n");
                    break;
                } else if (this.gamesB >= this.gamesA + 2 && this.gamesB >= 6) {
                    // B venceu
                    this.vencedor = this.jb;
                    arq.write("Jogador B Venceu Set!\n");
                    arq.write("Pontuação Games: " + this.gamesA + " x " + this.gamesB+"\n");
                    break;
                }
                // tie break: Ganha quem ganhar o game 7
                else if (this.gamesA == 6 && this.gamesB == 6) {
                    game.resetPontos();
                    game.simulaTieBreak(arq);
                    this.vencedor = game.getVencedor();
                    if (this.vencedor == this.ja) {
                        this.gamesA++;
                        arq.write("\n");
                        arq.write("Jogador A Venceu o Tie Break!\n");
                        arq.write("Jogador A ganhou: " + gamesA + " game(s)\n");
                        arq.write("\n");
                        break;
                    } else {
                        this.gamesB++;
                        arq.write("\n");
                        arq.write("Jogador B Venceu o Tie Break!\n");
                        arq.write("Jogador B ganhou: " + gamesB + " game(s)\n");
                        arq.write("\n");
                        break;
                    }
                }
                arq.write("\n");

            }
        } catch (Exception e) {
            throw new IOException();
        }
    }

    public Jogador getVencedor() {
        return this.vencedor;
    }

}