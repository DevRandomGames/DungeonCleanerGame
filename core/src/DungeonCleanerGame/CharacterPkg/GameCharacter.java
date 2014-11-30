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
        standby;
    }
    
    public enum dir{
        up,
        down,
        right,
        left
    }
    
    TextureRegion texture;
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
    private Animation StrikeUp;
    private Animation StrikeDown;
    private Animation StrikeLeft;
    private Animation StrikeRight;
    
    
    float statetime=1;
    
  
    
    
    @Override
    public void draw(Batch batch, float alpha){
        
    texture = UpdatePlayer(Gdx.graphics.getDeltaTime());
    //texture = WalkUpTex[0].getTexture();
    
    batch.draw(texture,
               body.getPosition().x-((float)this.getWidth()/2f),
               body.getPosition().y-((float)this.getHeight()/2f),
               this.getOriginX(),this.getOriginY(),this.getWidth(),
               this.getHeight(),this.getScaleX(), this.getScaleY(),
               this.getRotation(),false);
    }
    
    @Override
    public float getX(){
        return body.getPosition().x;
    }
    
    @Override
    public float getY(){
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

    public void LoadPlayerTexture(){
        WalkSheet = new Texture(Gdx.files.internal("Warrior.png"));
        StrikeSheet = new Texture(Gdx.files.internal("Warrior_hit.png"));
        
        WalkRightTex = new TextureRegion[4];
        WalkLeftTex = new TextureRegion[4];
        WalkUpTex = new TextureRegion[4];
        WalkDownTex = new TextureRegion[4];
        StrikeRightTex = new TextureRegion[4];
        StrikeLeftTex= new TextureRegion[4];
        StrikeUpTex= new TextureRegion[4];
        StrikeDownTex = new TextureRegion[4];
        
        
        
        this.HEIGTH = WalkSheet.getHeight()/4;
        this.WIDTH = WalkSheet.getWidth()/4;
       
        //NOTE: In Final version put sheet_rows and sheet_colums!
        TextureRegion[][] tmp = TextureRegion.split(WalkSheet,WalkSheet.getWidth()/4,WalkSheet.getHeight()/4);
        TextureRegion[][] tmp2 = TextureRegion.split(StrikeSheet,StrikeSheet.getWidth()/4,StrikeSheet.getHeight()/4);
        //TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("WarriorAt.pack"));
        
        
        for(int i=0;i<4;++i){
            WalkDownTex[i] = tmp[1][i];
            WalkLeftTex[i] = tmp[3][i];
            WalkRightTex[i] = tmp[0][i];
            WalkUpTex[i] = tmp[2][i];
            StrikeRightTex[i] = tmp2[0][i];
            StrikeLeftTex[i]= tmp2[3][i];
            StrikeUpTex[i]= tmp2[2][i];
            StrikeDownTex[i] = tmp2[1][i];
        }
        
        
        
        WalkDown = new Animation(0.3f,WalkDownTex);
        WalkLeft = new Animation(0.3f,WalkLeftTex);
        WalkRight = new Animation(0.3f,WalkRightTex);
        WalkUp = new Animation(0.3f,WalkUpTex);
        
        StrikeUp = new Animation(0.1f,StrikeUpTex);
        StrikeDown =new Animation(0.1f,StrikeDownTex);
        StrikeLeft = new Animation(0.1f,StrikeLeftTex);
        StrikeRight = new Animation(0.1f,StrikeRightTex);
        
        
        stndbydown = new Animation(0, WalkDownTex[0]);
        stndbyleft = new Animation(0, WalkLeftTex[0]);
        stndbyright = new Animation(0,WalkRightTex[0]);
        stndbyup = new Animation(0, WalkUpTex[0]);

     
    }
    
    private TextureRegion UpdatePlayer(float DeltaTime){
        
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
