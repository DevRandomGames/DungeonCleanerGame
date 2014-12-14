/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import java.util.TreeMap;

/**
 *
 * @author ArclorenSarth
 */
public class ConstantEngine {
    private DevRandEngine engine;
    private static ConstantEngine INSTANCE = null;
    
    //Si esto sale en la presentación, que sepais que artem esta tirando bytes
    //a la basura usando objectos para tipos primitivos
    TreeMap<String,Integer> intConstantMap;
    TreeMap<String,Float> floatConstantMap;
    TreeMap<String,Short> shortConstantMap;
    
    
    private ConstantEngine(DevRandEngine e){
        engine = e;
        intConstantMap = new TreeMap();
        floatConstantMap = new TreeMap();
        shortConstantMap = new TreeMap();
    }
    
    private static void createInstance(DevRandEngine e){
        INSTANCE = new ConstantEngine(e);
    }
    
    public static ConstantEngine getInstance(DevRandEngine e){
        if(INSTANCE == null) createInstance(e);
        return INSTANCE;
    }
    
    //PARA UTILIZACION EXTERNAMENTE DEL ENGINE
    //USAR POST CREACION
    public static ConstantEngine getInstance(){
        return INSTANCE;
    }
    
    
    
    public void addConstant(String con, Object value){
        if(value instanceof Integer) intConstantMap.put(con,(Integer)value);
        else if(value instanceof Float) floatConstantMap.put(con,(Float)value);
        else if(value instanceof Short) shortConstantMap.put(con,(Short)value);
    }
    
    public int getIntConstant(String con){
        return intConstantMap.get(con);
    }
    
    public float getFloatConstant(String con){
        return floatConstantMap.get(con);
    }
    
    public short getShortConstant(String con){
        return shortConstantMap.get(con);
    }
    
}
