package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame extends Game {
    
    Scanner in = new Scanner(System.in);
    ArrayList<GoFishPlayer> players = new ArrayList<>();
    GroupOfCards deck = new GroupOfCards(0);
    String[] suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    int numOfPlayers = 0;
    boolean round = true;

    public GoFishGame() {
        super("Go Fish");
    }
    
    @Override
    public void play() {
        while (round) {
            // Choose random player to start
            int random = (int) (Math.random() * numOfPlayers);
            System.out.println("Player " + (random + 1) + ": " + players.get(random).getPlayerID() + " will go first ");

            // Display player hand numbered as options ex. 1) four of hearts
            players.get(random).hand.isFourOfKind();
            // Playing Game:  John and Elizabeth  

            // Player chooses a card and another player to ask for the card (For ease players can be numbered)
            while (deck.getSize() > 0) {
                System.out.println(players.get(random).getPlayerID() + "'s turn");
                System.out.println("Choose a card from your hand:");
                players.get(random).hand.showCards();
                int choiceCard = checkChoiceCard(random);
                System.out.println("Choose a player to ask:");
                int i = 0;
                for (GoFishPlayer p : players) {
                    if (random != i) {
                        System.out.println(i + ") " + p.getPlayerID());
                    }
                    i++;
                }
                int choicePlayer = checkChoicePlayer();
                int cardAsked = players.get(random).hand.printCard(choiceCard).rank;
                GroupOfCards playerAsked = players.get(choicePlayer).hand;
                System.out.println("You chose " + players.get(choicePlayer).getPlayerID() + " for the " + cardAsked);
                scanForCard(playerAsked, cardAsked, random, choicePlayer);

                // When a set of cards is completed it is removed from player's hand (discarded)
                players.get(random).hand.isFourOfKind();
                players.get(random).hand.showCards();
                System.out.println("End of Turn");
                
                if (random == players.size() - 1) {
                    random = 0;
                } else {
                    random++;
                }
                
            }
            declareRoundWinner();
            roundCheck();
        }
        declareWinner();
    }

    public int checkChoicePlayer() {
        int choicePlayer = in.nextInt();
        while(choicePlayer > players.size() || choicePlayer < 0){
            System.out.println("Not a valid player");
            choicePlayer = in.nextInt();
        }
        return choicePlayer;
    }

    public int checkChoiceCard(int random) {
        int choiceCard = in.nextInt();
        while(choiceCard > players.get(random).hand.getSize() || choiceCard < 0){
            System.out.println("Not a valid card");
            choiceCard = in.nextInt();
        }
        return choiceCard;
    }

    public void roundCheck() {
        System.out.println("Would you like to play another round?(yes/no)");
        String anotherRound = in.nextLine();
        if (anotherRound.equals("no")) {
            round = false;
            
        } else {
            round = true;
        }
    }

    public void scanForCard(GroupOfCards playerAsked, int cardAsked, int random, int choicePlayer) {
        /* If the other player has the card it will be given to the player whose asked
        a) Player can continue their turn and ask for another card
        b) Else player will receive a "Go Fish" message (Signifys end of turn)*/
        int counter = 0;
        for (GoFishCard c : playerAsked.cards) {
            System.out.println("c.rank = " + c.rank + " cardAsked = " + cardAsked);
            if (c.rank == cardAsked) {
                System.out.println("Card Matched");
                players.get(random).hand.addCard(c);
                players.get(choicePlayer).hand.cards.remove(c);
                break;
            }
            if (counter == playerAsked.cards.size() - 1) {
                System.out.println("Go Fish");
                GoFishCard b = deck.giveCard(0);
                players.get(random).hand.addCard(b);
                break;
            }
            counter++;
        }
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
        for (GoFishPlayer p : players) {
            if (p.getScore() > roundScore) {
                roundScore = p.getScore();
                winner = p.getPlayerID();
            }
        }
        System.out.println(winner + " wins the game!");
    }
    
    public void declareRoundWinner() {
        String winner = "";
        int i = 0;
        int highestSets = 0;
        for (GoFishPlayer p : players) {
            if (p.getSets() > highestSets) {
                highestSets = p.getSets();
                winner = p.getPlayerID();
            }
        }
        System.out.println("The winner of the round is " + winner);
        for (GoFishPlayer p : players) {
            if (winner.equals(p.getPlayerID())) {
                p.addToScore();
            }
        }
    }
    
}
