
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    private JButton button1;
    private JButton button2;
    private JButton button3;


    public Menu(){

        button1 = new JButton("New Game");
        button1.setPreferredSize( new Dimension(200, 100));
        button2 = new JButton("High Score");
        button2.setPreferredSize( new Dimension(200, 100));
        button3 = new JButton("Exit");
        button3.setPreferredSize( new Dimension(200, 100));

        setLayout(new GridBagLayout());

        GridBagConstraints layout = new GridBagConstraints();
        layout.gridwidth = GridBagConstraints.REMAINDER;
        add(new JLabel("<html><h1><strong><i>Duck Schooter</i></strong></h1><hr></html>"), layout);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        this.add(button1, layout);
       this.add(button2, layout);
       this.add(button3, layout);



        this.setBackground(Color.PINK);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        MyFrame my = new MyFrame();
        GameScreen gb = new GameScreen();
        if(source == button1){
            MyFrame.cObjl.next(MyFrame.cPanel);
        } else if(source == button2){
            MyFrame.cObjl.show(MyFrame.cPanel, "4");
        } else if(source == button3){
            System.exit(0);
        }


    }

}
