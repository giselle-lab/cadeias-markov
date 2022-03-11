
public class Main {

    public static void main(String[] args) {
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
        System.out.println("PARTIDA 1");
        System.out.println("Probabilidade do Jogador A fazer ponto:" + jA.getProbabilidade());
        System.out.println("Probabilidade do Jogador B fazer ponto:" + jB.getProbabilidade());

        int i = 1;
        for (; i <= 30; i++) {
            System.out.println("Simulação " + i + ":");
            System.out.println();
            partida1.simula();
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

        System.out.println("PARTIDA 2:");
        System.out.println("Probabilidade do Jogador A fazer ponto:" + jA2.getProbabilidade());
        System.out.println("Probabilidade do Jogador B fazer ponto:" + jB2.getProbabilidade());

        int j = 1;
        for (; j <= 30; j++) {
            System.out.println("Simulação " + j + ":");
            System.out.println();
            partida2.simula();
            // reseta sets
            partida2.setSets(0, 0);
        }
    }
}
