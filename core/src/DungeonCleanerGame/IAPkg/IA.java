/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.IAPkg;

import DungeonCleanerGame.CharacterPkg.Enemy;
import DungeonCleanerGame.CharacterPkg.GameCharacter;

/**
 *
 * @author ivan
 */
public class IA {
    private float controlTime=0;
    
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
    
    public void stateSelection(Enemy e){
        
        
    }
    
    public void RandomDir(Enemy e,int i,float DeltaTime){
        controlTime+=DeltaTime;
        //System.out.println((int)controlTime);
      if(4-(int)controlTime==0){
            controlTime=0;
            switch(i){
                case 0:e.d=GameCharacter.dir.left;break;
                case 1:e.d=GameCharacter.dir.right;break;
                case 2:e.d=GameCharacter.dir.up;break;
                case 3:e.d=GameCharacter.dir.down;break;    
            }
        }
    }
}
