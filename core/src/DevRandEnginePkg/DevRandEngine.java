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
public class DevRandEngine {
    private static DevRandEngine INSTANCE = null;
    private RenderEngine renderEng;
    private PhysicsEngine physicsEng;
    private SoundEngine soundEng;
    private LogicEngine logicEng;
    
    
    private DevRandEngine(){
        renderEng = RenderEngine.getInstance();
        soundEng = SoundEngine.getInstance();
        logicEng = LogicEngine.getInstance();
        physicsEng = PhysicsEngine.getInstance();
    }
    
    private static void createInstance(){
        INSTANCE = new DevRandEngine();
    }
    
    public static DevRandEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public RenderEngine gameRender(){
        return renderEng;
    }
    
    public SoundEngine gameSound(){
        return soundEng;
    }
    
    public LogicEngine gameLogic(){
        return logicEng;
    }
    
    public PhysicsEngine gamePhysics(){
        return physicsEng;
    }
}
