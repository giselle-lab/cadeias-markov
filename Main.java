import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // PARTIDA 1
		double p = 0.76;
        double q = 1 - p;

        Jogador jA = new Jogador("A", p);
        Jogador jB = new Jogador("B", q);
        Partida partida1 = new Partida(jA, jB);

        String filePath = "../cadeias-markov/Test/";
        String fileName= "Partida1_Simu";
        String fileType = "txt";

        String fileName1Gerais = "Infos_Gerais_Partida1";
        FileWriter estatisticasGerais1 = new FileWriter(filePath+fileName1Gerais+"."+fileType);
        estatisticasGerais1.write("PARTIDA 1\n");
        estatisticasGerais1.write("\n");
        estatisticasGerais1.write("Probabilidade do Jogador A fazer ponto:" + jA.getProbabilidade() + "\n");
        estatisticasGerais1.write("Probabilidade do Jogador B fazer ponto:" + jB.getProbabilidade() + "\n"); 
        estatisticasGerais1.write("\n");

        int i = 1;
        int m = 30;
        for (; i <= m; i++) {
            FileWriter myFile = new FileWriter(filePath+fileName+i+"."+fileType);
            myFile.write("PARTIDA 1\n");
            myFile.write("\n");
            myFile.write("Probabilidade do Jogador A fazer ponto:" + jA.getProbabilidade() + "\n");
            myFile.write("Probabilidade do Jogador B fazer ponto:" + jB.getProbabilidade() + "\n");            
            myFile.write("\n");
            myFile.write("Simulação " + i + ":\n");
            estatisticasGerais1.write("Simulação " + i + ":");
            estatisticasGerais1.write("\n");
            partida1.simula(myFile,estatisticasGerais1);
            myFile.close();
            //reseta sets e pontos
            partida1.totalDEPontos = 0;
            partida1.setSets(0, 0); 
        }
        estatisticasGerais1.write("PARTIDAS TOTAIS:");
        estatisticasGerais1.write("\n");
        partida1.getJogadorA().imprimePartidas(estatisticasGerais1);
        partida1.getJogadorB().imprimePartidas(estatisticasGerais1);
        estatisticasGerais1.close();

        // PARTIDA 2
        
        double p2 = 0.53;
        double q2 = 1 - p2;

        Jogador jA2 = new Jogador("A", p2);
        Jogador jB2 = new Jogador("B", q2);
        Partida partida2 = new Partida(jA2, jB2);

        String filePath2 = "../cadeias-markov/Test/"";
        String fileName2= "Partida2_Simu";
        String fileType2 = "txt";

        String fileName2Gerais = "Infos_Gerais_Partida2";
        FileWriter estatisticasGerais2 = new FileWriter(filePath+fileName2Gerais+"."+fileType);
        estatisticasGerais2.write("PARTIDA 2:\n");
        estatisticasGerais2.write("\n");
        estatisticasGerais2.write("Probabilidade do Jogador A2 fazer ponto:" + jA2.getProbabilidade() + "\n");
        estatisticasGerais2.write("Probabilidade do Jogador B2 fazer ponto:" + jB2.getProbabilidade() + "\n");
        estatisticasGerais2.write("\n");

        int j = 1;
        int k = 30;
        for (; j <= k; j++) {
            FileWriter myFile2 = new FileWriter(filePath2+fileName2+j+"."+fileType2);
            myFile2.write("PARTIDA 2:\n");
            myFile2.write("\n");
            myFile2.write("Probabilidade do Jogador A fazer ponto:" + jA2.getProbabilidade() + "\n");
            myFile2.write("Probabilidade do Jogador B fazer ponto:" + jB2.getProbabilidade() + "\n");
            myFile2.write("\n");
            myFile2.write("Simulação " + j + ":\n");
            estatisticasGerais2.write("Simulação " + j + ":");
            estatisticasGerais2.write("\n");
            partida2.simula(myFile2,estatisticasGerais2);
            myFile2.close();
            // reseta sets e pontos
            partida2.totalDEPontos = 0;
            partida2.setSets(0, 0);
        }
        estatisticasGerais2.write("PARTIDAS TOTAIS:");
        estatisticasGerais2.write("\n");
        partida2.getJogadorA().imprimePartidas(estatisticasGerais2);
        partida2.getJogadorB().imprimePartidas(estatisticasGerais2);
        estatisticasGerais2.close();
    }
}
