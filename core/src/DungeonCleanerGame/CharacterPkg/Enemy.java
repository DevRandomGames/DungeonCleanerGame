/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.CharacterPkg;

import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.ControlsPkg.DungeonIAController;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
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
    private DevRandEngine gameEng;
    private final short GROUP_MONSTER=-2;
    static private int ID=0;
    
    
    public Enemy(float unitScale){
        setBounds(0,0,64*unitScale,64*unitScale);
        ++ID;
        //CREAMOS EL PLAYERCONTROLLER
        super.controls = new DungeonIAController(this);
        gameEng = DevRandEngine.getInstance();
    }
    
    public void createBody(float x, float y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        super.body = gameEng.gamePhysics().getWorld().createBody(bodyDef);
        super.body.setUserData(ID);
        
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
        fixtureArea.filter.groupIndex = GROUP_MONSTER;
        body.createFixture(fixtureArea);
        shape.dispose();
        
        
    }
    
    public int getID(){
        return ID;
    }
    
    public DungeonIAController getEnemyControls(){
        return (DungeonIAController) super.controls;
    }
}
