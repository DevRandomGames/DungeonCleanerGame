/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.CharacterPkg;

import DevRandEnginePkg.ConstantEngine;
import DevRandEnginePkg.ControlsEnginePkg.KeyMapper;
import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 *
 * @author ivan
 */
public class Player extends GameCharacter{
    private static final DevRandEngine gameEng = DevRandEngine.getInstance();
    private static final ConstantEngine constant = gameEng.gameConstant();
    private static final short GROUP_PLAYER = constant.getShortConstant("GROUP_PLAYER");
    private static final short GROUP_PLAYER_WEAPON = constant.getShortConstant("GROUP_PLAYER_WEAPON");
    
    public Player(float unitScale){
        setBounds(0,0,64*unitScale,64*unitScale);
        super.life = constant.getIntConstant("PlayerLife");
        super.defense = constant.getIntConstant("PlayerDefense");
        super.attack = constant.getIntConstant("PlayerAttack");
        super.stamina = constant.getIntConstant("PlayerStamina");
        //CREAMOS EL PLAYERCONTROLLER
        super.controls = new DungeonPlayerController(this);
        LoadTexture();
    }
    
    public void createBody(float x, float y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        super.body = gameEng.gamePhysics().getWorld().createBody(bodyDef);
        super.body.setUserData("Player");
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(this.getWidth()/5f, this.getHeight()/5f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 2f;
        fixtureDef.filter.groupIndex=GROUP_PLAYER;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        
             
        shape = new PolygonShape();
        shape.setAsBox(this.getWidth()/2, this.getHeight()/2);
        FixtureDef fixtureDef2 = new FixtureDef();
        fixtureDef2.shape = shape;
        fixtureDef2.density = 2f;
        fixtureDef2.isSensor = true;
        fixtureDef2.filter.groupIndex=GROUP_PLAYER_WEAPON;
        fixture = body.createFixture(fixtureDef2);
        shape.dispose();
        
    }
    
    
    private void LoadTexture(){
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
    
    
    
    
    public DungeonPlayerController getPlayerControls(){
        return (DungeonPlayerController) super.controls;
    }
   
    
}
