/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.CharacterPkg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author ivan
 */
public class Boss1 extends Enemy{

    public Boss1(float unitScale) {
        super(unitScale);
        super.life = Enemy.constant.getIntConstant("BossLife");
        super.defense = Enemy.constant.getIntConstant("BossDefense");
        super.attack = Enemy.constant.getIntConstant("BossAttack");
        super.stamina = Enemy.constant.getIntConstant("BossStamina");
        LoadTexture();
    }
    
    
    private void LoadTexture(){
        WalkSheet = new Texture(Gdx.files.internal("BigDady.png"));
        //StrikeSheet = new Texture(Gdx.files.internal("Warrior_hit.png"));
        
        WalkRightTex = new TextureRegion[4];
        WalkLeftTex = new TextureRegion[4];
        WalkUpTex = new TextureRegion[4];
        WalkDownTex = new TextureRegion[4];
        
        /*StrikeRightTex = new TextureRegion[4];
        StrikeLeftTex= new TextureRegion[4];
        StrikeUpTex= new TextureRegion[4];
        StrikeDownTex = new TextureRegion[4];*/
        
        
        
        this.HEIGTH = WalkSheet.getHeight()/4;
        this.WIDTH = WalkSheet.getWidth()/4;
       
        //NOTE: In Final version put sheet_rows and sheet_colums!
        TextureRegion[][] tmp = TextureRegion.split(WalkSheet,WalkSheet.getWidth()/4,WalkSheet.getHeight()/4);
        //TextureRegion[][] tmp2 = TextureRegion.split(StrikeSheet,StrikeSheet.getWidth()/4,StrikeSheet.getHeight()/4);
        //TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("WarriorAt.pack"));
        
        
        for(int i=0;i<4;++i){
            WalkDownTex[i] = tmp[3][i];
            WalkLeftTex[i] = tmp[0][i];
            WalkRightTex[i] = tmp[2][i];
            WalkUpTex[i] = tmp[1][i];
            /*StrikeRightTex[i] = tmp2[0][i];
            StrikeLeftTex[i]= tmp2[3][i];
            StrikeUpTex[i]= tmp2[2][i];
            StrikeDownTex[i] = tmp2[1][i];*/
        }
        
        
        
        WalkDown = new Animation(0.3f,WalkDownTex);
        WalkLeft = new Animation(0.3f,WalkLeftTex);
        WalkRight = new Animation(0.3f,WalkRightTex);
        WalkUp = new Animation(0.3f,WalkUpTex);
        
        /*StrikeUp = new Animation(0.1f,StrikeUpTex);
        StrikeDown =new Animation(0.1f,StrikeDownTex);
        StrikeLeft = new Animation(0.1f,StrikeLeftTex);
        StrikeRight = new Animation(0.1f,StrikeRightTex);*/
        
        
        stndbydown = new Animation(0, WalkDownTex[0]);
        stndbyleft = new Animation(0, WalkLeftTex[0]);
        stndbyright = new Animation(0,WalkRightTex[0]);
        stndbyup = new Animation(0, WalkUpTex[0]);
    }
    
}
