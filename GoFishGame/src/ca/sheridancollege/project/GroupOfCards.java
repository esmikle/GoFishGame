/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<GoFishCard> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        size = givenSize;
        cards = new ArrayList<>();
    }
    
    public ArrayList<GoFishCard> getCards() {
        return cards;
    }
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public void showCards() {
        int i = 0;
        for (Card c : cards) {
            System.out.println(i+") "+c.toString());
            i++;
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

    public void addCard(GoFishCard card) {
        cards.add(card);
    }
    
    public GoFishCard printCard(int index){
        return cards.get(index);
    }

    public GoFishCard giveCard(int index) {
        return cards.remove(index);
    }

    public void isFourOfKind() {
        /* Checks if group of cards contains 4 of any rank and removes 
            them while increasing player set score */
        int counter = 0;
        int rank = 0;
        for (Card c : cards) {
            for (int i = 0; i < cards.size(); i++) {
                if (c.rank == cards.get(i).rank) {
                    counter += 1;
                    rank = c.rank;
                }
            }
            if (counter == 4) {
                System.out.println("Four of kind found for rank " + rank);
            }
        }
        
        for(GoFishCard c : cards){
            if(rank == c.rank){
                cards.remove(c);
            }
        }
    }

}//end class
