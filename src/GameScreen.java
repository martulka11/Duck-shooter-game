import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class GameScreen extends JPanel{

    private JLabel labelTime = new JLabel("Time");
    private JLabel labelScore = new JLabel("Score");
    public static int start = 0;
    public static int score = 0;
    public static Timer timer;
    public static Timer timer2;


    public GameScreen() {


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point me = e.getPoint();
                Duck remove = null;
                Obstacle obs = null;
                    for (Obstacle obstacle : MyFrame.obstacles) {
                        if (me.getX() >= obstacle.getX() && me.getX() <= obstacle.getX() + obstacle.getWidth() && me.getY() >= obstacle.getY() && me.getY() <= obstacle.getY() + obstacle.getHeight()) {
                            obs = obstacle;
                            System.out.println("Obstacle");
                        }
                    }

                for(Duck duck : MyFrame.ducks) {
                    if (me.getX() >= duck.getX() && me.getX() <= duck.getX() + duck.getWidth() && me.getY() >= duck.getY() && me.getY() <= duck.getY() + duck.getHeight()) {
                        remove = duck;
                        score++;
                        System.out.println("Punkty" + score);
                        System.out.println("Hide duck");

                }}

                if(remove != null){
                    remove.reduceLives();
                    System.out.println(remove.getLives());
                    if(remove.getLives() == 0)
                        MyFrame.ducks.remove(remove);
                }

                if(obs != null){
                    obs.reduceLives();
                    System.out.println(obs.getLives());
                    if(obs.getLives() == 0)
                        MyFrame.obstacles.remove(obs);
                }

                if(Player.livesPlayer  < 0){
                    timer.stop();
                }

            }
        });


    timer = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Rectangle bounds = new Rectangle(getSize());
            for (Duck duck : MyFrame.ducks) {
                duck.move(bounds);
            }
            for (Obstacle obs : MyFrame.obstacles) {
                obs.moveObstacle(bounds);
            }
            repaint();
        }
    });
    timer.start();


            new Thread(
                    () -> {
                        while (!Thread.currentThread().isInterrupted()) {
                            labelTime.setText("Time  " + String.valueOf(start));
                            labelScore.setText("Score  " + String.valueOf(score));
                            if (Player.livesPlayer < 0) {
                                Thread.currentThread().isInterrupted();
                                return;
                            }
                        }
                    }
            ).start();


        labelTime.setFont(new Font("Serif", Font.PLAIN, 20));
        labelScore.setFont(new Font("Serif", Font.PLAIN, 20));

        Border border = labelTime.getBorder();
        Border margin = new EmptyBorder(10,100,10,100);
        labelTime.setBorder(new CompoundBorder(border, margin));

        Border border1 = labelScore.getBorder();
        Border margin1 = new EmptyBorder(10,100,10,100);
        labelScore.setBorder(new CompoundBorder(border1, margin1));

        add(labelTime);
        add(labelScore);


        this.setBackground(Color.WHITE);
    }


        public static void startCounter () {
            new Thread(
                    () -> {
                        try {
                            while (!Thread.currentThread().isInterrupted()) {
                                start++;
                                Thread.sleep(1000);
                                if (Player.livesPlayer < 0) {
                                    Thread.currentThread().isInterrupted();
                                    MyFrame.cardLayout.show(MyFrame.mainPanel, "5");
                                    return;
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

            ).start();
        }


        @Override
        public Dimension getPreferredSize () {
            return new Dimension(1200, 900);
        }

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            for (Duck duck : MyFrame.ducks) {
               for(Obstacle obstacle : MyFrame.obstacles){
                Graphics2D g2d = (Graphics2D) g.create();
                duck.paint(g2d, this);
                obstacle.paint(g2d,this);
                g2d.dispose();
            }
            }
        }



    }

