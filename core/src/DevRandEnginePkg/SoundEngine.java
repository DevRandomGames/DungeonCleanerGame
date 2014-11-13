/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

/**
 *
 * @author ArclorenSarth
 */
public class SoundEngine {
    private static SoundEngine INSTANCE = null;
    
    
    private SoundEngine(){
        
    }
    
    private static void createInstance(){
        INSTANCE = new SoundEngine();
    }
    
    public static SoundEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
}
