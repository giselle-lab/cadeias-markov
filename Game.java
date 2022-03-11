import java.io.IOException;
import java.io.FileWriter;

import java.util.ArrayList;

public class Game extends Ponto {
    private ArrayList<Ponto> pontos = new ArrayList<>();
    private Jogador vencedor;
    private Jogador ja, jb;
    private int pontosA;
    private int pontosB;

    public Game(Jogador ja, Jogador jb) {
        this.ja = ja;
        this.jb = jb;
        this.pontosA = 0;
        this.pontosB = 0;
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
                    this.pontosA++;
                    arq.write("Jogador A Pontuou! \n");
                    arq.write("Pontuação: " + this.pontosA + " x " + this.pontosB + "\n");
                } else {
                    this.pontosB++;
                    arq.write("Jogador B Pontuou! \n" );
                    arq.write("Pontuação: " + this.pontosA + " x " + this.pontosB + "\n");
                }

                if (this.pontosA >= this.pontosB + 2 && this.pontosA >= 4) {
                    // A venceu
                    this.vencedor = this.ja;
                    arq.write("\n");
                    arq.write("Jogador A fez um Game!\n");
                    arq.write("Pontuação do Game: " + this.pontosA + " x " + this.pontosB + "\n");
                    break;
                } else if (this.pontosB >= this.pontosA + 2 && this.pontosB >= 4) {
                    // B venceu
                    this.vencedor = this.jb;
                    arq.write("\n");
                    arq.write("Jogador B fez um Game! \n");
                    arq.write("Pontuação do Game: " + this.pontosA + " x " + this.pontosB + "\n");
                    break;
                }
            }
            arq.write("\n");
        } catch (Exception e) {
            throw new IOException();
        }
    }

    public void simulaTieBreak(FileWriter arq) throws IOException {
        while(true) {
            Ponto ponto = new Ponto();
            ponto.simula(this.ja,this.jb);
            pontos.add(ponto);
            this.vencedor = ponto.getVencedor();
            if(this.vencedor == this.ja) {
                this.pontosA++;
                arq.write("Jogador A Pontuou!\n");
                arq.write("Pontuação: "+ this.pontosA + " x " + this.pontosB + "\n");
            }
            else {
                this.pontosB++;
                arq.write("Jogador B Pontuou!"+ "\n");
                arq.write("Pontuação: "+ this.pontosA + " x " + this.pontosB+ "\n");
            }

            if(this.pontosA >= this.pontosB + 2 && this.pontosA >= 7) {
                // A venceu
                this.vencedor = this.ja;
                arq.write("\n");
                arq.write("Jogador A fez um Game!"+ "\n");
                arq.write("Pontuação do Game: "+ this.pontosA + " x " + this.pontosB+ "\n");
                break;
            }
            else if (this.pontosB >= this.pontosA + 2 && this.pontosB >= 7) {
                // B venceu
                this.vencedor = this.jb;
                arq.write("\n");
                arq.write("Jogador B fez um Game!"+ "\n");
                arq.write("Pontuação do Game: "+ this.pontosA + " x " + this.pontosB+ "\n");
                break;
            }
        }
        arq.write("\n");

    }

    public Jogador getVencedor() {
        return this.vencedor;
    }

}