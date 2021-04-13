/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


public abstract class Fish {
    protected int boundX, boundY;
    protected int positionFishX, positionFishY;
    protected int speedX, speedY, maxSpeedX, maxSpeedY;
    protected BufferedImage img = null;
    protected int minDepth = 0;
    
    public void loadBounds() {
        
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	boundX = (int) screenSize.getWidth();
    	boundY = (int) screenSize.getHeight();
       
    }
    
    public  BufferedImage loadImage(String str){
    	loadBounds();
        Random rand = new Random();
        try {
            img = ImageIO.read(new File(str));
            positionFishX = rand.nextInt(boundX - img.getWidth());
            positionFishY = rand.nextInt(boundY- img.getHeight());
            int newSizeCoef = rand.nextInt(3)+1;
            img = resize(img, img.getWidth()/newSizeCoef, img.getHeight()/newSizeCoef);
            return img;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return img;
    }
    public void randomStart() {
	Random rand = new Random();
        int x = rand.nextInt(2);
        if (x == 0) {
            img = horizontalFlip(img);
            speedX *= -1;
        }
	}
    public BufferedImage horizontalFlip(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage flippedImage = new BufferedImage(w, h, img.getType());
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return flippedImage;
    }
    public void crossBarrier(){ //TO DO = one function
        Random rand = new Random();
        if (positionFishX > boundX - img.getWidth() || positionFishX < 0) { 
            if (positionFishX > boundX - img.getWidth()) {
                positionFishX = boundX - img.getWidth();
            } else {
                positionFishX = 0;
            }
            img = horizontalFlip(img);
            speedX = Integer.signum(speedX) * (-1) * (rand.nextInt(maxSpeedX) + 1);
        }
            
        if (positionFishY > boundY - img.getHeight() || positionFishY < minDepth) {
            if (positionFishY > boundY - img.getHeight()) {
                positionFishY = boundY - img.getHeight();
            } else {
                positionFishY = minDepth;
            }
            speedY = Integer.signum(speedY) * (-1) * (rand.nextInt(maxSpeedY) + 1);
        }
    }
    public  BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

    return dimg;
} 
    public void move() {
	positionFishX += speedX;
	positionFishY += speedY;
	crossBarrier();
    }
    
    public  void draw(Graphics g){
	g.drawImage(img, positionFishX, positionFishY, null);
    }
}
