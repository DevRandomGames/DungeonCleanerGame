/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.ControlsPkg;

import DevRandEnginePkg.ControlsEnginePkg.KeyMapper;
import DevRandEnginePkg.ControlsEnginePkg.PlayerController;
import DevRandEnginePkg.DevRandEngine;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.*;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.*;
import DungeonCleanerGame.CharacterPkg.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;

/**
 *
 * @author ArclorenSarth
 */
public class DungeonPlayerController extends PlayerController{
    private DevRandEngine gameEngine;
    
    public DungeonPlayerController(Player p){
        gameEngine = DevRandEngine.getInstance();
        super.ctrlIdentity = p;
        super.keyMap = new KeyMapper();
        //PONEMOS LOS CONTROLES AL KEYMAPPER
        super.keyMap.addKey("left", Input.Keys.A);
        super.keyMap.addKey("right", Input.Keys.D);
        super.keyMap.addKey("up", Input.Keys.W);
        super.keyMap.addKey("down", Input.Keys.S);
        
    }
    

    @Override
    public void computeAction(int p, int e, int f){
        Player pl = (Player) super.ctrlIdentity;
        pl.st = walk;
        if(Gdx.input.isKeyPressed(keyMap.key("left"))){
            pl.addAction(moveBy(-2f,0f,0.01f));
            pl.d = left;
            gameEngine.gameRender().getCamera().translate(-2f,0);
            
        }
        else if(Gdx.input.isKeyPressed(keyMap.key("right"))){
            pl.addAction(moveBy(2f,0f,0.01f));
            pl.d = right;
            gameEngine.gameRender().getCamera().translate(2f,0);
        }
        else if(Gdx.input.isKeyPressed(keyMap.key("up"))){
            pl.addAction(moveBy(0f,2f,0.01f));
            pl.d = up;
            gameEngine.gameRender().getCamera().translate(0,2f);
        }
        else if(Gdx.input.isKeyPressed(keyMap.key("down"))){
            pl.addAction(moveBy(0f,-2f,0.01f));
            pl.d = down;
            gameEngine.gameRender().getCamera().translate(0,-2f);
        }
        else{
            pl.st = standby;
        }
    }
    
}
