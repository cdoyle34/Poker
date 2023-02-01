import java.util.Scanner;
public class Players extends Cards{
    protected String player1;
    protected String player2;
    Cards player1Card = new Cards();
    Cards player2Card = new Cards();
    Cards flopCard1 = new Cards();
    Cards flopCard2 = new Cards();
    Cards flopCard3 = new Cards();
    Cards turnCard = new Cards();
    Cards riverCard = new Cards();


    public Players(){
        player1 = "unknown";
        player2 = "unknown";
    }

    public Players(String playerName1, String playerName2){
        player1 = playerName1;
        player2 = playerName2;
    }

    public void setPlayer1(String playerName1){
        player1 = playerName1;
    }
    public void setPlayer2(String playerName2){
        player2 = playerName2;
    }

    public void givePlayersCards(){

        System.out.println (player1 + "'s cards are...");
        super.randomCard();
        super.randomCard();
        System.out.println();
        System.out.println(player2 + "'s cards are...");
        super.randomCard();
        super.randomCard();

    }

    public void makeFlop(){

        System.out.println("The flop is...");
        flopCard1.randomCard();
        flopCard2.randomCard();
        flopCard3.randomCard();
    }

    public void makeTurn(){
        System.out.println("The turn is...");

        turnCard.randomCard();
    }

    public void makeRiver(){
        System.out.println("The river is...");

        riverCard.randomCard();
    }

    public static void main(String[] args){

    }


}
