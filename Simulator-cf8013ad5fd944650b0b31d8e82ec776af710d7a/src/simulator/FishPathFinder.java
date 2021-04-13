
package simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FishPathFinder {
   private String pathFish;
   public String findFishPath(String name){
       BufferedReader br;
       try{
           br = new BufferedReader(new FileReader("src\\simulator\\fishAdress.txt"));
           String line = br.readLine();
           while(line != null){
              String arrStr[] = line.split(" - ");
              if(arrStr[0].equals(name)){
                  pathFish = arrStr[1];
                  return pathFish;
              }
              line = br.readLine();
           }
       } catch(FileNotFoundException fnf ){
           fnf.printStackTrace();
       } catch( IOException ioe ){
           ioe.printStackTrace();
       }
       return "";
    }

   
}
