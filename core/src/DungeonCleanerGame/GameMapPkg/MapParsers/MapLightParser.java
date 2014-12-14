/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungeonCleanerGame.GameMapPkg.MapParsers;

import DevRandEnginePkg.DevRandEngine;
import DevRandEnginePkg.UtilsEngine;
import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author albert
 */

public class MapLightParser extends MapParser {
    

    /* need to be added on every map extends */

  
    @Override
    public void parse(TiledMap tiledMap) {
        parsePointLight(tiledMap);
        parseMapLight(tiledMap);
    }

    private void parseMapLight(TiledMap tiledMap) {
        boolean mapLight = Boolean.parseBoolean((String) tiledMap.getProperties().get("mapLight"));
        if (mapLight) {
            float ambrientLight = Float.parseFloat((String) tiledMap.getProperties().get("ambrientLight"));
            DevRandEngine.getInstance().gamePhysics().getRayhandler().setAmbientLight(ambrientLight);
        } else {
            DevRandEngine.getInstance().gamePhysics().getRayhandler().setShadows(false);
        }
    }

    private void parsePointLight(TiledMap tiledMap) {

        RayHandler ray = DevRandEngine.getInstance().gamePhysics().getRayhandler();
        //Tmx code in alpha

        MapLayer layer = tiledMap.getLayers().get("Atrezzo");
        MapObjects objects;
        if (layer != null) {
            objects = layer.getObjects();
        } else {
            return;
        }

        for (MapObject obj : objects) {

            boolean light = Boolean.parseBoolean((String) obj.getProperties().get("light"));
            if (light == true) {
                String lightColor = (String) obj.getProperties().get("lightColor");
                float color[] = new float[4];
                List<String> asList = Arrays.asList(lightColor.split("\\s*,\\s*"));
                for (int i = 0; i < asList.size(); ++i) {
                    color[i] = Float.parseFloat(asList.get(i));
                }

                float lightDistance = Float.parseFloat((String) obj.getProperties().get("lightDistance"));
                Vector2 coord = ((RectangleMapObject) obj).getRectangle().getCenter(new Vector2());

                float offsetx = UtilsEngine.parseFloat((String) obj.getProperties().get("offsetx"));
                float offsety = UtilsEngine.parseFloat((String) obj.getProperties().get("offsety"));

                PointLight a = new PointLight(ray, 128, new Color(color[0], color[1], color[2], color[3]), lightDistance, coord.x+offsetx, coord.y + offsety);

            }
        }
    }

}
