package DungeonCleanerGame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import DungeonCleanerGame.DungeonCleaner;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Dungeon Cleaner";
                //config.width = 576;
                //config.height = 480;
		new LwjglApplication(new DungeonCleaner(), config);
	}
}
