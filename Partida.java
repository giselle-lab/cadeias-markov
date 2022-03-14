import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Partida {
    ArrayList<Set> sets = new ArrayList<>();
    Jogador ja, jb;
    int setsJa, setsJb;
    Jogador vencedor;
    int totalSets;//total de sets na partida
    int totalDEPontos;//total de pontos na partida inteira

    public Partida(Jogador ja, Jogador jb) {
        this.ja = ja;
        this.jb = jb;
        this.setsJa = 0;
        this.setsJb = 0;
        this.totalSets = 0;
        this.totalDEPontos = 0;
    }

    public Jogador getJogadorA(){
         return this.ja;
     }

    public Jogador getJogadorB(){
         return this.jb;
     }

    public void simula(FileWriter arq, FileWriter arqGerais) throws IOException {
        try {
            int totalPontosA = 0;
            int totalPontosB = 0;
            int totalGames = 0;
            int numSet = 1;//para impressão de qual set estamos
            boolean teve3Sets = false;
            while (true) {
                Set set = new Set(this.ja, this.jb);
                arq.write("Set " + numSet + ":");
                arq.write("\n");
                set.simula(arq,arqGerais);
                this.vencedor = set.getVencedor();
                //
                if (this.vencedor == this.ja) {
                    //A venceu set
                    this.setsJa++;
                    numSet++;
                    totalGames += set.getTotalDEGames();
                    totalPontosA += set.getPontosA();
                    totalPontosB += set.getPontosB();
                    arqGerais.write("O jogador A fez " + set.getPontosA() + " pontos nesse set\n");
                    arqGerais.write("O jogador B fez " + set.getPontosB() + " pontos nesse set\n");
                    arqGerais.write("\n");
                    arq.write("Placar de Sets: "  + this.setsJa + " x " + this.setsJb+"\n");
                    arq.write("\n");
                } else {
                    //B venceu set
                    this.setsJb++;
                    numSet++;
                    totalGames += set.getTotalDEGames();
                    totalPontosA += set.getPontosA();
                    totalPontosB += set.getPontosB();
                    arqGerais.write("O jogador A fez " + set.getPontosA() + " pontos nesse set\n");
                    arqGerais.write("O jogador B fez " + set.getPontosB() + " pontos nesse set\n");
                    arqGerais.write("\n");
                    arq.write("Placar de Sets: " +  this.setsJa + " x " + this.setsJb+"\n");
                    arq.write("\n");
                }
                //verificar se alguem já venceu a partida
                if (this.setsJa >= this.setsJb + 2) {
                    // A venceu partida
                    this.totalDEPontos += set.totalDEPontos;
                    this.vencedor = this.ja;
                    ja.alteraPartidasJogador();
                    arq.write("Jogador A Venceu a Partida!\n");
                    arq.write("Placar de Sets Final: " + this.setsJa + " x " + this.setsJb);
                    arq.write("\n");
                    arqGerais.write("O jogador A venceu " + this.setsJa + " sets nessa partida\n");
                    arqGerais.write("O jogador B venceu " + this.setsJb + " sets nessa partida\n");
                    break;
                } else if (this.setsJb >= this.setsJa + 2) {
                    // B venceu
                    this.totalDEPontos += set.totalDEPontos;
                    this.vencedor = this.jb;
                    jb.alteraPartidasJogador();
                    arq.write("Jogador B Venceu a Partida!\n");
                    arq.write("Placar de Sets Final: " + this.setsJa + " x " + this.setsJb);
                    arq.write("\n");
                    arqGerais.write("O jogador A venceu " + this.setsJa + " sets nessa partida\n");
                    arqGerais.write("O jogador B venceu " + this.setsJb + " sets nessa partida\n");
                    break;
                }
                //Terceiro Set para desempatar
                else if (this.setsJa == 1 && this.setsJb == 1) {
                    arq.write("Set " + 3 + ":");
                    arq.write("\n");
                    teve3Sets = true;
                    //reseta games e pontos
                    set.setGames(0, 0, true);
                    set.resetPontos();
                    set.simula(arq,arqGerais);
                    this.vencedor = set.getVencedor();
                    totalGames += set.getTotalDEGames();
                    if (this.vencedor == this.ja) {
                        //A venceu
                        this.totalDEPontos += set.totalDEPontos;
                        this.setsJa++;
                        ja.alteraPartidasJogador();
                        arq.write("\n");
                        arq.write("Jogador A Venceu a Partida!\n");
                        arq.write("Placar Sets: " + this.setsJa + " x " + this.setsJb);
                        arq.write("\n");
                        totalPontosA += set.getPontosA();
                        totalPontosB += set.getPontosB();
                        arqGerais.write("O jogador A fez " + set.getPontosA() + " pontos nesse set\n");
                        arqGerais.write("O jogador B fez " + set.getPontosB() + " pontos nesse set\n");
                        arqGerais.write("\n");
                        arqGerais.write("O jogador A venceu " + this.setsJa + " sets nessa partida\n");
                        arqGerais.write("O jogador B venceu " + this.setsJb + " sets nessa partida\n");
                        break;
                    } else {
                        //B venceu partida
                        this.totalDEPontos += set.totalDEPontos;
                        this.setsJb++;
                        jb.alteraPartidasJogador();
                        arq.write("\n");
                        arq.write("Jogador B Venceu a Partida!\n");
                        arq.write("Placar Sets: " + this.setsJa + " x " + this.setsJb);
                        arq.write("\n");
                        totalPontosA += set.getPontosA();
                        totalPontosB += set.getPontosB();
                        arqGerais.write("O jogador A fez " + set.getPontosA() + " pontos nesse set\n");
                        arqGerais.write("O jogador B fez " + set.getPontosB() + " pontos nesse set\n");
                        arqGerais.write("\n");
                        arqGerais.write("O jogador A venceu " + this.setsJa + " sets nessa partida\n");
                        arqGerais.write("O jogador B venceu " + this.setsJb + " sets nessa partida\n");
                        break;
                    }
                }
                this.totalDEPontos += set.totalDEPontos;
            }//fim do while
            if(teve3Sets){
                this.totalSets = 3;
            } else {
                this.totalSets = 2;
            }
            arqGerais.write("\n");
            arqGerais.write("Ocorreram um total de " + this.totalSets + " sets\n");
            arqGerais.write("Ocorreram um total de " + totalGames + " games\n");
            arqGerais.write("O jogador A fez um total de " + totalPontosA + " pontos\n");
            arqGerais.write("O jogador B fez um total de " + totalPontosB + " pontos\n");
            arqGerais.write("Ocorreram um total de " + (totalPontosA+totalPontosB) + " pontos\n");
            arqGerais.write("O jogador " + this.vencedor.getNome() + " venceu a partida!\n");
            arqGerais.write("\n");
            arq.write("\n");
        } catch (Exception e) {
            throw new IOException();
        }
    }

    public String getVencedor() {
        return this.vencedor.getNome();
    }

    public int getTotalSets(){
        return this.totalSets;
    }

    public int getTotalPontos(){
        return this.totalDEPontos;
    }

    public void setSets(int a, int b) {
        this.setsJa = a;
        this.setsJb = b;
    }


}