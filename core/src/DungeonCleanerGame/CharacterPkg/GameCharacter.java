/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.CharacterPkg;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author ivan
 */
public class GameCharacter extends Actor{
    
    Texture texture;
    
    private int life;
    private int attack;
    private int defense;
    private int stamina;
  
    
    
    @Override
    public void draw(Batch batch, float alpha){
    batch.draw(texture,this.getX(),getY(),this.getOriginX(),this.getOriginY(),this.getWidth(),
            this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),0,0,
            texture.getWidth(),texture.getHeight(),false,false);
    }
    
    /*@Override
    public void draw(Batch batch, float alpha){
            batch.draw(texture,0,0);
            
    
    }*/
    

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

       
}
