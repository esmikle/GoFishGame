package ca.sheridancollege.project;

public class GoFishGame extends Game {

    public GoFishGame(){
        super("Go Fish");
    }
    
    @Override
    public void play() {
    // Starting Game: Elizabeth 
        // Create deck and player arraylists with names given by user (2 - 4 players)
        
        // Initialize deck with 52 cards
        
        // Deal 4 cards to each player
        
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