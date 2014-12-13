/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame;

import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.GameMapPkg.GameMap;
import com.badlogic.gdx.physics.box2d.Body;

/**
 *
 * @author ArclorenSarth
 */
public class CombatManager {
    private static final DevRandEngine engine = DevRandEngine.getInstance();
    private GameMap map;
           
    CombatManager(GameMap map){
        this.map = map;
        
    }
    
    public void computeStrikeToMonster(Body player, Body monster){
        
    }
    
    public void computeStrikeToPlayer(Body monster, Body player){
        
    }
    
}
