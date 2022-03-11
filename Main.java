import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // gera uma probabilidade com 0.7 <= p <= 0.8 do jogador A ganhar
        double min = 0.7;
        double max = 0.8;
        double p = (double) ((Math.random() * (max - min)) + min);
        p = Math.round(p * 100.0) / 100.0;
        double q = 1 - p;

        Jogador jA = new Jogador("A", p);
        Jogador jB = new Jogador("B", q);
        Partida partida1 = new Partida(jA, jB);

        /// PARTIDA 1
        String filePath = "../cadeias-markov/Test/";
        String fileName= "Partida1_Simu_";
        String fileType = "txt";


        int i = 1;
        for (; i <= 30; i++) {
            FileWriter myFile = new FileWriter(filePath+fileName+i+"."+fileType);
            myFile.write("PARTIDA 1\n");
            myFile.write("Probabilidade do Jogador A fazer ponto:" + jA.getProbabilidade() + "\n");
            myFile.write("Probabilidade do Jogador B fazer ponto:" + jB.getProbabilidade() + "\n");            
            myFile.write("Simulação " + i + ":\n");
            myFile.write("\n");
            partida1.simula(myFile);
            myFile.close();
            //reseta sets
            partida1.setSets(0, 0);
        }

        // PARTIDA 2

        // gera uma probabilidade com 0.45 <= p <= 0.55 do jogador A ganhar
        double min2 = 0.45;
        double max2 = 0.55;
        double p2 = (double) ((Math.random() * (max2 - min2)) + min2);
        p2 = Math.round(p2 * 100.0) / 100.0;
        double q2 = 1 - p2;

        Jogador jA2 = new Jogador("A2", p2);
        Jogador jB2 = new Jogador("B2", q2);
        Partida partida2 = new Partida(jA2, jB2);

        

        String filePath2 = "../cadeias-markov/Test/";
        String fileName2= "Partida2_Simu_";
        String fileType2 = "txt";

        int j = 1;
        for (; j <= 30; j++) {
            FileWriter myFile2 = new FileWriter(filePath2+fileName2+j+"."+fileType2);
            myFile2.write("PARTIDA 2:\n");
            myFile2.write("Probabilidade do Jogador A fazer ponto:" + jA2.getProbabilidade() + "\n");
            myFile2.write("Probabilidade do Jogador B fazer ponto:" + jB2.getProbabilidade() + "\n");
            myFile2.write("Simulação " + j + ":\n");
            myFile2.write("\n");
            partida2.simula(myFile2);
            myFile2.close();
            // reseta sets
            partida2.setSets(0, 0);
        }
    }
}
