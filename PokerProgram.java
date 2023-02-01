/*
@file PokerProgram.java
@brief this program implements all the classes to create the game, using all the methods that have been created on display to come
       together and play the poker game that has been created.
@author Cameron Doyle
@data November 29th, 2022
 */
//This is the program class.
import java.util.Scanner;
public class PokerProgram {
public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    boolean playAgain = true;               //Boolean variable used to see if user wants to play again
    String r = "unknown";
    String z = "unknown";
    Cards extraCardsFive = new Cards();     //Cards class used to access all other methods for other variations of poker.
    while (playAgain = true) {              //While loop used with boolean to see if user wants to play again
        Workings game1 = new Workings();            //Workings class used to create game1 object to start the game.
        Players players = new Players();            //Players class used to create players object to access those methods.
        players.setPlayer1("Jack");                 //Players names are set to jack and jill
        players.setPlayer2("Jill");
        players.givePlayersCards();
        System.out.println("Jack goes first, would you like to bet or check? (input check, bet)");      //Asks user what the first action to be taken will be
        r = scnr.next();
        if (r.equals("check")) {                        //If action is check the check method within workings will run
            game1.Check();
        } else if (r.equals("bet")) {
            game1.Bet();                                //Else if action is bet the bet method within workings will run
        }
        System.out.println("There may have been an error in your input, but if not...");        //Tells the user they have an error if they input something wrong
        System.out.println("Would you like to play again?(yes/no)");                        //Asks user if they want to play again
        z = scnr.next();

        if (z.equals("yes")){               //.Equals used with string variable z to then set boolean to true to play again or not
            playAgain = true;
        }
        else if (z.equals("no")){
            playAgain = false;
            break;
        }
    }

    extraCardsFive.printExtraCard();            //Shows other methods that could be used with workings class to play other variations of poker.
    extraCardsFive.printTwoExtraCards();
    extraCardsFive.fiveCardinHand();



}
}
