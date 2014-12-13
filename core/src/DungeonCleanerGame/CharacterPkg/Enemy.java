/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.CharacterPkg;

import DevRandEnginePkg.ConstantEngine;
import DevRandEnginePkg.DevRandEngine;
import DevRandEnginePkg.RandomEngine;
import DungeonCleanerGame.ControlsPkg.DungeonIAController;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
import DungeonCleanerGame.IAPkg.IA;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;



/**
 *
 * @author ivan
 */
public class Enemy extends GameCharacter {
    private final static DevRandEngine gameEng = DevRandEngine.getInstance();
    protected final static ConstantEngine constant = gameEng.gameConstant();
    private static IA myIA;
    private static final short GROUP_MONSTER = constant.getShortConstant("GROUP_MONSTER");
    private static final short GROUP_MONSTER_VISION = constant.getShortConstant("GROUP_MONSTER_VISION");
    private static int ID=0;
    
    private int enemyID;
    
    public Enemy(float unitScale){
        enemyID = ID;
        myIA = new IA();
        ++ID;
        //CREAMOS EL PLAYERCONTROLLER
        super.controls = new DungeonIAController(this);
        
    }
    
    public int getEnemyID(){
        return enemyID;
    }
    
    public void createBody(float x, float y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        super.body = gameEng.gamePhysics().getWorld().createBody(bodyDef);
        super.body.setUserData(enemyID);
        
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(this.getWidth()/4, this.getHeight()/4);
        FixtureDef fixtureBox = new FixtureDef();
        fixtureBox.shape = shape;
        fixtureBox.density = 2f;
        fixtureBox.filter.groupIndex = GROUP_MONSTER;
        body.createFixture(fixtureBox);
        shape.dispose();
        
        PolygonShape Areashape = new PolygonShape();
        Areashape.setAsBox(this.getWidth()*2, this.getHeight()*2);
        FixtureDef fixtureArea = new FixtureDef();
        fixtureArea.isSensor = true;
        fixtureArea.shape = Areashape;
        fixtureArea.density = 2f;
        fixtureArea.filter.groupIndex = GROUP_MONSTER_VISION;
        body.createFixture(fixtureArea);
        Areashape.dispose();
        
        
    }
    
    public int getTotalID(){
        return ID;
    }
    
    public GameCharacter.state iaComputeState(){
        
        return this.st;
    }
    
    public GameCharacter.dir iaComputeDir(){
        return myIA.RandomDir(RandomEngine.randInt(0,5));
    }
    
    public DungeonIAController getEnemyControls(){
        return (DungeonIAController) super.controls;
    }
}
