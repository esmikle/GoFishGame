package ca.sheridancollege.project;

public class GoFishCard extends Card {

    protected int rank;
    protected String suit;
    
    public GoFishCard (int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    @Override
    public String toString() {
        return rank+" of "+suit;
    }
    
}