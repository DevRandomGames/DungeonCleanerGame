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
        Player p = map.getPlayer();
        if(p.isStriking){
            
            Enemy e = map.getEnemy((Integer)monster.getUserData());
            e.disableControls(0.3f);

            int attack = p.getAttack();
            int stamina = p.getStamina();

            int life = e.getLife();
            int defense = e.getDefense();

            e.setLife(newLife(life,defense,attack,stamina));
            
            monster.setLinearVelocity(new Vector2(0f,0f));
            Vector2 dir = new Vector2(monster.getPosition().x,monster.getPosition().y);
            dir.sub(player.getPosition());
            dir.x = dir.x*7;
            dir.y = dir.y*7;
            
            monster.setLinearVelocity(dir);
            if(e.getLife() <= 0){
                map.killEnemy((Integer)monster.getUserData());
                e.killEnemy();
            }
            
        }
        
    }
    
    public void computeStrikeToPlayer(Body monster, Body player, WorldManifold mani){
        Player p = map.getPlayer();
        Enemy e = map.getEnemy((Integer)monster.getUserData());
        
        p.disableControls(0.3f);
        
        int attack = e.getAttack();
        int stamina = e.getStamina();
        
        int life = p.getLife();
        int defense = p.getDefense();
        
        p.setLife(newLife(life,defense,attack,stamina));
        
        player.setLinearVelocity(new Vector2(0f,0f));
        Vector2 dir = new Vector2(player.getPosition().x,player.getPosition().y);
        dir.sub(monster.getPosition());
        dir.x = dir.x*10;
        dir.y = dir.y*10;
        
        player.setLinearVelocity(dir);
    }
    
    private void computeBulletToPlayer(Body bullet,Body player,WorldManifold mani){
        Player p = map.getPlayer();
        
        
        p.disableControls(0.3f);
        
        int attack = 10;
        int stamina = 10;
        
        int life = p.getLife();
        int defense = p.getDefense();
        
        p.setLife(newLife(life,defense,attack,stamina));
        
        player.setLinearVelocity(new Vector2(0f,0f));
        Vector2 dir = new Vector2(player.getPosition().x,player.getPosition().y);
        dir.sub(bullet.getPosition());
        dir.x = dir.x*10;
        dir.y = dir.y*10;
        
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
