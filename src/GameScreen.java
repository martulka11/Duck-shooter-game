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

    private JButton button1;
    private JLabel labelTime = new JLabel("0");
    private JLabel labelScore = new JLabel("0");
    public static int start = 0;
    public static int score = 0;
   // public Line2D lin;

    public static List<Duck> listOfDuck = new LinkedList<>();


    public GameScreen(){

        JPanel bottompanel = new JPanel();
        Duck duck1  = new Duck("/red-duck.png", 200, 70, 70, 40);
        Duck duck2  = new Duck("/blue-duck.png", 50, 70, 70, 5);

        this.setLayout(new BorderLayout());


        bottompanel.add(labelTime);
        this.add(bottompanel, BorderLayout.SOUTH);

        this.add(duck1);
        this.add(duck2);
        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        labelTime.setText(String.valueOf(start));
                        labelScore.setText(String.valueOf(score));
                        repaint();
                    }
                }
        ).start();

        this.setBackground(Color.WHITE);
         this.setSize(1200, 850);
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

  /*  Duck duck1  = new Duck("/red-duck.png", 100, 70, 70, 7);
    Duck duck2  = new Duck("/red-duck.png", 100, 70, 70, 7);

    public void paint(Graphics g) {
        super.paint(g);
            duck1.paint(g);
            duck2.paint(g);
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

