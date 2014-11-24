/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DevRandEnginePkg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.*;

/**
 *
 * @author ArclorenSarth
 */
public class RenderEngine {
    private static RenderEngine INSTANCE = null;
    
    private OrthographicCamera camera;
    private TiledMapRenderer mapRender;
    //private OrthogonalTiledMapRenderer mapRender;
    private Stage stage;
    
    private SpriteBatch batch;
    
    
    private RenderEngine(){
        batch = new SpriteBatch();
        stage = new Stage(new FillViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        //camera = new OrthographicCamera();
        camera = (OrthographicCamera) stage.getCamera();
                
        Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    
    private static void createInstance(){
        INSTANCE = new RenderEngine();
    }
    
    public static RenderEngine getInstance(){
        if(INSTANCE == null) createInstance();
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
    
    public void setMapToRender(TiledMap m){
        mapRender = new OrthogonalTiledMapRenderer(m);
    }
    
    public void renderMap(){
        mapRender.setView(camera);
        mapRender.render();
    }
    
    public void renderStage(){
        stage.act();
        stage.draw();
    }
    
    
    
    
    
    
    
    
    
    public TiledMapRenderer getMapRender(){
        return mapRender;
    }
    
    public OrthographicCamera getCamera(){
        return camera;
    }
    
    public Stage stage(){
        return stage;
    }
    
   /*public void renderZone(StaticTiledMapTile[][] zone,int width,int height){
       
        TiledMap map = new TiledMap();
        MapLayers layers = map.getLayers();

        TiledMapTileLayer layer1 = new TiledMapTileLayer(width, height, 1, 1);
        
        for(int i=0;i<zone.length;++i){
            for(int j=0;j<zone[0].length;++j){
                Cell cell = new Cell();
                cell.setTile(zone[i][j]);
                layer1.setCell(i, j, cell);
                
            }
        }
        layers.add(layer1);
        mapRender = new OrthogonalTiledMapRenderer(map);
        
        
        
        mapRender.render();
        
   }
   */
   
    
    
}
