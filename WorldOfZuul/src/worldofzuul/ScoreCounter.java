package worldofzuul;

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
