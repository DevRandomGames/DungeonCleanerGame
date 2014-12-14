/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.CharacterPkg;

import DevRandEnginePkg.ControlsEnginePkg.ActionController;
import DevRandEnginePkg.DevRandEngine;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.right;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.standby;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 *
 * @author ivan
 */
public class GameCharacter extends Actor{
    
    protected ActionController controls;
    protected Body body;
    
    public Boolean controlsEnabled = true;
    public Boolean isStriking = false;
    
    protected int life;
    protected int attack;
    protected int defense;
    protected int stamina;
    
    protected int maxLife;
    protected int maxStamina;
    
    
    int sheet_rows;
    int sheet_columns;
    String PathToSheet;
    
    Texture WalkSheet;
    Texture StrikeSheet;
    
    int HEIGTH;
    int WIDTH;
    
    
    TextureRegion[] WalkRightTex;
    TextureRegion[] WalkLeftTex;
    TextureRegion[] WalkUpTex;
    TextureRegion[] WalkDownTex;
    
    TextureRegion[] StrikeRightTex;
    TextureRegion[] StrikeLeftTex;
    TextureRegion[] StrikeUpTex;
    TextureRegion[] StrikeDownTex;
    
    
    public enum state{
        walk,
        die,
        strike,
        standby,
        stalk;
    }
    
    public enum dir{
        up,
        down,
        right,
        left,
        not;
    }
    
    TextureRegion texture;
    public dir d=right;
    public state st=standby;
    
       
    Animation WalkUp;
    Animation WalkDown;
    Animation WalkLeft;
    Animation WalkRight;
    Animation stndbyleft;
    Animation stndbyright ;
    Animation stndbyup;
    Animation stndbydown;
    Animation StrikeUp;
    Animation StrikeDown;
    Animation StrikeLeft;
    Animation StrikeRight;
    
    
    float statetime=1;
    
  
    
    
    @Override
    public void draw(Batch batch, float alpha){
        
        texture = UpdateCharacter(Gdx.graphics.getDeltaTime());
        batch.draw(texture,
                   body.getPosition().x-((float)this.getWidth()/2f),
                   body.getPosition().y-((float)this.getHeight()/2f),
                   this.getOriginX(),this.getOriginY(),this.getWidth(),
                   this.getHeight(),this.getScaleX(), this.getScaleY(),
                   this.getRotation(),false);
    }
    
    
    /*public void LoadTexture(){
       //OVERRIDEN
    }*/
    
    public void disableControls(float seconds){
        controls.timer = seconds;
        controlsEnabled = false;
    }
    
    
    public float getBodyX(){
        return body.getPosition().x;
    }
    
    
    public float getBodyY(){
        return body.getPosition().y;
    }
    
       
    public ActionController getControls(){
        return controls;
    }
    
    public Body getBody(){
        return body;
    }
           
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

    
    
    private TextureRegion UpdateCharacter(float DeltaTime){
        
        statetime+=DeltaTime;
        
        Animation fm = stndbyright ;
        boolean loop = true;
        
        switch(st){
            case walk:
                fm = GetWalkAnimation(d);
            break;
            case standby:
                fm = GetStnAnimation(d);
            break; 
            case strike:
                fm = GetStrikeAnimation(d);
            break;
            case stalk:
                fm = GetWalkAnimation(d);
            break;
                
        }
        
        return fm.getKeyFrame(statetime, loop);
    
    }
    
    private Animation GetWalkAnimation(dir d){
        Animation fm = null;
        switch(d){
            case down: fm = WalkDown; break;
            case left: fm=WalkLeft; break;
            case right: fm=WalkRight; break;
            case up: fm=WalkUp; break;  
        }
        return fm;
    }
    
    private Animation GetStnAnimation(dir d){
        Animation fm = null;
        switch(d){
            case down: fm=stndbydown; break;
            case left: fm=stndbyleft; break;
            case right: fm=stndbyright; break;
            case up: fm=stndbyup; break;    
        }
        return fm;
    }
    
    private Animation GetStrikeAnimation(dir d){
        Animation fm = null;
        switch(d){
            case down: fm = StrikeDown; break;
            case left: fm=StrikeLeft; break;
            case right: fm=StrikeRight; break;
            case up: fm=StrikeUp; break;  
        }
        return fm;
    }
    
       
}
