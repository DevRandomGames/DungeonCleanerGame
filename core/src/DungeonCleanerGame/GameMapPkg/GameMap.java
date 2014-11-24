/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.GameMapPkg;

import java.util.ArrayList;

/**
 *
 * @author ArclorenSarth
 */
public class GameMap {
    Room actualRoom;
    
    ArrayList<Room> DungeonMap;
    int numberofrooms;
    
    public GameMap(){
        DungeonMap = new ArrayList();
        numberofrooms = 5;
    }
    
    public void newRoom(String roomName){
        Room r = new Room(roomName);
        DungeonMap.add(r);
        actualRoom = r;
    }
    
    public void newRandomRoom(){
        Room r = new Room("RandomMap");
        DungeonMap.add(r);
        actualRoom = r;
    }
            
    public Room getRoom(int i){
        return DungeonMap.get(i);
    }
    
    public Room getActualRoom(){
        return actualRoom;
    }
    
    
    
}
