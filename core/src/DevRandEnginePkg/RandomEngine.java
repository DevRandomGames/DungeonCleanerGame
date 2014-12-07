/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import com.badlogic.gdx.utils.Array;
import java.util.Random;

/**
 *
 * @author ArclorenSarth
 */
public class RandomEngine {
    /*private static RandomEngine INSTANCE = null;
    
    
    private RandomEngine(){
        
    }
    
    private static void createInstance(){
        INSTANCE = new RandomEngine();
    }
    
    public static RandomEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }*/
    
    public static int randInt(int min, int max) {
        //max is not included in range of the result [min,max-1]
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min)) + min;
        return randomNum;
    }
    
}
