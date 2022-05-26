import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MyFrame extends JFrame{

    private JPanel menuScreen;
    public static JPanel playerScreen;
    public static JPanel gameScreen;
    public static JPanel scoreScreen;


    public static List<Player> listOfPlayer = new LinkedList<>();

    public static CardLayout cObjl;
    public static JPanel cPanel;

    public MyFrame() {
       super("Duck shooter");
        cPanel = new JPanel();
        cObjl = new CardLayout();

        cPanel.setLayout(cObjl);


        menuScreen = new JPanel();
        playerScreen = new JPanel();
        gameScreen = new JPanel();
        scoreScreen = new JPanel();


        Menu menu = new Menu();
        menuScreen.add(menu);
       menuScreen.setBackground(Color.PINK);


        PlayerScreen playerS = new PlayerScreen();
        playerScreen.add(playerS);


        List<Duck> ducks = new ArrayList<>();
        List<Duck> ducksMedium = new ArrayList<>();
        List<Duck> ducksHard = new ArrayList<>();
        Duck ducks1 = new Duck("/red-duck.png", 100);
        ducks.add(new Duck("/green-duck.png", 200));
        ducks.add(ducks1);

        GameScreen game = new GameScreen(ducks);
        gameScreen.add(game);
        gameScreen.setBackground(Color.WHITE);

        ScoreTable scoreTable = new ScoreTable();
        scoreScreen.add(scoreTable);

        scoreScreen.setLayout(new BorderLayout());


        cPanel.add(menuScreen, "1");

        cPanel.add(playerScreen, "2");

        cPanel.add(gameScreen, "3");

        cPanel.add(scoreScreen, "4");

        getContentPane().add(cPanel);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
