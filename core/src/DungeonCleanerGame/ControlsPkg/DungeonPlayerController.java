/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.ControlsPkg;

import DevRandEnginePkg.ControlsEnginePkg.KeyMapper;
import DevRandEnginePkg.ControlsEnginePkg.PlayerController;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.*;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.*;
import DungeonCleanerGame.CharacterPkg.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;


/**
 *
 * @author ArclorenSarth
 */
public class DungeonPlayerController extends PlayerController{
    float attackCooldown;
    float attackTime;
    boolean striking;
   
    
    public DungeonPlayerController(Player p){
        super.timer = 0;
        super.ctrlIdentity = p;
        super.keyMap = new KeyMapper();
        //PONEMOS LOS CONTROLES AL KEYMAPPER
        super.keyMap.addKey("left", Input.Keys.A);
        super.keyMap.addKey("right", Input.Keys.D);
        super.keyMap.addKey("up", Input.Keys.W);
        super.keyMap.addKey("down", Input.Keys.S);
        super.keyMap.addKey("hit", Input.Keys.SPACE);
        
        attackCooldown = 0;
        striking = false;
        
        
    }
    

    @Override
    public void computeAction(int p, int e, int f){
        Player pl = (Player) super.ctrlIdentity;
        
        super.timer -= (Gdx.graphics.getDeltaTime());
        if(super.timer <=0){
            super.timer = 0;
            pl.controlsEnabled = true;
        }
        attackTime -= Gdx.graphics.getDeltaTime();
        if(attackTime <= 0) {
            attackTime = 0;
            striking = false;
            
        }
        attackCooldown -= Gdx.graphics.getDeltaTime();
        if(attackCooldown <= 0) {
            attackCooldown = 0;
        }
        
        
        float horizontalMov = 0;
        float verticalMov = 0;
        float speed = 2f;
        
        
        
        //COMPUTE CONTROLS AND CALCULATE FUTURE REACTIONS
        if(Gdx.input.isKeyPressed(keyMap.key("left"))){
            horizontalMov += (-speed);
        }
        if(Gdx.input.isKeyPressed(keyMap.key("right"))){
            horizontalMov += speed;
        }
        if(Gdx.input.isKeyPressed(keyMap.key("up"))){
            verticalMov += speed;
        }
        if(Gdx.input.isKeyPressed(keyMap.key("down"))){
            verticalMov += (-speed);
        }
        
        if(Gdx.input.isKeyPressed(keyMap.key("hit"))){
            if(attackTime > 0){
                striking = true;
            }
            else if(attackTime == 0 && attackCooldown == 0){
                striking = true;
                attackTime = 0.5f;
                attackCooldown = 0.9f;
            }
            
        }
        
        
        //Timer que desactiva controles
        if(pl.controlsEnabled){
            //COMPUTE FUTURE REACTION TO CONTROLS
            pl.getBody().setLinearVelocity(horizontalMov,verticalMov);
        
            pl.st = walk;
            if(horizontalMov > 0) pl.d = right;
            else if (horizontalMov < 0) pl.d = left;
            else if(verticalMov > 0) pl.d = up;
            else if (verticalMov < 0) pl.d = down;
        
            if(horizontalMov == 0 && verticalMov == 0) pl.st = standby;
        
            if(striking) {
                pl.isStriking = true;
                pl.st = strike;
            }
            else pl.isStriking = false;
            
            pl.getBody().getFixtureList().get(1).setSensor(!striking);
               
        }
        pl.getBody().setAngularVelocity(0f);
        
        
        
    }
    
}
