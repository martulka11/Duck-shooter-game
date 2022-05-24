import javax.swing.*;
import java.awt.*;

public class ScoreTable extends JPanel {

    JTable table;

public ScoreTable(){

    //bedzie bral tablice graczy i dodawal ich wyniki

    Object[] data = { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };
    this.setLayout(new BorderLayout());

    //GridBagConstraints layout = new GridBagConstraints();
   // layout.gridwidth = GridBagConstraints.REMAINDER;
    this.add(new JLabel("<html><h1><strong>Player Score</strong></h1><hr></html>"), BorderLayout.NORTH);

    JList list = new JList(data);
    list.setBackground(Color.PINK);
    this.add(list, BorderLayout.CENTER);
    this.setBackground(Color.PINK);
    this.setSize(1200, 900);

}

}
