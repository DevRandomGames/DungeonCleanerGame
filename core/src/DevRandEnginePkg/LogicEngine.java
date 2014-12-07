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
    private DevRandEngine engine;
    private static LogicEngine INSTANCE = null;
    
    
    public LogicEngine(DevRandEngine e){
        engine = e;
    }
    
    private static void createInstance(DevRandEngine e){
        INSTANCE = new LogicEngine(e);
    }
    
    public static LogicEngine getInstance(DevRandEngine e){
        if(INSTANCE == null) createInstance(e);
        return INSTANCE;
    }
    
   
    
}
