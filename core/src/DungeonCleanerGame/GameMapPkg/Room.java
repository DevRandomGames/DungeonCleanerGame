/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.GameMapPkg;

import DungeonCleanerGame.CharacterPkg.Enemy;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ivan
 */
public class Room {
    
    private TiledMap tiledMap;
    private int width;
    private int height;
    RoomInfo info;
    
    Room upDoor;
    Room downDoor;
    Room leftDoor;
    Room rightDoor;
    
    ArrayList<Enemy> Enemies;
    ArrayList<Object> Objects;
    ArrayList<Object> Chests;
    Random RG;
   
    public Room(String mapName){
        RG = new Random();
        info = new RoomInfo(mapName);
        GenerateRoom(mapName);
        
        //GenerateDoors();
        //GenerateEnemies();
        //GenerateObjects();
        //GenerateChests();
    }
       
    private void GenerateDoors(){
        
        int nd = RG.nextInt(5);
        for(int i=0;i<nd;++i){
            //TODO
            //add a position for every door
            //always in the walls of the room
        }
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
    
    private void GenerateRoom(String mapName){
        tiledMap = new TmxMapLoader().load("Rooms/"+mapName);
        width = tiledMap.getProperties().get("width",Integer.class);
        height = tiledMap.getProperties().get("height",Integer.class);
    }
    
    private void GenerateEnemies(){
       int ns = RG.nextInt((int)(10/*(Xsize*Ysize)/2*/));
       Enemies = new ArrayList();
       for(int i=0;i<ns;++i){
           Enemy e = new Enemy();
          // e.setXpos(RG.nextInt(Xsize));
          // e.setYpos(RG.nextInt(Ysize));
           Enemies.add(e);
       }
    }
    
    private void GenerateObjects(){
        int no = RG.nextInt((int)(/*(Xsize*Ysize)/4*/10));
    }
    
    private void GenerateChests(){
        
        //Now depends on the room size, maybe we can add some stat or skill
        //call it lucky that increase the likelihood of chest
        int nc;
        if(width*height > 20){
            nc = RG.nextInt(2);
        }
        else nc = 0;
        
        //
    }
    
}
