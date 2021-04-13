
package fishes;
import java.awt.Graphics;
import java.util.Random;
import simulator.Fish;
import simulator.FishPathFinder;

public class Catfish extends Fish{
    private final String name = "Catfish";

	public Catfish() {
                maxSpeedX = 3;
                maxSpeedY = 2;
		FishPathFinder fpf = new FishPathFinder();
		img = loadImage(fpf.findFishPath(name));
		Random rand = new Random();
		speedX = rand.nextInt(maxSpeedX) + 1;
		speedY = rand.nextInt(maxSpeedY);
                minDepth = boundY/2;
		randomStart();
	}
        
}
