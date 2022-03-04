import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      Jogador j1 = new Jogador("j1",0.8);
      Jogador j2 = new Jogador("j2",0.6);
      Jogo jogo = new Jogo(j1,j2);

      System.out.println(j1.getSetJogador());
      System.out.println(j2.getNome());
      //variaveis aleatorias ao longo do tempo
      //matriz de transição
      //repetir ate que um jogador ganhe
    }
  }