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
public class Ghost extends Enemy {

    public Ghost(float unitScale) {
        super(unitScale);
        this.setBounds(0f, 0f, 64*unitScale, 64*unitScale);
        super.life = Enemy.constant.getIntConstant("GhostLife");
        super.defense = Enemy.constant.getIntConstant("GhostDefense");
        super.attack = Enemy.constant.getIntConstant("GhostAttack");
        super.stamina = Enemy.constant.getIntConstant("GhostStamina");
        LoadTexture();
    }
    
    
    private void LoadTexture(){
        WalkSheet = new Texture(Gdx.files.internal("Ghost.png"));
        Bullet = new Texture(Gdx.files.internal("bullet.png"));
        //StrikeSheet = new Texture(Gdx.files.internal("Warrior_hit.png"));
        
        WalkRightTex = new TextureRegion[1];
        WalkLeftTex = new TextureRegion[1];
        WalkUpTex = new TextureRegion[1];
        WalkDownTex = new TextureRegion[1];
        
        /*StrikeRightTex = new TextureRegion[4];
        StrikeLeftTex= new TextureRegion[4];
        StrikeUpTex= new TextureRegion[4];
        StrikeDownTex = new TextureRegion[4];*/
        
        
        
        this.HEIGTH = WalkSheet.getHeight()/4;
        this.WIDTH = WalkSheet.getWidth();
       
        //NOTE: In Final version put sheet_rows and sheet_colums!
        TextureRegion[][] tmp = TextureRegion.split(WalkSheet,WalkSheet.getWidth(),WalkSheet.getHeight()/4);
        //TextureRegion[][] tmp2 = TextureRegion.split(StrikeSheet,StrikeSheet.getWidth()/4,StrikeSheet.getHeight()/4);
        //TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("WarriorAt.pack"));
        
        
        for(int i=0;i<1;++i){
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
        
        StrikeDown = new Animation(0, WalkDownTex[0]);
        StrikeLeft = new Animation(0, WalkLeftTex[0]);
        StrikeRight = new Animation(0,WalkRightTex[0]);
        StrikeUp = new Animation(0, WalkUpTex[0]);
        
        
        stndbydown = new Animation(0, WalkDownTex[0]);
        stndbyleft = new Animation(0, WalkLeftTex[0]);
        stndbyright = new Animation(0,WalkRightTex[0]);
        stndbyup = new Animation(0, WalkUpTex[0]);
    }
    
}
