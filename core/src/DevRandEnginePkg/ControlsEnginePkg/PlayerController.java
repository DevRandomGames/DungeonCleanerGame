/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg.ControlsEnginePkg;

import DungeonCleanerGame.CharacterPkg.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/**
 *
 * @author ArclorenSarth
 */
public class PlayerController extends ActionController{
    private int playerNum;
    private KeyMapper keyMap;
    
    
    public PlayerController(Player p, KeyMapper km){
        super.ctrlIdentity = p;
        keyMap = km;
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

    public void newKeyMap(KeyMapper m){
        keyMap = m;
    }
    
}
