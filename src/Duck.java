import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Duck extends JLabel implements ImageObserver, MouseListener {
    private BufferedImage image;
    private String pathname;
    private int distance;
    private int speed;
    public int x;
    private int y;
    private int width;
    private int hight;
    private int lives;
    private int score;



    public Duck(String pathname, int y, int width, int hight, int speed) {
        super();
        this.pathname = pathname;
        this.speed = speed;
        this.distance =  1 + (int)(Math.random()*speed);
        this.x = 0;
        this.y = y;
        this.width = width;
        this.hight = hight;
        this.lives = duckColor();
        this.addMouseListener(this);
        System.out.println("make duck"+ lives);
        this.score = 0;
        GameScreen.listOfDuck.add(this);
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
          //  System.out.println("odleglosc" + x);
            if(x > 1200)
            x -= distance;
        }
    };
    Timer timer=new Timer(100,al);

    public int duckColor() {
        switch (pathname) {
            case "/red-duck.png":
                return 3;
            case "/blue-duck.png":
                return 6;
            case "/green-duck.png":
                return 8;
            case "/yellow-duck.png":
                return 10;
            default:
                return 0;
        }
    }

public int addScore(){
        return GameScreen.score + this.score;
}


      @Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, width, hight, this);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if(lives > 0){
            lives--;
            System.out.println(lives);
            System.out.println("mouseClicked");
        } else {
            this.score=1;
            System.out.println("Score" + score);
           // System.out.println( "ogolne punkty" + GameScreen.score);
            image = null;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
