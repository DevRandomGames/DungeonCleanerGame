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
    
    int HEIGTH;
    int WIDTH;
    
    
    TextureRegion[] WalkRightTex;
    TextureRegion[] WalkLeftTex;
    TextureRegion[] WalkUpTex;
    TextureRegion[] WalkDownTex;
    
    
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
    
    float statetime=1;
    
  
    
    
    @Override
    public void draw(Batch batch, float alpha){
        
    texture = UpdatePlayer(Gdx.graphics.getDeltaTime());
    //texture = WalkUpTex[0].getTexture();
    //System.out.println(texture.getWidth()+" "+texture.getHeight());
    batch.draw(texture,body.getPosition().x-(this.WIDTH/2),body.getPosition().y-(this.HEIGTH/2),this.getOriginX(),this.getOriginY(),this.getWidth(),
            this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),false);
    }
    
    /*@Override
    public void draw(Batch batch, float alpha){
            batch.draw(texture,0,0);
            
    
    }*/
    
    
    
    
    
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
        
        WalkRightTex = new TextureRegion[4];
        WalkLeftTex = new TextureRegion[4];
        WalkUpTex = new TextureRegion[4];
        WalkDownTex = new TextureRegion[4];
        
        this.HEIGTH = WalkSheet.getHeight()/4;
        this.WIDTH = WalkSheet.getWidth()/4;
       
        //NOTE: In Final version put sheet_rows and sheet_colums!
        TextureRegion[][] tmp = TextureRegion.split(WalkSheet,WalkSheet.getWidth()/4,WalkSheet.getHeight()/4);
        //TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("WarriorAt.pack"));
        //System.out.println(WalkSheet.getWidth()+" "+WalkSheet.getHeight());
        
        //System.out.println(atlas.findRegion("Warrior_0-0.jpeg").getTexture());
        
        for(int i=0;i<4;++i){
            WalkDownTex[i] = tmp[1][i];
            WalkLeftTex[i] = tmp[3][i];
            WalkRightTex[i] = tmp[0][i];
            WalkUpTex[i] = tmp[2][i];
            
            System.out.println(WalkUpTex[i].getTexture().getHeight());
        }
        
        
        
        WalkDown = new Animation(0.3f,WalkDownTex);
        WalkLeft = new Animation(0.3f,WalkLeftTex);
        WalkRight = new Animation(0.3f,WalkRightTex);
        WalkUp = new Animation(0.3f,WalkUpTex);
        
        System.out.println(WalkUp.getAnimationDuration()+" ");
        
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
                
        }
        System.out.println("statetime:"+statetime+" Index:"+fm.getKeyFrameIndex(statetime));
        return fm.getKeyFrame(statetime, loop);
    
    }
    
    private Animation GetWalkAnimation(dir d){
        Animation fm = null;
        switch(d){
            case down: fm = WalkDown; System.out.println("WD"); break;
            case left: fm=WalkLeft; System.out.println("WL"); break;
            case right: fm=WalkRight;System.out.println("WR"); break;
            case up: fm=WalkUp;System.out.println("WU"); break;  
        }
        return fm;
    }
    
    private Animation GetStnAnimation(dir d){
        Animation fm = null;
        switch(d){
            case down: fm=stndbydown;System.out.println("SD"); break;
            case left: fm=stndbyleft;System.out.println("SL"); break;
            case right: fm=stndbyright;System.out.println("SR"); break;
            case up: fm=stndbyup;System.out.println("SU"); break;    
        }
        return fm;
    }
    
       
}
