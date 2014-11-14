/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.GameMapPkg;

import DungeonCleanerGame.CharacterPkg.Enemy;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ivan
 */
public class Room {
    
    ArrayList Doors;
    int Xsize;
    int Ysize;
    StaticTiledMapTile[][] RoomMap;
    ArrayList<Enemy> Enemies;
    ArrayList<Object> Objects;
    ArrayList<Object> Chests;
    Random RG;
   
    public Room(){
        
        RG = new Random();
        GenerateRoom();
        GenerateDoors();
        GenerateEnemies();
        GenerateObjects();
        GenerateChests();
    }
    
    private void GenerateDoors(){
        
        int nd = RG.nextInt(5);
        for(int i=0;i<nd;++i){
            //TODO
            //add a position for every door
            //always in the walls of the room
        }
    }
    
    private void GenerateRoom(){
        
        Xsize = RG.nextInt(20)+1;
        Ysize = RG.nextInt(20)+1;
        Texture floor = new Texture("Piedra.png");
        RoomMap = new StaticTiledMapTile[Xsize][Ysize];
        TextureRegion cell = new TextureRegion(floor,1,1);
        for(int i=0;i<Xsize;++i){
            for(int j=0;j<Ysize;++j){
                RoomMap[i][j] = new StaticTiledMapTile(cell);
                //RoomMap[i][j].setTextureRegion(cell);
            }
        }
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
        if(Xsize*Ysize > 20){
            nc = RG.nextInt(2);
        }
        else nc = 0;
        
        //
    }
    
    public int getXsize(){
        return Xsize;
    }
    
    public int getYsize(){
        return Ysize;
    }
    
    public StaticTiledMapTile[][] getRoomMap(){
        return RoomMap;
    }
    
    
}
