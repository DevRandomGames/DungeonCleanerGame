/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePckg;

/**
 *
 * @author ArclorenSarth
 */
public class DevRandEngine {
    private static DevRandEngine INSTANCE = null;
    private RenderEngine renderEng;
    private SoundEngine soundEng;
    private LogicEngine logicEng;
    
    
    private DevRandEngine(){
        renderEng = RenderEngine.getInstance();
        soundEng = SoundEngine.getInstance();
        logicEng = LogicEngine.getInstance();
    }
    
    private static void createInstance(){
        INSTANCE = new DevRandEngine();
    }
    
    public static DevRandEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public void renderGame(){
        renderEng.render();
    }
    
    public void soundGame(){
        
    }
    
    public void logicGame(){
        
    }
}
