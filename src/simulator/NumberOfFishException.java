/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

/**
 *
 * @author oldsh
 */
public class NumberOfFishException extends Exception {

    public NumberOfFishException() {
        //super();
    }

    public NumberOfFishException(String string) {
        super("Error num! " + string);
    }
    
    
}
