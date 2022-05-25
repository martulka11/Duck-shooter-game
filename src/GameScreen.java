import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class GameScreen extends JPanel{

    private JLabel labelTime = new JLabel("0");
    private JLabel labelScore = new JLabel("0");
    public static int start = 0;
    public static int score = 0;

    public static List<Duck> listOfDuck = new LinkedList<>();


    public GameScreen(){

        Duck duck1  = new Duck("/red-duck.png",  100, 60, 60, 10);
        Duck duck2  = new Duck("/blue-duck.png",  200, 70, 70, 20);
        Duck duck3  = new Duck("/green-duck.png",  400, 70, 70, 5);
        Duck duck4  = new Duck("/yellow-duck.png",  150, 30, 30, 10);
        Duck duck5  = new Duck("/red-duck.png",  500, 70, 70, 10);

        listOfDuck.add(duck1);
        listOfDuck.add(duck2);
        listOfDuck.add(duck3);
        listOfDuck.add(duck4);
        listOfDuck.add(duck5);

        // this.setLayout(null);

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(int i = 0; i < listOfDuck.size(); i++) {
                    g.drawImage(listOfDuck.get(i).getImage(), listOfDuck.get(i).getX(), listOfDuck.get(i).getY(), null);
                }
            }
        };

        this.add(pane);

       // labelTime.setLocation(450, 800);
        //this.add(labelTime);



        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        labelTime.setText(String.valueOf(start));
                        labelScore.setText(String.valueOf(score));
                        repaint();
                    }
                }
        ).start();

       // this.setBackground(Color.WHITE);
        // this.setSize(1200, 900);
    }


    public void startCounter() {
        new Thread(
                () -> {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                           start++;
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }


//jakbym tutaj dodala metode dodajaca kaczki??


    public void zapisWynikow(String sciezkapliku) {
        try {
            FileWriter fileWriter = new FileWriter(sciezkapliku);
            fileWriter.write(MyFrame.listOfPlayer.toString());
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void gameOverJDialog(){
        JDialog dialog = new JDialog(new Frame(), "Info Frame");
        JLabel lab = new JLabel("Game Over");
        dialog.add(lab);
        dialog.setSize(300, 200);
        dialog.setVisible(true);
    }

/*
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Duck duck : listOfDuck) {
            Graphics2D g2d = (Graphics2D) g;
            duck.paint(g2d);
            g2d.dispose();
        }
/*
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        g2.draw(lin);
    }

*/

}

