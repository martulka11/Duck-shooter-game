import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ScoreTable extends JPanel implements Serializable {

    JTable table;

public ScoreTable(){


    //bedzie bral tablice graczy i dodawal ich wyniki

    Object[] data = { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };
    this.setLayout(new BorderLayout());

    //GridBagConstraints layout = new GridBagConstraints();
   // layout.gridwidth = GridBagConstraints.REMAINDER;
    this.add(new JLabel("<html><h1><strong>Player Score</strong></h1><hr></html>"), BorderLayout.NORTH);

    JList list = new JList(data);
    list.setBackground(Color.WHITE);
    this.add(list, BorderLayout.CENTER);
    Color color = new Color(245, 235 ,224);
    this.setBackground(color);
    this.setSize(1200, 900);

}/*
    public static void main(String[] args){
    Player e = null;
    try {
        FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        e = (Employee) in.readObject();
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

    System.out.println("Deserialized Employee...");
    System.out.println("Name: " + e.name);
    System.out.println("Address: " + e.address);
    System.out.println("SSN: " + e.SSN);
    System.out.println("Number: " + e.number);
}
*/
}
