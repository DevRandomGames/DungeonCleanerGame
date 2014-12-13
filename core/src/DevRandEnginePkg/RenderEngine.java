/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.*;

/**
 *
 * @author ArclorenSarth
 */
public class RenderEngine {
    private static RenderEngine INSTANCE = null;
    private DevRandEngine engine;
    
    private OrthographicCamera camera;
    private TiledMapRenderer mapRender;
    //private OrthogonalTiledMapRenderer mapRender;
    private Stage stage;
    
    private Box2DDebugRenderer debugRenderer;
    private SpriteBatch batch;
    private BitmapFont font;
    private Array<String> debugInfo;
    
    
    private RenderEngine(DevRandEngine e){
        engine = e;
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        debugInfo = new Array();
        debugRenderer = new Box2DDebugRenderer();
        
        stage = new Stage(new FillViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        //camera = new OrthographicCamera();
        camera = (OrthographicCamera) stage.getCamera();
                
        Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    
    private static void createInstance(DevRandEngine e){
        INSTANCE = new RenderEngine(e);
    }
    
    public static RenderEngine getInstance(DevRandEngine e){
        if(INSTANCE == null) createInstance(e);
        return INSTANCE;
    }
    
    public void clearScreen(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    
    public void renderBegin(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
    }
    
    public void renderEnd(){
        batch.end();
    }
    
    public void setCamera(int w, int h){
        camera.setToOrtho(false,w,h);
    }
    
    public void setMapToRender(TiledMap m, float unitScale){
        mapRender = new OrthogonalTiledMapRenderer(m,unitScale);
    }
    
    public void renderMap(){
        mapRender.setView(camera);
        mapRender.render();
    }
    
    public void renderStage(){
        stage.act();
        stage.draw();
    }
    
    public void renderWorldDebug(){
        debugRenderer.render(engine.gamePhysics().getWorld(), camera.combined);
    }
    
    public void addDebugString(String info, int numL){
        if(numL >= debugInfo.size)
            debugInfo.add(info);
        else debugInfo.set(numL, info); 
    }
    
    public void renderDebugInfo(){
        int X = 10, Y = 700;
        batch.begin();
        font.setScale(1f);
        font.setColor(Color.WHITE);
        for(int i=0; i<debugInfo.size; ++i){
            font.draw(batch,debugInfo.get(i),X,Y);
            Y -= 20;
        }
        batch.end();
    }
    
    
    public void renderUI(String m, int posX, int posY){
        font.setColor(Color.RED);
        font.setScale(5f);
        batch.begin();
        font.draw(batch,m,posX,posY);
        batch.end();
    }
    
    
    
    
    
    
    
    
    
    
    
    public TiledMapRenderer getMapRender(){
        return mapRender;
    }
    
    public OrthographicCamera getCamera(){
        return camera;
    }
    
    public Stage getStage(){
        return stage;
    }
    
     
    
}
