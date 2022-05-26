import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlayerScreen extends JPanel implements ActionListener {

    private JButton playButton;
    private JButton easy;
    private JButton medium;
    private JButton hard;
    private String name;
    private JTextField textField;


    public PlayerScreen(){
        JLabel labelText = new JLabel("Enter your name");
        textField = new JTextField(20);
        playButton = new JButton("PLAY");
        easy = new JButton("EASY");
        medium = new JButton("MEDIUM");
        hard = new JButton("HARD");

        this.add(labelText);
        this.add(textField);
        this.add(playButton);
        this.add(new JLabel("<html><h1><strong>Choose difficulty level</strong></h1><hr></html>"));
        this.add(easy);
        this.add(medium);
        this.add(hard);


        playButton.addActionListener(this);


        this.setBackground(Color.WHITE);


    }


   @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == playButton){
            MyFrame.cObjl.next(MyFrame.cPanel);
            GameScreen.timer2.start();
            name = textField.getText();
            System.out.println(name);
}
    }
}
