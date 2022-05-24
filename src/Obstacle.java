import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Obstacle extends JPanel {
    private BufferedImage image;
    private String pathname;
    private int distance;
    //private int speed;
    public int x;
    private int y;
    private int width;
    private int hight;

    public Obstacle(String pathname, int y, int width, int hight){
        super();
        this.pathname = pathname;
        this.distance =  1 + (int)(Math.random()*5);
        this.x = 0;
        this.y = y;
        this.width = width;
        this.hight = hight;
        timer.start();


        File imageFile = new File(pathname);
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

    }

    ActionListener al=new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            x += distance;
            if(x > 1200)
                x -= distance;
        }
    };
    Timer timer=new Timer(100,al);


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, width, hight, this);
    }

}
