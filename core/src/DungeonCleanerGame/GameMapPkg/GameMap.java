/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.GameMapPkg;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ArclorenSarth
 */
public class GameMap {
    Room actualRoom;
    Vector2 actualPos;
    String[] mapNamesLeft = {"BigRoom1.tmx","Exterior1.tmx","ForgeRoom.tmx"};
    String[] mapNamesRight = {"BigRoom1.tmx","ForgeRoom.tmx"};
    String[] mapNamesUp = {"ForgeRoom.tmx"};
    String[] mapNamesDown = {"BigRoom1.tmx","ForgeRoom.tmx"};
    String[][] mapNames = {mapNamesLeft,mapNamesRight,mapNamesUp,mapNamesDown};
    
    ArrayList<Room> DungeonMap;
    int numberofrooms;
    
    public GameMap(){
        DungeonMap = new ArrayList();
        numberofrooms = 5;
        actualPos = new Vector2(0f,0f);
    }
    
    public void newRoom(String roomName){
        Room r = new Room(roomName);
        DungeonMap.add(r);
        actualRoom = r;
    }
    
    public Room newRandomRoom(int i){
        return new Room(mapNames[i][randInt(0,mapNames[i].length)]);
    }
            
    public Room getRoom(int i){
        return DungeonMap.get(i);
    }
    
    public Room getActualRoom(){
        return actualRoom;
    }
    
    public Vector2 getActualPos(){
        return actualPos;
    }
    
    public boolean checkDoors(float posX, float posY){
        Room old = actualRoom;
        if(posX < actualRoom.info.leftBoundry){
            if(actualRoom.leftDoor == null){
                Room r = newRandomRoom(1);
                if(r.info.rightDoorPos == null) return false;
                DungeonMap.add(r);
                actualRoom = r;
                old.leftDoor = r;
                actualRoom.rightDoor = old;
                
            }
            else {
                actualRoom = actualRoom.leftDoor; 
                actualRoom.GenerateRoom(actualRoom.getMapName());
            }
            actualPos.x = actualRoom.info.rightDoorPos.x;
            actualPos.y = actualRoom.info.rightDoorPos.y;
            return true;
        }
        else if(posX > actualRoom.info.rightBoundry){
            if(actualRoom.rightDoor == null){
                Room r = newRandomRoom(0);
                if(r.info.leftDoorPos == null) return false;
                DungeonMap.add(r);
                actualRoom = r;
                old.rightDoor = r;
                actualRoom.leftDoor = old;
            }
            else {
                actualRoom = actualRoom.rightDoor; 
                actualRoom.GenerateRoom(actualRoom.getMapName());
            }
            actualPos.x = actualRoom.info.leftDoorPos.x;
            actualPos.y = actualRoom.info.leftDoorPos.y;
            return true;
        }
        else if(posY > actualRoom.info.upBoundry){
            if(actualRoom.upDoor == null){
                Room r = newRandomRoom(3);
                if(r.info.downDoorPos == null) return false;
                DungeonMap.add(r);
                actualRoom = r;
                old.upDoor = r;
                actualRoom.downDoor = old;
            }
            else {
                actualRoom = actualRoom.upDoor;
                actualRoom.GenerateRoom(actualRoom.getMapName());
            }
            actualPos.x = actualRoom.info.downDoorPos.x;
            actualPos.y = actualRoom.info.downDoorPos.y;
            return true;
        }
        else if(posY < actualRoom.info.downBoundry){
            if(actualRoom.downDoor == null){
                Room r = newRandomRoom(2);
                if(r.info.upDoorPos == null) return false;
                DungeonMap.add(r);
                actualRoom = r;
                old.downDoor = r;
                actualRoom.upDoor = old;
            }
            else {
                actualRoom = actualRoom.downDoor;
                actualRoom.GenerateRoom(actualRoom.getMapName());
            }
            actualPos.x = actualRoom.info.upDoorPos.x;
            actualPos.y = actualRoom.info.upDoorPos.y;
            return true;
        }
        else return false;
    }
    
    private static int randInt(int min, int max) {
        //max is not included in range of the result [min,max-1]
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min)) + min;
        return randomNum;
    }
    
}
