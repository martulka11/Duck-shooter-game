import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Player implements Serializable {

    private transient int score;
    private String name;
    private transient int time;
    public transient static int livesPlayer = 10;
    private long totalScore;


    public Player(String name) {
        super();
        this.name = name;
        this.score = GameScreen.score;
        this.time = GameScreen.start;
        this.totalScore = score * time;
        MyFrame.listOfPlayer.add(this);


        savePlayer("D:\\kaczki.txt");
    }


    public void savePlayer (String pathname){
        try {
            FileOutputStream fileOut = new FileOutputStream(pathname);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(int i = 0 ; i < MyFrame.listOfPlayer.size() ; i++) {
            out.writeObject(MyFrame.listOfPlayer.get(i).toString());
            }
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved ");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Total Score: " + totalScore + '\n';
    }
}
