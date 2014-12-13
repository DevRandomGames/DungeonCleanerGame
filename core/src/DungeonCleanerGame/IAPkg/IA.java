/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.IAPkg;

import DungeonCleanerGame.CharacterPkg.Enemy;
import DungeonCleanerGame.CharacterPkg.GameCharacter;
import DungeonCleanerGame.CharacterPkg.GameCharacter.dir;

/**
 *
 * @author ivan
 */
public class IA {
    private float controlTime=0;
    
    public IA(){
        
    }
    public void stateSelection(Enemy e){
        
        
    }
    
    public GameCharacter.dir RandomDir(int i){
        switch(i){
            case 0: return  GameCharacter.dir.left;
            case 1: return  GameCharacter.dir.right;
            case 2: return  GameCharacter.dir.up;
            case 3: return GameCharacter.dir.down;
            default: return GameCharacter.dir.down;
        }
    }
}
