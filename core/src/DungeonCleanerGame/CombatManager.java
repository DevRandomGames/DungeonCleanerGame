/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame;

import DevRandEnginePkg.DevRandEngine;
import DevRandEnginePkg.RandomEngine;
import DungeonCleanerGame.CharacterPkg.Enemy;
import DungeonCleanerGame.CharacterPkg.Player;
import DungeonCleanerGame.GameMapPkg.GameMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.WorldManifold;

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
    
    public void computeStrikeToMonster(Body player, Body monster, WorldManifold mani){
        
    }
    
    public void computeStrikeToPlayer(Body monster, Body player, WorldManifold mani){
        Player p = map.getPlayer();
        Enemy e = map.getEnemy((Integer)monster.getUserData());
        
        p.disableControls(0.7f);
        
        int attack = e.getAttack();
        int stamina = e.getStamina();
        
        int life = p.getLife();
        int defense = p.getDefense();
        
        p.setLife(newLife(life,defense,attack,stamina));
        player.setLinearVelocity(new Vector2(0f,0f));
        Vector2 dir = mani.getNormal();
        System.out.println(mani.getNormal().toString());
        //dir.add(point);
        dir.x = dir.x*-1*2;
        dir.y = dir.y*-1*2;
        player.applyForceToCenter(dir, true);
        player.setLinearVelocity(dir);
    }
    
    
    private int newLife(int oldLife, int defense, int attack, int stamina){
        int finalAttack = attack; //posteriormente aplicarle una mult con (stamina/maxStamina) o algo asi
        int randomDefense = RandomEngine.randInt(0, defense+1);
        finalAttack -= randomDefense;
        if(finalAttack < 0) finalAttack = 0;
        return oldLife - finalAttack;
    }
    
}
