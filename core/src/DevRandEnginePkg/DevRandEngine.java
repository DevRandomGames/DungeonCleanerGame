/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import DevRandEnginePkg.ControlsEnginePkg.ControlsEngine;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

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
    private ControlsEngine controlsEng;
    
    private Box2DDebugRenderer debugRenderer;
    
    
    private DevRandEngine(){
        renderEng = RenderEngine.getInstance();
        soundEng = SoundEngine.getInstance();
        logicEng = LogicEngine.getInstance();
        physicsEng = PhysicsEngine.getInstance();
        controlsEng = ControlsEngine.getInstance();
        
        debugRenderer = new Box2DDebugRenderer();
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
    
    public ControlsEngine gameControls(){
        return controlsEng;
    }
    
    
    
    public void renderWorldDebug(){
        debugRenderer.render(physicsEng.getWorld(), renderEng.getCamera().combined);
    }
    
}
