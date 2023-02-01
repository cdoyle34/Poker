import java.util.Random;
public class Cards {
    private int suit;
    private int value;

    public String suitName;

    public String valueName;

    public Cards() {
        this.suit = 1;
        this.value =1;
    }
    public Cards(String name){
        suit = 0;
        value = 0;
        suitName = name;
        valueName = "";
    }
    public Cards (int suit, int value, String suitName, String valueName){
        suit = 0;
        value = 0;
        suitName = "unknown";
        valueName = "unknown";
    }
    public void randomCard() {
        Random rndm = new Random();
        this.suit = rndm.nextInt(4);
        this.value = rndm.nextInt(13) + 1;
        if (suit == 0){
            suitName = "Clubs";
        }
        else if (suit == 1){
            suitName = "Diamonds";
        }
        else if (suit == 2){
            suitName = "Hearts";
        }
        else if (suit == 3){
            suitName = "Spades";
        }
        if (value == 1){
            valueName = "Ace of ";
        }
        else if (value == 2){
            valueName = "Two of ";
        }
        else if (value == 3){
            valueName = "Three of ";
        }
        else if (value == 4){
            valueName = "Four of ";
        }
        else if (value == 5){
            valueName = "Five of ";
        }
        else if (value == 6){
            valueName = "Six of ";
        }
        else if (value == 7){
            valueName = "Seven of ";
        }
        else if (value == 8){
            valueName = "Eight of ";
        }
        else if (value == 9){
            valueName = "Nine of ";
        }
        else if (value == 10){
            valueName = "Ten of ";
        }
        else if (value == 11){
            valueName = "Jack of ";
        }
        else if (value == 12){
            valueName = "Queen of ";
        }
        else if (value == 13){
            valueName = "King of ";
        }


        System.out.println(valueName + suitName);
    }

    public void printExtraCard(){
        Cards extraCard = new Cards();
        System.out.println("The extra card is.... ");
        extraCard.randomCard();
    }

    public void fiveCardinHand(){
        Cards extraCard1 = new Cards();
        Cards extraCard2 = new Cards();
        Cards extraCard3 = new Cards();
        Cards extraCard4 = new Cards();
        Cards extraCard5 = new Cards();
        System.out.println("The five cards in hand are... ");
        extraCard1.randomCard();
        extraCard2.randomCard();
        extraCard3.randomCard();
        extraCard4.randomCard();
        extraCard5.randomCard();
    }

    public void printTwoExtraCards(){
        Cards extraCard10 = new Cards();
        Cards extraCard11 = new Cards();
        System.out.println("The two extra Cards are... ");
        extraCard10.randomCard();
        extraCard11.randomCard();
    }

    public static void main(String [] args){

    }










}
