/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.IAPkg;

import DungeonCleanerGame.CharacterPkg.Enemy;
import DungeonCleanerGame.CharacterPkg.GameCharacter;
import DungeonCleanerGame.CharacterPkg.GameCharacter.dir;
import com.badlogic.gdx.physics.box2d.Body;

/**
 *
 * @author ivan
 */
public class IA {
    
    private boolean alert;
    private boolean hitting;
    
    private float alertTimer;
    private float hittingTimer;
    
    private Body playerBody;
    
    public IA(){
        alert = false;
        hitting = false;
        alertTimer=0;
    }
    
    public boolean getAlert(){
        return alert;
    }
    
    public void actAlert(Body bp){
        alert = true;
        playerBody = bp;
        alertTimer=5;
    }
    
    public void decAlert(){
        alert = false;
        alertTimer=0;
    }
    
    public void setHit(boolean b){
        hitting = b;
    }
    
    public boolean getHit(){
        return hitting;
    }
    
    public void clearTimer(){
        alertTimer=0;
    }
    
    public void subTime(float time){
        alertTimer-=time;
        if(alertTimer<0) alertTimer=0;
    }
    
    public void addTime(float time){
        alertTimer+=time;
        if(alertTimer>5) alertTimer=5;
    }
    
    public float getTime(){
        return alertTimer;
    }
    
    public GameCharacter.dir nextDirToPlayer(float x, float y){
        
        System.out.println("NEXT DIR");
        int diffx = (int)x - (int)playerBody.getPosition().x;
        int diffy = (int)y - (int)playerBody.getPosition().y;
        if(Math.abs(diffx)<Math.abs(diffy)){
            if(diffx<0){
                return dir.right;
            }
            else return dir.left;
        }
        else{
            if(diffy<0){
                return dir.up;
            }
            else return dir.down;
        }
    }
    
    public GameCharacter.dir RandomDir(int i){
        System.out.println("RANDOM DIR");
        switch(i){
            case 0: return  GameCharacter.dir.left;
            case 1: return  GameCharacter.dir.right;
            case 2: return  GameCharacter.dir.up;
            case 3: return GameCharacter.dir.down;
            default: return GameCharacter.dir.down;
        }
    }
    
    private boolean equalsInRange(float a, float b){
        int ai = (int) a;
        int bi = (int) b;
        
        if(ai-1<=bi || bi<=ai+1) return true;
        return false;
    }
    
}
