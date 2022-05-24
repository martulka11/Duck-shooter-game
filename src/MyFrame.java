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

    public static Container contentPane;
    private JPanel menuScreen;
    public static JPanel playerScreen;
    public static JPanel gameScreen;
    public static JPanel scoreScreen;


    public static List<Player> listOfPlayer = new LinkedList<>();


    public MyFrame() {
       super("Game");


        menuScreen = new JPanel();
        gameScreen = new JPanel();
        scoreScreen = new JPanel();
        playerScreen = new JPanel();

        Menu menu = new Menu();
        menuScreen.add(menu);
        menuScreen.setBackground(Color.PINK);

        GameScreen game = new GameScreen();
        gameScreen.add(game);
       gameScreen.setLayout(new BorderLayout());

        PlayerScreen playerS = new PlayerScreen();
        playerScreen.add(playerS);
        playerScreen.setLayout(new BorderLayout());

        ScoreTable scoreTable = new ScoreTable();
        scoreScreen.add(scoreTable);
        scoreScreen.setLayout(new BorderLayout());


        contentPane=getContentPane();
        contentPane.add(menuScreen);

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
