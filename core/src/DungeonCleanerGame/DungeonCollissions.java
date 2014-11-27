/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame;

import DevRandEnginePkg.DevRandEngine;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 *
 * @author ArclorenSarth
 */
public class DungeonCollissions implements ContactListener{
    int numC;
    DevRandEngine eng;
    
    public DungeonCollissions(){
        numC = 0;
        eng = DevRandEngine.getInstance();
    }
    
    
    @Override
    public void beginContact(Contact contact){
        Body a=contact.getFixtureA().getBody();
        Body b=contact.getFixtureB().getBody();
        if(b.getUserData() != null && b.getUserData().equals("Player")){
            ++numC;
            eng.gameRender().addDebugString("CONTACT NUMBER = " + numC, 1);
        }
    }
    
    @Override
    public void endContact(Contact contact){

    }
    
    @Override
    public void postSolve(Contact contact, ContactImpulse impulse){

    }
    
    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }
}
