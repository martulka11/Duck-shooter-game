/*import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
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

        public BufferedImage getImage() {
            return image;
        }

        public void setImage(BufferedImage image) {
            this.image = image;
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

        public void setDelta(int x, int y) {
            xDelta = x;
            yDelta = y;
        }

        public int getXDelta() {
            return xDelta;
        }

        public int getYDelta() {
            return yDelta;
        }



        public int addScore(){
            return GameScreen.score + this.score;
        }

        public void move(Rectangle bounds) {
            int xDelta = getXDelta();
            int yDelta = getYDelta();
            int x = getX() + xDelta;
            int y = getY() + yDelta;

            if (x < bounds.x) {
                x = bounds.x;
                xDelta *= -1;
            } else if (x + getWidth() >= bounds.x + bounds.width) {
                x = (bounds.x + bounds.width) - getWidth();
                xDelta *= -1;
            }

            if (y < bounds.y) {
                y = bounds.y;
                yDelta *= -1;
            } else if (y + getWidth() >= bounds.y + bounds.height) {
                y = (bounds.y + bounds.height) - getHeight();
                yDelta *= -1;
            }
            setDelta(xDelta, yDelta);
            setLocation(x, y);
        }


        public void paint(Graphics2D g2d, ImageObserver observer) {
            g2d.drawImage(getImage(), getX(), getY(), observer);
        }

    }*/
