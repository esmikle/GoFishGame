package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame extends Game {

    Scanner in = new Scanner(System.in);
    ArrayList<GoFishPlayer> players = new ArrayList<>();
    GroupOfCards deck = new GroupOfCards(52);
    String[] suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    int numOfPlayers = 0;

    public GoFishGame() {
        super("Go Fish");
    }

    @Override
    public void play() {

        // Choose random player to start
        int random = (int) (Math.random() * numOfPlayers);
        System.out.println("Player " + (random + 1) + ": " + players.get(random).getPlayerID() + " will go first ");

        players.get(random).hand.showCards();
        players.get(random).hand.isFourOfKind();
        
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
  
    public void dealToPlayers() {
        // Deal 4 cards to each player
        for (int i = 0; i < 4; i++) {
            for (GoFishPlayer p : players) {
                GoFishCard c = deck.giveCard(0);
                p.hand.addCard(c);
            }
        }
    }

    public void initializeDeck() {
        // Initialize deck with 52 cards
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < 13; j++) {
                GoFishCard c = new GoFishCard(j + 1, suits[i]);
                deck.addCard(c);
            }
        }
        deck.shuffle();
    }

    public void initializePlayers() {
        // Create deck and player arraylist with names given by user (2 - 4 players)
        System.out.println("Welcome to Go Fish!");
        while (numOfPlayers < 2 || numOfPlayers > 4) {
            System.out.println("Enter number of players (2 - 4):");
            numOfPlayers = in.nextInt();
        }
        in.nextLine();
        
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1));
            String name = in.nextLine();
            GoFishPlayer player = new GoFishPlayer(name);
            players.add(player);
        } 
    }

    @Override
    public void declareWinner() {
       int roundScore = 0;
       String winner = "";
       for(GoFishPlayer p : players){
           if(p.getScore() > roundScore){
               roundScore = p.getScore();
               winner = p.getPlayerID();
           }
       }
       System.out.println(winner+" wins the game!"); 
    }
    
    public void declareRoundWinner(){
        String winner = "";
        int i = 0;
        int highestSets = 0;
        for(GoFishPlayer p : players){
            if(p.getSets() > highestSets){
                highestSets = p.getSets();
                winner = p.getPlayerID();
            }
        }
        System.out.println("The winner of the round is "+winner);
        for(GoFishPlayer p : players){
            if(winner.equals(p.getPlayerID())){
                p.addToScore();
            }
        }
    }

}
