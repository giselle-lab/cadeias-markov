import java.util.ArrayList;

public class Set {
    ArrayList<Game> games = new ArrayList<>();
    Jogador vencedor;
    Jogador ja, jb;
    int gamesA;
    int gamesB;

    public Set(Jogador ja, Jogador jb){
        this.ja = ja;
        this.jb = jb;
        this.gamesA = 0;
        this.gamesB = 0;
    }

    public void simula() {
        while(true) {
            Game game = new Game(this.ja,this.jb);
            games.add(game);
            game.simula();
            this.vencedor = game.getVencedor();
            if(this.vencedor == this.ja) {
                this.gamesA++;
                System.out.println("Jogador A pontua: "+ gamesA + "game(s)");

            }

            else {
                this.gamesB++;
                System.out.println("Jogador B pontua: "+ gamesA + "game(s)");

            }
            if(this.gamesA > this.gamesB + 2 && this.gamesA >= 6) {
                // A venceu
                this.vencedor = this.ja;
                System.out.println("Jogador A Venceu Set!");
                System.out.println("Games: "+ this.gamesA + " x " + this.gamesB);
                break;
            }
            else if (this.gamesB > this.gamesA + 2 && this.gamesB >= 6) {
                // B venceu
                this.vencedor = this.jb;
                System.out.println("Jogador B Venceu Set!");
                System.out.println("Games: "+ this.gamesA + " x " + this.gamesB);
                break;
            }
            //tie break: Ganha quem ganhar o game 7
            else if(this.gamesA == 6 && this.gamesB == 6){
                if(this.gamesA == this.gamesB + 1){
                    //A venceu
                    this.vencedor = this.ja;
                    System.out.println("Jogador A Venceu Tie Break!");
                    System.out.println("Games: "+ this.gamesA + " x " + this.gamesB);
                    break;
                } 
                else{
                    //B venceu
                    this.vencedor = this.jb;
                    System.out.println("Jogador B Venceu Tie Break!");
                    System.out.println("Games: "+ this.gamesA + " x " + this.gamesB);
                    break;
                }
            }
            System.out.println();

        }
    } 

    public Jogador getVencedor() {
        return this.vencedor;
    }

}