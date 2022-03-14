import java.io.IOException;
import java.io.FileWriter;

import java.util.ArrayList;

public class Set {
    ArrayList<Game> games = new ArrayList<>();
    Jogador vencedor;
    Jogador ja, jb;
    int gamesA;
    int gamesB;
    int pontosA;
    int pontosB;
    int totalDEGames;//numero de games jogados
    int totalDEPontos;//total de pontos por set

    public Set(Jogador ja, Jogador jb) {
        this.ja = ja;
        this.jb = jb;
        this.gamesA = 0;
        this.gamesB = 0;
        this.totalDEGames = 0;
        this.totalDEPontos = 0;
    }

    public int getGamesA() {
        return this.gamesA;
    }

    public int getGamesB() {
        return this.gamesB;
    }

    public int getTotalDEGames(){
        return this.totalDEGames;
    }

    public int getTotalDEPontos(){
        return this.totalDEPontos;
    }

    //public void setTotalDEGames(int a){
    //    this.totalDEGames = a;
    //}

    public void setGames(int a, int b, boolean x) {
        if (!x) {
            this.gamesA = a;
            this.gamesB = b;
        } else {
            this.gamesA = 0;
            this.gamesB = 0;
        }
    }

    public void resetPontos() {
        this.pontosA = 0;
        this.pontosB = 0;
        this.totalDEPontos = 0;
    }

    public void simula(FileWriter arq, FileWriter arqGerais) throws IOException {
        try {
            int totalGames = 0;
            int totalTieBreaks = 0;
            while (true) {
                this.totalDEGames++;
                Game game = new Game(this.ja, this.jb);
                games.add(game);
                game.simula(arq);

                this.vencedor = game.getVencedor();
                if (this.vencedor == this.ja) {
                    //A venceu game
                    this.gamesA++;
                    totalGames++;
                    arq.write("Jogador A ganhou " + gamesA + " game(s)\n");
                } else {
                    //B venceu game
                    this.gamesB++;
                    totalGames++;
                    arq.write("Jogador B ganhou " + gamesB + " game(s)\n");
                }
                //verificar se alguem já venceu o set
                if (this.gamesA >= this.gamesB + 2 && this.gamesA >= 6) {
                    // A venceu set
                    this.totalDEPontos += game.totalPontos;
                    this.pontosA += game.getPontosA();
                    this.pontosB += game.getPontosB();
                    this.vencedor = this.ja;
                    ja.alteraSetsJogador();
                    arq.write("Jogador A Venceu Set!"+"\n");
                    arq.write("Placar de Games: " + this.gamesA + " x " + this.gamesB +"\n");
                    break;
                } else if (this.gamesB >= this.gamesA + 2 && this.gamesB >= 6) {
                    // B venceu set
                    this.totalDEPontos += game.totalPontos;
                    this.pontosB += game.getPontosB();
                    this.pontosA += game.getPontosA();
                    this.vencedor = this.jb;
                    jb.alteraSetsJogador();
                    arq.write("Jogador B Venceu Set!\n");
                    arq.write("Placar de Games: " + this.gamesA + " x " + this.gamesB+"\n");
                    break;
                }
                
                //n importa se é if ou else if
                // tie break: Ganha quem ganhar o game 7
                if (this.gamesA == 6 && this.gamesB == 6) {
                    game.resetPontos();
                    game.simulaTieBreak(arq);
                    this.vencedor = game.getVencedor();
                    if (this.vencedor == this.ja) {
                        //A venceu set
                        this.totalDEPontos += game.totalPontos;
                        this.pontosA += game.getPontosA();
                        this.pontosB += game.getPontosB();
                        this.gamesA++;
                        totalTieBreaks++;
                        arq.write("\n");
                        arq.write("Jogador A Venceu o Tie Break!\n");
                        arq.write("Jogador A ganhou: " + gamesA + " game(s)\n");
                        arq.write("\n");
                        arq.write("Jogador A Venceu Set!\n");
                        arq.write("\n");
                        break;
                    } else {
                        //B venceu set
                        this.totalDEPontos += game.totalPontos;
                        this.pontosB += game.getPontosB();
                        this.pontosA += game.getPontosA();
                        this.gamesB++;
                        totalTieBreaks++;
                        arq.write("\n");
                        arq.write("Jogador B Venceu o Tie Break!\n");
                        arq.write("Jogador B ganhou: " + gamesB + " game(s)\n");
                        arq.write("\n");
                        arq.write("Jogador B Venceu Set!\n");
                        arq.write("\n");
                        break;
                    }
                }
                this.totalDEPontos += game.totalPontos;
                this.pontosA += game.getPontosA();
                this.pontosB += game.getPontosB();

                arq.write("\n");
            }//fim do while
            arqGerais.write("Total de games que A ganhou desse set:"+ this.gamesA +"\n");
            arqGerais.write("Total de games que B ganhou desse set:"+ this.gamesB +"\n");
            this.totalDEGames = totalGames + totalTieBreaks; 
        } catch (Exception e) {
            throw new IOException();
        }
    }

    public Jogador getVencedor() {
        return this.vencedor;
    }
    public int getPontosA(){
        return this.pontosA;
    }
    public int getPontosB(){
        return this.pontosB;
    }

}