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
    public int distance;
    private int x;
    private int y;
    private int lives;

    public Duck(String pathname, int y) {
        super();
        this.pathname = pathname;
        this.distance =  1 + (int)(Math.random());
        this.x = 0;
        this.y = y;
        this.lives = duckColor();
        System.out.println("make duck"+ lives);
        //mozemy tez zronic tak ze uttja dodam tablice static i co jakis czas bede
        //tworzyc kaczke i dodawac ja do litsy ktora listy kotra jest caly czas renderowana



        String imageFile = pathname;
        try {
            image = ImageIO.read(getClass().getResource(imageFile));
        } catch (IOException e) {
            System.err.println("error in upload the picture");
            e.printStackTrace();
        }

    }


    public int duckColor() {
        switch (pathname) {
            case "/red-duck.png":
                return 3;
            case "/blue-duck.png":
                return 5;
            case "/green-duck.png":
                return 7;
            case "/yellow-duck.png":
                return 10;
            default:
                return 5;
        }
    }

    public void increaseSpeed(int number){
        this.distance *= number ;
    }

    public void increaseSpeed(){

        this.distance += 100 ;
    }

    public void increaseLives(){

        this.lives += 2 ;
    }



    public int getLives() {
        return lives;
    }

    public BufferedImage getImage() {
        return image;
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

    public void move(Rectangle bounds){
        x+= distance;
            if(x + getWidth() > bounds.width){
                System.out.println(Player.livesPlayer);
                Player.livesPlayer--;
             x = bounds.width - getWidth();
             distance *=-1;
         } else if(x < 0){
                Player.livesPlayer--;
                System.out.println(Player.livesPlayer);
                x = 0;
             distance *= -1;
        }
        setLocation(x, y);

    }


    public void paint(Graphics2D g2d, ImageObserver observer) {
    g2d.drawImage(getImage(), getX(), getY(), observer);
}


}
