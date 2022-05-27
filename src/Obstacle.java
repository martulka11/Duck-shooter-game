import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Obstacle extends JLabel implements ImageObserver {
    private BufferedImage image;
    private String pathname;
    private int distance;
    public int x;
    private int y;
    private int lives;

    public Obstacle(String pathname, int y){
        super();
        this.pathname = pathname;
        this.distance =  1 + (int)(Math.random()*2);
        this.x = 0;
        this.y = y;
        this.lives = obstacleLives();
        System.out.println("make obstacle"+ lives);


        String imageFile = pathname;
        try {
            image = ImageIO.read(getClass().getResource(imageFile));
        } catch (IOException e) {
            System.err.println("Error in upload the picture");
            e.printStackTrace();
        }

    }

        public BufferedImage getImage() {
            return image;
        }



    public int getLives() {
        return lives;
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


        public void moveObstacle(Rectangle bounds){
            x+= distance;
            if(x + getWidth() > bounds.width){
                x = bounds.width - getWidth();
                distance *=-1;
            } else if(x < 0){
                x = 0;
                distance *= -1;
            }
            setLocation(x, y);

        }

    public void reduceLives() {
        this.lives--;
    }


    public int obstacleLives() {
        switch (pathname) {
            case "/tree.png":
                return 7;
            case "/cloud.png":
                return 10;
            default:
                return 5;
        }
    }


        public void paint(Graphics2D g2d, ImageObserver observer) {
            g2d.drawImage(getImage(), getX(), getY(), observer);
        }

    }
