import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class MyFrame extends JFrame{

    private JPanel menuScreen;
    public static JPanel playerScreen;
    public static JPanel gameScreen;
    public static JPanel scoreScreen;

    public static List<Duck> ducks;
    public static List<Obstacle> obstacles;

    public static List<Player> listOfPlayer = new LinkedList<>();

    public static CardLayout cardLayout;
    public static JPanel mainPanel;

    public MyFrame() {
       super("Duck shooter");
        mainPanel = new JPanel();
        cardLayout = new CardLayout();

        mainPanel.setLayout(cardLayout);


        menuScreen = new JPanel();
        playerScreen = new JPanel();
        gameScreen = new JPanel();
        scoreScreen = new JPanel();


        Menu menu = new Menu();
        menuScreen.add(menu);
        Color color = new Color(245, 235 ,224);
        menuScreen.setBackground(color);


        ducks = new ArrayList<>();
        ducks.add(new Duck("/red-duck.png", 100));
        ducks.add(new Duck("/blue-duck.png", 200));
        ducks.add(new Duck("/yellow-duck.png", 600));

        obstacles = new ArrayList<>();
        obstacles.add(new Obstacle("/cloud.png", 100));
        obstacles.add(new Obstacle("/tree.png", 500));


        GameScreen game = new GameScreen();
        gameScreen.add(game);
        gameScreen.setBackground(Color.PINK);

        PlayerScreen playerS = new PlayerScreen();
        playerScreen.add(playerS);
        playerScreen.setBackground(color);

        ScoreTable scoreTable = new ScoreTable();
        scoreScreen.add(scoreTable);
        scoreScreen.setBackground(color);


        mainPanel.add(menuScreen, "1");
        mainPanel.add(playerScreen, "2");
        mainPanel.add(gameScreen, "3");
        mainPanel.add(scoreScreen, "4");

        getContentPane().add(mainPanel);

        addKeyListener(new MultiKeyListener());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    public static String generatorColorsDuck(){
        Random generator = new Random();
        int number = generator.nextInt(5);
        switch (number) {
            case 1:
                return "/red-duck.png";
            case 2:
                return "/blue-duck.png";
            case 3:
                return "/green-duck.png";
            case 4:
                return "/yellow-duck.png";
            default:
                return "/red-duck.png";
        }
    }


    public static String generatorObstacle(){
        Random generator = new Random();
        int number = generator.nextInt(3);
        switch (number) {
            case 1:
                return "/cloud.png";
            case 2:
                return "/tree.png";
            default:
                return "/cloud.png";
        }
    }

    public static int generatorY(){
        Random generator = new Random();
        int number = generator.nextInt(800);
        return number;
    }


    public static void speedUp () {
        new Thread(
                () -> {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            Thread.sleep(5000);
                            for(Duck duck : ducks){
                                duck.increaseSpeed(2);
                            }
                            if (Player.livesPlayer < 0) {
                                Thread.currentThread().isInterrupted();
                                return;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }


    public static void addLives () {
        new Thread(
                () -> {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            Thread.sleep(5000);
                            for(Duck duck : ducks){
                                duck.increaseLives();
                            }
                            if (Player.livesPlayer < 0) {
                                Thread.currentThread().isInterrupted();
                                return;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }



    public static void newDuck () {
        new Thread(
                () -> {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            ducks.add(new Duck(generatorColorsDuck(), generatorY()));
                            obstacles.add(new Obstacle(generatorObstacle(), generatorY()));
                            Thread.sleep(5000);
                            if (Player.livesPlayer < 0) {
                                Thread.currentThread().isInterrupted();
                                return;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }


    public static void newDuckLevelUp () {
        new Thread(
                () -> {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            ducks.add(new Duck(generatorColorsDuck(), generatorY()));
                            ducks.add(new Duck(generatorColorsDuck(), generatorY()));
                            obstacles.add(new Obstacle(generatorObstacle(), generatorY()));
                            Thread.sleep(5000);
                            if (Player.livesPlayer < 0) {
                                Thread.currentThread().isInterrupted();
                                return;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                    new MyFrame();

            }
        });



    }

}
