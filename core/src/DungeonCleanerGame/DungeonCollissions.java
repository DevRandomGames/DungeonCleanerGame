/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame;

import DevRandEnginePkg.DevRandEngine;
import com.badlogic.gdx.math.Vector2;
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
        if((contact.getFixtureA().getFilterData().groupIndex==-1 && contact.getFixtureB().getFilterData().groupIndex==-2)
            || (contact.getFixtureA().getFilterData().groupIndex==-2 && contact.getFixtureB().getFilterData().groupIndex==-1)){
            ++numC;
            eng.gameRender().addDebugString("CONTACT NUMBER = " + numC, 1);
            a.applyForceToCenter(-90,-30, true);
            if(contact.getFixtureA().isSensor()){
                eng.gameLogic().getMap().getActualRoom().
            }
        }
        /*else if(b.getUserData() != null && b.getUserData().equals("Player")){
            ++numC;
            eng.gameRender().addDebugString("CONTACT NUMBER = " + numC, 1);
            b.applyForceToCenter(-90,-30, true);
        }*/
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
