
package fishes;

import java.util.Random;

import simulator.Fish;
import simulator.FishPathFinder;

public class Guppy extends Fish {
	private final String name = "Guppy";

	public Guppy() {
                maxSpeedX = 5;
                maxSpeedY = 2;
		FishPathFinder fpf = new FishPathFinder();
		img = loadImage(fpf.findFishPath(name));
		Random rand = new Random();
		speedX = rand.nextInt(maxSpeedX) + 1;
		speedY = rand.nextInt(maxSpeedY);
		randomStart();
	}

}
