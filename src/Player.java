import java.io.*;


public class Player implements Serializable {
    private static final long serialVersionUID = 1244017908663480771L;

    private transient int score;
    private String name;
    private transient int time;
    public transient static int livesPlayer = 10;
    private long totalScore;


    public Player(String name) {
        this.name = name;
        this.score = GameScreen.score;
        this.time = GameScreen.start;
        this.totalScore = score * time;
        MyFrame.listOfPlayer.add(this);

        savePlayer("/document.txt");
    }

    public long getTotalScore() {
        return totalScore;
    }

    public void savePlayer (String pathname){
        try {
            FileOutputStream fileOut = new FileOutputStream(pathname);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(MyFrame.listOfPlayer);
            out.close();
            fileOut.close();
            System.out.printf("Data is saved");
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
