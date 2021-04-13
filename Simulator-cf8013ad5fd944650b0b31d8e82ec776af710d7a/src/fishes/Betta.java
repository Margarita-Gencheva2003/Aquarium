
package fishes;

import java.util.Random;

import simulator.Fish;
import simulator.FishPathFinder;

public class Betta extends Fish {
	private final String name = "Betta";

	public Betta() {
                Random rand = new Random();
                maxSpeedX = 5;
                maxSpeedY = 3;
		FishPathFinder fpf = new FishPathFinder();
		img = loadImage(fpf.findFishPath(name));
		speedX = rand.nextInt(maxSpeedX) + 1;
		speedY = rand.nextInt(maxSpeedY);
		randomStart();
                
	}

	

}
