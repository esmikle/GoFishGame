package ca.sheridancollege.project;

public class GoFishCard extends Card {

    protected int rank;
    protected String suit;
    
    @Override
    public String toString() {
        return rank+" of "+suit;
    }
    
}