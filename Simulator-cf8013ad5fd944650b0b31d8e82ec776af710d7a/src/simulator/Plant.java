package simulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

public class Plant {

	private int plantX1, plantX2;
	private double plantY1, plantY2;
	private int boundX, boundY;
	private double speedGrowth;

	private double G = 255;
        
        public Plant() {
		loadBounds();
	}
       
	public void loadBounds() {
		G = 255;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		boundY = (int) screenSize.getHeight();
		boundX = (int) screenSize.getWidth();

		Random rand = new Random();

		plantX1 = rand.nextInt(boundX) + 1;
		plantX2 = plantX1;

		plantY1 = boundY;
		plantY2 = boundY;

		speedGrowth = (double)( rand.nextInt(100) + 1) / 1000;
		boundY = rand.nextInt(boundY) + 1;
	}

	

	public void growPlant() {
		if (plantY2 > boundY / 2) {
			plantY2 -= speedGrowth;
			if (G > 150) {
				G -= speedGrowth / 10;
			}
		}

		if (plantY2 <= boundY / 2) {
			loadBounds();
		}
	}

	public void draw(Graphics g) {
		Color green = new Color(0, (int) G, 0);
		g.setColor(green);
		g.drawLine(plantX1, (int) plantY1, plantX2, (int) plantY2);
	}
}
