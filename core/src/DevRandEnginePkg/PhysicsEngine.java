/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import DungeonCleanerGame.CharacterPkg.GameCharacter;
import box2dLight.RayHandler;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ArclorenSarth
 */
public class PhysicsEngine {
    private DevRandEngine engine;
    private static PhysicsEngine INSTANCE = null;
    
    private World world;
    Box2DMapObjectParser parser;
    private RayHandler rayhandler;
    
    ArrayList<Body> deadBodies;
    
    
    private PhysicsEngine(DevRandEngine e){
        engine = e;
        deadBodies = new ArrayList();
    }
    
    private static void createInstance(DevRandEngine e){
        INSTANCE = new PhysicsEngine(e);
    }
    
    public static PhysicsEngine getInstance(DevRandEngine e){
        if(INSTANCE == null) createInstance(e);
        return INSTANCE;
    }
    
    public void renderPhysics(){
        world.step(1.0f/60.0f, 6, 2);
        for(int i=0; i < deadBodies.size(); ++i){
            world.destroyBody(deadBodies.get(i));
            deadBodies.remove(i);
        }
    }
    
    public World getWorld(){
        return world;
    }
    
    public void addDeadBodie(Body b){
        deadBodies.add(b);
    }      
    
    public void createWorld(TiledMap map, float unitScale){
        parser = new Box2DMapObjectParser();
        world = new World(new Vector2(0f,0f),true);
        parser.setUnitScale(unitScale);
        parser.load(world, map);
        if(rayhandler!=null ) rayhandler.dispose();
        rayhandler = new RayHandler(world);
    }
    
    
    public void createCharacters(ArrayList<GameCharacter> charList){
        //generar bodys a partir de una lista de Personages.
    }

    public RayHandler getRayhandler() {
       return rayhandler;
    }
    
    
}
