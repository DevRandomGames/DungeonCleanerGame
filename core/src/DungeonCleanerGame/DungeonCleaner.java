package DungeonCleanerGame;

import DevRandEnginePkg.DevRandEngine;
import com.badlogic.gdx.ApplicationAdapter;


public class DungeonCleaner extends ApplicationAdapter {
	DevRandEngine gameEngine;
	
	@Override
	public void create () {
            gameEngine = DevRandEngine.getInstance();
	}

	@Override
	public void render () {
            renderGame();
	}
        
        
        private void renderGame(){
            gameEngine.gameRender().renderSprite("knight.jpg");
        }
}
