import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ScoreTable extends JPanel implements Serializable, ActionListener {

    private JList list;
    private JButton back;

public ScoreTable(){

    Object[] data = { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };

    this.setLayout(new GridBagLayout());

    GridBagConstraints layout = new GridBagConstraints();
    layout.insets = new Insets(15,0,15,0);
    layout.gridwidth = GridBagConstraints.REMAINDER;

    back = new JButton("Back to Menu");
    list = new JList(new DefaultListModel<>());
    JScrollPane scrollPane = new JScrollPane(list);



    JLabel label = new JLabel("<html><strong>Player Score</strong><hr></html>");
    label.setFont(new Font("Serif", Font.PLAIN, 60));

    Color colorBtn = new Color(74, 78 ,105);
    Dimension d = new Dimension(170, 70);

    back.setBackground(colorBtn);
    back.setPreferredSize(d);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);

    list.setBackground(Color.WHITE);
    scrollPane.setPreferredSize(new Dimension(300, 300));


    this.add(label, layout);
    this.add(scrollPane, layout);
    this.add(back, layout);

   //odczytWynikow("D:\\kaczki.txt");

    for (int i = 0; i < 50; i++) {
        ((DefaultListModel) list.getModel()).addElement(String.valueOf(i));
    }


    Color color = new Color(245, 235 ,224);
    this.setBackground(color);
    this.setSize(1200, 900);

}


    public ArrayList<Player> odczytWynikow (String sciezkapliku){
        MyFrame.listOfPlayer = null;
        try {
            FileInputStream fileIn = new FileInputStream(sciezkapliku);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MyFrame.listOfPlayer = (ArrayList) in.readObject();

            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            //return (ArrayList<Player>) MyFrame.listOfPlayer;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
           // return (ArrayList<Player>) MyFrame.listOfPlayer;
    }
        return (ArrayList<Player>) MyFrame.listOfPlayer;
}



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == back){
        MyFrame.cardLayout.show(MyFrame.mainPanel, "1");
        }

        }
    }

    /*
    *
    public static void odczytWynikow (String sciezkapliku){
    MyFrame. = null;
    try {
        FileInputStream fileIn = new FileInputStream(sciezkapliku);
        ObjectInputStream in = new ObjectInputStream(fileIn);
       // for(Player player : MyFrame.listOfPlayer){
        MyFrame.listOfPlayer = (Player) in.readObject();

        in.close();
        fileIn.close();
    } catch (IOException i) {
        i.printStackTrace();
        return;
    } catch (ClassNotFoundException c) {
        System.out.println("Employee class not found");
        c.printStackTrace();
        return;
    }
}
*/



