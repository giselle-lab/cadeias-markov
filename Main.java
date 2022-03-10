import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
//import org.json.simple.JSONObject;

//public class CreatingJSONDocument {
    public class Main{
    
        public static void main (String[] args) {
            
            //JSONObject obj = new JSONObject();
            //obj.put("titulo", "Análise Partidas");
            //obj.put("Partida",1);
            
            
            double min= 0.7;
            double max = 0.8;
            //gera uma probabilidade com 0.7 <= p <= 0.8 do jogador A ganhar
            double p =  (double) ((Math.random() * (max - min)) + min);
            p = Math.round(p * 100.0) / 100.0;
            double q = 1-p;
            Jogador jA = new Jogador("ja",p);
            Jogador jB = new Jogador("jb",q);
            Partida partida1 = new Partida(jA,jB);
            ///PATIDA 1
            System.out.println("PARTIDA 1");

            int i = 1;
            for(; i<=3;i++){
                partida1.simula();
                System.out.println(partida1.getVencedor());
                System.out.println("Simulação" + i);
            }
            


            //my_obj.put("Partida",2);
            //PARTIDA 2
            /*double min2 = 0.45;
            double max2 = 0.55;
            //gera uma probabilidade com 0.45 <= p <= 0.55 do jogador A ganhar
            double p2 =  (double) ((Math.random() * (max2 - min2)) + min2);
            p2 = Math.round(p * 100.0) / 100.0;
            double q2 = 1-p2;
            Jogador jA2 = new Jogador("ja2",p2);
            Jogador jB2 = new Jogador("jb2",q2);
            Partida partida2 = new Partida(jA2,jB2);
            partida2.simula();
            //System.out.println(partida2.getVencedor());*/
        }
    }
//}