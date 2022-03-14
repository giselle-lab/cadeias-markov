import java.io.IOException;
import java.io.FileWriter;

import java.util.ArrayList;

public class Game extends Ponto {
    private ArrayList<Ponto> pontos = new ArrayList<>();
    private Jogador vencedor;
    private Jogador ja, jb;
    private int pontosA;
    private int pontosB;
    int totalPontos;//numero total de pontos jogados no game

    public Game(Jogador ja, Jogador jb) {
        this.ja = ja;
        this.jb = jb;
        this.pontosA = 0;
        this.pontosB = 0;
        this.totalPontos = 0;
    }

    public Jogador getJogadorA(){
        return this.ja;
    }

   public Jogador getJogadorB(){
        return this.jb;
    }

    public void resetPontos(){
        this.pontosA = 0;
        this.pontosB = 0;
    }

    public void simula(FileWriter arq) throws IOException {
        try {
            while (true) {
                Ponto ponto = new Ponto();
                ponto.simula(this.ja, this.jb);
                
                pontos.add(ponto);
                this.vencedor = ponto.getVencedor();
                if (this.vencedor == this.ja) {
                    //A venceu ponto
                    this.pontosA++;
                    arq.write("Jogador A Pontuou! \n");
                    arq.write("Pontuação: " + this.pontosA + " x " + this.pontosB + "\n");
                } else {
                    //B venceu ponto
                    this.pontosB++;
                    arq.write("Jogador B Pontuou! \n" );
                    arq.write("Pontuação: " + this.pontosA + " x " + this.pontosB + "\n");
                }
                //verificar se alguem já venceu o game
                if (this.pontosA >= this.pontosB + 2 && this.pontosA >= 4) {
                    // A venceu game
                    this.vencedor = this.ja;
                    ja.alteraGamesJogador();
                    this.totalPontos = this.pontosA + this.pontosB;
                    arq.write("\n");
                    arq.write("Jogador A fez um Game!\n");
                    arq.write("Pontuação do Game: " + this.pontosA + " x " + this.pontosB + "\n");
                    break;
                } else if (this.pontosB >= this.pontosA + 2 && this.pontosB >= 4) {
                    // B venceu game
                    this.vencedor = this.jb;
                    jb.alteraGamesJogador();
                    this.totalPontos = this.pontosA + this.pontosB;
                    arq.write("\n");
                    arq.write("Jogador B fez um Game! \n");
                    arq.write("Pontuação do Game: " + this.pontosA + " x " + this.pontosB + "\n");
                    break;
                }
            }
            this.totalPontos = this.pontosA + this.pontosB;
            arq.write("\n");
        } catch (Exception e) {
            throw new IOException();
        }
    }

    public void simulaTieBreak(FileWriter arq) throws IOException {
        try {
            while (true) {
                Ponto ponto = new Ponto();
                ponto.simula(this.ja, this.jb);
                pontos.add(ponto);
                this.vencedor = ponto.getVencedor();
                if (this.vencedor == this.ja) {
                    //A venceu ponto
                    this.pontosA++;
                    arq.write("Jogador A Pontuou! \n");
                    arq.write("Pontuação: " + this.pontosA + " x " + this.pontosB + "\n");
                } else {
                    //B venceu ponto
                    this.pontosB++;
                    arq.write("Jogador B Pontuou! \n" );
                    arq.write("Pontuação: " + this.pontosA + " x " + this.pontosB + "\n");
                }
                //verificar se alguem já venceu o game
                if (this.pontosA >= this.pontosB + 2 && this.pontosA >= 7) {
                    // A venceu game
                    this.vencedor = this.ja;
                    ja.alteraGamesJogador();
                    this.totalPontos = this.pontosA + this.pontosB;
                    arq.write("\n");
                    arq.write("Jogador A ganhou o Tie Break! \n");
                    arq.write("Pontuação do Game: " + this.pontosA + " x " + this.pontosB + "\n");
                    break;
                } else if (this.pontosB >= this.pontosA + 2 && this.pontosB >= 7) {
                    // B venceu game
                    this.vencedor = this.jb;
                    jb.alteraGamesJogador();
                    this.totalPontos = this.pontosA + this.pontosB;
                    arq.write("\n");
                    arq.write("Jogador B ganhou o Tie Break! \n");
                    arq.write("Pontuação do Game: " + this.pontosA + " x " + this.pontosB + "\n");
                    break;
                }
            }
            this.totalPontos = this.pontosA + this.pontosB;
            arq.write("\n");
        } catch (Exception e) {
            throw new IOException();
        }
    }

/*
    public void simulaTieBreak(FileWriter arq) throws IOException {
        try {
            while(true) {
                Ponto ponto = new Ponto();
                ponto.simula(this.ja,this.jb);
                pontos.add(ponto);
                this.vencedor = ponto.getVencedor();
                if(this.vencedor == this.ja) {
                    //A venceu ponto
                    this.pontosA++;
                    arq.write("Jogador A Pontuou!\n");
                    arq.write("Pontuação: "+ this.pontosA + " x " + this.pontosB + "\n");
                }
                else {
                    //B venceu ponto
                    this.pontosB++;
                    arq.write("Jogador B Pontuou!"+ "\n");
                    arq.write("Pontuação: "+ this.pontosA + " x " + this.pontosB+ "\n");
                }
                //verificar se alguem já venceu o tie break
                if(this.pontosA >= this.pontosB + 2 && this.pontosA >= 7) {
                    // A venceu tie break
                    this.vencedor = this.ja;
                    this.ja.alteraTieBreaks();
                    this.totalPontos = this.pontosA + this.pontosB;
                    arq.write("\n");
                    arq.write("Jogador A fez um Game!"+ "\n");
                    arq.write("Pontuação do Game: "+ this.pontosA + " x " + this.pontosB+ "\n");
                    break;
                }
                else if (this.pontosB >= this.pontosA + 2 && this.pontosB >= 7) {
                    // B venceu tie break
                    this.vencedor = this.jb;
                    this.jb.alteraTieBreaks();
                    this.totalPontos = this.pontosA + this.pontosB;
                    arq.write("\n");
                    arq.write("Jogador B fez um Game!"+ "\n");
                    arq.write("Pontuação do Game: "+ this.pontosA + " x " + this.pontosB+ "\n");
                    break;
                }
            }
        this.totalPontos = this.pontosA + this.pontosB;
        arq.write("\n");
        } catch (Exception e) {
            throw new IOException();
        }
    }
*/
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