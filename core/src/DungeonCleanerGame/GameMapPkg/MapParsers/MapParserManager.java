/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.GameMapPkg.MapParsers;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import java.util.List;

/**
 *
 * @author albert
 */
public class MapParserManager {

    public final static Array<MapParser> mapParsers = new Array();

    public static void parse(TiledMap tiledMap){
        
        for(MapParser parser : mapParsers){
            parser.parse(tiledMap);
        }
    }
    
    public static void inicialize(){
        mapParsers.add(new MapLightParser());
    }

    //TODO (Tinc la idea i molt guapa)

}
