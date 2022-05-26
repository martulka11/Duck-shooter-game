import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Duck extends JLabel implements ImageObserver {
    private BufferedImage image;
    private String pathname;
    private int distance;
    private int speed;
    private int x;
    private int y;
    private int width;
    private int hight;
    public int lives;
    private int score;



    public Duck(String pathname, int y) {
        super();
        //this.image = dimg;
        this.pathname = pathname;
       //this.speed = speed;
        this.distance =  1 + (int)(Math.random()*5);
        this.x = 0;
        this.y = y;
        //this.width = width;
        //this.hight = hight;
        this.lives = duckColor();
        System.out.println("make duck"+ lives);
        this.score = 0;




        String imageFile = pathname;
        try {
            image = ImageIO.read(getClass().getResource(imageFile));
        } catch (IOException e) {
            System.err.println("error in upload the picture");
            e.printStackTrace();
        }

    }

   /* Image dimg = image.getScaledInstance(width, hight,
            Image.SCALE_SMOOTH);
*/
  //  ImageIcon imageIcon = new ImageIcon(dimg);

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

    public int getLives() {
        return lives;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void reduceLives() {
        this.lives--;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setLocation(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getWidth() {
        return image == null ? 0 : image.getWidth();
    }

    public int getHeight() {
        return image == null ? 0 : image.getHeight();
    }


    public int addScore(){
        return GameScreen.score + this.score;
}

    public void move(Rectangle bounds){
        x+= distance;
            if(x + getWidth() > bounds.width){
                Player.livesPlayer--;
             x = bounds.width - getWidth();
             distance *=-1;
         } else if(x < 0){
                Player.livesPlayer--;
                x = 0;
             distance *= -1;
        }
        setLocation(x, y);

    }


public void paint(Graphics2D g2d, ImageObserver observer) {
    g2d.drawImage(getImage(), getX(), getY(), observer);
}

ActionListener ad = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Cick");
    }
};


}
