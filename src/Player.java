import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Player {

    private int score;
    private String name;
    private int time;
    private int lives;
    private int totalScore;


    public Player(String name){
        this.name = name;
        this.score = GameScreen.score;
        this.time = GameScreen.start;
        this.lives = 10;
        this.totalScore = score*time;
        MyFrame.listOfPlayer.add(this);
    }



    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Total Score: " + totalScore + '\n';
    }
}
