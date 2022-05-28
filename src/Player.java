import java.io.*;

public class Player implements Serializable {

    private transient int score;
    private String name;
    private transient int time;
    public  transient static int livesPlayer = 3;
    private long totalScore;


    public Player(String name ) {
        this.name = name;
        this.score = GameScreen.score;
        this.time = GameScreen.start;
        this.totalScore = score * time;
        MyFrame.listOfPlayer.add(this);
        System.out.println(name + totalScore);

        savePlayer("D:\\kaczki.txt");
    }

    public static void savePlayer (String sciezkapliku){
        try {
            FileOutputStream fileOut = new FileOutputStream(sciezkapliku);
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
    }*/

