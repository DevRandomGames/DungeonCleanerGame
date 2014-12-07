/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DungeonCleanerGame.ControlsPkg;

import DevRandEnginePkg.AIEngine;
import DevRandEnginePkg.ControlsEnginePkg.IAController;
import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.CharacterPkg.Enemy;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.down;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.left;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.right;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.dir.up;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.standby;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.strike;
import static DungeonCleanerGame.CharacterPkg.GameCharacter.state.walk;
import DungeonCleanerGame.CharacterPkg.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import java.util.Random;

/**
 *
 * @author ArclorenSarth
 */
public class DungeonIAController extends IAController{
    
    private DevRandEngine gameEngine;
    private Random RG;
    
    public DungeonIAController(Enemy e){
        super.ctrlIdentity = e;
        gameEngine = DevRandEngine.getInstance();
        RG = new Random();
    }
    
    public void computeAction(int p, int e, int f){
        Enemy en = (Enemy) super.ctrlIdentity;
        en.st = walk;
        //Camera cam = gameEngine.gameRender().getCamera();
        float speed = 200;
        float forceMove = 0.5f;
        
        gameEngine.gameIA().stateSelection(en);
        gameEngine.gameIA().idiotWalk(en);
        gameEngine.gameIA().RandomDir(en, RG.nextInt(4),Gdx.graphics.getDeltaTime());
        
    }
    
}
