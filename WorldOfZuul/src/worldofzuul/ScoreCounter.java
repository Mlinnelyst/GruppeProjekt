/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author bodeval
 */
public class ScoreCounter {
    private int score;

    public void addScore(int amount) {
        score += amount;
    }
    
    public void decreaseScore(int amount) {
        score -= amount;
        
    }
    
    public void printScore() {
        System.out.println("Score is " + score);
    }
    
}
