/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.ControlsPkg;

import DevRandEnginePkg.ControlsEnginePkg.KeyMapper;
import DevRandEnginePkg.ControlsEnginePkg.PlayerController;
import DungeonCleanerGame.CharacterPkg.Player;
import com.badlogic.gdx.Gdx;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;

/**
 *
 * @author ArclorenSarth
 */
public class DungeonPlayerController extends PlayerController{
    
    public DungeonPlayerController(Player p, KeyMapper km){
        super.ctrlIdentity = p;
        super.keyMap = km;
    }
    

    @Override
    public void computeAction(int p, int e, int f){
        Player pl = (Player) super.ctrlIdentity;
        if(Gdx.input.isKeyPressed(keyMap.key("left"))){
            pl.addAction(moveBy(-1f,0f,0.01f));
        }
        if(Gdx.input.isKeyPressed(keyMap.key("right"))){
            pl.addAction(moveBy(1f,0f,0.01f));
        }
        if(Gdx.input.isKeyPressed(keyMap.key("up"))){
            pl.addAction(moveBy(0f,1f,0.01f));
        }
        if(Gdx.input.isKeyPressed(keyMap.key("down"))){
            pl.addAction(moveBy(0f,-1f,0.01f));
        }
    }
    
}
