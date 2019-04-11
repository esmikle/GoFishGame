package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame extends Game {

    public GoFishGame(){
        super("Go Fish");
    }
    
    @Override
    public void play() {
    // Starting Game: Elizabeth 
        Scanner in = new Scanner(System.in);
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        String [] suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
        int numOfPlayers = 0;
        // Create deck and player arraylist with names given by user (2 - 4 players)
        System.out.println("Welcome to Go Fish!");
        while(numOfPlayers < 2 || numOfPlayers > 4){
            System.out.println("Enter number of players (2 - 4):");
            numOfPlayers = in.nextInt();
        }
        GroupOfCards deck = new GroupOfCards(52);
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter name for player "+i+1);
            String name = in.nextLine();
            GoFishPlayer player = new GoFishPlayer(name);
            players.add(player);
        }
        
        // Initialize deck with 52 cards
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < 13; j++) {
                GoFishCard c = new GoFishCard(j+1, suits[i]);
                deck.addCard(c);
            }
        }
        deck.shuffle();
        
        // Deal 4 cards to each player
        for (int i = 0; i < 4; i++) {
            for(GoFishPlayer p : players){
                Card c = deck.giveCard(0);
                p.hand.addCard(c);
            }
        }
        
        // Choose random player to start
        
    // Playing Game:  John and Elizabeth  
        // Display player hand numbered as options ex. 1) four of hearts
        
        // Player chooses a card and another player to ask for the card (For ease players can be numbered)
        
        /* If the other player has the card it will be given to the player whose asked
             a) Player can continue their turn and ask for another card
             b) Else player will receive a "Go Fish" message (Signifys end of turn)*/
        
        // When a set of cards is completed it is removed from player's hand (discarded)
        
    // Score Keeping: Gary
        // Player round scores should be displayed at all times (round score = number of sets made)
        
        // Player round score should be automatically increased when they complete a set of cards
            
        // Player game score should display after each round (max of 5 rounds) (game score = number of rounds won)
        
        // At any point if user chooses to quit show the final game score
        
    }

    @Override
    public void declareWinner() {
        // Gary
    }
    
}