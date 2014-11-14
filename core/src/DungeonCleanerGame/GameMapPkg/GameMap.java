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
    ArrayList DungeonMap;
    int numberofrooms;
    
    public GameMap(){
        DungeonMap = new ArrayList();
        numberofrooms = 5;
    }
    
    public void insertRoom (){
        Room r = new Room();
        DungeonMap.add(r);
    }
    
    public Room getRoom(int i){
        return (Room) DungeonMap.get(i);
    }
    
    
    
}
