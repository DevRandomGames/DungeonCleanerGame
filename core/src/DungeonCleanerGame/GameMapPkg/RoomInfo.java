/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.GameMapPkg;

import com.badlogic.gdx.math.Vector2;


/**
 *
 * @author ArclorenSarth
 */
public class RoomInfo {
    public Vector2 upDoorPos;
    public Vector2 downDoorPos;
    public Vector2 leftDoorPos;
    public Vector2 rightDoorPos;
    
    public float upBoundry;
    public float downBoundry;
    public float leftBoundry;
    public float rightBoundry;
    
    
    public RoomInfo(String mapName){
        if(mapName.equals("Exterior1.tmx")){
            upDoorPos = null;
            downDoorPos = null;
            leftDoorPos = new Vector2(1.25f,4.5f);
            rightDoorPos = null;

            upBoundry = 15f;
            downBoundry = 1f;
            leftBoundry = 1f;
            rightBoundry = 19f;
        }
        else if(mapName.equals("BigRoom1.tmx")){
            upDoorPos = null;
            downDoorPos = new Vector2(8.5f,2.25f);
            leftDoorPos = new Vector2(2.25f,11.5f);
            rightDoorPos = new Vector2(21.85f,6.5f);

            upBoundry = 14f;
            downBoundry = 2f;
            leftBoundry = 2f;
            rightBoundry = 22f;
        }
        else if(mapName.equals("ForgeRoom.tmx")){
            upDoorPos = new Vector2(5.5f,10.85f);
            downDoorPos = new Vector2(6.5f,1.25f);
            leftDoorPos = new Vector2(1.25f,7.5f);
            rightDoorPos = new Vector2(10.85f,3.5f);

            upBoundry = 11f;
            downBoundry = 1f;
            leftBoundry = 1f;
            rightBoundry = 11f;
        }
    }
}
