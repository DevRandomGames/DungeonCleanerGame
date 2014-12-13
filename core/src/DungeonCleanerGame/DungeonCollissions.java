/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame;

import DevRandEnginePkg.ConstantEngine;
import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.GameMapPkg.GameMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 *
 * @author ArclorenSarth
 */
public class DungeonCollissions implements ContactListener{
    private static final DevRandEngine eng = DevRandEngine.getInstance();
    private static final ConstantEngine cons = eng.gameConstant();
    private static final short gP = cons.getShortConstant("GROUP_PLAYER");
    private static final short gPW = cons.getShortConstant("GROUP_PLAYER_WEAPON");
    private static final short gM = cons.getShortConstant("GROUP_MONSTER");
    private static final short gMV = cons.getShortConstant("GROUP_MONSTER_VISION");
    private final CombatManager combat;
    private final GameMap gmap;
    int numPlyHits;
    int numMonHits;
    int numMonDetect;
    
    public DungeonCollissions(CombatManager combat,GameMap gmap){
        this.combat = combat;
        this.gmap = gmap;
        numPlyHits = 0;
        numMonHits = 0;
    }
    
    
    @Override
    public void beginContact(Contact contact){
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
        Body Player;
        Body Monster;
        if((fixA.getFilterData().groupIndex==gPW && fixB.getFilterData().groupIndex==gM)
            || (fixA.getFilterData().groupIndex==gM && fixB.getFilterData().groupIndex==gPW)){
            ++numPlyHits;
            eng.gameRender().addDebugString("PlayerHits = " + numPlyHits, 1);
            if(fixB.getFilterData().groupIndex==gM) {
                Monster = fixB.getBody();
                Player = fixA.getBody();
            }
            else {
                Monster = fixA.getBody();
                Player = fixB.getBody();
            }
            combat.computeStrikeToMonster(Player, Monster);
        }
        else if((fixA.getFilterData().groupIndex==gP && fixB.getFilterData().groupIndex==gM)
            || (fixA.getFilterData().groupIndex==gM && fixB.getFilterData().groupIndex==gP)){
            ++numMonHits;
            eng.gameRender().addDebugString("MonsterHits = " + numMonHits, 2);
            if(fixB.getFilterData().groupIndex==gP){
                Player = fixB.getBody();
                Monster = fixA.getBody();
            }
            else {
                Player = fixA.getBody();
                Monster = fixB.getBody();
            }
            combat.computeStrikeToPlayer(Monster, Player);
        }
        else if((fixA.getFilterData().groupIndex==gP && fixB.getFilterData().groupIndex==gMV)
            || (fixA.getFilterData().groupIndex==gMV && fixB.getFilterData().groupIndex==gP)){
            ++numMonDetect;
            eng.gameRender().addDebugString("MonsterDetection = " + numMonDetect, 3);
            if(fixB.getFilterData().groupIndex==gP){
                Player = fixB.getBody();
                Monster = fixA.getBody();
            }
            else {
                Player = fixA.getBody();
                Monster = fixB.getBody();
            }
            
            int monsterID = (Integer) Monster.getUserData();
            gmap.getEnemy(monsterID);
            
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
