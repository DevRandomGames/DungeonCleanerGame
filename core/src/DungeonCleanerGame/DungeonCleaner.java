package DungeonCleanerGame;

import DevRandEnginePkg.ControlsEnginePkg.*;
import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.CharacterPkg.Player;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
import DungeonCleanerGame.GameMapPkg.Room;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class DungeonCleaner extends ApplicationAdapter {
	DevRandEngine gameEngine;
        private int posX;
        private int posY;
        private float scale;
        private int mvSpeed;
        
        PlayerController PC;
        
        
        @Override
	public void create () {
            gameEngine = DevRandEngine.getInstance();
            posX=0; posY=0; scale=0.1f; mvSpeed=5;
            gameEngine.gameLogic().getMap().insertRoom();
            
                           
            Player p = new Player(new Texture("knight.jpg"));
            KeyMapper km = new KeyMapper();
            km.addKey("left", Input.Keys.A);
            km.addKey("right", Input.Keys.D);
            km.addKey("up", Input.Keys.W);
            km.addKey("down", Input.Keys.S);
            PC = new DungeonPlayerController(p,km);
            
            p.setPosition(20, 20);
            p.setScale(0.1f);
            gameEngine.gameRender().stage().addActor(p);
            
	}

	@Override
	public void render () {
            renderGame();
	}
        
        
        private void renderGame(){
            inputControl();
            //Room r = gameEngine.gameLogic().getMap().getRoom(0);
            //gameEngine.gameRender().renderZone(r.getRoomMap(), r.getXsize(), r.getYsize());
            
            gameEngine.gameRender().clearScreen();
            gameEngine.gameRender().stage().draw();
            gameEngine.gameRender().stage().act();
            
        }
        
        private void inputControl(){
              
            PC.computeAction(0,0,0);
        }
}
