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
    Random RG;
    String[] mapNames = {"BigRoom1.tmx","Exterior1.tmx"};
    
    ArrayList<Room> DungeonMap;
    int numberofrooms;
    
    public GameMap(){
        DungeonMap = new ArrayList();
        numberofrooms = 5;
        actualPos = new Vector2(0f,0f);
        RG = new Random();
    }
    
    public void newRoom(String roomName){
        Room r = new Room(roomName);
        DungeonMap.add(r);
        actualRoom = r;
    }
    
    public void newRandomRoom(){
        Room r = new Room(mapNames[RG.nextInt(1)]);
        DungeonMap.add(r);
        actualRoom = r;
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
                newRandomRoom();
                old.leftDoor = actualRoom;
            }
            else actualRoom = actualRoom.leftDoor;
            if(actualRoom.info.rightDoorPos != null){
                actualPos.x = actualRoom.info.rightDoorPos.x;
                actualPos.y = actualRoom.info.rightDoorPos.y;
                actualRoom.rightDoor = old;
            }
            else if(actualRoom.info.leftDoorPos != null){
                actualPos.x = actualRoom.info.leftDoorPos.x;
                actualPos.y = actualRoom.info.leftDoorPos.y;
                actualRoom.leftDoor = old;
            }
            else if(actualRoom.info.upDoorPos != null){
                actualPos.x = actualRoom.info.upDoorPos.x;
                actualPos.y = actualRoom.info.upDoorPos.y;
                actualRoom.upDoor = old;
            }
            else if(actualRoom.info.downDoorPos != null){
                actualPos.x = actualRoom.info.downDoorPos.x;
                actualPos.y = actualRoom.info.downDoorPos.y;
                actualRoom.downDoor = old;
            }
            return true;
        }
        else if(posX > actualRoom.info.rightBoundry){
            if(actualRoom.rightDoor == null){
                newRandomRoom();
                old.rightDoor = actualRoom;
            }
            else actualRoom = actualRoom.rightDoor;
            if(actualRoom.info.leftDoorPos != null){
                actualPos.x = actualRoom.info.leftDoorPos.x;
                actualPos.y = actualRoom.info.leftDoorPos.y;
                actualRoom.leftDoor = old;
            }
            else if(actualRoom.info.rightDoorPos != null){
                actualPos.x = actualRoom.info.rightDoorPos.x;
                actualPos.y = actualRoom.info.rightDoorPos.y;
                actualRoom.rightDoor = old;
            }
            else if(actualRoom.info.upDoorPos != null){
                actualPos.x = actualRoom.info.upDoorPos.x;
                actualPos.y = actualRoom.info.upDoorPos.y;
                actualRoom.upDoor = old;
            }
            else if(actualRoom.info.downDoorPos != null){
                actualPos.x = actualRoom.info.downDoorPos.x;
                actualPos.y = actualRoom.info.downDoorPos.y;
                actualRoom.downDoor = old;
            }
            return true;
        }
        else if(posY > actualRoom.info.upBoundry){
            if(actualRoom.upDoor == null){
                newRandomRoom();
                old.upDoor = actualRoom;
            }
            else actualRoom = actualRoom.upDoor;
            
            if(actualRoom.info.downDoorPos != null){
                actualPos.x = actualRoom.info.downDoorPos.x;
                actualPos.y = actualRoom.info.downDoorPos.y;
                actualRoom.downDoor = old;
            }
            else if(actualRoom.info.rightDoorPos != null){
                actualPos.x = actualRoom.info.rightDoorPos.x;
                actualPos.y = actualRoom.info.rightDoorPos.y;
                actualRoom.rightDoor = old;
            }
            else if(actualRoom.info.leftDoorPos != null){
                actualPos.x = actualRoom.info.leftDoorPos.x;
                actualPos.y = actualRoom.info.leftDoorPos.y;
                actualRoom.leftDoor = old;
            }
            else if(actualRoom.info.upDoorPos != null){
                actualPos.x = actualRoom.info.upDoorPos.x;
                actualPos.y = actualRoom.info.upDoorPos.y;
                actualRoom.upDoor = old;
            }
            
            return true;
        }
        else if(posY < actualRoom.info.downBoundry){
            if(actualRoom.downDoor == null){
                newRandomRoom();
                old.downDoor = actualRoom;
            }
            else actualRoom = actualRoom.downDoor;
            
            if(actualRoom.info.upDoorPos != null){
                actualPos.x = actualRoom.info.upDoorPos.x;
                actualPos.y = actualRoom.info.upDoorPos.y;
                actualRoom.upDoor = old;
            }
            else if(actualRoom.info.rightDoorPos != null){
                actualPos.x = actualRoom.info.rightDoorPos.x;
                actualPos.y = actualRoom.info.rightDoorPos.y;
                actualRoom.rightDoor = old;
            }
            else if(actualRoom.info.leftDoorPos != null){
                actualPos.x = actualRoom.info.leftDoorPos.x;
                actualPos.y = actualRoom.info.leftDoorPos.y;
                actualRoom.leftDoor = old;
            }
            else if(actualRoom.info.downDoorPos != null){
                actualPos.x = actualRoom.info.downDoorPos.x;
                actualPos.y = actualRoom.info.downDoorPos.y;
                actualRoom.downDoor = old;
            }
            return true;
        }
        else return false;
    }
    
    
    
}
