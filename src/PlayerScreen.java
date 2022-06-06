import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerScreen extends JPanel implements ActionListener {

    private JButton easy;
    private JButton medium;
    private JButton hard;

    public PlayerScreen(){

        easy = new JButton("EASY");
        medium = new JButton("MEDIUM");
        hard = new JButton("HARD");

        this.setLayout(new GridBagLayout());

        GridBagConstraints layout = new GridBagConstraints();
        layout.insets = new Insets(15,0,15,0);
        layout.gridwidth = GridBagConstraints.REMAINDER;


        JLabel label = new JLabel("<html><strong>Choose difficulty level</strong><hr></html>");
        label.setFont(new Font("Serif", Font.PLAIN, 60));
        add(label, layout);

        easy.addActionListener(this);
        medium.addActionListener(this);
        hard.addActionListener(this);

        this.add(easy, layout);
        this.add(medium, layout);
        this.add(hard, layout);

        Color colorBtn = new Color(74, 78 ,105);
        Dimension d = new Dimension(170, 70);

        easy.setBackground(colorBtn);
        medium.setBackground(colorBtn);
        hard.setBackground(colorBtn);
        easy.setPreferredSize(d);
        medium.setPreferredSize(d);
        hard.setPreferredSize(d);
        easy.setForeground(Color.WHITE);
        medium.setForeground(Color.WHITE);
        hard.setForeground(Color.WHITE);


        Color color = new Color(245, 235 ,224);
        this.setBackground(color);

    }

   @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == easy){
            MyFrame.cardLayout.show(MyFrame.mainPanel, "3");
            GameScreen.startCounter();
            for(Duck duck : MyFrame.ducks) {
                duck.increaseSpeed(1);
            }
            MyFrame.newDuck();
            MyFrame.speedUp();
            MyFrame.addLives();
        }else if(source == medium){
            MyFrame.cardLayout.show(MyFrame.mainPanel, "3");
           GameScreen.startCounter();
            for(Duck duck : MyFrame.ducks) {
                duck.increaseSpeed(2);
            }
            MyFrame.newDuckLevelUp();
            MyFrame.speedUp();
            MyFrame.addLives();
        }else if(source == hard){
           MyFrame.cardLayout.show(MyFrame.mainPanel, "3");
           GameScreen.startCounter();
           for(Duck duck : MyFrame.ducks) {
               duck.increaseSpeed(3);
           }
            MyFrame.newDuckLevelUp();
            MyFrame.addLives();
        }
    };
}
