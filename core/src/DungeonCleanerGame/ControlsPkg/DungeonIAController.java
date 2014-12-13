/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.ControlsPkg;

import DevRandEnginePkg.ControlsEnginePkg.IAController;
import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.CharacterPkg.Enemy;
import DungeonCleanerGame.CharacterPkg.GameCharacter;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.down;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.left;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.right;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.up;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.standby;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.strike;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.walk;
import DungeonCleanerGame.CharacterPkg.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import java.util.Random;

/**
 *
 * @author ArclorenSarth
 */
public class DungeonIAController extends IAController{
    
    private DevRandEngine gameEngine;
    private Random RG;
    private float iaTimer;
    
    public DungeonIAController(Enemy e){
        super.ctrlIdentity = e;
        super.timer=0;
        iaTimer=0;
        e.st = walk;
        gameEngine = DevRandEngine.getInstance();
        RG = new Random();
    }
    
    public void computeAction(int p, int e, int f){
        
        super.timer -=Gdx.graphics.getDeltaTime();
        iaTimer+=Gdx.graphics.getDeltaTime();
        Enemy en = (Enemy) super.ctrlIdentity;
        //en.st = walk;
        //Camera cam = gameEngine.gameRender().getCamera();
        float speed = 200;
        float forceMove = 0.5f;
        
        if(super.timer <=0){
            super.timer = 0;
            en.controlsEnabled = true;
        }
        
       if(en.controlsEnabled){
            en.iaComputeState();
        
            if(iaTimer>=4){
                iaTimer = 0;
                en.iaComputeDir();
            }
        
            switch(en.st){
                case walk: idiotWalk(en);break;
                //case hit: idiotWalk(en);
                default: idiotWalk(en);break;
            }
       }
        
        
        en.getBody().setAngularVelocity(0f);
        
    }
    
    public void idiotWalk(Enemy e){
        
        if(e.d==GameCharacter.dir.up && e.st==GameCharacter.state.walk){
            e.getBody().setLinearVelocity(0f, 0.5f);
        }
        if(e.d==GameCharacter.dir.down && e.st==GameCharacter.state.walk){
            e.getBody().setLinearVelocity(0f, -0.5f);
        }
        if(e.d==GameCharacter.dir.left && e.st==GameCharacter.state.walk){
            e.getBody().setLinearVelocity(-0.5f, 0f);
        }
        if(e.d==GameCharacter.dir.right && e.st==GameCharacter.state.walk){
            e.getBody().setLinearVelocity(0.5f, 0f);
        }
    }
    
}
