
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel implements ActionListener{
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public Menu(){
        button1 = new JButton("New Game");
        button2 = new JButton("High Score");
        button3 = new JButton("Exit");

        this.setLayout(new GridBagLayout());

        GridBagConstraints layout = new GridBagConstraints();
        layout.insets = new Insets(15,0,15,0);
        layout.gridwidth = GridBagConstraints.REMAINDER;

        JLabel label = new JLabel("<html><strong><i>Duck Schooter</i></strong><hr></html>");
        label.setFont(new Font("Serif", Font.PLAIN, 60));
        add(label, layout);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        this.add(button1, layout);
       this.add(button2, layout);
       this.add(button3, layout);

        Color colorBtn = new Color(74, 78 ,105);
        Dimension d = new Dimension(170, 70);

        button1.setBackground(colorBtn);
        button2.setBackground(colorBtn);
        button3.setBackground(colorBtn);
        button1.setPreferredSize(d);
        button2.setPreferredSize(d);
        button3.setPreferredSize(d);
        button1.setForeground(Color.WHITE);
        button2.setForeground(Color.WHITE);
        button3.setForeground(Color.WHITE);


        Color color = new Color(245, 235 ,224);
        this.setBackground(color);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == button1){
            MyFrame.cardLayout.next(MyFrame.mainPanel);
        } else if(source == button2){
            MyFrame.cardLayout.show(MyFrame.mainPanel, "4");
        } else if(source == button3){
            System.exit(0);
        }


    }

}
