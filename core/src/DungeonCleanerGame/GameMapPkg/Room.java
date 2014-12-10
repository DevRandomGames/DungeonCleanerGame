/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.GameMapPkg;

import DevRandEnginePkg.RandomEngine;
import DungeonCleanerGame.CharacterPkg.Enemy;
import DungeonCleanerGame.CharacterPkg.Worm;
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
    private RandomEngine random;
    
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
       int ns = 0;
       Enemies = new ArrayList();
       for(int i=0;i<ns;++i){
           
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
