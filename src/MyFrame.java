import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Container;
import java.util.LinkedList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class MyFrame extends JFrame implements Runnable {

    private JPanel menuScreen;
    public static JPanel playerScreen;
    public static JPanel gameScreen;
    public static JPanel scoreScreen;


    public static List<Player> listOfPlayer = new LinkedList<>();

    public static CardLayout cObjl;
    public static JPanel cPanel;

    public MyFrame() {
       super("Game");
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
        playerScreen.setLayout(null);

        GameScreen game = new GameScreen();
        gameScreen.add(game);
        // gameScreen.setBackground(Color.WHITE);
       // gameScreen.setLayout(new BorderLayout());

        ScoreTable scoreTable = new ScoreTable();
        scoreScreen.add(scoreTable);

        scoreScreen.setLayout(new BorderLayout());


        cPanel.add(menuScreen, "1");

        cPanel.add(playerScreen, "2");

        cPanel.add(gameScreen, "3");

        cPanel.add(scoreScreen, "4");
        getContentPane().add(cPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);
        this.setVisible(true);
    }



    @Override
    public void run() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });



    }

}
