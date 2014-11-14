/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg.ControlsEnginePkg;

import java.util.TreeMap;

/**
 *
 * @author ArclorenSarth
 */
public class KeyMapper {
    TreeMap<String,Integer> map;
    
    public KeyMapper(){
        map = new TreeMap();
    }
    
    public void addKey(String nameAction, int key){
        map.put(nameAction,key);
    }
    
    public int key(String k){
        return map.get(k);
    }
}
