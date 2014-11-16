package DungeonCleanerGame;

import DevRandEnginePkg.ControlsEnginePkg.*;
import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.CharacterPkg.Player;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
import DungeonCleanerGame.GameMapPkg.Room;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class DungeonCleaner extends ApplicationAdapter {
	private DevRandEngine gameEngine;
        
        private Player p;
        private PlayerController plyCtrl;
        private KeyMapper km;
        
        TiledMap tiledMap;
        OrthographicCamera camera;
        TiledMapRenderer tiledMapRenderer;
        
        
        @Override
	public void create () {
            gameEngine = DevRandEngine.getInstance();
            gameEngine.gameLogic().getMap().insertRoom();
            createPlayer();        
            gameEngine.gameRender().stage().addActor(p);
            
            float w = Gdx.graphics.getWidth();
            float h = Gdx.graphics.getHeight();

            camera = new OrthographicCamera();
            camera.setToOrtho(false,w,h);
            camera.update();
            
            tiledMap = new TmxMapLoader().load("Rooms/BigRoom1.tmx");
            tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
            
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
            
            camera.update();
            tiledMapRenderer.setView(camera);
            tiledMapRenderer.render();
            
            
            gameEngine.gameRender().stage().act();
            gameEngine.gameRender().stage().draw();
            
            
        }
        
        private void inputControl(){
            gameEngine.gameControls().computeControls();
        }
        
        private void createPlayer(){
            //CREAMOS AL JUGADOR
            p = new Player(new Texture("knight.jpg"));
            km = new KeyMapper();
            
            //PONEMOS LOS CONTROLES AL KEYMAPPER
            km.addKey("left", Input.Keys.A);
            km.addKey("right", Input.Keys.D);
            km.addKey("up", Input.Keys.W);
            km.addKey("down", Input.Keys.S);
            
            //CREAMOS EL PLAYERCONTROLLER Y ANADIMOS AL CONTROLS ENGINE
            plyCtrl = new DungeonPlayerController(p,km);
            gameEngine.gameControls().addControl(plyCtrl);
            //POSICIONAMOS AL JUGADOR
            
            p.setPosition(20, 20);
            p.setScale(0.1f);
        }
}
