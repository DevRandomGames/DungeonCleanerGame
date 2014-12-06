/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DevRandEnginePkg;

import DungeonCleanerGame.CharacterPkg.Enemy;
import DungeonCleanerGame.CharacterPkg.GameCharacter;
import DungeonCleanerGame.CharacterPkg.GameCharacter.dir;
import DungeonCleanerGame.CharacterPkg.GameCharacter.state;

/**
 *
 * @author ivan
 */
public class AIEngine {
    
    private static AIEngine INSTANCE;
    
    
    private static void createInstance(){
        INSTANCE = new AIEngine();
    }
    
    public static AIEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public void idiotWalk(Enemy e){
        
        if(e.d==dir.up && e.st==state.walk){
            e.getBody().setLinearVelocity(0f, 0.5f);
        }
        if(e.d==dir.down && e.st==state.walk){
            e.getBody().setLinearVelocity(0f, -0.5f);
        }
        if(e.d==dir.left && e.st==state.walk){
            e.getBody().setLinearVelocity(-0.5f, 0f);
        }
        if(e.d==dir.right && e.st==state.walk){
            e.getBody().setLinearVelocity(0.5f, 0f);
        }
    }
    
    public void stateSelection(Enemy e){
        e.st = state.walk;
    }
    
    public void RandomDir(Enemy e,int i){
        
        switch(i){
            case 0:e.d=dir.left;break;
            case 1:e.d=dir.right;break;
            case 2:e.d=dir.up;break;
            case 3:e.d=dir.down;break;    
        }
    }
}
