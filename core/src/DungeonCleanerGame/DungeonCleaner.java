package DungeonCleanerGame;

import DevRandEnginePkg.Box2DMapObjectParser;
import DevRandEnginePkg.ControlsEnginePkg.*;
import DevRandEnginePkg.DevRandEngine;
import DungeonCleanerGame.CharacterPkg.Player;
import DungeonCleanerGame.ControlsPkg.DungeonPlayerController;
import DungeonCleanerGame.GameMapPkg.GameMap;
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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class DungeonCleaner extends ApplicationAdapter {
	private DevRandEngine gameEngine;
        
        private Player p;
        private GameMap DungeonMap;
                
        
        private OrthographicCamera camera;
        private TiledMapRenderer tiledMapRenderer;
        private World world;
        private Box2DDebugRenderer debugRenderer;
        
        float widthScreen;
        float heightScreen;
        int mapWidth;
        int mapHeight;
        
        
        @Override
	public void create () {
            
            gameEngine = DevRandEngine.getInstance();
            createPlayer();        
           
            
            world = new World(new Vector2(0,0),true);
            debugRenderer = new Box2DDebugRenderer();
            Box2DMapObjectParser parser = new Box2DMapObjectParser();
            
            DungeonMap = new GameMap();
            DungeonMap.newRoom("Exterior1.tmx");
            
            tiledMapRenderer = new OrthogonalTiledMapRenderer
            (DungeonMap.getActualRoom().getRoomMap());
            
            widthScreen = Gdx.graphics.getWidth();
            heightScreen = Gdx.graphics.getHeight();
            mapWidth = DungeonMap.getActualRoom().getWidth();
            mapHeight = DungeonMap.getActualRoom().getHeight();         
            
            parser.load(world, DungeonMap.getActualRoom().getRoomMap());
            
            camera = new OrthographicCamera();
            camera.setToOrtho(false,mapWidth*100,mapHeight*100);
            camera.update();
           
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
            debugRenderer.render(world, camera.combined);
            
            
        }
        
        private void inputControl(){
            gameEngine.gameControls().computeControls();
        }
        
        private void createPlayer(){
            //CREAMOS AL JUGADOR
            p = new Player();
            p.LoadPlayerTexture();
            //ANADIMOS PlayerControls AL CONTROLS ENGINE
            gameEngine.gameControls().addControl(p.getPlayerControls());
            //POSICIONAMOS AL JUGADOR
            p.setPosition(20, 20);
            //p.setScale(0.1f);
            //ANADIMOS PLAYER AL STAGE
            gameEngine.gameRender().stage().addActor(p);
        }
}
