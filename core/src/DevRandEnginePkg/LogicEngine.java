/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import DungeonCleanerGame.GameMapPkg.GameMap;

/**
 *
 * @author ArclorenSarth
 */
public class LogicEngine {
    private static LogicEngine INSTANCE = null;
    
    
    public LogicEngine(){
        
    }
    
    private static void createInstance(){
        INSTANCE = new LogicEngine();
    }
    
    public static LogicEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
   
    
}
