/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.GameMapPkg;

import DevRandEnginePkg.ConstantEngine;
import DevRandEnginePkg.RandomEngine;
import DungeonCleanerGame.CharacterPkg.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import java.util.ArrayList;


/**
 *
 * @author ivan
 */
public class Room {
    private ConstantEngine constant;
    private String mapName;
    private TiledMap tiledMap;
    private int width;
    private int height;
    RoomInfo info;
        
    Room upDoor;
    Room downDoor;
    Room leftDoor;
    Room rightDoor;
    
    public ArrayList<Enemy> Enemies;
    ArrayList<Object> Objects;
    ArrayList<Object> Chests;
    
   
    public Room(String mapName){
        constant = ConstantEngine.getInstance();
        this.mapName = mapName;
        info = new RoomInfo(mapName);
        GenerateRoom(mapName);
        upDoor = null;
        downDoor = null;
        leftDoor = null;
        rightDoor = null;
        
        GenerateEnemies();
        //GenerateObjects();
        //GenerateChests();
    }
    
    public String getMapName(){
        return this.mapName;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public TiledMap getRoomMap(){
        return tiledMap;
    }    
    
    public void GenerateRoom(String mapName){
        if(tiledMap != null) tiledMap.dispose();
        tiledMap = new TmxMapLoader().load("Rooms/"+mapName);
        width = tiledMap.getProperties().get("width",Integer.class);
        height = tiledMap.getProperties().get("height",Integer.class);
    }
    
    private void GenerateEnemies(){
        int ns = RandomEngine.randInt(2,width*height/2);
        Enemies = new ArrayList();
        int t;
        Enemy e;
        float x,y;
        float unitScale = constant.getFloatConstant("unitScale");
        for(int i=0;i<ns;++i){
            t = RandomEngine.randInt(0, 2);
            x = RandomEngine.randInt(2, width-2);
            y = RandomEngine.randInt(2, height-2);
            switch(t){
                case 0: e = new Worm(unitScale); break;
                case 1: e = new Ghost(unitScale); break;
                case 2: e = new Boss1(unitScale); break;
                default: e = new Worm(unitScale); break;
            }
            e.setPosition(x, y);
            Enemies.add(e);
       }
    }
    
    private void GenerateObjects(){
        int no = 0;
    }
    
    private void GenerateChests(){
        
        //Now depends on the room size, maybe we can add some stat or skill
        //call it lucky that increase the likelihood of chest
        int nc;
        if(width*height > 20){
            nc = 0;
        }
        else nc = 0;
        
        
    }
    
}
