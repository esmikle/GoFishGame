/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author elizabethsmikle
 */
public class Main {
    public static void main (String [] args){
        GoFishGame game = new GoFishGame();
        game.initializeDeck();
        game.initializePlayers();
        game.dealToPlayers();
        game.play();
    }
}
