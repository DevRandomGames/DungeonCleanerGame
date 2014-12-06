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
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.ArrayList;


public class DungeonCleaner extends ApplicationAdapter {
	private DevRandEngine gameEngine;
        private DungeonCollissions collissions;
        
        private Player p;
        private GameMap DungeonMap;
        Body body;        
        
        int widthScreen;
        int heightScreen;
        
        float unitScale; //unidad de escalado pixeles a metros del wordl (1m/Xpxl) 
        
        Boolean b = true;
        
        
        @Override
	public void create () {
            widthScreen = Gdx.graphics.getWidth();
            heightScreen = Gdx.graphics.getHeight();
            unitScale = 1/100f;
            gameEngine = DevRandEngine.getInstance();
            gameEngine.gameRender().setCamera((int)(widthScreen*unitScale),(int)(heightScreen*unitScale));
            
            createGameMap();
            createWorld();
            createPlayer(4.0f,4.0f);
           
        }

	@Override
	public void render () {
            if(DungeonMap.checkDoors(p.getX(),p.getY())){
                changeMap();
            }
            
            inputControl();
                                   
            gameEngine.gameRender().clearScreen();
            gameEngine.gameRender().getCamera().position.set(p.getX(),p.getY(),0);
            gameEngine.gameRender().getCamera().update();
            gameEngine.gamePhysics().renderPhysics();
            gameEngine.gameRender().renderMap();
            gameEngine.gameRender().renderStage();
            gameEngine.renderWorldDebug();
            
            
            renderDebugInfo();
	}
        
        private void changeMap(){
            
            Vector2 newPosPlyr = DungeonMap.getActualPos();
            gameEngine.gameRender().getStage().clear();
                       
            gameEngine.gameRender().setMapToRender
            (DungeonMap.getActualRoom().getRoomMap(), unitScale);
            gameEngine.gamePhysics().createWorld(DungeonMap.getActualRoom().getRoomMap(), unitScale);
            gameEngine.gamePhysics().getWorld().setContactListener(collissions);
                     
            createPlayer(newPosPlyr.x,newPosPlyr.y);
            
        }
        
        private void inputControl(){
            gameEngine.gameControls().computeControls();
        }
        
        private void createPlayer(float posX, float posY){
            //CREAMOS AL JUGADOR
            p = new Player(unitScale);
            p.LoadPlayerTexture();
            //ANADIMOS PlayerControls AL CONTROLS ENGINE
            gameEngine.gameControls().addControl(p.getPlayerControls());
            //POSICIONAMOS AL JUGADOR Y LA CAMARA ENCIMA SUYO
            p.createBody(posX,posY);
            gameEngine.gameRender().getCamera().position.set(p.getX(),p.getY(),0);
            //ANADIMOS PLAYER AL STAGE
            gameEngine.gameRender().getStage().addActor(p);
            
        }
        
             
        private void createGameMap(){
            DungeonMap = new GameMap();
            DungeonMap.newRoom("BigRoom1.tmx");
            
            gameEngine.gameRender().setMapToRender
            (DungeonMap.getActualRoom().getRoomMap(), unitScale);
        }
        
        private void createWorld(){
            gameEngine.gamePhysics().createWorld(DungeonMap.getActualRoom().getRoomMap(), unitScale);
            collissions = new DungeonCollissions();
            gameEngine.gamePhysics().getWorld().setContactListener(collissions);
        }
        
        
        private void renderDebugInfo(){
            //COORDENADAS DE SCREEN, HE EMEPZADO IZQUIERDA ARRIBA POR ESO Y ES ALTA
            gameEngine.gameRender().addDebugString("PlyrX=" + p.getX() +" PlyrY=" +p.getY(),0);
            gameEngine.gameRender().renderDebugInfo();
        }
        
        
        
        
        
}
