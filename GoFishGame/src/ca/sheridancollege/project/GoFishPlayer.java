package ca.sheridancollege.project;

public class GoFishPlayer extends Player {
    
    private int numOfSets;
    GroupOfCards hand = new GroupOfCards(0);;
    
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
    
    public void displayScore(){
        System.out.println("Rounds won = "+score);
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void addToSets(){
        numOfSets += 1;
    }
    
    public void displaySets(){
        System.out.println("Num of Sets made = "+numOfSets);
    }
    
    public int getSets(){
        return numOfSets;
    }
    
    
    
    
}