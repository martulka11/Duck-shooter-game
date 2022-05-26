import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class GameScreen extends JPanel{

    private JLabel labelTime = new JLabel("0");
    private JLabel labelScore = new JLabel("0");
    public static int start = 0;
    public static int score = 0;
    public static Timer timer2;

    private List<Duck> ducks;


    public GameScreen(List<Duck> ducks) {

        this.ducks = ducks;

        Random rnd = new Random();


        for (Duck duck : ducks) {
          duck.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    Point me = e.getPoint();
                    // Rectangle bounds = new Rectangle(getSize());
                    //  if (bounds.contains(me)) {
                    for(int i = 0; i < ducks.size(); i++){
                        if(ducks.get(i).getLives()>0){
                            System.out.println(ducks.get(i).getY());
                            ducks.get(i).reduceLives();
                            System.out.println("zostalo zyc" + ducks.get(i).getLives());
                        } else {
                            // score++; inaczej??????????????/
                            //moze liczac kaczki ktore nie maja obrazkow???
                            ducks.remove(i);
                        }
                    }
                    System.out.println("I was clicked!");
                }
                // }
            });
          // System.out.println(getX());
            //duck.setDelta(xDelta, 0);
        };




        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle bounds = new Rectangle(getSize());
                for (Duck duck : ducks) {
                    duck.move(bounds);
                }
                start++;
             //   System.out.println(start);
                repaint();
            }
        });
        timer.start();



        ActionListener al=new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                    //start++
                if(Player.livesPlayer == 0){
                    timer.stop();
                }

            }

        };
        timer2 =new Timer(1000,al);



        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        labelTime.setText(String.valueOf(start));
                        labelScore.setText(String.valueOf(score));
                    }
                }
        ).start();

        this.setBackground(Color.WHITE);
    }
/*
        public void startCounter () {
            new Thread(
                    () -> {
                        try {
                            while (!Thread.currentThread().isInterrupted()) {
                                start++;
                                Thread.sleep(1000);
                                System.out.println(start);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            ).start();

        }*/
//jakbym tutaj dodala metode dodajaca kaczki??


        public void zapisWynikow (String sciezkapliku){
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

        @Override
        public Dimension getPreferredSize () {
            return new Dimension(1200, 900);
        }

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            for (Duck duck : ducks) {
                Graphics2D g2d = (Graphics2D) g.create();
                duck.paint(g2d, this);
                g2d.dispose();
            }
        }

        public void gameOverJDialog () {
            JDialog dialog = new JDialog(new Frame(), "Info Frame");
            dialog.setLayout(new FlowLayout());
            JLabel lab = new JLabel("Game Over");
            JButton button = new JButton("Back to Menu");
            dialog.add(lab);
            button.addActionListener(actionListener);
            dialog.add(button);
            dialog.setSize(600, 500);
            dialog.setVisible(true);
        }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MyFrame.cObjl.show(MyFrame.cPanel, "1");
        }
    };



    }

