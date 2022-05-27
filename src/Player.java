import java.io.*;

public class Player implements Serializable {

    private transient int score;
    private String name;
    private transient int time;
    public  transient static int livesPlayer = 3;
    private long totalScore;


    public Player(String name ) {
        this.name = name;
        this.score = 20;//GameScreen.score;
        this.time = 40; //GameScreen.start;
        this.totalScore = score * time;
        MyFrame.listOfPlayer.add(this);
        System.out.println(name + totalScore);

    }

    public static void zapisWynikow (Player player){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/document.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
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
/*
                try {
            FileWriter fileWriter = new FileWriter(sciezkapliku);
            fileWriter.write(MyFrame.listOfPlayer.toString());
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

