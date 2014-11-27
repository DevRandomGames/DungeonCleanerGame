/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.CharacterPkg;

import DevRandEnginePkg.ControlsEnginePkg.KeyMapper;
import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 *
 * @author ivan
 */
public class Player extends GameCharacter{
    private DevRandEngine gameEng;
    
    public Player(){
        //super.texture = t;
        setBounds(0,0,64/100f,64/100f);
        //super.setWidth(64/100f);
        //super.setHeight(64/100f);
        //CREAMOS EL PLAYERCONTROLLER Y ANADIMOS AL CONTROLS ENGINE
        super.controls = new DungeonPlayerController(this);
        gameEng = DevRandEngine.getInstance();
        //HAVE TO CREATE BODY OR IT MAYBE CRASH
    }
    
    public void createBody(int x, int y){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        super.body = gameEng.gamePhysics().getWorld().createBody(bodyDef);
        super.body.setUserData("Player");
        this.setPosition(body.getPosition().x,body.getPosition().y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(this.getWidth()/4*this.getScaleX(), this.getHeight()/4*this.getScaleY());
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 2f;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
    }
    
    
    
    
    public DungeonPlayerController getPlayerControls(){
        return (DungeonPlayerController) super.controls;
    }
   
    
}
