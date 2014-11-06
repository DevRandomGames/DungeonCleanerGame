package DungeonCleanerGame;

import com.badlogic.gdx.ApplicationAdapter;
import DevRandEnginePckg.*;


public class DungeonCleaner extends ApplicationAdapter {
	DevRandEngine gameEngine;
	
	@Override
	public void create () {
            gameEngine = DevRandEngine.getInstance();
	}

	@Override
	public void render () {
            gameEngine.renderGame();
	}
}
