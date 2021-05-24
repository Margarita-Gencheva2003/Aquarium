package simulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import fishes.*;
public class Aquarium extends JPanel implements ActionListener {

	private GraphicsConfiguration gc;
	private Timer timer;
	private ArrayList<Fish> fish;
	private Plant plant[];

        
        private int numRedfish, numGuppy, numAngelfish, numCatfish, numBetta;
	public static void main(String[] args) {
                
		Aquarium aq = new Aquarium(); // create object of type aquarium
                aq.numRedfish = aq.inputNumOfSmth("number of Redfish: ");
                aq.numGuppy = aq.inputNumOfSmth("number of Guppy: ");
                aq.numAngelfish = aq.inputNumOfSmth("number of Angelfish: ");
                aq.numCatfish = aq.inputNumOfSmth("number of Catfish: ");
                aq.numBetta = aq.inputNumOfSmth("number of Betta: ");

                //arraylist for fish has been created here
                aq.fish =new ArrayList<>();
                for(int i = 0; i < aq.numRedfish; i++){
                    aq.fish.add(new Redfish()); 
                    
                }
                for(int i = 0; i < aq.numGuppy; i++){
                    aq.fish.add(new Guppy()); 
                    
                }
                for(int i = 0; i < aq.numAngelfish; i++){
                   aq.fish.add(new Angelfish());
                }
                for(int i = 0; i < aq.numCatfish; i++){
                    aq.fish.add(new Catfish()); 
                    
                }
                for(int i = 0; i < aq.numBetta; i++){
                    aq.fish.add(new Betta()); 
                    
                }
                Collections.shuffle(aq.fish); // Randomly permutes the specified list using a default source of randomness. 
		
		aq.plant = new Plant[aq.inputNumOfSmth("number of Plants: ")]; //array for plant has been created here
		for (int i = 0; i < aq.plant.length; i++) {
			aq.plant[i] = new Plant();
		}

		JFrame frame = new JFrame(aq.gc); 

		frame.setTitle("Aquarium");
		frame.add(aq); // frame adds the aquarium(aq is JPanel)
		aq.setBackground(Color.blue);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		// timer calls periodically a function(in out case: ActionPerformed
		aq.timer = new Timer(30, aq);	
                aq.timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// move fish
		for(Fish fish: fish){
                    fish.move();
                }
		// grow plant
		for (int i = 0; i < plant.length; i++) {
			plant[i].growPlant();
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
               
		for (int i = 0; i < plant.length; i++) {
			plant[i].draw(g);
		}

		for(Fish fish: fish){
                    fish.draw(g);
                }
               
	}
        public int inputNumOfSmth( String message){
            int num = 0;
             try{
                num =Integer.parseInt(JOptionPane.showInputDialog(message));
                if(num < 0){
                    throw new NumberOfFishException();
                }
             } catch(NumberOfFishException nfe){
                 nfe.printStackTrace();
             } catch (NumberFormatException nfe1){
                 nfe1.printStackTrace();
             }
             return num;
        }

}
