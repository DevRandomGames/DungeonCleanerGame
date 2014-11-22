/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.CharacterPkg;

import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.right;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.standby;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author ivan
 */
public class GameCharacter extends Actor{
    
    int sheet_rows;
    int sheet_columns;
    String PathToSheet;
    
    Texture WalkSheet;
    
    public enum state{
        walk,
        die,
        strike,
        standby;
    }
    
    public enum dir{
        up,
        down,
        right,
        left
    }
    
    Texture texture;
    public dir d=right;
    public state st=standby;
    
    private int life;
    private int attack;
    private int defense;
    private int stamina;
    
    private Animation WalkUp;
    private Animation WalkDown;
    private Animation WalkLeft;
    private Animation WalkRight;
    private Animation stndbyleft;
    private Animation stndbyright ;
    private Animation stndbyup;
    private Animation stndbydown;
    
    float statetime=1;
    
  
    
    
    @Override
    public void draw(Batch batch, float alpha){
        
     texture = UpdatePlayer(Gdx.graphics.getDeltaTime());
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

    public void LoadPlayerTexture(){
        WalkSheet = new Texture(Gdx.files.internal("Warrior.png"));
       
        //NOTE: In Final version put sheet_rows and sheet_colums!
        TextureRegion[][] tmp = TextureRegion.split(WalkSheet,WalkSheet.getWidth()/4,WalkSheet.getHeight()/4);
        
        WalkDown = new Animation(0.5f,tmp[0]);
        WalkLeft = new Animation(0.5f,tmp[1]);
        WalkRight = new Animation(0.5f,tmp[2]);
        WalkUp = new Animation(0.5f,tmp[3]);
        
        stndbydown = new Animation(0, tmp[0][0]);
        stndbyleft = new Animation(0, tmp[1][0]);
        stndbyright = new Animation(0, tmp[2][0]);
        stndbyup = new Animation(0, tmp[3][0]);

     
    }
    
    private Texture UpdatePlayer(float DeltaTime){
        
        statetime+=DeltaTime;
        
        Animation fm = stndbyright ;
        boolean loop = true;
        
        switch(st){
            case walk:
                switch(d){
                    case down: fm=WalkDown;
                    case left: fm=WalkLeft;
                    case right: fm=WalkRight;
                    case up: fm=WalkUp;    
                }
            break;
            case standby:
                switch(d){
                    case down: fm=stndbydown;
                    case left: fm=stndbyleft;
                    case right: fm=stndbyright;
                    case up: fm=stndbyup;    
                }
            break;    
                
        }
        
        return fm.getKeyFrame(statetime, loop).getTexture();
    
    }
    
    
    
       
}
