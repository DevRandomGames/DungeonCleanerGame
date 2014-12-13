/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import DevRandEnginePkg.ControlsEnginePkg.ControlsEngine;
import com.badlogic.gdx.Gdx;
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
    public RandomEngine randEng;
    public ConstantEngine consEng;
    
    
    
    
    
    private DevRandEngine(){
        renderEng = RenderEngine.getInstance(this);
        soundEng = SoundEngine.getInstance(this);
        logicEng = LogicEngine.getInstance(this);
        physicsEng = PhysicsEngine.getInstance(this);
        controlsEng = ControlsEngine.getInstance(this);
        consEng = ConstantEngine.getInstance(this);
        
        
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
    
    
    public ConstantEngine gameConstant(){
        return consEng;
    }
    
    
    
    
    
}
