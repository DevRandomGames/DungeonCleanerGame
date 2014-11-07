/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStuff;

import CharacterPkg.Enemy;
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
    Box[][] RoomMap;
    ArrayList Enemies;
    ArrayList Objects;
    ArrayList Chests;
    Random RG;
   
    private Room(){
        
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
        
        for(int i=0;i<Xsize;++i){
            for(int j=0;j<Ysize;++j){
                RoomMap[i][j] = new Box();
            }
        }
    }
    
    private void GenerateEnemies(){
       int ns = RG.nextInt((int)((Xsize*Ysize)/2));
       
       for(int i=0;i<ns;++i){
           Enemy e = new Enemy();
           e.setXpos(RG.nextInt(Xsize));
           e.setYpos(RG.nextInt(Ysize));
           Enemies.add(e);
       }
    }
    
    private void GenerateObjects(){
        int no = RG.nextInt((int)((Xsize*Ysize)/4));
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
    
}


