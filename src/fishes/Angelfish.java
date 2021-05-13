/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishes;

import java.awt.Graphics;
import java.util.Random;

import simulator.Fish;
import simulator.FishPathFinder;

public class Angelfish extends Fish {
	private final String name = "Angelfish";

	public Angelfish() {
            
                maxSpeedX = 8;
                maxSpeedY = 3;
		FishPathFinder fpf = new FishPathFinder();
		img = loadImage(fpf.findFishPath(name));
		Random rand = new Random();
		speedX = rand.nextInt(maxSpeedX-2) + 3;
		speedY = rand.nextInt(maxSpeedY);
		randomStart();
	}

}
