package ca.sheridancollege.project;

public class GoFishPlayer extends Player {

    private int numOfSets;
    
    public GoFishPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {

    }
    
    @Override
    public void addToScore(){
        this.score += 1;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void addToSets(){
        numOfSets += 1;
    }
    
    public int getSets(){
        return numOfSets;
    }
    
    
    
    
}