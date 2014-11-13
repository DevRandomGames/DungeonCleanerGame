/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import DungeonCleanerGame.CharacterPkg.GameCharacter;
import java.util.ArrayList;

/**
 *
 * @author ArclorenSarth
 */
public class PhysicsEngine {
    private static PhysicsEngine INSTANCE = null;
    
    
    private PhysicsEngine(){
        
    }
    
    private static void createInstance(){
        INSTANCE = new PhysicsEngine();
    }
    
    public static PhysicsEngine getInstance(){
        if(INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    
    public void createWorld(Object map){
        //se habria de generar un world a partir de un mapa que le pasamos
        //al motor fisico, que se encarga de los bodys etc.
    }
    
    
    public void createCharacters(ArrayList<GameCharacter> charList){
        //generar bodys a partir de una lista de Personages.
    }
    
    
}
