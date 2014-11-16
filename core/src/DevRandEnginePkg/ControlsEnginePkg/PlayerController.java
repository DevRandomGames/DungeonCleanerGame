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
public abstract class PlayerController extends ActionController{
    protected int playerNum;
    protected KeyMapper keyMap;
    
    
    @Override
    public void computeAction(int p, int e, int f){
        //OVERRIDED
    }

    public void newKeyMap(KeyMapper m){
        keyMap = m;
    }
    
}
